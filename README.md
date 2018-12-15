# cat-movie
慕课网仿猫眼项目源码
## 1 微服务介绍
传统应用带来的问题：
- 单一业务开发和迭代困难
- 扩容困难
- 部署和回滚困难

微服务概述：
- 微服务是一种将业务系统进一步拆分的架构风格
- 微服务强调每个业务都独立运行
- 每个单一服务都应该使用更轻量的机制保持通信
- 服务不强调环境，可以不同语言或数据源

## 2 演示环境构建
#### 安装zookeeper
zookeeper 3.4.10
解压，修改conf/zoo_sample.cfg为zoo.cfg
bin/zkServer.sh 启动

#### 配置zookeeper
添加zkclient依赖，配置：
spring:
  dubbo:
    registry: zookeeper://118.126.111.144:2181

## 3 业务基础环境构建
API网关的常见作用
- 身份验证和安全
- 审查和监测
- 动态路由
- 压力测试
- 负载均衡
- 静态相应处理 

localhost:80/auth/userName=admin&password=admin 获取jwt
guns-api项目，存放接口和公共类

## 4 用户模块开发
#### 启动检查
dubbo可以不先启动服务提供者，避免强依赖
```$xslt
    @Reference(interfaceClass = UserAPI.class, check = false)
    private UserAPI userAPI;
```
#### 负载均衡
负载均衡策略配置，一般配置在service上
```$xslt
loadbalance = "roundrobin"
```
#### 多协议支持
protocol：服务之间的通信协议，一般用dubbo协议

## 5 影片模块开发
#### 服务聚合
#### mybatis-plus自定义SQL实现
#### dubbo异步调用
影片详情查询接口存在多个服务调用
影片详情查询改造异步调用:Future特性
需要配置:@EnableAsync 和 async = true
[异步调用 见文档](https://dubbo.gitbooks.io/dubbo-user-book/content/demos/async-call.html)

## 6 影院模块开发
#### 影院模块业务开发
mybatis一对多查询：根据影院编号,获取所有电影的信息和对应的放映场次信息
#### 修改全局异常返回
Tip
#### Dubbo特性：并发、连接控制，结果缓存
- 结果缓存
```aidl
@Reference(interfaceClass = CinemaServiceApi.class, cache = "lru", check = false)
```
dubbo缓存是本地缓存，不是分布式缓存，需要了解dubbo结果缓存与Redis等的区别，参考官网

[结果缓存 见文档](https://dubbo.gitbooks.io/dubbo-user-book/content/demos/result-cache.html)

- 并发、连接控制
```aidl
@Service(interfaceClass = CinemaServiceApi.class, executes = 10)
```
[并发控制 见文档](https://dubbo.gitbooks.io/dubbo-user-book/content/demos/concurrency-control.html)

[连接控制 见文档](https://dubbo.gitbooks.io/dubbo-user-book/content/demos/config-connections.html)

## 7 订单模块开发
#### 订单模块业务开发
- window ftp服务器
1. 在计算机管理中创建用户
我的电脑 -> 管理 -> 计算机管理 -> 本地用户和组 -> 用户 -> 新用户
2. 开启FTP服务器
控制面板 -> 程序和功能 -> 启用或关闭windows功能  -> Internet Infomation Services  -> 勾选FTP服务器和Web管理工具
3. 添加FTP站点
控制面板 -> 管理工具 -> IIS管理器 -> 网站 -> 添加FTP站点 -> 站点名称随便写，存放位置新建ftp文件夹 -> 端口2100，不需要SSL
 -> 身份验证匿名，所有用户可以读取写入
4. 测试
ftp://192.168.10.109
- centos ftp服务器
[CentOS搭建ftp服务器](https://www.cnblogs.com/ismallboy/p/6785270.html)
[425 Failed to establish connection 问题解决](https://blog.csdn.net/kofterry/article/details/82875034)

- 数据库时间处理
1. MoocOrderTMapper.xml#getOrderInfoById 对数据库时间的处理
2. mysql函数：DATE_FORMAT、UNIX_TIMESTAMP

#### 订单模块的横向和纵向拆表解决
问题：每年的订单量太大
横向拆分：同一个订单表拆成两个订单表
纵向拆分：订单表按年进行拆分
TODO mycat分库分表
- dubbo特性：服务分组、聚合和版本控制
[服务分组 见文档](https://dubbo.gitbooks.io/dubbo-user-book/content/demos/service-group.html)
-> 可以使用分组实现蓝绿上线
[服务聚合 见文档](https://dubbo.gitbooks.io/dubbo-user-book/content/demos/group-merger.html)
merge只能合并List集合，无法合并两个String
```aidl
暂时没有分组聚合的注解，只能手工合并
OrderServiceImpl2017 + OrderServiceImpl2018

@Service(interfaceClass = OrderServiceAPI.class, group = "default")
@Service(interfaceClass = OrderServiceAPI.class, group = "order2017")
@Service(interfaceClass = OrderServiceAPI.class, group = "order2018")

@Reference(interfaceClass = OrderServiceAPI.class, check = false, timeout = 8000, group = "order2018")
@Reference(interfaceClass = OrderServiceAPI.class, check = false, timeout = 8000, group = "order2017")
```

#### 服务限流如何处理
问题：双十一订单太多
限流措施是系统高可用的一种手段
1. 使用并发与连接控制进行限流，不常用
2. 使用漏桶算法和令牌桶算法进行限流
漏桶算法流速固定，令牌桶对于业务峰值有一定承载能力
```aidl
TokenBucket
下单增加令牌桶逻辑
```

#### 服务的熔断和降级
问题：业务系统雪崩
hystrix具体使用见：Hystrix文档

#### 如何保证多版本的蓝绿上线
- 如何保证多版本的蓝绿上线（部分上线，灰度发布）
[多版本 见文档](https://dubbo.gitbooks.io/dubbo-user-book/content/demos/multi-versions.html)
```aidl
group=lan version=1 version=2
group=lv version=1
gateway -> lan lv version=1
gateway -> lan version=1
gateway -> lan version=2
```

## 8 支付模块开发
#### 支付模块业务开发
支付宝当面付流程：获取二维码 -> 等待支付宝回调 -> 修改订单状态 -> 定期对账
演示为了避免支付宝回调过程，在客户端查询支付状态的时候，Consumer修改订单状态
蚂蚁金服文档中心，下载当面付Demo
使用沙箱环境测试

#### dubbo特性学习：隐式参数、参数验证等
- 本地存根
类似于dubbo的静态代理
dubbo会在客户端生成一个代理，处理部分业务
stub必须有可传入proxy的构造函数
[本地存根 见文档](https://dubbo.gitbooks.io/dubbo-user-book/content/demos/local-stub.html)
- 本地伪装 常用
本地伪装是本地存根的一个子集
通常会使用本地伪装处理服务降级
hystrix对某个方法做降级，本地伪装可以对某个接口做降级
注意：本地伪装只能捕获Rpc异常
[本地伪装 见文档](https://dubbo.gitbooks.io/dubbo-user-book/content/demos/local-mock.html)
```aidl
@Service(interfaceClass = AliPayServiceAPI.class, mock = "com.stylefeng.guns.api.alipay.AlipayServiceMock")
```
- 隐式参数 
dubbo提供了参数的隐式传递
dubbo的隐式参数仅单次调用可用
注意隐式参数的保留字段
分布式事务中经常用到
[隐式参数 见文档](https://dubbo.gitbooks.io/dubbo-user-book/content/demos/attachment.html)

## 9 分布式事务
#### 事务简介
事务是用来保证一组**数据操作**的完整性和一致性
事务必须满足ACID的四大特性：原子性（Atomicity）、一致性（Consistency）、隔离性（Isolation）、持久性（Durability）**必背**
事务具有四种隔离级别
事务具有七种传播行为

#### 分布式事务的前世今生
分布式事务就是将多个节点的事务看成一个整体处理
分布式事务由事务参与者、资源服务器、事务管理器等组成
常见的分布式事务的例子：支付、下订单等

#### 分布式事务解决方案
###### 实现思路
两段式事务（2PC）和三段式事务（3PC）（很少用，但是原理需要知道）
基于XA的分布式事务：由两段式事务进化而来（了解）
**基于消息（消息队列或Redis）的最终一致性方案（应用比较广泛）** 案例：A系统转账前通过消息告诉B系统改状态成功再转钱否则回滚，一起成功失败
**TCC（Try Confirm Cancel）编程式补偿性事务（应用最广）**
###### 两种事务比较
基于消息事务是强一致性事务，会存在资源浪费
TCC事务是柔性事务，在try阶段要对资源做预留
TCC事务在确认或取消阶段释放资源
与基于消息事务对比，TCC的时效性更好

#### 主流分布式事务框架介绍
阿里全局事务服务（Global Transaction Service，简称GTS）收费
蚂蚁金服分布式事务（Distributed Transaction-eXtended，简称DTX）收费
**开源TCC框架（TCC-Transaction）** 暂时使用这个
**开源TCC框架（ByteTCC）**

## 10 服务监控

## 11 微服务面试总结

## 备注
- 常用命令
```aidl
clean install -Dmaven.test.skip=true
```
- 测试接口
```$xslt
登录：http://localhost:81/auth?userName=admin&password=admin123
下单：http://localhost:81/order/buyTickets?fieldId=1&soldSeats=9&seatsName=1
订单列表：http://localhost:81/order/getOrderInfo
```

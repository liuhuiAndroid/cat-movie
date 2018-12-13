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

- 数据库时间处理
1. MoocOrderTMapper.xml#getOrderInfoById 对数据库时间的处理
2. mysql函数：DATE_FORMAT、UNIX_TIMESTAMP

#### 订单模块的横向和纵向拆表解决
问题：每年的订单量太大

#### 服务限流如何处理
问题：双十一订单太多

#### 服务的熔断和降级
问题：业务系统雪崩

#### 如何保证多版本的蓝绿上线
- dubbo特性：分组、聚合和版本控制
- 如何保证多版本的蓝绿上线
部分上线，灰度发布

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

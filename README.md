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
[见dubbo 官方文档](https://dubbo.gitbooks.io/dubbo-user-book/content/demos/async-call.html)

## 备注
常用命令
```aidl
clean install -Dmaven.test.skip=true
```
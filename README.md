# spring-cloud-nacos实例

[Spring Boot 与 Spring Cloud Alibaba 版本对应关系](https://sca.aliyun.com/docs/2023/best-practice/spring-boot-to-spring-cloud/#spring-boot-%E4%B8%8E-spring-cloud-alibaba-%E7%89%88%E6%9C%AC%E5%AF%B9%E5%BA%94%E5%85%B3%E7%B3%BB)

## 1. 准备工作
|工具|版本|
|---|---|
|JDK|1.8|
|MAVEN|3.2.5+|
|[Nacos Server](https://objects.githubusercontent.com/github-production-release-asset-2e65be/137451403/ca2ff3f9-5ce1-4c1f-974e-a156869e8bfd?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=releaseassetproduction%2F20241128%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20241128T011837Z&X-Amz-Expires=300&X-Amz-Signature=f376ba430efc8f7cb5a895fee8a2ea08abf143166610a672e4eed390b011eeb4&X-Amz-SignedHeaders=host&response-content-disposition=attachment%3B%20filename%3Dnacos-server-2.4.3.zip&response-content-type=application%2Foctet-stream)|2.4.3|
|SpringBoot|2.7.18|
|spring-cloud-dependencies|2021.0.5|
|spring-cloud-alibaba-dependencies|2021.0.5.0|


## 2. 下载并安装nacos
你可以通过源码和发行包两种方式来获取 Nacos。
### 从Github上下载源码方式(**不推荐**)
```shell
git clone https://github.com/alibaba/nacos.git
cd nacos/
mvn -Prelease-nacos -Dmaven.test.skip=true clean install -U  
ls -al distribution/target/

// change the $version to your actual path
cd distribution/target/nacos-server-$version/nacos/bin
```
### 下载编译后压缩包方式(**强烈推荐**)
您可以从 [最新稳定版本](https://github.com/alibaba/nacos/releases) 下载 nacos-server-$version.zip 包。
本实例使用的是2.4.3版本
```shell
unzip nacos-server-$version.zip 或者 tar -xvf nacos-server-$version.tar.gz
cd nacos/bin
```

## 3. 启动服务器
注：Nacos的运行需要以至少2C4g60g*3的机器配置下运行。

**Linux/Unix/Mac**

启动命令(standalone代表着单机模式运行，非集群模式):

`sh startup.sh -m standalone`

如果您使用的是ubuntu系统，或者运行脚本报错提示[[符号找不到，可尝试如下运行：

`bash startup.sh -m standalone`
---
**Windows**

启动命令(standalone代表着单机模式运行，非集群模式):

`startup.cmd -m standalone`

## 4.关闭服务器
**Linux/Unix/Mac**

`sh shutdown.sh
`
---
**Windows**

`shutdown.cmd`

或者双击shutdown.cmd运行文件。

## 5. 服务启动成功后访问nacos管理界面

http://localhost:8848/nacos/

界面中服务管理菜单服务列表就是我们需要查看注册服务接口的地方。

### 6. 创建一个`spring-boot-nacos-provider`项目用于注册服务
下载实例代码，并启动`spring-boot-nacos-provider`项目，然后在nacos管理界面中 服务管理-服务列表 会看到注册成功的项目

### 7. 创建一个`spring-boot-nacos-consumer`项目用于发现并调用服务
启动`spring-boot-nacos-consumer`项目，在nacos管理界面中 服务管理-服务列表 会看到注册服务，在订阅者列表中会看到消费服务方

### 8. 远程访问测试
浏览器访问 `spring-boot-nacos-consumer`服务 地址 http://localhost:8082/consume，consumer端会远程调用provider端接口并返回预期结果

### 9. 注意事项

***SpringBoot版本 spring-cloud-dependencies版本 spring-cloud-alibaba-dependencies版本一定要按照 nacos官网说明匹配对应，否则项目启动会报错***
[Spring Boot 与 Spring Cloud Alibaba 版本对应关系](https://sca.aliyun.com/docs/2023/best-practice/spring-boot-to-spring-cloud/#spring-boot-%E4%B8%8E-spring-cloud-alibaba-%E7%89%88%E6%9C%AC%E5%AF%B9%E5%BA%94%E5%85%B3%E7%B3%BB)
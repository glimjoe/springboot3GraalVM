# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.4/maven-plugin/reference/html/#build-image)
* [GraalVM Native Image Support](https://docs.spring.io/spring-boot/docs/3.2.4/reference/html/native-image.html#native-image)

### Additional Links

These additional references should also help you:

* [Configure AOT settings in Build Plugin](https://docs.spring.io/spring-boot/docs/3.2.4/maven-plugin/reference/htmlsingle/#aot)

## GraalVM Native Support

This project has been configured to let you generate either a lightweight container or a native
executable.
It is also possible to run your tests in a native image.

### Lightweight Container with Cloud Native Buildpacks

If you're already familiar with Spring Boot container images support, this is the easiest way to get
started.
Docker should be installed and configured on your machine prior to creating the image.

To create the image, run the following goal:

```
$ ./mvnw spring-boot:build-image -Pnative
```

Then, you can run the app like any other container:

```
$ docker run --rm springboot3graalvm:0.0.1-SNAPSHOT
```

### Executable with Native Build Tools

Use this option if you want to explore more options such as running your tests in a native image.
The GraalVM `native-image` compiler should be installed and configured on your machine.

NOTE: GraalVM 22.3+ is required.

To create the executable, run the following goal:

```
$ ./mvnw native:compile -Pnative
```

Then, you can run the app as follows:

```
$ target/springboot3graalvm
```

You can also run your existing tests suite in a native image.
This is an efficient way to validate the compatibility of your application.

To run your existing tests in a native image, run the following goal:

```
$ ./mvnw test -PnativeTest
```

### 额外注意事项
* 以上内容，是通过spring initializer创建项目的时候自动生成的，但是其中内容有部分谬误
* 上面提到需要GraalVM 22.3以上版本，这是旧版的说明，新版GraalVM的版本号跟随Java版本号，下载Java17对应的GraalVM版本就是17，不要强行下载Java22对应的GraalVM，Java22不是LTS
* 上面的命令是基于Linux发行版的，Windows下面构建镜像的命令应该是：
```
mvn -Pnative spring-boot:build-image
```
不过常用的应该是构建本地可执行镜像
```shell
mvn -Pnative native:compile
```
有时候会遇到类似于`Error:java: 错误: 不支持发行版本 17`，尝试重启电脑

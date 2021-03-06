一个比较完整的gradle多项目例子, 使用了springBoot, springSecurity, mybatis, springfox-swagger2

### 1: 初始化
https://start.spring.io/ <br>
选择：Gradle <br>
Artifact：bootTest<br>
boot版本2.06<br>
依赖加：Web Lombok Security Actuator DevTools MySql MyBatis

### 2：建立子项目
下载解压后,根目录新建3文件夹：web app common<br>
把根目录的src复制到3个目录下<br>
把根目录的src删除<br>
common新建文件build.gradle，内容就一行：<br>
archivesBaseName = 'bootTest-common'<br>
app的内容为：
```
archivesBaseName = 'bootTest-app'
dependencies {
	compile project(":common")
}
```
web的内容为：
```
archivesBaseName = 'bootTest-web'
dependencies {
	compile project(":app")
}
```

### 3:添加子项目
根目录的settings.gradle 添加：include 'web', 'app', 'common'<br>
根目录的build.gradle：把除了buildscript之外的内容全部扩在subprojects里：
```
subprojects {
	apply plugin: 'java'
	......
}
```

### 4：配置数据源，security
在web下的src/main/resource/application.properties添加数据源配置：
```
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://127.0.0.1:3307/test?useSSL=false&useUnicode=true&characterEncoding=utf8
spring.datasource.username=test
spring.datasource.password=test
```
spring security用户配置
```
spring.security.user.name=aa
spring.security.user.password=aa
spring.security.user.roles=admin
```

web工程下的BootTestApplication改写如下：
```
@SpringBootApplication
@RestController
public class BootTestApplication {
	public static void main(String[] args) {
		SpringApplication.run(BootTestApplication.class, args);
	}
	@GetMapping("/test")
    public String getInfo() {
	  return "test";
	}
}
```
### 5:测试启动
用ideal导入整个项目
run web工程下的BootTestApplication
浏览器输入：http://localhost:8080/test 可见“test”

### 6:springboot打包的问题
在terminal窗口build<br>
gradlew build -x test<br>
可以在web项目下的build\libs目录下看到bootTest-web-0.0.1-SNAPSHOT.jar<br>
用Java jar bootTest-web-0.0.1-SNAPSHOT.jar可以运行<br>
但是可以发现文件有60多M ？？？<br>
打开发现BOOT-INF\lib中<br>
bootTest-app-0.0.1-SNAPSHOT.jar<br>
bootTest-common-0.0.1-SNAPSHOT.jar都有20多M<br>
可见spring boot的gradle 插件把app和common都搞成boot jar，
实际上我们只要bootTest-web-0.0.1-SNAPSHOT.jar是boot jar就可以<br>
按文档https://docs.spring.io/spring-boot/docs/2.0.6.RELEASE/gradle-plugin/reference/html/#managing-dependencies-using-in-isolation<br>
不是所有子项目都需要apply plugin: 'org.springframework.boot'<br>
所以把更目录build.gradle的subprojects块内的apply plugin: 'org.springframework.boot'去掉，<br>
移动到web的build.gradle中，在subprojects增加
```
dependencyManagement {
	imports {
		mavenBom org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES
	}
}
```

再gradlew build -x test
可以发现bootTest-web-0.0.1-SNAPSHOT.jar变为20多M

### 7:mybatis自动生成和其他配置
增加mybatis自动生成：<br>
bootTest根目录下增加文件：<br>
build-mybatis.gradle: 还会自动生成repository类，继承GenericMapper和GenericRepository,自动copy到目标目录<br>
generatorConfig-mysql.xml<br>
内容见源代码<br>
命令行运行gradlew mymy 生成xml mapper和entity,mapper<br>

刚开始在依赖里已经选了myBatis<br>
在web的application.properties里增加配置：
```
mybatis.mapper-locations=classpath:mapper/*.xml,classpath:mapper/ext/*.xml
mybatis.type-aliases-package=com.example.bootTest.app.db.entity
```
在APP项目的com.example.bootTest.app下增加类Appconfig:
```
@Configuration
@MapperScan("com.example.bootTest.app.db.repo")
public class AppConfig {
}
```

### 8:登录
增加依赖 implementation "org.springframework.boot:spring-boot-starter-thymeleaf"<br>
增加一个模版login.html到templates下, thymeleaf默认读取templates下的模版<br>
thymeleaf自动会添加csrf保护<br>
ApplicationSecurity：spring security配置<br>
TestUserService：用户数据访问<br>
用户密码在BootTestApplicationTests中转换，用默认的bcrypt encoder.


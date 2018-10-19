一个比较完整的gradle多项目例子, springboot框架, 使用mybatis<br>

1: 初始化
-
https://start.spring.io/ <br><br>
选择：Gradle<br>
Artifact：bootTest<br>
boot版本2.06<br>
依赖加：Web Lombok Security Actuator DevTools MySql MyBatis<br>
<br>
2：建立子项目
-
下载解压后<br>
根目录新建3文件夹：web app common<br>
把根目录的src复制到3个目录下<br>
把根目录的src删除<br>
common新建文件build.gradle，内容就一行：<br>
archivesBaseName = 'bootTest-common'<br>
app的内容为：<br>
archivesBaseName = 'bootTest-app'<br>
dependencies {<br>
	compile project(":common")<br>
}<br>
web的内容为：<br>
archivesBaseName = 'bootTest-web'<br>
dependencies {<br>
	compile project(":app")<br>
}<br>
<br>
3:添加子项目
-
根目录的settings.gradle 添加：include 'web', 'app', 'common'<br>
根目录的build.gradle：把除了buildscript之外的内容全部扩在subprojects里：<br>
subprojects {<br>
	apply plugin: 'java'<br>
	......<br>
}<br>
<br>
4：配置数据源，security
-
在web下的src/main/resource/application.properties添加数据源配置：<br>
spring.datasource.driver-class-name=com.mysql.jdbc.Driver<br>
spring.datasource.url=jdbc:mysql://127.0.0.1:3307/test?useSSL=false&useUnicode=true&characterEncoding=utf8<br>
spring.datasource.username=test<br>
spring.datasource.password=test<br>
spring security用户配置<br>
spring.security.user.name=aa<br>
spring.security.user.password=aa<br>
spring.security.user.roles=admin<br>
<br>
web工程下的BootTestApplication改写如下：<br>
@SpringBootApplication<br>
@RestController<br>
public class BootTestApplication {<br>
	public static void main(String[] args) {<br>
		SpringApplication.run(BootTestApplication.class, args);<br>
	}<br>
	@GetMapping("/test")<br>
    public String getInfo() {<br>
	  return "test";<br>
	}<br>
}<br>
<br>
5:测试启动
-
用ideal导入整个项目<br>
run web工程下的BootTestApplication<br>
浏览器输入：http://localhost:8080/test 可见“test”<br>
<br>
<br>
6:springboot打包的问题
-
在terminal窗口build<br>
gradlew build -x test<br>
可以在web项目下的build\libs目录下看到bootTest-web-0.0.1-SNAPSHOT.jar<br>
用Java jar bootTest-web-0.0.1-SNAPSHOT.jar可以运行<br>
但是可以发现文件有60多M ？？？<br>
打开发现BOOT-INF\lib中<br>
bootTest-app-0.0.1-SNAPSHOT.jar<br>
bootTest-common-0.0.1-SNAPSHOT.jar都有20多M<br>
可见spring boot的gradle 插件把app和common都搞成boot jar，实际上我们只要bootTest-web-0.0.1-SNAPSHOT.jar<br>
是boot jar就可以<br>
按文档https://docs.spring.io/spring-boot/docs/2.0.6.RELEASE/gradle-plugin/reference/html/#managing-dependencies-using-in-isolation<br>
不是所有子项目都需要apply plugin: 'org.springframework.boot'<br>
所以把更目录build.gradle的subprojects块内的apply plugin: 'org.springframework.boot'去掉，<br>
移动到web的build.gradle中，在subprojects增加<br>
dependencyManagement {<br>
	imports {<br>
		mavenBom org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES<br>
	}<br>
}<br>
<br>
再gradlew build -x test<br>
可以发现bootTest-web-0.0.1-SNAPSHOT.jar变为20多M<br>
<br>
7:mybatis自动生成和其他配置
-
增加mybatis自动生成：<br>
bootTest根目录下增加文件：<br>
build-mybatis.gradle<br>
generatorConfig-mysql.xml<br>
内容见源代码<br>
命令行运行gradlew mymy 生成xml mapper和entity,dao<br>
<br>
刚开始在依赖里已经选了myBatis<br>
在web的application.properties里增加配置：<br>
mybatis.mapper-locations=classpath:mapper/*.xml,classpath:mapper/ext/*.xml<br>
mybatis.type-aliases-package=com.example.bootTest.app.db.entity<br>
在APP项目的com.example.demo4.app下增加类Appconfig:<br>
@Configuration<br>
@MapperScan("com.example.demo4.app.db.dao")<br>
public class AppConfig {<br>
}<br>
<br>

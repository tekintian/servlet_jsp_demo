# Gradle JSP演示项目

jsp + servlet 实现简单 加减乘除计算器， 2种数据格式，直接显示或者返回JSON

##API请求
- 需要传递4个参数  请求方式：POST 或 get

参数 | 参数说明 | 是否必填
---- | ---- | ----
num1 | 第一个数 | 是 |
num2  | 第二个数 |  是 | 
oper |  操作符 | 是 |
t  |  json 返回的数据格式 | 是 | 

- get请求示例： 
    http://localhost:8090/jsp_demo/calculation.do?num1=12&num2=99&oper=-&t=json

## jsp开发常见问题
1. out对象为何可以直接使用？
	因为 out 对象在JSP中属于内置对象，jsp中一共有9个内置对象【不用声明，可直接只用的对象】

2. [JSP九大内置对象及四个作用域详解](docs/JSP九大内置对象及四个作用域详解.md)
3. [SimpleDateFormat使用详解](docs/SimpleDateFormat使用详解.md)


## IDEA 使用Gradle运行jsp项目
1. 新建gradle项目,类型选择 java 与web；

2. 增加编译依赖

	//编译依赖
    compileOnly('javax.servlet:javax.servlet-api:4.0.1')
    compileOnly('javax.servlet.jsp:javax.servlet.jsp-api:2.3.2-b02')
    compileOnly('javax.servlet.jsp.jstl:javax.servlet.jsp.jstl-api:1.2.1')

-  compileOnly 仅在编译的时候使用，不会发布到 lib目录； compile 会跟随项目发布到 lib目录


- 完整的 build.gradle文件
```gradle
plugins {
    id 'java'
    id 'war'
}

group 'cn.tekin'
version '1.0-SNAPSHOT'

sourceCompatibility = 1.8

repositories {
    mavenCentral()
}

dependencies {

//编译依赖
    compileOnly('javax.servlet:javax.servlet-api:4.0.1')
    compileOnly('javax.servlet.jsp:javax.servlet.jsp-api:2.3.2-b02')
    compileOnly('javax.servlet.jsp.jstl:javax.servlet.jsp.jstl-api:1.2.1')

    testCompile group: 'junit', name: 'junit', version: '4.11'
    testCompile group: 'junit', name: 'junit', version: '4.12'
}

```


## IDEA 结合Tomcat调试运行jsp文件，tomcat 翻译后的jsp文件对应的源文件存放目录为：
```text
C:\Users\{你的电脑的用户名}\.IntelliJIdea2018.1\system\tomcat\Unnamed_{项目名称}\work\Catalina\localhost\{项目名称}\org\apache\jsp
```

- IDEA 所有的项目配置位置

	C:\Users\{你电脑用户名}\.IntelliJIdea2018.1\system\tomcat

	此目录下面存放了所有的IDEA软件中创建的项目的所有运行配置文件和JSP翻译的源文件等文件




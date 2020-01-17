# SpringBoot学习

## 一、基础配置

### 定制banner

在resources目录下添加banner.txt文件

在文件下添加相应的图形

[定制bannaer网站](http://patorjk.com/software/taag/#p=display&f=Graffiti&t=Type Something )

关闭bannner

在启动类中关闭

```java
SpringApplicationBuilder builder = new SpringApplicationBuilder(XXXApplication.class);

SpringApplication build = builder.build();
build.setBannerMode(Banner.Mode.OFF);
build.run(args);
```

### SpringBoot注解

```java
@Component, @Service, @Controller, @Repository是spring注解，注解后可以被spring框架所扫描并注入到spring容器来进行管理
    
@Component是通用注解，其他三个注解是这个注解的拓展，并且具有了特定的功能
@Repository注解在持久层中，具有将数据库操作抛出的原生异常翻译转化为spring的持久层异常的功能。
@Controller层是spring-mvc的注解，具有将请求进行转发，重定向的功能。
@Service层是业务逻辑层注解，这个注解只是标注该类处于业务逻辑层。
    
用这些注解对应用进行分层之后，就能将请求处理，义务逻辑处理，数据库操作处理分离出来，为代码解耦，也方便了以后项目的维护和开发。
```

| 注解        | 含义                                         |
| ----------- | -------------------------------------------- |
| @Component  | 最普通的组件，可以被注入到spring容器进行管理 |
| @Repository | 作用于持久层                                 |
| @Service    | 作用于业务逻辑层                             |
| @Controller | 作用于表现层（spring-mvc的注解）             |



### 属性注入

可以在XXX.properties文件中写信息，读入相应的文件中

```java
//在book类中定义
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@PropertySource("classpath:book.properties")
public class Book {
    @Value("${Book.id}")
    private Long id;
    @Value("${Book.name}")
    private String name;
    @Value("${Book.author}")
    private String author;
}

//Component组件，使其归于spring管理
//使用@Value从XXX.properties中提取信息
//@PropertySource("classpath:book.properties")表示从该路径下获取需要读取的文件
```

#### 类型安全的属性注入（SpringBoot提供）

```java
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@PropertySource("classpath:book.properties")
@ConfigurationProperties(prefix = "book")
//增加其配置，增加前缀，读取信息
public class Book {
    private Long id;
    private String name;
    private String author;
}
```

需要配置xml

```xml
<dependency> 
	<groupId> org.springframework.boot </ groupId> 
	<artifactId> spring-boot-configuration-processor </ artifactId> 
	<optional> true </ optional> 
</dependency>
```



### yaml配置

yaml配置有序，而properties配置无序

自定义yaml目前不支持使用注解直接注入Springboot项目

![注入](https://img2018.cnblogs.com/blog/1418974/201907/1418974-20190728164637719-1038154879.png)

### lombok插件

```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.10</version>
</dependency>
```

[yml配置详解](https://www.cnblogs.com/hellokuangshen/p/11259029.html)

### profile

环境切换

使用不同的命名，以便于切换

常见命名方式application-{name}.yml

若想要哪个配置文件生效，则在application.yml中配置

```yml
spring.profiles.active=active
```



## 二、整合视图层技术

thymeleaf

## 三、整合Web开发

### 返回JSON数据

HttpMessageConverter消息转换工具

1. 将服务端返回的对象序列化成JSO字符串
2. 将前端传来的JSON字符串反序列化成Java对象



```java
Json
Gson
Fson

    
org.springframework.boot.autoconfigure.http.JacksonHttpMessageConvertersConfiguration
org.springframework.boot.autoconfigure.JackAutoConfiguration

org.springframework.boot.autoconfigure.http.GsonHttpMessageConvertersConfiguration
org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration
```

![image-20200117204845621](C:\Users\jiefa\AppData\Roaming\Typora\typora-user-images\image-20200117204845621.png)

```java
@Configuration
public class WebMvcConfig {
   /* @Bean
   //Json
    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper om = new ObjectMapper();
        om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        converter.setObjectMapper(om);
        return converter;
    }

    @Bean
    ObjectMapper objectMapper(){
        ObjectMapper om = new ObjectMapper();
        om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        return om;
    }

   @Bean
   //Gson
   GsonHttpMessageConverter gsonHttpMessageConverter(){
       GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
       converter.setGson(new GsonBuilder().setDateFormat("yyyy/MM/dd").create());
       return converter;
   }*/

   @Bean
    //FastJson
   FastJsonHttpMessageConverter fastJsonHttpMessageConverter(){
       FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
       FastJsonConfig config = new FastJsonConfig();
       config.setDateFormat("yyyy/MM/dd");
       converter.setFastJsonConfig(config);
       return converter;
   }

}
```

### 静态资源

```java
//添加静态资源的

org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration
    
classpath:/META-INF/resources/
classpath:/resources/
classpath:/static/
classpath:/public/
/
```


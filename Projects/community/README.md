# community
## 快捷键
```scss
ctrl + p                  提示参数
ctrl + shift + n          寻找文件
alt + 1                   切换全屏
alt + insert              快速构建get和set方法
ctrl + e                  快速切换最近的一个文件
ctrl + alt + o            移除无用包文件
alt + Enter               去掉多余的修饰符(public...)
ctrl + alt + v            快速抽取变量

ctrl + q	              返回值类型
ctrl + n	              搜索类
ctrl + F12	              查看当前类的所有方法
ctrl + h

```
```git
git commit --amend

一、如果已经push到远端服务器，想修改已经提交过的commit信息  

1.保存
# git commit --amend  
2.重新提交gerrit审批  
# git push --no-thin origin HEAD:refs/for/master  
  
二、如果已经push到远端服务器,有漏掉的test.txt文件想提交到上一次的commit信息  

1.添加test.txt  
# git add test.txt  
2.修改commit信息
# git commit --amend  
3.重新push到远端服务器  
# git push --no-thin origin HEAD:refs/for/master 

git commit --amend --no-edit 追加提交，只显示一次提交信息
git commit --amend --no-edit
```

## Spring
### 注解
@Component是基础注解，表示一个 JavaBean 可以被注入到 Spring 容器中。<br>
为了更好的表示 Web 服务中的三层结构，所以就额外的引出了另外的三种注解分别用在三层结构中进行标注：

@Controller 用在表现层，对来自前端的请求进行转发处理与重定向。

@Repository 用在持久层，标注 DAO 类，表示这个类可以对数据库进行数据的读取或者写入。

@Service 用在业务层，用来处理业务逻辑。


## 授权
OAuth

Github提供的流程<br>
1. 重定向用户请求其Github身份
2. Github将用户重定向你的站点
3. 你的站点使用用户的访问令牌访问网址


具体流程

第一步<br>
用户登录app或Web应用，其应用转跳到Github用户授权页面，调用API的authorize，其中`client_id`必须携带，如下所示
```
GET https://github.com/login/oauth/authorize
```

用户同意授权，链接地址跳转到设置的`redirect_uri`,并且携带`code`

第二步<br>
获取到这个`code`参数后，将这个code传到服务器的后台,后台调用 
```
https://github.com/login/oauth/access_token 
```
这个api，传入`client_id`, `client_secret`, `code` 这三个参数，获取到 `access_token`令牌。

第三步<br>
获取到 `access_token` 后， 再调用 
```
https://api.github.com/user?access_token=access_token 
```
这个API，就可以获取到基本的用户信息了。

根据第一步传入的不同的 `scope`，获取到的用户信息也是不同的。使用 `login` 字段作为用户的唯一标示。

第四步<br>
存入数据库，更新登录状态

[简书介绍](https://www.jianshu.com/p/78d186aeb526)

## 资料
[Spring 文档](https://spring.io/guides)    
[Spring Web](https://spring.io/guides/gs/serving-web-content/)   
[es](https://elasticsearch.cn/explore)    
[Github deploy key](https://developer.github.com/v3/guides/managing-deploy-keys/#deploy-keys)    
[Bootstrap](https://v3.bootcss.com/getting-started/)    
[Github OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)    
[Spring](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support)    
[菜鸟教程](https://www.runoob.com/mysql/mysql-insert-query.html)    
[Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#setting-attribute-values)    
[Spring Dev Tool](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#using-boot-devtools)  
[Spring MVC](https://docs.spring.io/spring/docs/5.0.3.RELEASE/spring-framework-reference/web.html#mvc-handlermapping-interceptor)  
[Markdown 插件](http://editor.md.ipandao.com/)   
[UFfile SDK](https://github.com/ucloud/ufile-sdk-java)  
[Count(*) VS Count(1)](https://mp.weixin.qq.com/s/Rwpke4BHu7Fz7KOpE2d3Lw)  

## 工具
[Git](https://git-scm.com/download)   
[Visual Paradigm](https://www.visual-paradigm.com)    
[Flyway](https://flywaydb.org/getstarted/firststeps/maven)  
[Lombok](https://www.projectlombok.org)    
[ctotree](https://www.octotree.io/)   
[Table of content sidebar](https://chrome.google.com/webstore/detail/table-of-contents-sidebar/ohohkfheangmbedkgechjkmbepeikkej)    
[One Tab](https://chrome.google.com/webstore/detail/chphlpgkkbolifaimnlloiipkdnihall)    
[Live Reload](https://chrome.google.com/webstore/detail/livereload/jnihajbhpnppcggbcgedagnkighmdlei/related)  
[Postman](https://chrome.google.com/webstore/detail/coohjcphdfgbiolnekdpbcijmhambjff)

## 脚本
```sql
CREATE TABLE USER
(
    ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    ACCOUNT_ID VARCHAR(100),
    NAME VARCHAR(50),
    TOKEN VARCHAR(36),
    GMT_CREATE BIGINT,
    GMT_MODIFIED BIGINT
);
```
```bash
mvn flyway:migrate
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```
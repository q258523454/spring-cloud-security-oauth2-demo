




关于模块：spring-cloud-security-oauth2-demo

2018-11-09 日更新

在这之前的更新都是 作者:```http https://github.com/lexburner```的劳动成果
新增 spring-cloud-security-JWT

首先建表:
```sql
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `authority` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=168 DEFAULT CHARSET=utf8
```

执行,创建用户
```http
http://localhost:8080/insertUser
```
账号:abc
密码:123

执行(未授权访问)---报错
```http
http://localhost:8080/userList
```

获取token先得登录
```http
http://localhost:8080/login
```
post body就是上面插入的账号密码
```json
{
"username": "abc",
"password": "123"
}
```

执行后会发现Headers里面返回了一个:
>MyAuthorization →MyToken eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhYmMtW1JPTEVfQURNSU4sIEFVVEhfV1JJVEVdIiwiZXhwIjoxNTQxNzQ4ODU5fQ.8NUBB5Ee4FUJ4MHDvEL8WTMrqgIO6tSmD1C76MWdCRv02Rb2woLEEr98s8g4C3DmbLDg9ZG5VUU4E4HT3AidJQ

复制这个token,以Mytoken开头的整个信息
在次调用(授权访问)
```http
http://localhost:8080/userList
```
在headers中添加参数
>MyAuthorization:MyToken eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhYmMtW1JPTEVfQURNSU4sIEFVVEhfV1JJVEVdIiwiZXhwIjoxNTQxNzQ4ODU5fQ.8NUBB5Ee4FUJ4MHDvEL8WTMrqgIO6tSmD1C76MWdCRv02Rb2woLEEr98s8g4C3DmbLDg9ZG5VUU4E4HT3AidJQ

最终返回结果:
```json
[{"id":161,"password":"123","username":"123"},{"id":162,"password":"123","username":"admin"},{"id":170,"password":"$2a$10$rVqyjJmVCpBVGb3/sPCz7eRGBNBotRZTbwLoBvTwUdeWtWpQNU9Ha","username":"abc"}]
```

该模块完全参照大神:
https://github.com/lexburner/oauth2-demo



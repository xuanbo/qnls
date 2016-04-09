#	环境搭建
---
##	开发环境
*	jdk1.7及以上
*	mysql5.6


##	框架
*	spring boot 1.3.3
*	spring security
*	spring jpa
*	druid
*	maven


##	说明
*	使用spring security实现了remember-me功能，持久化保存在数据库。
*	访问权限通过spring security的注解配置，在controller方法的前面用@PreAuthorize注解限制访问权限，关于访问资源存储在数据库还有待进一步的解决
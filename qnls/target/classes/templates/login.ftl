<#-- 用户登录页面 -->
<#import "common/common.ftl" as c>
<@c.htmlHead title="login">

</@c.htmlHead>
<@c.htmlBody>
    <form action="/login" method="post">
        用户名 : <input type="text" name="username" placeholder="用户名：" />
        密码: <input type="password" name="password" placeholder="密码：" />
        记住密码: <input type="checkbox" name="remember-me" value="true" />
        <input type="submit" value="登录"/>
    </form>
</@c.htmlBody>
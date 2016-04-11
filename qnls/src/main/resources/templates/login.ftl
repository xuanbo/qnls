<#-- 用户登录页面 -->
<#import "common/common.ftl" as c>
<@c.htmlHead title="login">
    <#-- 引入login.js -->
    <script type="text/javascript" src="/assets/custom/login/login.js"></script>
</@c.htmlHead>
<@c.htmlBody>
    <form id="loginForm" action="/login" method="post">
        用户名 : <input id="username" type="text" name="username" placeholder="用户名：" />
        密码: <input id="password" type="password" name="password" placeholder="密码：" />
        记住密码: <input type="checkbox" name="remember-me" value="true" />
        <input id="login" type="button" value="登录"/>
    </form>
</@c.htmlBody>
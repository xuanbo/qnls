<#import "common/common.ftl" as c>
<@c.htmlHead title="主页">

</@c.htmlHead>
<@c.htmlBody>
<div>
    欢迎您，
    <#if USER??>
    ${USER.name}，<a href="/logout">注销</a>
    <#else>
        游客，<a href="/login">登录</a>
    </#if>
</div>
<div>青年侣社，一个为年轻人打造的展示梦想、表达自己、传递爱心、释放激情和发挥创造力的O2O互助社区</div>

</@c.htmlBody>

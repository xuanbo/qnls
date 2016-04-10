<#-- 个人中心 -->
<#import "../common/common.ftl" as c>
<@c.htmlHead title="个人中心">

</@c.htmlHead>
<@c.htmlBody>
<p>个人中心</p>
<div>
    <#-- 用户昵称 -->
    <#if user.nickname??>
        ${user.nickname}
    </#if>
    <#-- 用户邮箱 -->
    <#if user.email??>
        ${user.email}
    </#if>
    <#-- 用户照片 -->
    <#if user.photo??>
        <img src="/personal/${user.id}/photo" />
    </#if>
</div>
</@c.htmlBody>
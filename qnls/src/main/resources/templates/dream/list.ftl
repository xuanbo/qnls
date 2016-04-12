<#import "../common/common.ftl" as c>
<@c.htmlHead title="梦想万事屋">
    <#-- 分页js -->
    <@c.paginator />
    <#-- 引入list.js -->
    <script type="text/javascript" src="/assets/custom/dream/list.js"></script>
    <#-- 引入list.css -->
    <link rel="stylesheet" type="text/css" href="/assets/custom/dream/list.css">
</@c.htmlHead>
<@c.htmlBody>

<#-- 引入AddDreamModal -->
<#include "addDreamModal.ftl">

<#-- top -->
<div id="head">
    <ol class="breadcrumb">
        <li><a href="/">青年侣社</a></li>
        <li><a href="/dream/list">梦想万事屋</a></li>
    </ol>
</div>

<div id="container">
    <#-- 梦想 -->
    <div id="dreams">
        <#if page.getContent()??>
            <#list page.getContent() as dream>
                <div class="dream">
                    <div class="userPhoto">
                        <img src="/images/user.jpg" class="img-circle">
                    </div>
                    <div class="dreamContent">
                        <#-- 梦想主题 -->
                        <div class="dreamTitle">
                            主题：
                            <a href="/dream/${dream.id}/comments">
                                ${dream.title}
                            </a>
                        </div>
                        <#-- 梦想内容 -->
                        <div>
                            ${dream.content}
                        </div>
                        <#-- 梦想发帖人与时间 -->
                        <div class="dreamUser">
                            <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                            <a href="">${dream.username}</a>
                            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                            发表时间：${dream.time}
                        </div>
                    </div>

                </div>
            </#list>
        <#else>
            <h1 style="margin-top: 100px; text-align: center">什么都没有呢，留下你的足迹吧！</h1>
        </#if>

        <#-- 分页 -->
        <div id="page" data-current="${current}"
             data-size="${size}"
             data-totalPages="${totalPages}">
        </div>
    </div>
</div>

<#-- 发帖 -->
<div id="addDream" class="btn">
    +
</div>

</@c.htmlBody>
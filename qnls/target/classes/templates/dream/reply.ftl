<#import "../common/common.ftl" as c>
<@c.htmlHead title="更多评论">
    <#-- 引入reply.css -->
    <link href="/assets/custom/dream/reply.css" rel="stylesheet" type="text/css">
</@c.htmlHead>
<@c.htmlBody>

<#-- top -->
<div id="head">
    <ol class="breadcrumb">
        <li><a href="/">青年侣社</a></li>
        <li><a href="/dream/list">梦想万事屋</a></li>
        <li>梦想还是要有的</li>
    </ol>
</div>

<div id="container">
    <#if page.getContent()??>
    <div id="replys">
        <#list page.getContent() as reply>
        <div class="reply">
            ${reply.id}
        </div>
        </#list>
    </div>
    </#if>
</div>

</@c.htmlBody>

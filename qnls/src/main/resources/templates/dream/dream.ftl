<#import "../common/common.ftl" as c>
<@c.htmlHead title="梦想在开花">
    <script type="text/javascript" src="assets/custom/dream/dream.js"></script>
</@c.htmlHead>
<@c.htmlBody>
<div>
    <#if Data??>
        <#list Data as commentAndReply>
        <div>
            <div>
                <#if commentAndReply.COMMENT??>
                   ${commentAndReply.COMMENT.username}评论：${commentAndReply.COMMENT.comment} 时间：${commentAndReply.COMMENT.commentTime}
                </#if>
            <div>
            <br>
            <div>
                <#if commentAndReply.REPLY??>
                    <#list commentAndReply.REPLY as reply>
                        ${reply.username}回复:${reply.replyUsername}||${reply.relyContent}<br>
                    </#list>
                    <a href="comment/${commentAndReply.COMMENT.id}/replys">更多精彩回复</a>
                <#else>
                    暂无回复
                </#if>
            </div>
        <div>
        <hr>
        </#list>
    </#if>
</div>
</@c.htmlBody>
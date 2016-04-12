<#import "../common/common.ftl" as c>
<@c.htmlHead title="梦想在开花">
    <#-- 分页js -->
    <@c.paginator />
    <#-- 引入dream.js -->
    <script type="text/javascript" src="/assets/custom/dream/dream.js"></script>
    <#-- 引入dream.css -->
    <link rel="stylesheet" type="text/css" href="/assets/custom/dream/dream.css">
</@c.htmlHead>
<@c.htmlBody>

<#-- 引入warnModal -->
<#include "../modalTemplates/warn.ftl">
<#-- 引入回复评论的modal -->
<#include "addReplyModal.ftl" >

<#-- top -->
<div id="head">
    <ol class="breadcrumb">
        <li><a href="/">青年侣社</a></li>
        <li><a href="/dream/list">梦想万事屋</a></li>
        <li>梦想还是要有的</li>
    </ol>
</div>

<#-- 评论内容+评论下面的5条回复 -->
<div id="container">
    <div>
    <#if Data??>
        <#list Data as commentAndReply>
            <div class="data">
            <#-- 每一条评论 -->
                <div class="comment">
                    <#if commentAndReply.COMMENT??>
                        <div class="commentUser">
                            <div class="userPhoto">
                                <img src="/images/user.jpg" />
                            </div>
                            <div class="userInfo">
                                <div class="username" title="用户">
                                    ${commentAndReply.COMMENT.username}
                                </div>
                                <div class="time" title="评论时间">
                                    ${commentAndReply.COMMENT.commentTime}
                                </div>
                            </div>
                            <div class="operator">
                                <#-- 回复该条评论 -->
                                <div class="replyThisComment btn" title="回复该条评论"
                                     data-username="${commentAndReply.COMMENT.username}"
                                     data-dreamCommentId="${commentAndReply.COMMENT.id}"
                                >
                                    <span class="glyphicon glyphicon-pencil"></span>
                                </div>
                            </div>
                        </div>
                        <div class="commentContent" title="评论内容">
                            &nbsp;&nbsp;:&nbsp;${commentAndReply.COMMENT.comment}
                        </div>
                    </#if>
                </div>
                <hr />
            <#-- 每一条评论下面显示5条回复 -->
                <#if commentAndReply.REPLY??>
                    <div class="replys">
                        <#list commentAndReply.REPLY as reply>
                        <#-- 每一条回复 -->
                            <div class="reply">
                                <a href="">
                                    ${reply.username}
                                </a>
                                &nbsp;回复:&nbsp;
                                <a href="">
                                    ${reply.replyUsername}
                                </a>
                                &nbsp;:&nbsp;
                                ${reply.replyContent}
                                &nbsp;
                                <span>${reply.replyTime}</span>
                                &nbsp;&nbsp;
                                <span class="replyThisReply" title="回复这条"
                                      data-dreamCommentId="${commentAndReply.COMMENT.id}"
                                      data-username="${reply.username}"
                                >
                                    回复他
                                </span>
                            </div>
                        </#list>
                        <#-- 回复多于五条才有能多回复 -->
                        <#if commentAndReply.COMMENT.replyCount gt 5>
                            <div class="moreReplys" title="更多精彩回复">
                                <a href="comment/${commentAndReply.COMMENT.id}/replys">
                                    ...
                                </a>
                            </div>
                        </#if>
                        <div>
                            ${commentAndReply.COMMENT.replyCount}条回复
                        </div>
                    </div>
                    <hr />
                <#else>
                    <div class="noReply">
                        暂无回复
                    </div>
                    <hr />
                </#if>
            </div>
        </#list>

        <#-- 分页 -->
        <div id="page" data-current="${current}"
             data-size="${size}"
             data-totalPages="${totalPages}">
        </div>
        <hr />
    <#else>
        <h1 style="margin-top: 100px; text-align: center">什么都没有呢，留下你的足迹吧！</h1>
    </#if>
    </div>
</div>

<#-- 评论该条梦想 -->
<div id="commentThisDream">
    <div>
        <textarea  type="text" id="dreamCommentInput" placeholder="我也评论一句..（不超过140个字）"></textarea >
    </div>
    <div id="addDreamComment" class="btn btn-default">
        评论
    </div>
</div>
</@c.htmlBody>
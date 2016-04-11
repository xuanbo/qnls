package com.lmbj.web.entity;

import javax.persistence.*;

/**
 * 梦想评论回复
 *
 * @author xuanbo
 * @version 1.0
 * @date 2016/4/10 13:17
 */
@Entity
@Table(name = "dreamCommentReply")
public class DreamCommentReply {

    /*
        主键
     */
    @Id
    @GeneratedValue
    @Column(name = "dreamCommentReply_id", length = 10)
    private Integer id;

    /*
        该评论的用户username
     */
    @Column(name = "dreamCommentReply_username", length = 20)
    private String username;

    /*
        该条回复的用户username
     */
    @Column(name = "dreamCommentReply_replyUsername", length = 10)
    private String replyUsername;

    /*
        该条回复所在的梦想评论
     */
    @Column(name = "dreamCommentReply_parentDreamCommentId", length = 10)
    private Integer parentDreamCommentId;

    /*
        回复的内容
     */
    @Column(name = "dreamCommentReply_relyContent")
    private String relyContent;

    /*
        回复的时间
     */
    @Column(name = "dreamCommentReply_relyTime")
    private String replyTime;

    public DreamCommentReply() {
    }

    public DreamCommentReply(String username, String replyUsername, Integer parentDreamCommentId, String relyContent, String replyTime) {
        this.username = username;
        this.replyUsername = replyUsername;
        this.parentDreamCommentId = parentDreamCommentId;
        this.relyContent = relyContent;
        this.replyTime = replyTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReplyUsername() {
        return replyUsername;
    }

    public void setReplyUsername(String replyUsername) {
        this.replyUsername = replyUsername;
    }

    public Integer getParentDreamCommentId() {
        return parentDreamCommentId;
    }

    public void setParentDreamCommentId(Integer parentDreamCommentId) {
        this.parentDreamCommentId = parentDreamCommentId;
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }

    public String getRelyContent() {
        return relyContent;
    }

    public void setRelyContent(String relyContent) {
        this.relyContent = relyContent;
    }

    @Override
    public String toString() {
        return "DreamCommentReply{" +
                "id=" + id +
                ", username=" + username +
                ", replyUsername=" + replyUsername +
                ", parentDreamCommentId=" + parentDreamCommentId +
                ", relyContent='" + relyContent + '\'' +
                ", replyTime='" + replyTime + '\'' +
                '}';
    }
}

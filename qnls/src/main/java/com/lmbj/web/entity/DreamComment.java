package com.lmbj.web.entity;

import javax.persistence.*;

/**
 * 梦想评价
 * @author xuanbo
 * @version 1.0
 * @date 2016/4/10 12:52
 */
@Entity
@Table(name = "dreamComment")
public class DreamComment {

    /*
        主键
     */
    @Id
    @GeneratedValue
    @Column(name = "dreamComment_id")
    private Integer id;

    /*
        梦想评论内容
     */
    @Column(name = "dreamComment_comment")
    private String comment;

    /*
        梦想id
     */
    @Column(name = "dreamComment_dreamId")
    private Integer dreamId;

    /*
        评论梦想的用户username
     */
    @Column(name = "dreamComment_username", length = 20)
    private String username;

    /*
        评论的时间
     */
    @Column(name = "dreamComment_commentTime")
    private String commentTime;

    /*
        回复该条评论的条数
     */
    @Column(name = "dreamComment_replyCount")
    private Integer replyCount;

    public DreamComment() {
    }

    public DreamComment(String comment, Integer dreamId, String username, String commentTime, Integer replyCount) {
        this.comment = comment;
        this.dreamId = dreamId;
        this.username = username;
        this.commentTime = commentTime;
        this.replyCount = replyCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getDreamId() {
        return dreamId;
    }

    public void setDreamId(Integer dreamId) {
        this.dreamId = dreamId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    @Override
    public String toString() {
        return "DreamComment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", dreamId=" + dreamId +
                ", username=" + username +
                ", commentTime='" + commentTime + '\'' +
                ", replyCount=" + replyCount +
                '}';
    }
}

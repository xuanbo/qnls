package com.lmbj.web.entity;

import javax.persistence.*;

/**
 * 梦想
 * @author xuanbo
 * @version 1.0                   x
 * @date 2016/4/10 12:33
 */
@Entity
@Table(name = "dream")
public class Dream {

    /*
        主键
     */
    @Id
    @GeneratedValue
    @Column(name = "dream_id", length = 10)
    private Integer id;

    /*
        梦想标题
     */
    @Column(name = "dream_title")
    private String title;

    /*
        梦想内容
     */
    @Column(name = "dream_content")
    private String content;

    /*
        梦想创建时间
     */
    @Column(name = "dream_time", length = 20)
    private String time;

    /*
        梦想用户name
     */
    @Column(name = "dream_username", length = 20)
    private String username;

    public Dream() {
    }

    public Dream(String title, String content, String time, String username) {
        this.title = title;
        this.content = content;
        this.time = time;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Dream{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

package com.lmbj.web.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Set;

/**
 * @author xuanbo
 * @version 1.0
 * @date 2016/4/9 00:56
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    /*
        主键id
     */
    @Id
    @GeneratedValue
    @Column(name = "user_id", length = 10)
    private Integer id;

    /*
        用户登录名
     */
    @Column(name = "user_name", length = 20)
    private String name;

    /*
        用户密码
     */
    @Column(name = "user_password", length = 20)
    private String password;

    /*
        用户昵称
     */
    @Column(name = "user_nickname", length = 50)
    private String nickname;

    /*
        用户邮箱
     */
    @Column(name = "user_email", length = 20)
    private String email;

    /*
        用户头像
     */
    @Column(name = "user_photo")
    private byte[] photo;

    /*
        用户累积分数
     */
    @Column(name = "user_score")
    private Integer score;

    /*
        用户角色
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "userrole",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")}
            , inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")})
    private Set<Role> roles;

    public User() {
    }

    public User(String name, String password, String nickname, String email, byte[] photo, Integer score, Set<Role> roles) {
        this.name = name;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.photo = photo;
        this.score = score;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", score=" + score +
                ", roles=" + roles +
                '}';
    }
}

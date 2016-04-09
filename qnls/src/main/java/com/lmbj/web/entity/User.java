package com.lmbj.web.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * @author xuanbo
 * @version 1.0
 * @date 2016/4/9 00:56
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id", length = 10)
    private int id;

    @Column(name = "user_name", length = 20)
    private String name;

    @Column(name = "user_password", length = 20)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "userrole",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")}
            , inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")})
    private Set<Role> roles;

    public User() {
    }

    public User(String name, String password, Set<Role> roles) {
        this.name = name;
        this.password = password;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}

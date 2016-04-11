package com.lmbj.web.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * @author xuanbo
 * @version 1.0
 * @date 2016/4/9 01:00
 */
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue
    @Column(name = "role_id", length = 5)
    private Integer id;

    @Column(name = "role_name", length = 20)
    private String name;

    @Column(name = "role_description", length = 50)
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<User> users;

    public Role() {
    }

    public Role(String name, String description, Set<User> users) {
        this.name = name;
        this.description = description;
        this.users = users;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", users=" + users +
                '}';
    }
}

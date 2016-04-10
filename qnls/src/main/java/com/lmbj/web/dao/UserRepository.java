package com.lmbj.web.dao;

import com.lmbj.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author xuanbo
 * @Package com.lmbj.web.dao
 * @Description
 * @date 2016/4/9.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * 根据用户名获取User
     * @param name
     * @return
     */
    User getByName(String name);
}

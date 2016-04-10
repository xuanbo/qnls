package com.lmbj.web.service;

import com.lmbj.web.entity.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xuanbo
 * @Package com.lmbj.web.service
 * @Description
 * @date 2016/4/9.
 */
public interface UserService {

    /**
     * 保存User对象，如果是持久态则更新
     * @param user
     */
    @Transactional
    void save(User user);

    /**
     * 根据name获取User
     * @param name
     * @return
     */
    @Transactional(readOnly = true)
    User getByName(String name);

    /**
     * 根据id获取User
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    User findOne(int id);
}

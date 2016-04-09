package com.lmbj.web.service;

import com.lmbj.web.entity.User;

/**
 * @author xuanbo
 * @Package com.lmbj.web.service
 * @Description
 * @date 2016/4/9.
 */
public interface UserService {

    void save(User user);

    User getByName(String name);

}

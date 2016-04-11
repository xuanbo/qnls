package com.lmbj.web.service;

import com.lmbj.web.entity.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xuanbo
 * @Package com.lmbj.web.service
 * @Description
 * @date 2016/4/9.
 */
public interface UserService extends BaseService<User, Integer> {

    /**
     * 根据name获取User
     * @param name
     * @return
     */
    @Transactional(readOnly = true)
    User getByName(String name);

}

package com.lmbj.web.service.impl;

import com.lmbj.web.dao.UserRepository;
import com.lmbj.web.entity.User;
import com.lmbj.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author xuanbo
 * @version 1.0
 * @date 2016/4/9 01:32
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User getByName(String name) {
        return userRepository.getByName(name);
    }

}

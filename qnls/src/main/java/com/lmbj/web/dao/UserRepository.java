package com.lmbj.web.dao;

import com.lmbj.web.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author xuanbo
 * @Package com.lmbj.web.dao
 * @Description
 * @date 2016/4/9.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    User getByName(String name);
}

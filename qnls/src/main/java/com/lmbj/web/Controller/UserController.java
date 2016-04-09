package com.lmbj.web.Controller;

import com.lmbj.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author xuanbo
 * @version 1.0
 * @date 2016/4/9 16:57
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

}

package com.lmbj.web.sercurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.lmbj.web.entity.User;
import com.lmbj.web.service.UserService;

@Component
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	
	/**
	 * 用户名可自定义，可以使用email等
	 */
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		User user = userService.getByName(username);
		if (user == null) {
			throw new UsernameNotFoundException("username:" 
					+ username + " is not found");
		}
		return new MyUserDetails(user);
	}

}

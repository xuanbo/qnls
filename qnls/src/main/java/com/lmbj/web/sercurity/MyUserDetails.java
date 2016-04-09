package com.lmbj.web.sercurity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.lmbj.web.entity.Role;
import com.lmbj.web.entity.User;

public class MyUserDetails extends User implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public MyUserDetails(User user){
		if (user != null){
			this.setId(user.getId());
			this.setName(user.getName());
			this.setPassword(user.getPassword());
			this.setRoles(user.getRoles());
		}
	}

	
	/**
	 * 用户和角色是多对多的关系
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		Set<Role> roles = this.getRoles();
		if (roles != null || roles.size() != 0){
			for (Role role : roles){
				SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
				authorities.add(authority);
			}
		}
		return authorities;
	}

	
	@Override
	public String getUsername() {
		return super.getName();
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

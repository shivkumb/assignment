package com.uxpsystems.assignment.security.serviceImpl;

import java.util.Collection;



import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.uxpsystems.assignment.model.User;

/**
 * 
 * @author shivkumb
 * Implements UserDetails overriding all methods which will help to find all user details.
 */
@Service
public class CustomUserDetailsImpl implements UserDetails {

	/**
	 * 
	 */
	User user;
	private static final long serialVersionUID = 1L;

	public CustomUserDetailsImpl(User user) {
		this.user = user;
	}
	public CustomUserDetailsImpl() {
		
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return user.isActive();
	}

}

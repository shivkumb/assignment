package com.uxpsystems.assignment.security.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.uxpsystems.assignment.dao.UserRepo;
import com.uxpsystems.assignment.exceptions.UserDataNotFoundException;
import com.uxpsystems.assignment.model.User;
/**
 * 
 * @author shivkumb
 *	This is Userdetails service class implemention to get the user details based on user name.
 */
@Service
public class UserDetailesServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	/**
	 * @param String username
	 * @throws UserDataNotFoundException user is not found
	 * This method will help to load the userdetails from db 
	 * 
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepo.findByUsername(username);
		if (user==null)
		{
			throw new UserDataNotFoundException();
		}
		CustomUserDetailsImpl userDetails = new CustomUserDetailsImpl(user);
		
		return userDetails;
	}

}

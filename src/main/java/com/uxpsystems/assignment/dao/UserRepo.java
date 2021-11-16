package com.uxpsystems.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uxpsystems.assignment.model.User;

@Repository
/**
 * 
 * @author shivkumb
 *	JPA reposity class which provides all CRUD operation methods
 */
public interface UserRepo extends JpaRepository<User, Long>{

	/**
	 * 
	 * @param username
	 * @return User entity
	 * {@code findByUsername is used to find the entity with with username filter}
	 */
	public User findByUsername(String username);
	
	/**
	 * 
	 * @param password
	 * @return User entity
	 * {@code findByUsername is used to find the entity with password filter }
	 */
	public User findByPassword(String password);
}

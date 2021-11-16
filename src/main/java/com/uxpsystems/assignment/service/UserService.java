package com.uxpsystems.assignment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uxpsystems.assignment.exceptions.DataNotSavedException;
import com.uxpsystems.assignment.model.User;
/**
 * @author shivkumb
 * @implSpec This is UserServiceImplention class.
 * The purpose of this class is provide the service for all CRUD operation methods from DAO layer.
 * 
 */
@Service
public interface UserService {

	/**
	 * 
	 * @return A user object list from database if users found else it returns empty list
	 * {@code This method can be used to search all users details}
	 */
	public List<User> getAllUsers();
	
	/**
	 * @param long userID
	 * @return A user object from database if user found else it returns null
	 * {@code This method can be used to search user details with help of userId}
	 */
	public User getUserById(long userId);
	
	/**
	 * @throws DataNotSavedException
	 * @return A user object from database if user is saved successfully else thorws DataNotSavedException
	 * @param User object
	 */
	public User saveUser(User user) throws DataNotSavedException;
	/**
	 * @param long userID
	 * {@code This method can be used to delete user details with help of userId}
	 */
	public void deleteUser(long userId);
	
	/**
	 * @throws DataNotSavedException
	 * @return A user object from database if user is updated successfully or saved succesfully if
	 * user was not already exists else thorws DataNotSavedException
	 * @param User object
	 */
	public User updateUser(User User) throws DataNotSavedException;
}

package com.uxpsystems.assignment.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uxpsystems.assignment.dao.UserRepo;
import com.uxpsystems.assignment.exceptions.DataNotSavedException;
import com.uxpsystems.assignment.model.User;
import com.uxpsystems.assignment.service.UserService;

/**
 * @author shivkumb
 * @implSpec This is UserServiceImplention class. The purpose of this class is
 *           provide the service for all CRUD operation methods from DAO layer.
 * 
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	/**
	 * 
	 * @return A user object list from database if users found else it returns empty
	 *         list {@code This method can be used to search all users details}
	 */
	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	/**
	 * @param long userID
	 * @return A user object from database if user found else it returns null
	 *         {@code This method can be used to search user details with help of userId}
	 */
	@Override
	public User getUserById(long userId) {
		User user = userRepo.findById(userId).orElse(null);
		return user;
	}

	/**
	 * @throws DataNotSavedException
	 * @return A user object from database if user is saved successfully else throws
	 *         DataNotSavedException
	 * @param User object
	 */
	@Override
	@Transactional(rollbackFor = DataNotSavedException.class)
	public User saveUser(User user) throws DataNotSavedException {

		User userByUsername = userRepo.findByUsername(user.getUsername());
		User userByPassword = userRepo.findByPassword(user.getPassword());
		if (userByUsername != null || userByPassword != null) {
			throw new DataNotSavedException();
		} else {
			User savedUser = userRepo.save(user);
			return savedUser;
		}

	}

	/**
	 * @param long userID
	 *             {@code This method can be used to delete user details with help of userId}
	 */
	@Override
	public void deleteUser(long userId) {

		userRepo.deleteById(userId);
	}

	/**
	 * @throws DataNotSavedException
	 * @return A user object from database if user is updated successfully or saved
	 *         succesfully if user was not already exists else thorws
	 *         DataNotSavedException
	 * @param User object
	 */
	@Override
	public User updateUser(User user) throws DataNotSavedException {

		return userRepo.save(user);
	}

}

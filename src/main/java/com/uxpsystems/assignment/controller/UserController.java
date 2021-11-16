package com.uxpsystems.assignment.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uxpsystems.assignment.exceptions.DataNotSavedException;
import com.uxpsystems.assignment.exceptions.InvalidInputInRequest;
import com.uxpsystems.assignment.exceptions.UserDataNotFoundException;
import com.uxpsystems.assignment.model.User;
import com.uxpsystems.assignment.service.UserService;
/**
 * 
 * @author shivkumb
 * Rest Controller class which will handle all CRUD operations requests.
 * Content Negotiation in JSON and XML as well.
 */
@RestController
public class UserController {

	@Autowired
	UserService userService;

	/**
	 * @GetMapping
	 * @return All Users List if no is user is available then throw custom exception UserDataNotFoundException.
	 * 
	 */
	@GetMapping(path = "/user", produces = { "application/json", "application/xml" }, consumes = { "application/json",
			"application/xml" })
	public ResponseEntity<List<User>> getAllUserDetail() {

		List<User> allUsers = userService.getAllUsers();
		if (allUsers.isEmpty()) {
			throw new UserDataNotFoundException();
		}
		return ResponseEntity.of(Optional.of(allUsers));
	}
	/**
	 * @GetMapping
	 * @param userId
	 * @return User entity if found with given user id else throw custom exception UserDataNotFoundException. 
	 */
	@GetMapping(path = "/user/{userId}", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<User> getUserDetailById(@PathVariable long userId) {
		User userDetails = userService.getUserById(userId);
		if (userDetails == null) {
			throw new UserDataNotFoundException();
		}
		return ResponseEntity.of(Optional.of(userDetails));
	}

	/**
	 * @PostMapping
	 * @param user Entity from User trying to save
	 * @param BindingResult result to check Validation errors
	 * @return User entity which is saved
	 * @throws InvalidInputInRequest
	 * @throws DataNotSavedException
	 */
	@PostMapping(path = "/user", produces = { "application/json", "application/xml" }, consumes = { "application/json",
			"application/xml" })
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user, BindingResult result)
			throws InvalidInputInRequest, DataNotSavedException {
		if (result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError objectError : list) {
				System.out.println(objectError.toString());
			}
			throw new InvalidInputInRequest();
		}

		user.setActive(true);
	
		User savedUser = userService.saveUser(user);
		return ResponseEntity.of(Optional.of(savedUser));
	}
	
	/**
	 * @PutMapping Method is used to update the entity in Database , if not found creates new entry.
	 * @param user
	 * @param result
	 * @return User which is updated
	 * @throws InvalidInputInRequest
	 * @throws DataNotSavedException
	 */
	@PutMapping(path = "/user", produces = { "application/json", "application/xml" }, consumes = { "application/json",
			"application/xml" })
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user, BindingResult result)
			throws InvalidInputInRequest, DataNotSavedException {
		if (result.hasErrors()) {
			throw new InvalidInputInRequest();
		}
		User updatedUser = userService.updateUser(user);
		return ResponseEntity.of(Optional.of(updatedUser));
	}
	
	/**
	 * @DeleteMapping -Method is used to delete the entity from Database , if not found throw custom exception UserDataNotFoundException. 
	 * @param userId
	 * @return Delete user with response code 202
	 */
	@DeleteMapping(path = "/user/{userId}", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<User> deleteUserByUserId(@PathVariable long userId) {
		User userDetails = userService.getUserById(userId);
		if (userDetails == null) {
			throw new UserDataNotFoundException();
		}else {
			userService.deleteUser(userId);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userDetails);
	}
}

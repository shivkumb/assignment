package com.uxpsystems.assignment.model;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
/**
 * 
 * @author shivkumb
 * User entity class with variables userID , username, password, Active status and TimeStamp.
 * UserID - Primary key ,will be incremented by 1 starting 1. 
 * username - Not blank,not nullable, length min = 6,max = 15 , Unique 
 *	password - Not blank,not nullable, length min = 8, Unique , 
 *	at least 1 (capital letter, small letter, number, special character)
 *  
 */

@Entity(name = "user_details")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id",nullable = false)
	private long userId;
	
	@Column(name = "username",nullable = false,unique = true)
	@NotBlank
	@Length(min = 6,max = 15)
	private String username;
	
	@Column(name = "password",nullable = false,unique = true)
	@NotBlank
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
	private String password;
	
	@Column(name = "active_status")
	private boolean isActive;
	
	@Column(name = "created_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

}

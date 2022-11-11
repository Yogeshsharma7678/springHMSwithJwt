package com.HMS.model;

//To declare variables of user class which are going to be column in the database

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class user {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//Autogenerate the user id
	private int userId;
	private String userName;
	private String userPassword;
	private String userMail;
	private String userRole;
	private int userPhone;
	private int userFee;
	
	@ManyToOne
	private room userRoom;
}

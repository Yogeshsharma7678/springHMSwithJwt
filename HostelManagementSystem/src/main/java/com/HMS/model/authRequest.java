package com.HMS.model;

//authRequest model class to declare authentication credentials 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class authRequest {

	private String userName;
	private String userPassword;
	
}

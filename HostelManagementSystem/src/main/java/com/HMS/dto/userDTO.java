package com.HMS.dto;

//Validating the user model data 

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.HMS.model.room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class userDTO {

	private int userId;
	
	@NotNull(message = "username can not be null")
	private String userName;
	
	@Pattern(regexp = "[a-zA-Z0-9_@#]{8,30}", message = "\nPassword can be AlphaNumeric and Atleast have 8 Characters.\n(Use atleast 1 Upper Case, 1 Lower Case, 1 Number)")
	private String userPassword;
	
	@Email
	private String userMail;
	
	@NotNull(message = "userrole can't be null")
	private String userRole;
	
    @Pattern(regexp="[0-9]{10}")
	private int userPhone;
	
	@Min(2000)
	@Max(6000)
	private int userFee;
	
	private room userRoom;
}

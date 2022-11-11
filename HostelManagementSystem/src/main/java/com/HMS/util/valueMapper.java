package com.HMS.util;

//class to convert user according to the validation

import com.HMS.dto.roomDTO;
import com.HMS.dto.userDTO;
import com.HMS.model.room;
import com.HMS.model.user;

public class valueMapper {

	public static user convertToUser(userDTO u) {
		
		user _u1=new user(u.getUserId(), u.getUserName(),u.getUserPassword(),u.getUserMail(),u.getUserRole(),u.getUserFee(),u.getUserPhone(),u.getUserRoom());
	
	     return _u1;
	}
	
	public static room convertToRoom(roomDTO r) {
		
		room _r1 = new room (r.getRoomId(),r.getRoomName(),r.getRoomType());
		
		return _r1;
		
	}
}

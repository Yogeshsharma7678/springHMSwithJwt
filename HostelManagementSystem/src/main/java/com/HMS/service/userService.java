package com.HMS.service;

//userService interface to declare all the methods to implement crud operations on user


import java.util.List;

import com.HMS.dto.userDTO;
import com.HMS.exception.GlobalException;
import com.HMS.model.user;

public interface userService {

	public user addUser(userDTO u);

	public List<user> getUser();

	public user updateUser(userDTO u);

	public String deleteUser(int userid) throws GlobalException;

	public String updatePhone(int userid, int userphone) throws GlobalException;

	public String allotRoom(int userid, int roomid) throws GlobalException;

	public Object updateFee(int userid, int userfee) throws GlobalException;

//	public user logReg(String username , String userpassword);
}

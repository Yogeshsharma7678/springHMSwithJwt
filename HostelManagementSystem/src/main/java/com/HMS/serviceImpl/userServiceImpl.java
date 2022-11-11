package com.HMS.serviceImpl;

//implementing all the methods of roomService and save data to databases  

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HMS.dto.userDTO;
import com.HMS.exception.GlobalException;
import com.HMS.model.user;
import com.HMS.repository.userRepository;
import com.HMS.service.userService;
import com.HMS.util.valueMapper;

@Service
public class userServiceImpl implements userService {

	@Autowired
	private userRepository repo;

	@Override
	public user addUser(userDTO u) {

		user u1 = valueMapper.convertToUser(u);
		return repo.save(u1);
	}

	@Override
	public List<user> getUser() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public user updateUser(userDTO u) {
		// TODO Auto-generated method stub

		user u1 = valueMapper.convertToUser(u);
		return repo.save(u1);
	}

	@Override
	public String deleteUser(int userid) throws GlobalException {
		// TODO Auto-generated method stub

		user u1 = repo.findByUserId(userid);
		if (u1 != null) {

			repo.deleteById(userid);
			return "deleted";
		} else {

			throw new GlobalException("User not found");

		}
	}

	@Override
	public String updatePhone(int userid, int userphone) throws GlobalException {
		// TODO Auto-generated method stub

		int st = repo.updatePhone(userid, userphone);

		if (st == 1) {

			return "updated";
		} else {

			throw new GlobalException("Something wrong");

		}

	}

	@Override
	public String allotRoom(int userid, int roomid) throws GlobalException {
		// TODO Auto-generated method stub

		int st = repo.allotRoom(userid, roomid);

		if (st == 1) {

			return "room allotted to user " + userid;
		} else {

			throw new GlobalException("something wrong");
		}
	}

	
	@Override
	public String updateFee(int userid, int userfee) throws GlobalException {
		// TODO Auto-generated method stub
		int st=repo.updateFee(userid, userfee);
		if(st==1) {
			return "Fee Updated to "+userid;
		}
		else {
			throw new GlobalException("something went wrong");

	}
	}

//	@Override
//	public user logReg(String username, String userpassword) {
//		// TODO Auto-generated method stub
//		user u1 = repo.findByUserId(0)
//		
//		return null;
//	}

}

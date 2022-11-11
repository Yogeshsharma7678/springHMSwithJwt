package com.HMS.controller;
/*Consuming all the methods of user 
 * 
 */
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HMS.model.authRequest;
import com.HMS.util.JwtUtil;

import com.HMS.dto.userDTO;
import com.HMS.exception.GlobalException;
import com.HMS.model.user;
import com.HMS.serviceImpl.userServiceImpl;

@RestController
@RequestMapping("/user")
public class userController {

	@Autowired
	//injecting 
	private userServiceImpl service;
	
	@Autowired
	//injecting
	AuthenticationManager authManager;
	
	@Autowired
	JwtUtil jwt;
	
	@PostMapping("/authentication")
	//generating the token to authenticate 
	public String generateToken(@RequestBody authRequest ar) {
	
		authManager.authenticate(
				new UsernamePasswordAuthenticationToken(ar.getUserName(),ar.getUserPassword()));
		return jwt.generateToken(ar.getUserName());
		
	}
	
	@PostMapping("/add")
	//consuming addUser methd
	public ResponseEntity<user> addUser(@RequestBody @Valid userDTO u){
		
		return new ResponseEntity<>(service.addUser(u),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/get")
	//To retrieve details of all the users available in hostel 
	public ResponseEntity<List<user>> getUser(){
		
		List<user> ul =service.getUser();
		
		return new ResponseEntity<>(ul,HttpStatus.OK);
	}  
	
	@PutMapping("/update")
	//To update users according to the user validation 
	public ResponseEntity<user> updateUser(@RequestBody @Valid userDTO u){
		
		return new ResponseEntity<>(service.updateUser(u),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{userid}")
	//To delete the user using the userId
	public ResponseEntity<String> deleteUser(@PathVariable int userid) throws GlobalException{
		
		String st = service.deleteUser(userid);
		
		if(st!=null) {
			
			return new ResponseEntity<>(st,HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<>(st,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
		@PutMapping("/phone/{id}/{phone}")
		//method to update phone number of the particular using user id
		public ResponseEntity<String> updatePhone(@PathVariable int id,@PathVariable int userphone) throws GlobalException{
			
			return new ResponseEntity<>(service.updatePhone(id, userphone),HttpStatus.OK);
			
		}
		
		@PutMapping("/allotroom/{userid}/{roomid}")
		//consuming the allotRoom method using user id and roomid 
		public ResponseEntity<String> allotRoom(@PathVariable int userid,@PathVariable int roomid) throws GlobalException{
			
			return new ResponseEntity<>(service.allotRoom(userid, roomid),HttpStatus.OK);
			
		}
		
		@PutMapping("/updatefee/{userid}/{userfee}")
		//consuming the updateFee method using user id
		public ResponseEntity<String> updateFee(@PathVariable int userid,@PathVariable int userfee) throws GlobalException{
			
			return new ResponseEntity<>(service.updateFee(userid, userfee),HttpStatus.ACCEPTED);
			
		}
}
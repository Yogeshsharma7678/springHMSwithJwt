package com.HMS.controller;

/*Room controller class to consume all the method related to 
 * room and map with the server
 */
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HMS.dto.roomDTO;
import com.HMS.exception.GlobalException;
import com.HMS.model.room;
import com.HMS.serviceImpl.roomServiceImpl;

@RestController
@RequestMapping("/room")
public class roomController {

	@Autowired
	//injecting the roomServiceImpl
	private roomServiceImpl service;
	
	@PostMapping("/post")
	
	//consuming the addRoom() method
	public ResponseEntity<room> addRoom(@RequestBody @Valid roomDTO r){
		
		return new ResponseEntity<>(service.addRoom(r),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/get")
	
	//method to get room's details
	public ResponseEntity<List<room>> getRoom(){
		
		List<room> rl = service.getRoom();
		
		return new ResponseEntity<>(rl,HttpStatus.OK);
	}

	@PutMapping("/update")
	
	//consume update method to update details of room
	public ResponseEntity<room> updateRoom(@RequestBody @Valid roomDTO r){
		
		return new ResponseEntity<>(service.updateRoom(r),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete")
	
	//Deleting the room from the hostel
	public ResponseEntity<String> deleteRoom(@PathVariable int roomid) throws GlobalException{
		
		String st = service.deleteRoom(roomid);
	
		if(st!=null) {
			
			return new ResponseEntity<>(st , HttpStatus.OK);
		}
		else {
			
			throw new GlobalException("something wrong");
		}
	 
	}
	
}










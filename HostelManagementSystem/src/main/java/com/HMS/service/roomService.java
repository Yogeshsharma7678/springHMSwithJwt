package com.HMS.service;

//roomService interface to declare all the methods to implement crud operations

import java.util.List;

import com.HMS.dto.roomDTO;
import com.HMS.exception.GlobalException;
import com.HMS.model.room;

public interface roomService {

	public room addRoom(roomDTO r);
	
	public room updateRoom(roomDTO r);
	
	public List<room> getRoom();
	
	public String deleteRoom(int roomid) throws GlobalException;

	
}

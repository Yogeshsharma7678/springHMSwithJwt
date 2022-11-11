package com.HMS.serviceImpl;

//implementing all the methods of roomService and save data to databases  

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HMS.dto.roomDTO;
import com.HMS.exception.GlobalException;
import com.HMS.model.room;
import com.HMS.repository.roomRepositoy;
import com.HMS.service.roomService;
import com.HMS.util.valueMapper;

@Service
//aquaring all the properties of roomService 
public class roomServiceImpl implements roomService {

	@Autowired
	private roomRepositoy repo;
	
	@Override
	public room addRoom(roomDTO r) {
		// TODO Auto-generated method stub

		room r1=valueMapper.convertToRoom(r);
		
		return repo.save(r1);
	}

	@Override
	public room updateRoom(roomDTO r) {
		// TODO Auto-generated method stub
        room r1=valueMapper.convertToRoom(r);
		
		return repo.save(r1);
		
	}

	@Override
	public List<room> getRoom() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public String deleteRoom(int roomid) throws GlobalException {
		// TODO Auto-generated method stub
		
		room r1 = repo.findByRoomId(roomid);
		if(r1!=null) {
			
			repo.delete(r1);
			return "deleted";
		}
		else {
			
			throw new GlobalException("room not fouund");
		}
	}

}

package com.HMS.repository;

//Room Repository interface which extend the properties of jparepository to create beans 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.HMS.model.room;

@Repository
public interface roomRepositoy extends JpaRepository<room, Integer> {

	//Query to find room by room id
	@Query(value="select * from room where room_id=?1",nativeQuery=true)
	room findByRoomId(int roomid);

}

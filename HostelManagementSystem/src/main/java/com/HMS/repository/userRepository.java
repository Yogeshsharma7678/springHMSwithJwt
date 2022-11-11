package com.HMS.repository;

//User Repository interface which extend the properties of jparepository to create beans 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.HMS.model.user;

@Repository
public interface userRepository extends JpaRepository<user, Integer>{


	//query to find user by user id
	@Query(value = "select * from user where user_id=?1 ",nativeQuery=true)
	user findByUserId(int userid);

	@Transactional
	@Modifying
	//Query to update phone using user id 
	@Query(value = "update user set user_phone=:userphone where user_id =:userid")
	int updatePhone(int userid, int userphone);

	@Transactional
	@Modifying
	//Query to allot room to the specific user
	@Query(value = "update user set user_room_room_id=:roomid where user_id=:userid")
	int allotRoom(int userid, int roomid);

	@Transactional 
	@Modifying
	//Query to update user fees
	@Query(value="update user set user_fee=:userFee where user_id=:userid")
	int updateFee(int userid,int userFee);
	
	//Query to find user by user name
	@Query(value="select * from user where user_name=?1",nativeQuery=true)
	user findByUserName(String username);

}

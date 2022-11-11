package com.HostelmanagementSystem;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.HMS.exception.GlobalException;
import com.HMS.serviceImpl.userServiceImpl;

@SpringBootTest
class HmswithspringApplicationTests {

	@Autowired
	private userServiceImpl service;
	
	@Test
	void testDelete()throws GlobalException {
		
		var expected="deleted";
			var actual=service.deleteUser(4);
			assertSame(expected,actual);
		
	}
	@Test
	void testGet()throws GlobalException {
		
		var expected="getting details";
			var actual=service.getUser();
			assertSame(expected,actual);
		
	}

}
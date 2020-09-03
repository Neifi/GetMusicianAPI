package com.thebigcode.GetMusicianAPI;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thebigcode.GetMusicianAPI.band.Band;
import com.thebigcode.GetMusicianAPI.band.Bands;
import com.thebigcode.GetMusicianAPI.user.User;
import com.thebigcode.GetMusicianAPI.user.Users;

@SpringBootTest
class GetMusicianApiApplicationTests {
	
	@Autowired
	private Users users;
	
	@Autowired
	private Bands bands;
	
	@Test
	void fetchUsers() {
		
		
	}
	
	void fetchBands() {
		
		

	}
	
	void insertUser() {
		
	}

}

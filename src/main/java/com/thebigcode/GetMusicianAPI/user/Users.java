package com.thebigcode.GetMusicianAPI.user;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface Users extends MongoRepository<User, String>{

	User findByName(String name);

}

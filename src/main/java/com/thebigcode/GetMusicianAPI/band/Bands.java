package com.thebigcode.GetMusicianAPI.band;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface Bands extends MongoRepository<Band,String>{

}

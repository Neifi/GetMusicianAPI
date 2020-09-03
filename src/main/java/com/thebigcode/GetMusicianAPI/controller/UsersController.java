package com.thebigcode.GetMusicianAPI.controller;

import java.util.List;
import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.MongoPersistentProperty;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thebigcode.GetMusicianAPI.band.Band;
import com.thebigcode.GetMusicianAPI.band.Bands;
import com.thebigcode.GetMusicianAPI.user.User;
import com.thebigcode.GetMusicianAPI.user.Users;

@RestController
public class UsersController {
	
	@Autowired
	private Users users;
	
	public ResponseEntity<List<User>> getAllBands(){
		List<User> bandList = users.findAll();
		
		if(bandList == null) {
			return ResponseEntity.notFound().build();
		}else if(bandList.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(bandList);
	}
	
	private static final String TEMPLATE = "Hello, %s!";
	
	@GetMapping("/")
	public HttpEntity<User> greeting(
			@RequestParam(value = "name", defaultValue = "World") String name) {

			User usr = users.findByName(name);
			usr.add(linkTo(methodOn(UsersController.class).greeting(name)).withSelfRel());
			
			return new ResponseEntity<>(usr, HttpStatus.OK);
		}
	
	@PostMapping("/")
	public HttpEntity<User> signup(
			@RequestParam(value = "name", defaultValue = "World") String name) {
		
		User usr = new User(String.format(TEMPLATE, name));
		usr.add(linkTo(methodOn(UsersController.class).greeting(name)).withSelfRel());
		users.save(usr);
		return new ResponseEntity<>(usr, HttpStatus.CREATED);
	}
	
	
	/**
	 * Writes the given {@link Map} using the given {@link MongoPersistentProperty} information.
	 *
	 * @param map must not {@literal null}.
	 * @param property must not be {@literal null}.
	 * @return
	 */
	protected Bson createMap(Map<Object, Object> map, MongoPersistentProperty property) {

	  if (!property.isDbReference()) {
	    return writeMapInternal(map, new Document(), property.getTypeInformation());
	  }
	  Document document = new Document();
	  for (Map.Entry<Object, Object> entry : map.entrySet()) {
	    Object key = entry.getKey();
	    Object value = entry.getValue();
	    if (conversions.isSimpleType(key.getClass())) {
	      String simpleKey = prepareMapKey(key.toString());
	      document.put(simpleKey, value != null ? createDBRef(value, property) : null);
	    } else {
	      throw new MappingException("Cannot use a complex object as a key value.");
	    }
	  }
	  return document;
	}
	
}

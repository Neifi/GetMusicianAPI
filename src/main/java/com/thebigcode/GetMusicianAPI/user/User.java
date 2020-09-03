package com.thebigcode.GetMusicianAPI.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thebigcode.GetMusicianAPI.band.Band;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Document
public class User extends RepresentationModel<User>{
	
	private final String content;
	
	@Indexed
	private String id;
	private String name;
	@JsonCreator
	public User(@JsonProperty("content") String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
}

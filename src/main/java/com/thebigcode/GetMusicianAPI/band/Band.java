package com.thebigcode.GetMusicianAPI.band;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Band extends RepresentationModel<Band>{
	
	private final String content;
	
	@JsonCreator
	public Band(@JsonProperty("content") String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
}

package com.jhinds.hinds;

import org.springframework.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class Resource {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Entity> get(@RequestHeader("Authorization") String authorization,
			@PathVariable("account") String account) {
	
		return (ResponseEntity<Entity>) ResponseEntity.ok();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestHeader("Authorization") String authorization,
			@PathVariable("account") String account) {
		
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Entity> post(@RequestHeader("Authorization") String authorization,
			@PathVariable("account") String account,
			@RequestBody Entity entity) {
		
		return (ResponseEntity<Entity>) ResponseEntity.ok();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Entity> put(@RequestHeader("Authorization") String authorization,
			@PathVariable("account") String account,
			@RequestBody Entity entity) {
		
		return (ResponseEntity<Entity>) ResponseEntity.ok();
	}	
	
	
	
	

}

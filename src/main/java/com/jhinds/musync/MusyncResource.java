package com.jhinds.musync;

import com.jhinds.musync.service.MusyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.jhinds.musync.entities.Playlist;
import com.jhinds.musync.entities.Song;
@RestController
public class MusyncResource {
	
	@Autowired
	MusyncService musyncService;
	
	@RequestMapping(value = "/music/song/{id}", method = RequestMethod.GET)
	public ResponseEntity<Song> getSong(@RequestHeader("Authorization") String authorization,
			@PathVariable("id") String id) {
	
		return (ResponseEntity<Song>) ResponseEntity.ok();
	}
	
	@RequestMapping(value = "/music/playlist/{id}", method = RequestMethod.GET)
	public ResponseEntity<Playlist> getPlaylist(@RequestHeader("Authorization") String authorization,
			@PathVariable("id") String id) {
	
		return (ResponseEntity<Playlist>) ResponseEntity.ok();
	}
	
	@RequestMapping(value = "/music/song/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteSong(@RequestHeader("Authorization") String authorization,
			@PathVariable("id") String id) {
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/music/playlist/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletePlaylist(@RequestHeader("Authorization") String authorization,
			@PathVariable("id") String id) {
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/music/playlist", method = RequestMethod.POST)
	public ResponseEntity<Song> createPlaylist(@RequestHeader("Authorization") String authorization,
			@PathVariable("account") String account,
			@RequestBody Song entity) {
		
		return (ResponseEntity<Song>) ResponseEntity.ok();
	}
	
	@RequestMapping(value = "/music/song", method = RequestMethod.PUT)
	public ResponseEntity<Song> addSong(@RequestHeader("Authorization") String authorization,
			@PathVariable("account") String account,
			@RequestBody Song entity) {
		
		return (ResponseEntity<Song>) ResponseEntity.ok();
	}	
	
	
	
	

}

package com.jhinds.musync.entities;

import org.springframework.data.annotation.Id;


public class Song {
	
	@Id
	private String id;
	private String name;
	private String artist;
	private String runningTime;
	private String album;

	public Song(String id, String name, String artist, String runningTime, String album) {
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.runningTime = runningTime;
		this.album = album;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}

}

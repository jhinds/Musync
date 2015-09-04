package com.jhinds.musync;

import org.springframework.data.annotation.Id;


public class Song {
	
	@Id
	private String id;
	private String name;
	private String artist;
	private String runningTime;
	private String album;
	
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

package com.jhinds.musync.entities;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Playlist {
	
	@Id
	private String id;
	private String name;
	private List<Song> songList;

	public Playlist(String id, String name, List<Song> songList) {
		this.id = id;
		this.name = name;
		this.songList = songList;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Song> getSongList() {
		return songList;
	}
	public void setSongList(List<Song> songList) {
		this.songList = songList;
	}
	

}

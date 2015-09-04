package com.jhinds.hinds;

import org.mockito.InjectMocks;

import com.jhinds.musync.Resource;

import entities.Song;

import org.junit.Test;
/**
 * Unit test for simple App.
 */
public class AppTest {

	@InjectMocks
	private Resource resource;

	@Test
	public void testGetEntity() {
		Song entity = new Song();
		
	}
}

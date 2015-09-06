package com.jhinds.musync;

import org.mockito.InjectMocks;

import com.jhinds.musync.entities.Song;

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

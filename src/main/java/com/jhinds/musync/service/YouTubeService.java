package com.jhinds.musync.service;

import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.youtube.PlaylistLinkEntry;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jonathanhinds on 9/6/15.
 */
public class YouTubeService {

    YouTubeService service = new YouTubeService(System.getenv("YOUTUBE_CLIENT_ID"), System.getenv("YOUTUBE_DEVELOPER_KEY"));
    String feedUrl = "http://gdata.youtube.com/feeds/api/users/default/playlists";

    public void createPlaylist(String title) throws MalformedURLException {
        PlaylistLinkEntry linkEntry = new PlaylistLinkEntry();
        linkEntry.setTitle(new PlainTextConstruct(title));

        PlaylistLinkEntry createdEntry = service.insert(new URL(feedUrl), linkEntry);
    }

}

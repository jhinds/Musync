package com.jhinds.musync.service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.util.Lists;
import com.google.api.services.youtube.YouTube;
import com.google.gdata.client.youtube.YouTubeService;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.youtube.PlaylistEntry;
import com.google.gdata.data.youtube.PlaylistLinkEntry;
import com.google.gdata.data.youtube.VideoEntry;
import com.google.gdata.util.ServiceException;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by jonathanhinds on 9/6/15.
 */
public class YouTubeMusyncService {

    private static YouTube youTube;
    public static final String VIDEO_ID =  "HALO";



    public void create() {
        List<String> scopes = Lists.newArrayList("https://www.googleapis.com/auth/youtube");

    }




    YouTubeService service = new YouTubeService(System.getenv("YOUTUBE_CLIENT_ID"), System.getenv("YOUTUBE_DEVELOPER_KEY"));
    String feedUrl = "http://gdata.youtube.com/feeds/api/users/default/playlists";

    public void createPlaylist(String title) throws IOException, ServiceException {
        PlaylistLinkEntry playlistLinkEntry = new PlaylistLinkEntry();
        playlistLinkEntry.setTitle(new PlainTextConstruct(title));

        PlaylistLinkEntry createdEntry = service.insert(new URL(feedUrl), playlistLinkEntry);
    }

    public void addVideoToPlaylist() throws IOException, ServiceException {
        PlaylistLinkEntry playlistLinkEntry = new PlaylistLinkEntry();
        String playlistUrl = playlistLinkEntry.getFeedUrl();
        String videoEntryUrl = "http://gdata.youtube.com/feeds/api/videos/ADos_xW4_J0";
        VideoEntry videoEntry = service.getEntry(new URL(videoEntryUrl), VideoEntry.class);

        PlaylistEntry playlistEntry = new PlaylistEntry(videoEntry);
        service.insert(new URL(playlistUrl), playlistEntry);
    }

    public void removeVideoFromPlaylist() throws IOException, ServiceException {
        PlaylistLinkEntry playlistLinkEntry = new PlaylistLinkEntry();
        playlistLinkEntry.delete();
    }



}

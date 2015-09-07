package com.jhinds.musync.service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.services.youtube.model.PlaylistSnippet;
import com.google.api.services.youtube.model.PlaylistStatus;
import com.google.api.services.youtube.model.Playlist;
import com.google.common.collect.Lists;
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

import com.jhinds.musync.utils.*;

/**
 * Created by jonathanhinds on 9/6/15.
 */
public class YouTubeMusyncService {

    private static YouTube youTube;
    public static final String VIDEO_ID =  "HALO";



    public void create(String title, String privacyStatus) throws Exception {
        List<String> scopes = Lists.newArrayList("https://www.googleapis.com/auth/youtube");
        Credential credential = Auth.authorize(scopes, "playlistupdates");

        youTube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, credential)
                .setApplicationName("Musync")
                .build();

        String playlistId = insertPlaylist(title, privacyStatus);

    }

    private String insertPlaylist(String title, String privacyStatus) throws Exception {
        PlaylistSnippet playlistSnippet = new PlaylistSnippet();
        playlistSnippet.setTitle(title);
        PlaylistStatus playlistStatus = new PlaylistStatus();
        playlistStatus.setPrivacyStatus(privacyStatus);

        Playlist youTubePlaylist = new Playlist();
        youTubePlaylist.setSnippet(playlistSnippet);
        youTubePlaylist.setStatus(playlistStatus);

        YouTube.Playlists.Insert playlistInsertion = youTube.playlists().insert("snippet,status", youTubePlaylist);
        Playlist playlistInserted = playlistInsertion.execute();

        return  playlistInserted.getId();
    }




}

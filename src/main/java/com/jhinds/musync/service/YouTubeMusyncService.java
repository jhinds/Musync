package com.jhinds.musync.service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.services.youtube.model.*;
import com.google.common.collect.Lists;
import com.google.api.services.youtube.YouTube;

import java.io.IOException;
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

    private static String insertPlaylistItem(String playlistId, String videoId) throws IOException {

        ResourceId resourceId = new ResourceId();
        resourceId.setKind("youtube#video");
        resourceId.setVideoId(videoId);

        PlaylistItemSnippet playlistItemSnippet = new PlaylistItemSnippet();
        playlistItemSnippet.setTitle("First video in the test playlist");
        playlistItemSnippet.setPlaylistId(playlistId);
        playlistItemSnippet.setResourceId(resourceId);


        PlaylistItem playlistItem = new PlaylistItem();
        playlistItem.setSnippet(playlistItemSnippet);


        YouTube.PlaylistItems.Insert playlistItemsInsertCommand =
                youTube.playlistItems().insert("snippet,contentDetails", playlistItem);
        PlaylistItem returnedPlaylistItem = playlistItemsInsertCommand.execute();

        return returnedPlaylistItem.getId();

    }




}

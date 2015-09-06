package com.jhinds.musync;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MusyncService {

    public List<Song> getPandoraFavorites() {
        return new LinkedList<Song>();

    }

    public List<Playlist> getSpotifyPlaylists() {
        return new LinkedList<Playlist>();

    }

    public Playlist createPlaylist() {
        return new Playlist();

    }

    public Playlist addSongToPlaylist() {
        return new Playlist();

    }

    public Playlist getSpotifyPlayist() {

        return new Playlist();
    }



}

package com.jhinds.musync;

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

    public String partnerLogin() {
        HttpHeaders requestHeaders = new HttpHeaders();
        List<MediaType> mediaTypes = new ArrayList<MediaType>();
        mediaTypes.add(MediaType.TEXT_PLAIN);
        requestHeaders.setAccept(mediaTypes);
        Map<String, String> body = new LinkedHashMap<String, String>();
        body.put("username", "pandora one");
        body.put("password", "TVCKIBGS9AO9TSYLNNFUML0743LH82D");
        body.put("deviceModel", "D01");
        body.put("version", "5");
        HttpEntity<Map> httpEntity = new HttpEntity<Map>(body, requestHeaders);
        String response = new RestTemplate().exchange(
                "https://internal-tuner.pandora.com/services/json/?method=auth.partnerLogin",
                    HttpMethod.POST, httpEntity, String.class).getBody();
        return new JSONObject(response).getJSONObject("result").get("partnerAuthToken").toString();
    }

    public void userLogin(){

    }

}

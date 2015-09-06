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

    public Map<String, String> partnerLogin() {
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
        Map<String, String> result = new LinkedHashMap<String, String>();
        String partnerAuthToken = new JSONObject(response).getJSONObject("result").get("partnerAuthToken").toString();
        String partnerId = new JSONObject(response).getJSONObject("result").get("partnerId").toString();
        result.put("partnerAuthToken", partnerAuthToken);
        result.put("partnerId", partnerId);
        return result;
    }

    public String userLogin(String username, String password){
        HttpHeaders requestHeaders = new HttpHeaders();
        List<MediaType> mediaTypes = new ArrayList<MediaType>();
        mediaTypes.add(MediaType.TEXT_PLAIN);
        requestHeaders.setAccept(mediaTypes);
        Map<String, String> body = new LinkedHashMap<String, String>();
        body.put("loginType", "user");
        body.put("username", username);
        body.put("password", password);
        body.put("partnerAuthToken", partnerLogin().get("partnerAuthToken"));
        HttpEntity<Map> httpEntity = new HttpEntity<Map>(body, requestHeaders);
        String response = new RestTemplate().exchange(
                "https://internal-tuner.pandora.com/services/json/?method=auth.userLogin&partner_id=" + partnerLogin().get("partnerId"),
                HttpMethod.POST, httpEntity, String.class).getBody();
        return new JSONObject(response).getJSONObject("result").get("userId").toString();

    }

}

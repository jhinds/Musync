package com.jhinds.musync;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.methods.AddTrackToPlaylistRequest;
import com.wrapper.spotify.methods.PlaylistCreationRequest;
import com.wrapper.spotify.methods.TrackSearchRequest;
import com.wrapper.spotify.models.Page;
import com.wrapper.spotify.models.Playlist;
import com.wrapper.spotify.models.Track;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jonathanhinds on 9/6/15.
 */
public class SpotifyService {

    private String spotifyURI;
    private String spotifyId;
    private String spotifyCategoryId;
    private String spotifyUserId;
    private String spotifyURL;

    private String clientId = System.getenv("SPOTIFY_CLIENT_ID");
    private String clientSecret = System.getenv("SPOTIFY_CLIENT_SECRET");

    Api api = Api.builder()
            .clientId(clientId)
            .clientSecret(clientSecret)
            .build();

    public void createPlaylist(String userId, String title) {
        final PlaylistCreationRequest request = api.createPlaylist(userId, title)
                .publicAccess(true)
                .build();

        try {
            final Playlist playlist = request.get();

            System.out.println("You just created this playlist!");
            System.out.println("Its title is " + playlist.getName());
        } catch (Exception e) {
            System.out.println("Something went wrong!" + e.getMessage());
        }
    }

    public void addTrackToPlaylist(List<String> tracks, int insertIndex) {
        final List<String> tracksToAdd = tracks;

        final AddTrackToPlaylistRequest request = api.addTracksToPlaylist("thelinmichael", "5ieJqeLJjjI8iJWaxeBLuK", tracksToAdd)
                .position(insertIndex)
                .build();

        try {
            request.get();
        } catch (Exception e) {
            System.out.println("Something went wrong!" + e.getMessage());
        }
    }

    public void searchForTrack(String song) {
        final TrackSearchRequest request = api.searchTracks(song).market("US").build();

        try {
            final Page<Track> trackSearchResult = request.get();
            System.out.println("I got " + trackSearchResult.getTotal() + " results!");
        } catch (Exception e) {
            System.out.println("Something went wrong!" + e.getMessage());
        }
    }

}

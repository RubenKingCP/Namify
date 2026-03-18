package org.example.model;

public class UserAccount extends Account {
    Library library;

    Playlist createPlaylist(String playlistName) {
        // Create Playlsit
        return new Playlist("");
    }

    void likeSong(String songId) {
        // Like a song
    }

    void login() {
    }

    void logout() {
    }

    void register() {
    }

    void viewProfile() {
        // View user profile
    }

    void downloadSong(String songId) {
        // Download a song
    }
    
    void followArtist(String artistId) {
        // Follow an artist
    }
}

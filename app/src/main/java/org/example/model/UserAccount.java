package org.example.model;

public class UserAccount {
    String userId;
    String userName;
    String email;
    String password;
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
}

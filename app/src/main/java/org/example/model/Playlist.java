package org.example.model;

public class Playlist extends Asset {
    Song[] songs;
    String name;

    public Playlist(String name) {
        this.name = name;
        this.songs = new Song[100]; // Example size, can be dynamic
    }

    void addSong(Song song) {
        // Add song to playlist
    }

    void removeSong(String songId) {
        // Remove song from playlist
    }

    void changeName(String newName) {
        // Change playlist name
    }

    void changeOrder() {
        // Try for drag and drop
    }

    @Override
    public void play() {
        // Play the playlist
    }

    public void playSong() {
        // Play a specific song from the playlist
    }
}

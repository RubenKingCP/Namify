package org.example.model;

public class Artist extends Asset {
    String name;
    String genre;
    Song[] songs;

    // Add stuff 

    public Artist(String name, String genre) {
        // Get from database
    }

    public void addSong(Song song) {
        // Add song to artist's list
    }

    public void removeSong(String songId) {
        // Remove song from artist's list
    }

    @Override
    public void play() {
        // Play the artist's songs
    }
}

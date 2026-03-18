package org.example.model;

public class Album extends Asset {
    Song[] songs;
    Artist artist;

    public Album(Song[] songs, Artist artist) {
        // Get from database
        this.songs = songs;
        this.artist = artist;
    }

    @Override
    public void play() {
        // Play the album
    }
}

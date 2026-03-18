package org.example.model;

import java.util.Arrays;
import java.util.List;

public class Library {
    Asset[] libraryAssets;

    public Library() {
        // Get from database
        this.libraryAssets = new Asset[100]; // Example size, can be dynamic
    }

    void addPlaylist(Playlist playlist) {
        // Add playlist to library
    }

    void removePlaylist(String playlistName) {
        // Remove playlist from library
    }

    void changePlaylistName(String oldName, String newName) {
        // Change playlist name
    }

    void changePlaylistOrder() {
        // Try for drag and drop
    }

    public List<Asset> getAssets() {
        // Search for songs, albums, artists, and playlists
        return Arrays.asList(libraryAssets);
    }
}

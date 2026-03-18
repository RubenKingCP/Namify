package org.example.controller;

import org.example.model.Playlist;
import org.example.model.Song;
import org.example.view.PlaylistView;

public class PlaylistController {
    private PlaylistView view;
    private Playlist model;

    public PlaylistController(PlaylistView playlistView, Playlist playlist) {
        this.view = playlistView;
        this.model = playlist;
    }

    public void loadPlaylistData() {
        // Load data for the playlist view
    }

    public void onSongClick() {
        // Handle song click events in the playlist view
        model.playSong();
    }
}

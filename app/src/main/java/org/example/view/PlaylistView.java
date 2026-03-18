package org.example.view;

import org.example.controller.PlaylistController;

public class PlaylistView {
    
    private PlaylistController playListController;

    public PlaylistView() {
        // Controller logic for PlayListView
    }

    public void setController(PlaylistController playListController) {
        this.playListController = playListController;
    }

    void displayPlaylist() {
        // Logic to display playlist view
    }

    void onSongSelected() {
        // Logic to handle song selection in playlist view
    }
}

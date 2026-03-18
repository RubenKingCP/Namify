package org.example.controller;

import org.example.view.DiscoverView;

public class DiscoverController {
    private DiscoverView discoverView;

    public DiscoverController(DiscoverView discoverView) {
        this.discoverView = discoverView;
        this.discoverView.setController(this);
    }

    public void onDiscoverGenreSelected() {
        // Handle discover genre selection
    }
}

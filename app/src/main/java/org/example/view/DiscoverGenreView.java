package org.example.view;

import org.example.controller.DiscoverController;
import org.example.model.Genre;

public class DiscoverGenreView {
    private DiscoverController discoverController;
    private Genre genre;

    public DiscoverGenreView(Genre genre) {
        // Initialize discover genre view
        this.genre = genre;
    }

    public void setController(DiscoverController discoverController) {
        this.discoverController = discoverController;
    }

    public void display() {
        // Display discover genre view  
    }

}

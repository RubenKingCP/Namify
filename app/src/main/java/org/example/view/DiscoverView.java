package org.example.view;

import org.example.controller.DiscoverController;
import org.example.model.Genre;
import java.util.List;

public class DiscoverView {
    private DiscoverController discoverController;
    public DiscoverView() {
        // Initialize discover view
    }

    public void setController(DiscoverController discoverController) {
        this.discoverController = discoverController;
    }

    public void displayGenres(List<Genre> genres) {
        // Display discover view
        for (Genre genre : genres) {
            // Display each genre in the discover view
            DiscoverGenreView genreView = new DiscoverGenreView(genre);
            genreView.setController(discoverController);
            genreView.display();
        }
    }
}

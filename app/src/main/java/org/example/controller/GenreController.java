package org.example.controller;

import org.example.view.GenreView;

public class GenreController {
    private GenreView genreView;

    public GenreController(GenreView genreView) {
        this.genreView = genreView;
        this.genreView.setController(this);
    }

    public void onAssetSelected() {
        // Handle asset selection in genre view
    }
}

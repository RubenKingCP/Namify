package org.example.controller;

import java.util.List;

import org.example.model.Library;
import org.example.model.Asset;
import org.example.view.LibraryView;

public class LibraryController {
    private LibraryView libraryView;
    private Library library;

    public LibraryController(LibraryView libraryView, Library library) {
        this.libraryView = libraryView;
        this.library = library;
        this.libraryView.setController(this);
    }

    public void loadAssets() {
        List<Asset> assets = library.getAssets();
        libraryView.displayAssets(assets);
    }

    public void onAssetClick(Asset asset) {
        // Handle click events for library assets (songs, albums, artists)
    }
}

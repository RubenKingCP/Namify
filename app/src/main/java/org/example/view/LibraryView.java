package org.example.view;

import java.util.List;

import org.example.controller.LibraryController;
import org.example.model.Asset;


public class LibraryView {
    private LibraryController libraryController;

    public LibraryView() {
        // Initialize library view
    }
    
    public void setController(LibraryController libraryController) {
        this.libraryController = libraryController;
    }

    public void displayAssets(List<Asset> assets) {
        // Display library assets (songs, albums, artists)
        for (Asset asset : assets) {
            // Display each asset in the library
            LibraryAssetView assetView;
            if (asset instanceof org.example.model.Album) {
                assetView = new LibraryAlbumAssetView(asset);
            } else if (asset instanceof org.example.model.Artist) {
                assetView = new LibraryArtistAssetView(asset);
            } else {
                continue; // Skip unknown asset types
            }
            assetView.setController(libraryController);
            assetView.display();
        }
    }
}

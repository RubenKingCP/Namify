package org.example.view;

import org.example.controller.LibraryController;
import org.example.model.Asset;

public abstract class LibraryAssetView {
    
    protected LibraryController libraryController;
    protected Asset asset;

    public LibraryAssetView(Asset asset) {
        this.asset = asset;
    }

    public void setController(LibraryController libraryController) {
        this.libraryController = libraryController;
    }

    public abstract void display();

    public void onClick() {
        // Handle click events for library asset view
        libraryController.onAssetClick(asset);
    }
}

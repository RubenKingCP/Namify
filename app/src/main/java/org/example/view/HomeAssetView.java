package org.example.view;

import org.example.controller.HomeController;
import org.example.model.Asset;

public abstract class HomeAssetView {
    
    protected HomeController homeController;
    protected Asset asset;

    public HomeAssetView(Asset asset) {
        this.asset = asset;
    }

    public void setController(HomeController homeController) {
        this.homeController = homeController;
    }

    public abstract void display();

    public void onClick() {
        // Handle click events for home asset view
        homeController.onAssetClick(asset);
    }
}

package org.example.view;

import org.example.controller.TopBarController;
public class TopBarView {
    
    private TopBarController controller;


    public TopBarView() {
        // Initialize top bar view
    }

    public void setController(TopBarController controller) {
        this.controller = controller;
    }

    public void onSearchButtonClicked() {
        // Handle search button click
        controller.onSearchButtonClicked();
    }

    public void onBackButtonClicked() {
        // Handle back button click
        controller.onBackButtonClicked();}

    public void onForwardButtonClicked() {
        // Handle forward button click
        controller.onForwardButtonClicked();
    }

    public void onDiscoverButtonClicked() {
        // Handle menu button click
        controller.onDiscoverButtonClicked();
    }

    public void onExitButtonClicked() {
        // Handle exit button click
        controller.onExitButtonClicked();
    }

    public void onSettingsButtonClicked() {
        // Handle settings button click
        controller.onSettingsButtonClicked();
    }

    public void onMinimizeButtonClicked() {
        // Handle minimize button click
        controller.onMinimizeButtonClicked();
    }

    public void onProfileButtonClicked() {
        // Handle profile button click
        controller.onProfileButtonClicked();
    }
}

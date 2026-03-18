package org.example.controller;

import org.example.view.TopBarView;
public class TopBarController {
    private TopBarView view;

    public TopBarController(TopBarView view) {
        this.view = view;
        this.view.setController(this);
    }

    public void onSearchButtonClicked() {
        // Handle search button click
    }

    public void onBackButtonClicked() {
        // Handle back button click
    }

    public void onForwardButtonClicked() {
        // Handle forward button click
    }

    public void onDiscoverButtonClicked() {
        // Handle menu button click
    }

    public void onExitButtonClicked() {
        // Handle exit button click
    }

    public void onSettingsButtonClicked() {
        // Handle settings button click
    }

    public void onMinimizeButtonClicked() {
        // Handle minimize button click
    }

    public void onProfileButtonClicked() {
        // Handle profile button click
    }
}

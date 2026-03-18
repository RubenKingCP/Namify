package org.example.view;

import org.example.controller.MusicPlayerController
;
public class MusicPlayerView {
    private MusicPlayerController controller;

    public MusicPlayerView () {
        // Initialzie
    }

    public void setController(MusicPlayerController controller) {

    }

    void onPlayButtonClicked() {
        controller.onPlayButtonClicked();
    }

    void onPauseButtonClicked() {
        controller.onPauseButtonClicked();
    }

    void onNextButtonClicked() {
        controller.onNextButtonClicked();
    }

    void onPreviousButtonClicked() {
        controller.onPreviousButtonClicked();
    }

    void onVolumeChanged() {
        controller.onVolumeChanged();
    }

    void onLikeButtonClicked() {
        controller.onLikeButtonClicked();
    }

    void onRepeatButtonClicked() {
        // Handle repeat button click
        controller.onRepeatButtonClicked();
    }

    void onShuffleButtonClicked() {
        // Handle shuffle button click
        controller.onShuffleButtonClicked();
    }

    public int getVolume() {
        // Get volume from UI
        return 1;
    }
}

package org.example.controller;

import org.example.model.MusicPlayer;
import org.example.view.MusicPlayerView;


public class MusicPlayerController {
    // Initialize music player controller
    private MusicPlayerView view;
    private MusicPlayer model;

    public MusicPlayerController() {
        // Initialize music player controller
        this.view = new MusicPlayerView();
        this.model = new MusicPlayer();

        view.setController(this);
    }

    public void onPlayButtonClicked() {
        model.play();
    }

    public void onPauseButtonClicked() {
        model.pause();
    }

    public void onNextButtonClicked() {
        model.next();
    }

    public void onPreviousButtonClicked() {
        model.previous();
    }

    public void onVolumeChanged() {
        model.setVolume(view.getVolume());
    }

    public void onLikeButtonClicked() {
        model.likeCurrentSong();
    }

    public void onRepeatButtonClicked() {
        // Handle repeat button click
        model.setRepeatMode();
    }

    public void onShuffleButtonClicked() {
        // Handle shuffle button click
        model.setShuffleMode();
    }
}

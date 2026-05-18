package tunix.service;

import tunix.event.EventBus;
import tunix.model.Song;
import tunix.api.SongApiClient;
import tunix.dto.request.SongFormDTO;

public class SongService {
    private final EventBus eventBus;
    private final SongApiClient songApiClient;

    public SongService(EventBus eventBus, SongApiClient songApiClient) {
        this.eventBus = eventBus;
        this.songApiClient = songApiClient;
    }

    public Song uploadSong(SongFormDTO songForm) {
        return songApiClient.uploadSong(songForm).getData().toSong();
    }

}

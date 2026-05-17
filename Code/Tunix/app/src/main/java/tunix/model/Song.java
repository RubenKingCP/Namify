package tunix.model;

public class Song implements ILibraryAsset {
    private final String title;
    private final int songId;
    private final Artist artist;
    private final int duration; // Duration in seconds
    private final String filePathUrl;

    public Song(String title, int songId, Artist artist, int duration, String filePathUrl) {
        this.title = title;
        this.songId = songId;
        this.artist = artist;
        this.duration = duration;
        this.filePathUrl = filePathUrl;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getId() {
        return songId;
    }

    public Artist getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    public String getFilePathUrl() {
        return filePathUrl;
    }
}

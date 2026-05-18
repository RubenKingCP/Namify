package tunixserver.dto.request;

public class SongFormDTO {
    public String title;
    public int artistId;
    public int duration;
    public String filePathIrl;
    public String coverImageUrl;

    public SongFormDTO() {
        
    }

    public String getTitle() {
        return title;
    }

    public int getArtistId() {
        return artistId;
    }
}

package tunix.api;

import tunix.dto.request.SongFormDTO;
import tunix.dto.response.ApiResponse;
import tunix.dto.response.SongResponse;

public class SongApiClient {
    private final ApiClient apiClient;

    public SongApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiResponse<SongResponse> uploadSong(SongFormDTO songFormDTO) {
        return apiClient.post("/songs/upload", songFormDTO, SongResponse.class);
    }
}

@startuml

title Spotify-like Desktop App (Clean Architecture - Fixed)

skinparam classAttributeIconSize 0
skinparam linetype ortho
skinparam packageStyle rectangle
skinparam shadowing false

left to right direction

' =====================================================
' FRONTEND LAYER (WRAPPER)
' =====================================================

package "Frontend" {

    ' =====================================================
    ' MODEL LAYER
    ' =====================================================

    package "Model Layer" {
' -------- ACCOUNT HIERARCHY --------
    abstract class Account {
        # id : String
        # status : Boolean
    }
    class User {
        + fetchUserProfile(userId : int) : User
        + postArtistRequest() : void
        + getUserStatus() : Boolean
        + followArtist(artistId : String) : void
    }
    class Artist {
        + fetchArtist(searchName : String) : List<Artist>
        + fetchSongWarnings(songId : int) : List<String>
        + postIssueWarning() : Boolean
        + postBan() : Boolean
        + checkDuplicateSong() : Boolean
    }
    class Admin {
        + fetchArtistApplications() : List<ArtistRequest>
        + postRejectResponse(applicationId : int) : String
        + postApproveResponse(applicationId : int) : String
    }
    class ArtistRequest{
        - userId : String
        - status : String
        --
        + ArtistRequest(userId : String)
        + getUserId() : String
        + getStatus() : String
    }

    User "1"-->"0...1" ArtistRequest : files
    Admin --> ArtistRequest : inspects

    Account <|-- User
    Account <|-- Artist
    Account <|-- Admin

    interface ILibraryAsset<T extends ILibraryAsset<T>> {
        # title : String
        # id : int
        --
        + fetch(searchName : String) : List<T>
    }

    Song ..|> ILibraryAsset
    Album ..|> ILibraryAsset
    Playlist ..|> ILibraryAsset

    ' -------- MUSIC CORE --------
    class Song {
        - artist : List<Artist> 
        - genre : List<String>
        --
        + Song(title : String, artist : List<Artist>, genres : List<String>)
        + getTitle() : String
        + getArtist() : Artist
        + getGenres() : List<String>
        + postRemoveSong(songId : int) : Boolean
        + fetchSongByPlId(plId : int) : List<Song>
        + fetchSong() : Boolean
        + postSong() : Boolean
    }

    class Album

    Artist "1" --> "0..*" Song : creates
    Artist "1" --> "0..*" Album : creates

    Album "1" *-- "1..*" Song

    ' -------- PLAYLIST SYSTEM --------
    class Playlist {
        # songs : List<Song>
        # creator : User
        - coauthors : List<User>
        --
        + Playlist(creator : User)
        + Playlist(creator : User, coauthors : List<User>)
        + getSongs() : List<Song>
        + getCreator() : User
        + getCoauthors() : List<User>
        # sendHTTPRequest() : Boolean
        # postRemoveSongById(songId : int, playlistId : int) : void
        # checkSongExists(songId : int) : Boolean
        + findByUserId(userId : int) : List<Playlist>
        + getSongsByPlaylistId(playlistId : int) : List<Song>
        + addSong(plId : int, songId : int) : Boolean
        + addToFavorites(songId : int, userId : int) : Boolean
    }

    User "1" --> "0..*" Playlist : owns
    Playlist "0..*" o-- "0..*" Song
    'Album --|> Playlist

    ' -------- LIBRARY --------
    class Library {
        - assets : List<ILibraryAsset>
        + getAssets() : List<ILibraryAsset>
    }

    User "1" *-- "1" Library

    Library "0..*" --> Song
    Library "0..*" --> Album
    Library "0..*" --> Playlist

    ' -------- LISTENING HISTORY --------
    class ListeningHistory { 
        - songs : Song[]
        - Playlists : Playlist[]
        - Albums : Album[]
        --
        + getSongs() : Song[]
        + addSong(song : Song) : void
        + getPlaylists() : Playlist[]
        + addPlaylist(pl : Playlist) : void
        + getAlbums() : Album[]
        + addAlbum(al : Album) : void
    }

    User "1" --> "0..*" ListeningHistory
    ListeningHistory o-- Song
    ListeningHistory o-- Playlist
    ListeningHistory o-- Album

    ' -------- PLAYER --------
    class MusicPlayer {
        - q : Queue<Song>
        --
        + getQueue() : Queue<Song>
        + playMusic(song : Song) : void
        + predictNext() : void 
    }
    MusicPlayer --> Song

    class Favorites 

    Favorites --|> Playlist
    Favorites --* User
    }

    ' =====================================================
    ' VIEW LAYER
    ' =====================================================

    package "View Layer" {

        interface View
        interface LibraryAssetView

        ' Persistent UI
        class TopBarView
        class MusicPlayerView
        class LibraryView

        ' Main screens
        class HomeView
        class SearchView
        class SongView
        class AlbumView
        class PlaylistView
        class ArtistView
        class LoginView

        ' Library sub views
        class LibrarySongView
        class LibraryAlbumView
        class LibraryPlaylistView
        class LibraryArtistView

        View <|.. HomeView
        View <|.. SearchView
        View <|.. SongView
        View <|.. AlbumView
        View <|.. PlaylistView
        View <|.. ArtistView
        View <|.. LoginView

        View <|.. LibraryView

        LibraryAssetView <|.. LibrarySongView
        LibraryAssetView <|.. LibraryAlbumView
        LibraryAssetView <|.. LibraryPlaylistView
        LibraryAssetView <|.. LibraryArtistView

        LibraryView <|.. LibraryAssetView
    }

    ' =====================================================
    ' CONTROLLER LAYER
    ' =====================================================

    package "Controller Layer" {

        class MusicApp

        class TopBarController
        class MusicPlayerController
        class LibraryController

        class HomeController
        class SearchController
        class SongController
        class AlbumController
        class PlaylistController
        class ArtistController
        class LoginController
    }

    ' =====================================================
    ' SERVICE LAYER
    ' =====================================================

    package "Service Layer" {

        class LibraryService
        class PlaybackService
        class SearchService
        class LoginService
    }

    ' =====================================================
    ' API LAYER
    ' =====================================================

    package "API Layer" {

        class ApiClient

        class SongAPI
        class PlaylistAPI
        class AlbumAPI
        class LibraryAPI
        class UserAPI
    }

    ' =====================================================
    ' EVENT SYSTEM
    ' =====================================================

    package "Event System" {

        interface Event
        class EventBus

        class ShowHomeEvent
        class ShowSearchEvent
        class ShowPlaylistEvent
        class ShowSongEvent
        class ShowAlbumEvent
        class PlaySongEvent

        Event <|-- ShowHomeEvent
        Event <|-- ShowSearchEvent
        Event <|-- ShowPlaylistEvent
        Event <|-- ShowSongEvent
        Event <|-- ShowAlbumEvent
        Event <|-- PlaySongEvent
    }

    ' =====================================================
    ' APP BOOTSTRAP
    ' =====================================================

    MusicApp -- TopBarController
    MusicApp -- LibraryController
    MusicApp -- MusicPlayerController
    MusicApp -- HomeView

    ' =====================================================
    ' VIEW → CONTROLLER
    ' =====================================================

    HomeView -- HomeController
    SearchView -- SearchController
    SongView -- SongController
    AlbumView -- AlbumController
    PlaylistView -- PlaylistController
    ArtistView -- ArtistController
    LoginView -- LoginController
    LibraryView -- LibraryController
    TopBarView -- TopBarController
    MusicPlayerView -- MusicPlayerController

    ' =====================================================
    ' CONTROLLER → SERVICE
    ' =====================================================

    HomeController -- EventBus
    SearchController -- SearchService
    LoginController -- LoginService
    LibraryController -- LibraryService
    MusicPlayerController -- PlaybackService

    ' =====================================================
    ' SERVICE → API
    ' =====================================================

    LibraryService -- LibraryAPI
    LibraryService -- UserAPI

    SearchService -- SongAPI
    SearchService -- AlbumAPI
    SearchService -- PlaylistAPI

    PlaybackService -- SongAPI
    PlaybackService -- PlaylistAPI

    LoginService -- UserAPI

    ' =====================================================
    ' API → CLIENT
    ' =====================================================

    SongAPI -- ApiClient
    PlaylistAPI -- ApiClient
    AlbumAPI -- ApiClient
    LibraryAPI -- ApiClient
    UserAPI -- ApiClient

    ' =====================================================
    ' EVENT SYSTEM USAGE
    ' =====================================================

    HomeController ..> EventBus : publish
    SearchController ..> EventBus : publish
    PlaylistController ..> EventBus : publish
    SongController ..> EventBus : publish
    AlbumController ..> EventBus : publish
    LibraryController ..> EventBus : publish

    MusicPlayerController ..> EventBus : subscribe

    ' =====================================================
    ' MODEL USAGE (MINIMAL)
    ' =====================================================

    LibraryService -- Library
    LibraryService -- LibraryAsset
    PlaybackService -- Song
    LoginService -- Account

}
 
left to right direction
package "Spring Backend" <<External System>> {

' =====================================================
' DOMAIN LAYER (ENTITIES)
' =====================================================

package "Domain (Entities)" {

    class Account
    class User
    class Artist
    class Admin
    class Song
    class Album
    class Playlist
    class Library

    Account <|-- User
    Account <|-- Artist
    Account <|-- Admin

    Playlist -- Song
    Album -- Song
    Library -- Song
    Library -- Playlist
    Library -- Album
    User -- Library
}

' =====================================================
' DTO LAYER
' =====================================================

package "DTO Layer" {

    class SongDTO
    class AlbumDTO
    class PlaylistDTO
    class UserDTO
    class ArtistDTO
    class LibraryDTO
}

' =====================================================
' CONTROLLER LAYER (REST API)
' =====================================================

package "Controller Layer (REST)" {

    interface API

    class AccountControllerAPI
    class UserControllerAPI
    class ArtistControllerAPI
    class AdminControllerAPI
    class SongControllerAPI
    class AlbumControllerAPI
    class PlaylistControllerAPI
    class LibraryControllerAPI
    class ListeningHistoryControllerAPI
    class ArtistRequestControllerAPI
}

API <|.. AccountControllerAPI
API <|.. UserControllerAPI
API <|.. ArtistControllerAPI
API <|.. AdminControllerAPI
API <|.. SongControllerAPI
API <|.. AlbumControllerAPI
API <|.. PlaylistControllerAPI
API <|.. LibraryControllerAPI
API <|.. ListeningHistoryControllerAPI
API <|.. ArtistRequestControllerAPI

' =====================================================
' SERVICE LAYER
' =====================================================

package "Service Layer" {

    interface Service

    class AccountService
    class UserService
    class ArtistService
    class AdminService
    class SongService
    class AlbumService
    class PlaylistService
    class LibraryService
    class ListeningHistoryService
    class ArtistRequestService
}

Service <|.. AccountService
Service <|.. UserService
Service <|.. ArtistService
Service <|.. AdminService
Service <|.. SongService
Service <|.. AlbumService
Service <|.. PlaylistService
Service <|.. LibraryService
Service <|.. ListeningHistoryService
Service <|.. ArtistRequestService

' =====================================================
' REPOSITORY LAYER
' =====================================================

package "Repository Layer (JPA)" {

    interface JpaRepository

    class AccountRepository
    class UserRepository
    class ArtistRepository
    class AdminRepository
    class SongRepository
    class AlbumRepository
    class PlaylistRepository
    class LibraryRepository
    class ListeningHistoryRepository
    class ArtistRequestRepository
}

JpaRepository <|.. AccountRepository
JpaRepository <|.. UserRepository
JpaRepository <|.. ArtistRepository
JpaRepository <|.. AdminRepository
JpaRepository <|.. SongRepository
JpaRepository <|.. AlbumRepository
JpaRepository <|.. PlaylistRepository
JpaRepository <|.. LibraryRepository
JpaRepository <|.. ListeningHistoryRepository
JpaRepository <|.. ArtistRequestRepository

' =====================================================
' FLOW: CONTROLLER → SERVICE
' =====================================================

SongControllerAPI -- SongService
PlaylistControllerAPI -- PlaylistService
AlbumControllerAPI -- AlbumService
UserControllerAPI -- UserService
ArtistControllerAPI -- ArtistService
LibraryControllerAPI -- LibraryService
AccountControllerAPI -- AccountService

' =====================================================
' FLOW: SERVICE → REPOSITORY
' =====================================================

SongService -- SongRepository
PlaylistService -- PlaylistRepository
AlbumService -- AlbumRepository
UserService -- UserRepository
ArtistService -- ArtistRepository
LibraryService -- LibraryRepository
AccountService -- AccountRepository

' =====================================================
' SERVICE → DOMAIN
' =====================================================

SongService -- Song
PlaylistService -- Playlist
AlbumService -- Album
UserService -- User
LibraryService -- Library
ArtistService -- Artist
AccountService -- Account

' =====================================================
' CONTROLLER → DTO
' =====================================================

SongControllerAPI -- SongDTO
PlaylistControllerAPI -- PlaylistDTO
AlbumControllerAPI -- AlbumDTO
UserControllerAPI -- UserDTO
ArtistControllerAPI -- ArtistDTO
LibraryControllerAPI -- LibraryDTO

' =====================================================
' CONTROLLER → API layer
' =====================================================
AlbumAPI -- AlbumControllerAPI
SongAPI -- SongControllerAPI
PlaylistAPI -- PlaylistControllerAPI
LibraryAPI -- LibraryControllerAPI
UserAPI -- UserControllerAPI
}
@enduml
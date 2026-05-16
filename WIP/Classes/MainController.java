package WIP.Classes;

public class MainController {
    private static IController mainCur;
    public static void main(String[] args) {
        initialze();
        mainCur = new HomeController();
    }

    public static void initialze(){
        HomeController hcontr = new HomeController();
        
    }

    private static void drawPersistentElements() {

    }

    public static void drawCenter() {
        mainCur.draw();
    }

    public void onPlaylistClicked(){
        mainCur = new PlaylistController();
        drawCenter();
    }
}
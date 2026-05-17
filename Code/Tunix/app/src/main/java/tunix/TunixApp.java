
package tunix;

public class TunixApp {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new TunixApp().getGreeting());
    }
}

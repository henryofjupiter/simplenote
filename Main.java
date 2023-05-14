import java.util.*;

public class Main {
    public static void main(String[] args) {
        Notebook user = new Notebook();
        Scanner scnr = new Scanner(System.in);

        user.menuLoop(scnr);
    }
}

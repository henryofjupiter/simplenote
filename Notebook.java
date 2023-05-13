import java.util.*;

public class Notebook {
    private String userName;
    private String fileName;
    private String noteTitle;
    private String currDate;
    private String currTime;


    public void menuLoop(Scanner scnr) {
        int userInput;

        while (true) {
            displayOptions();
            userInput = scnr.nextInt();

        }
    }
    // displays menu option to user
    public void displayOptions() {
        System.out.println("Notebook Action Options");
        System.out.println("_____________________");
        System.out.println("Choose a action from the below options");
        System.out.println("1. Enter name");
        System.out.println("2. Create new folder");
        System.out.println("3. create new file");
        System.out.println("4. Open a folder/ file");
        System.out.println("5. Delete a folder/ file");
        System.out.println("6. Exit");
    }
}

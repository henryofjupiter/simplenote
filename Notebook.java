import java.util.*;

public class Notebook {
    private String userName;
    private String fileName;
    private String noteTitle;
    private String currDate;
    private String currTime;


    // displays menu option to user
    private void displayOptions() {
        System.out.println("Notebook Action Options");
        System.out.println("_____________________");
        System.out.println("Choose a action from the below options");
        System.out.println("1. Enter name");
        System.out.println("2. Create new folder");
        System.out.println("3. create new file");
        System.out.println("4. Open a folder/ file");
        System.out.println("5. Delete a folder/ file");
        System.out.println("6. Show list of folders/ files");
        System.out.println("7. Exit");
    }

    // handles the main function loop for input
    // calls userInputValidation which is used to handle input validation
    public void menuLoop(Scanner scnr) {
        String userInput;
        while (true) {
            displayOptions();
            userInput = scnr.nextLine();
            userInputValidation(userInput);
        }
    }

    //handles userInput for menu option
    private void userInputValidation(String userInput) {
        if (userInput.equals("1")) {
            System.out.println("Please Enter Your Name");

        }
        else if (userInput.equals("2")) {
            System.out.println("Create a new folder");

        }
        else if (userInput.equals("3")) {
            System.out.println("Create a new file");

        }
        else if (userInput.equals("4")) {
            System.out.println("Open a folder/ file");

        }
        else if (userInput.equals("5")) {
            System.out.println("Delete a folder/ file");

        }
        else if (userInput.equals("6")) {
            System.out.println("Show list of folders/ files");
        }
        else if (userInput.equals("7")) {
            System.out.println("Exit");
        }
        else {
           System.out.println("Please choose menu option");
        }
    }
}

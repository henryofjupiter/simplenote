import java.nio.file.FileAlreadyExistsException;
import java.util.*;
import java.io.File;

public class Notebook {
    private String userName;
    private String fileName;
    private String folderName;
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
    // handle input validation
    public void menuLoop(Scanner scnr) {
        String userInput;
        while (true) {
            displayOptions();
            userInput = scnr.nextLine();

            if (userInput.equals("1")) {
                getUserName(scnr);
            }
            else if (userInput.equals("2")) {
                createNewFolder(scnr);

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

    private void getUserName(Scanner scnr)  {
        System.out.println("Enter your name");
        userName = scnr.nextLine();
    }

    // Creates folder & throws exception and prompts for user input if folder already exists
    private void createNewFolder(Scanner scnr) {
        System.out.println("Enter file name");
        do {
            try {
                folderName = scnr.next();
                File newFolder = new File(folderName);
                if (newFolder.mkdir()) {
                    System.out.println("Folder '" +  folderName + "' creation successful");
                } else {
                    throw new FileAlreadyExistsException("File creation error, try again");
                }
            } catch (FileAlreadyExistsException e) {
                System.out.println(e);
            }
        }while(true);
    }
}


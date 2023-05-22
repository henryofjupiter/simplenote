import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Notebook {
    protected String userName;
    protected String fileName;
    protected String chosenFolder;
    protected String folderName;
    protected String filePath;
    private String noteTitle;
    protected String currDate; //TODO: IMPLEMENT DATE FROM JAVA LIBRARY
    private String currTime;
    protected final HashMap<String, String> folderNames = new HashMap<String, String>();
    protected String[] listOfFolders;
    public Notebook() {

    }
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
        userInput user = new userInput();
        FolderFileManager folderFile = new FolderFileManager();

        String userInput;

        while (true) {
            displayOptions();
            userInput = scnr.next();

            if (userInput.equals("1")) {
                user.getUserName(scnr);
            }
            else if (userInput.equals("2")) {
                folderFile.createNewFolder(scnr);

            }
            else if (userInput.equals("3")) {
                folderFile.createNewFile(scnr);

            }
            else if (userInput.equals("4")) {
                //TODO: work on opening folder or files
                folderFile.openFolderFile(scnr);
            }
            else if (userInput.equals("5")) {
                System.out.println("Delete a folder/ file");

            }
            else if (userInput.equals("6")) {
                System.out.println("Show list of folders/ files");
            }
            else if (userInput.equals("7")) {
                System.out.println("Exit");
                break;
            }
            else {
                System.out.println("Please choose menu option");
            }
        }

    }

        // Creates new folder
    // adds newly created folder to hashmap along with the folder's path as key

}

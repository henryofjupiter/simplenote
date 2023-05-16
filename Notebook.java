import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.*;
import java.io.File;

public class Notebook {
    private String userName;
    private String fileName;
    private String chosenFolder;
    private String folderName;
    private String filePath;
    private String noteTitle;
    private String currDate;
    private String currTime;
    private final HashMap<String, String> folderNames = new HashMap<String, String>();


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
            userInput = scnr.next();

            if (userInput.equals("1")) {
                getUserName(scnr);
            }
            else if (userInput.equals("2")) {
                createNewFolder(scnr);

            }
            else if (userInput.equals("3")) {
                createNewFile(scnr);

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
                break;
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

    // Creates new folder
    private void createNewFolder(Scanner scnr) {
        System.out.println("Enter name of folder");
        do {
            try {
                folderName = scnr.next();
                File newFolder = new File(folderName);
                filePath = newFolder.getAbsolutePath();
                if (newFolder.mkdir()) {
                    System.out.println("Folder '" +  folderName + "' creation successful");
                    folderNames.put(filePath, folderName);
                    scnr.nextLine();
                    break;
                } else {
                    throw new FileAlreadyExistsException("Folder already exits, try a new name");
                }
            } catch (FileAlreadyExistsException e) {
                System.out.println(e);
            }
        }while(true);
    }

    // Creates a new file with extension .txt in a chosen folder
    // adds newly created folder to hashmap with folder path as key
    private void createNewFile(Scanner scnr) {
        scnr.nextLine();
        do {
            System.out.println("Please choose a folder to store your file");
            for (String i : folderNames.values()) {
                System.out.println(i);
            }
            chosenFolder = scnr.nextLine();
            System.out.println();

            for (String i : folderNames.keySet()) {

                if (folderNames.get(i).equals(chosenFolder)) {
                    filePath = i;
                }
                else {
                    System.out.println("Folder not on file");
                    chosenFolder = " ";
                    break;
                }
            }
            try {
                if (!(chosenFolder.equals(" "))) {
                    System.out.println("Enter name of file");
                    System.out.println("file path " + filePath);
                    fileName = scnr.next();
                    fileName = filePath + File.separator + fileName + ".txt";
                    System.out.println("--> " + fileName);
                    File newFile = new File(fileName);

                    if(newFile.createNewFile()) {
                        System.out.println("File creation successful");
                        break;
                    }
                    else if (newFile.exists()) {
                        System.out.println("File Exists");
                    }
                }
            } catch (IOException r) {
                System.out.println(r.getMessage());
            }
        }while(true);
    }
}

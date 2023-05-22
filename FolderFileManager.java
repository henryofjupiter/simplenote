import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FolderFileManager extends Notebook {
    FolderFileManager() {

    }

    // Creates new folder
    // adds newly created folder to hashmap along with the folder's path as key
    public void createNewFolder(Scanner scnr) {
        System.out.println("Enter name of folder");
        do {
            try {
                folderName = scnr.next();
                File newFolder = new File("myNotebook" + File.separator + folderName);
                filePath = newFolder.getAbsolutePath();
                listOfFolders = newFolder.list();

                if (newFolder.mkdirs()) {
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

    private void folderNamesList (){
        for (String i : folderNames.values()) {
            System.out.println(i);
        }
        //testing to return list of folders
        for (String i : listOfFolders) {
            System.out.println(i);
        }
    }

    // Creates a new file with extension .txt in a chosen folder
    public void createNewFile(Scanner scnr) {
        scnr.nextLine();
        do {
            System.out.println("Please choose a folder to store your file");
            folderNamesList();
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
    //fetches current date from library

    // retrieves current date from java library
    public void currentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        currDate = dtf.format(now);
    }

    //open folders or file
   public void openFolderFile (Scanner scnr) {
        System.out.println("Choose from the menu option below");
        System.out.println("1. Open a folder");
        System.out.println("2. Open a file");

        String userInput = scnr.next();

        if (userInput.equals("1")) {
            folderNamesList();
            System.out.println("Choose a folder to open");
        }
        else if (userInput.equals("2")) {
            //TODO: IMPLEMENT A FOLDER THAT READS FILES FROM A SELECTED FOLDER
        }
        else {
            System.out.println("Nothing to output");
        }
    }

}

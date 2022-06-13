package Lockers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileManager {

    //Constants for fileStoragePackage directory inside Project
    private static File filePath;
    public static String mainPathpath = Paths.get("").toAbsolutePath() + File.separator + "LockersFolder";


    //Creat new folder if not exist
    public static void createNewFolderIfNotExist(String directory) {
        filePath = new File(directory);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
    }

    // Show All Files
    public static void showFiles() {
        filePath = new File(mainPathpath);
        if (filePath.list().length > 0) {

            String[] listFiles = filePath.list();
            Arrays.sort(listFiles);

            System.out.println("Showing all files\n");
            for (String f : listFiles) {
                System.out.println(" " + f);
            }

        } else
            System.out.println("Folder is empty\n");
    }


    //Adding file to main directory
    public static void addFiletoDirectory(String addFileName) {
        try {
            File newFile = new File(mainPathpath + File.separator + addFileName);
            String[] allFiles = filePath.list();
            for (String s : allFiles) {
                if (addFileName.equalsIgnoreCase(s)) {
                    System.out.println(addFileName + " File already exist");
                    return;
                }
            }
            newFile.createNewFile();
            System.out.println("File added successfully!");
        } catch (IOException e) {
            System.out.println("File creation failed");
            System.out.println(e.getMessage());
        }

    }

    // Delete file from main directory
    public static void deleteFileFromDirectory(String deleteFileName) {
        File newFile = new File(mainPathpath + File.separator + deleteFileName);
        filePath = new File(mainPathpath);
        String[] allFiles = filePath.list();

        for (String f : allFiles) {
            if (f.equals(deleteFileName)) {
                newFile.delete();
                System.out.println("File Deletion successful\n");
                return;
            }
        }
        System.out.println("File Deletion failed!");
        System.out.println(deleteFileName + " Not found in directory\n");

    }


    // Search file from main directory
    public static void searchFileFromDirectory(String searchFileName) {
        filePath = new File(mainPathpath);
        String[] allFiles = filePath.list();
        for (String f : allFiles) {
            if (f.equals(searchFileName)) {
                System.out.println(searchFileName + " file found in directory\n");
                return;
            }
        }
        System.out.println(searchFileName + " file not found in directory\n");
    }
}

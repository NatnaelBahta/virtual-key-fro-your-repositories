package Lockers;

import java.util.Scanner;

public class MenuManager {

    public static final String greenText = "\u001B[32m";
    public static final String whiteText = "\u001B[0m";
    public static final String blueText = "\u001B[34m";
    public static final String textRed = "\u001B[31m";

    // Welcome message printer, file creation, and primaryMenu caller method
    public static void showWelocmeMessage(String devName, String appName, String date){
        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + greenText + " Welcome to " + appName + " Application " + whiteText + " <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("                                               " + blueText + " Developer Name: " + devName + whiteText + "                                            ");
        System.out.println("                                                  " + blueText + " Date: " + date + whiteText + "                                                   ");
        System.out.println("                    " + blueText + " This application created user to search, add, and delete file from main folder LockersFolder " + whiteText + "           ");
        FileManager.createNewFolderIfNotExist("LockersFolder");
        primaryMenu();
    }


    // Primary menu handler method
    public static void primaryMenu() {
        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>> " +  blueText + " Primary Menu " + whiteText + " <<<<<<<<<<<<<<<<<<<<" );
        System.out.println("                      " +  blueText + " Select One of Below Options " + whiteText + "                " );
        System.out.println("-> " +  blueText + "1, " + whiteText +  " To search existing files" );
        System.out.println("-> " +  blueText + "2, " + whiteText +  " To go to secondary menu for file operation" );
        System.out.println("-> " +  blueText + "3, " + whiteText +  " To exit from this application" );

        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                int userInput = scan.nextInt();
                switch (userInput) {
                    case 1:
                        FileManager.showFiles();
                        primaryMenu();
                        break;
                    case 2:
                        secondaryMenu();
                        break;
                    case 3:
                        System.out.println(blueText + "\n Application exited successfully!\n");
                        scan.close();
                        System.exit(0);
                    default:
                        System.out.println(textRed + "Invalid input! Please enter a valid input");
                }
            } catch (Exception e) {
                System.out.println(textRed + " Error! Please enter a valid input!\n" + whiteText);
                System.out.println(e.getClass().getName());
                primaryMenu();
            }

        }
    }

    // Secondary menu handler method
    public static void secondaryMenu(){
        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>> " +  greenText + " Secondary Menu " + whiteText + " <<<<<<<<<<<<<<<<<<<<" );
        System.out.println("                    " +  blueText + " Select One of Below Options " + whiteText + "                     ");
        System.out.println("-> " +  blueText + "1, " + whiteText +  " To add files");
        System.out.println("-> " +  blueText + "2, " + whiteText +  " To delete files");
        System.out.println("-> " +  blueText + "3, " + whiteText +  " To search files");
        System.out.println("-> " +  blueText + "4, " + whiteText +  " To go back");
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                int userInput = scan.nextInt();
                switch (userInput) {
                    case 1:
                        System.out.println("Please enter file name to be added ");
                        String userInputToAdd = scan.next();
                        FileManager.addFiletoDirectory(userInputToAdd);
                        secondaryMenu();
                        break;
                    case 2:
                        System.out.println("Please enter file name to be deleted ");
                        String userInputToDelete = scan.next();
                        FileManager.deleteFileFromDirectory(userInputToDelete);
                        secondaryMenu();
                        break;
                    case 3:
                        System.out.println("Please enter file name to be searched ");
                        String userInputToSearch = scan.next();
                        FileManager.searchFileFromDirectory(userInputToSearch);
                        secondaryMenu();
                        break;
                    case 4:
                        System.out.println("Returning back to Primary menu");
                        primaryMenu();
                       return;
                    default:
                        System.out.println(textRed + "Invalid input! Please enter a valid input");
                        break;
                }
            } catch (Exception e) {
                System.out.println(textRed + " Error! Please enter a valid input!");
                System.out.println(e.getClass().getName());
                secondaryMenu();
            }

        }
    }
}

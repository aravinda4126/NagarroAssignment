package Assignment4;

import java.util.Scanner;

public class MenuCreator {

    Scanner sc = new Scanner(System.in);

    TrayCreator trayCreator = new TrayCreator();
    Tray subjectsTray = trayCreator.createFolders();


    // call printFileDetails() method in each folder and print details of all files
    public void printFiles () {
        while(!subjectsTray.getFolderStack().isEmpty()) {
            Folder poppedFolder = subjectsTray.getFolderStack().pop();
            poppedFolder.printFileDetails();
        }
    }


    // call searchFileByNumber() method in each folder and print details if found
    public void searchFileNumber(int targetFileNumber){
        boolean isFound = false;
        while (!subjectsTray.getFolderStack().isEmpty()){
            Folder poppedFolder = subjectsTray.getFolderStack().pop();
            File targetFile = poppedFolder.searchFileByNumber(targetFileNumber);
            if(targetFile!=null){
                isFound = true;
                System.out.println("File Found");
                System.out.println(targetFile.toString());
                break;
            }
        }
        if(!isFound){
            System.out.println("File Not Found");
        }
    }


    // call searchFileByName() method in each folder and print details if found
    public void searchFileName(String targetFileName){
        boolean isFound = false;
        while (!subjectsTray.getFolderStack().isEmpty()){
            Folder poppedFolder = subjectsTray.getFolderStack().pop();
            File targetFile = poppedFolder.searchFileByName(targetFileName);
            if(targetFile!=null){
                isFound = true;
                System.out.println("File Found");
                System.out.println(targetFile.toString());
                break;
            }
        }
        if(!isFound){
            System.out.println("File Not Found");
        }
    }


    public void printMenu() {
        System.out.println();
        System.out.println("-------------Menu-------------");
        System.out.println("1. Print Folder Details.");
        System.out.println("2. Print File Details.");
        System.out.println("3. Search a folder by name");
        System.out.println("4. Search a file by number");
        System.out.println("5. Search a file by name");
        System.out.println();
        System.out.print("Select an option : ");
    }

    public String enterFolderName(){
        System.out.print("Enter folder name : ");
        sc.nextLine();
        return sc.nextLine();
    }

    public int enterFileNumber(){
        System.out.print("Enter File Number : ");
        return sc.nextInt();
    }

    public String enterFileName(){
        System.out.print("Enter File Name : ");
        sc.nextLine();
        return sc.nextLine();
    }


    public void executeProgram() {
        printMenu();
        try {
            int option = sc.nextInt();
            switch (option) {
                case 1 -> subjectsTray.printFolders();
                case 2 -> printFiles();
                case 3 -> subjectsTray.searchFolderByName(enterFolderName());
                case 4 -> searchFileNumber(enterFileNumber());
                case 5 -> searchFileName(enterFileName());
                default -> System.out.println("Enter a valid input");
                }
            }
        catch (Exception e) {
                System.out.println("Enter a valid input");
        }
    }
}

package Assignment4;

import java.time.LocalDate;
import java.util.HashMap;

public class Folder {

    private String folderName;
    private LocalDate createdDate;
    private String folderOwner;
    private FileType fileType;

    private HashMap<Integer, File> fileHashMap = new HashMap<>();

    public Folder(String folderName, LocalDate createdDate, String folderOwner, FileType fileType) {
        this.folderName = folderName;
        this.createdDate = createdDate;
        this.folderOwner = folderOwner;
        this.fileType = fileType;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getFolderOwner() {
        return folderOwner;
    }

    public void setFolderOwner(String folderOwner) {
        this.folderOwner = folderOwner;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public HashMap<Integer, File> getFileHashMap() {
        return fileHashMap;
    }

    public void setFileHashMap(HashMap<Integer, File> fileHashMap) {
        this.fileHashMap = fileHashMap;
    }

    @Override
    public String toString() {
        return "Folder {" +
                "FolderName = '" + folderName + '\'' +
                ", CreatedDate = '" + createdDate + '\'' +
                ", FolderOwner = '" + folderOwner + '\'' +
                ", FileType = " + fileType +
                '}';
    }


    public void addFilesToHashMap(File file) {
        if (file.getFileName() != null && !file.getFileName().equals("") && file.getFileNumber() > 0) {
            fileHashMap.put(file.getFileNumber(), file);
        } else {
            System.out.println("File can't be identified");
        }
    }


    public void printFileDetails(){
        for(File file : fileHashMap.values())
            System.out.println(file.toString());
    }


    public File searchFileByNumber (int targetFileNumber){
        File targetFile = null;
        if(fileHashMap.containsKey(targetFileNumber)){
            targetFile = fileHashMap.get(targetFileNumber);
        }
        return targetFile;
    }


    public File searchFileByName (String targetFileName){
        File targetFile = null;
        for(File file : fileHashMap.values()){
            if(file.getFileName().equals(targetFileName)){
                targetFile = file;

            }
        }
        return targetFile;
    }
}
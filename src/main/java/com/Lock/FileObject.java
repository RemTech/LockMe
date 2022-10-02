package com.Lock;
import java.io.*;
import java.util.*;

public class FileObject implements Serializable {
    /*Adding User specified files */  /*Done*/
    /* File Retrieval is by ascending order */ /*Done*/
    /*Delete a user specified file */
    /* Search a user specified file */
    /* Navigation option to close the current execution */
    /* Ability to close the application */
    public int age;
    public String fileName;
    public String firstName;
    public String lastName;
    public String jobPosition;

    public FileObject() {
    }

    /* To move the initialisation t o the constructor */
    public FileObject(String fileName, int age, String firstName, String lastName, String jobPosition) {
       this.age = age;
       this.firstName = firstName;
       this.lastName = lastName;
       this.jobPosition = jobPosition;
       this.fileName = fileName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void createUserFile(String path, String fileName, String content) {
        /** Function to create file **/
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File Created Successfully");
            } else if (file.exists()) {
                System.out.println("File is in the directory");
            } else {
                throw new RuntimeException("File Not created");
            }
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(content);
            printWriter.flush();
            printWriter.close();
        } catch (IOException ex) {
            System.out.println(" Check:" + " " + ex.getMessage());
        }

    }

    public void deleteFile(String path,String fileName) {
        /** Function to delete **/
        LinkedList list = new LinkedList<>();
        list.add(new File(fileName));
        Iterator<File> itr = list.iterator();
        while (itr.hasNext()) {
            File files = (File) itr.next();
            if (files.getName().matches(fileName)&&files.exists()){
                files.delete();
                System.out.println("File successfully deleted");
            }
            else if(!files.exists()||files.equals(fileName)){
                System.out.println("Specified file does not exist");
            }else {
                System.err.println("Error:File not deleted successfully");
            }
        }
    }

    public void searchFileAscending() throws FileNotFoundException {
        /** Search function **/
        File file = new File(Execution.DIRECTORY);
        File[] fileArray = file.listFiles();
        Arrays.sort(fileArray);
        /** for each loop method **/
/*       for (File getFile:fileArray){
//           if (getFile.isFile()){
//               System.out.println(getFile.getName());
//           }
    }*/
        /** Iterator method **/
        Iterator itr = Arrays.stream(fileArray).iterator();
        while (itr.hasNext()) {
            File chFile = (File) itr.next();
            if (chFile.isFile()) {
                System.out.println(chFile.getName());
            }
        }
    }
    public void userSpecifiedSearch(String path, String fileName) {
        /**  Linear Search **/
        /*int start=0; int stop=fileName.length()-1;*/
        File file = new File(path);
        String[] arrayFile = file.list();
        int check = 0;
        if (arrayFile == null) {
            System.out.println("Empty directory");
        } else {
            for (int x = 0; x < arrayFile.length; x++) {
                String actualFileName = arrayFile[x];
                if (actualFileName.matches(fileName)) {
                    System.out.println("Positive Found file:"+" "+fileName);
                    check = 1;
                }
            }
        }
        if (check == 0) {
            System.out.println("Negative Cannot find file!!");
        }
    }



}





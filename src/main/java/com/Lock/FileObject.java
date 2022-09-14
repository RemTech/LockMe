package com.Lock;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileObject {
    /*Adding User specified files */
    /* File Retrieval is by ascending order */
    /*Delete a user specified file */
    /* Search a user specified file */
    /* Navigation option to close the current execution */
    /* Ability to close the application */
    private String value;

    public FileObject() {

    }

    public FileObject(String value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void createFile(String fileName,String content) {
        try {
            String path =System.getProperty("user.dir");
            File file = new File(path.concat(fileName));
            file.createNewFile();
            if (file.createNewFile() == true) {
                System.out.println("File Created Successfully");
            } else if (file.exists()) {
                System.out.println("File is in the directory");
            } else {
                throw new RuntimeException("File Not created");
            }
            PrintWriter printWriter =new PrintWriter(file);
            printWriter.println(content);
            printWriter.flush();
            printWriter.close();
        } catch (IOException ex) {
            System.out.println(" Check:" + ex.getMessage());
        }

    }
}

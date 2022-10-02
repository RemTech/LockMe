package com.Lock;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Execution {
    public static final String DIRECTORY = System.getProperty("user.dir");
    public static final String DEV_NAME = "Remi Osisanya";
    public static final String APPLICATION_NAME = "LockedMe.app";
/** Main class for Business logic to be executed **/
    public static void main(String[] args) {
        int mainOption;
        String userInput;
        int secondOption;
        String secondOptionline;
        try {
            do {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println(new Date().toString());
                System.out.println("Developer's Name:" + "\t" + DEV_NAME);
                System.out.println("Application-Name:" + "\t" + APPLICATION_NAME);
                System.out.println("WELCOME TO MAIN-PAGE");
                System.out.println("Enter number from 0-2 to Select an Option");
                System.out.println("Option -> 0: Get file names in an ascending order");
                System.out.println("Option -> 1: Add,Delete, and Search user specified file(s)");
                System.out.println("Option -> 2: Exit application");
                System.out.print("Main Page Enter Option to Start:");
                userInput = bufferedReader.readLine();
                mainOption = Integer.parseInt(userInput);
                FileObject fileObject = new FileObject();
                if(mainOption<3){
                switch (mainOption) {
                    case 0:
                        /** Return File in ascending order **/
                        System.out.println("List of files in ascending order");
                        fileObject.searchFileAscending();
                        break;
                    case 1:
                        /** Add,Delete,Search user specified file business logic **/
                        /** subFunction for option 1 **/
                        do {
                            System.out.println("Option -> 1: Add user specified file");
                            System.out.println("Option -> 2: Delete Specified file");
                            System.out.println("Option -> 3: Search user specified file");
                            System.out.println("Option -> 4: Main Page");
                            System.out.println("Enter your option ");
                            secondOptionline = bufferedReader.readLine();
                            secondOption = Integer.parseInt(secondOptionline);
                            switch (secondOption) {
                                case 1: /** Add user specified file **/
                                    System.out.println("Please enter the file name to be created:");
                                    String fileName = bufferedReader.readLine();
                                    System.out.println("Create content for the file");
                                    String content = bufferedReader.readLine();
                                    fileObject.createUserFile(DIRECTORY, fileName, content);  /* file creation */
                                    break;
                                case 2: /** Delete Specified file **/
                                    System.out.println("Please enter the file name to be deleted:");
                                    String fileName1 = bufferedReader.readLine();
                                    //fileObject.deleteUserFile(DIRECTORY, fileName1);
                                    fileObject.deleteFile(DIRECTORY, fileName1);
                                    break;
                                case 3:/** Search user specified file **/
                                    System.out.println("File to be searched:");
                                    File searchFile = new File(bufferedReader.readLine());
                                    fileObject.userSpecifiedSearch(DIRECTORY, String.valueOf(searchFile));
                                    break;
                                case 4: /** Main page **/
                                    System.out.println("Back to Main Menu");
                                    break;
                                default:
                                    /** Null **/
                            }
                        } while (secondOption < 4);
                        break;
                    case 2: /** To exit application **/
                        System.out.println("Exit: End of app");
                        break;
                }
                }else {
                    /** To handle number >=3,and >3 **/
                    System.out.println("Enter Number less than 3");
                }
            } while (mainOption<2);
        } catch (IOException e) {
            System.err.println("Please check:"+" "+e.getMessage());
        } catch (NumberFormatException exception) {
            System.err.println("Please enter Number" +" "+ exception.getMessage());
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }
    }



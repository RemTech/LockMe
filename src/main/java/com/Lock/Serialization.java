package com.Lock;

import java.io.*;

public class Serialization{
    /* FileOutputStream,ObjectOutputStream */
    private FileObject fileObject;
    private String userInput;
    public Serialization(FileObject fileObject){
        this.fileObject=new FileObject();
        this.fileObject.setAge(23);
        this.fileObject.setFirstName("Remi");

    }
    public void serializeObject(){
        try{
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Your FileName");
            userInput= bufferedReader.readLine();
            DataOutputStream dataOutputStream= new DataOutputStream(new FileOutputStream(userInput));
            ObjectOutputStream objectOuputStream=new ObjectOutputStream(dataOutputStream);
           objectOuputStream.writeObject(fileObject);
            objectOuputStream.flush();
            objectOuputStream.close();
            System.out.println("Successfully created");
        }catch (IOException exception){
           System.out.println("View this:"+exception.getMessage());
        }
    }
    public void deSerialise(){
        try{
            FileInputStream fileInputStream=new FileInputStream("Youtube.txt");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            FileObject fileObject1=(FileObject)objectInputStream.readObject();
            objectInputStream.close();
            System.out.println(fileObject1.getAge()+"\t"+fileObject1.getFirstName());
        }catch(IOException exception){

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[]args){
       Serialization serialization=new Serialization(new FileObject());
       FileObject fileObject=new FileObject();
       //serialization.serializeObject();
        serialization.deSerialise();
    }
}


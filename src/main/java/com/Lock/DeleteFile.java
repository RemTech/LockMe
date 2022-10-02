package com.Lock;

public class DeleteFile extends FileObject{
    private String fileName;
    private int age;
    private String firstName;
    private String lastName;
    private String jobPosition;
    public DeleteFile(){
        super();
    }
    public DeleteFile(String fileName,int age,String firstName,String lastName,String jobPosition){
        super(fileName,age,firstName,lastName,jobPosition);
        this.fileName=fileName;
        this.age=age;
        this.firstName=firstName;
        this.lastName=lastName;
        this.jobPosition=jobPosition;
    }
    public  void setFileName(String fileName){
        this.fileName=fileName;
    }
    public String getFileName(){
        return fileName;
    }
    public void fileDelete(){
        if (super.fileName.equals(fileName)){
            System.out.println("Deleting the specified file(s)");
            /* to write the batch code to delete files *//*ERASE /S <fileName>*/
            System.clearProperty(fileName);
            if (System.clearProperty(fileName).isEmpty()){
                System.out.println("File(s) successfully Deleted");
            }
            else
            {
                System.out.println("File Not successfully Deleted");
            }
        }
    }
}

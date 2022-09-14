package com.Lock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class Execution {

    public static void main(String[]args)throws IOException {
        String reader0,reader1;
       Date date=new Date();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(date.toString());
        System.out.println("Enter your values:");
        reader0=bufferedReader.readLine(); reader1=bufferedReader.readLine();
        FileObject fileObject=new FileObject();
       fileObject.createFile(reader0,reader1);

    }
}

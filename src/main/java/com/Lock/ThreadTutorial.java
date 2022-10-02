package com.Lock;

public class ThreadTutorial implements Runnable{
    private String name;
    private int age;
    public ThreadTutorial(String name,int age){
        this.age=age;
        this.name=name;
    }
    @Override
    public void run() {
        synchronized (this){
            System.out.println("Child Thread");
            try{
            if (age>4){
                int value=(45*90)/2;
                System.out.println("Calculated age for:"+ name +" is ".concat(String.valueOf(value)));
            }else {
                System.out.println("Executed");
            }
            Thread.sleep(1000);
            this.notify();
        }catch (InterruptedException exception){
                System.err.println(exception.getMessage());
            }
    }
    }

    public static void main(String[]args){
     try{
         ThreadTutorial tutorial=new ThreadTutorial("Thread",23);
        Thread thread=new Thread(tutorial);
        thread.start();
        synchronized (thread){
            System.out.println("Super thread");
            thread.wait();
            System.out.println("Completed the synchronisation");
        }
    }catch (InterruptedException exception){
         System.err.println(exception.getMessage());
     }
}
}




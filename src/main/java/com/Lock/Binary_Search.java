package com.Lock;

import java.util.Arrays;
import java.util.Scanner;

public class Binary_Search {
    public static void main(String[] args) {
        int [] array;int start;int stop;int value;int midRange; int isiro; int count; boolean check=false;
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter your digit");
        isiro=sc.nextInt();
        array=new int[isiro];
        System.out.println("Digits to be stored");
        for ( count=0;count<isiro;count++) {
            array[count] = sc.nextInt();
        }
        System.out.println("Enter Number To Find");
        value= sc.nextInt();
        Arrays.sort(array);
        start=0;stop=isiro-1;
        midRange=(start+stop)/2;
        if(start<=stop) {
            if (midRange == value) {
                System.out.println("Element found @:" + midRange);
                check=true;System.out.println(check);
            } else if (array[midRange] < value) {
                start = midRange + 1;
                check=true;System.out.println(check+""+(midRange+1));
            } else {
                stop = midRange - 1;
                check=true;
                System.out.println(check+""+(midRange-1));
            }
            midRange = (start+stop)/ 2;
        }
            if (start>stop){
                System.out.println(check);

            }

        }

    }



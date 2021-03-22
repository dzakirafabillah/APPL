/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CopyingAFile;

/**
 * CopyFile.java
 * @author DZAKIRA
 * Specification : Write a program that prompts the user for a filename, 
   then opens a Scanner to the file and copies it, a line at a time, to the
   standard output.
 */

import java.util.Scanner;
import java.io.*;
public class CopyFile{

    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        Scanner input = null;
        boolean exist = false;
        File file;
        
        do{
            /*Get File Name*/
            System.out.println("Enter File Address : ");
            file = new File(scan.nextLine());
            /*Trying to Open File*/
            try{
                input = new Scanner(file);
                exist = true;
            }
            catch (FileNotFoundException e){
                System.out.println("File is not found " + e + "\n");
            }
        }while(!exist); //if the file doesn't exist, ask for another file name
        
        /*Print isi File*/
        while(input.hasNext()){
            System.out.println(input.nextLine());
        }
    }
}

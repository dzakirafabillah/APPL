/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlacingExceptionHandlers;

/**
 *
 * @author DZAKIRA
 */
/**
 *
 * @author DZAKIRA
 */
// ****************************************************************
// ParseInts.java
//
// Reads a line of text and prints the integers in the line.
//
// ****************************************************************
import java.util.Scanner;

public class ParseInts{
    public static void main(String[] args){
        int val, sum=0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a line of text");
        Scanner scanLine = new Scanner(scan.nextLine());
        
        /*try statement that encompasses the entire while loop.*/
        try {
            while (scanLine.hasNext()){
                val = Integer.parseInt(scanLine.next());
                sum += val;
            }
        } catch (NumberFormatException e1) {
        }
        
        
        System.out.println("The sum of the integers on this line is " + sum);
    }
}


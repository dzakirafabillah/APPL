package ExceptionArentAlwaysError;

// ****************************************************************
// CountLetters.java
// @author DZAKIRA 
// Reads a words from the standard input and prints the number of
// occurrences of each letter in that word.
//
// ****************************************************************

import java.util.Scanner;

public class CountLetters {
    public static void main(String[] args){
        int[] counts = new int[26];
        Scanner scan = new Scanner(System.in);
        //get word from user
        System.out.print("Enter a single word (letters only, please): ");
        String word = scan.nextLine();
        //convert to all upper case
        word = word.toUpperCase();
        //count frequency of each letter in string
        
        for (int i=0; i < word.length(); i++){
            //try if the character is between 'A' - 'Z'
            try {
                counts[word.charAt(i)-'A']++;
            } catch (ArrayIndexOutOfBoundsException e1) {
                //modify the body of the catch so that it prints a useful message
                System.out.println("Not a Letter : " + word.charAt(i) );
            }         
        }
            
        //print frequencies
        System.out.println();
        for (int i=0; i < counts.length; i++)
            if (counts [i] != 0)
                System.out.println((char)(i +'A') + ": " + counts[i]);
    }
}
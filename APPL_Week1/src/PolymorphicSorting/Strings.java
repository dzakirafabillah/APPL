/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PolymorphicSorting;

import java.util.Scanner;

/**
 *
 * @author DZAKIRA
 */
public class Strings {
    public static void main(String[] args){
                Comparable[] stringList;
		int size;
		
		Scanner scan = new Scanner( System.in );
		
		System.out.print("\nHow many Strings do you want to sort? ");
		size = scan.nextInt();
                
                stringList = new Comparable[size];
		
		System.out.println("\nEnter the Strings...");
		for(int i=0; i<size; i++){
                        //scan string
			stringList[i] = scan.next();
		}
		
		Sorting.selectionSort(stringList);
                //Sorting.insertionSort(stringList);
		
		System.out.println("\nYour numbers in sorted order...");
		for(int i=0; i<size; ++i){
			System.out.print( stringList[i] + "   " );
		}
		System.out.println();
	}   
}


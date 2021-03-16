/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PolymorphicSorting;

// ******************************************************
// Numbers.java
//
// Demonstrates selectionSort on an array of integers.
// ******************************************************
import java.util.Scanner;


public class Numbers {
    //----------------------------------------------------------------------
	//	Reads in an array of integer, sorts them, then prints them
	//	in sorted order.
	//----------------------------------------------------------------------
	public static void main(String[] args){
		//int[] intList;
                //diubah jadi comparable
                Comparable[] intList;
		int size;
		
		Scanner scan = new Scanner( System.in );
		
		System.out.print("\nHow many integers do you want to sort? ");
		size = scan.nextInt();
                //diubah jadi comparable
		//intList = new int[size];
                intList = new Comparable[size];
		
		System.out.println("\nEnter the numbers...");
		for(int i=0; i<size; ++i){
			intList[i] = scan.nextInt();
		}
		
		Sorting.selectionSort(intList);
                //Sorting.insertionSort(intList);
		
		System.out.println("\nYour numbers in sorted order...");
		for(int i=0; i<size; ++i){
			System.out.print( intList[i] + "   " );
		}
		System.out.println();
	}   
}

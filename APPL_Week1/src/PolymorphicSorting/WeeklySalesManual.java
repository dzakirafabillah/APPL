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
public class WeeklySalesManual {
    public static void main(String[] args){
		int size;
		String aFirstName, aLastName;
                int aTotalSales;
                
		Scanner scan = new Scanner( System.in );
		
		System.out.print("\nHow many Staff do you want to sort? ");
		size = scan.nextInt();
                Salesperson[] salesStaff = new Salesperson[size];
		
		System.out.println("\nEnter Data of Staff...");
		for(int i=0; i<size; i++){
                        //scan string
                        System.out.printf("First name : ");
			aFirstName = scan.next();
                        System.out.printf("Last name : ");
			aLastName = scan.next();
                        System.out.printf("Total Sales : ");
			aTotalSales = scan.nextInt();
                        System.out.println("===========");
                        salesStaff[i] = new Salesperson(aFirstName, aLastName, 
                                aTotalSales);
		}
		
		Sorting.insertionSort( salesStaff );
		
                System.out.println( "\nRanking of Sales for the Week\n" );
                for( Salesperson s : salesStaff ) {
                    System.out.println( s );
                }
	}
}
    
    



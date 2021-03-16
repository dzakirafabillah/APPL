/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PolymorphicSorting;

// *******************************************************
// Salesperson.java
//
// Represents a sales person who has a first name, last
// name, and total number of sales.
// *******************************************************
public class Salesperson implements Comparable {
	private String firstName, lastName;
	private int totalSales;
	
	//----------------------------------------------------------------------
	//	Constructor:  Sets up the salesperson object with
	//	              the given data.
	//----------------------------------------------------------------------
	public Salesperson( String first, String last, int sales ) {
            firstName = first;
            lastName = last;
            totalSales = sales;
	}

	//----------------------------------------------------------------------
	//	Returns the salesperson as a string.
	//----------------------------------------------------------------------
	public String toString() {
            return lastName + ", " + firstName + ": \t" + totalSales;
	}
	
	//----------------------------------------------------------------------
	//	Returns true if the salespeople have the same name.
	//----------------------------------------------------------------------
	public boolean equals( Object other ) {
		return( lastName.equals(((Salesperson)other).getLastName()) &&
		        firstName.equals(((Salesperson)other).getFirstName()));
	}

	//----------------------------------------------------------------------
	//	Order is based on total sales with the name (last, then first)
	//	breaking a tie.
	//----------------------------------------------------------------------
	public int compareTo( Object other ) {
		int result;
                if (((Salesperson)other).totalSales>this.totalSales){
                    result = -1;
                }else if (((Salesperson)other).totalSales<this.totalSales)
                    result = 1;
                else {//jika totalSales sama
                    if (this.firstName.compareTo(((Salesperson)other).firstName) != 0){
                        result = this.firstName.compareTo(((Salesperson)other).firstName);
                    }else {
                       result = this.lastName.compareTo(((Salesperson)other).lastName); 
                    }           
                }
		
		return result;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getSales() {
		return totalSales;
	}
}


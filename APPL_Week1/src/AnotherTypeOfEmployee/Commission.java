/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnotherTypeOfEmployee;

/**
 *
 * @author DZAKIRA
 */
public class Commission extends Hourly{
    double totalSales; //total sales the employee has made
    double commissionRate; //commission rate (represent the percent in decimal)
    
    /*Constructor*/
    public Commission(String eName, String eAddress, String ePhone,
                  String socSecNumber, double eRate, double eCommissionRate){
        super(eName, eAddress, ePhone, socSecNumber, eRate);
        this.commissionRate = eCommissionRate;
    }
    
    /* method that adds the parameter to the instance variable representing 
    total sales.*/
    public void addSales (double totalSales){
        this.totalSales += totalSales;
    }
    
    /*compute the pay for hours worked then add to that the pay from commission 
    on sales.*/
    @Override
    public double pay(){
        double totalPayment = super.pay();
        totalPayment += (this.totalSales * this.commissionRate);
        this.totalSales = 0; 
        return totalPayment;
   }

    /*all the toString method of the parent class then add the total sales to 
    that.*/
     public String toString(){
        String str = super.toString();
        str += "\nTotal Sales: " + this.totalSales;
        return str;
     }
}

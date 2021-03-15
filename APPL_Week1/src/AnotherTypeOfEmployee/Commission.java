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
    double commissionRate; //commission rate (represent the percent in decimal form)
    
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
    
    
}

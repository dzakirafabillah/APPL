/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaintingShapes;

//******************************************************

// Paint.java
//
// Represents a type of paint that has a fixed area
// covered by a gallon. All measurements are in feet.
//******************************************************

public class Paint {
    
    private double coverage; //number of square feet per gallon

    /*Constructor*/
    public Paint(double c){
        coverage = c;
    }

    /*method to compute the amount of paint needed to paint a shape).*/
    public double amount(Shape s){
        System.out.println ("Computing amount for " + s);
        //correct the return statement
        return (s.area() / coverage);
    }
}
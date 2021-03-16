/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaintingShapes;

/**
 *
 * @author DZAKIRA
 */
public class Cylinder extends Shape { 
    private double radius;  
    private double height;  
  
    public Cylinder(double aRadius, double aHeight) {
        super("Cylinder"); 
        radius = aRadius;
        height = aHeight;
    } 
    
    public double area() {
        return Math.PI*radius*radius*height;
    }
  
    public String toString() {
        return super.toString() + " of radius " + radius + " and height " + height;
    }
}

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
public abstract class Shape {
    //An instance variable shapeName of type String
    String shapeName;
    
    //constructor
    public Shape(String aShapename) {
        this.shapeName = aShapename;
    }
    
    //An abstract method area()
    public abstract double area();
  
    //A toString method that returns the name of the shape
    public String toString() {
        return this.shapeName;
    }
}
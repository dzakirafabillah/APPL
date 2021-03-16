/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpeedControl;

// **********************************************************************
// SpeedControl.java
//
// Demonstrates animation -- balls bouncing off the sides of a panel -
// with speed controlled by a slider.
// **********************************************************************
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SpeedControl{
    // -------------------------------------
    // Sets up the frame for the animation.
    // -------------------------------------
     public static void main(String[] args)
    {
    JFrame frame = new JFrame ("Bouncing Balls");
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    //frame.getContentPane.add(new SpeedControlPanel ());
    frame.add(new SpeedControlPanel ());
    frame.pack();
    frame.setVisible(true);
}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColoringaMoveableCircle;

// ******************************************************************
// CirclePanel.java
//
// A panel with a circle drawn in the center and buttons on the
// bottom that move the circle.
// ******************************************************************
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class CirclePanel extends JPanel{
    private final int CIRCLE_SIZE = 50;
    private int x,y;
    private Color c;
    JButton chooseColor = new JButton("Choose Color");
    //---------------------------------------------------------------
    // Set up circle and buttons to move it.
    //---------------------------------------------------------------
    public CirclePanel(int width, int height){
        // Set coordinates so circle starts in middle
        x = (width/2)-(CIRCLE_SIZE/2);
        y = (height/2)-(CIRCLE_SIZE/2);
        c = Color.green;
        // Need a border layout to get the buttons on the bottom
        this.setLayout(new BorderLayout());
        // Create buttons to move the circle
        JButton left = new JButton("Left");
        JButton right = new JButton("Right");
        JButton up = new JButton("Up");
        JButton down = new JButton("Down");
        // Add listeners to the buttons
        left.addActionListener(new MoveListener(-20,0));
        right.addActionListener(new MoveListener(20,0));
        up.addActionListener(new MoveListener(0,-20));
        down.addActionListener(new MoveListener(0,20));
        // Need a panel to put the buttons on or they'll be on
        // top of each other.
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(left);
        buttonPanel.add(right);
        buttonPanel.add(up);
        buttonPanel.add(down);
        // Add the button panel to the bottom of the main panel
        this.add(buttonPanel, "South");
        
        
        // Create buttons to coloring the circle
        JButton red = new JButton("Red");
        JButton blue = new JButton("Blue");
        JButton green = new JButton("Green");
        JButton white = new JButton("White");
        
        // Add listeners to the buttons
        red.addActionListener(new ColorListener(Color.red));
        blue.addActionListener(new ColorListener(Color.blue));
        chooseColor.addActionListener(new ColorListener(null));
        green.addActionListener(new ColorListener(Color.green));
        white.addActionListener(new ColorListener(Color.white));
        
        //background of each button
        red.setBackground(Color.red);
        blue.setBackground(Color.blue);
        green.setBackground(Color.green);
        white.setBackground(Color.white);
        
        //foreground of each button
        red.setForeground(Color.white);
        blue.setForeground(Color.white);
        green.setForeground(Color.white);
        white.setForeground(Color.black);
        
        // Need a panel to put the buttons on or they'll be on
        // top of each other.
        JPanel buttonPanelColor = new JPanel();
        buttonPanelColor.add(red);
        buttonPanelColor.add(blue);
        buttonPanelColor.add(chooseColor);
        buttonPanelColor.add(green);
        buttonPanelColor.add(white);
        // Add the button panel to the bottom of the main panel
        this.add(buttonPanelColor, "North");
    }
    //---------------------------------------------------------------
    // Draw circle on CirclePanel
    //---------------------------------------------------------------
    public void paintComponent(Graphics page){
        super.paintComponent(page);
        page.setColor(c);
        page.fillOval(x,y,CIRCLE_SIZE,CIRCLE_SIZE);
    }
    //---------------------------------------------------------------
    // Class to listen for button clicks that move circle.
    //---------------------------------------------------------------
    private class MoveListener implements ActionListener{
        private int dx;
        private int dy;
        //---------------------------------------------------------------
        // Parameters tell how to move circle at click.
        //---------------------------------------------------------------
        public MoveListener(int dx, int dy){
            this.dx = dx;
            this.dy = dy;
        }
        //---------------------------------------------------------------
        // Change x and y coordinates and repaint.
        //---------------------------------------------------------------
        public void actionPerformed(ActionEvent e){
            x += dx;
            y += dy;
            repaint();
        }
    }
    
    //---------------------------------------------------------------
    // Class to listen for button clicks that change color of the circle.
    //---------------------------------------------------------------
    private class ColorListener implements ActionListener{
        private Color color;
        //---------------------------------------------------------------
        // Parameters tell how to move circle at click.
        //---------------------------------------------------------------
        public ColorListener(Color a){
            this.color = a;
        }
        //---------------------------------------------------------------
        // Change color repaint.
        //---------------------------------------------------------------
        public void actionPerformed(ActionEvent e){
            if(color != null){
                c = color;
            }else{
                c = JColorChooser.showDialog(chooseColor, "JColorChooser", 
                        c);
            }
            
            repaint();
        }
    }
}

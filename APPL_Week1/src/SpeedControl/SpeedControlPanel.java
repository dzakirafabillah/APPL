/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpeedControl;

// ******************************************************************
// SpeedControlPanel.java
//
// The panel for the bouncing ball. Similar to
// ReboundPanel.java in Listing 8.16 in the text, except a circle
// rather than a happy face is rebounding off the edges of the
// window.
// ******************************************************************
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class SpeedControlPanel extends JPanel
{
    private final int WIDTH = 600;
    private final int HEIGHT = 400;
    private final int BALL_SIZE = 50;
    private Circle bouncingBall; // the object that moves
    private Timer timer;
    private int moveX, moveY; // increment to move each time
    private JSlider speedSlider;
    private JLabel label;
    JPanel panel = new JPanel();
    // ---------------------------------------------
    // Sets up the panel, including the timer
    // for the animation
    // ---------------------------------------------
    public SpeedControlPanel (){
        timer = new Timer(30, new ReboundListener());
        this.setLayout (new BorderLayout());
        bouncingBall = new Circle(BALL_SIZE);
        moveX = moveY = 5;
        
        // Set up a slider object here
        /*JSlider that is horizontal with values ranging from 0 to 200, 
        initially set to 30.*/
        speedSlider = new JSlider(JSlider.HORIZONTAL,0, 200, 30);
        speedSlider.setMajorTickSpacing(40);
        speedSlider.setMinorTickSpacing(10);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);
        speedSlider.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        SlideListener slt = new SlideListener();
        speedSlider.addChangeListener(slt);
        
        label = new JLabel("Timer Delay");
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        
        panel.add(label);
        panel.add(speedSlider);
        this.add(panel, "South");
      
        setPreferredSize (new Dimension (WIDTH, HEIGHT));
        setBackground(Color.black);
        timer.start();
    }
    // --------------------
    // Draw the ball
    // --------------------
    public void paintComponent (Graphics page){
        super.paintComponent (page);
        bouncingBall.draw(page);
    }
    
    // ***************************************************
    // An action listener for the timer
    // ***************************************************

public class ReboundListener implements ActionListener{
    // ----------------------------------------------------


    // actionPerformed is called by the timer -- it updates
    // the position of the bouncing ball
    // ----------------------------------------------------
    public void actionPerformed(ActionEvent action){
        /*slidePanelHt used to fix the problem, so The ball (circle) doesn't 
          goes down behind the panel the slider is on.
        */
        int slidePanelHt = panel.getSize().height;
        bouncingBall.move(moveX, moveY);
        // change direction if ball hits a side
        int x = bouncingBall.getX();
        int y = bouncingBall.getY();
        if (x < 0 || x >= WIDTH - BALL_SIZE)
            moveX = moveX * -1;
        if (y <= 0 || y >= HEIGHT - slidePanelHt - BALL_SIZE)
            moveY = moveY * -1;
        repaint();
    }
}
    // *****************************************************
    // A change listener for the slider.
    // *****************************************************
private class SlideListener implements ChangeListener{
    // -------------------------------------------------
    // Called when the state of the slider has changed;
    // resets the delay on the timer.
    // -------------------------------------------------
    
    /*
    This function must determine the value of the slider, then set the
    timer delay to that value. The timer delay can be set with the method 
    setDelay (int delay) in the Timer class.
    */
    
    public void stateChanged (ChangeEvent event){
        int speed = speedSlider.getValue();
        timer.setDelay(speed);
    }
    
   
}

}
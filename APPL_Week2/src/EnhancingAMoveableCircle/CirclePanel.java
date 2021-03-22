package EnhancingAMoveableCircle;

// ******************************************************************
// CirclePanel.java
// @author DZAKIRA
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
    JButton left, right, up, down;
    JPanel buttonPanel;
    private int W_width, W_height;
    //---------------------------------------------------------------
    // Set up circle and buttons to move it.
    //---------------------------------------------------------------
    public CirclePanel(int width, int height){
        //get Window Size
        W_width = width;
        W_height = height;
        
        
        // Set coordinates so circle starts in middle
        x = (width/2)-(CIRCLE_SIZE/2);
        y = (height/2)-(CIRCLE_SIZE/2);
        c = Color.green;

        // Need a border layout to get the buttons on the bottom
        this.setLayout(new BorderLayout());

        // Create buttons to move the circle
        left = new JButton("Left");
        right = new JButton("Right");
        up = new JButton("Up");
        down = new JButton("Down");

        // Add listeners to the buttons
        left.addActionListener(new MoveListener(-20,0));
        right.addActionListener(new MoveListener(20,0));
        up.addActionListener(new MoveListener(0,-20));
        down.addActionListener(new MoveListener(0,20));

        //set Mnemonics
        left.setMnemonic(KeyEvent.VK_L);
        right.setMnemonic(KeyEvent.VK_R);
        up.setMnemonic(KeyEvent.VK_U);
        down.setMnemonic(KeyEvent.VK_D);
     
        //set tooltips
        String sLeft = "<html> Memindahkan circle ke Kiri <br> sebanyak 20 satuan </html> ";
        String sRight = "<html> Memindahkan circle ke Kanan <br> sebanyak 20 satuan </html> ";
        String sUp = "<html> Memindahkan circle ke Atas <br> sebanyak 20 satuan </html> ";
        String sDown = "<html> Memindahkan circle ke Bawah <br> sebanyak 20 satuan </html> ";
        
        left.setToolTipText(sLeft);
        right.setToolTipText(sRight);
        up.setToolTipText(sUp);
        down.setToolTipText(sDown);
        
        
        // Need a panel to put the buttons on or they'll be on top of each other.
        buttonPanel = new JPanel();
        buttonPanel.add(left);
        buttonPanel.add(right);
        buttonPanel.add(up);
        buttonPanel.add(down);
        
        

        // Add the button panel to the bottom of the main panel
        this.add(buttonPanel, "South");
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
            
            //disabled when the circle gets all the way to an edge
            if (x < 0) left.setEnabled(false); else left.setEnabled(true);
            if (y < 0) up.setEnabled(false); else up.setEnabled(true);
            if (x >= ( W_width -85)) right.setEnabled(false); else right.setEnabled(true);
            if (y >= ( W_height -135)) down.setEnabled(false); else down.setEnabled(true);
        }
    }
}

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class AdDisplay implements ActionListener {
    
    // Constructor to initialize the class attributes
    private JFrame frame = new JFrame();
    private JLabel firstLine, secondLine;
    private Timer timer;
    private ArrayList<Message> list;
    private Random rnd;
    private int index;

    // Void function to set up and start the billboard
    public void display(ArrayList<Message> msgs){

        // Assigns the value of the parameter "msgs" to the instance variable "list" of the current object.
        this.list = msgs; 
        rnd = new Random();
        index = rnd.nextInt(msgs.size()); // Generates a random index
        
        // Set up the frame
        frame.setTitle("Billboard");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up the label 1
        firstLine = new JLabel(msgs.get(index).getText());

        firstLine.setForeground(Color.CYAN); // Text color
        firstLine.setBackground(Color.BLACK); // Background color
        firstLine.setOpaque(true); // fill the background with the specified color (black)
        firstLine.setBounds(0,0,400,150); // Set bounds to center the label more effectively
        firstLine.setFont(new Font("Arial", Font.BOLD, 20)); // text larger and bold
        firstLine.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        firstLine.setVerticalAlignment(SwingConstants.CENTER); // Center text vertically

        frame.add(firstLine); // Add label to the frame

        // Set up label 2
        secondLine = new JLabel(msgs.get(index).getCustomer());

        secondLine.setForeground(Color.ORANGE);
        secondLine.setBackground(Color.BLACK);
        secondLine.setOpaque(true);
        secondLine.setBounds(0,100,400,150); // Adjust bounds to be symmetrical with firstLine
        secondLine.setFont(new Font("Arial", Font.BOLD, 15)); 
        secondLine.setHorizontalAlignment(SwingConstants.CENTER); 
        secondLine.setVerticalAlignment(SwingConstants.CENTER); 

        frame.add(secondLine);

        // Set up the timer to switch messages every 10 seconds
        timer = new Timer(10*1000, this);
        timer.setInitialDelay(0); // Starts immediately
        timer.start();

        //
        frame.setLayout(null); 
        frame.setVisible(true); // Display the frame
    }

    // Method to update the display with a randomly selected message
    public void updateDisplay(){

        index = rnd.nextInt(this.list.size());
        firstLine.setText(this.list.get(index).getText());
        secondLine.setText(this.list.get(index).getCustomer());
    }

    // Handle the action event triggered by the timer
    @Override
   public void actionPerformed(ActionEvent e) {
       if(e.getSource() == timer){
            this.updateDisplay(); // Runs the Display method
       }
    
    }
}

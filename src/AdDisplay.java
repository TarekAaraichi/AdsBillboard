
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

// Class that handles displaying advertisements on a digital billboard
public class AdDisplay implements ActionListener {

    // GUI components: JFrame for the main window, JLabels for text display
    private JFrame frame = new JFrame();
    private JLabel firstLine, secondLine;
    
    // Timer for switching advertisements at regular intervals
    private Timer timer;
    
    // List of advertisements and random generator for selecting ads
    private ArrayList<Advertisements> list;
    private Random rnd;
    
    // Index for tracking current ad and array to count how often each ad is displayed
    private int index;
    private int[] adDisplayCounts;

    // Tracks the time the program has been running (for display stats)
    private long runningTime = 0;

    // Method to set the list of ads and initialize the display counts
    public void setMessageList(ArrayList<Advertisements> ads) {
        this.list = ads;
        // Initialize the display counter for each advertisement
        this.adDisplayCounts = new int[list.size()];  
    }

    // Method to configure and start the billboard display
    public void display(ArrayList<Advertisements> ads){

        // Set the ads list for this object and initialize the counters
        this.setMessageList(ads);
        rnd = new Random();
        
        // Select a random advertisement index to display initially
        index = rnd.nextInt(list.size()); 
        
        // Set up the window (frame) properties
        frame.setTitle("Ads Billboard");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configure the first label to display the ad text
        firstLine = new JLabel(list.get(index).getText());
        firstLine.setForeground(Color.CYAN);  // Set the text color to cyan
        firstLine.setBackground(Color.BLACK); // Set the background color to black
        firstLine.setOpaque(true);  // Make the background color visible
        firstLine.setBounds(0, 0, 400, 150);  // Set the label size and position
        firstLine.setFont(new Font("Arial", Font.BOLD, 20));  // Set the font to Arial, bold, and size 20
        firstLine.setHorizontalAlignment(SwingConstants.CENTER);  // Center-align the text horizontally
        firstLine.setVerticalAlignment(SwingConstants.CENTER);    // Center-align the text vertically
        frame.add(firstLine);  // Add the first label to the frame

        // Configure the second label to display the customer name
        secondLine = new JLabel(list.get(index).getCustomer());
        secondLine.setForeground(Color.ORANGE);  // Set the text color to orange
        secondLine.setBackground(Color.BLACK);   // Set the background color to black
        secondLine.setOpaque(true);  // Make the background color visible
        secondLine.setBounds(0, 100, 400, 150);  // Set the label size and position
        secondLine.setFont(new Font("Arial", Font.BOLD, 15));  // Set the font to Arial, bold, and size 15
        secondLine.setHorizontalAlignment(SwingConstants.CENTER);  // Center-align the text horizontally
        secondLine.setVerticalAlignment(SwingConstants.CENTER);    // Center-align the text vertically
        frame.add(secondLine);  // Add the second label to the frame

        // Set up the timer to switch ads every 10 seconds (10,000 ms)
        timer = new Timer(10 * 1000, this);
        timer.setInitialDelay(0);  // Start the timer immediately
        timer.start();  // Start the timer to trigger the action events
        
        // Set the layout manager to null, so we can use absolute positioning
        frame.setLayout(null);
        frame.setVisible(true);  // Make the frame visible
    }

    // Method to update the billboard with a randomly selected Ad from the list (Not considering the paid fees by each customer)
    //public void updateDisplay(){

        //index = rnd.nextInt(this.list.size());
        //firstLine.setText(this.list.get(index).getText());
        //secondLine.setText(this.list.get(index).getCustomer());


    // Method to select a random index based on the fee paid by each customer (weighted selection)
    private int getRandomIndex() {
        // Calculate the total sum of all customer fees
        int totalFees = 0;
        for (Advertisements ads : list)
            totalFees += ads.getFee();  // Add up each ad's fee
        
        // Generate a random value within the range of total fees
        Float randomValue = rnd.nextFloat() * totalFees;

        // Find the index that corresponds to the random value (weighted by fees)
        float cumulativeWeight = 0;
        for (int i = 0; i < list.size(); i++) {
            cumulativeWeight += list.get(i).getFee();  // Add the fee to cumulative weight
            if (randomValue <= cumulativeWeight)       // Check if it falls within the current range
                return i;  // Return the index of the selected ad
        }
        // If something goes wrong, return the last index (fallback)
        return list.size() - 1;
    }

    // Method to display the statistics, including ad display counts and program runtime
    public void displayStats() {
        this.runningTime += timer.getDelay();  // Increment running time by the timer delay (10 seconds)
        
        // Calculate the time in seconds, minutes, and hours
        long seconds = (runningTime / 1000) % 60;
        long minutes = (runningTime / (1000 * 60)) % 60;
        long hours = (runningTime / (1000 * 60 * 60)) % 24;

        // Print the formatted runtime and ad display counts
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Ads Display Counts and Runtime Stats:");
        System.out.printf("The Program has been running for: %02d:%02d:%02d\n", hours, minutes, seconds);
        for (int i = 0; i < list.size(); i++) {
            Advertisements ad = list.get(i);
            System.out.println("    - " + ad.getCustomer() + ": Ad Displayed " + adDisplayCounts[i] + " times.");
        }
        System.out.println("-----------------------------------------------------------------");
    }

    // Method to handle timer events (triggered every 10 seconds)
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            this.ClearConsole();  // Clear the console for a clean display
            int index = getRandomIndex();  // Select a random ad based on fees
            adDisplayCounts[index]++;  // Increment the display counter for the selected ad
            Advertisements ad = list.get(index);  // Get the selected ad

            // Update the labels with the new ad text and customer name
            firstLine.setText(ad.getText());
            secondLine.setText(ad.getCustomer());

            // Display updated statistics
            this.displayStats();
        }
    }

    // Method to clear the console (for a clean terminal display)
    public void ClearConsole() {
        try {
            // Check if the system is Windows
            if (System.getProperty("os.name").contains("Windows")) {
                // Use the "cls" command to clear the console in Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Use ANSI escape codes to clear the console on Unix-based systems
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();  // Print any exceptions
        }
    }
}

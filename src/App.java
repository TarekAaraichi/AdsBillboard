import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class App {
    public static void main(String[] args) throws Exception {

        // Create a List of customers
        ArrayList <Message> textList = new ArrayList<>();

        Message msg1 = new Message("Hederliga Harrys bilar","En bra biläffar (för Harry)", 5000F);
        Message msg2 = new Message("Farmor Ankas Pajer AB","Skynda innan Mårten äter allt!", 2000F);
        Message msg3 = new Message("Svarte Petters Svartbyggen","Bygga svart? Ring Petter", 1500F);
        Message msg4 = new Message("Långbens Detektivbyrå","Mysterier? Ring Långben", 4000F);

        // Store customer data into our list
        textList.add(msg1);
        textList.add(msg2);
        textList.add(msg3);
        textList.add(msg4);
            
        // Create a JFrame
        JFrame frame = new JFrame("Vår fina reklamtavla");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        // Set a timer on our board
        

            // Create a JLabel with HTML for two lines
            //String labelT ext = "<html>First Line<br>Second Line</html>";
            JLabel label1 = new JLabel(textList.get(0).getCustomer());
            JLabel label2 = new JLabel(textList.get(0).getText());
       
            // Add the label to the frame
            frame.add(label1);
            frame.add(label2);

            // Set the frame visibility
            frame.setVisible(true);
                        
        
                
    }

    public Object setVisible(boolean b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setVisible'");
    }
}

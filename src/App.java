import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        // Create a list of messages (advertisements)
        ArrayList <Message> messageList = new ArrayList<>();
        
        // Creates a new instance of the Message class using the constructor
        Message msg1 = new Message("Hederliga Harrys bilar","En bra biläffar (för Harry)", 5000F);
        Message msg2 = new Message("Farmor Ankas Pajer AB","Skynda innan Mårten äter allt!", 2000F);
        Message msg3 = new Message("Svarte Petters Svartbyggen","Bygga svart? Ring Petter", 1500F);
        Message msg4 = new Message("Långbens Detektivbyrå","Mysterier? Ring Långben", 4000F);

        // Adds the messages (objects) to the Array List of messages.
        messageList.add(msg1);
        messageList.add(msg2);
        messageList.add(msg3);
        messageList.add(msg4);

        // Initialize the AdDisplay 
        AdDisplay reklamSkylt = new AdDisplay();

        // Set up the billboard using the "Display" function in "AdDisplay" Class
        reklamSkylt.display(messageList);
    }
}

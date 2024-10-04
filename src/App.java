import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        // Create a list of messages (advertisements)
        ArrayList <Advertisements> advertisements = new ArrayList<>();
        
        // Creates a new instance of the Message class using the constructor
        Advertisements ad1 = new Advertisements("Hederliga Harrys bilar","En bra biläffar (för Harry)", 5000F);
        Advertisements ad2 = new Advertisements("Farmor Ankas Pajer AB","Skynda innan Mårten äter allt!", 2000F);
        Advertisements ad3 = new Advertisements("Svarte Petters Svartbyggen","Bygga svart? Ring Petter", 1500F);
        Advertisements ad4 = new Advertisements("Långbens Detektivbyrå","Mysterier? Ring Långben", 4000F);

        // Adds the messages (objects) to the Array List of messages.
        advertisements.add(ad1);
        advertisements.add(ad2);
        advertisements.add(ad3);
        advertisements.add(ad4);

        // Initialize the AdDisplay 
        AdDisplay billboard = new AdDisplay();

        // Set up the billboard using the "Display" function in "AdDisplay" Class
        billboard.display(advertisements);
    }
}

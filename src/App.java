
import java.util.ArrayList;  // Importing ArrayList to create dynamic lists.

public class App {
    public static void main(String[] args) throws Exception {

        // Creates a list of advertisements using ArrayList
        ArrayList<Advertisements> advertisements = new ArrayList<>();

        // Adds a new Advertisement object to the advertisements list, with an Ad message, a customer name and the paid fee.
        advertisements.add(new Advertisements("Hederliga Harrys bilar", "En bra biläffar (för Harry)", 5000F));
        advertisements.add(new Advertisements("Farmor Ankas Pajer AB", "Skynda innan Mårten äter allt!", 2000F));
        advertisements.add(new Advertisements("Svarte Petters Svartbyggen", "Bygga svart? Ring Petter", 1500F));
        advertisements.add(new Advertisements("Långbens Detektivbyrå", "Mysterier? Ring Långben", 4000F));

        
        // // Creates instances of the "Advertisements" class with Ad text, customer name, and paid fee
        // Advertisements ad1 = new Advertisements("Hederliga Harrys bilar", "En bra biläffar (för Harry)", 5000F);
        // Advertisements ad2 = new Advertisements("Farmor Ankas Pajer AB", "Skynda innan Mårten äter allt!", 2000F);
        // Advertisements ad3 = new Advertisements("Svarte Petters Svartbyggen", "Bygga svart? Ring Petter", 1500F);
        // Advertisements ad4 = new Advertisements("Långbens Detektivbyrå", "Mysterier? Ring Långben", 4000F);

        // // Adds the advertisement objects to the ArrayList
        // advertisements.add(ad1);
        // advertisements.add(ad2);
        // advertisements.add(ad3);
        // advertisements.add(ad4);

        // Initializes an instance of the AdDisplay class, which will handle showing ads
        AdDisplay billboard = new AdDisplay();

        // Calls the display method of AdDisplay to display the advertisements on the billboard
        billboard.display(advertisements);        
    }
}

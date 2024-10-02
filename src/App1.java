// 2.Bygg ett GUI i Java Swing som visar två rader med 16 tecken på varje (med JLabel).

import java.awt.GridLayout;
import javax.swing.*;

public class App1 extends JFrame {
    private JLabel label1, label2;  // Två rader med 16 tecken på varje

    public App1() {
        setTitle("Reklamtavla"); // Titel på fönstret
        setSize(300, 150);       // Storlek på fönstret
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1)); // Två rader layout
    
        // Skapa ett Message-objekt med en text
        Message message = new Message("Här är en text");

        // Visa endast de första 16 tecknen på varje rad
        label1 = new JLabel(message.getText().substring(0, Math.min(message.getText().length(), 16)), SwingConstants.CENTER);
        label2 = new JLabel("Andra raden här", SwingConstants.CENTER);
        
        add(label1);
        add(label2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new App().setVisible(true)); // Starta GUI
    }
}

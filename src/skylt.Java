
public class Skylt implements ActionListener {
   private Timer timer; 
   private JLabel label1;
   private JLabel label2;
   //private ArrayList<Message> mmessageS;
   
   public void run(){
    //Stoppa in i messages
       // Skapa ett "fönster" // FRAME
        JFrame frame = new JFrame("Stefans Reklamskylt");

        frame.setSize(500,300); // Set the size of the frame
        frame.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE);

        label = new JLabel("En fin bilaffär (för mig)");
        //label.setForeground(new Color(93,255,0));
        label.setForeground(Color.CYAN);
        label.setBackground(Color.BLACK);
        label.setOpaque(true);
        label.setBounds(10,0,390,100);
        frame.add(label);


        label2 = new JLabel("Hederlige Harrys bilar");
        //label.setForeground(new Color(93,255,0));
        label2.setForeground(Color.CYAN);
        label2.setBackground(Color.BLACK);
        label2.setOpaque(true);
        label2.setBounds(10,100,390,100);
        frame.add(label2);

        JButton button = new JButton();
        button.setText("Klicka här!");
        button.setBounds(100,200,100,50);
        button.setOpaque(true);
        frame.add(button);

        timer = new Timer(10*1000, this);
        timer.setInitialDelay(10*1000);
        timer.start();                       
 

        frame.setLayout(null);
        // och köra/visa fönster
        frame.setVisible(true);
     
   } 


   @Override
   public void actionPerformed(ActionEvent e) {
       if(e.getSource() == timer){
            // tar en av random Messages
           label.setText("hejsan änbrat!!! ");
           label2.setText("...");
       }

   }
}
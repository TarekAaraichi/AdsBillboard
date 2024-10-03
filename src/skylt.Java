import javax.swing.JFrame;
import javax.swing.JLabel;

public class skylt implements ActionListener {
    private Timer timer;
    
    public  void run(){

        // Skapa FRAME
        JFrame frame = new JFrame("Grupp 7's fina reklamskylt");
        frame.setSize(500,300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE);

        //     

        JLabel label = new JLabel("En fin bilaffär (för mig)");
        label.setForeground(Color.GREEN);
        label.setBackground(Color.BlACK);
        label.setOpaque(true);
        label.setBounds(0,0,390,100)
        frame.add(label)

        JLabel label2 = new JLabel("Hederlige Harrys Bilar");
        label.setForeground(Color.GREEN);
        label.setBackground(Color.BlACK);
        label.setOpaque(true);
        label.setBounds(0,100,390,100)
        frame.add(label2)

        timer new Timer(10*1000, this);
        timer.setInitialDelar(10*1000);
        timer.start();




        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == timer)
            label.setText();
            label2.setText();
    }
   
}

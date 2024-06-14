import javax.swing.*;
import java.awt.*;
import java.awt.event.*;;
public class EnterIn implements ActionListener{

    JFrame frame;
    JPanel panel;
    JButton balanceButton,depositButton,transferButton,withdrawButton,changePinButton,BackButton;
    ImageIcon img;
    JLabel background,heading;
    Font myFont;
    String ac,pin;
    EnterIn(String ac,String pin)
    { this.ac=ac;this.pin=pin;
        //creation for frame,panel,font,buttons,image storing,background label for image
        
        frame         = new JFrame("ATM MODEL");
        myFont        = new Font("Times new roman",Font.BOLD, 15);
        panel         = new JPanel();
        balanceButton = new JButton("Balance");
        depositButton = new JButton("Deposit");
        transferButton  = new JButton("Transfer");
        withdrawButton  = new JButton("Withdraw");
        changePinButton  = new JButton("Change pin");
        BackButton     = new JButton("Back");
        img           = new ImageIcon("Task-3\\7.jpg");
        background    = new JLabel("",img,JLabel.CENTER);
        heading       =new JLabel();
        //setting the width,height and position for frame,panel,background image and buttons
        
        frame.setSize(650,680); 
        frame.setResizable(false);
        panel.setBounds(0,0,650,650);
        background.setBounds(0,0,650,650);
        heading.setText("Please select your requirements :");
        heading.setFont(new Font("Times new roman",Font.BOLD,30));
        heading.setForeground(new Color(204,255,255));
        heading.setBounds(130,30,450,100);
        //left side
        withdrawButton.setBounds(0,180, 150, 70);
        changePinButton.setBounds(0,300 , 150, 70);
        transferButton.setBounds(0,420 , 150, 70);
        //right side
        balanceButton.setBounds(500, 180, 150, 70);
        depositButton.setBounds(500,300 , 150, 70);
        BackButton.setBounds(500, 420, 150, 70);
       
        
        //setting Fontstyle,font color,unfocus,font border,inactive button and actionlistener for buttons in this section
        
        balanceButton.setFont(myFont);
        depositButton.setFont(myFont);
        transferButton.setFont(myFont);
        withdrawButton.setFont(myFont);
        changePinButton.setFont(myFont);
        BackButton.setFont(myFont);
        balanceButton.setBackground(Color.red);
        depositButton.setBackground(Color.red);
        transferButton.setBackground(Color.red);
        withdrawButton.setBackground(Color.red);
        changePinButton.setBackground(Color.red);
        BackButton.setBackground(Color.red);


        balanceButton.setForeground(Color.WHITE);
        depositButton.setForeground(Color.WHITE);
        transferButton.setForeground(Color.WHITE);
        withdrawButton.setForeground(Color.WHITE);
        changePinButton.setForeground(Color.WHITE);
        BackButton.setForeground(Color.WHITE);


        balanceButton.setBorder(BorderFactory.createCompoundBorder());
        depositButton.setBorder(BorderFactory.createEtchedBorder());
        transferButton.setBorder(BorderFactory.createEtchedBorder());
        withdrawButton.setBorder(BorderFactory.createEtchedBorder());
        changePinButton.setBorder(BorderFactory.createEtchedBorder());
        BackButton.setBorder(BorderFactory.createEtchedBorder());
   
        
        balanceButton.setFocusable(false);
        depositButton.setFocusable(false);
        transferButton.setFocusable(false);
        withdrawButton.setFocusable(false);
        changePinButton.setFocusable(false);
        BackButton.setFocusable(false);
       
       
        balanceButton.addActionListener(this);
        depositButton.addActionListener(this);
        transferButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        changePinButton.addActionListener(this);
        BackButton.addActionListener(this);
       
       
        //Here adding the buttons and background image label in the panel and adding the panel in the frame
        
        panel.add(balanceButton);
        panel.add(depositButton);
        panel.add(transferButton);
        panel.add(withdrawButton);
        panel.add(changePinButton);
        panel.add(BackButton);
        panel.add(heading);
        panel.add(background);   
        frame.add(panel);

        //frame visibility,layout,and close operation
        
        panel.setLayout(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    
    }
    public void actionPerformed(ActionEvent e)
    {

           if(e.getSource()==balanceButton)
           {
    //          
            frame.dispose();
            new Balance(ac,pin);
           }
           if(e.getSource()==depositButton)
           {
            frame.dispose();
            new Deposit(ac,pin);
           }
           if(e.getSource()==transferButton)
           {
            frame.dispose();
            new Transfer(ac,pin);
           }
           if(e.getSource()==changePinButton)
           {
            frame.dispose();
            new changePin(ac,pin);
           }
           if(e.getSource()==withdrawButton)
           {
            frame.dispose();
            new Withdraw(ac,pin);}
           if(e.getSource()==BackButton)
           {
            frame.dispose();
            new ATM1();}
    }
    // public static void main(String args[])
    // {
    //     new EnterIn("123456789","1234");
    // }
}

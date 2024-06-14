import javax.swing.*;
import java.awt.*;
import java.awt.event.*;;
public class ATM1 implements ActionListener{

    JFrame frame;
    JPanel panel;
    JButton insertButton,AccountButton;
    ImageIcon img;
    JLabel background,heading;
    Font myFont;
    ATM1()
    {
        //creation for frame,panel,font,buttons,image storing,background label for image
        
        frame         = new JFrame("ATM MODEL");
        myFont        = new Font("Times new roman",Font.BOLD, 15);
        panel         = new JPanel();
        insertButton  = new JButton("Enter in");
        AccountButton = new JButton("New Account");
        img           = new ImageIcon("Task-3\\SukunaWelcome.gif");
        background    = new JLabel("",img,JLabel.CENTER);
        heading       =new JLabel();
        //setting the width,height and position for frame,panel,background image and buttons
        
        frame.setSize(650,680); 
        frame.setResizable(false);
        panel.setBounds(0,0,650,650);
        background.setBounds(0,0,650,650);
        heading.setText("PLEASE SELECT ONE");
        heading.setFont(myFont);
        heading.setSize(200,200);
        //heading.setHorizontalTextPosition(JLabel.CENTER);
        //heading.setVerticalTextPosition(JLabel.TOP);
        heading.setForeground(new Color(204,255,255));
        heading.setBounds(430,160,350,500);
       // heading.setBorder(BorderFactory.createEtchedBorder());
        insertButton.setBounds(500, 450, 120, 50);
        AccountButton.setBounds(500, 540, 120, 50);
       
        
        //setting Fontstyle,font color,unfocus,font border,inactive button and actionlistener for buttons in this section
        
        insertButton.setFont(myFont);
        AccountButton.setFont(myFont);
        insertButton.setBackground(Color.red);
        AccountButton.setBackground(Color.red);
        insertButton.setForeground(Color.WHITE);
        AccountButton.setForeground(Color.WHITE);
        insertButton.setBorder(BorderFactory.createEtchedBorder());
        AccountButton.setBorder(BorderFactory.createEtchedBorder());
        insertButton.setFocusable(false);
        AccountButton.setFocusable(false);
        //insertButton.setEnabled(false);
        insertButton.addActionListener(this);
        AccountButton.addActionListener(this);

        //Here adding the buttons and background image label in the panel and adding the panel in the frame
        panel.add(insertButton);
        panel.add(AccountButton);
          
        panel.add(heading);

        frame.add(panel);
        panel.add(background); 
        //frame visibility,layout,and close operation
        
        panel.setLayout(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    
    }
    public void actionPerformed(ActionEvent e)
    {
            if(e.getSource()==insertButton)
            {
                frame.dispose();
                new AccountChecking();
            }
            if(e.getSource()==AccountButton)
            {
                frame.dispose();
                new NewAccount();
            }
    }
    // public static void main(String[] args) {
    //     new ATM1();
    // }
}

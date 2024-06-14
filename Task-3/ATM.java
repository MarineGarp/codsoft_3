
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATM implements ActionListener{

    JFrame frame;
    JPanel panel;
    JButton insertButton,AccountButton;
    ImageIcon img;
    JLabel background,heading;
    Font myFont;

    ATM()
    {
        //creation for frame,panel,font,buttons,image storing,background label for image
        
        frame         = new JFrame("ATM MODEL");
        myFont        = new Font("Times new roman",Font.BOLD, 15);
        panel         = new JPanel();
        insertButton  = new JButton("Card Way");
        AccountButton = new JButton("Account Way");
        img           = new ImageIcon("Task-3\\SukunaWelcome.gif");
        background    = new JLabel("",img,JLabel.CENTER);
        heading       =new JLabel();
        //setting the width,height and position for frame,panel,background image and buttons
        
        frame.setSize(650,680); 
        frame.setResizable(false);
        panel.setBounds(0,0,650,650);
        background.setBounds(0,0,650,650);
        heading.setText("PLEASE SELECT A WAY");
        heading.setFont(myFont);
        heading.setForeground(new Color(204,255,255));
        heading.setBounds(430,160,350,500);
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
        AccountButton.addActionListener(this);

        //Here adding the buttons and background image label in the panel and adding the panel in the frame
        
        panel.add(insertButton);
        panel.add(AccountButton);
        panel.add(heading);
        panel.add(background);   
        frame.add(panel);

        //frame visibility,layout,and close operation
        
        panel.setLayout(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    
    }
    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource() == AccountButton)
        {
            frame.dispose();
           ATM1 atm= new ATM1();
        }

    }
    public static void main(String[] args) {
        new ATM();
    }
}

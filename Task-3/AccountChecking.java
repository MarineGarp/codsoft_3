import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AccountChecking implements ActionListener{

    JFrame frame;
    JPanel panel;
    JButton insertButton,delbutton,clrbutton,backButton;
    JButton[] numberButtons=new JButton[10];
    JTextField text;
    ImageIcon img;
    JLabel heading,background;
    Font myFont;

    AccountChecking()
    {
        //creation for frame,panel,font,buttons,image storing,background label for image,clrbutton deletebutton,textfield
        
        frame         = new JFrame("ATM MODEL");
        myFont        = new Font("Times new roman",Font.BOLD, 15);
        panel         = new JPanel();
        insertButton  = new JButton("Enter");
        img           = new ImageIcon("Task-3\\blackScreen.jpg");
        background    = new JLabel("",img,JLabel.CENTER);
        text          = new JTextField();
        delbutton     = new JButton("Delete");
        clrbutton     = new JButton("Clear");
        heading       =new JLabel();
        backButton    =new JButton("Back");
       
        
        //setting the width,height and position for frame,panel,background image and buttons
        
        frame.setSize(650,680); 
        frame.setResizable(false);
        panel.setBounds(100,200,420,400);
        panel.setLayout(new GridLayout(5,5,50,50));
        panel.setVisible(true);
        panel.setBackground(new Color(0,0,0,0));
        background.setBounds(0,0,650,650);
        heading.setText("Enter your account number :");
        heading.setFont(new Font("Times new roman",Font.BOLD,30));
        heading.setForeground(new Color(204,255,255));
        heading.setBounds(140,10,400,100);
        insertButton.setBounds(220, 550, 180, 40);
        text.setBounds(150,100,320,50);
        text.setHorizontalAlignment(JLabel.CENTER);
        backButton.setBounds(520, 570, 100, 50);
        backButton.setFont(myFont);
        backButton.setForeground(Color.white);
        backButton.setBackground(Color.red);
        backButton.setFocusable(false);
        
        
        //setting Fontstyle,font color,unfocus,font border,inactive button and actionlistener for buttons in this section
        text.setFont(myFont);
        text.setEditable(true);
        insertButton.setFont(new Font("Times new roman",Font.BOLD, 20));
      
        insertButton.setBackground(Color.GREEN);
      
        insertButton.setForeground(Color.WHITE);
      
        insertButton.setBorder(BorderFactory.createEtchedBorder());
      
        insertButton.setFocusable(false);
      
      
        insertButton.addActionListener(this);
      

       

        
        
        
        
         //Here adding the buttons and background image label in the panel and adding the panel in the frame
        
         //numbers
        for(int i =0;i<10;i++)
        {
            numberButtons[i]= new JButton(String.valueOf(i));
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(Color.BLUE);
            numberButtons[i].setForeground(Color.WHITE);
            numberButtons[i].setBorder(BorderFactory.createEtchedBorder());
            numberButtons[i].addActionListener(this);

        }
       
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        delbutton.setBounds(40,500,205,50);
        delbutton.setFocusable(false);
        delbutton.setBackground(Color.red);
        delbutton.setForeground(Color.WHITE);
        delbutton.setBorder(BorderFactory.createEtchedBorder());
        clrbutton.setBounds(255,500,205,50);
        clrbutton.setFocusable(false);
        clrbutton.setBackground(Color.red);
        clrbutton.setForeground(Color.WHITE);
        clrbutton.setBorder(BorderFactory.createEtchedBorder());
        panel.add(delbutton);
        panel.add(numberButtons[0]);
        delbutton.addActionListener(this);
        panel.add(clrbutton);
        clrbutton.addActionListener(this);
        backButton.addActionListener(this);
        frame.add(backButton);
         frame.add(panel);
         frame.add(text);
         frame.add(insertButton);
         frame.add(heading);
         frame.add(background); 
        //frame visibility,layout,and close operation 
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    
    
    }
    public String AccountNumbers;
    public void actionPerformed(ActionEvent e)
    {
        for(int i=0;i<10;i++)
        {
            if(e.getSource()==numberButtons[i])
            {
                
                text.setText(text.getText()+String.valueOf(i));
               
            
            }
        }AccountNumbers=text.getText();
        if(e.getSource()==delbutton)
        {
            if(text.getText().length()>0){
                text.setText(text.getText().substring(0, text.getText().length()-1));
            }
        }
         if(e.getSource()==clrbutton)
        {
       
            text.setText("");
        }
        if(e.getSource()==backButton)
        {
            frame.dispose();
            new ATM1();
        }
        if(e.getSource()==insertButton)
        {
            if(AccountNumbers.length()==12)
            {  
            try{
                String url= "jdbc:mysql://localhost:3306/test"; // table details
                String username = "root"; // MySQL credentials
                String password = "";
                String query= "SELECT * FROM Atm_users WHERE AccountNumber ="+"'"+AccountNumbers+"'"; // query to be run
                Class.forName("com.mysql.cj.jdbc.Driver"); // Driver name
                Connection con = DriverManager.getConnection(url,username,password);
                Statement st = con.createStatement();
                ResultSet rs= st.executeQuery(query);
                if( rs.next()) // Execute query
                {
                    rs.getString("AccountNumber");
                    System.out.println("Connected to your account!!");
                    frame.dispose();
                    new PinChecking(AccountNumbers);
                }
                else{
                    JOptionPane.showMessageDialog(frame, "Wrong account number", "Incorrect Account number", JOptionPane.ERROR_MESSAGE);
                    text.setText("");
                    System.out.println("Not connected to your account!!");}
                st.close(); // close statement
                con.close(); // close connection
                }
       
       
                catch(Exception ae){
                        System.out.println(ae);
                    }
                }
                else
                {  
                     JOptionPane.showMessageDialog(frame, "Account number must contains 12 numbers", "Incorrect Account number", JOptionPane.INFORMATION_MESSAGE);

                }
                  
        }
    }
    public static void main(String[] args) {
        new AccountChecking();
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Balance implements ActionListener{

    JFrame frame;
    JPanel panel;
    JButton insertButton,AccountButton;
    ImageIcon img;
    JLabel background,heading;
    Font myFont;
    String ac,pin,query;
    Balance(String ac,String pin)
    { this.ac=ac;this.pin=pin;
         heading=new JLabel();
       
       
        try{
            String url= "jdbc:mysql://localhost:3306/test"; // table details
            String username = "root"; // MySQL credentials
            String password = "";
            query= "SELECT Balance FROM Atm_users WHERE AccountNumber ="+"'"+ac+"'"; // query to be run
            
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver name
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(query);
            if(rs.next()) // Execute query
            {
                //rs.getInt(query);
                heading.setText("Account Balance : "+rs.getString("Balance"));
                System.out.println("Balance is "+rs.getString("Balance"));
            }
            st.close(); // close statement
            con.close(); // close connection
            }
                catch(Exception ae)
                {
                    System.out.println(ae);
                }
        //creation for frame,panel,font,buttons,image storing,background label for image
        
        frame         = new JFrame("ATM MODEL");
        myFont        = new Font("Times new roman",Font.BOLD, 15);
        panel         = new JPanel();
        insertButton  = new JButton("Back");
        img           = new ImageIcon("Task-3\\BalancePanel.gif");
        background    = new JLabel("",img,JLabel.CENTER);
       
        //setting the width,height and position for frame,panel,background image and buttons
        
        frame.setSize(650,680); 
        frame.setResizable(false);
        panel.setBounds(0,0,650,650);
        background.setBounds(0,0,650,650);
        
        heading.setFont(new Font("Times new roman",Font.BOLD,30));
        heading.setSize(300,300);
        heading.setForeground(Color.RED);
        heading.setBounds(180,270,500,100);
        insertButton.setBounds(500, 550, 120, 50);
       
        
        //setting Fontstyle,font color,unfocus,font border,inactive button and actionlistener for buttons in this section
        
        insertButton.setFont(myFont);
        insertButton.setBackground(Color.red);
        insertButton.setForeground(Color.WHITE);
        insertButton.setBorder(BorderFactory.createEtchedBorder());
        insertButton.setFocusable(false);
        insertButton.addActionListener(this);
       

        //Here adding the buttons and background image label in the panel and adding the panel in the frame
        panel.add(insertButton);
         
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
                new EnterIn(ac,pin);
            }
    }
    // public static void main(String[] args) {
    //     Balance obj=new Balance("123456789","1234");
    // }
}

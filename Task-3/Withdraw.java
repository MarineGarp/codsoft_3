import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
public class Withdraw implements ActionListener{

    JFrame frame;
    JPanel panel;
    JButton insertButton,delbutton,clrbutton,backButton;
    JButton[] numberButtons=new JButton[10];
    JTextField text;
    ImageIcon img;
    JLabel background,heading;
    Font myFont;
    String ac,pin;
    Withdraw(String ac,String pin)
    { this.ac=ac;this.pin=pin;
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
        heading       = new JLabel();
        backButton      =new JButton("Back");
        
        //setting the width,height and position for frame,panel,background image and buttons
        
        frame.setSize(650,680); 
        frame.setResizable(false);
        panel.setBounds(100,200,420,400);
        panel.setLayout(new GridLayout(5,5,50,50));
        panel.setVisible(true);
        panel.setBackground(new Color(0,0,0,0));
        background.setBounds(0,0,650,650);
        heading.setText("Enter your withdraw amount :");
        heading.setFont(new Font("Times new roman",Font.BOLD,30));
        heading.setForeground(new Color(204,255,255));
        heading.setBounds(140,10,400,100);
        insertButton.setBounds(220, 550, 200, 40);
        text.setBounds(150,100,320,50);
        backButton.setBounds(520, 570, 100, 50);
        backButton.setFont(myFont);
        backButton.setForeground(Color.white);
        backButton.setBackground(Color.red);
        backButton.setFocusable(false);
        
        //setting Fontstyle,font color,unfocus,font border,inactive button and actionlistener for buttons in this section
        text.setFont(myFont);
        text.setEditable(true);
        text.setHorizontalAlignment(JLabel.CENTER);
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
         frame.add(panel);
         frame.add(text);
         frame.add(insertButton);
         frame.add(heading);
         frame.add(backButton);
         frame.add(background); 
        //frame visibility,layout,and close operation 
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    
    }
    String pinstore="";int bal;
    public void actionPerformed(ActionEvent e)
    {
        for(int i=0;i<10;i++)
        {
            if(e.getSource()==numberButtons[i])
            {

                    pinstore+=((JButton)e.getSource()).getText();
                    text.setText(text.getText()+String.valueOf(i));              
            }
           
        }pin=text.getText();
        if(e.getSource()==delbutton)
        {
            if(text.getText().length()>0){
                text.setText(text.getText().substring(0, text.getText().length()-1));
            }
        }
        if(e.getSource()==backButton)
        {
            frame.dispose();
            new EnterIn(ac, pin);
        }
         if(e.getSource()==clrbutton)
        {
            text.setText("");
        }
        if(e.getSource()==insertButton)
        {
            try{
                String url= "jdbc:mysql://localhost:3306/test"; // table details
                String username = "root"; // MySQL credentials
                String password = "";
                int input=Integer.parseInt(pinstore);
                Class.forName("com.mysql.cj.jdbc.Driver"); // Driver name
                Connection con = DriverManager.getConnection(url,username,password);
                Statement st = con.createStatement();
                ResultSet rs;
                String query1="SELECT * FROM Atm_users WHERE AccountNumber="+"'"+ac+"'"; // query to be run
                rs=st.executeQuery(query1);
                rs.next();
                bal=Integer.parseInt(rs.getString("Balance"));
                if(input<bal)
                {
                String query= "UPDATE Atm_users SET Balance="+"'"+(bal-input)+"'"+" WHERE AccountNumber="+"'"+ac+"'"; // query to be run
                int b=st.executeUpdate(query);
                if(b>0) // Execute query
                {
                    //rs.getInt(query);
                    System.out.println("Transaction succeed!!");
                    frame.dispose();
                    new EnterIn(ac,pinstore);
                }
                else
                {
                    JOptionPane.showMessageDialog(frame,"Transaction failed","Failed",JOptionPane.INFORMATION_MESSAGE);
                    text.setText("");    
                    System.out.println("Transaction failed!!");
                }
                }
                else{
                    JOptionPane.showMessageDialog(frame,"Insufficient amount","Failed",JOptionPane.INFORMATION_MESSAGE);
                }
                st.close(); // close statement
                con.close(); // close connection
                }
                    catch(Exception ae){
                        System.out.println(ae);
                    }
        }
    }
    // public static void main(String[] args) {
    //     new Withdraw("123456789","1234");
    // }
}
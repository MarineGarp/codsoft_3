import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;;
public class changePin implements ActionListener{

    JFrame frame;
    JPanel panel,form;
    JButton insertButton,AccountButton;
    ImageIcon img;
    JLabel background,heading,fromac,toac,amount;
    JTextField text1,text2,text3;
    Font myFont;
    String ac,pin;
    changePin(String ac,String pin)
    {
        this.ac=ac;
        this.pin=pin;
        //creation for frame,panel,font,buttons,image storing,background label for image
        
        frame         = new JFrame("ATM MODEL");
        myFont        = new Font("Times new roman",Font.BOLD, 25);
        panel         = new JPanel();
        form          = new JPanel();
        insertButton  = new JButton("Enter");
        AccountButton =new JButton("Back");
        img           = new ImageIcon("Task-3\\blackScreen.jpg");
        background    = new JLabel("",img,JLabel.CENTER);
        heading       =new JLabel();
        fromac        =new JLabel("Enter your old pin :");
        toac          =new JLabel("Enter your new pin :");
        amount        =new JLabel("Re-enter new pin :");
        text1         =new JTextField();
        text2         =new JTextField();
        text3         =new JTextField();
        //setting the width,height and position for frame,panel,background image and buttons
        form.setLayout(new GridLayout(4,2,15,25));
        frame.setSize(650,680); 
        frame.setResizable(false);
        panel.setBounds(0,0,650,650);
        background.setBounds(0,0,650,650);
        heading.setText("Change Pin");
        heading.setFont(new Font("Times new roman",Font.BOLD,30));
        heading.setForeground(new Color(204,255,255));
        heading.setBounds(170,20,350,200);
        insertButton.setBounds(220, 500, 200, 80);
        AccountButton.setBounds(520, 570, 100, 50);
        form.setBounds(100,200,420,300);
        form.setBackground(new Color(0,0,0,0));
        form.setVisible(true);
        text1.setBounds(325,150,300,20);
        text2.setBounds(325,250,300,20);
        text3.setBounds(325,350,300,20);
        text1.setBorder(BorderFactory.createEtchedBorder());
        text2.setBorder(BorderFactory.createEtchedBorder());
        text3.setBorder(BorderFactory.createEtchedBorder());
        
        //setting Fontstyle,font color,unfocus,font border,inactive button and actionlistener for buttons in this section
        text1.setFont(myFont);
        text1.setEditable(true);
        text1.setHorizontalAlignment(JLabel.CENTER);
        text2.setFont(myFont);
        text2.setEditable(true);
        text2.setHorizontalAlignment(JLabel.CENTER);
        text3.setFont(myFont);
        text3.setEditable(true);
        fromac.setFont(new Font("Times new roman",Font.BOLD,20));
        toac.setFont(new Font("Times new roman",Font.BOLD,20));
        amount.setFont(new Font("Times new roman",Font.BOLD,20));
        text3.setHorizontalAlignment(JLabel.CENTER);
        fromac.setForeground(Color.white);
        toac.setForeground(Color.WHITE);
        amount.setForeground(Color.WHITE);
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
        panel.add(heading);
        form.add(fromac);
        form.add(text1);
        form.add(toac);
        form.add(text2);
        form.add(amount);
        form.add(text3);
        panel.add(form); 
        panel.add(insertButton);
        panel.add(AccountButton);
       
        panel.add(background);   
        frame.add(panel);

        //frame visibility,layout,and close operation
        
        panel.setLayout(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    
    }
    String query1,t1,t2,t3;
    int bal,bal1;
    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource()==insertButton)
        {
            t1 = text1.getText();
             t2 = text2.getText();
             t3 = text3.getText(); 
          try{
            String url= "jdbc:mysql://localhost:3306/test"; // table details
            String username = "root"; // MySQL credentials
            String password = "";
           int input1=Integer.parseInt(t1);
           // int input2=Integer.parseInt(t2);
            int input3=Integer.parseInt(t3);
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver name
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();
            ResultSet rs;
            String query="SELECT * FROM Atm_users WHERE AccountNumber="+"'"+ac+"'"; // query to be run
            rs=st.executeQuery(query);
            rs.next();
            bal1=Integer.parseInt(rs.getString("PinNumber"));
            if(input1==bal1)
            {
            query1= "UPDATE Atm_users SET PinNumber="+"'"+(input3)+"'"+" WHERE AccountNumber="+"'"+ac+"'"; // query to be run
            int b1=st.executeUpdate(query1);
            if(b1>0) // Execute query
            {
                //rs.getInt(query);
                System.out.println("Pin changed successfully!!");
                frame.dispose();
                new EnterIn(ac,pin);
            }
            else
            {
                JOptionPane.showMessageDialog(frame,"Pin not changed!!","Failed",JOptionPane.INFORMATION_MESSAGE);
                text1.setText("");    
                text2.setText("");    
                text3.setText("");    
                System.out.println("Pin change failed!!");}
             // close connection
            }
            else
            {
                JOptionPane.showMessageDialog(frame,"Process Failed","Failed",JOptionPane.ERROR_MESSAGE);
            }st.close(); // close statement
            con.close();
        }
                catch(Exception ae)
                {
                    System.out.println(ae);
                }
            }
        if(a.getSource() == AccountButton)

        {
            frame.dispose();
            new EnterIn(ac,pin);
        }

    }
    // public static void main(String[] args) {
    //    new changePin("123456789","1234");
    // }
}
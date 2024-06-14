import javax.swing.*;
import java.awt.*;
public class LoadingPanel {
    JFrame frame;
    JPanel panel;
    ImageIcon img;
    JLabel background,heading;
    JProgressBar bar;
    String ac,pin;
    LoadingPanel(String ac,String pin)
    {
        //creation for frame,panel,font,buttons,image storing,background label for image
        
        frame         = new JFrame("ATM MODEL");
        panel         = new JPanel();
        img           = new ImageIcon("Task-3\\SukunaSittingLoadingPanel.gif");
        background    = new JLabel("",img,JLabel.CENTER);
        heading       =new JLabel("Processing...");
        bar=new JProgressBar();
        //setting the width,height and position for frame,panel,background image and buttons
        bar.setValue(0);
        bar.setBounds(125,460,400,50);
        bar.setStringPainted(true);
        bar.setFont(new Font("Times new roman",Font.BOLD,20));
        bar.setBackground(Color.white);
        bar.setForeground(Color.red);
        frame.setSize(650,680); 
        frame.setResizable(false);
        panel.setBounds(0,0,650,650);
        background.setBounds(0,0,650,650);
        heading.setFont(new Font("Times new roman",Font.BOLD,20));
        heading.setForeground(new Color(204,255,255));
        heading.setBounds(150,400,350,50);
       
        
        //setting Fontstyle,font color,unfocus,font border,inactive button and actionlistener for buttons in this section
//         JProgressBar loadingBar=new JProgressBar(0,100);
//         loadingBar.setStringPainted(true);
//         loadingBar.setBounds(100,100,300,300);
//         panel.add(loadingBar);
// try{
//    int i=0;
//         while(i<=100)
//        {
//            loadingBar.setValue(i);
//            Thread.sleep(500);
//            i++;
//        }}
//        catch(Exception ae)
//        {
//            System.out.println(ae);
//        }    
   
    panel.add(bar);
    //Here adding the buttons and background image label in the panel and adding the panel in the frame
    panel.add(heading);
    panel.add(background);   
    frame.add(panel);
    // fill();

    int counter=0;
    while(counter<=100)
    {
        bar.setValue(counter);
        try{
            Thread.sleep(500);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        counter++;
    }
    bar.setString("Done :)");
        //frame visibility,layout,and close operation
        panel.setVisible(true);
        panel.setLayout(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        // frame.dispose();
        // new EnterIn(ac,pin);
        
}
public void fill()
        {
        }
        public static void main(String[] args) {
            new LoadingPanel("1234567890","23");
        }
        
}
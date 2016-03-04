/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickettest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author mark
 */
public class LogIn extends JPanel implements ActionListener{
    
    
     JLabel nameLabel;
       JLabel passwordLabel;
         JLabel titleLabel;
       JLabel logoLabel;
       
    JTextField passwordField;
    JTextField nameField;
    
    JButton logInButton;
    JButton signUpButton;
    JButton pic;
    
    Timer t;
    boolean showButtons = true;
    int counter = 1;
    
    
    
        DBconnector raelene;
    
    
    
    public LogIn(){
    
        
        super();
        
        setLayout(null);
        
        
        init();
        
    }
    
    private void init(){
        
        Color randomColor = new Color(162, 223, 254);
        setBackground(randomColor);
        
        t= new Timer(600, this);
        t.start();
        
        raelene = new DBconnector();
        //raelene = tickettest.TicketTest.dbConnector;
        
        titleLabel =  new JLabel("<html><h1>TicketTron 6000</h1></html>");
      titleLabel.setBounds(140,2, 200,50);
        add(titleLabel);
        
      nameLabel =  new JLabel("<html><h2>name:</h2></html>");
      nameLabel.setBounds(196,80, 110,40);
        add(nameLabel);
        nameField = new JTextField();
     nameField.setBounds(140,120, 180,40);
        add( nameField);
       passwordLabel =  new JLabel("<html><h2>password:</h2></html>");
       passwordLabel.setBounds(180,170, 110,40);
        add(passwordLabel);
        
    passwordField = new JTextField();
    passwordField.setBounds(140, 210, 180,40);
        add(passwordField);
    
      
        
       logInButton =  new JButton("log in");
       logInButton.setBounds(100,320, 110,40);
       logInButton.addActionListener(this);
        add(logInButton);
        signUpButton  =  new JButton("sign up");
       signUpButton.setBounds(250,320, 110,40);
        signUpButton.addActionListener(this);
        add(signUpButton);
        
        
        
        pic = new JButton("pic");
        pic.setBounds(170,450, 120,120);
        String picname = "images/logo1.png"; 
        ImageIcon monkeyPic = new ImageIcon(picname);
        pic.setIcon(monkeyPic);
        add(pic);
        
        
        
        
        
    }  // end init
    
    
    
    
         @Override
         public void actionPerformed(ActionEvent event){

       	Object obj = event.getSource();
       
    
         if (obj == t){
              
             counter++;
             
             
             if(!showButtons){
              counter = 1000;
              showButtons = true;
             }
             
             if(counter > 1001){
                 
                showButtons(); 
                counter = 1;
             }
             
             
                 
                } //end if timer
        
        
                if (obj == signUpButton){
                  int timeStamp = (int)System.currentTimeMillis();
                  String myName = nameField.getText();
                 raelene.enterUser(timeStamp, myName, passwordField.getText(), 8);
                 //tickettest.TicketTest.makeMaster(new User(myName, timeStamp));
                 tickettest.TicketTest.screen.createScreen(7,1);
                 
                }
                
                 if (obj == logInButton){
                  
                  String myName = nameField.getText();
                  String myPassword = passwordField.getText();
                  
                 if(raelene.checkThatPassword( myName, myPassword)){
                  tickettest.TicketTest.screen.createScreen(7,1);   
                 }else{
                     
                   hideButtons();
                 }
               
                 
                 
                }
                
                
                
                
                
                 
         }  // end action listener
    
    
    
    
    
   private void hideButtons(){
        showButtons = false;
        titleLabel.setText("<html><h1>Access Denied</h1></html>");
        nameLabel.setVisible(false);
        passwordLabel.setVisible(false);
        passwordField.setVisible(false);
        nameField.setVisible(false);
        logInButton.setVisible(false);
        signUpButton.setVisible(false);
       
       
   }  // end hide buttons
    
    
   private void showButtons(){
        titleLabel.setText("<html><h1>TicketTron 6000</h1></html>");
      nameLabel.setVisible(true);
        passwordLabel.setVisible(true);
        passwordField.setVisible(true);
        nameField.setVisible(true);
        logInButton.setVisible(true);
        signUpButton.setVisible(true);
       
       
   } // end show buttons
    
    
    
    
    
    
    
}  // end class

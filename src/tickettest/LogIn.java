/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickettest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author mark
 */
public class LogIn extends JPanel implements ActionListener{
    
    
     JLabel nameLabel;
       JLabel passwordLabel;
    JTextField passwordField;
    JTextField nameField;
    
    JButton logInButton;
    JButton signUpButton;
    
        DBconnector raelene;
    
    
    
    public LogIn(){
    
        
        super();
        
        setLayout(null);
        
        
        init();
        
    }
    
    private void init(){
        
        
        raelene = new DBconnector();
      nameLabel =  new JLabel("name");
      nameLabel.setBounds(200,68, 110,40);
        add(nameLabel);
        nameField = new JTextField();
     nameField.setBounds(140,98, 180,40);
        add( nameField);
       passwordLabel =  new JLabel("password");
       passwordLabel.setBounds(200,168, 110,40);
        add(passwordLabel);
        
    passwordField = new JTextField();
    passwordField.setBounds(140, 198, 180,40);
        add(passwordField);
    
      
        
       logInButton =  new JButton("log in");
       logInButton.setBounds(100,360, 110,40);
       logInButton.addActionListener(this);
        add(logInButton);
        signUpButton  =  new JButton("sign up");
       signUpButton.setBounds(250,360, 110,40);
        signUpButton.addActionListener(this);
        add(signUpButton);
        
        
    }  // end init
    
    
    
    
         @Override
         public void actionPerformed(ActionEvent event){

       	Object obj = event.getSource();
       
    
        
        
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
                     nameLabel.setText("access denied");
                 }
               
                 
                 
                }
                
                
                
                
                
                 
         }  // end action listener
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}  // end class

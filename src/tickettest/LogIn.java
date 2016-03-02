/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickettest;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author mark
 */
public class LogIn extends JPanel{
    
    
     JLabel nameLabel;
       JLabel passwordLabel;
    JTextField passwordField;
    JTextField nameField;
    
    JButton logInButton;
    JButton signUpButton;
    
    public LogIn(){
    
        
        super();
        
        setLayout(null);
        
        
        init();
        
    }
    
    private void init(){
        
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
        add(logInButton);
        signUpButton  =  new JButton("sign up");
       signUpButton.setBounds(250,360, 110,40);
        add(signUpButton);
        
        
    }
    
}  // end class

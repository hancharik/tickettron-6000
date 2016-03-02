/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickettest;

import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author mah537
 */
public class DisplayPanel extends JPanel{
    
    
    TPanel ticketPanel;
    TicketPage ticket;
     HomePage homePage;
    JPanel mainPanel;
    
    public DisplayPanel(int displayChoice){
    
        super();
    
        setLayout(new GridLayout(1,2));
        
        switch(displayChoice){
            case 1 :  homePage() ; break; 
            case 2 :     makeTicket(3); break; 
        }
        
      
    
    
} // end constructor
 
    
        public DisplayPanel(int displayChoice, int choice){
    
        super();
    
        setLayout(new GridLayout(1,2));
        
        switch(displayChoice){
            case 1 :  homePage() ; break; 
            case 2 :     makeTicket(choice); break; 
        }
        
      
    
    
} // end constructor
    
    public void makeTicket(int d){
        
        
      //  this.remove(mainPanel);
        ticket = new TicketPage(d);
        add(ticket);
     // repaint();
        
    }  // end make stuff
  

    
    
  public void homePage(){
      
       
      
     //  this.remove(mainPanel);
       mainPanel  = new HomePage(tickettest.TicketTest.master);
       add(mainPanel);
      // repaint();
      //ticket.setVisible(false);
      //homePage.setVisible(true);
  }    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}  // end class

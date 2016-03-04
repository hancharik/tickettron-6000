/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickettest;

/**
 *
 * @author mah537
 */
public class TicketTest {

   static TFrame screen;
   static User master;
   public static DBconnector dbConnector;
    public static void main(String[] args) {
          dbConnector = new DBconnector();
        master = new User("mark", 11);
       screen = new TFrame();
     
       
    }
    
 
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickettest;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author mah537
 */
public class TFrame extends JFrame{
    
   
    DisplayPanel display1 = new DisplayPanel(1);  // 1 is homepage
    DisplayPanel display2;// = new DisplayPanel(2);  // 2 is ticket page, 2nd int is category
    LogIn logIn = new LogIn();
    
    public TFrame(){
        super ("Ticket Test 6000");
        
       
                
                getContentPane().setLayout(new BorderLayout());
             
                // createScreen(1,1); // this works!!!
                 createScreen(6,1); 
                
                
                setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize (480,620);
                this.setLocation(400, 100);
		setVisible(true);
    } // end constructor
   
    
    public void createScreen(int choice, int category){
        
  
       switch(choice){
           case 1 :    getContentPane().add(display1,"Center");  break;
            case 2 :    getContentPane().remove(display1); display2 = new DisplayPanel(2, category); getContentPane().add(display2,"Center"); break;//display2 = new DisplayPanel(2,category); getContentPane().add(display2,"Center"); break;
            case 3 :    getContentPane().remove(display2);  getContentPane().add(display1,"Center"); break;
            case 4 :    getContentPane().remove(display1);  display2 = new DisplayPanel(2, category); getContentPane().add(display2,"Center"); break;
            case 5 :    getContentPane().remove(display1);  display1 = new DisplayPanel(1); getContentPane().add(display1,"Center"); break;
             case 6 :    getContentPane().add(logIn,"Center");  break;
              case 7 :    getContentPane().remove(logIn);  display1 = new DisplayPanel(1); getContentPane().add(display1,"Center"); break;
               case 8 :    getContentPane().remove(display1);  logIn = new LogIn(); getContentPane().add(logIn,"Center");  break;
       }
       repaint();
            setVisible(true);
  
        }  // end create screen one variable
    
    
}

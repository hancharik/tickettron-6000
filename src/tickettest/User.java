/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickettest;

import java.util.ArrayList;

/**
 *
 * @author mark
 */
public class User {
    
    
    private String name;
    private int idNumber;
    private ArrayList<Category> contacts;
    private String picture = "images/tf1.jpg";
    private int colorTheme = 4;
    
    
    
    
    public User(String name, int id){
    
       this.name = name; 
        idNumber = id;
        initContacts();
     }  // end constructor
    
   private void initContacts(){
       
       contacts = new ArrayList();
       Category c1 = new Category(1, "notes");
       Category c2 = new Category(2, "Space Patrol");
       Category c3 = new Category(3, "Driver");
       Category c4 = new Category(4, "tickets");
       contacts.add(c1);
       contacts.add(c2);
       contacts.add(c3);
       contacts.add(c4);
       
       Category c5 = new Category(5, "aspirations");
       contacts.add(c5);
   }
    
    
    public String getName(){
        
        return name;
    }
    
    public ArrayList getContacts(){
     
        return contacts;
    }
    
     public String getPicture(){
        
        return picture;
    }
    
    public int getTheme(){
        
        
        
        return colorTheme;
    }
     
   public void addCategory(Category c){
       
       contacts.add(c);
       
   }  
     public int getId(){
         
         return idNumber;
         
     }
     
     
}// end class
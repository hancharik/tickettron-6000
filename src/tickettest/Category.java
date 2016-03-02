/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickettest;

/**
 *
 * @author mark
 */
public class Category {
    
    
    private int identifier;
    private String name;
    
    
        public Category(int id, String name){
    
          identifier = id;
          this.name = name;
        }  // end constructor
    
    public int getId(){
        
        
        return identifier;
    }
    
    public String getName(){
        
       return name; 
        
    }
    
    
            
}//

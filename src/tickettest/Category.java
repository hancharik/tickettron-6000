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
    private DBconnector raelene;
    
        public Category(int id, String name, int owner){
    
          identifier = id;
          this.name = name;
          enterIntoDatabase(id, name, owner);
          
        }  // end constructor
    
    public int getId(){
        
        
        return identifier;
    }
    
    public String getName(){
        
       return name; 
        
    }
    
   private void enterIntoDatabase(int ii, String nn, int oo){
       
      raelene = new DBconnector();
      raelene.writeToTopics(ii, nn, oo); 
       
       
       
   } 
            
}//

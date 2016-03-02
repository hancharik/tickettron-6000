/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickettest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;
import static tickettest.TicketTest.master;

/**
 *
 * @author mark
 */
public class DBconnector {
    
    int size = 100;
    int mapArraySize = 20;//(testdbconnector.TestDBConnector.mapSize * testdbconnector.TestDBConnector.mapSize) + 1;
    public boolean[] stars = new boolean[mapArraySize];
    int counter = 1;
    String head;
    String tail;
    
   public  DBconnector() {
       
      //getConnection(); 
      System.out.println("good to go.\n LET WRITE TO SOME DATABASES, BABY!"); 
    
     
   
      System.out.println(" very ok."); 
  
      System.out.println(" very very ok.");
 
   }
    
    
    

      
          private Connection getConnection() {
        Connection connection = null;
        try
        {
            // if necessary, set the home directory for Derby
          //  String dbDirectory = "c:/murach/java/db";
          //  System.setProperty("derby.system.home", dbDirectory);

            // set the db url, username, and password
            String url = "jdbc:derby://localhost:1527/space";
            String username = "spaceuser";
            String password = "spaceuser";

            connection = DriverManager.getConnection(url, username, password);
			return connection;
                     
                        
        }
        catch(SQLException e)
        {
            System.err.println(e);
			return null;
        }
    }  //end getConnection
      
      
        public void createDatabase(){
            
            
            
            
            
            
            
            
            
            
        }  
          
          
          
          
     ////////////////////////////////////////////////////////////////     
     ////////////////////////////////////////////////////////////////////////////
          
             public void writeToMemo(int id, int from, int to, String head, String tail) {
    
           String sql =
                
            "INSERT INTO SPACEUSER.MEMO (memoid, memofrom, memoto, memohead, memotail) VALUES (?, ?, ?, ?, ?)" ;
           
           

           
           
           
           
           
           
           
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ){   
            
           // counter = 1;
            
           
                    ps.setInt(1, id);
                    ps.setInt(2, from);
                    ps.setInt(3, to);
                    ps.setString(4, head);
                    ps.setString(5, tail);
                    
                     ps.executeUpdate();
                  //  System.out.println("(" + i + "," + j + ")  id: " + counter + " empty: " );
                   
            ResultSet results = ps.getGeneratedKeys();
results.next(); // Assume just one auto-generated key; otherwise, use a while loop here
System.out.println("result success! "+ results.getInt(1)); // 
            
           //  System.out.println("FUCK YEAH BABY...\n PULL THEM TITTIES OUT!");
           
           
           
        }
        catch(SQLException e)
        {
            System.err.println(e);
            
        }
        
  
        
        
    }  // end write to memo
     
             
             
         ////////////////////////////////////////////////////////////////     
     ////////////////////////////////////////////////////////////////////////////
          
             public void writeToTopics(int id, String name, int owner) {
    
           String sql =
                
            "INSERT INTO SPACEUSER.TOPICS (id, name, owner) VALUES (?, ?, ?)" ;

           
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ){   
            
           // counter = 1;
            
           
                    ps.setInt(1, id);
                    ps.setString(2, name);
                    ps.setInt(3, owner);
                    ps.executeUpdate();
   
           
        }
        catch(SQLException e)
        {
            System.err.println(e);
            
        }
        
  
        
        
    }  // end write to topics
     
           ////////////////////////////////////////////////////////////////     
     ////////////////////////////////////////////////////////////////////////////
          
             public void enterUser(int id, String name, String password, int theme) {
    
           String sql =
                
            "INSERT INTO SPACEUSER.MEMOUSER (id, name, password, theme) VALUES (?, ?, ?, ?)" ;

          master = new User(name, id, theme);
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql) ){   
            
           // counter = 1;
            
           
                    ps.setInt(1, id);
                    ps.setString(2, name);
                    ps.setString(3, password);
                    ps.setInt(4, theme);
                    ps.executeUpdate();
   
           
        }
        catch(SQLException e)
        {
            System.err.println(e);
            
        }
        
  master = new User(name, id, theme);
        
        
    }  // end enter user         
             
             
       private boolean somethingThere(){
         boolean yesOrNo = false;
         Random random = new Random();
                int chanceOfSolarSystem = 1 + random.nextInt( 100 );
                if(chanceOfSolarSystem>90){
                   yesOrNo = true; 
                }
         return yesOrNo;
     }  
       
  ////////////////////////////////////////////////////////////////////////        
  /////////////////////////////////////////////////////////////////////////////        
          
         // SELECT * FROM SPACEUSER.MEMO WHERE  MEMOTO = 4;
         public  void printSectors() {
        Connection connection = getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM SPACEUSER.FIELD"))
        {
            
System.out.println( "printing out now...");
            
            while(rs.next())
            {
                int xCord = rs.getInt("x");
                int yCord = rs.getInt("y");
                int id = rs.getInt("id");

               System.out.println("(" + xCord + "," + yCord + ")  id: " + id);
            }
            System.out.println();

            rs.close();
            statement.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }     // END PRINT SECTORS
    
         
         
            // ;
         public  void printSection(int category) {
        Connection connection = getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM SPACEUSER.MEMO WHERE  MEMOTO = " + category))
        {
            
System.out.println( "printing out now...");
            
            while(rs.next())
            {
                String hhead = rs.getString("memohead");
                String ttail = rs.getString("memotail");
                
              head = hhead;
              tail = ttail;

               System.out.println("from category: " +category + ",\n head:" + hhead + "\ntail: " + ttail );
            }
            System.out.println();

            rs.close();
            statement.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }     // end print section
         
         
               public  String printCategoryName(int category) {
                   String returned = "broken raelene 287";
        Connection connection = getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM SPACEUSER.TOPICS WHERE ID = " + category))
        {
            while(rs.next())
            {
                returned = rs.getString("name");
           
            }
          
            rs.close();
            statement.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        
        return returned;
        
        
    }     // end print category name   
   
              public  boolean checkThatPassword(String name, String claim) {
                  boolean temp = false;
                  int tempTheme = 0;
                   int tempId = 0;
                   String returned = "broken raelene 312";
                   String checkPassword = "broken raelene 313";
                    System.out.println("checking on name: " + name + ", password " + claim ); 
        Connection connection = getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM SPACEUSER.MEMOUSER WHERE NAME = '" + name + "'"))
            
        {
            while(rs.next())
            {
                tempTheme = rs.getInt("theme");
                checkPassword = rs.getString("password");
                tempId = rs.getInt("id");
               System.out.println("password = you gave us " + claim + ", we have " + checkPassword ); 
            }
          
            rs.close();
            statement.close();
        }
        catch(SQLException e)
        {
             System.out.println("password = you gave us " + claim + ", we have " + checkPassword ); 
             System.out.println(e);
        }
        
        if(checkPassword.equals(claim)){
         temp = true; 
          master = new User(name, tempId, tempTheme);
        }
        
        
        
        
        return temp;
        
        
    }     // end check that password            
             
               public  ArrayList<Category> getMyCategories(int ownerId) {
                   ArrayList<Category> myThings = new ArrayList();
        Connection connection = getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM SPACEUSER.TOPICS WHERE OWNER = " + ownerId))
        {
            while(rs.next())
            {
                int catid = rs.getInt("id");
                String catName = rs.getString("name");
                
                
           Category temp = new Category( catid, catName, ownerId);
           myThings.add(temp);
           
            }
          
            rs.close();
            statement.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        
        return myThings;
        
        
    }     // end get my categories           
               
               
               
               
               
         public String getHead(){
             return head;
         }
         
         public String getTail(){
             return tail;
         }
         
            public String getHead(int id){
             return head;
         }
         
         public String getTail(int id){
             return tail;
         }
          
         
         
         
         
        public void printSectorByVectors(int x, int y)
    {
        Connection connection = getConnection();
        try
        {
            PreparedStatement ps = connection.prepareStatement(
                "SELECT * FROM SPACEUSER.FIELD WHERE X = ? AND Y = ?");
            ps.setInt(1, x);
            ps.setInt(2, y);
            ResultSet rs = ps.executeQuery();
          
            if(rs.next())
            {
                 int xCord = rs.getInt("x");
                int yCord = rs.getInt("y");
                int id = rs.getInt("id");
                boolean star = rs.getBoolean("empty");

              System.out.println("id at (" + xCord + "," + yCord + ")  is: " + id + " and star is " + star);
             
                if(star){
               System.out.println("there is a solar system there");  
                }else{
             System.out.println("empty space");   
                }
                
            }

            rs.close();
            ps.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }  // end sector by vectors   
         
             public void printSectionByVectors(int x, int y)
    {
        Connection connection = getConnection();
        try
        {
            PreparedStatement ps = connection.prepareStatement(
                "SELECT * FROM SPACEUSER.FIELD WHERE X = ? AND Y = ?");
            ps.setInt(1, x);
            ps.setInt(2, y);
            ResultSet rs = ps.executeQuery();
          
            if(rs.next())
            {
                 int xCord = rs.getInt("x");
                int yCord = rs.getInt("y");
                int id = rs.getInt("id");
                boolean star = rs.getBoolean("empty");

              System.out.println("id at (" + xCord + "," + yCord + ")  is: " + id + " and star is " + star);
             
                if(star){
               System.out.println("there is a solar system there");  
                }else{
             System.out.println("empty space");   
                }
                
            }

            rs.close();
            ps.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }  // end sector by vectors    
         
           public void printGalaxyMap(int x, int y){
        
               int mapSize = 10; // 10 is for the 21 map size that we like, you just need an odd number
               int size = 1;
               
       for(int i = -mapSize; i < mapSize + 1; i++){
                for(int j = -mapSize; j < mapSize + 1; j++){
                    printSectorByVectors(i + x,j + y);
                    size++;
                } 
            }
       System.out.println("size of array: " + size);
    }  // end sector by vectors         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
      
  }  // end program
    
    
    
    
    


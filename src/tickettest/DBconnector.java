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

/**
 *
 * @author mark
 */
public class DBconnector {
    
    int size = 100;
    int mapArraySize = 20;//(testdbconnector.TestDBConnector.mapSize * testdbconnector.TestDBConnector.mapSize) + 1;
    public boolean[] stars = new boolean[mapArraySize];
    int counter = 1;
    
    
   public  DBconnector() {
       
      //getConnection(); 
      System.out.println("good to go.\n LET WRITE TO SOME DATABASES, BABY!"); 
    
      //writeSectors();
        /*
      System.out.println(" very ok."); 
      //printSectors();
      System.out.println(" very very ok.");
      printSectorByVectors(0,0);
      printSectorByVectors(82,52);
      printSectorByVectors(15,75);
      printSectorByVectors(10,20);
      printSectorByVectors(62,5);
      printSectorByVectors(1,9);
      printSectorByVectors(40,8);
      printSectorByVectors(88,22);
      printSectorByVectors(65,75);
      printSectorByVectors(11,20);
      printSectorByVectors(63,5);
      printSectorByVectors(11,9);
      System.out.println(" o my goodness yes.");
      */
     // printGalaxyMap(10,-2);
    //  printGalaxyMap(10,-4);
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
        
  
        
        
    }  // end write sectors
             
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
    
    
    
    
    


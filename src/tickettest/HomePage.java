/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickettest;



import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.sql.JDBCType.NULL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author mark
 */
public class HomePage extends JPanel implements ActionListener{
    
   
    
    JButton pic;
    JButton submitButton;
    JButton exitButton;
    JButton newButton;
    JLabel nametag;
     JLabel titleTag;
     
     
     JLabel directions;
    JTextField newName;
     
     
     JPanel categoryPanel;
     
    ArrayList<Category> categoreez;// = user.getContacts();
    ArrayList<JButton> contactButtons;
    
    DBconnector raelene;
    private User user;
    
    
    
    public HomePage(User forWhom){
        
        super();
        
        user = forWhom;
        
        setLayout(null);
        
        setBackground(randomColor(user.getTheme()));
        initComponents();
        
        System.out.println(getDurationBreakdown(System.currentTimeMillis()));
        
        
    }// end constructor
    
    //scroll.setBounds(scrollx,6,640,420);
    private void initComponents(){
      
        raelene = new DBconnector();
         categoreez  = raelene.getMyCategories(user.getId());
       // contactList = user.getContacts();
        contactButtons = new ArrayList();
        pic = new JButton("pic");
        pic.setBounds(12,40, 110,120);
        String picname = user.getPicture(); 
        ImageIcon monkeyPic = new ImageIcon(picname);
        pic.setIcon(monkeyPic);
        add(pic);
        
      //  categoryPanel = new JPanel();
       // categoryPanel.setBackground(Color.yellow);
      categoryPanel = categoryPanel();
        categoryPanel.setBounds(200,60,200,300);
        categoryPanel.setBackground(Color.yellow);
        //categoryPanel.setVisible(false);
        add(categoryPanel);
        
        
        
        
        nametag = new JLabel(user.getName());
        nametag.setBounds(40,168, 110,40);
        add(nametag);
        
        titleTag = new JLabel("home page for " + user.getName() + " who has " + categoreez.size() + " categories");
        titleTag.setBounds(80,4, 500,20);
        add(titleTag);
        
            
       ///////////////////////////////////////////////////////  
    ///////////////////////////////////////////////////////
    ///////// this is a group
    
     directions = new JLabel("enter name for category:");
        directions.setBounds(248,380,160,40);
        directions.setVisible(false);
        add(directions);
        newName = new JTextField();
        newName.setBounds(240,416,160,40);
        newName.setVisible(false);
        add(newName);
    
       ///////// this is a group
       ///////////////////////////////////////////////////////
 /////////////////////////////////////////////////////// 
   
        
        
        
     submitButton = new JButton("create new category");
    submitButton.setBounds(240,476,160,40);
    submitButton.setBackground(randomColor(user.getTheme()));//.setBackground(randomColor(theme));
    //pageButton.setVisible(false);
    submitButton.addActionListener(this);
    add(submitButton);
    exitButton = new JButton("log out");
    exitButton.setBounds(12,476,110,40);
    exitButton.setBackground(randomColor(user.getTheme()));//.setBackground(randomColor(theme));
    exitButton.addActionListener(this);
    //pageButton.setVisible(false);
   //pageButton.addActionListener(this);
    add(exitButton);
        
     newButton = new JButton("create");
    newButton.setBounds(240,476,160,40);
    newButton.setBackground(randomColor(user.getTheme()));//.setBackground(randomColor(theme));
    newButton.setVisible(false);
   newButton.addActionListener(this);
    add(newButton);    
        
        
        
        
        
        
        
        
        
        
    }  // end inint components
    
    
  
        @Override
         public void actionPerformed(ActionEvent event){

       	Object obj = event.getSource();
       
    
        
        
                if (obj == submitButton){
                  
                    directions.setVisible(true);
                    newName.setVisible(true);
                   newButton.setVisible(true);
                    submitButton.setVisible(false);
                    // submitButton.setText("whaa???");
                  
                  repaint();
                    newName.requestFocus();
                }
                
                
                
                 if (obj == newButton){
                  
                     int timeStamp = (int)System.currentTimeMillis();
                     
                   Category someting = new Category(timeStamp, newName.getText(), user.getId());
                   user.addCategory(someting);
                   raelene.writeToTopics(timeStamp, newName.getText(), user.getId());
                   tickettest.TicketTest.screen.createScreen(5,2);
                   
                   
                   
                   
                   
                }
                 
                 
                 
                 
                 
                if (obj == exitButton){
                  
                   tickettest.TicketTest.screen.createScreen(8,1);
                    
                }
         
                
                   for(int i = 0; i < contactButtons.size(); i++){
    
             
                 if (obj ==  contactButtons.get(i)){
                    
                     tickettest.TicketTest.screen.createScreen(4,i );
                    }
       
                }
                
                
                
                
                
                
                
                
         }  // end action listener
         
         
         private String properDate(){
             
             // http://www.xyzws.com/javafaq/how-to-use-simpledateformat-class-formating-parsing-date-and-time/142
             
              Date now = new Date();
        String datetimeStr = now.toString();
        System.out.println("1. " + datetimeStr);
        SimpleDateFormat format = new SimpleDateFormat(
                    "hh:mm:ss a EEE MMM dd yyyy");
        System.out.println("2. " + format.format(now));
            String result = format.format(now);
            return result;
             
             
         }
         
         
         
         
         
         
         
         
         
         
   private String millisToDate(long millis){

    return DateFormat.getDateInstance(DateFormat.FULL).format(millis);
    //You can use DateFormat.LONG instead of SHORT

} 
   
     public static String getDurationBreakdown(long millis)
    {
        if(millis < 0)
        {
            throw new IllegalArgumentException("Duration must be greater than zero!");
        }

        long days = TimeUnit.MILLISECONDS.toDays(millis);
        millis -= TimeUnit.DAYS.toMillis(days);
        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

        StringBuilder sb = new StringBuilder(64);
        sb.append(days);
        sb.append(" Days ");
        sb.append(hours);
        sb.append(" Hours ");
        sb.append(minutes);
        sb.append(" Minutes ");
        sb.append(seconds);
        sb.append(" Seconds");

        return(sb.toString());
    }  
   
   
   
     private JPanel categoryPanel(){
    
         
     JPanel mercPanel = new JPanel();
     int rows = categoreez.size();
     int columns = 1;
     int buttons = rows * columns;
       mercPanel.setLayout(new GridLayout(rows,columns));
       //  merchantButtons = monkeyTown.merchants();
   // colorMerchantsWithTransactions();
    for(int i = 0; i <  rows; i++){   
        JButton jimmy = new JButton();
     jimmy.setSize(160, 40);
       // if(user.getContacts().size()< i){
            // jimmy.setText("" + i);  
         jimmy.setText(categoreez.get(i).getName());  
      //  }

    
       jimmy.setBackground(randomColor(user.getTheme()));
       jimmy.setOpaque(true);
      jimmy.setBorderPainted(false);
       
       jimmy.addActionListener(this);
       contactButtons.add(jimmy); 
      mercPanel.add(jimmy);
      
    }
    return mercPanel;
     }
     
     
     public Color randomColor(int themeChoice){

                        int same;
    
                        int R = (int) (Math.random( )*256);
                        int G = (int)(Math.random( )*256);
                        int B= (int)(Math.random( )*256);
                                
                        Color randomColor = new Color(R, G, B);
    
    
    switch(themeChoice){
        // original monkey yellows, browns, and greens
                        case 1: R = (int) (Math.random( )*156)+100;
                                G = (int)(Math.random( )*56)+200;
                                B= (int)(Math.random( )*56);break; 
                        case 2: B = (int) (Math.random( )*156)+100;
                                R = (int)(Math.random( )*56)+200;
                                G= (int)(Math.random( )*56); break; 
                        case 3: R = (int) (Math.random( )*156)+100;
                                B = (int)(Math.random( )*56)+200;
                                G= (int)(Math.random( )*56); break; 
                        case 4: G = (int) (Math.random( )*156)+100;
                                B = (int)(Math.random( )*56)+200;
                                R= (int)(Math.random( )*56); break; 
                        case 5: G = (int) (Math.random( )*56)+200;
                                R = (int)(Math.random( )*56)+200;
                                B= (int)(Math.random( )*56)+200;break;
                        case 6: R = (int) (Math.random( )*56)+100;
                                G = (int)(Math.random( )*56)+100;
                                B= (int)(Math.random( )*56)+100; break;
                       // grayscale if you set them all to same value...
                        case 7: R = (int) (Math.random( )*88)+88;
                                G = (int)(Math.random( )*88)+88;
                                B= (int)(Math.random( )*88)+88; break;
                      // reduce the range for subtle greyscale...
                        case 8: R = (int) (Math.random( )*60)+160;
                                G = (int)(Math.random( )*60)+160;
                                B= (int)(Math.random( )*60)+160; break;
                          // this is nice...
                        case 9: R = (int) (Math.random( )*56)+100;
                                G = (int)(Math.random( )*56)+100;
                                B= (int)(Math.random( )*56)+100; break; 
                                   // really pull back...
                        case 10: same = (int) (Math.random( )*66) + 180;
                                R = same; 
                                G = same;
                                B= same; break;
                                case 11: G = (int) (Math.random( )*156)+100;
                                B = (int)(Math.random( )*56)+200;
                                R= (int)(Math.random( )*56); break;
                                case 12: R = (int) (Math.random( )*156)+100;
                                B = (int)(Math.random( )*56)+200;
                                G= (int)(Math.random( )*56); break;
                                case 13: R = (int) (Math.random( )*20)+160;
                                G = (int)(Math.random( )*20)+160;
                                B= (int)(Math.random( )*20)+160; break;
                                case 14: R = (int) (Math.random( )*120)+60;
                                G = (int)(Math.random( )*20)+160;
                                B= (int)(Math.random( )*90)+150; break;
                        default:R = (int) (Math.random( )*256);
                                G = (int)(Math.random( )*256);
                                B= (int)(Math.random( )*256); break;
                        
    }
                     randomColor = new Color(R, G, B);  

                return randomColor;

} // end random color
   
   
   
   
   
   
   
   
} // end class


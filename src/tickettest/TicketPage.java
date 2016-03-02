/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickettest;

import java.awt.Color;
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

/**
 *
 * @author mark
 */
public class TicketPage extends JPanel implements ActionListener{
    
    JTextArea readarea;
    JScrollPane readscroll;
    
    JTextArea writearea;
    
    JButton pic;
    JButton submitButton;
    JButton exitButton;
    JButton homeButton;
    JLabel nametag;
    JLabel titleTag;
    JLabel headTag;
    JLabel tailTag;
    
    ArrayList<Category> topics;
    
    DBconnector raelene;
    
    private int toWhom;
    private User user = tickettest.TicketTest.master;
    
    public TicketPage(int recipient){
        
        super();
        
        toWhom = recipient;
        topics = user.getContacts();
        setLayout(null);
        setBackground(randomColor(user.getTheme()));
        initComponents();
        
        System.out.println(getDurationBreakdown(System.currentTimeMillis()));
        
        
    }// end constructor
    
    //scroll.setBounds(scrollx,6,640,420);
    private void initComponents(){
      
        raelene = new DBconnector();
        raelene.printSection(topics.get(toWhom).getId());
        pic = new JButton("pic");
        pic.setBounds(12,40, 110,120);
        String picname = "images/tf1.jpg"; 
        ImageIcon monkeyPic = new ImageIcon(picname);
        pic.setIcon(monkeyPic);
       // add(pic);
        
        
        nametag = new JLabel("ticket page");
        nametag.setBounds(40,168, 110,40);
       // add(nametag);
        
        titleTag = new JLabel("Posting to Category: " + raelene.printCategoryName(topics.get(toWhom).getId()));
        // titleTag = new JLabel("Posting to Category: " + topics.get(toWhom).getName());
        titleTag.setBounds(80,4, 500,20);
        add(titleTag);
        
        headTag = new JLabel( raelene.getHead());
        headTag.setBounds(40,34, 500,20);
        add(headTag);
        
        tailTag = new JLabel(raelene.getTail());
        tailTag.setBounds(40,64, 500,20);
        add(tailTag);
            
       ///////////////////////////////////////////////////////  
    ///////////////////////////////////////////////////////
    ///////// this is a group
    
     
        readarea = new JTextArea();
        readarea.setBackground(randomColor(user.getTheme()));
    readscroll = new JScrollPane (readarea, 
   JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    readscroll.setBounds(20, 120, 422,100);
    add(readscroll);
    
       ///////// this is a group
       ///////////////////////////////////////////////////////
 /////////////////////////////////////////////////////// 
   
         writearea = new JTextArea();
        writearea.setBackground(randomColor(user.getTheme()));
        writearea.setBounds(20, 240, 422,200);
        writearea.setEditable(true);
        add(writearea);
        
        
        
     submitButton = new JButton("submit");
    submitButton.setBounds(240,476,120,40);
    submitButton.setBackground(randomColor(user.getTheme()));
    //pageButton.setVisible(false);
    submitButton.addActionListener(this);
    add(submitButton);
    exitButton = new JButton("new ticket");
    exitButton.setBounds(12,476,110,40);
    exitButton.setBackground(randomColor(user.getTheme()));
    exitButton.addActionListener(this);
    //pageButton.setVisible(false);
   //pageButton.addActionListener(this);
   // add(exitButton);
        
     homeButton = new JButton("home");
    homeButton.setBounds(100,476,110,40);
    homeButton.setBackground(randomColor(user.getTheme()));
    //pageButton.setVisible(false);
   homeButton.addActionListener(this);
    add(homeButton);    
        
        
        
        
        
        
        
        
        
        
    }  // end inint components
    
    
  
        @Override
         public void actionPerformed(ActionEvent event){

       	Object obj = event.getSource();
       
    
        
        
                if (obj == submitButton){
                    nametag.setText(millisToDate(System.currentTimeMillis()));
                   
                    //writearea.append("\n   " + properDate() + "\n");
                   // writearea.getText()
                    //tickettest.TicketTest.memoId
                    raelene.writeToMemo( (int)System.currentTimeMillis(), user.getId(), topics.get(toWhom).getId(),  readarea.getText(), writearea.getText() );
                    
                     
                    tickettest.TicketTest.screen.createScreen(3,1);
                    
                    
                    
                    
                    
                }
     
                 if (obj == homeButton){
                  
                   tickettest.TicketTest.screen.createScreen(3,1);
                    
                }
                
                
                if (obj == exitButton){
                  
                   tickettest.TicketTest.screen.createScreen(3,1);
                    
                }
         
         }
         
         
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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import my.database.dbFrame;

import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JDialog;

import pos.pmfuncs.MainFunc;
//
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;


//

/**
 *
 * 
 */
public class POS extends javax.swing.JFrame {

    private final static int button_width   =   145;        // button width
    private final static int button_height  =   130;        // button height
    private final static int horizontalGap  =   22;         // horizontal gap in button
    private final static int verticalGap    =   22;         // verticle gap in button
    private final static int numberOfColumns=   4;          // number of colums in the button panel
    private final static int fontSize       =   11;         // font size of button name
    private final static int fontType       =   Font.BOLD;  // font type
    private final static String fontName    =   "Times New Roman";    // font name
    private final static Color  fontColor   =   new Color(0, 0, 255);  // font colot
    private static boolean isEmployee=false;
    private Border border;
    private JButton search;
    private JTextField field;
    private JTextField textfield;
    private JTextField userfield;
    private JLabel userlabel;
    private JPasswordField passfield;
    private JLabel passlabel;
    private JButton login;
    private JButton cancel;
    private static JButton add;
    private static JButton print;
    private static JButton logout_Button;
    private JLabel pclabel;
    private static JLabel bglabel;
    private JLabel logolabel;
    private JButton sale;
    private JButton cart;
    private JButton tests;
    private JMenuBar menu;
    private static JPanel panel;
    private static JMenu orderMenu;
    private static JMenu fileMenu;
    private static JMenuBar menubar;
    private static String newPassword;
    private String id = null;
    JFrame addFrame = new dbFrame();
    JFrame saleFrame = new saleForm();
    JFrame PromoFrame = new PromoFrame();
    JFrame PrintFrame = new PrintFrame();
      private static JPanel lPanel;
    public String seaText;
    public boolean seaAction = false;
    static Object[] options=  new Object[]{"Add to Cart"};
    static Object selectedValue;   
    private static javax.swing.JButton back;
    private javax.swing.JButton exit;
    private static javax.swing.JScrollPane item;
    private static javax.swing.JPanel button;
    private static javax.swing.JPanel main;
    private static JButton saleButton = new JButton();
    private int defaultQuantity = 1;
    public int updateCart;
    
    public static JButton getLogout_Button()
    {
        return logout_Button;
    }
    public static JButton getSaleButton()
    {
        return saleButton;
    }
    public static JButton getAdd()
    {
        return add;
    }
    public static JPanel getPanel()
    {
        return panel;
    }
    public static JButton getPrint()
    {
        return print;
    }
    public static JMenu getFileMenu()
    {
        return fileMenu;
    }
    
    public static JMenu getOrderMenu()
    {
        return orderMenu;
    }
    public static JMenuBar getMenubar()
    {
        return menubar;
    }
    public static void setOptions(String object)
    {
        options = new Object[]{"Add to Cart", "Delete"};
    }
    public static void resetOptions(String object)
    {
        options = new Object[]{"Add to Cart"};
    }
      public static Object[] getOptions()
      {    
                       
          return options;
        }
    public static JLabel getBglabel()
    {
        return bglabel;
    }
                   
    public static javax.swing.JScrollPane getItem()
    {
        return item;
    }
    public static JPanel getButton()
    {
        return button;
    }
    public static JPanel getMain()
    {
        return main;
    }
    public static boolean isEmployee()
    {
        return isEmployee;
    }
    public static void toggleEmployee()
    {
       if(isEmployee)isEmployee=false;
       else isEmployee=true;
    }
    public POS(boolean isEmployee)
    {
      this.isEmployee=isEmployee;
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
        } catch (Exception ex) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
     
        
        initComponents(isEmployee);
    }
    private  void initComponents(boolean b) 
    {

        main = new javax.swing.JPanel();
        exit = new javax.swing.JButton();
        item = new javax.swing.JScrollPane();
        button = new javax.swing.JPanel();
        back = new javax.swing.JButton();
        login = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        logout_Button = new javax.swing.JButton();
        cart = new javax.swing.JButton();
        tests = new javax.swing.JButton();
        sale = new javax.swing.JButton();
        search = new javax.swing.JButton();
        add = new javax.swing.JButton();
        print = new javax.swing.JButton();
        pclabel = new javax.swing.JLabel();
        bglabel = new javax.swing.JLabel();
        textfield = new javax.swing.JTextField();
        userfield = new javax.swing.JTextField();
        userlabel = new javax.swing.JLabel();
        passfield = new javax.swing.JPasswordField();
        passlabel = new javax.swing.JLabel();
        menubar = new javax.swing.JMenuBar();
        logolabel = new javax.swing.JLabel();
        
        
        
        setLocation(MouseInfo.getPointerInfo().getLocation());
        setResizable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            });
        
        main.setBackground(new java.awt.Color(180, 216, 230));
        main.setForeground(new java.awt.Color(140, 205, 250));
        main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
           // ADD MENU
        JMenuBar menubar = new JMenuBar();
        menubar.setAlignmentX(Component.LEFT_ALIGNMENT);
        menubar.setMaximumSize(menubar.getPreferredSize());
        /*Employee access*/
        fileMenu = new JMenu("Stores");
        fileMenu.setMnemonic(KeyEvent.VK_O);
        menubar.add(fileMenu);
    class HelpDialog extends JDialog {
    public HelpDialog() {
    setTitle("Help");
    JLabel help = new JLabel("With 2MJE-Inventory Software, You can:");
      help.setFont(new Font("Italic", Font.BOLD, 12));
      help.setForeground(Color.RED);
      help.setHorizontalTextPosition(JLabel.CENTER);
      help.setVerticalTextPosition(JLabel.TOP);
      add(help);
       JLabel help1 = new JLabel("<html><pre><b>* Add new items, delete Items,Check Qantity of Items,Sale cart, and labels to inventory<b>"
               + "<br><font size=4><font color=#1E90FF>+ Help Content </font></font>"
               + "<br><font color=#3300FF>What is included in an inventory item?</font>"
               + "<br> Item Name , SKU (part number), Price(fixed or per unit), Quantity"
               + "<br><font color=#3300FF>What is an Inventory Item category?</font>"
               + "<br>Tires,Head Lights,Wind Shield,Engines,Side Mirrors,Rear Mirror,Brakes,Hood,Front Door,Back Door,<br>Fuel Tank,Transmission"
               + "<br><font color=#3300FF>What is promotion?</font>"
               + "<br> Every month, the store will have a sale special for customers "
               + "<br><font color=#3300FF>What is the login restriction?</font>"
               + "<br> Only the store owner or inventoru administrator is able to log to our inventory software for <br>editing or making changes. </font>"
               + "<br><font color=#3300FF>What is feedback?</font>"
               + "<br> We are designing customer feedback to help the store improve customer satisfation and <br>quality of products.</pre></html>"
       );
       help1.setFont(new Font("italic", Font.BOLD, 11));
       help1.setForeground(Color.BLACK);
       help1.setHorizontalTextPosition(JLabel.CENTER);
       help1.setVerticalTextPosition(JLabel.TOP);
       add(help1);
       help1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
    setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(650, 350);
        setLocationRelativeTo(null);
  }
}
    JMenuItem helpMenu = new JMenuItem("Help");
    helpMenu.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent event) {
    HelpDialog ad = new HelpDialog();
        ad.setVisible(true);
          }
        });
   
        fileMenu.add(helpMenu);
        fileMenu.addSeparator();
        class ContactDialog extends JDialog {
    public ContactDialog() {
    setTitle("Contact Us");
    setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

    add(Box.createRigidArea(new Dimension(0, 10)));

       JLabel Contact = new JLabel("Contact 2JME for Support and Service");
       Contact.setFont(new Font("Serif", Font.BOLD, 12));
       Contact.setForeground(Color.BLUE);
       Contact.setHorizontalTextPosition(JLabel.CENTER);
       Contact.setVerticalTextPosition(JLabel.TOP);
       add(Contact);
       JLabel contact1 = new JLabel("<html><pre><b>Please Contact Us At:<b><br>2mje@gmail.com</pre></html>");
       contact1.setFont(new Font("Serif", Font.BOLD, 11));
       contact1.setForeground(Color.BLACK);
       contact1.setHorizontalTextPosition(JLabel.CENTER);
       contact1.setVerticalTextPosition(JLabel.TOP);
       add(contact1);
       contact1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       setModalityType(ModalityType.APPLICATION_MODAL);
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       setSize(270, 150);
       setLocationRelativeTo(null);
    }
  }
        JMenuItem contactMenu = new JMenuItem("Contact Us");
        contactMenu.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
        ContactDialog ad = new ContactDialog();
        ad.setVisible(true);
          }
        });
    class AboutDialog extends JDialog {
    public AboutDialog() {
    setTitle("About Us");
    setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

    add(Box.createRigidArea(new Dimension(0, 10)));

    JLabel about = new JLabel(" 2MJE Inventory Software was created by Emanuel, James, Mohammad A and Mohammad N ");
    about.setFont(new Font("Serif", Font.BOLD, 12));
    about.setForeground(Color.BLUE);
    about.setHorizontalTextPosition(JLabel.CENTER);
    about.setVerticalTextPosition(JLabel.TOP);
    add(about);
    JLabel about1 = new JLabel("<html><pre><b>Our Goal:<b><br>2JME Inventory is an inventory application that is extremely easy to use.<br>This software has been designed for small companies in mind,who just want<br>to get the job done without any complicated learning process. Our interface<br>is built for busy people that don't want to spend a lot of time learning how<br>to use a new piece of software.</pre></html>");
    about1.setFont(new Font("Serif", Font.BOLD, 11));
    about1.setForeground(Color.BLACK);
    about1.setHorizontalTextPosition(JLabel.CENTER);
    about1.setVerticalTextPosition(JLabel.TOP);
    add(about1);
    JLabel logo = new JLabel();
   
    try {
            Image img = ImageIO.read(getClass().getResource("pos/images/logo2.png"));
            logo.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
        }
    add(logo,JLabel.CENTER);
    add(Box.createRigidArea(new Dimension(0, 100)));
    about1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setModalityType(ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(560, 300);
        setLocationRelativeTo(null);
    }
    }
    
        fileMenu.add(contactMenu);
        JMenuItem about = new JMenuItem("About");
        about.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
        AboutDialog ad = new AboutDialog();
        ad.setVisible(true);
          }
        });
        menubar.add(about);
        menubar.setFont(new Font("COURIER", Font.BOLD,10));
            main.add(menubar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0, 1400, 30));
        
        // set search button
                   
        search.setText("");
        try 
        {
            Image img = ImageIO.read(getClass().getResource("pos/images/search.png"));
            search.setIcon(new ImageIcon(img));
        } 
        catch (Exception ex) {}
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               searchActionPerformed(evt);
            }

            private void searchActionPerformed(ActionEvent evt) {
                String[] Sep = new String[2];
                //System.out.println(textfield.getText());
                seaText = textfield.getText().toLowerCase().trim();
                
                
                if (seaText.startsWith("Tires")){
                    addSubmenue("Tires");
                    seaAction = false;
                }
                else if (seaText.startsWith("Head Lights")){
                    addSubmenue("Head Lights");
                    seaAction = false;
                }
                else{
                                    
                    PrintWriter output = null;
    try
         {
            //the file path of output.txt
            output = new PrintWriter(new FileWriter(MainFunc.SpeciPath("")+"SeaInput.txt"));
            output.println(seaText);
            
         }catch(IOException e)
         {
             System.out.println(e);
             System.exit(0);
         }
         finally 
         {
            output.close(); //close print
         }
                addSubmenue("SEA");
                seaAction = true;
             
                }
                
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        main.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 44,107,40));
        
        // set textfield
        textfield.setText("Search by Name, SKU #, Type or Manufacturer");
        textfield.setForeground(Color.LIGHT_GRAY);
        
        textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldActionPerformed(evt);
            }

            private void textfieldActionPerformed(ActionEvent evt) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        main.add(textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 43, 580, 45));
        
        final String defaultText = "Search by Name, SKU #, Type or Manufacturer";
        textfield.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(textfield.getText().equals(defaultText)){
                textfield.setText("");
                textfield.setForeground(Color.black);
                }
                
            }
            
            public void mouseExited(MouseEvent e) {
                if(textfield.getText().equals("")){
                textfield.setForeground(Color.LIGHT_GRAY);
                textfield.setText(defaultText);
                }
                else if(!textfield.getText().equals(defaultText)){
                textfield.setForeground(Color.black);
                
                }
            }
            
            
        });
        
        
        
        
        
        item.setBackground(new java.awt.Color(220, 20, 60));
        item.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        item.setAutoscrolls(true);
        
         //set title 2MJE
        pclabel.setText("2MJE Car Parts");
        pclabel.setForeground(Color.WHITE);
        pclabel.setFont(new Font("Times New Roman", Font.BOLD,35));
        try 
        {
            Image img = ImageIO.read(getClass().getResource("pos/images/logoicon.png"));
            pclabel.setIcon(new ImageIcon(img));
        } 
        catch (Exception ex) {}

      main.add(pclabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10,35, 340, 110));
       
        
        // sale button
        
    
        saleButton.setText("Sale");
        try 
        {
            Image img = ImageIO.read(getClass().getResource("pos/images/car.gif"));
            saleButton.setIcon(new ImageIcon(img));
        } 
        catch (Exception ex) {}

        
        saleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //saleActionPerformed(evt);
                PromoFrame.pack();
                PromoFrame.setLocationRelativeTo(null);
                PromoFrame.setVisible(true);
            }

            private void saleActionPerformed(ActionEvent evt) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
      //  main.add(saleButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 420, 150, 98));
        
        button.setBackground(new java.awt.Color(250,240,230));
        button.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inventory Items", javax.swing.border.TitledBorder.ABOVE_TOP, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Courier", Font.BOLD, 15), new java.awt.Color(0,0,255))); 
        button.setForeground(new java.awt.Color(50,240,230));
        button.setAutoscrolls(true);
        button.setEnabled(false);
        button.setOpaque(false);
        button.setLayout(new GridLayout(3, 4));
        item.setViewportView(button);

        main.add(item, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 155, 685, 480));
        // set exit button 
        exit.setText("Exit");
        exit.setFont(new Font("Times New Roman", Font.BOLD,18));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        main.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 700, 120, 50));
        //add the add button
        add.setText("Add");
        add.setFont(new Font("Times New Roman", Font.BOLD,18));
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //display it in the center
                addFrame.pack();
                addFrame.setLocationRelativeTo(null);
                addFrame.setVisible(true);
            }
        });
        
 //       main.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 120, 50));
        // print button
        print.setText("Print");
        print.setFont(new Font("Times New Roman", Font.BOLD,18));
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //btn_backActionPerformed(evt);
                //System.out.println("hahaha");
                PrintFrame.pack();
                PrintFrame.setLocationRelativeTo(null);
                PrintFrame.setVisible(true);
            
            

            }
        });
       
        // add the back button
        back.setText("Back");
        back.setFont(new Font("Times New Roman", Font.BOLD,18));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
                seaAction = false;
            }
        });
        main.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 700, 120, 50));
        
        // login label
        userlabel.setText("Username");
        userlabel.setForeground(Color.RED);
        userlabel.setFont(new Font("Courier New", Font.BOLD,20));
        // login textfield
        userfield.setText("");
        userfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tex_userfieldActionPerformed(evt);
            }

            private void tex_userfieldActionPerformed(ActionEvent evt) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        // login passlabel
        passlabel.setText("Password");
        passlabel.setForeground(Color.RED);
        passlabel.setFont(new Font("Courier New", Font.BOLD,20));
        
        // login passfield
        passfield.setText("");
        passfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tex_passfieldActionPerformed(evt);
            }

            private void tex_passfieldActionPerformed(ActionEvent evt) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        logout_Button.setText("Log in");
        logout_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                        
                        if(logout_Button.getText().equals("Log in"))
                        {   
                            logout_Button.setText("Forgot Password?");
                            main.remove(logout_Button);
//                            main.add(logout_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 50, 100, 30));
//                          
                            main.add(logout_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 80, 175, 30));

                            main.setBorder(border);
                             //just add
                            main.remove(add);
                            main.remove(print);
                            main.remove(bglabel);
                            main.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 160, 300, 200));
                            main.add(bglabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0, 1400,768));

                            main.revalidate();
                            main.repaint();
                        }
                        else if(logout_Button.getText().equals("Forgot Password?")){
                          //  AppLogin
                            main.remove(logout_Button);
                            
                            panel.remove(passfield);
                            panel.remove(passlabel);
                            userlabel.setText("Enter employee id: ");
                            login.setText("Ok");//change login behavior
                            panel.setBorder(BorderFactory.createTitledBorder("Recover Password"));
                            panel.revalidate();
                            panel.repaint();
                            main.revalidate();
                            main.repaint();
                            
                        }
                        else
                        {   
                            AppLogin.logout(); 
                           
                        }
                            
                        

            }

            private void tex_passfieldActionPerformed(ActionEvent evt) {
                 //To change body of generated methods, choose Tools | Templates.
            }
        });
        main.add(logout_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 50, 100, 30));
        //Cart button
          cart.setText("Cart");
          cart.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saleFrame.pack();
                saleFrame.setLocationRelativeTo(null);
                saleFrame.setVisible(true);
//                tex_passfieldActionPerformed(evt);
                
               
                
            }

//            private void tex_passfieldActionPerformed(ActionEvent evt) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
        });
        main.add(cart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 50, 100, 30));
        
        //cancel button
        cancel.setText("Cancel");
        cancel.setForeground(Color.RED);
        cancel.setFont(new Font("Courier New", Font.BOLD,15));
        
        
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }      
            private void cancelActionPerformed(ActionEvent evt) {
                String ul = userlabel.getText();
                if(ul.equals("Enter employee id: ") || ul.equals("Enter new password")
                        || ul.equals("Re-enter new password"))
                {
               
                   userfield.setText("");
                   userlabel.setText("Username");
                   panel.remove(lPanel);
                   panel.add(passlabel);
                   panel.add(passfield);
//                    lPanel.remove(login);
//                    lPanel.remove(cancel);
//                    lPanel.setLayout(new BoxLayout(lPanel, BoxLayout.X_AXIS));
//                    lPanel.add(login,BorderLayout.CENTER);
//                    lPanel.add(cancel, BorderLayout.EAST);
                    panel.add(lPanel);
                    login.setHorizontalAlignment(SwingConstants.RIGHT);
                    login.setText("Login");             
                    panel.setBorder(BorderFactory.createTitledBorder("Administrator Login"));
        
                }
                
                main.remove(panel);
                logout_Button.setText("Log in");
                main.remove(logout_Button);
//                            main.add(logout_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 50, 100, 30));
//              
                main.remove(bglabel);
                main.add(logout_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 50, 100, 30));
                main.add(bglabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0, 1400,768));
                main.revalidate();
                main.repaint();
            }
                    
            });
           


        // login button
        login.setText("Login");
        login.setForeground(Color.RED);
        login.setFont(new Font("Courier New", Font.BOLD,15));
        
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
                    
            }

            private void loginActionPerformed(ActionEvent evt) {
                
               if(login.getText().equals("Login")){
                
               char[] input=passfield.getPassword();
               
               
                AppLogin.main(new String[]{userfield.getText(), new String(input)});
                
                Arrays.fill(input, '0');
               passfield.setText("");
               passfield.revalidate();
               userfield.setText("");
               userfield.revalidate();
                if(isEmployee)
                {
                    main.remove(bglabel);
                   
                    options=new Object[]{"Add to Cart","Delete"};
                    button.revalidate();
                    button.repaint();
                    item.setViewportView(button);
                    main.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 120, 50));
                    main.add(item, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 155, 685, 480));
                    
                    
                    menubar.validate();
                    main.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 120, 50));
                   
                    main.remove(panel);
                    main.add(bglabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0, 1400,768));
                    // main.add(pclabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10,35, 340, 110));
                    main.revalidate();
                    main.repaint();
                }
               }
                else if(userlabel.getText().equals("Enter employee id: "))
                {
                     id = userfield.getText();
                    boolean verifyId = AppLoginModule.verifyId(id);//TODO getClientId
                    
                    if(verifyId)
                    {
                        userlabel.setText("Enter new password");
                        //userlabel.revalidate();
                        userfield.setText("");
                    }
                }
                else if(userlabel.getText().equals("Enter new password") )
                {
                    newPassword= userfield.getText();
                    userfield.setText("");
                    userlabel.setText("Re-enter new password");
                }
                else if(userlabel.getText().equals("Re-enter new password"))
                {
                    String pass = userfield.getText();
                    userfield.setText("");
                    if(newPassword.equals(pass))
                    {
                        AppLoginModule.setNewPassword(AppLoginModule.getClientName(id), pass);
                        
                        
                        userlabel.setText("Username");
                        logout_Button.setText("Log in");
                        main.remove(bglabel);
                        main.add(logout_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 50, 100, 30));
                        main.add(bglabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0, 1400,768));
                        main.remove(panel);
                        panel.remove(lPanel);
                        main.revalidate();
                        main.repaint();
                
                        login.setText("Login");
                        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                        panel.add(passlabel);
                        panel.add(passfield);
                        panel.setBorder(BorderFactory.createTitledBorder("Administrator Login"));
                        panel.add(lPanel);
        
       // panel.add(login,BorderLayout.CENTER);
      
      //  lPanel.setLayout(new BoxLayout(lPanel, BoxLayout.X_AXIS));
      //  lPanel.add(login,BorderLayout.CENTER);
      //  lPanel.add(cancel, BorderLayout.EAST);
      //  panel.add(lPanel);
      //  login.setHorizontalAlignment(SwingConstants.RIGHT);
                       // logout_Button.setText(seaText);
                        
                         System.out.println("made it here");
                         id = null;
                    
            }
                    
                }
               
                
                
               }
        });
         panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(userlabel);
        panel.add(userfield);
        panel.add(passlabel);
        panel.add(passfield);
        panel.setBorder(BorderFactory.createTitledBorder("Administrator Login"));
        
       // panel.add(login,BorderLayout.CENTER);
        lPanel = new JPanel();
        lPanel.setLayout(new BoxLayout(lPanel, BoxLayout.X_AXIS));
        lPanel.add(login,BorderLayout.CENTER);
        lPanel.add(cancel, BorderLayout.EAST);
        panel.add(lPanel);
        login.setHorizontalAlignment(SwingConstants.RIGHT);
       // main.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 160, 300, 200));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1366)/2, (screenSize.height-760)/2, 1366, 768);
    
      

    
            bglabel.setOpaque(false);
        
        bglabel.setFont(new Font("Times New Roman", Font.BOLD,35));
        
        try 
        {
            Image img = ImageIO.read(getClass().getResource("pos/images/carback.jpg"));
            bglabel.setIcon(new ImageIcon(img));
            
        } 
        catch (Exception ex) {}
        
        main.add(bglabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0, 1400,768));
}
    
    
    
    

    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        addMainMenue();
    }

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {
       addMainMenue();
    }

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                    if(args.length==0){
                      
                new POS(false).setVisible(true);
                    }else
                    
                       if(!(isEmployee()) && args[0].equals("true"))
                        toggleEmployee();
                    if(!AppLoginModule.psswdFileExists())
                        AppLoginModule.setPsswdFile();
                    
                    
                
                
                
            }
        });
    }


                
                
 
    private void addMainMenue() {

        button.removeAll();
        repaint();

        Image img, sub;
        ImageIcon icon;
        String imagePath,imag = "/pos/images/carback.jpg";

        ArrayList menue = new ArrayList();
        ArrayList itemName = new ArrayList();

        for (int size = 0 ; size<ItemCar.mainMenuCodes.length; size++) {
            menue.add(ItemCar.mainMenuCodes[size]);
            itemName.add(ItemCar.mainMenuDesc[size]);
        }
        
        JButton[] buttons = new JButton[menue.size()];

        for (int i = 0; i < buttons.length; i++) {
              
            imagePath   = imag+menue.get(i).toString()+".jpeg";

            URL url     = getClass().getResource(imagePath);


            if(url!=null){
                img         = Toolkit.getDefaultToolkit().getImage(url);
                sub         = img.getScaledInstance(button_width - 8, button_height - 30, Image.SCALE_FAST);
                icon        = new ImageIcon(sub);
            }
            else
               icon        = new ImageIcon();

            buttons[i]  = new JButton(itemName.get(i).toString(), icon);
            buttons[i].setVerticalTextPosition(AbstractButton.BOTTOM);
            buttons[i].setHorizontalTextPosition(AbstractButton.CENTER);

            buttons[i].setBorder(javax.swing.BorderFactory.createEtchedBorder());
            buttons[i].setFont(new java.awt.Font("Times New Roman", 1, 13));
            buttons[i].setForeground(new java.awt.Color(0,0, 205));

            buttons[i].setActionCommand(menue.get(i).toString());
            buttons[i].addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    String choice = e.getActionCommand();
                    addSubmenue(choice);
                }
            });
        }

        int b       =   0;
        int vGap    =   verticalGap;
        int hGap    =   horizontalGap;
        int bLength =   buttons.length;
        int bRows   =   bLength/numberOfColumns +1;

        L1:    for (int j = 0; j <bRows; j++) {
                vGap = 10;
                for (int k = 0; k < numberOfColumns; k++) {

                    button.add(buttons[b], new org.netbeans.lib.awtextra.AbsoluteConstraints(vGap, hGap, button_width, button_height));
                    repaint();
                    vGap +=button_width+verticalGap;
                    b++;
                    if(b>=bLength){
                        break L1;
                    }
                }
                hGap +=button_height+horizontalGap;
        }
        pack();
    }

    private void addSubmenue(String choice) {
        button.removeAll();
        repaint();

        Image img, sub;
        ImageIcon icon;
        String imagePath,imag = "/pos/images/";

        ArrayList menue = new ArrayList();
        ArrayList itemName = new ArrayList();

        ArrayList   list  =   ItemCar.getSubMenu(choice);
        String subCode[]  =   (String[]) list.get(0);
        String subDesc[]  =   (String[]) list.get(1);

        for (int size = 0 ; size<subCode.length; size++) {
            menue.add(subCode[size]);
            itemName.add(subDesc[size]);
        }

        JButton[] buttons = new JButton[menue.size()];

        for (int i = 0; i < buttons.length; i++) {

            //imagePath   = imag+menue.get(i).toString().substring(0,3)+".jpeg";
            String[] orderNonum = menue.get(i).toString().split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
            imagePath   = imag+orderNonum[0]+".jpeg";
            
            //System.out.println(imagePath);

            URL url     = getClass().getResource(imagePath);
//                System.out.println(imagePath +"   Get Reso : " +getClass().getResource(imagePath));

            if(url!=null){
                img         = Toolkit.getDefaultToolkit().getImage(url);
                sub         = img.getScaledInstance(button_width - 8, button_height - 30, Image.SCALE_FAST);
                icon        = new ImageIcon(sub);
            }
            else
               icon        = new ImageIcon();



            buttons[i]  = new JButton(itemName.get(i).toString(), icon);
            buttons[i].setVerticalTextPosition(AbstractButton.BOTTOM);
            buttons[i].setHorizontalTextPosition(AbstractButton.CENTER);

            buttons[i].setBorder(javax.swing.BorderFactory.createEtchedBorder());
            buttons[i].setFont(new java.awt.Font("Tahoma", 1, 13));
            buttons[i].setForeground(new java.awt.Color(0, 0, 205));


            buttons[i].setActionCommand(menue.get(i).toString());
            buttons[i].addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    String choice = e.getActionCommand();
                    addItems(choice);
                }
            });
        }
        int b       =   0;
        int vGap    =   verticalGap;
        int hGap    =   horizontalGap;
        int bLength =   buttons.length;
        int bRows   =   bLength/numberOfColumns +1;

        L1:    for (int j = 0; j <bRows; j++) {
                vGap = 10;
                for (int k = 0; k < numberOfColumns; k++) {

                    button.add(buttons[b], new org.netbeans.lib.awtextra.AbsoluteConstraints(vGap, hGap, button_width, button_height));
                    repaint();
                    vGap +=button_width+verticalGap;
                    b++;
                    if(b>=bLength){
                        break L1;
                    }
                }
                hGap +=button_height+horizontalGap;
        }
        pack();
    }

    @SuppressWarnings("empty-statement")
    private void addItems(String choice) {
        //System.out.println("haha"+choice);

        String [] idetail = new String [8];
        String folder;
        

        if(choice.startsWith("Ti")){//Tires
            idetail = MainFunc.ListDetail(MainFunc.SpeciPath("Tires"), 2, choice);//String,int,String
            folder = "TIRES";
            choice  =   "\n\nMODEL: "+idetail[0]+"\nSERIES: "+idetail[1]+"\nLOCATION: "+idetail[4]+"\nPRICE: $"
                        +idetail[2]+"\nQuantity: "+idetail[3]+"\nPART#: "+idetail[5]+"\nDiscount: "+idetail[6]+"%\nRating: "+idetail[7];}
        
        else if(choice.startsWith("Tr")){//Transmission
            idetail = MainFunc.ListDetail(MainFunc.SpeciPath("Transmission"), 2, choice);//String,int,String
            folder = "TRANSMISSION";
            choice  =   "\n\nMODEL: "+idetail[0]+"\nSERIES: "+idetail[1]+"\nLOCATION: "+idetail[4]+"\nPRICE: $"
                        +idetail[2]+"\nQuantity: "+idetail[3]+"\nPART#: "+idetail[5]+"\nDiscount: "+idetail[6]+"%\nRating: "+idetail[7];}
        
        else if(choice.startsWith("SM")){//Side Mirrors
            idetail = MainFunc.ListDetail(MainFunc.SpeciPath("Side Mirrors"), 2, choice);//String,int,String
            folder = "SIDE MIRRORS";
            choice  =   "\n\nMODEL: "+idetail[0]+"\nSERIES: "+idetail[1]+"\nLOCATION: "+idetail[4]+"\nPRICE: $"
                        +idetail[2]+"\nQuantity: "+idetail[3]+"\nPART#: "+idetail[5]+"\nDiscount: "+idetail[6]+"%\nRating: "+idetail[7];}
        
        else if(choice.startsWith("RM")){//Rear Mirror
            idetail = MainFunc.ListDetail(MainFunc.SpeciPath("Rear Mirror"), 2, choice);//String,int,String
            folder = "Rear Mirror";
            choice  =   "\n\nMODEL: "+idetail[0]+"\nSERIES: "+idetail[1]+"\nLOCATION: "+idetail[4]+"\nPRICE: $"
                        +idetail[2]+"\nQuantity: "+idetail[3]+"\nPART#: "+idetail[5]+"\nDiscount: "+idetail[6]+"%\nRating: "+idetail[7];}
        else if(choice.startsWith("En")){//Side Mirrors
            idetail = MainFunc.ListDetail(MainFunc.SpeciPath("Engines"), 2, choice);//String,int,String
            folder = "ENGINES";
            choice  =   "\n\nMODEL: "+idetail[0]+"\nSERIES: "+idetail[1]+"\nLOCATION: "+idetail[4]+"\nPRICE: $"
                        +idetail[2]+"\nQuantity: "+idetail[3]+"\nPART#: "+idetail[5]+"\nDiscount: "+idetail[6]+"%\nRating: "+idetail[7];}
        else if(choice.startsWith("WS")){//Side Mirrors
            idetail = MainFunc.ListDetail(MainFunc.SpeciPath("Wind Shield"), 2, choice);//String,int,String
            folder = "WIND SHIELD";
            choice  =   "\n\nMODEL: "+idetail[0]+"\nSERIES: "+idetail[1]+"\nLOCATION: "+idetail[4]+"\nPRICE: $"
                        +idetail[2]+"\nQuantity: "+idetail[3]+"\nPART#: "+idetail[5]+"\nDiscount: "+idetail[6]+"%\nRating: "+idetail[7];}
        else if(choice.startsWith("HL")){//Side Mirrors
            idetail = MainFunc.ListDetail(MainFunc.SpeciPath("Head Lights"), 2, choice);//String,int,String
            folder = "HEAD LIGHTS";
            choice  =   "\n\nMODEL: "+idetail[0]+"\nSERIES: "+idetail[1]+"\nLOCATION: "+idetail[4]+"\nPRICE: $"
                        +idetail[2]+"\nQuantity: "+idetail[3]+"\nPART#: "+idetail[5]+"\nDiscount: "+idetail[6]+"%\nRating: "+idetail[7];}
        else if(choice.startsWith("Br")){//Side Mirrors
            idetail = MainFunc.ListDetail(MainFunc.SpeciPath("Brakes"), 2, choice);//String,int,String
            folder = "BRAKES";
            choice  =   "\n\nMODEL: "+idetail[0]+"\nSERIES: "+idetail[1]+"\nLOCATION: "+idetail[4]+"\nPRICE: $"
                        +idetail[2]+"\nQuantity: "+idetail[3]+"\nPART#: "+idetail[5]+"\nDiscount: "+idetail[6]+"%\nRating: "+idetail[7];}
        else if(choice.startsWith("Ho")){//Side Mirrors
            idetail = MainFunc.ListDetail(MainFunc.SpeciPath("Hood"), 2, choice);//String,int,String
            folder = "HOOD";
            choice  =   "\n\nMODEL: "+idetail[0]+"\nSERIES: "+idetail[1]+"\nLOCATION: "+idetail[4]+"\nPRICE: $"
                        +idetail[2]+"\nQuantity: "+idetail[3]+"\nPART#: "+idetail[5]+"\nDiscount: "+idetail[6]+"%\nRating: "+idetail[7];}
        else if(choice.startsWith("FT")){//Side Mirrors
            idetail = MainFunc.ListDetail(MainFunc.SpeciPath("Fuel Tank"), 2, choice);//String,int,String
            folder = "FUEL TANK";
            choice  =   "\n\nMODEL: "+idetail[0]+"\nSERIES: "+idetail[1]+"\nLOCATION: "+idetail[4]+"\nPRICE: $"
                        +idetail[2]+"\nQuantity: "+idetail[3]+"\nPART#: "+idetail[5]+"\nDiscount: "+idetail[6]+"%\nRating: "+idetail[7];}
        else if(choice.startsWith("FD")){//Side Mirrors
            idetail = MainFunc.ListDetail(MainFunc.SpeciPath("Front Door"), 2, choice);//String,int,String
            folder = "FRONT DOOR";
            choice  =   "\n\nMODEL: "+idetail[0]+"\nSERIES: "+idetail[1]+"\nLOCATION: "+idetail[4]+"\nPRICE: $"
                        +idetail[2]+"\nQuantity: "+idetail[3]+"\nPART#: "+idetail[5]+"\nDiscount: "+idetail[6]+"%\nRating: "+idetail[7];}
        else if(choice.startsWith("BD")){//Side Mirrors
            idetail = MainFunc.ListDetail(MainFunc.SpeciPath("Back Door"), 2, choice);//String,int,String
            folder = "BACK DOOR";
            choice  =   "\n\nMODEL: "+idetail[0]+"\nSERIES: "+idetail[1]+"\nLOCATION: "+idetail[4]+"\nPRICE: $"
                        +idetail[2]+"\nQuantity: "+idetail[3]+"\nPART#: "+idetail[5]+"\nDiscount: "+idetail[6]+"%\nRating: "+idetail[7];}
        
        else{
            folder = "not_valid";
        }
        //display item's details and let the user select an action
        
        String currentFile;
        
        Path path;
     
        boolean fileDeleted=false;
        
        
        
        Object selectedValue = JOptionPane.showInputDialog(null,
            "You chose: " + choice + "\n\nPlease select", "Item's Details",
        JOptionPane.INFORMATION_MESSAGE, null,
        options, options[0]);
        
        if(selectedValue != null){
            if (selectedValue.toString().equals("Delete")){
                int n = JOptionPane.showConfirmDialog(
                    this,"The item will be permanently deleted!\n "
                            + "Do you want to continue?",
                    "Remove Item",
                    JOptionPane.YES_NO_OPTION);

                //get the actual name of the file
                currentFile = idetail[0]+"_"+idetail[5]+".txt";


                //0: YES, 1:NO
                if (n==0){
                    if(!folder.equals("not_valid")){
                        path =  FileSystems.getDefault().
                                getPath(MainFunc.SpeciPath(folder));
                        path = path.resolve(currentFile);
                        try{
                            //if file exists - delete it
                            Files.deleteIfExists(path);

                            //set fileDeleted to true
                            fileDeleted = true;

                            //check for exceptions
                        }catch(NoSuchFileException x){
                            JOptionPane.showMessageDialog(this, "Cannot proceed: "
                                    + "file does not exist!");
                        }catch(IOException x){   
                            JOptionPane.showMessageDialog(this, "Cannot proceed: "
                                    + "file is not accessible. "
                                    + "Please check the permission settings.");
                        }

                        //file was deleted, display the message
                        if (fileDeleted == true){
                            String folder2;
                            JOptionPane.showMessageDialog(this, "The file"
                                    + " was sucessfully deleted from the "
                                    + "database");
                            String [] orderX = {"Tires","Head Lights","Wind Shield","Engines","Side Mirrors","Rear Mirror","Brakes","Hood","Front Door","Back Door","Fuel Tank","Transmission"};
                            String [] orderY = {"Tires","Head Lights","Wind Shield","Engines","Side Mirrors","Rear Mirror","Brakes","Hood","Front Door","Back Door","Fuel Tank","Transmission"};
                            
                            
                            if(seaAction == true){
                                
                                addSubmenue("SEA");
                                //seaAction = false;
                            
                            }
                            else{
                            
                            for(int i=0; i<orderY.length; i++){
                            if(folder.equals(orderY[i])){
                                folder2 = orderX[i];
                            }
                            else{
                                folder2 = "not valid";
                            }
                            if(!folder2.equals("not valid")){
                                //System.out.println(folder2);
                            addSubmenue(folder2);
                            }
                            }
                            
                            }

                        }
                    }
                }
            }else if(selectedValue.toString().equals("Add to Cart")){
                 //if user chose "Add to Cart", then the info of the 
                //item should be passed into the saleForm by calling
                //setInfo method.
               
                    if(idetail[3].equals("0")){
                        JOptionPane.showMessageDialog(this, "This Item"
                                + " is currently out of stock!");
                    }else{
                        updateCart = 1;
                        setInfo(idetail[0],idetail[2],idetail[3],idetail[6]);
                         
                    }
            }
        }
        

    }
            //preconditions: receives data when the user selects
            //"Add to Cart".
            //postconditions: the item is being added to the jTable List
            //on the Cart form
          public void setInfo(String name, String price, String quantity, String discount){
                boolean addNewItem = true;
                boolean addNewItemActivate = false;
                saleFrame.pack();
                saleFrame.setLocationRelativeTo(null);
                saleFrame.setVisible(true);
                saleForm passToCart = new saleForm(name, price, quantity,discount, 
                        defaultQuantity, updateCart, addNewItem, addNewItemActivate);
                passToCart.setList();
        
          }
                   
}


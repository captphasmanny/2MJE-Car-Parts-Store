
package my.database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 */

public class dbFrame extends javax.swing.JFrame {
    JFrame frame;
    
    private String itemID;
    private String itemName;
    private String itemSeries;
    private String itemQuantity;
    private String itemPartNumber;
    private String itemPrice;
    private String itemLocation;
    private String roots = new File("").getAbsolutePath()+File.separator+"CarDatabase"+File.separator;


    /**
     * Creates new form dbFrame
     */
    public dbFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jAddPanel = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblSeries = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        btnButton = new javax.swing.JButton();
        lblLocation = new javax.swing.JLabel();
        lblPartNumber = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtSeries = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtLocation = new javax.swing.JTextField();
        txtPartNumber = new javax.swing.JTextField();
        lblQuantity = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        comboCategory = new javax.swing.JComboBox();
        lblPartType = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("panelAdd"); // NOI18N
        setPreferredSize(new java.awt.Dimension(388, 400));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jAddPanel.setBackground(new java.awt.Color(204, 204, 204));
        jAddPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("ADD ITEM TO DATABASE"));

        lblName.setText("Name:");

        lblSeries.setText("Series:");

        lblPrice.setText("Price ($):");

        btnButton.setText("ADD");
        btnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnButtonActionPerformed(evt);
            }
        });

        lblLocation.setText("Location:");

        lblPartNumber.setText("Part #:");

        lblQuantity.setText("Quantity:");

        comboCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tires", "Head Lights", "Wind Shield", "Engines", "Side Mirrors", "Rear Mirror", "Brakes", "Hood", "Front Door", "Back Door", "Fuel Tank", "Transmission" }));
        comboCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategoryActionPerformed(evt);
            }
        });

        lblPartType.setText("Select type:");

        javax.swing.GroupLayout jAddPanelLayout = new javax.swing.GroupLayout(jAddPanel);
        jAddPanel.setLayout(jAddPanelLayout);
        jAddPanelLayout.setHorizontalGroup(
            jAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAddPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jAddPanelLayout.createSequentialGroup()
                        .addGroup(jAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addComponent(lblSeries)
                            .addComponent(lblPrice)
                            .addComponent(lblLocation)
                            .addComponent(lblPartNumber)
                            .addComponent(lblPartType))
                        .addGroup(jAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jAddPanelLayout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(btnButton))
                            .addGroup(jAddPanelLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPartNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jAddPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(comboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jAddPanelLayout.createSequentialGroup()
                        .addComponent(lblQuantity)
                        .addGap(33, 33, 33)
                        .addGroup(jAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSeries, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jAddPanelLayout.setVerticalGroup(
            jAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAddPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSeries)
                    .addComponent(txtSeries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblQuantity)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jAddPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblPrice))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jAddPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocation)
                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPartNumber)
                    .addComponent(txtPartNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPartType))
                .addGap(31, 31, 31)
                .addComponent(btnButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jAddPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jAddPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
     * Preconditions: check whether the user entered all the data
     * into the fields
     * PostConditions: if everything was entered propely, add the entry
     * into the database
     */
    private void btnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnButtonActionPerformed

        boolean badChar;
        boolean badString;
        boolean dbAccess;   //success = 1, fail = 0
//        boolean dbSuccess;  
        String currentlyTesting;
        String itemCategory;
        
        if(this.txtName.getText().equals("")||
                this.txtSeries.getText().equals("")||
                this.txtPartNumber.getText().equals("")||
                this.txtPrice.getText().equals("")||
                this.txtLocation.getText().equals("")||
                this.txtQuantity.getText().equals("")){
            
            JOptionPane.showMessageDialog(frame, 
                    "Please enter all the fields.");
            
        }else{
            
             //assign text to the variables
            itemName = this.txtName.getText();
            itemSeries = this.txtSeries.getText();
            itemQuantity = this.txtQuantity.getText();
            itemPartNumber = this.txtPartNumber.getText();
            itemPrice = this.txtPrice.getText();
            itemLocation = this.txtLocation.getText();
            
            //making these in array in Transmission more fields will be 
            //added in the future so they can be just inputed here
            String[] listArrayText = {itemName,itemSeries,
                itemPartNumber,itemLocation};
            String[] listArrayIntNumbers = {itemQuantity};
            String[] listArrayFNumbers = {itemPrice};
            
            int arraySizeText = listArrayText.length;
            int arraySizeIntNumbers = listArrayIntNumbers.length;
            int arraySizeFNumbers = listArrayFNumbers.length;
            
            //now need to test for acceptable characters
            badChar = false;
            currentlyTesting = "text";
            for(int i =0; i < arraySizeText; i++)
            {
                badChar = testChar(listArrayText[i].toString(),
                        currentlyTesting);
                if(badChar == true){
                    JOptionPane.showMessageDialog(frame, 
                    "Invalid characters were entered."
                        + " Only letters, numbers and '.' are allowed"
                            + " to be entered.");
                    
                    //invalid characters, get out of here.
                    return;
                }
            }
            
            //here only integer numbers will be allowed
            currentlyTesting = "intnumbers";
            for(int i =0; i < arraySizeIntNumbers; i++)
            {
                badChar = testChar(listArrayIntNumbers[i].toString(),
                        currentlyTesting);
                if(badChar == true){
                    JOptionPane.showMessageDialog(frame, 
                    "Invalid characters were entered."
                        + " Make sure Quantity contains"
                            + " round and positive numbers only.");
                    
                    //invalid characters, get out of here.
                    return;
                }
            }
            
            
            //here only float numbers will be allowed
            currentlyTesting = "fnumbers";
            for(int i =0; i < arraySizeFNumbers; i++)
            {
                badChar = testChar(listArrayFNumbers[i].toString(),
                        currentlyTesting);
                if(badChar == true){
                    JOptionPane.showMessageDialog(frame, 
                    "Invalid characters were entered."
                        + " Make sure Price contains"
                            + " numbers only.");
                    
                    //invalid characters, get out of here.
                    return;
                }
            }
            
            //need to test if the name and part number wasn't just a space
//            if (this.txtName.equals(evt))
            badString = testString(this.txtName.getText());
            if (badString == true){
                JOptionPane.showMessageDialog(frame, 
                    "Name can't contain only spaces!");
                return;
                
            }
            badString = testString(this.txtPartNumber.getText());
            if (badString == true){
                JOptionPane.showMessageDialog(frame, 
                    "Part Number can't contain only spaces!");
                return;
                
            }
            
            badString = testString(this.txtPartNumber.getText());
            if (badString == true){
                JOptionPane.showMessageDialog(frame, 
                    "Part Number can't contain only spaces!");
                return;
                
            }
            
            itemCategory = (String)comboCategory.getSelectedItem( );
            
            //write the item to DB
            dbAccess = WriteToDB(itemCategory);
            
            if (dbAccess == true){
                 JOptionPane.showMessageDialog(frame, 
                    "Entry was added successfully to the database");
                 //clear the textfields
                 this.txtName.setText("");
                 this.txtSeries.setText("");
                 this.txtQuantity.setText("");
                 this.txtPrice.setText("");
                 this.txtLocation.setText("");
                 this.txtPartNumber.setText("");
                 
            }else{
                JOptionPane.showMessageDialog(frame, 
                    "Critical error! Database was not updated!"
                    + " Please report an error to the developer.");
            }
           
            
        }
        

        
    }//GEN-LAST:event_btnButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
                 this.txtName.setText("");
                 this.txtSeries.setText("");
                 this.txtQuantity.setText("");
                 this.txtPrice.setText("");
                 this.txtLocation.setText("");
                 this.txtPartNumber.setText("");

    }//GEN-LAST:event_formWindowClosed

    private void comboCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCategoryActionPerformed

    /*
     * Preconditions: create the textfile with the name of the item
     * plus the part number
     * Postconditions: the file is written to the directory. 
     */
    private boolean WriteToDB(String category){
        
        //this variable is used to save the file to the
        //correct category.
        String folder;
        
        boolean success;
        
        if(category.equals("Tires")){
            folder = "TIRES";
        }else if(category.equals("Head Lights")){
            folder = "HEAD LIGHTS";
        }else if(category.equals("Wind Shield")){
            folder = "WIND SHIELD";
        }else if(category.equals("Engines")){
            folder = "ENGINES";
        }else if(category.equals("Side Mirrors")){
            folder = "SIDE MIRRORS";
        }else if(category.equals("Rear Mirror")){
            folder = "REAR MIRROR";
        }else if(category.equals("Brakes")){
            folder = "BRAKES";
        }else if(category.equals("Hood")){
            folder = "HOOD";
        }else if(category.equals("Front Door")){    
            folder = "FRONT DOOR";
        }else if(category.equals("Back Door")){    
            folder = "BACK DOOR";
        }else if(category.equals("Fuel Tank")){    
            folder = "FUEL TANK";
        }else if(category.equals("Transmission")){    
            folder = "TRANSMISSION";
        }else{
            /*
             * Error, the folder was not found/DB can't be accessed. 
             * set success to false and exit. The message will be displayed
             * showing that update was failed.
            */
            success = false;
            return success;
        }
        
        //create new file with the name and partnumber
        //and save it to the appropriate category folder
        try {
          File file = new File(roots+ folder + File.separator
                  + itemName + "_" + itemPartNumber + ".txt");
          BufferedWriter output = new BufferedWriter(new FileWriter(file));
          output.write(itemName + "###" 
                  + itemSeries + "###"
                  + itemPrice.toString() + "###"
                  + itemQuantity.toString() + "###"
                  + itemLocation.toString() + "###"
                  + itemPartNumber.toString());
          output.close();
          success = true;
        } catch ( IOException e ) {
            //the file couldn't be created or accessed,
            //set success to false and exit the method
           success = false;
            
        }
        return success;
    }
    
    
     private boolean testChar(String stringContent, String curTesting){
        boolean val = false;
        Pattern p = Pattern.compile("[a-zA-Z0-9 .]+");
        
        //if testing for number fields, then make sure they contain
        //nothing else but numbers and a 'dot'
        if(curTesting.equals("intnumbers")){
            p = Pattern.compile("[0-9]+");
        }else if(curTesting.equals("fnumbers")){
            p = Pattern.compile("[0-9.]+");
        }
        
            Matcher m = p.matcher(stringContent);
            if (m.matches()){
                //matched only allowed characters, set the var to
                //false and return it
                val = false;
            }else{
                // Invalid input: reject it, set val = true
                val = true;
            }
            return val;
    }
     
     private boolean testString(String stringContent){
         boolean val = false;
        Pattern p1 = Pattern.compile("[a-zA-Z0-9.]+");
        Pattern p2 = Pattern.compile("[ ]+");
        
        Matcher m1 = p1.matcher(stringContent);
        Matcher m2 = p2.matcher(stringContent);
            if (!m1.matches()&& m2.matches()){
                // Invalid input: reject it, set val = true
                val = true;
            }else{
                //matched only allowed characters, set the var to
                //false and return it
                val = false;
            }
        
        return val;
     }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dbFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dbFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dbFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dbFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dbFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnButton;
    private javax.swing.JComboBox comboCategory;
    private javax.swing.JPanel jAddPanel;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPartNumber;
    private javax.swing.JLabel lblPartType;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblSeries;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPartNumber;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSeries;
    // End of variables declaration//GEN-END:variables
}

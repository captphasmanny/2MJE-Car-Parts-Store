/*
*This class is used when items were chosen to be added to the cart
After the user clicks "Add to Cart", the item will pop-up in the jTable
in this form. The table consist of 6 rows total:
Item (name), Price,  Qty, Available Qty, Discount %, Total item amount
The user can select and item, increase or decrease the quantity, remove an
item from the cart or completely clear the cart.
After the user satisfied with the chosen items and with the estimated
amount, he/she is able to click "Check Out" button to proceed with
the payment.
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pos.pmfuncs.MainFunc;




public class saleForm extends javax.swing.JFrame {

    private static String name,price,totalQuantity,discount;
    private static int defaultQuantity;
    private static int update;
    String [] Cdetail = new String [2];
    String testCoupon = "";
    boolean couponValid = false;
    String couponPercent = "0";
    boolean updatePriceOnly = false;
    int currentItemDetail=0;
    String quantity="1";
    JFrame CheckFrame = new CheckFrame();
    JFrame frameExp;
    private static boolean addNewItem = false;
    private static boolean addNewItemActivate = false;
    
    
    DefaultTableModel model;
    
    //setup a constructor
    public saleForm(String passname, String passprice, 
            String passquantity, String passdiscount, 
            int passDefaultQuantity, int passUpdateCart,
            boolean passAddNewItem, boolean passAddNewItemActivate){
        name = passname;
        price = passprice;
        totalQuantity = passquantity;
        discount = passdiscount;
        defaultQuantity = passDefaultQuantity;
        update = passUpdateCart;
        addNewItem = passAddNewItem;
        addNewItemActivate = passAddNewItemActivate;

    }
    
    
     /*
    Preconditions: this method updates the cart. Variable "update" determines
    whether to update the cart or not
    Postconditions: if update = 1, alow update and show it on the screen,
    otherwise, no changes will be applied.
    */  
    public void setList(){
//        int itemNumber = numberOfItemsInCart; 
//        DefaultListModel dlm = new DefaultListModel();
        double itemPrice;
        double temp;
        String formatItemPrice="";
        
        //if update = 1 then allow updating the cart. Otherwise, exit the method
        if (update !=1){
            return;
        }
        //check to make sure the variabels have data
        if (name != null && price != null &&
                quantity != null && discount != null){
            
          if(addNewItem == true){ 
              addNewItemActivate = true;
              addNewItem = false;
          }else{
              if(addNewItemActivate == true){
                  quantity = "1";
                  addNewItemActivate = false;
              }
          }
            
            //calculate the total value of the item(s)
          temp = Double.parseDouble(price) * 
                  (Double.parseDouble(discount)/100);
          itemPrice = (Double.parseDouble(price)- temp)*
                  Double.parseDouble(quantity);
          
          
          formatItemPrice = String.format("%.2f", itemPrice);
          if (model != null && updatePriceOnly == false){
          model.insertRow(model.getRowCount(),new Object[]{name,price,
              "1",totalQuantity,discount, formatItemPrice});
          UpdateTotalCartPrice();
          update = 0;
          }
          if (model != null && updatePriceOnly == true){
              
              model.setValueAt(formatItemPrice, tblCart.getSelectedRow(), 5);
              
              updatePriceOnly = false;
              UpdateTotalCartPrice();
              update = 0;
          }
          
          
        }else{
            return;
        }
        
    }

    //Preconditions: the string for coupon text is being tested
    //Postconditions: if the text was matched, the discount will be applied
    public void ApplyCoupon(){
        Cdetail = MainFunc.RTFCoupon(MainFunc.SpeciPathOri("")+"CouponCode.txt");

        if(Cdetail[0].equals(testCoupon)){
            couponValid = true;
            couponPercent = Cdetail[1]; //get the discount percentage
            JOptionPane.showMessageDialog(this, couponPercent + "% discount was "
                    + "applied to your total price!");
            UpdateTotalCartPrice();
        }else{
            //coupon is not valid, the discount will not be applied, so 
            //set the percent to 0
            couponPercent = "0";
            couponValid = false;    
        }
        
        
    }
    
    //Preconditions: The price is shown before any changes. 
    //Postconditions: after this method is called, the total price
    //will be updated
    private void UpdateTotalCartPrice(){
        double truePrice=0;     //price without discount
        double reducedPrice=0;  //if discsount applied
        String formatTruePrice="";
        String formatReducedPrice="";
        String s=""; 
        
        for(int i=0;i<model.getRowCount();i++){
            Object o = model.getValueAt(i, 5);
            s += o.toString();
            truePrice += Double.parseDouble(s);
            s="";
        }
        //strTruePrice = Double.toString(truePrice);
        //7% tax
        formatTruePrice = String.format("%.2f", truePrice*1.07);
        this.txtCartTotal.setText(formatTruePrice);
        
        if(couponValid = true ){
            reducedPrice = truePrice - (truePrice * 
                    Double.parseDouble(couponPercent)/100);
            //7% tax
            formatReducedPrice = String.format("%.2f", reducedPrice*1.07);
            this.txtEstimatedTotal.setText(formatReducedPrice); 
        }else{
          this.txtEstimatedTotal.setText(formatTruePrice);
          
        }
        
        
    }
    
    /** 
     * Creates new form saleForm
     */
    public saleForm() {
        initComponents();
        model = (DefaultTableModel)tblCart.getModel();
         //txtCoupon.setEditable(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblShoppingCart = new javax.swing.JLabel();
        lblItemTotal1 = new javax.swing.JLabel();
        lblLine = new javax.swing.JLabel();
        lblItemTotal2 = new javax.swing.JLabel();
        txtCoupon = new javax.swing.JTextField();
        txtCartTotal = new javax.swing.JTextField();
        txtEstimatedTotal = new javax.swing.JTextField();
        btnContinueShopping = new javax.swing.JButton();
        btnCheckOut = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        btnClearCart = new javax.swing.JButton();
        btnRemoveItem = new javax.swing.JButton();
        lblChooseQty = new javax.swing.JLabel();
        btnQtyAdd = new javax.swing.JButton();
        btnQtySubtract = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        lblShoppingCart.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblShoppingCart.setText("Shopping Cart:");

        lblItemTotal1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblItemTotal1.setForeground(new java.awt.Color(51, 153, 0));
        lblItemTotal1.setText("Cart total (taxes included) $:");

        lblLine.setText("_____________________________");

        lblItemTotal2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblItemTotal2.setForeground(new java.awt.Color(51, 153, 0));
        lblItemTotal2.setText("Coupon:");

        txtCoupon.setEditable(false);
        txtCoupon.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCoupon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCoupon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCouponKeyReleased(evt);
            }
        });

        txtCartTotal.setEditable(false);
        txtCartTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCartTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCartTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCartTotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        txtEstimatedTotal.setEditable(false);
        txtEstimatedTotal.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        txtEstimatedTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEstimatedTotal.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Estimated Total ($)", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 18))); // NOI18N

        btnContinueShopping.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        btnContinueShopping.setForeground(new java.awt.Color(255, 0, 0));
        btnContinueShopping.setText("Continue Shopping");
        btnContinueShopping.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnContinueShoppingMouseReleased(evt);
            }
        });

        btnCheckOut.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        btnCheckOut.setForeground(new java.awt.Color(0, 0, 204));
        btnCheckOut.setText("Check Out");
        btnCheckOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCheckOutMouseClicked(evt);
            }
        });
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });

        tblCart.setBackground(new java.awt.Color(240, 240, 240));
        tblCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Price", "Choose Quantity", "Qty Total Available", "Discount %", "Item Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCart);

        btnClearCart.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        btnClearCart.setText("Clear Cart");
        btnClearCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearCartActionPerformed(evt);
            }
        });

        btnRemoveItem.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        btnRemoveItem.setText("Remove Item");
        btnRemoveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveItemActionPerformed(evt);
            }
        });

        lblChooseQty.setText("Choose Quantity");

        btnQtyAdd.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        btnQtyAdd.setText("+");
        btnQtyAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQtyAddActionPerformed(evt);
            }
        });

        btnQtySubtract.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        btnQtySubtract.setText("-");
        btnQtySubtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQtySubtractActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCheckOut)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtEstimatedTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnClearCart, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnRemoveItem))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(btnQtySubtract, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblItemTotal2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCoupon, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblChooseQty)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(btnQtyAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addGap(57, 57, 57))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblLine, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(551, 551, 551)
                            .addComponent(lblItemTotal1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtCartTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblShoppingCart)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnContinueShopping)))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblShoppingCart)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemTotal1)
                    .addComponent(txtCartTotal)
                    .addComponent(btnRemoveItem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQtyAdd))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLine)
                            .addComponent(lblChooseQty))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCoupon, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(lblItemTotal2))
                        .addGap(26, 26, 26)
                        .addComponent(txtEstimatedTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClearCart, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnQtySubtract))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnContinueShopping)
                    .addComponent(btnCheckOut))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCheckOutMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCheckOutMouseClicked

    private void btnContinueShoppingMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContinueShoppingMouseReleased
         this.setVisible(false);
         //this.txtCoupon.setText("");
    }//GEN-LAST:event_btnContinueShoppingMouseReleased

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       

            this.setList();
            if(model.getRowCount()>0){
                   this.btnQtyAdd.setEnabled(true);
                   this.btnQtySubtract.setEnabled(true);
                   this.txtCoupon.setEditable(true);
            }
    }//GEN-LAST:event_formWindowActivated

    private void txtCouponKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCouponKeyReleased
        
        testCoupon = this.txtCoupon.getText();
        ApplyCoupon();
        
    }//GEN-LAST:event_txtCouponKeyReleased

    private void btnClearCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearCartActionPerformed
        //clear the cart when the button is clicked
        //and if there are items in the cart
        if(model.getRowCount()>0){
           model.setNumRows(0); //remove all items from the cart
            this.txtCartTotal.setText("");
            this.txtEstimatedTotal.setText("");
            this.txtCoupon.setText("");
            this.txtCoupon.setEditable(false);
            couponValid = false;    //reset couponValid to false
            couponPercent = "0"; //reset percentage to 0
            quantity = "1";
            JOptionPane.showMessageDialog(this, 
                    "All items were removed from your cart");
        }else{
            JOptionPane.showMessageDialog(this, 
                    "Your Cart is empty already");
        }
        
    }//GEN-LAST:event_btnClearCartActionPerformed

    private void btnRemoveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveItemActionPerformed
       //removes an item from the cart
        //and if there is at least one item in the cart
        if(model.getRowCount()>0){
            try{
            model.removeRow(tblCart.getSelectedRow());
            UpdateTotalCartPrice();
            if(model.getRowCount()< 1 ){
                couponValid = false;    //reset couponValid to false
                couponPercent = "0"; //reset percentage to 0
                quantity = "1";
                this.txtCoupon.setText("");
                this.txtCoupon.setEditable(false);
            }
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, 
                        "Please make sure to select an Item");
            }
       }else{
           JOptionPane.showMessageDialog(this, 
                    "Your Cart is empty");
       }
    }//GEN-LAST:event_btnRemoveItemActionPerformed

    private void btnQtyAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQtyAddActionPerformed
        //if there are available quantity amount,
        //the quantity can be increased by one with each click
        
        if(model.getRowCount()>0){
            int resetQty = 0;
            String strQty;
            int row = tblCart.getSelectedRow();
            int[] itemDetails = new int[3];
//            System.out.println(itemDetails.length);
            for(int i = 1; i < itemDetails.length; i++){
                itemDetails[i] = currentItemDetails(i);   //get current quantity in the table
//                 System.out.println(itemDetails[i]);
                 if(itemDetails[i] == -1000){
                    return; //use an error code to jump out in case of an error
                }
                  if(i == 1){
                     resetQty = itemDetails[i];
                 }else if(i == 2){
                     totalQuantity = Integer.toString(itemDetails[i]);
                 }else if(i == 3){
                     discount = Integer.toString(itemDetails[i]);
//                     System.out.println(discount);
                 }
            }
            
            resetQty +=1;               //increase by 1
            
            price = (tblCart.getModel().getValueAt(row, 1).toString());
            if(resetQty > Integer.parseInt(totalQuantity)){
                JOptionPane.showMessageDialog(this, totalQuantity + 
                        " is the maximum");
            }else{
//                int row = tblCart.getSelectedRow();
                strQty = Integer.toString(resetQty);
                model.setValueAt(resetQty, tblCart.getSelectedRow(), 2);
                quantity = Integer.toString(resetQty);
                updatePriceOnly = true;
                update = 1;
                setList();
            }
        
        }else{
            JOptionPane.showMessageDialog(this,"Please add an item"
                    + " to the cart first");
        }
        
    }//GEN-LAST:event_btnQtyAddActionPerformed

    private void btnQtySubtractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQtySubtractActionPerformed
        //if desired, the customer can decrease the qty to 0
        if(model.getRowCount()>0){
            int resetQty = 0;
            String strQty;
            int row = tblCart.getSelectedRow();
            int[] itemDetails = new int[3];
            
            for(int i = 1; i < itemDetails.length; i++){
               
                itemDetails[i] = currentItemDetails(i);   //get current item details
                 if(itemDetails[i] == -1000){
                    return; //use an error code to jump out in case of an error
                }
                 if(i == 1){
                     resetQty = itemDetails[i];
                 }else if(i == 2){
                     totalQuantity = Integer.toString(itemDetails[i]);
                 }else if(i == 3){
                     discount = Integer.toString(itemDetails[i]);
                 }
            }
            
            resetQty -=1;               //increase by 1
            
            price = (tblCart.getModel().getValueAt(row, 1).toString());
            
            
            if(resetQty < 0){
                JOptionPane.showMessageDialog(this, "Please select"
                        + " quantity more than 0");
            }else{
//                int row = tblCart.getSelectedRow();
                strQty = Integer.toString(resetQty);
                model.setValueAt(resetQty, tblCart.getSelectedRow(), 2);
                quantity = Integer.toString(resetQty);
                updatePriceOnly = true;
                update = 1;
                setList();
            }
        
        }else{
            JOptionPane.showMessageDialog(this,"Please add an item"
                    + " to the cart first");
        }
        
    }//GEN-LAST:event_btnQtySubtractActionPerformed

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
        //The user clicks this button when he is ready to cheack out
        
        if(txtEstimatedTotal.getText().equals("")||txtEstimatedTotal.getText().equals("0.00")){
            JOptionPane.showMessageDialog(frameExp, "Please add at least one item "
                    + "in the cart before you checkout.");
        }
        else{
            
                BufferedWriter writer;
                BufferedWriter writer2;
                BufferedWriter writer3;
                
            try
    {
    File file = new File("PaymentCurr.txt");
    file.createNewFile();
    File file2 = new File("FBListCurr.txt");
    file2.createNewFile();
    File file3 = new File("FBQuanCurr.txt");
    file3.createNewFile();
    

    writer = new BufferedWriter(new FileWriter(file));

                writer.write(txtEstimatedTotal.getText());
                writer.newLine();
                //System.out.println(SEAList[i]);
    writer.close();
    
    writer2 = new BufferedWriter(new FileWriter(file2));

    for(int w=0; w<model.getRowCount();w++){
                writer2.write(model.getValueAt(w, 0)+"###");
    }
                writer2.newLine();
                //System.out.println(SEAList[i]);
    writer2.close();
    
    writer3 = new BufferedWriter(new FileWriter(file3));

    for(int h=0; h<model.getRowCount();h++){
                writer3.write(model.getValueAt(h, 2)+"###");
    }
                writer3.newLine();
                //System.out.println(SEAList[i]);
    writer3.close();
    

    }
    catch(FileNotFoundException e)
    {
        System.out.println("File Not Found");
        //System.exit( 1 );
    }
    catch(IOException e)
    {
        System.out.println("something messed up");
        //System.exit( 1 );
    }
        
            
        CheckFrame.pack();
        CheckFrame.setLocationRelativeTo(null);
        CheckFrame.setVisible(true);
        setVisible(false);
        dispose();
        }
    }//GEN-LAST:event_btnCheckOutActionPerformed

       //preconditions: integer index is being passed to get the
        //the details of the item one by one
        //Postconditions: based on the integer number
        //the proper detailes is collected from the jTable
    public int currentItemDetails(int item){
        
            try{
            int row = tblCart.getSelectedRow();
            String itemDetail="";
            
            
//            if (item == 0){
//                //getting price here
//                itemDetail = (tblCart.getModel().getValueAt(row, 1).toString());
//            }else 
                if(item == 1){
                //getting quantity the customer chose
                itemDetail = (tblCart.getModel().getValueAt(row, 2).toString());
            }else if(item == 2){
                //getting total quantity available
                itemDetail = (tblCart.getModel().getValueAt(row, 3).toString());
            }else if(item == 3){
                //getting discount percentage amount
                itemDetail = (tblCart.getModel().getValueAt(row, 4).toString());
            }
           
//           System.out.println(itemDetail + " item: " + item);
           currentItemDetail = Integer.parseInt(itemDetail);
           
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,"Please select"
                        + " an item first!");
                currentItemDetail = -1000; //this is an error code
            }
        
        return currentItemDetail;
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
            java.util.logging.Logger.getLogger(saleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(saleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(saleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(saleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new saleForm().setVisible(true);
            }
        });
        
        
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JButton btnClearCart;
    private javax.swing.JButton btnContinueShopping;
    private javax.swing.JButton btnQtyAdd;
    private javax.swing.JButton btnQtySubtract;
    private javax.swing.JButton btnRemoveItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblChooseQty;
    private javax.swing.JLabel lblItemTotal1;
    private javax.swing.JLabel lblItemTotal2;
    private javax.swing.JLabel lblLine;
    private javax.swing.JLabel lblShoppingCart;
    private javax.swing.JTable tblCart;
    private javax.swing.JTextField txtCartTotal;
    private javax.swing.JTextField txtCoupon;
    private javax.swing.JTextField txtEstimatedTotal;
    // End of variables declaration//GEN-END:variables
}


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import pos.pmfuncs.MainFunc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public class RateFrame extends javax.swing.JFrame {
    boolean Select1 = false;
    boolean Select2 = false;
    boolean Select3 = false;
    boolean Select4 = false;
    boolean Select5 = false;
    boolean Submited = false;
    JFrame frameRak;

    /**
     * Creates new form RateFrame
     */
    public RateFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        RateItem = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        Rate1 = new javax.swing.JRadioButton();
        Rate2 = new javax.swing.JRadioButton();
        Rate3 = new javax.swing.JRadioButton();
        Rate4 = new javax.swing.JRadioButton();
        Rate5 = new javax.swing.JRadioButton();
        jSeparator3 = new javax.swing.JSeparator();
        SubmitButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("You Are Now Rating:");

        RateItem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RateItem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Rate1.setText("1");
        Rate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rate1ActionPerformed(evt);
            }
        });

        Rate2.setText("2");
        Rate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rate2ActionPerformed(evt);
            }
        });

        Rate3.setText("3");
        Rate3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rate3ActionPerformed(evt);
            }
        });

        Rate4.setText("4");
        Rate4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rate4ActionPerformed(evt);
            }
        });

        Rate5.setText("5");
        Rate5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rate5ActionPerformed(evt);
            }
        });

        SubmitButton.setText("Submit");
        SubmitButton.setToolTipText("");
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator2)
                            .addComponent(RateItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Rate1)
                                .addGap(49, 49, 49)
                                .addComponent(Rate2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(Rate3)
                                .addGap(46, 46, 46)
                                .addComponent(Rate4)
                                .addGap(50, 50, 50)
                                .addComponent(Rate5))
                            .addComponent(jSeparator3)
                            .addComponent(SubmitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CancelButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(RateItem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Rate1)
                    .addComponent(Rate2)
                    .addComponent(Rate3)
                    .addComponent(Rate4)
                    .addComponent(Rate5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SubmitButton)
                .addGap(18, 18, 18)
                .addComponent(CancelButton)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        RateItem.setText(MainFunc.RTF2(MainFunc.SpeciPathOri("")+"RateItem.txt"));
    }//GEN-LAST:event_formWindowActivated

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        // TODO add your handling code here:
        Select1 = false; Select2 = false; Select3 = false; Select4 = false; Select5 = false; 
        Rate1.setSelected(false);Rate2.setSelected(false);Rate3.setSelected(false);Rate4.setSelected(false);Rate5.setSelected(false);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
        // TODO add your handling code here:
        if(Select1 == true){
            MainFunc.RateIt("1");
            Submited = true;
            JOptionPane.showMessageDialog(frameRak, 
                        "You give the item a rating of 1.");
        }
        else if(Select2 == true){
            MainFunc.RateIt("2");
            Submited = true;
            JOptionPane.showMessageDialog(frameRak, 
                        "You give the item a rating of 2.");
        }
        else if(Select3 == true){
            MainFunc.RateIt("3");
            Submited = true;
            JOptionPane.showMessageDialog(frameRak, 
                        "You give the item a rating of 3.");
        }
        else if(Select4 == true){
            MainFunc.RateIt("4");
            Submited = true;
            JOptionPane.showMessageDialog(frameRak, 
                        "You give the item a rating of 4.");
        }
        else if(Select5 == true){
            MainFunc.RateIt("5");
            Submited = true;
            JOptionPane.showMessageDialog(frameRak, 
                        "You give the item a rating of 5.");
        }
        else{
            JOptionPane.showMessageDialog(frameRak, 
                        "You Must Select A Number Before Submit.");
        }
        if(Submited == true){
        Select1 = false; Select2 = false; Select3 = false; Select4 = false; Select5 = false; 
        Rate1.setSelected(false);Rate2.setSelected(false);Rate3.setSelected(false);Rate4.setSelected(false);Rate5.setSelected(false);
        setVisible(false);
        dispose();
        }
    }//GEN-LAST:event_SubmitButtonActionPerformed

    private void Rate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rate1ActionPerformed
        // TODO add your handling code here:
        Select1 = true; Select2 = false; Select3 = false; Select4 = false; Select5 = false; 
        Rate2.setSelected(false);Rate3.setSelected(false);Rate4.setSelected(false);Rate5.setSelected(false);
    }//GEN-LAST:event_Rate1ActionPerformed

    private void Rate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rate2ActionPerformed
        // TODO add your handling code here:
        Select1 = false; Select2 = true; Select3 = false; Select4 = false; Select5 = false; 
        Rate1.setSelected(false);Rate3.setSelected(false);Rate4.setSelected(false);Rate5.setSelected(false);
    }//GEN-LAST:event_Rate2ActionPerformed

    private void Rate3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rate3ActionPerformed
        // TODO add your handling code here:
        Select1 = false; Select2 = false; Select3 = true; Select4 = false; Select5 = false;
        Rate1.setSelected(false);Rate2.setSelected(false);Rate4.setSelected(false);Rate5.setSelected(false);
    }//GEN-LAST:event_Rate3ActionPerformed

    private void Rate4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rate4ActionPerformed
        // TODO add your handling code here:
        Select1 = false; Select2 = false; Select3 = false; Select4 = true; Select5 = false;
        Rate1.setSelected(false);Rate2.setSelected(false);Rate3.setSelected(false);Rate5.setSelected(false);
    }//GEN-LAST:event_Rate4ActionPerformed

    private void Rate5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rate5ActionPerformed
        // TODO add your handling code here:
        Select1 = false; Select2 = false; Select3 = false; Select4 = false; Select5 = true;
        Rate1.setSelected(false);Rate2.setSelected(false);Rate3.setSelected(false);Rate4.setSelected(false);
    }//GEN-LAST:event_Rate5ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        Select1 = false; Select2 = false; Select3 = false; Select4 = false; Select5 = false; 
        Rate1.setSelected(false);Rate2.setSelected(false);Rate3.setSelected(false);Rate4.setSelected(false);Rate5.setSelected(false);
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(RateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RateFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JRadioButton Rate1;
    private javax.swing.JRadioButton Rate2;
    private javax.swing.JRadioButton Rate3;
    private javax.swing.JRadioButton Rate4;
    private javax.swing.JRadioButton Rate5;
    private javax.swing.JLabel RateItem;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}

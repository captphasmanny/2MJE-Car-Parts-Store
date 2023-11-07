
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDialog;
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
public class PrintFrame extends javax.swing.JFrame {
    JFrame framePri;

    /**
     * Creates new form PrintFrame
     */
    public PrintFrame() {
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
        PrintFull = new javax.swing.JButton();
        PrintPayHis = new javax.swing.JButton();
        CleanPayHis = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Print Records");

        PrintFull.setText("Print Full Item List To Text");
        PrintFull.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintFullActionPerformed(evt);
            }
        });

        PrintPayHis.setText("Print Payment History To Text");
        PrintPayHis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintPayHisActionPerformed(evt);
            }
        });

        CleanPayHis.setText("Cleanup Payment History");
        CleanPayHis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CleanPayHisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PrintFull, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PrintPayHis, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                            .addComponent(CleanPayHis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel1)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(PrintFull, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PrintPayHis, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CleanPayHis, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PrintFullActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintFullActionPerformed
        // TODO add your handling code here:
                            File folderP = new File(MainFunc.SpeciPath(""));
        // gets you the list of files at this folder
        File[] listOfFilesP = folderP.listFiles();//read all the files paths/names
        String[] folderArrayP = new String[listOfFilesP.length];//convert File to String
        
        for (int ip = 0; ip < listOfFilesP.length; ++ip){
            folderArrayP[ip] = listOfFilesP[ip].getName();//restore names to String Array
            //System.out.println(folderArray[i]);
        }
        
                BufferedWriter writer;
            try
    {
    File file = new File("FullList.txt");
    file.createNewFile();

    writer = new BufferedWriter(new FileWriter(file));

    
    for(int kP=0; kP<folderArrayP.length-1; kP++){
            File folder2P = new File(MainFunc.SpeciPath("")+folderArrayP[kP]);
            //System.out.println(MainFunc.SpeciPath("")+folderArray[k]);
            File[] listOfFiles2P = folder2P.listFiles();
            String[] FullList = new String[listOfFiles2P.length];
        
            for (int ix = 0; ix < listOfFiles2P.length; ++ix){
                FullList[ix] = listOfFiles2P[ix].getName();//restore names to String Array
                writer.write(FullList[ix].substring(0,FullList[ix].length()-4 ));
                writer.newLine();
                //System.out.println(SEAList[i]);
            }
    }
    writer.close();
    
if (Desktop.isDesktopSupported()) {
    Desktop.getDesktop().edit(file);
} else {
    // dunno, up to you to handle this
}

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
    }//GEN-LAST:event_PrintFullActionPerformed

    private void PrintPayHisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintPayHisActionPerformed
        // TODO add your handling code here:
        try{
        File file2 = new File("PaymentHistory.txt");
        if (Desktop.isDesktopSupported()) {
    Desktop.getDesktop().edit(file2);
} else {
    // dunno, up to you to handle this
}
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
    }//GEN-LAST:event_PrintPayHisActionPerformed

    private void CleanPayHisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CleanPayHisActionPerformed
        // TODO add your handling code here:
        JDialog.setDefaultLookAndFeelDecorated(true);
    int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (response == JOptionPane.NO_OPTION) {
      //System.out.println("No button clicked");
    
    } else if (response == JOptionPane.YES_OPTION) {
      //System.out.println("Yes button clicked");
        BufferedWriter writer2;
                  try{
        File file2 = new File("PaymentHistory.txt");
        writer2 = new BufferedWriter(new FileWriter(file2));
        writer2.newLine();
        writer2.close();
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
                  
                  JOptionPane.showMessageDialog(framePri, 
                        "Your Payment History Has Been Cleaned Up!");
    } else if (response == JOptionPane.CLOSED_OPTION) {
      //System.out.println("JOptionPane closed");
    }
        
        
        
    
    }//GEN-LAST:event_CleanPayHisActionPerformed

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
            java.util.logging.Logger.getLogger(PrintFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrintFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CleanPayHis;
    private javax.swing.JButton PrintFull;
    private javax.swing.JButton PrintPayHis;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

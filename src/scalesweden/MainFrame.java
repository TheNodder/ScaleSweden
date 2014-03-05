/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scalesweden;

import java.awt.Component;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JFileChooser;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Niclas Olsson, Cobton AB
 */
public class MainFrame extends javax.swing.JFrame {

    boolean CompStarted = false;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jToolBar1 = new javax.swing.JToolBar();
        jButtonCompetition = new javax.swing.JButton();
        jButtonRules = new javax.swing.JButton();
        jButtonDocuments = new javax.swing.JButton();
        jButtonSettings = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Skala Sverige 2014.0");
        setPreferredSize(new java.awt.Dimension(1366, 768));

        jToolBar1.setRollover(true);

        jButtonCompetition.setText("Tävlingar");
        jButtonCompetition.setToolTipText("");
        jButtonCompetition.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCompetition.setFocusable(false);
        jButtonCompetition.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCompetition.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButtonCompetition.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonCompetition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCompetitionActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonCompetition);

        jButtonRules.setText("Regler");
        jButtonRules.setToolTipText("");
        jButtonRules.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRules.setFocusable(false);
        jButtonRules.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonRules.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRules.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButtonRules.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonRules.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRulesActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonRules);

        jButtonDocuments.setText("Dokument");
        jButtonDocuments.setToolTipText("");
        jButtonDocuments.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonDocuments.setFocusable(false);
        jButtonDocuments.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonDocuments.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonDocuments.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButtonDocuments.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonDocuments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDocumentsActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonDocuments);

        jButtonSettings.setText("Inställningar");
        jButtonSettings.setToolTipText("");
        jButtonSettings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSettings.setFocusable(false);
        jButtonSettings.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSettings.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButtonSettings.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSettingsActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonSettings);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${maximizedBounds}"), jDesktopPane1, org.jdesktop.beansbinding.BeanProperty.create("border"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDesktopPane1.getAccessibleContext().setAccessibleName("");

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean setModal(String dialogName) {
        /**
         * We should create a utility class for this stuff: This function is
         * being called first to make sure that there is only one dialog present
         * in the pane from the wanted class Like a modal behaviour that won't
         * obstruct other dialogs from other classes.
         */

        boolean active = false;

        JInternalFrame[] allFrames = jDesktopPane1.getAllFrames();

        for (JInternalFrame allFrame : allFrames) {

            if (dialogName.equals(allFrame.getName())) {
                try {

                    allFrame.moveToFront();
                                      
                    if (!dialogName.equals("setDlg")) { //Don't maximize the settingsdialog
                        allFrame.setMaximum(true);
                    }
                    allFrame.setSelected(true);

                } catch (PropertyVetoException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                active = true;
                break;
            }
        }

        return active;
    }

    @SuppressWarnings("empty-statement")
    private void jButtonCompetitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCompetitionActionPerformed

       if (!setModal("compDlg")) {

           Competition CompList = new Competition();

           Component add = jDesktopPane1.add(CompList);
           CompList.setTitle("Tävlingar");

           try {
               CompList.setMaximum(true);
           } catch (PropertyVetoException ex) {
               Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
           }
           CompList.setVisible(true);
       }


    }//GEN-LAST:event_jButtonCompetitionActionPerformed

    private void jButtonRulesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRulesActionPerformed
        // TODO add your handling code here:
        if (!setModal("rulesDlg")) {
            Rules CRules = new Rules();
            jDesktopPane1.add(CRules);
            try {
                CRules.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            CRules.setVisible(true);
    }//GEN-LAST:event_jButtonRulesActionPerformed
    }

    private void jButtonSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSettingsActionPerformed
        // TODO add your handling code here:
        if (!setModal("setDlg")) {
            ClubSettings CSettings = new ClubSettings();
            jDesktopPane1.add(CSettings);
            CSettings.setLocation(((int) jDesktopPane1.getBounds().getWidth() / 2) - (CSettings.getWidth() / 2), 2); //Try to center on screen
            CSettings.setVisible(true);
        }

    }//GEN-LAST:event_jButtonSettingsActionPerformed

    private void jButtonDocumentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDocumentsActionPerformed
        
        // Open documents to print/view/edit
        String DocDir = System.getProperty("user.dir")+"/documents/";
        
        JFileChooser FileOpener = new JFileChooser(DocDir);
       
        
        int showOpenDialog = FileOpener.showOpenDialog(jDesktopPane1);
               
        if(showOpenDialog == JFileChooser.APPROVE_OPTION) {
            String DocPath = DocDir + FileOpener.getSelectedFile().getName();
            try {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(new File(DocPath)); // Try to open file with associated program
                }
            }
            catch (IOException ioe) {
                    JOptionPane.showMessageDialog(jDesktopPane1, "Det verkar inte finnas något program som kan hantera " + FileOpener.getSelectedFile().getName(), "Problem...", JOptionPane.ERROR_MESSAGE);
                }
             }
           
    }//GEN-LAST:event_jButtonDocumentsActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String args[]) throws ClassNotFoundException {

        /* Invoke the SQLite driver     */
        Class.forName("org.sqlite.JDBC");

        /* Set the Nimbus look and feel 
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);

            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCompetition;
    private javax.swing.JButton jButtonDocuments;
    private javax.swing.JButton jButtonRules;
    private javax.swing.JButton jButtonSettings;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JToolBar jToolBar1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}

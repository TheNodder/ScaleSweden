/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scalesweden;

import java.awt.Component;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Niclas
 */
public class MainFrame extends javax.swing.JFrame {

   
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
        jButtonCompetition1 = new javax.swing.JButton();
        jButtonCompetition2 = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Skala Sverige 2013.0");
        setPreferredSize(new java.awt.Dimension(1366, 768));

        jToolBar1.setRollover(true);

        jButtonCompetition.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scalesweden/icons/competition.png"))); // NOI18N
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

        jButtonCompetition1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scalesweden/icons/rules.png"))); // NOI18N
        jButtonCompetition1.setText("Regler");
        jButtonCompetition1.setToolTipText("");
        jButtonCompetition1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCompetition1.setFocusable(false);
        jButtonCompetition1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonCompetition1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCompetition1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButtonCompetition1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonCompetition1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCompetition1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonCompetition1);

        jButtonCompetition2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scalesweden/icons/settings.png"))); // NOI18N
        jButtonCompetition2.setText("Inställningar");
        jButtonCompetition2.setToolTipText("");
        jButtonCompetition2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCompetition2.setFocusable(false);
        jButtonCompetition2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCompetition2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButtonCompetition2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonCompetition2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCompetition2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonCompetition2);

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
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCompetitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCompetitionActionPerformed
        // TODO add your handling code here:
        
        Competition CompList = new Competition();
        Component add = jDesktopPane1.add(CompList);
        CompList.setTitle("Tävlingar");

        try {
            CompList.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        CompList.setVisible(true);
        //CompList.show();
        jButtonCompetition.setEnabled(false);
       
    }//GEN-LAST:event_jButtonCompetitionActionPerformed

    private void jButtonCompetition1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCompetition1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCompetition1ActionPerformed

    private void jButtonCompetition2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCompetition2ActionPerformed
        // TODO add your handling code here:
        ClubSettings CSettings = new ClubSettings();
        jDesktopPane1.add(CSettings);
        CSettings.setVisible(true);
    }//GEN-LAST:event_jButtonCompetition2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ClassNotFoundException {
        
        /* Invoke the SQLite driver     */        
        Class.forName("org.sqlite.JDBC");
        
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
    private javax.swing.JButton jButtonCompetition1;
    private javax.swing.JButton jButtonCompetition2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JToolBar jToolBar1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}

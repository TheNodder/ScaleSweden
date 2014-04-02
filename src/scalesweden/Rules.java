/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scalesweden;

import java.awt.Container;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Niclas Olsson, Cobton AB
 */
public class Rules extends javax.swing.JInternalFrame {

    Object[] columnNames = {"Namn:", "Tävlingsklass:", "Typ av regel:", "Skapad:", "Redigerbar:"};
    private DefaultTableModel rules_Model;

    /**
     * Creates new form Rules
     */
    public Rules() {
        initComponents();
        //populateRulesTable();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu_Rules = new javax.swing.JPopupMenu();
        jMenuItem_EditRule = new javax.swing.JMenuItem();
        jMenuItem_CopyRule = new javax.swing.JMenuItem();
        jSeparator_Popmenu = new javax.swing.JPopupMenu.Separator();
        jMenuItem_DeleteRule = new javax.swing.JMenuItem();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Rules = new javax.swing.JTable();

        jMenuItem_EditRule.setText("Redigera/visa regel");
        jMenuItem_EditRule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_EditRuleActionPerformed(evt);
            }
        });
        jPopupMenu_Rules.add(jMenuItem_EditRule);

        jMenuItem_CopyRule.setText("Kopiera regel.");
        jMenuItem_CopyRule.setToolTipText("Kopiera markerad regel till en ny regel.");
        jMenuItem_CopyRule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_CopyRuleActionPerformed(evt);
            }
        });
        jPopupMenu_Rules.add(jMenuItem_CopyRule);
        jPopupMenu_Rules.add(jSeparator_Popmenu);

        jMenuItem_DeleteRule.setText("Radera regel");
        jMenuItem_DeleteRule.setToolTipText("Ta bort regel från systemet.");
        jMenuItem_DeleteRule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_DeleteRuleActionPerformed(evt);
            }
        });
        jPopupMenu_Rules.add(jMenuItem_DeleteRule);

        setClosable(true);
        setResizable(true);
        setTitle("Regler");
        setName("rulesDlg"); // NOI18N
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jButton1.setText("Ny regel...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable_Rules.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Namn", "Tävlingsklass", "Typ av regel", "Skapad", "Redigerbar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Rules.setToolTipText("Högerklicka för meny.");
        jTable_Rules.setComponentPopupMenu(jPopupMenu_Rules);
        jTable_Rules.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_Rules.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_RulesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Rules);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void populateRulesTable() {

        rules_Model = new DefaultTableModel(columnNames, 0);
        jTable_Rules.setModel(rules_Model);
        
        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:db/scale.db");
            Statement statement = connection.createStatement();

            statement.setQueryTimeout(2);  // set timeout to 10 sec.

            ResultSet rs = statement.executeQuery("select * from rules order by created_at desc;");

            while (rs.next()) {
                // read the result set and pop into the table

                Object[] row = new Object[rs.getMetaData().getColumnCount()];
                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                    if ("created_at".equals(rs.getMetaData().getColumnName(i + 1))) {
                        row[i] = rs.getTimestamp(i + 1); //Convert timestamp to human readable
                    } else {
                        row[i] = rs.getObject(i + 1);
                    }
                }
                rules_Model.addRow(row);
            }
        } catch (SQLException e) {
            // if the error message is "out of memory", 
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
    }

    private boolean checkForDialogs() {

        boolean retVal = false;

        javax.swing.JDesktopPane pane;
        pane = this.getDesktopPane();

        JInternalFrame[] allFrames = pane.getAllFrames();

        for (JInternalFrame frame : allFrames) {
            if (frame.getName().equals("newRule")) {
                try {
                    frame.setSelected(true);
                    frame.moveToFront();
                    retVal = true;
                } catch (PropertyVetoException ex) {
                }
            }
        }
        return retVal; //We didn't find any dialog so maybe we should allow a creation ?
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (!checkForDialogs()) {
            NewRule CRule = new NewRule();
            Container parent = this.getParent();

            CRule.setLocation(((int) parent.getBounds().getWidth() / 2) - (CRule.getWidth() / 2), 2); //Try to center on screen
            parent.add(CRule);
            CRule.setVisible(true);

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable_RulesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_RulesMouseClicked
        // TODO add your handling code here:
        //if(evt == MOUSE_CLICKED){
        System.out.print("Dubbelklick");
        //}
    }//GEN-LAST:event_jTable_RulesMouseClicked

    private void jMenuItem_EditRuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_EditRuleActionPerformed

        if (!checkForDialogs()) {
            java.sql.Timestamp ts;

            ts = (java.sql.Timestamp) rules_Model.getValueAt(jTable_Rules.getSelectedRow(), 3);

            NewRule ERule = new NewRule(ts.getTime());
            Container Eparent = this.getParent();

            ERule.setLocation(((int) Eparent.getBounds().getWidth() / 2) - (ERule.getWidth() / 2), 2); //Try to center on screen
            Eparent.add(ERule);
            ERule.setVisible(true);
        }

    }//GEN-LAST:event_jMenuItem_EditRuleActionPerformed

    private void jMenuItem_DeleteRuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_DeleteRuleActionPerformed

        if ("Nej".equals(rules_Model.getValueAt(jTable_Rules.getSelectedRow(), 4))) {

            JOptionPane.showMessageDialog(this.getDesktopPane(),
                    "Det är inte tillåtet att radera denna regel!",
                    "Regel är inte raderbar!",
                    JOptionPane.WARNING_MESSAGE);
        } else {

            java.sql.Timestamp ts;

            ts = (java.sql.Timestamp) rules_Model.getValueAt(jTable_Rules.getSelectedRow(), 3);

            Connection connection = null;
            try {
                // create a database connection
                connection = DriverManager.getConnection("jdbc:sqlite:db/scale.db");
                Statement statement = connection.createStatement();

                statement.setQueryTimeout(2);  // set timeout to 2 sec.

                int rs = statement.executeUpdate("DELETE FROM rules_static WHERE created_at = '" + ts.getTime() + "';");
                rs = statement.executeUpdate("DELETE FROM rules_manouvers WHERE created_at = '" + ts.getTime() + "';");
                rs = statement.executeUpdate("DELETE FROM rules WHERE created_at = '" + ts.getTime() + "';");

            } catch (SQLException e) {
                // if the error message is "out of memory", 
                // it probably means no database file is found
                System.err.println(e.getMessage());
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {

                    System.err.println(e);
                }
            }
            populateRulesTable();
        }

    }//GEN-LAST:event_jMenuItem_DeleteRuleActionPerformed

    private void jMenuItem_CopyRuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_CopyRuleActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this.getDesktopPane(),
                "Jobba på Niclas! Sluta sov på kvällar å nätter!",
                "Jag ska impa in kod!",
                JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jMenuItem_CopyRuleActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // Refresh the table
        populateRulesTable();
    }//GEN-LAST:event_formInternalFrameActivated


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuItem jMenuItem_CopyRule;
    private javax.swing.JMenuItem jMenuItem_DeleteRule;
    private javax.swing.JMenuItem jMenuItem_EditRule;
    private javax.swing.JPopupMenu jPopupMenu_Rules;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator_Popmenu;
    private javax.swing.JTable jTable_Rules;
    // End of variables declaration//GEN-END:variables
}

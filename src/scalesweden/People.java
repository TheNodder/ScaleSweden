/*
 * Copyright (C) 2015 Niclas Olsson, Cobton AB
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Niclas
 */
public class People extends javax.swing.JInternalFrame {

    Object[] columnNames = {"Förnamn:", "Efternamn:", "Prefix:", "Nationellt nr:", "Klubb:"};
    private DefaultTableModel people_Model;
    static int clack = 0;
    static int selectedRow = 0;

    /**
     * Creates new form People
     */
    public People() {
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

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_People = new javax.swing.JTable();

        setClosable(true);
        setName("peopleDlg"); // NOI18N
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

        jButton1.setText("Ny aktiv");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable_People.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Förnamn:", "Efternamn:", "SMFF nr:", "Klubb:"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_People.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_PeopleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_People);

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void populatePeopleTable() {

        people_Model = new DefaultTableModel(columnNames, 0);
        jTable_People.setModel(people_Model);

        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:db/scale.db");
            Statement statement = connection.createStatement();

            statement.setQueryTimeout(15);  // set timeout to 15 sec.

            ResultSet rs = statement.executeQuery("select name, lastname, prefix, nationalnbr, clubname from people order by name;");

            while (rs.next()) {
                // read the result set and pop into the table

                Object[] row = new Object[rs.getMetaData().getColumnCount()];
                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                    row[i] = rs.getObject(i + 1);
                }
                people_Model.addRow(row);

            }

        } catch (SQLException e) {
            // if the error message is "out of memory", 
            // it probably means no database file is found
            System.err.println(e.getMessage());
            // JOptionPane.showMessageDialog(this, "Problem: " + System.err.(e.getMessage()) "Problem...", JOptionPane.ERROR_MESSAGE);
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
            if (frame.getName().equals("peopleEdit")) {
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
    
   private void showEditDialog() {
        if (!checkForDialogs()) {
            java.sql.Timestamp ts;

            ts = (java.sql.Timestamp) jTable_People.getValueAt(jTable_People.getSelectedRow(), 3);

            People_Edit EditPilot = new People_Edit();
            Container parent = this.getParent();

            EditPilot.setLocation(((int) parent.getBounds().getWidth() / 2) - (EditPilot.getWidth() / 2), 2); //Try to center on screen
            parent.add(EditPilot);
            EditPilot.setVisible(true);
        }
    }
   
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        showEditDialog();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        populatePeopleTable();
        checkForDialogs();
    }//GEN-LAST:event_formInternalFrameActivated

    private void jTable_PeopleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_PeopleMouseClicked
        // TODO add your handling code here:
        clack += 1;

        if (clack >= 2 && selectedRow == jTable_People.getSelectedRow()) {

            System.out.println("Dubbelklick" + evt.getClickCount());
            clack = 0;
            showEditDialog();
        }
        selectedRow = jTable_People.getSelectedRow();
    }//GEN-LAST:event_jTable_PeopleMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_People;
    // End of variables declaration//GEN-END:variables
}

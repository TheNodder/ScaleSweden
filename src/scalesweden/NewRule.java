/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package scalesweden;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import static scalesweden.ScaleClasses.ListOfManouvers;
/**
 *
 * @author niclas
 */
public class NewRule extends javax.swing.JInternalFrame {

    /**
     * Creates new form NewRule
     */
    public NewRule() {
        initComponents();
        initDropDowns(); // Prepare the dropdowns in the title area
    }

     private void initManouversColumn(TableColumn manouverColumn) {
        //Set up the editor for the manouvers.
        JComboBox manouverComboBox = new JComboBox(ListOfManouvers);
        
        manouverColumn.setCellEditor(new DefaultCellEditor(manouverComboBox));
 
        //Set up tool tip for the manouver cells.
        DefaultTableCellRenderer renderer =  new DefaultTableCellRenderer();
        renderer.setToolTipText("Klicka för att välja från listan.");
        manouverColumn.setCellRenderer(renderer);
    }
     
    private void popTables(int index){ //Populates the tables with data define i templates in ScaleClasses.java
        TableModel model;
        
        switch(index){
            case 1: //F4C
                //Static
                model = new DefaultTableModel(ScaleClasses.F4C_Static_Sweden,ScaleClasses.Static_headers);
                jTable_Static.setModel(model);

                //Manouvers
                model = new DefaultTableModel(ScaleClasses.F4C_Manouvers_Sweden,ScaleClasses.Manouvers_headers);
                jTable_Manouvers.setModel(model);
               
                break;
                
            case 2: //F4H
                //Static
                model = new DefaultTableModel(ScaleClasses.F4H_Static_Sweden,ScaleClasses.Static_headers);
                jTable_Static.setModel(model);

                //Manouvers
                model = new DefaultTableModel(ScaleClasses.F4H_Manouvers_Sweden,ScaleClasses.Manouvers_headers);
                jTable_Manouvers.setModel(model);
                
                break;
                
            case 3: //Klubbskala
                //Static
                model = new DefaultTableModel();
                jTable_Static.setModel(model);
                
                model = new DefaultTableModel();
                jTable_Manouvers.setModel(model);
                
                break;
                
            case 4: //Fly Only
                //Static
                model = new DefaultTableModel();
                jTable_Static.setModel(model);
                
                model = new DefaultTableModel(ScaleClasses.FlyOnly_Manouvers_Sweden,ScaleClasses.Manouvers_headers);
                jTable_Manouvers.setModel(model);
                
                break;
        }
    }
    
      private void initDropDowns(){
        DefaultComboBoxModel CompClasses = new DefaultComboBoxModel(ScaleClasses.ListOfClasses);
        jComboBox_SetClass.removeAllItems();
        jComboBox_SetClass.setModel(CompClasses);
        
        DefaultComboBoxModel RuleType= new DefaultComboBoxModel(ScaleClasses.ListOfRuleType);
        jComboBox_RuleType.removeAllItems();
        jComboBox_RuleType.setModel(RuleType);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jTextField_CompName = new javax.swing.JTextField();
        jComboBox_SetClass = new javax.swing.JComboBox();
        jComboBox_RuleType = new javax.swing.JComboBox();
        jLabel_Name = new javax.swing.JLabel();
        jLabel_Class = new javax.swing.JLabel();
        jLabel_Type = new javax.swing.JLabel();
        jPanel_PointBoard = new javax.swing.JPanel();
        jPanel_Static = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Static = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Manouvers = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jSpinner3 = new javax.swing.JSpinner();
        jSpinner4 = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSpinner5 = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Ny regel...");
        setName("newRule"); // NOI18N
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        jComboBox_SetClass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_SetClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_SetClassActionPerformed(evt);
            }
        });

        jComboBox_RuleType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel_Name.setText("Namn:");

        jLabel_Class.setText("Klass:");

        jLabel_Type.setText("Typ:");

        jPanel_PointBoard.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Bedömning"));

        jPanel_Static.setBorder(javax.swing.BorderFactory.createTitledBorder("Statisk"));
        jPanel_Static.setPreferredSize(new java.awt.Dimension(285, 469));

        jTable_Static.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sektion", "Skalariktighet", "K"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_Static.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(jTable_Static);
        if (jTable_Static.getColumnModel().getColumnCount() > 0) {
            jTable_Static.getColumnModel().getColumn(0).setMinWidth(30);
            jTable_Static.getColumnModel().getColumn(0).setMaxWidth(58);
            jTable_Static.getColumnModel().getColumn(2).setMinWidth(35);
            jTable_Static.getColumnModel().getColumn(2).setMaxWidth(35);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Domare:"));

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(Byte.valueOf((byte)3), Byte.valueOf((byte)1), null, Byte.valueOf((byte)1)));
        jSpinner1.setToolTipText("Välj antal domare per panel.");

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(Byte.valueOf((byte)1), Byte.valueOf((byte)1), null, Byte.valueOf((byte)1)));
        jSpinner2.setToolTipText("Välj antal domarpaneler för regeln.");

        jLabel1.setText("Antal domare:");

        jLabel2.setText("Ant.paneler:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSpinner1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanel_StaticLayout = new javax.swing.GroupLayout(jPanel_Static);
        jPanel_Static.setLayout(jPanel_StaticLayout);
        jPanel_StaticLayout.setHorizontalGroup(
            jPanel_StaticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel_StaticLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel_StaticLayout.setVerticalGroup(
            jPanel_StaticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_StaticLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Flygprogram"));
        jPanel2.setPreferredSize(new java.awt.Dimension(285, 469));

        jTable_Manouvers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sektion", "Manöver", "K"
            }
        ));
        jTable_Manouvers.setMaximumSize(new java.awt.Dimension(2147483647, 300));
        jTable_Manouvers.setPreferredSize(new java.awt.Dimension(168, 300));
        jScrollPane2.setViewportView(jTable_Manouvers);
        if (jTable_Manouvers.getColumnModel().getColumnCount() > 0) {
            jTable_Manouvers.getColumnModel().getColumn(0).setMinWidth(30);
            jTable_Manouvers.getColumnModel().getColumn(0).setMaxWidth(58);
            jTable_Manouvers.getColumnModel().getColumn(2).setMinWidth(35);
            jTable_Manouvers.getColumnModel().getColumn(2).setMaxWidth(35);
        }

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Domare:"));

        jSpinner3.setModel(new javax.swing.SpinnerNumberModel(Byte.valueOf((byte)3), Byte.valueOf((byte)1), null, Byte.valueOf((byte)1)));
        jSpinner3.setToolTipText("Välj antal domare per panel.");

        jSpinner4.setModel(new javax.swing.SpinnerNumberModel(Byte.valueOf((byte)1), Byte.valueOf((byte)1), null, Byte.valueOf((byte)1)));
        jSpinner4.setToolTipText("Välj antal domarpaneler för regeln.");

        jLabel3.setText("Antal domare:");

        jLabel4.setText("Ant.paneler:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSpinner3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jSpinner5.setModel(new javax.swing.SpinnerNumberModel(Byte.valueOf((byte)3), Byte.valueOf((byte)1), null, Byte.valueOf((byte)1)));

        jLabel5.setText("Antal flygomgångar:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel_PointBoardLayout = new javax.swing.GroupLayout(jPanel_PointBoard);
        jPanel_PointBoard.setLayout(jPanel_PointBoardLayout);
        jPanel_PointBoardLayout.setHorizontalGroup(
            jPanel_PointBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_PointBoardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_Static, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel_PointBoardLayout.setVerticalGroup(
            jPanel_PointBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_PointBoardLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel_PointBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_Static, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_PointBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_Name)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextField_CompName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox_SetClass, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_Class))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Type)
                            .addComponent(jComboBox_RuleType, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Name)
                    .addComponent(jLabel_Class)
                    .addComponent(jLabel_Type))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_CompName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_SetClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_RuleType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_PointBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jComboBox_SetClass.getAccessibleContext().setAccessibleName("");

        getAccessibleContext().setAccessibleName("newRule");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_SetClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_SetClassActionPerformed
        
    //Executes when ScaleClases closes and action
        
        switch (jComboBox_SetClass.getSelectedIndex()) {
                
                case 1: //F4C
                    jTable_Static.setEnabled(true);
                    jTable_Static.setVisible(true);
                    popTables(jComboBox_SetClass.getSelectedIndex());
                    initManouversColumn(jTable_Manouvers.getColumnModel().getColumn(1)); //Create a dropdownlist in the column
                    break;
                
                case 2: //F4H
                    jTable_Static.setEnabled(true);
                    jTable_Static.setVisible(true);
                    popTables(jComboBox_SetClass.getSelectedIndex());
                    initManouversColumn(jTable_Manouvers.getColumnModel().getColumn(1)); //Create a dropdownlist in the column
                    break;
                    
                case 3: //Klubbskala
                    jTable_Static.setEnabled(true);
                    jTable_Static.setVisible(true);
                    popTables(jComboBox_SetClass.getSelectedIndex());
                    initManouversColumn(jTable_Manouvers.getColumnModel().getColumn(1)); //Create a dropdownlist in the column
                    break;
                    
                case 4:// Fly Only
                    jTable_Static.setEnabled(false);
                    jTable_Static.setVisible(false);
                    popTables(jComboBox_SetClass.getSelectedIndex());
                    initManouversColumn(jTable_Manouvers.getColumnModel().getColumn(1)); //Create a dropdownlist in the column
                    break;
        }
    }//GEN-LAST:event_jComboBox_SetClassActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox_RuleType;
    private javax.swing.JComboBox jComboBox_SetClass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_Class;
    private javax.swing.JLabel jLabel_Name;
    private javax.swing.JLabel jLabel_Type;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel_PointBoard;
    private javax.swing.JPanel jPanel_Static;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JTable jTable_Manouvers;
    private javax.swing.JTable jTable_Static;
    private javax.swing.JTextField jTextField_CompName;
    // End of variables declaration//GEN-END:variables
}

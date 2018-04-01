/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scalesweden;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableModel;
import static scalesweden.ScaleClasses.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author niclas
 */
public class NewRule extends javax.swing.JInternalFrame {

    /**
     * Creates new form NewRule
     */
    private DefaultTableModel fly_Model;
    private DefaultTableModel static_Model;

  //  long created_at; // Timestamp
    java.sql.Timestamp created_at;

    private char saveMode;

    public NewRule() {
        initComponents();
        initTables();    // Prepare the tables
        initDropDowns(); // Prepare the dropdowns in the title area
        saveMode = 'N';  // N for new
    }

    public NewRule(java.sql.Timestamp ts) {
        initComponents();
        saveMode = 'E'; // e for edit
        created_at = ts;  // set a "class global"
        initTables();    // Prepare the tables
        initManouversColumn(jTable_Manouvers.getColumnModel().getColumn(1)); //Create a dropdownlist in the column
        this.setTitle("Redigera regel...");
        jComboBox_SetClass.setEnabled(false);
        jComboBox_RuleType.setEnabled(false);
        popFromDB(); //Get data from DB and populate the frame

    }

    private void initTables() {
        fly_Model = new DefaultTableModel(ScaleClasses.Init_Empty_Table, ScaleClasses.Manouvers_headers);
        jTable_Manouvers.setModel(fly_Model);
        static_Model = new DefaultTableModel(ScaleClasses.Init_Empty_Table, ScaleClasses.Static_headers);
        jTable_Static.setModel(static_Model);

    }

    private void initManouversColumn(TableColumn manouverColumn) {
        //Set up the editor for the manouvers-column.
        JComboBox manouverComboBox = new JComboBox(ListOfManouvers);

        manouverColumn.setCellEditor(new DefaultCellEditor(manouverComboBox));

        //Set up tool tip for the manouver cells.
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setToolTipText("Klicka för att välja från listan.");
        manouverColumn.setCellRenderer(renderer);
    }

    private void popTables(int index) { //Populates the tables with data defined i templates in ScaleClasses.java

        switch (index) {
            case 0:
                initTables();
                break;

            case 1: //F4C
                //Static
                static_Model = new DefaultTableModel(ScaleClasses.F4C_Static_Sweden, ScaleClasses.Static_headers);
                jTable_Static.setModel(static_Model);

                //Manouvers
                fly_Model = new DefaultTableModel(ScaleClasses.F4C_Manouvers_Sweden, ScaleClasses.Manouvers_headers);
                jTable_Manouvers.setModel(fly_Model);

                break;

            case 2: //F4H
                //Static
                static_Model = new DefaultTableModel(ScaleClasses.F4H_Static_Sweden, ScaleClasses.Static_headers);
                jTable_Static.setModel(static_Model);

                //Manouvers
                fly_Model = new DefaultTableModel(ScaleClasses.F4H_Manouvers_Sweden, ScaleClasses.Manouvers_headers);
                jTable_Manouvers.setModel(fly_Model);

                break;

            case 3: //Klubbskala
                initTables();
                break;

            case 4: //Fly Only
                //Static
                static_Model = new DefaultTableModel();
                jTable_Static.setModel(static_Model);
                
                //Manouvers
                fly_Model = new DefaultTableModel(ScaleClasses.FlyOnly_Manouvers_Sweden, ScaleClasses.Manouvers_headers);
                jTable_Manouvers.setModel(fly_Model);

                break;
            
            case 5:
                static_Model = new DefaultTableModel(ScaleClasses.POP_Static_Sweden, ScaleClasses.Static_headers);
                jTable_Static.setModel(static_Model);
                
                //Manouvers
                fly_Model = new DefaultTableModel(ScaleClasses.POP_Manouvers_Sweden, ScaleClasses.Manouvers_headers);
                jTable_Manouvers.setModel(fly_Model);
                
                break;
                
            default:
                break;
        }
    }

    private void initDropDowns() {
        DefaultComboBoxModel CompClasses = new DefaultComboBoxModel(ScaleClasses.ListOfClasses);
        jComboBox_SetClass.removeAllItems();
        jComboBox_SetClass.setModel(CompClasses);

        DefaultComboBoxModel RuleType = new DefaultComboBoxModel(ScaleClasses.ListOfRuleType);
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

        jPopupMenu_Manouvers = new javax.swing.JPopupMenu();
        jMenuItem_ManAddRow = new javax.swing.JMenuItem();
        jMenuItem_ManInsertRow = new javax.swing.JMenuItem();
        jSeparator_Manouvers = new javax.swing.JPopupMenu.Separator();
        jMenuItem_ManRemoveRow = new javax.swing.JMenuItem();
        jPopupMenu_Static = new javax.swing.JPopupMenu();
        jMenuItem_StaticAddRow = new javax.swing.JMenuItem();
        jMenuItem_StaticInsertRow = new javax.swing.JMenuItem();
        jSeparator_Static = new javax.swing.JPopupMenu.Separator();
        jMenuItem_StaticRemoveRow = new javax.swing.JMenuItem();
        jTextField_RuleName = new javax.swing.JTextField();
        jComboBox_SetClass = new javax.swing.JComboBox();
        jComboBox_RuleType = new javax.swing.JComboBox();
        jLabel_Name = new javax.swing.JLabel();
        jLabel_Class = new javax.swing.JLabel();
        jLabel_Type = new javax.swing.JLabel();
        jPanel_PointBoard = new javax.swing.JPanel();
        jPanel_Static = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Static = new javax.swing.JTable();
        jPanelStatic_judges = new javax.swing.JPanel();
        jSpinner_Static_Judges = new javax.swing.JSpinner();
        jSpinner_Static_Panels = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel_Manouvers = new javax.swing.JPanel();
        jScrollPane_Manouvers = new javax.swing.JScrollPane();
        jTable_Manouvers = new javax.swing.JTable();
        jPanelManouvers_judges = new javax.swing.JPanel();
        jSpinner_Fly_Judges = new javax.swing.JSpinner();
        jSpinner_Fly_Panels = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSpinner_flights = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();

        jMenuItem_ManAddRow.setText("Lägg till en rad");
        jMenuItem_ManAddRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ManAddRowActionPerformed(evt);
            }
        });
        jPopupMenu_Manouvers.add(jMenuItem_ManAddRow);

        jMenuItem_ManInsertRow.setText("Infoga ny rad.");
        jMenuItem_ManInsertRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ManInsertRowActionPerformed(evt);
            }
        });
        jPopupMenu_Manouvers.add(jMenuItem_ManInsertRow);
        jPopupMenu_Manouvers.add(jSeparator_Manouvers);

        jMenuItem_ManRemoveRow.setText("Ta bort rad");
        jMenuItem_ManRemoveRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ManRemoveRowActionPerformed(evt);
            }
        });
        jPopupMenu_Manouvers.add(jMenuItem_ManRemoveRow);

        jMenuItem_StaticAddRow.setText("Lägg till en rad");
        jMenuItem_StaticAddRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_StaticAddRowActionPerformed(evt);
            }
        });
        jPopupMenu_Static.add(jMenuItem_StaticAddRow);

        jMenuItem_StaticInsertRow.setText("Infoga ny rad.");
        jMenuItem_StaticInsertRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_StaticInsertRowActionPerformed(evt);
            }
        });
        jPopupMenu_Static.add(jMenuItem_StaticInsertRow);
        jPopupMenu_Static.add(jSeparator_Static);

        jMenuItem_StaticRemoveRow.setText("Ta bort rad");
        jMenuItem_StaticRemoveRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_StaticRemoveRowActionPerformed(evt);
            }
        });
        jPopupMenu_Static.add(jMenuItem_StaticRemoveRow);

        setClosable(true);
        setTitle("Ny regel...");
        setName("newRule"); // NOI18N
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
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

        jComboBox_SetClass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_SetClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_SetClassActionPerformed(evt);
            }
        });

        jComboBox_RuleType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_RuleType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_RuleTypeActionPerformed(evt);
            }
        });

        jLabel_Name.setText("Namn:");

        jLabel_Class.setText("Klass:");

        jLabel_Type.setText("Typ:");

        jPanel_PointBoard.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Bedömning"));

        jPanel_Static.setBorder(javax.swing.BorderFactory.createTitledBorder("Statisk"));
        jPanel_Static.setPreferredSize(new java.awt.Dimension(285, 469));

        jTable_Static.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
        jTable_Static.setComponentPopupMenu(jPopupMenu_Static);
        jScrollPane1.setViewportView(jTable_Static);
        if (jTable_Static.getColumnModel().getColumnCount() > 0) {
            jTable_Static.getColumnModel().getColumn(0).setMinWidth(30);
            jTable_Static.getColumnModel().getColumn(0).setMaxWidth(58);
            jTable_Static.getColumnModel().getColumn(2).setMinWidth(35);
            jTable_Static.getColumnModel().getColumn(2).setMaxWidth(35);
        }

        jPanelStatic_judges.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Domare:"));

        jSpinner_Static_Judges.setModel(new javax.swing.SpinnerNumberModel(3, 1, 99, 1));
        jSpinner_Static_Judges.setToolTipText("Välj antal domare per panel.");

        jSpinner_Static_Panels.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));
        jSpinner_Static_Panels.setToolTipText("Välj antal domarpaneler för regeln.");

        jLabel1.setText("Antal domare:");

        jLabel2.setText("Ant.paneler:");

        javax.swing.GroupLayout jPanelStatic_judgesLayout = new javax.swing.GroupLayout(jPanelStatic_judges);
        jPanelStatic_judges.setLayout(jPanelStatic_judgesLayout);
        jPanelStatic_judgesLayout.setHorizontalGroup(
            jPanelStatic_judgesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStatic_judgesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelStatic_judgesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSpinner_Static_Judges))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                .addGroup(jPanelStatic_judgesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinner_Static_Panels, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );
        jPanelStatic_judgesLayout.setVerticalGroup(
            jPanelStatic_judgesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelStatic_judgesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelStatic_judgesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelStatic_judgesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner_Static_Judges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner_Static_Panels, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanel_StaticLayout = new javax.swing.GroupLayout(jPanel_Static);
        jPanel_Static.setLayout(jPanel_StaticLayout);
        jPanel_StaticLayout.setHorizontalGroup(
            jPanel_StaticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelStatic_judges, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jPanelStatic_judges, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jPanel_Manouvers.setBorder(javax.swing.BorderFactory.createTitledBorder("Flygprogram"));
        jPanel_Manouvers.setPreferredSize(new java.awt.Dimension(285, 469));

        jTable_Manouvers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Sektion", "Manöver", "K"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_Manouvers.setToolTipText("Högerklicka för menu.");
        jTable_Manouvers.setComponentPopupMenu(jPopupMenu_Manouvers);
        jTable_Manouvers.setMaximumSize(new java.awt.Dimension(2147483647, 300));
        jTable_Manouvers.setPreferredSize(new java.awt.Dimension(168, 300));
        jScrollPane_Manouvers.setViewportView(jTable_Manouvers);

        jPanelManouvers_judges.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Domare:"));

        jSpinner_Fly_Judges.setModel(new javax.swing.SpinnerNumberModel(3, 1, 99, 1));
        jSpinner_Fly_Judges.setToolTipText("Välj antal domare per panel.");

        jSpinner_Fly_Panels.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));
        jSpinner_Fly_Panels.setToolTipText("Välj antal domarpaneler för regeln.");

        jLabel3.setText("Antal domare:");

        jLabel4.setText("Ant.paneler:");

        javax.swing.GroupLayout jPanelManouvers_judgesLayout = new javax.swing.GroupLayout(jPanelManouvers_judges);
        jPanelManouvers_judges.setLayout(jPanelManouvers_judgesLayout);
        jPanelManouvers_judgesLayout.setHorizontalGroup(
            jPanelManouvers_judgesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelManouvers_judgesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelManouvers_judgesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSpinner_Fly_Judges))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelManouvers_judgesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinner_Fly_Panels, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );
        jPanelManouvers_judgesLayout.setVerticalGroup(
            jPanelManouvers_judgesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelManouvers_judgesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelManouvers_judgesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanelManouvers_judgesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner_Fly_Judges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner_Fly_Panels, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jSpinner_flights.setModel(new javax.swing.SpinnerNumberModel(3, 1, 99, 1));

        jLabel5.setText("Antal flygomgångar:");

        javax.swing.GroupLayout jPanel_ManouversLayout = new javax.swing.GroupLayout(jPanel_Manouvers);
        jPanel_Manouvers.setLayout(jPanel_ManouversLayout);
        jPanel_ManouversLayout.setHorizontalGroup(
            jPanel_ManouversLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane_Manouvers, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
            .addComponent(jPanelManouvers_judges, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_ManouversLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSpinner_flights, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel_ManouversLayout.setVerticalGroup(
            jPanel_ManouversLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_ManouversLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jScrollPane_Manouvers, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_ManouversLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner_flights, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelManouvers_judges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel_PointBoardLayout = new javax.swing.GroupLayout(jPanel_PointBoard);
        jPanel_PointBoard.setLayout(jPanel_PointBoardLayout);
        jPanel_PointBoardLayout.setHorizontalGroup(
            jPanel_PointBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_PointBoardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_Static, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel_Manouvers, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel_PointBoardLayout.setVerticalGroup(
            jPanel_PointBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_PointBoardLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel_PointBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_Manouvers, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(jTextField_RuleName))
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
                    .addComponent(jTextField_RuleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    /* ******************************************************************************
     * popupmenu Manouver table
     ****************************************************************************** */
    private void jMenuItem_ManAddRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ManAddRowActionPerformed
        //Add a new empty row in the manouver-table
        fly_Model.addRow(ScaleClasses.Empty_Row_Data);
    }//GEN-LAST:event_jMenuItem_ManAddRowActionPerformed

    private void jMenuItem_ManRemoveRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ManRemoveRowActionPerformed
        // Remove the selected row in the Manouvers table
        fly_Model.removeRow(jTable_Manouvers.getSelectedRow());
    }//GEN-LAST:event_jMenuItem_ManRemoveRowActionPerformed

    private void jMenuItem_ManInsertRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ManInsertRowActionPerformed
        // Insert a row at the selected item in the Manouvers table
        fly_Model.insertRow(jTable_Manouvers.getSelectedRow(), Empty_Row_Data);
    }//GEN-LAST:event_jMenuItem_ManInsertRowActionPerformed

    /* ******************************************************************************
     * popupmenu Static table
     ****************************************************************************** */
    private void jMenuItem_StaticAddRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_StaticAddRowActionPerformed
        static_Model.addRow(ScaleClasses.Empty_Row_Data);
    }//GEN-LAST:event_jMenuItem_StaticAddRowActionPerformed

    private void jMenuItem_StaticInsertRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_StaticInsertRowActionPerformed
        static_Model.insertRow(jTable_Static.getSelectedRow(), Empty_Row_Data);
    }//GEN-LAST:event_jMenuItem_StaticInsertRowActionPerformed

    private void jMenuItem_StaticRemoveRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_StaticRemoveRowActionPerformed
        static_Model.removeRow(jTable_Static.getSelectedRow());
    }//GEN-LAST:event_jMenuItem_StaticRemoveRowActionPerformed

    private void checkToSave() {
        if ((!jTextField_RuleName.getText().isEmpty()) && (jComboBox_SetClass.getSelectedIndex() > 0) && (jComboBox_RuleType.getSelectedIndex() > 0)) {
            //Save the data
            saveToDB();
        }
    }

    private void popFromDB() {
        //Prepare the database
        Connection connection = null;
        try {
            // create a database connection
            
            Properties connectionProps = new Properties();
            connectionProps.put("user", "root");
            connectionProps.put("password", "Pascal");
        
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/F4", connectionProps);
            
            String sql = "select * from RULES where CREATED_AT = ?";//+created_at;
            //Statement preparedStatement = connection.createStatement();
            //preparedStatement.setQueryTimeout(15);
            
           // preparedStatement.(1, created_at);
           // ResultSet rs = preparedStatement.executeQuery(sql);
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int P = preparedStatement.getParameterMetaData().getParameterCount();
           
            preparedStatement.setQueryTimeout(15);
            preparedStatement.setTimestamp(1, created_at);
            
            
            boolean result = preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();
            int T = rs.getFetchSize();
            jTextField_RuleName.setText(rs.getString("name"));
            jComboBox_SetClass.getModel().setSelectedItem(rs.getString("mainclass"));
            jComboBox_RuleType.getModel().setSelectedItem(rs.getString("type"));
            jSpinner_Static_Panels.getModel().setValue(rs.getShort("staticpanels"));
            jSpinner_Static_Judges.getModel().setValue(rs.getInt("staticjudges"));
            jSpinner_Fly_Panels.getModel().setValue(rs.getInt("flypanels"));
            jSpinner_Fly_Judges.getModel().setValue(rs.getInt("flyjudges"));
            jSpinner_flights.getModel().setValue(rs.getInt("flights"));

            if (rs.getString("readwrite").equals("false")) { //Not an editable rule
                this.setTitle("Visar ej redigerbar regel");
                jTextField_RuleName.setEnabled(false);
                jTable_Static.setEnabled(false);
                jTable_Manouvers.setEnabled(false);
                jPanel_PointBoard.setEnabled(false);
                jPanelStatic_judges.setEnabled(false);
                jPanelManouvers_judges.setEnabled(false);
                jSpinner_Fly_Judges.setEnabled(false);
                jSpinner_Fly_Panels.setEnabled(false);
                jSpinner_Static_Judges.setEnabled(false);
                jSpinner_Static_Panels.setEnabled(false);
                jSpinner_flights.setEnabled(false);
                jComboBox_SetClass.setEnabled(false);
                jComboBox_RuleType.setEnabled(false);
                saveMode = 'X';
            }
/*
            static_Model.removeRow(0); // Tidy up the rows
            rs = statement.executeQuery("select * from rules_static where created_at = " + created_at);

            while (rs.next()) {
                Object[] row = new Object[rs.getMetaData().getColumnCount()];
                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                    row[i] = rs.getObject(i + 1);
                }
                static_Model.addRow(row);
            }

            fly_Model.removeRow(0); // Tidy up the rows
            rs = statement.executeQuery("select * from rules_manouvers where created_at = " + created_at);

            while (rs.next()) {
                Object[] row = new Object[rs.getMetaData().getColumnCount()];
                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                    row[i] = rs.getObject(i + 1);
                }
                fly_Model.addRow(row);
            }
*/
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

    private void saveToDB() {

        //Prepare the database
        Connection connection = null;
        try {
            // create a database connection
            //connection = DriverManager.getConnection("jdbc:sqlite:db/scale.db");
            Properties connectionProps = new Properties();
            connectionProps.put("user", "root");
            connectionProps.put("password", "Pascal");
        
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/F4", connectionProps);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(15);

            if (saveMode == 'E') {
                // Update the rules-table in the DB
                int rs = statement.executeUpdate("UPDATE rules SET "
                        + "name='" + jTextField_RuleName.getText() + "', "
                        + "mainclass='" + jComboBox_SetClass.getSelectedItem().toString() + "', "
                        + "type='" + jComboBox_RuleType.getSelectedItem().toString() + "', "
                        + "staticpanels='" + jSpinner_Static_Panels.getModel().getValue() + "', "
                        + "staticjudges='" + jSpinner_Static_Judges.getModel().getValue() + "', "
                        + "flypanels='" + jSpinner_Fly_Panels.getModel().getValue() + "', "
                        + "flyjudges='" + jSpinner_Fly_Judges.getModel().getValue() + "', "
                        + "flights='" + jSpinner_flights.getModel().getValue() + "' "
                        + "WHERE created_at='" + created_at + "'");

                // Update the rules_static-table in the DB
                rs = statement.executeUpdate("DELETE FROM rules_static where created_at = '" + created_at + "'");

                for (int i = 0; i < static_Model.getRowCount(); i++) {
                    rs = statement.executeUpdate("INSERT INTO rules_static(created_at, k, description, section)"
                            + "VALUES ('" + created_at + "', '" + static_Model.getValueAt(i, 2) + "', '"
                            + static_Model.getValueAt(i, 1) + "', '"
                            + static_Model.getValueAt(i, 0) + "')");
                }

                // Update the rules_manouvers-table in the DB
                rs = statement.executeUpdate("DELETE FROM rules_manouvers where created_at = '" + created_at + "'");

                for (int i = 0; i < fly_Model.getRowCount(); i++) {
                    rs = statement.executeUpdate("INSERT INTO rules_manouvers(created_at, k, description, section)"
                            + "VALUES ('" + created_at + "', '" + fly_Model.getValueAt(i, 2) + "', '"
                            + fly_Model.getValueAt(i, 1) + "', '"
                            + fly_Model.getValueAt(i, 0) + "')");
                }

            } else if (saveMode == 'N') {
                
                //Create timestamp
                Calendar calendar = Calendar.getInstance();
                created_at = new java.sql.Timestamp(calendar.getTime().getTime());
                
                // Update the rules-table in the DB              
                String sql = "INSERT INTO rules (name, mainclass, type, created_at, staticpanels, staticjudges, flypanels, flyjudges, flights) VALUES (?,?,?,?,?,?,?,?,?)";
                int rs;
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, jTextField_RuleName.getText());
                    preparedStatement.setString(2, jComboBox_SetClass.getSelectedItem().toString());
                    preparedStatement.setString(3, jComboBox_RuleType.getSelectedItem().toString());
                    preparedStatement.setTimestamp(4, created_at);
                    preparedStatement.setInt(5,(int)jSpinner_Static_Panels.getModel().getValue());
                    preparedStatement.setInt(6,(int)jSpinner_Static_Judges.getModel().getValue());
                    preparedStatement.setInt(7,(int)jSpinner_Fly_Panels.getModel().getValue());
                    preparedStatement.setInt(8,(int)jSpinner_Fly_Judges.getModel().getValue());
                    preparedStatement.setInt(9,(int)jSpinner_flights.getModel().getValue());
                    rs = preparedStatement.executeUpdate();
                    System.out.println(rs);
                    try {
                        preparedStatement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(NewRule.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                // Insert the rules_static-table in the DB
                sql = "INSERT INTO rules_static(created_at, k, description, section) VALUES (?,?,?,?)";
                for (int i = 0; i < static_Model.getRowCount(); i++) {
                    
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        preparedStatement.setString(4, static_Model.getValueAt(i, 0).toString()); //Sektion
                        preparedStatement.setString(3, static_Model.getValueAt(i, 1).toString()); //Beskrivning
                       
                        if(!static_Model.getValueAt(i, 2).toString().isEmpty()){                  //if field not empty
                        preparedStatement.setInt(2, Integer.parseUnsignedInt(static_Model.getValueAt(i, 2).toString())); //K-faktor
                        } else {
                                preparedStatement.setInt(2,0); //set the K to zero if the field is empty
                        }
                        
                        preparedStatement.setTimestamp(1, created_at);
                                              
                        rs = preparedStatement.executeUpdate();
                        System.out.println(rs);
                        try {
                            preparedStatement.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(NewRule.class.getName()).log(Level.SEVERE, null, ex);
                        }  
                    }
                }

                // Update the rules_manouvers-table in the DB
                sql = "INSERT INTO rules_manouvers(created_at, k, description, section) VALUES (?,?,?,?)";
                for (int i = 0; i < fly_Model.getRowCount(); i++) {
                   /* rs = statement.executeUpdate("INSERT INTO rules_manouvers(created_at, k, description, section)"
                            + "VALUES ('" + created_at + "', '" + fly_Model.getValueAt(i, 2) + "', '"
                            + fly_Model.getValueAt(i, 1) + "', '"
                            + fly_Model.getValueAt(i, 0) + "')");
                */
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        preparedStatement.setString(4, fly_Model.getValueAt(i, 0).toString()); //Sektion
                        preparedStatement.setString(3, fly_Model.getValueAt(i, 1).toString()); //Beskrivning
                       
                        if(!fly_Model.getValueAt(i, 2).toString().isEmpty()){                  //if field not empty
                        preparedStatement.setInt(2, Integer.parseUnsignedInt(fly_Model.getValueAt(i, 2).toString())); //K-faktor
                        } else {
                                preparedStatement.setInt(2,0); //set the K to zero if the field is empty
                        }
                        
                        preparedStatement.setTimestamp(1, created_at);
                                               
                        rs = preparedStatement.executeUpdate();
                        System.out.println(rs);
                        try {
                            preparedStatement.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(NewRule.class.getName()).log(Level.SEVERE, null, ex);
                        }  
                    }
                }
                
                saveMode = 'E';
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

    private void jComboBox_SetClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_SetClassActionPerformed

        if (saveMode == 'N') { //Only if new rule

//Executes when ScaleClases closes and action
            switch (jComboBox_SetClass.getSelectedIndex()) {

                case 0:
                    popTables(jComboBox_SetClass.getSelectedIndex()); //Clear the contents of the tables.
                    checkToSave();
                    break;

                case 1: //F4C
                    jTable_Static.setEnabled(true);
                    jTable_Static.setVisible(true);
                    popTables(jComboBox_SetClass.getSelectedIndex());
                    initManouversColumn(jTable_Manouvers.getColumnModel().getColumn(1)); //Create a dropdownlist in the column
                    checkToSave();
                    break;

                case 2: //F4H
                    jTable_Static.setEnabled(true);
                    jTable_Static.setVisible(true);
                    popTables(jComboBox_SetClass.getSelectedIndex());
                    initManouversColumn(jTable_Manouvers.getColumnModel().getColumn(1)); //Create a dropdownlist in the column
                    checkToSave();
                    break;

                case 3: //Klubbskala
                    jTable_Static.setEnabled(true);
                    jTable_Static.setVisible(true);
                    popTables(jComboBox_SetClass.getSelectedIndex());
                    initManouversColumn(jTable_Manouvers.getColumnModel().getColumn(1)); //Create a dropdownlist in the column
                    checkToSave();
                    break;

                case 4:// Fly Only
                    jSpinner_Static_Panels.getModel().setValue(0);
                    jSpinner_Static_Judges.getModel().setValue(0);
                    jTable_Static.setEnabled(false);
                    jTable_Static.setVisible(false);
                    popTables(jComboBox_SetClass.getSelectedIndex());
                    initManouversColumn(jTable_Manouvers.getColumnModel().getColumn(1)); //Create a dropdownlist in the column
                    checkToSave();
                    break;
            }
        }
    }//GEN-LAST:event_jComboBox_SetClassActionPerformed

    private void jComboBox_RuleTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_RuleTypeActionPerformed

       // checkToSave();
    }//GEN-LAST:event_jComboBox_RuleTypeActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        if(saveMode == 'E'){
            saveToDB();
        }
        else if(saveMode == 'N') {
            checkToSave();
        }
    }//GEN-LAST:event_formInternalFrameClosing

    
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
    private javax.swing.JMenuItem jMenuItem_ManAddRow;
    private javax.swing.JMenuItem jMenuItem_ManInsertRow;
    private javax.swing.JMenuItem jMenuItem_ManRemoveRow;
    private javax.swing.JMenuItem jMenuItem_StaticAddRow;
    private javax.swing.JMenuItem jMenuItem_StaticInsertRow;
    private javax.swing.JMenuItem jMenuItem_StaticRemoveRow;
    private javax.swing.JPanel jPanelManouvers_judges;
    private javax.swing.JPanel jPanelStatic_judges;
    private javax.swing.JPanel jPanel_Manouvers;
    private javax.swing.JPanel jPanel_PointBoard;
    private javax.swing.JPanel jPanel_Static;
    private javax.swing.JPopupMenu jPopupMenu_Manouvers;
    private javax.swing.JPopupMenu jPopupMenu_Static;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane_Manouvers;
    private javax.swing.JPopupMenu.Separator jSeparator_Manouvers;
    private javax.swing.JPopupMenu.Separator jSeparator_Static;
    private javax.swing.JSpinner jSpinner_Fly_Judges;
    private javax.swing.JSpinner jSpinner_Fly_Panels;
    private javax.swing.JSpinner jSpinner_Static_Judges;
    private javax.swing.JSpinner jSpinner_Static_Panels;
    private javax.swing.JSpinner jSpinner_flights;
    private javax.swing.JTable jTable_Manouvers;
    private javax.swing.JTable jTable_Static;
    private javax.swing.JTextField jTextField_RuleName;
    // End of variables declaration//GEN-END:variables
}

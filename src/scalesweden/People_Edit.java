/*
 * Copyright (C) 2014 Niclas
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

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import static scalesweden.ScaleClasses.ListOfClasses;

/**
 *
 * @author Niclas Olsson, Cobton AB
 */
public class People_Edit extends javax.swing.JInternalFrame {

    /**
     * Creates new form Pilots_Edit
     */
    Object[] columnNames = {java.util.ResourceBundle.getBundle("scalesweden/Languages").getString("MODELL:"), java.util.ResourceBundle.getBundle("scalesweden/Languages").getString("KLASS:"), java.util.ResourceBundle.getBundle("scalesweden/Languages").getString("AEROBATIC:"), java.util.ResourceBundle.getBundle("scalesweden/Languages").getString("SKALA:"), java.util.ResourceBundle.getBundle("scalesweden/Languages").getString("FLERMOTORIGT:")};
    char SaveMode; //SaveMode='N' for a new record. SaveMode='E' for edit record
    String nationnbr;

    public People_Edit() { //Add new pilot
        initComponents();
        jTable_Planes.setEnabled(false);
        SaveMode = 'N';
        initClassesColumn(jTable_Planes.getColumnModel().getColumn(1)); //Create a dropdownlist in the column
    }

    public People_Edit(String prefix, String nbr) { //Edit a pilot
        initComponents();
        jTable_Planes.setEnabled(false);
        SaveMode = 'E';
        // initClassesColumn(jTable_Planes.getColumnModel().getColumn(1)); //Create a dropdownlist in the column
        populatePeople(prefix, nbr);
        nationnbr=nbr;

    }

    public People_Edit(String prefix, String nbr, boolean Copy) { //Copy a pilot to a new one
        initComponents();
        jTable_Planes.setEnabled(false);
        SaveMode = 'N';
        // initClassesColumn(jTable_Planes.getColumnModel().getColumn(1)); //Create a dropdownlist in the column
        populatePeople(prefix, nbr);
        if (Copy) {
            jTextField_nationalnbr.setText("");
        }
    }

    private void populatePeople(String prefix, String nbr) {

        //Prepare the database
        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:db/scale.db");
            PreparedStatement ps = connection.prepareStatement("select * from people where prefix = ? and nationalnbr = ?");
            ps.setString(1, prefix);
            ps.setString(2, nbr);
            ps.setQueryTimeout(5);

            ResultSet rs = ps.executeQuery();

            jTextField_prefix.setText(rs.getString("prefix"));
            jTextField_cellphone.setText(rs.getString("cellphone"));
            jTextField_clubname.setText(rs.getString("clubname"));
            jTextField_clubnbr.setText(rs.getString("clubnr"));
            jTextField_lastname.setText(rs.getString("lastname"));
            jTextField_name.setText(rs.getString("name"));
            jTextField_nationalnbr.setText(rs.getString("nationalnbr"));
            jTextField_phonenbr.setText(rs.getString("phonenbr"));
            jTextField_postadress.setText(rs.getString("postadress"));
            jTextField_streetadress.setText(rs.getString("streetadress"));
            jTextField_town.setText(rs.getString("town"));
            jTextField_zipcode.setText(rs.getString("zipcode"));

            if (rs.getString("judge").matches("true")) { //Workaround caused by the sqlite3 jdbc-driver: getBoolean should be used...
                jCheckBox_Judge.setSelected(rs.getString("judge").matches("true"));
                jToggleButton_F4C.setEnabled(true);
                jToggleButton_F4C.setSelected(rs.getString("F4C").matches("true"));
                jToggleButton_F4H.setEnabled(true);
                jToggleButton_F4H.setSelected(rs.getString("F4H").matches("true"));
                jToggleButton_FlyOnly.setEnabled(true);
                jToggleButton_FlyOnly.setSelected(rs.getString("FlyOnly").matches("true"));
            }
            jCheckBox_Pilot.setSelected(rs.getString("pilot").matches("true"));

            if (rs.getString("pilot").matches("true")) {
                jTable_Planes.setEnabled(true);
            }

            ps.clearBatch();
            ps = connection.prepareStatement("select * from people_aeroplanes where prefix = ? and nationalnbr = ?");
            ps.setString(1, prefix);
            ps.setString(2, nbr);
            rs = ps.executeQuery();

            DefaultTableModel peopleAeroplanes_Model = (DefaultTableModel) jTable_Planes.getModel();
            jTable_Planes.setModel(peopleAeroplanes_Model);
            peopleAeroplanes_Model.setRowCount(0);                                  //Clear the contents of the table
            initClassesColumn(jTable_Planes.getColumnModel().getColumn(1));         //Create a dropdownlist in the column

            while (rs.next()) {
                // read the result set and pop into the table

                Object[] row = new Object[rs.getMetaData().getColumnCount()];
                for (int i = 2; i < rs.getMetaData().getColumnCount(); i++) {
                    if (i == 4 || i == 6) {  //Tick CheckBox
                        if (rs.getString(i + 1).matches("true")) {
                            row[i-2] = true;
                        } else {
                            row[i-2] = false;
                        }
                    } else { //Just text

                        row[i-2] = rs.getObject(i + 1);
                    }
                }
                peopleAeroplanes_Model.addRow(row);
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

    private void initClassesColumn(TableColumn classesColumn) {
        //Set up the editor for the classes-column.
        JComboBox classesComboBox = new JComboBox(ListOfClasses);

        classesColumn.setCellEditor(new DefaultCellEditor(classesComboBox));

        //Set up tool tip for the class cells.
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setToolTipText(java.util.ResourceBundle.getBundle("scalesweden/Languages").getString("KLICKA FÖR ATT VÄLJA FRÅN LISTAN."));
        classesColumn.setCellRenderer(renderer);
        classesColumn.setModelIndex(1);

    }

   /* private void initClassesColumnTickBox(TableColumn classesColumn) {
        //Set up the editor for the classes-column.

        JCheckBox classesCheckBox = new JCheckBox("", true);
        classesColumn.setCellEditor(new DefaultCellEditor(classesCheckBox));

        //Set up tool tip for the class cells.
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setToolTipText("Klicka för att aktivera.");
        renderer.setVisible(true);
        classesColumn.setCellRenderer(renderer);
        classesColumn.setModelIndex(classesColumn.getModelIndex());

    }
*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField_nationalnbr = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField_prefix = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField_lastname = new javax.swing.JTextField();
        jTextField_clubname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_clubnbr = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField_postadress = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField_streetadress = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField_zipcode = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField_town = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField_phonenbr = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField_cellphone = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jToggleButton_F4C = new javax.swing.JToggleButton();
        jToggleButton_F4H = new javax.swing.JToggleButton();
        jToggleButton_FlyOnly = new javax.swing.JToggleButton();
        jCheckBox_Judge = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jCheckBox_Pilot = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Planes = new javax.swing.JTable();
        jButton_save = new javax.swing.JButton();
        jButton_close = new javax.swing.JButton();

        setClosable(true);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("scalesweden/Languages"); // NOI18N
        setTitle(bundle.getString("AKTIVA - REDIGERA/VISA")); // NOI18N
        setToolTipText("");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("peopleEdit"); // NOI18N

        jLabel1.setText(bundle.getString("SMFF-NR:")); // NOI18N
        jLabel1.setToolTipText("");

        jLabel2.setText("Prefix:");
        jLabel2.setToolTipText("");

        jTextField_prefix.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_prefix.setText("SWE");
        jTextField_prefix.setToolTipText("This is the prefix for the Nationalnumber e.g: SWE for Sweden.");

        jLabel3.setText(bundle.getString("FÖRNAMN:")); // NOI18N
        jLabel3.setToolTipText("");

        jLabel4.setText(bundle.getString("EFTERNAMN:")); // NOI18N
        jLabel4.setToolTipText("");

        jLabel5.setText(bundle.getString("KLUBB:")); // NOI18N
        jLabel5.setToolTipText("");

        jLabel6.setText(bundle.getString("KLUBBNR:")); // NOI18N
        jLabel6.setToolTipText("");

        jLabel7.setText(bundle.getString("POSTADRESS:")); // NOI18N
        jLabel7.setToolTipText("");

        jLabel8.setText(bundle.getString("GATUDADRESS:")); // NOI18N
        jLabel8.setToolTipText("");

        jLabel9.setText(bundle.getString("POSTNR:")); // NOI18N
        jLabel9.setToolTipText("");

        jLabel10.setText(bundle.getString("POSTORT:")); // NOI18N
        jLabel10.setToolTipText("");

        jLabel11.setText(bundle.getString("HEMNR:")); // NOI18N
        jLabel11.setToolTipText("");

        jLabel12.setText(bundle.getString("MOBILNR:")); // NOI18N
        jLabel12.setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jToggleButton_F4C.setText("F4C");
        jToggleButton_F4C.setEnabled(false);

        jToggleButton_F4H.setText("F4H");
        jToggleButton_F4H.setEnabled(false);

        jToggleButton_FlyOnly.setText("FlyOnly");
        jToggleButton_FlyOnly.setEnabled(false);

        jCheckBox_Judge.setText(bundle.getString("DOMARE")); // NOI18N
        jCheckBox_Judge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_JudgeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox_Judge)
                .addGap(5, 5, 5)
                .addComponent(jToggleButton_F4C)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton_F4H)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton_FlyOnly)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton_F4C)
                    .addComponent(jToggleButton_F4H)
                    .addComponent(jToggleButton_FlyOnly)
                    .addComponent(jCheckBox_Judge))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jCheckBox_Pilot.setText("Pilot");
        jCheckBox_Pilot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_PilotActionPerformed(evt);
            }
        });

        jTable_Planes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Modell:", "Klass:", "Aerobatic:", "Skala:", "Flermotorigt:"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_Planes.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable_Planes);
        jTable_Planes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jCheckBox_Pilot)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox_Pilot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton_save.setText(bundle.getString("SPARA")); // NOI18N
        jButton_save.setToolTipText(bundle.getString("KLICKA HÄR FÖR ATT SPARA PERSONEN.")); // NOI18N
        jButton_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_saveActionPerformed(evt);
            }
        });

        jButton_close.setText(bundle.getString("STÄNG")); // NOI18N
        jButton_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_closeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel9))
                            .addComponent(jTextField_zipcode, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextField_town)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jTextField_postadress, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextField_streetadress)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton_save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_close))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel11))
                                    .addComponent(jTextField_phonenbr, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel12))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField_cellphone, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(2, 2, 2)
                                            .addComponent(jLabel2))
                                        .addComponent(jTextField_prefix, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextField_nationalnbr, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jTextField_clubname))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(2, 2, 2)
                                            .addComponent(jLabel6))
                                        .addComponent(jTextField_clubnbr, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(177, 209, Short.MAX_VALUE))
                                        .addComponent(jTextField_lastname)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_clubname))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_nationalnbr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_prefix)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_clubnbr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_postadress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_streetadress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_zipcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_town, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_phonenbr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_cellphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_save)
                    .addComponent(jButton_close))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox_JudgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_JudgeActionPerformed
        // TODO add your handling code here:
        if (jCheckBox_Judge.isSelected()) {
            jToggleButton_F4C.setEnabled(true);
            jToggleButton_F4H.setEnabled(true);
            jToggleButton_FlyOnly.setEnabled(true);
        } else {
            jToggleButton_F4C.setEnabled(false);
            jToggleButton_F4H.setEnabled(false);
            jToggleButton_FlyOnly.setEnabled(false);
        }

    }//GEN-LAST:event_jCheckBox_JudgeActionPerformed

    private void jButton_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_closeActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButton_closeActionPerformed

    private void jCheckBox_PilotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_PilotActionPerformed

        if (jCheckBox_Pilot.isSelected()) {
            jTable_Planes.setEnabled(true);
        } else {
            jTable_Planes.setEnabled(false);
        }

    }//GEN-LAST:event_jCheckBox_PilotActionPerformed

    private void jButton_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_saveActionPerformed

        if (jTextField_nationalnbr.getText().equals("")) {
            jTextField_nationalnbr.setBackground(Color.red);
            JOptionPane.showMessageDialog(this, "Du måste ange personens medlemsnummer i den tävlandes nations riksorganisation!", "SWE-?????", JOptionPane.ERROR_MESSAGE);
        } else {
            saveToDB();
            jTextField_nationalnbr.setBackground(Color.white);
        }
    }//GEN-LAST:event_jButton_saveActionPerformed

    private void saveToDB() {
        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:db/scale.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(15);  // set timeout to 15 sec.

            int rs;

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
            if (SaveMode == 'E') { //Edit the Active Person
                /* Why just not update the record? Well, cause there might be typo when entering the Nationalnbr */

                rs = statement.executeUpdate("delete from people where prefix='SWE' and nationalnbr='" + nationnbr + "';");
                System.out.println("PE#1 Antal poster raderade: " + rs);
                rs = statement.executeUpdate("INSERT INTO people (nationalnbr, prefix, clubname, clubnr, name, lastname, postadress, streetadress, zipcode, town, phonenbr, cellphone, judge, F4C, F4H, FlyOnly, pilot) "
                        + "VALUES ('" + jTextField_nationalnbr.getText() + "', '" + jTextField_prefix.getText() + "', '"
                        + jTextField_clubname.getText() + "', '" + jTextField_clubnbr.getText() + "', '"
                        + jTextField_name.getText() + "', '" + jTextField_lastname.getText() + "', '"
                        + jTextField_postadress.getText() + "', '" + jTextField_streetadress.getText() + "', '"
                        + jTextField_zipcode.getText() + "', '" + jTextField_town.getText() + "', '"
                        + jTextField_phonenbr.getText() + "', '" + jTextField_cellphone.getText() + "', '"
                        + jCheckBox_Judge.isSelected() + "', '" + jToggleButton_F4C.isSelected() + "', '"
                        + jToggleButton_F4H.isSelected() + "', '" + jToggleButton_FlyOnly.isSelected() + "', '" + jCheckBox_Pilot.isSelected() + "');");
                if (rs > 0) {
                    rs = statement.executeUpdate("delete from people_aeroplanes where prefix='SWE' and nationalnbr='" + nationnbr + "';");

                    for (int i = 0; i < jTable_Planes.getRowCount(); i++) {
                        rs = statement.executeUpdate("INSERT INTO people_aeroplanes (nationalnbr,prefix, model, class, aerobatic, scale, multipleEngines)"
                                + "VALUES ('" + jTextField_nationalnbr.getText() + "', '" + jTextField_prefix.getText() + "', '"
                                + jTable_Planes.getValueAt(i, 0) + "', '"
                                + jTable_Planes.getValueAt(i, 1) + "', '"
                                + jTable_Planes.getValueAt(i, 2) + "', '"
                                + jTable_Planes.getValueAt(i, 3) + "', '"
                                + jTable_Planes.getValueAt(i, 4) + "');");
                        /*  if (rs > 0) {
                         System.err.println("New Active Person added");
                         }*/
                    }
                    //SaveMode = 'E'; // Change to edit mode
                    //jTextField_nationalnbr.setEnabled(false);
                    nationnbr = jTextField_nationalnbr.getText(); //Update for local use
                }

            } else if (SaveMode == 'N') { //Add new Active Person
                rs = statement.executeUpdate("INSERT INTO people (nationalnbr, prefix, clubname, clubnr, name, lastname, postadress, streetadress, zipcode, town, phonenbr, cellphone, judge, F4C, F4H, FlyOnly, pilot) "
                        + "VALUES ('" + jTextField_nationalnbr.getText() + "', '" + jTextField_prefix.getText() + "', '"
                        + jTextField_clubname.getText() + "', '" + jTextField_clubnbr.getText() + "', '"
                        + jTextField_name.getText() + "', '" + jTextField_lastname.getText() + "', '"
                        + jTextField_postadress.getText() + "', '" + jTextField_streetadress.getText() + "', '"
                        + jTextField_zipcode.getText() + "', '" + jTextField_town.getText() + "', '"
                        + jTextField_phonenbr.getText() + "', '" + jTextField_cellphone.getText() + "', '"
                        + jCheckBox_Judge.isSelected() + "', '" + jToggleButton_F4C.isSelected() + "', '"
                        + jToggleButton_F4H.isSelected() + "', '" + jToggleButton_FlyOnly.isSelected() + "', '" + jCheckBox_Pilot.isSelected() + "');");
                if (rs > 0) {

                    for (int i = 0; i < jTable_Planes.getRowCount(); i++) {
                        rs = statement.executeUpdate("INSERT INTO people_aeroplanes (nationalnbr,prefix, model, class, aerobatic, scale, multipleEngines)"
                                + "VALUES ('" + jTextField_nationalnbr.getText() + "', '" + jTextField_prefix.getText() + "', '"
                                + jTable_Planes.getValueAt(i, 0) + "', '"
                                + jTable_Planes.getValueAt(i, 1) + "', '"
                                + jTable_Planes.getValueAt(i, 2) + "', '"
                                + jTable_Planes.getValueAt(i, 3) + "', '"
                                + jTable_Planes.getValueAt(i, 4) + "');");
                        /*    if (rs > 0) {
                         System.err.println("New Active Person added");
                         }*/
                    }
                    SaveMode = 'E'; // Change to edit mode
                    //jTextField_nationalnbr.setEnabled(false);       
                    nationnbr = jTextField_nationalnbr.getText(); //Update for local use
                }

            } else { // Not a valid mode
                System.err.println("PE#2 Unknown mode when saving Active Person. Mode:" + SaveMode);
            }
        } catch (SQLException e) {
            // if the error message is "out of memory", 
            // it probably means no database file is found
            System.err.println(e.getMessage() + ": " + e.getErrorCode() + ":" + e.getSQLState());
        } finally {
            try {
                if (connection != null) {

                    //setSavedInidicatorOn();  //Inform the user that data has been saved
                    //setAlertOffButton();
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_close;
    private javax.swing.JButton jButton_save;
    private javax.swing.JCheckBox jCheckBox_Judge;
    private javax.swing.JCheckBox jCheckBox_Pilot;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Planes;
    private javax.swing.JTextField jTextField_cellphone;
    private javax.swing.JTextField jTextField_clubname;
    private javax.swing.JTextField jTextField_clubnbr;
    private javax.swing.JTextField jTextField_lastname;
    private javax.swing.JTextField jTextField_name;
    private javax.swing.JTextField jTextField_nationalnbr;
    private javax.swing.JTextField jTextField_phonenbr;
    private javax.swing.JTextField jTextField_postadress;
    private javax.swing.JTextField jTextField_prefix;
    private javax.swing.JTextField jTextField_streetadress;
    private javax.swing.JTextField jTextField_town;
    private javax.swing.JTextField jTextField_zipcode;
    private javax.swing.JToggleButton jToggleButton_F4C;
    private javax.swing.JToggleButton jToggleButton_F4H;
    private javax.swing.JToggleButton jToggleButton_FlyOnly;
    // End of variables declaration//GEN-END:variables
}

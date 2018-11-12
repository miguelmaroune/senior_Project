
package army.views;

import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class search extends javax.swing.JFrame {

   
    public search() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cb4 = new javax.swing.JComboBox<>();
        cb5 = new javax.swing.JComboBox<>();
        t5 = new javax.swing.JTextField();
        t6 = new javax.swing.JTextField();
        cb1 = new javax.swing.JComboBox<>();
        cb6 = new javax.swing.JComboBox<>();
        t1 = new javax.swing.JTextField();
        cb7 = new javax.swing.JComboBox<>();
        t2 = new javax.swing.JTextField();
        t7 = new javax.swing.JTextField();
        cb2 = new javax.swing.JComboBox<>();
        cb3 = new javax.swing.JComboBox<>();
        t3 = new javax.swing.JTextField();
        t4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cb4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Training Id" }));
        jPanel2.add(cb4, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 18, 90, 20));

        cb5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Driving ID" }));
        cb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb5ActionPerformed(evt);
            }
        });
        jPanel2.add(cb5, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 18, 100, 20));
        jPanel2.add(t5, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 49, 100, 30));
        jPanel2.add(t6, new org.netbeans.lib.awtextra.AbsoluteConstraints(592, 49, 100, 30));

        cb1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id ", "First Name", "Last Name", "Rank", "Blood Type", "Training id", "Date of birth", "Platoon Id", "Driving license" }));
        jPanel2.add(cb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 18, -1, 20));

        cb6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sanction ID" }));
        jPanel2.add(cb6, new org.netbeans.lib.awtextra.AbsoluteConstraints(592, 18, 100, 20));
        jPanel2.add(t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 49, 114, 30));

        cb7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rest LIst" }));
        jPanel2.add(cb7, new org.netbeans.lib.awtextra.AbsoluteConstraints(702, 18, 100, 20));
        jPanel2.add(t2, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 49, 114, 30));
        jPanel2.add(t7, new org.netbeans.lib.awtextra.AbsoluteConstraints(702, 49, 100, 30));

        cb2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id ", "First Name", "Last Name", "Rank", "Blood Type", "Training id", "Date of birth", "Platoon Id", "Driving license" }));
        jPanel2.add(cb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 18, -1, 20));

        cb3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id ", "First Name", "Last Name", "Rank", "Blood Type", "Training id", "Date of birth", "Platoon Id", "Driving license" }));
        jPanel2.add(cb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 18, -1, 20));
        jPanel2.add(t3, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 49, 114, 30));
        jPanel2.add(t4, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 49, 90, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/army/icons/Operational_Camouflage_Pattern_(OCP),_Scorpion_W2_swatch.jpg"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 90));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 20, 810, 90);

        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel1);
        jLabel1.setBounds(1040, 10, 100, 100);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/army/icons/magnifier.png"))); // NOI18N
        jPanel1.add(jButton1);
        jButton1.setBounds(830, 10, 105, 100);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "First name", "Last name", "Rank", "D O B", "Platoon Id", "Phone #", "Position", "Blood type", "Driving license", "Training Id", "Sanction ID", "Rest List"
            }
        ));
        jTable1.setColumnSelectionAllowed(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 130, 1130, 402);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Edit");
        jPanel1.add(jButton2);
        jButton2.setBounds(950, 10, 70, 100);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/army/icons/Operational_Camouflage_Pattern_(OCP),_Scorpion_W2_swatch.jpg"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 1200, 797);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1160, 540);

        setBounds(0, 0, 1179, 582);
    }// </editor-fold>//GEN-END:initComponents

    private void cb5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb5ActionPerformed

   
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JComboBox<String> cb2;
    private javax.swing.JComboBox<String> cb3;
    private javax.swing.JComboBox<String> cb4;
    private javax.swing.JComboBox<String> cb5;
    private javax.swing.JComboBox<String> cb6;
    private javax.swing.JComboBox<String> cb7;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    private javax.swing.JTextField t4;
    private javax.swing.JTextField t5;
    private javax.swing.JTextField t6;
    private javax.swing.JTextField t7;
    // End of variables declaration//GEN-END:variables
}

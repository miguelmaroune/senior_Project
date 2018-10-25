package army.views;

import army.controller.XMLReaderDOM;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

public class adduser extends javax.swing.JFrame {

     
        
    public adduser() {
       
        initComponents();
       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtuser = new javax.swing.JTextField();
        AddUSer = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        PositionCombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtuser1 = new javax.swing.JTextField();
        AddUSer1 = new javax.swing.JButton();
        AddUSer2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("insert user's information");
        setBackground(new java.awt.Color(255, 121, 27));
        setFocusCycleRoot(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        txtuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtuserActionPerformed(evt);
            }
        });
        jPanel1.add(txtuser);
        txtuser.setBounds(140, 30, 200, 20);

        AddUSer.setBackground(new java.awt.Color(255, 255, 255));
        AddUSer.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        AddUSer.setText("Edit user");
        AddUSer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AddUSer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddUser(evt);
            }
        });
        jPanel1.add(AddUSer);
        AddUSer.setBounds(390, 60, 110, 40);

        jLabel3.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel3.setText("Type:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 80, 80, 40);

        jLabel1.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel1.setText("Pasword");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 50, 90, 30);

        PositionCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soldier", "Platoon Leader", "Company Leader", "Secretary" }));
        PositionCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PositionComboActionPerformed(evt);
            }
        });
        jPanel1.add(PositionCombo);
        PositionCombo.setBounds(140, 90, 200, 20);

        jLabel2.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel2.setText("  UserName:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 20, 90, 30);

        txtuser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtuser1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtuser1);
        txtuser1.setBounds(140, 60, 200, 20);

        AddUSer1.setBackground(new java.awt.Color(255, 255, 255));
        AddUSer1.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        AddUSer1.setText("delete user");
        AddUSer1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AddUSer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddUSer1AddUser(evt);
            }
        });
        jPanel1.add(AddUSer1);
        AddUSer1.setBounds(390, 110, 110, 40);

        AddUSer2.setBackground(new java.awt.Color(255, 255, 255));
        AddUSer2.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        AddUSer2.setText("add user");
        AddUSer2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AddUSer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddUSer2AddUser(evt);
            }
        });
        jPanel1.add(AddUSer2);
        AddUSer2.setBounds(390, 10, 110, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/army/icons/Operational_Camouflage_Pattern_(OCP),_Scorpion_W2_swatch.jpg"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 0, 540, 210);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 540, 210);

        setSize(new java.awt.Dimension(555, 202));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
        
    private void AddUser(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddUser
       XMLReaderDOM xml = new XMLReaderDOM();
        try {
            xml.addUser(txtuser.getText(), "password", PositionCombo.getSelectedItem().toString());
        } catch (SAXException ex) {
            Logger.getLogger(adduser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(adduser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(adduser.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_AddUser

    private void PositionComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PositionComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PositionComboActionPerformed

    private void txtuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtuserActionPerformed

    private void txtuser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtuser1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtuser1ActionPerformed

    private void AddUSer1AddUser(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddUSer1AddUser
        // TODO add your handling code here:
    }//GEN-LAST:event_AddUSer1AddUser

    private void AddUSer2AddUser(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddUSer2AddUser
        // TODO add your handling code here:
    }//GEN-LAST:event_AddUSer2AddUser
       
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton AddUSer;
    public javax.swing.JButton AddUSer1;
    public javax.swing.JButton AddUSer2;
    private javax.swing.JComboBox<String> PositionCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtuser;
    private javax.swing.JTextField txtuser1;
    // End of variables declaration//GEN-END:variables
}

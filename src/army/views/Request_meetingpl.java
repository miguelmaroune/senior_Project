
package army.views;

import army.controller.DbManager;
import army.handler.UserHandler;
import army.model.User;
import army.settings.Settings;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Request_meetingpl extends javax.swing.JFrame {

    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    public Request_meetingpl() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        subject = new javax.swing.JTextField();
        cb = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Cancel");

        setTitle("Please Enter The Subject Of The Meeting...");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);
        jPanel1.add(subject);
        subject.setBounds(30, 20, 360, 140);

        cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soldier's ID" }));
        jPanel1.add(cb);
        cb.setBounds(130, 180, 150, 20);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Request Meeting");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(120, 210, 170, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/army/icons/Operational_Camouflage_Pattern_(OCP),_Scorpion_W2_swatch.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 410, 270);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 410, 270);

        setBounds(0, 0, 427, 307);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        insert_meeting(subject.getText());

    }//GEN-LAST:event_jButton3ActionPerformed

    private void fill_combo(){
        try {
          conn= DriverManager.getConnection(Settings.DBURL, Settings.DBUserName,Settings.DBPassword);
        String sql ="select * from soldier where Platoon_ID";
        pst=conn.prepareStatement (sql);
        rs=pst.executeQuery();
        while(rs.next()){
            
            String name=rs.getString("Soldier_Id");
            cb.addItem(name);
            
            
        }
        
        
        
        }catch (Exception e){
                JOptionPane.showMessageDialog(null, e);
        }
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField subject;
    // End of variables declaration//GEN-END:variables
public void insert_meeting(String request) {
        UserHandler Uhandler = new UserHandler();
        User user = Uhandler.getCurrUser();
        Connection con = null;
        String username = (String) cb.getSelectedItem();
//        for testing 
//        String username = "123456";
        try {
            if (con == null) {
                con = DbManager.getConnection();
            }
        } catch (Exception ex) {
            Logger.getLogger(Request_meeting.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Uhandler.request_meeting(con, username, request);
            setVisible(false);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "could not set meeting!", "Connection error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Request_meeting.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbManager.CloseConnection();}
        

}
}

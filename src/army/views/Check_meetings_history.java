package army.views;

import army.controller.DbManager;
import army.handler.UserHandler;
import army.model.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Check_meetings_history extends javax.swing.JFrame {

    private Vector<Vector<String>> meeting_his = new Vector<>();

    public Check_meetings_history() {
        UserHandler Uhandler = new UserHandler();
        User user = Uhandler.getCurrUser();
        Connection con = null;
        String username = user.getUsername();
//        for testing 
//        String username = "123456";
        try {
            if (con == null) {
                con = DbManager.getConnection();
            }
        } catch (Exception ex) {
            Logger.getLogger(Soldier_home.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            meeting_his = Uhandler.meetings_history(con, username);
        } catch (SQLException ex) {
            Logger.getLogger(Soldier_home.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbManager.CloseConnection();
        }
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setTitle("History of Meetings");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Meeting Id", "Subject", "Status", "Date", "Result"
            }
        ));
        jScrollPane2.setViewportView(jTable2);
        setMeetingTbl();

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(10, 90, 810, 270);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Meeting history :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 20, 230, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/army/icons/Operational_Camouflage_Pattern_(OCP),_Scorpion_W2_swatch.jpg"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 0, 840, 390);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 850, 392);

        setBounds(0, 0, 861, 431);
    }// </editor-fold>//GEN-END:initComponents

//    public static void main(String args[]) {
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Check_meetings_history().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
public void setMeetingTbl() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        for (Vector<String> v : meeting_his) {

// "Meeting Id", "Subject", "Status", "Date", "Result"
            String Meeting_ID = v.get(0);
            String Subject = v.get(1);
            String Status = v.get(2);
            String Date = v.get(3);
            String Result = v.get(4);
            model.addRow(new Object[]{Meeting_ID, Subject, Status, Date,Result});
        }

    }

}

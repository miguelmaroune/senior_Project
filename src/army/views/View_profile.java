package army.views;

import army.controller.DbManager;
import army.handler.UserHandler;
import army.model.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class View_profile extends javax.swing.JFrame {

    private Vector<Object> general_info = new Vector<>();
    private Vector<Vector<String>> training = new Vector<>();
    private Vector<Vector<String>> rest = new Vector<>();
    private Vector<Vector<String>> sanctions = new Vector<>();

    public View_profile() {
      //  ImageIcon img ;
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
            general_info = Uhandler.ViewProfile(con, username);
            training = Uhandler.training(con, username);
            rest = Uhandler.rest(con, username);
            sanctions = Uhandler.sanctions(con, username);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        setTitle("Resume");
        setResizable(false);
        getContentPane().setLayout(null);

        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 10, 103, 117);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Soldier_id", "Platoon_id", "First_name", "Last_name", "Rank", "Position", "available ", "date of birth", "phone number", "blood type"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        setGenInfo();

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 139, 970, 60);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Rest");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(470, 460, 70, 80);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("General Information ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(400, 40, 230, 80);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Trainings");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(450, 200, 110, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Sanctions");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(450, 350, 120, 30);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Sanction description", "Reference", "Start date", "End date", "Duration", "Executed", "Date of commitment", "Deduction", "Status"
            }
        ));
        jTable2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTable2FocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        setSanction();

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 390, 970, 90);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Rest type", "Reference", "Start date", "End date", "Cause"
            }
        ));
        jScrollPane3.setViewportView(jTable3);
        setRest();

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(10, 530, 970, 90);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Training description", "Reference", "Start date", "End date", "Location", "Evaluation"
            }
        ));
        jScrollPane4.setViewportView(jTable4);
        setTraining();

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(10, 250, 970, 90);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/army/icons/Operational_Camouflage_Pattern_(OCP),_Scorpion_W2_swatch.jpg"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 1010, 640);

        setBounds(0, 0, 1006, 682);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable2FocusGained
    }//GEN-LAST:event_jTable2FocusGained

//    public static void main(String args[]) {
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new View_profile().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    // End of variables declaration//GEN-END:variables

    public void setGenInfo() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
         
//        SELECT Soldier_Id , Platoon_Id , First_Name , Last_Name , "
//                    + "  Phone_Number , Rank , Position , Available ,DOB ,"
//                    + "  Blood_Type
//general_info.get(0);
        if (general_info.size() > 0) {
            model.addRow(new Object[]{general_info.get(0), general_info.get(1), general_info.get(2), general_info.get(3),
                general_info.get(5), general_info.get(6), general_info.get(7), general_info.get(8), general_info.get(4), general_info.get(9)});
        } else {
            model.setRowCount(0);
        }
    }

    public void setTraining() {
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        model.setRowCount(0);
        training.forEach((v) -> {
            // description , reference , start , end , location , Evaluation       
            String description = v.get(0);
            String reference = v.get(1);
            String start = v.get(2);
            String end = v.get(3);
            String location = v.get(4);
            String Evaluation = v.get(5);

            model.addRow(new Object[]{description, reference, start, end, location, Evaluation});
        });

    }

    public void setRest() {
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);
        rest.forEach((v) -> {
            // Type_Rest , Reference_Rest , Start , End , Cause 
            String Type_Rest = v.get(0);
            String Reference_Rest = v.get(1);
            String start = v.get(2);
            String end = v.get(3);
            String Cause = v.get(4);

            model.addRow(new Object[]{Type_Rest, Reference_Rest, start, end, Cause});
        });

    }

    public void setSanction() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        sanctions.forEach((v) -> {
            // description , start , end , duration , executed , date_Commited , deduction , status
            String description = v.get(0);
            String reference = v.get(1);
            String start = v.get(2);
            String end = v.get(3);
            String duration = v.get(4);
            String executed = v.get(5);
            String date_Commited = v.get(6);
            String deduction = v.get(7);
            String status = v.get(8);
            model.addRow(new Object[]{description, reference, start, end, duration, executed, date_Commited, deduction, status});
        });

    }
}

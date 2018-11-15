package army.views;

import army.views.Check_meetings_history;
import army.views.View_profile;
import army.views.Request_meeting;
import army.calendar.CalendarPanel;
import army.calendar.CalendarPanelTest;
import army.controller.DbManager;
import army.handler.UserHandler;
import army.model.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Soldier_home extends javax.swing.JFrame {

    private Vector<Vector<String>> meetings = new Vector<>();
    private Vector<Vector<String>> tasks = new Vector<>();
    public Soldier_home() {
        UserHandler Uhandler = new UserHandler();
        User user = Uhandler.getCurrUser();
        Connection con = null;
        String username = user.getUsername();

        try {
            if (con == null) {
                con = DbManager.getConnection();
            }
        } catch (Exception ex) {
            Logger.getLogger(Soldier_home.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            tasks = Uhandler.checkowndailytask(con, username);
        } catch (SQLException ex) {
            Logger.getLogger(Soldier_home.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbManager.CloseConnection();
        }
        
        
        try {
            meetings = Uhandler.checkownmeeting(con, username);
        } catch (SQLException ex) {
            Logger.getLogger(Soldier_home.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbManager.CloseConnection();
        }
        initComponents();
        settaskTbl();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        addtaskreport = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome back soldier!");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel2.setBackground(new java.awt.Color(204, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel2.setText("          Welcome Soldier! These are your tasks for today      ");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(80, 40, 500, 25);

        jLabel1.setBackground(new java.awt.Color(204, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel1.setText("                   These are your Pending Meetings          ");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(90, 240, 500, 25);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Assignment_Id", "Task ", "Status", "Date", "Reference", "Task report", "Task highlights"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 80, 680, 90);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Meeting Id", "Subject", "Status", "Date"
            }
        ));
        setMeetingTbl();
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(20, 280, 670, 90);

        addtaskreport.setText("Add Task Report");
        addtaskreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtaskreportActionPerformed(evt);
            }
        });
        jPanel1.add(addtaskreport);
        addtaskreport.setBounds(450, 190, 160, 23);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/army/icons/Operational_Camouflage_Pattern_(OCP),_Scorpion_W2_swatch.jpg"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 20, 720, 380);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, -20, 720, 400);

        jMenu4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenu4.setText("Manage meetings");

        jMenuItem1.setText("Request meeting");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuItem2.setText("Meeting history and result");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuBar1.add(jMenu4);

        jMenu2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenu2.setText("See profile");

        jMenuItem3.setText("See own profile");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenu3.setText("Check workdays and tasks");

        jMenuItem4.setText("Check calendar and tasks");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        setBounds(0, 0, 732, 435);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
//              Request_meeting req = new Request_meeting();
//              req.setVisible(true);
        new Request_meeting().setVisible(true);

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        new Check_meetings_history().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new View_profile().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new CalendarPanelTest().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void addtaskreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtaskreportActionPerformed

    }//GEN-LAST:event_addtaskreportActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addtaskreport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
public  void setMeetingTbl() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        for (Vector<String> v : meetings) {
// "Meeting Id", "Subject", "Status", "Date"       
            String Meeting_ID = v.get(0);
            String Subject = v.get(1);
            String Status = v.get(2);
            String Date = v.get(3);

            model.addRow(new Object[]{Meeting_ID, Subject, Status, Date});
        }

    }

public  void settaskTbl() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (Vector<String> v : tasks) {
// "ass Id", "task id", "Status", "Date",reference,task report ,task highlitght       
            String Assignment_id = v.get(0);
            String Task = v.get(1);
            String Status = v.get(2);
            String Date = v.get(3);
            String Reference = v.get(4);
            String Report = v.get(5);
            String Highlights = v.get(6);
            model.addRow(new Object[]{Assignment_id, Task, Status, Date, Reference, Report,Highlights});
        }

    }

}

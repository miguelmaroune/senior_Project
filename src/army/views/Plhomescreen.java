
package army.views;

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


public class Plhomescreen extends javax.swing.JFrame {

   private Vector<Vector<String>> tasks = new Vector<>();
    private Vector<Vector<String>> meetings = new Vector<>();
    private UserHandler Uhandler;
    private User user;
    private String username;
    private Connection con;
    
    public Plhomescreen() {
        
         Uhandler = new UserHandler();
         user = Uhandler.getCurrUser();
         username = user.getUsername();
         con = null;
     
        try {
            if (con == null) {
                con = DbManager.getConnection();
            }
        } catch (Exception ex) {            Logger.getLogger(CalendarPanel.class.getName()).log(Level.SEVERE, null, ex);

            Logger.getLogger(CalendarPanel.class.getName()).log(Level.SEVERE, null, ex);}
    //    try {
    //       meetings = Uhandler.meetings_historyplaton(con,username);
      // } catch (SQLException ex) {
        //   Logger.getLogger(Plhomescreen.class.getName()).log(Level.SEVERE, null, ex);
      // }
       
         

        initComponents();setMeetingTbl();
        try {
           tasks = Uhandler.tasksearchbyplatoon(con,username);
       } catch (SQLException ex) {
           Logger.getLogger(Plhomescreen.class.getName()).log(Level.SEVERE, null, ex);
       }
        settaskTbl();
        try {
           tasks = Uhandler.tasksearchbyMid(con,username);
       } catch (SQLException ex) {
           Logger.getLogger(Plhomescreen.class.getName()).log(Level.SEVERE, null, ex);
       }
        settaskownTbl();
        
    }
    public void setMeetingTbl() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        for (Vector<String> v : meetings) {
// "Meeting Id","Military Id "Subject", "Status", "Date"       
            String Meeting_ID = v.get(0);
            String Military_ID = v.get(1);
            String Subject = v.get(2);
            String Status = v.get(3);
            String Date = v.get(4);

            model.addRow(new Object[]{Meeting_ID, Military_ID,Subject, Status, Date});
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
            String Date = v.get(6);
            String Reference = v.get(3);
            String Report = v.get(4);
            String Highlights = v.get(5);
            model.addRow(new Object[]{Assignment_id, Task, Status, Date, Reference, Report,Highlights});
        }

    }
    public  void settaskownTbl() {
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);
        for (Vector<String> v : tasks) {
// "ass Id", "task id", "Status", "Date",reference,task report ,task highlitght       
            String Assignment_id = v.get(0);
            String Task = v.get(1);
            String Status = v.get(2);
            String Date = v.get(6);
            String Reference = v.get(3);
            String Report = v.get(4);
            String Highlights = v.get(5);
            model.addRow(new Object[]{Assignment_id, Task, Status, Date, Reference, Report,Highlights});
        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        meeting = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome back Lt !");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel3.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Assignment Id", "Task ", "Status", "Date", "Reference", "Task report", "Task highlights"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(10, 400, 680, 90);

        jLabel1.setBackground(new java.awt.Color(204, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel1.setText("                   These are your Platoon tasks          ");
        jLabel1.setOpaque(true);
        jPanel3.add(jLabel1);
        jLabel1.setBounds(110, 360, 500, 25);

        jLabel2.setBackground(new java.awt.Color(204, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel2.setText("          Welcome LT! These are your tasks for today      ");
        jLabel2.setOpaque(true);
        jPanel3.add(jLabel2);
        jLabel2.setBounds(110, 30, 500, 25);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Meeting Id", "Subject", "Status", "Date"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(20, 250, 670, 90);

        jLabel3.setBackground(new java.awt.Color(204, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel3.setText("                   These are your Pending Meetings          ");
        jLabel3.setOpaque(true);
        jPanel3.add(jLabel3);
        jLabel3.setBounds(120, 210, 500, 25);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Assignment Id", "Task ", "Status", "Date", "Reference", "Task report", "Task highlights"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(10, 70, 680, 90);

        jButton1.setText("Edit task");
        jPanel3.add(jButton1);
        jButton1.setBounds(260, 510, 180, 23);

        jButton2.setText("remove task");
        jPanel3.add(jButton2);
        jButton2.setBounds(470, 510, 200, 23);

        jButton3.setText("Add task");
        jPanel3.add(jButton3);
        jButton3.setBounds(60, 510, 170, 23);

        jButton7.setText("Add task report");
        jPanel3.add(jButton7);
        jButton7.setBounds(450, 170, 150, 23);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/army/icons/Operational_Camouflage_Pattern_(OCP),_Scorpion_W2_swatch.jpg"))); // NOI18N
        jPanel3.add(jLabel4);
        jLabel4.setBounds(0, 20, 700, 530);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, -20, 700, 570);

        meeting.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        meeting.setText("Manage meetings");

        jMenuItem1.setText("Request Meeting");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        meeting.add(jMenuItem1);
        jMenuItem1.getAccessibleContext().setAccessibleDescription("");

        jMenuItem4.setText("Meetings History and Results");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        meeting.add(jMenuItem4);
        meeting.add(jSeparator1);

        jMenuBar1.add(meeting);
        meeting.getAccessibleContext().setAccessibleDescription("");

        jMenu2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenu2.setText("Query platoon");

        jMenuItem2.setText("Search Platoon");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenu1.setText("Check tasks and workdays");

        jMenuItem5.setText("Check calendar and tasks");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenu3.setText("Generate ");

        jMenuItem3.setText("Jouhouz and mission paper");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem6.setText("Jadwal");
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        setBounds(0, 0, 716, 590);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
   new Request_meetingpl().setVisible(true);                                          
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
new pl_meetinghistory().setVisible(true);     
    }//GEN-LAST:event_jMenuItem4ActionPerformed
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
new CalendarPanelTest().setVisible(true); 
    }//GEN-LAST:event_jMenuItem5ActionPerformed
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
new searchpl().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
new Listjouhouz().setVisible(true);        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

  
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JMenu meeting;
    // End of variables declaration//GEN-END:variables
}

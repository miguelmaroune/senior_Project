
package army.views;

import army.calendar.CalendarPanel;
import army.calendar.CalendarPanelTest;
import army.controller.DbManager;
import army.handler.UserHandler;
import army.model.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;


public class Cl_homepage extends javax.swing.JFrame {
    private Vector<Vector<String>> tasks = new Vector<>();
    private Vector<Vector<String>> meetings = new Vector<>();
    private UserHandler Uhandler;
    private User user;
    private String username;
    private Connection con;
    
    public Cl_homepage() {
         Uhandler = new UserHandler();
        User user = Uhandler.getCurrUser();
         username = user.getUsername();
        con = null;
       
        try {
            if (con == null) {
                con = DbManager.getConnection();
            }
        } catch (Exception ex) {
            Logger.getLogger(CalendarPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
try {
        tasks = Uhandler.checkowndailytask(con, username);
        } catch (SQLException ex) {
            Logger.getLogger(Soldier_home.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbManager.CloseConnection();
        }
        try {
        meetings = Uhandler.showallpendingmeetings(con, username);
        } catch (SQLException ex) {
            Logger.getLogger(CalendarPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbManager.CloseConnection();
        }
        initComponents();
        setMeetingTbl();
        settaskTbl();
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        setresult = new javax.swing.JButton();
        setstatus = new javax.swing.JButton();
        setdate = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        refresh = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        meeting = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome back Captain !");
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
        jScrollPane1.setBounds(10, 60, 680, 90);

        jLabel1.setBackground(new java.awt.Color(204, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel1.setText("                   These are The Pending Meetings          ");
        jLabel1.setOpaque(true);
        jPanel3.add(jLabel1);
        jLabel1.setBounds(120, 180, 500, 25);

        jLabel2.setBackground(new java.awt.Color(204, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel2.setText("          Welcome Captain ! These are the tasks for today      ");
        jLabel2.setOpaque(true);
        jPanel3.add(jLabel2);
        jLabel2.setBounds(110, 20, 500, 25);

        setresult.setText("Set Meeting result");
        setresult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setresultActionPerformed(evt);
            }
        });
        jPanel3.add(setresult);
        setresult.setBounds(190, 340, 150, 23);

        setstatus.setText("Set Meeting Status");
        setstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setstatusActionPerformed(evt);
            }
        });
        jPanel3.add(setstatus);
        setstatus.setBounds(360, 340, 150, 23);

        setdate.setText("Set Meeting Date");
        setdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setdateActionPerformed(evt);
            }
        });
        jPanel3.add(setdate);
        setdate.setBounds(540, 340, 150, 23);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Meeting Id", "Military id", "Subject", "Status", "Date", "Result"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(20, 230, 670, 90);

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        jPanel3.add(refresh);
        refresh.setBounds(0, 360, 110, 23);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/army/icons/Operational_Camouflage_Pattern_(OCP),_Scorpion_W2_swatch.jpg"))); // NOI18N
        jPanel3.add(jLabel3);
        jLabel3.setBounds(0, 0, 700, 400);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 700, 400);

        meeting.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        meeting.setText("Manage meetings");
        meeting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meetingActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Request Meeting");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        meeting.add(jMenuItem1);
        jMenuItem1.getAccessibleContext().setAccessibleDescription("");

        jMenuItem4.setText("Search meeting history");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        meeting.add(jMenuItem4);
        meeting.add(jSeparator1);

        jMenuBar1.add(meeting);
        meeting.getAccessibleContext().setAccessibleDescription("");

        jMenu1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenu1.setText("Manage tasks and workdays");

        jMenuItem5.setText("Manage tasks");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem14.setText("Manage workdays");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem14);

        jMenuItem18.setText("Check workdays and tasks");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem18);

        jMenuBar1.add(jMenu1);

        jMenu4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenu4.setText("Query");

        jMenuItem6.setText("Search / Edit /Archive");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuItem7.setText("Tarashi7");
        jMenu4.add(jMenuItem7);

        jMenuItem2.setText("Tables");
        jMenu4.add(jMenuItem2);

        jMenuBar1.add(jMenu4);

        jMenu5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenu5.setText("Manage Soldiers");

        jMenuItem9.setText("Add info");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem9);

        jMenuBar1.add(jMenu5);

        jMenu6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenu6.setText("Generate");

        jMenuItem15.setText("لائحة الجهوز والمهمات");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem15);

        jMenuItem16.setText("Schedule");
        jMenu6.add(jMenuItem16);

        jMenuBar1.add(jMenu6);

        jMenu2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenu2.setText("Manage accounts");

        jMenuItem3.setText("Add/Remove/Edit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenu3.setText("Tools");

        jMenuItem11.setText("Encryption tool");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuItem12.setText("Sanction calculator");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);

        jMenuItem10.setText("ورقة الحرس");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        setBounds(300, 150, 709, 446);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
new Tasks().setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed
    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        
    }//GEN-LAST:event_jMenuItem11ActionPerformed
    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
    new Sanction_paper().setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed
    private void meetingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meetingActionPerformed

    }//GEN-LAST:event_meetingActionPerformed
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    new Request_meetingcl().setVisible(true);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
new cl_meetinghistory().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed
    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
new CalendarPanelTest().setVisible(true);

    }//GEN-LAST:event_jMenuItem18ActionPerformed
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
new Search_cl().setVisible(true); 
    }//GEN-LAST:event_jMenuItem6ActionPerformed
    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        new Addsoldier().setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
     new   adduser().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
new   Listjouhouz().setVisible(true);    }//GEN-LAST:event_jMenuItem15ActionPerformed
    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
new   Haras().setVisible(true);    }//GEN-LAST:event_jMenuItem10ActionPerformed
    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        new Workdays().setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void setstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setstatusActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();        Vector<String> v = new Vector<>();

        v = (Vector<String>) model.getDataVector().elementAt(jTable2.getSelectedRow());
        try {
            if (con == null) {
                con = DbManager.getConnection();
            }
        } catch (Exception ex) {
            Logger.getLogger(CalendarPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Uhandler.update_meeting_status(v, con, username);
        } catch (SQLException ex) {
            Logger.getLogger(CalendarPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbManager.CloseConnection();
        }
    }//GEN-LAST:event_setstatusActionPerformed
    private void setdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setdateActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        Vector<String> v = new Vector<>();
        v = (Vector<String>) model.getDataVector().elementAt(jTable2.getSelectedRow());
        try {
            if (con == null) {
                con = DbManager.getConnection();
            }
        } catch (Exception ex) {
            Logger.getLogger(CalendarPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Uhandler.update_meeting_Date(v, con, username);
        } catch (SQLException ex) {
            Logger.getLogger(CalendarPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbManager.CloseConnection();
        }
    }//GEN-LAST:event_setdateActionPerformed
    private void setresultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setresultActionPerformed
  DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        Vector<String> v = new Vector<>();
        v = (Vector<String>) model.getDataVector().elementAt(jTable2.getSelectedRow());
        try {
            if (con == null) {
                con = DbManager.getConnection();
            }
        } catch (Exception ex) {
            Logger.getLogger(CalendarPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Uhandler.update_meeting_Result(v, con, username);
        } catch (SQLException ex) {
            Logger.getLogger(CalendarPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbManager.CloseConnection();
        }    }//GEN-LAST:event_setresultActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
       this.dispose();
       new Cl_homepage().setVisible(true);
        
    }//GEN-LAST:event_refreshActionPerformed
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
    
    
  
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JMenu meeting;
    private javax.swing.JButton refresh;
    private javax.swing.JButton setdate;
    private javax.swing.JButton setresult;
    private javax.swing.JButton setstatus;
    // End of variables declaration//GEN-END:variables

 

}

package army.views;

import army.calendar.CalendarPanel;
import army.controller.DbManager;
import army.handler.UserHandler;
import army.settings.Settings;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Tasks extends javax.swing.JFrame {
    
private Vector<Vector<String>> tasksearch = new Vector<>();
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    String result;
    private UserHandler Uhandler;
        
    public Tasks() {
        initComponents();fill_combo();fill_combo2();
Uhandler=new UserHandler();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        addtask = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        aid = new javax.swing.JComboBox<>();
        mid = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setTitle("Manage Tasks");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Please choose search criteria");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 40, 350, 50);

        date.setToolTipText("Choose by date");
        getContentPane().add(date);
        date.setBounds(270, 110, 170, 20);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Task Id", "Soldier ID", "Date and Time", "Reference", "Task status", "Highlights", "Task report"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 443, 895, 50);

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        getContentPane().add(edit);
        edit.setBounds(626, 402, 100, 23);

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete);
        delete.setBounds(744, 402, 100, 23);

        addtask.setText("Add Task");
        addtask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtaskActionPerformed(evt);
            }
        });
        getContentPane().add(addtask);
        addtask.setBounds(730, 503, 120, 23);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Assignment Id", "Task Id", "Soldier ID", "Date and Time", "Reference", "Task status", "Highlights", "Task report"
            }
        ));
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setHeaderValue("Assignment Id");
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 140, 895, 260);

        aid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose by Assignment id" }));
        aid.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                aidItemStateChanged(evt);
            }
        });
        getContentPane().add(aid);
        aid.setBounds(410, 20, 170, 20);

        mid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose by Military id" }));
        mid.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                midItemStateChanged(evt);
            }
        });
        getContentPane().add(mid);
        mid.setBounds(410, 50, 170, 20);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/army/icons/magnifier.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(790, 40, 50, 60);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Press to see all tasks");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(730, 10, 180, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Choose By Date");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(420, 80, 140, 22);

        jButton5.setText("Go to selected Date");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(450, 110, 200, 23);

        jLabel5.setText("YYYY-MM_DD");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(290, 420, 100, 14);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/army/icons/Operational_Camouflage_Pattern_(OCP),_Scorpion_W2_swatch.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 920, 540);

        setBounds(0, 0, 931, 576);
    }// </editor-fold>//GEN-END:initComponents

    private void aidItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_aidItemStateChanged
      result= (String) aid.getSelectedItem();
                                          
            try {
                    conn= DriverManager.getConnection(Settings.DBURL, Settings.DBUserName,Settings.DBPassword);}
            catch (SQLException ex) {
                Logger.getLogger(Request_meetingcl.class.getName()).log(Level.SEVERE, null, ex);}
                 
            try {
                      UserHandler Uhandler = new UserHandler();
                     tasksearch = Uhandler.tasksearchbyaid(conn, result);}
            catch (SQLException ex) {
            Logger.getLogger(Soldier_home.class.getName()).log(Level.SEVERE, null, ex);}
            finally {
            DbManager.CloseConnection();
            settaskTbl();}                 
    }//GEN-LAST:event_aidItemStateChanged
    private void midItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_midItemStateChanged
    result= (String) mid.getSelectedItem();
                                          
            try {
                    conn= DriverManager.getConnection(Settings.DBURL, Settings.DBUserName,Settings.DBPassword);}
            catch (SQLException ex) {
                Logger.getLogger(Request_meetingcl.class.getName()).log(Level.SEVERE, null, ex);}
                 
            try {
                      UserHandler Uhandler = new UserHandler();
                     tasksearch = Uhandler.tasksearchbyMid(conn, result);}
            catch (SQLException ex) {
            Logger.getLogger(Soldier_home.class.getName()).log(Level.SEVERE, null, ex);}
            finally {
            DbManager.CloseConnection();
            settaskTbl();}
           
                           
    
    }//GEN-LAST:event_midItemStateChanged
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
try {
                    conn= DriverManager.getConnection(Settings.DBURL, Settings.DBUserName,Settings.DBPassword);}
            catch (SQLException ex) {
                Logger.getLogger(Request_meetingcl.class.getName()).log(Level.SEVERE, null, ex);}
                 
            try {
                      UserHandler Uhandler = new UserHandler();
                     tasksearch = Uhandler.tasksearchall(conn);}
            catch (SQLException ex) {
            Logger.getLogger(Soldier_home.class.getName()).log(Level.SEVERE, null, ex);}
            finally {
            DbManager.CloseConnection();
            settaskTbl();}
        

    }//GEN-LAST:event_jButton4ActionPerformed
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
SimpleDateFormat df =new SimpleDateFormat("YYYY-MM-dd");
        result =df.format(date.getDate());
    
        try {
                    conn= DriverManager.getConnection(Settings.DBURL, Settings.DBUserName,Settings.DBPassword);}
            catch (SQLException ex) {
                Logger.getLogger(Request_meetingcl.class.getName()).log(Level.SEVERE, null, ex);}
                 
            try {
                      UserHandler Uhandler = new UserHandler();
                     tasksearch = Uhandler.tasksearchbydate(conn, result);}
            catch (SQLException ex) {
            Logger.getLogger(Soldier_home.class.getName()).log(Level.SEVERE, null, ex);}
            finally {
            DbManager.CloseConnection();
            settaskTbl();}
    }//GEN-LAST:event_jButton5ActionPerformed
    private void addtaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtaskActionPerformed
DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Vector<String> v = new Vector<>();
        v = (Vector<String>) model.getDataVector().elementAt(jTable1.getSelectedRow());
        try {
            if (conn == null) {
                conn = DbManager.getConnection();
            }
        } catch (Exception ex) {
            Logger.getLogger(CalendarPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Uhandler.addtask(v, conn);
        
        } catch (SQLException ex) {
        Logger.getLogger(Tasks.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
            DbManager.CloseConnection();
        }        
    }//GEN-LAST:event_addtaskActionPerformed
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        Vector<String> v = new Vector<>();
        v = (Vector<String>) model.getDataVector().elementAt(jTable2.getSelectedRow());
        try {
            if (conn == null) {
                conn = DbManager.getConnection();
            }
        } catch (Exception ex) {
            Logger.getLogger(CalendarPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Uhandler.deletetask(v, conn);
        
        } catch (SQLException ex) {
        Logger.getLogger(Tasks.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
            DbManager.CloseConnection();
        }        
    }//GEN-LAST:event_deleteActionPerformed
    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        Vector<String> v = new Vector<>();
        v = (Vector<String>) model.getDataVector().elementAt(jTable2.getSelectedRow());
        try {
            if (conn == null) {
                conn = DbManager.getConnection();
            }
        } catch (Exception ex) {
            Logger.getLogger(CalendarPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Uhandler.updatetask(v, conn);
        
        } catch (SQLException ex) {
        Logger.getLogger(Tasks.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
            DbManager.CloseConnection();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_editActionPerformed
    private void fill_combo(){
        try {
          conn= DriverManager.getConnection(Settings.DBURL, Settings.DBUserName,Settings.DBPassword);
        String sql ="select * from assigned_task";
        pst=conn.prepareStatement (sql);
        rs=pst.executeQuery();
        while(rs.next()){
            
          String id=rs.getString("Assignement_Id");
            
            aid.addItem(id);
        }        }catch (Exception e){
                JOptionPane.showMessageDialog(null, e);
}
    
}
    private void fill_combo2(){
        try {
          conn= DriverManager.getConnection(Settings.DBURL, Settings.DBUserName,Settings.DBPassword);
        String sql ="select * from assigned_task";
        pst=conn.prepareStatement (sql);
        rs=pst.executeQuery();
        while(rs.next()){
            
          String id=rs.getString("Soldier_Id");
            
            mid.addItem(id);
        }        }catch (Exception e){
                JOptionPane.showMessageDialog(null, e);

    
} 
    }
    public void settaskTbl() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        for (Vector<String> v : tasksearch) {

// Assignement_id,Task_Id,Soldier_Id,Date_Assigned,Reference,Status,highlights,report   
            String Assignement_id = v.get(0);
            String Task_Id = v.get(1);
            String Soldier_Id = v.get(2);
            String Date_Assigned = v.get(3);
            String Reference = v.get(4);
            String Status = v.get(6);
            String highlights = v.get(7);
            String report = v.get(5);
            model.addRow(new Object[]{Assignement_id, Task_Id, Soldier_Id, Date_Assigned,Reference,report,Status,highlights});
        } }   
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addtask;
    private javax.swing.JComboBox<String> aid;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox<String> mid;
    // End of variables declaration//GEN-END:variables
}

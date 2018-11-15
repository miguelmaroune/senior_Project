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
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class cl_meetinghistory extends javax.swing.JFrame {

    private Vector<Vector<String>> meeting_his = new Vector<>();
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    String result;

    
    
    
    public cl_meetinghistory() {
        UserHandler Uhandler = new UserHandler();
        User user = Uhandler.getCurrUser();
        Connection con = null;
      
        try {
            if (con == null) {
                con = DbManager.getConnection();
            }
        } catch (Exception ex) {
            Logger.getLogger(Soldier_home.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        initComponents();
        fill_combo();fill_combo2();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        searchall = new javax.swing.JButton();
        cb = new javax.swing.JComboBox<>();
        label = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cb2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        test = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        setdate = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setTitle("History of Meetings");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Meeting Id", "Subject", "Status", "Date", "Result", "Military Id"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(20, 180, 890, 320);

        searchall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/army/icons/magnifier.png"))); // NOI18N
        searchall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchallActionPerformed(evt);
            }
        });
        jPanel1.add(searchall);
        searchall.setBounds(100, 30, 50, 60);

        cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soldier's ID" }));
        cb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbItemStateChanged(evt);
            }
        });
        jPanel1.add(cb);
        cb.setBounds(290, 40, 150, 30);

        label.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        label.setText("Name will show here");
        jPanel1.add(label);
        label.setBounds(540, 0, 240, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Power filter tool");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(60, 90, 270, 30);

        cb2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meeting id" }));
        cb2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb2ItemStateChanged(evt);
            }
        });
        jPanel1.add(cb2);
        cb2.setBounds(290, 120, 150, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Filter by Military id");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(260, 0, 270, 30);

        test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testActionPerformed(evt);
            }
        });
        jPanel1.add(test);
        test.setBounds(50, 120, 160, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("See all meetings");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(60, 0, 270, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Filter by Status");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(490, 80, 270, 30);

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meeting status", "Pending date set", "Pending date not set", "Rejected", "Cancelled", "Done" }));
        status.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                statusItemStateChanged(evt);
            }
        });
        jPanel1.add(status);
        status.setBounds(500, 120, 150, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Filter by date");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(710, 80, 130, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Filter by Meeting id");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(260, 80, 270, 30);
        jPanel1.add(date);
        date.setBounds(710, 120, 130, 30);

        setdate.setText("Set date");
        setdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setdateActionPerformed(evt);
            }
        });
        jPanel1.add(setdate);
        setdate.setBounds(850, 120, 90, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/army/icons/Operational_Camouflage_Pattern_(OCP),_Scorpion_W2_swatch.jpg"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 0, 940, 520);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 940, 530);

        setBounds(0, 0, 956, 562);
    }// </editor-fold>//GEN-END:initComponents

    private void cbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbItemStateChanged
        result= (String) cb.getSelectedItem();
        try {                                    
            try {
                
                conn= DriverManager.getConnection(Settings.DBURL, Settings.DBUserName,Settings.DBPassword);
            } catch (SQLException ex) {
                Logger.getLogger(Request_meetingcl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
            String sql ="SELECT * FROM `soldier` WHERE `Soldier_Id`=?";
            
            
            pst=conn.prepareStatement (sql);
            pst.setString(1,result);
            rs=pst.executeQuery();
             while(rs.next()){
            String name2=rs.getString("First_Name");
            String name3=rs.getString("Last_Name");
            String name4=name2+" "+name3;
            label.setText(name4);  
             try {
      UserHandler Uhandler = new UserHandler();
            meeting_his = Uhandler.meetings_historymilitaryid(conn, result);
        } catch (SQLException ex) {
            Logger.getLogger(Soldier_home.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbManager.CloseConnection();
            setMeetingTbl();
        }
             }
             
             
        } catch (SQLException ex) {
                Logger.getLogger(Request_meetingcl.class.getName()).log(Level.SEVERE, null, ex);
            }        // TODO add your handling code here:
                            
       
    }//GEN-LAST:event_cbItemStateChanged
    private void searchallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchallActionPerformed
   
     try {
      UserHandler Uhandler = new UserHandler();
            meeting_his = Uhandler.meetings_historyall(conn);
        } catch (SQLException ex) {
            Logger.getLogger(Soldier_home.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbManager.CloseConnection();
            setMeetingTbl();
        }
       
    }//GEN-LAST:event_searchallActionPerformed
    public void filter (String query){
       
       TableRowSorter<DefaultTableModel>tr=new TableRowSorter<DefaultTableModel>();
       jTable1.setRowSorter(tr);
       tr.setRowFilter(RowFilter.regexFilter(query));
   }
    private void cb2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb2ItemStateChanged
try {result=(String) cb2.getSelectedItem();
      UserHandler Uhandler = new UserHandler();
            meeting_his = Uhandler.meetings_historymeetingid(conn, result);
        } catch (SQLException ex) {
            Logger.getLogger(Soldier_home.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbManager.CloseConnection();
            setMeetingTbl();}      
    }//GEN-LAST:event_cb2ItemStateChanged

    private void statusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_statusItemStateChanged
try {result=(String) status.getSelectedItem();;
      UserHandler Uhandler = new UserHandler();
            meeting_his = Uhandler.meetings_historystatus(conn, result);
        } catch (SQLException ex) {
            Logger.getLogger(Soldier_home.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbManager.CloseConnection();
            setMeetingTbl();}      
                             
    }//GEN-LAST:event_statusItemStateChanged

    private void setdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setdateActionPerformed
SimpleDateFormat df =new SimpleDateFormat("YYYY-MM-dd");
        result =df.format(date.getDate());
    
        try {
                    conn= DriverManager.getConnection(Settings.DBURL, Settings.DBUserName,Settings.DBPassword);}
            catch (SQLException ex) {
                Logger.getLogger(Request_meetingcl.class.getName()).log(Level.SEVERE, null, ex);}
                 
            try {
                      UserHandler Uhandler = new UserHandler();
                      meeting_his = Uhandler.meetingsearchbydate(conn, result);}
            catch (SQLException ex) {
            Logger.getLogger(Soldier_home.class.getName()).log(Level.SEVERE, null, ex);}
            finally {
            DbManager.CloseConnection();
            setMeetingTbl();}        // TODO add your handling code here:
    }//GEN-LAST:event_setdateActionPerformed

    private void testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testActionPerformed
String filter=test.getText().toLowerCase();
        filter(filter);       
    }//GEN-LAST:event_testActionPerformed
    public void setMeetingTbl() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (Vector<String> v : meeting_his) {

// "Meeting Id", "Subject", "Status", "Date", "Result ,soldierid"
            String Meeting_ID = v.get(0);
            String Subject = v.get(1);
            String Status = v.get(2);
            String Date = v.get(3);
            String Result = v.get(4);
            String Soldier_id = v.get(5);
            model.addRow(new Object[]{Meeting_ID, Subject, Status, Date,Result,Soldier_id});
        }

    }
    private void fill_combo(){
        try {
          conn= DriverManager.getConnection(Settings.DBURL, Settings.DBUserName,Settings.DBPassword);
        String sql ="select * from soldier";
        pst=conn.prepareStatement (sql);
        rs=pst.executeQuery();
        while(rs.next()){
            
          String id=rs.getString("Soldier_Id");
            
            cb.addItem(id);
        }        }catch (Exception e){
                JOptionPane.showMessageDialog(null, e);
        }
    }
    private void fill_combo2(){
        try {
          conn= DriverManager.getConnection(Settings.DBURL, Settings.DBUserName,Settings.DBPassword);
        String sql ="select * from meeting";
        pst=conn.prepareStatement (sql);
        rs=pst.executeQuery();
        while(rs.next()){
            
          String id=rs.getString("id_Meeting");
            
            cb2.addItem(id);
        }        }catch (Exception e){
                JOptionPane.showMessageDialog(null, e);
}
    
}
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb;
    private javax.swing.JComboBox<String> cb2;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel label;
    private javax.swing.JButton searchall;
    private javax.swing.JButton setdate;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JTextField test;
    // End of variables declaration//GEN-END:variables

 
}


package army.views;

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
import javax.swing.table.DefaultTableModel;

public class Listjouhouz extends javax.swing.JFrame {

    private Vector<Vector<String>> tasksearch = new Vector<>();
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    String result;
    private UserHandler Uhandler;
    
    public Listjouhouz() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        date = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setTitle("لائحة الجهوز والمهمات");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 31, 170, 44));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("لائحة الجهوز اليومي والمهمات بتاريخ ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 31, 555, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "الوظيفة", "الرتبة", "الإسم", "الرقم العسكري"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 110, 400, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "رقم المهمة", "نوع المهمة", "المعنيين بـالتنفيذ", "التاريخ", "المستند", "وضع المهمة", "تعليمات اضافية", "تقرير انتهاء المهمة"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 108, 920, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/army/icons/Operational_Camouflage_Pattern_(OCP),_Scorpion_W2_swatch.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 0, 180, 550));

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setText("تحديد التاريخ ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 170, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/army/icons/Operational_Camouflage_Pattern_(OCP),_Scorpion_W2_swatch.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 1370, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1373, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1389, 584);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        SimpleDateFormat df =new SimpleDateFormat("YYYY-MM-dd");
        result =df.format(date.getDate());

       
        try {
            conn= DriverManager.getConnection(Settings.DBURL, Settings.DBUserName,Settings.DBPassword);
        } catch (SQLException ex) {
            Logger.getLogger(Listjouhouz.class.getName()).log(Level.SEVERE, null, ex);
        }

            UserHandler Uhandler = new UserHandler();
        try {
            tasksearch = Uhandler.tasksearchbydate(conn, result);
        } catch (SQLException ex) {
            Logger.getLogger(Listjouhouz.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            DbManager.CloseConnection();
            settaskTbl();}
        
    }//GEN-LAST:event_jButton5ActionPerformed

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
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}

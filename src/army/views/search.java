
package army.views;
import army.controller.DbManager;
import java.*;
//import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import army.model.Soldier;

public class search extends javax.swing.JFrame {

    
    public search() {
        initComponents();
    }
                            
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        bimage = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("choose a criteria .....");
        setBackground(new java.awt.Color(0, 51, 51));

        jPanel1.setLayout(null);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id", "First Name", "Last Name", "Rank","Blood Type" ,"Training id","Date of birth","Platoon Id" ,"Driving license"}));
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(20, 10, 80, 20);

        bimage.setBackground(new java.awt.Color(255, 255, 255));
        bimage.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        bimage.setOpaque(true);
        jPanel1.add(bimage);
        bimage.setBounds(10, 70, 170, 220);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(110, 10, 130, 20);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "Id", "First Name", "Last Name", "Rank", "Date Of Birth", "Platoon Id", "Phone #","Position","Blood Type","Driving license","Training Id"
            }
        ));
        table.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(table);
        table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(190, 70, 1090, 500);
        jPanel1.add(jTextField2);
        jTextField2.setBounds(380, 10, 140, 20);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id", "First Name", "Last Name", "Rank" ,"Blood Type" ,"Driving License","Training id","Date of birth","Platoon Id"}));
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(260, 10, 110, 20);
        jPanel1.add(jTextField3);
        jTextField3.setBounds(650, 10, 140, 20);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id", "First Name", "Last Name", "Rank","Blood Type" ,"Driving license","Training id","Date of birth","Platoon Id" }));
        jPanel1.add(jComboBox3);
        jComboBox3.setBounds(530, 10, 110, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon("/army/icons/magnifier.png")); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    jLabel2MouseClicked(evt);
                } catch (Exception ex) {
                    Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jPanel1.add(jLabel2);
        jLabel2.setBounds(840, 0, 50, 60);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(50, -90, 920, 340);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(0, 0, 1500, 500);
    }                       

     //fill arraylist with data
    public ArrayList<Soldier> getSoldierlist() throws Exception{
        
            ArrayList<Soldier> soldierlist =new ArrayList<Soldier>();
//          Class.forName("");
            Connection con=DbManager.getConnection();
            String query="select * from soldier" ;
            Statement st;
//            Resultset rs;
            try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
//            rs =  (Resultset) st.executeQuery(query);
            Soldier soldier;
            
            while (rs.next()){
                soldier =new Soldier(rs.getInt("soldier_id"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("rank"));
                soldierlist.add(soldier);
               
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
 return soldierlist; }
     //p0opulate the jtable
    public void showsoldiers() throws Exception{
        ArrayList<Soldier> list=getSoldierlist();
        DefaultTableModel model=(DefaultTableModel) table.getModel();
        

        for (int i=0;i<list.size();i++){
                    Object[] row= new Object [1];
//            row[0]=list.get(i).getid();
            int id = list.get(i).getid();
//            row[1]=list.get(i).getfirstname();
String firstname = list.get(i).getfirstname();
//            row[2]=list.get(i).getlastname();
String lastname = list.get(i).getlastname();
//            row[3]=list.get(i).getrank();
            String rank = list.get(i).getrank();
                    
                 model.addRow(new Object[]{id,firstname,lastname,rank});
                    
                    
                    }
        
    }
    
    
    
    
    
    
    
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) throws Exception {                                     
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "Id", "First Name", "Last Name", "Rank", "Date Of Birth", "Platoon Id", "Training Id"
            }
        ));
        showsoldiers();
    }                                    

   
    public static void main(String args[]) {
      
                new search().setVisible(true);
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel bimage;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable table;
    // End of variables declaration                   
}

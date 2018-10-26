
package army.views;

public class cl_meetinghistory extends javax.swing.JFrame {

    
    public cl_meetinghistory() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("History of Meetings");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Meeting Id", "Subject", "Status", "Date", "Result"
            }
        ));
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(10, 80, 890, 280);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Meeting history  :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 20, 230, 40);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(370, 30, 260, 20);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Meeting id", "Subject", "Status", "Date", "Result" }));
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(270, 30, 74, 20);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/army/icons/magnifier.png"))); // NOI18N
        jPanel1.add(jButton1);
        jButton1.setBounds(680, 10, 50, 60);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/army/icons/Operational_Camouflage_Pattern_(OCP),_Scorpion_W2_swatch.jpg"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 0, 940, 390);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 940, 392);

        setBounds(0, 0, 956, 431);
    }// </editor-fold>//GEN-END:initComponents

   
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cl_meetinghistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

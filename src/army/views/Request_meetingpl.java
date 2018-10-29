
package army.views;

public class Request_meetingpl extends javax.swing.JFrame {

    
    public Request_meetingpl() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        subject = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Cancel");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Please Enter The Subject Of The Meeting...");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);
        jPanel1.add(subject);
        subject.setBounds(30, 20, 360, 140);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Request Meeting");
        jPanel1.add(jButton3);
        jButton3.setBounds(120, 210, 170, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soldier's ID" }));
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(130, 180, 150, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/army/icons/Operational_Camouflage_Pattern_(OCP),_Scorpion_W2_swatch.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 410, 270);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 410, 270);

        setBounds(0, 0, 427, 307);
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Request_meetingpl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField subject;
    // End of variables declaration//GEN-END:variables
}

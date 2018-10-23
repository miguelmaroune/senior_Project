package army.views;

import army.model.User;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.Color;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import army.controller.XMLReaderDOM;
import org.apache.log4j.Logger;

public class LoginPage extends javax.swing.JFrame {

    static Timer tm;
    static int i = 0;

    public LoginPage() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        j1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lebanese Army");
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        setName("LoginFrame"); // NOI18N
        getContentPane().setLayout(null);

        jPanel2.setLayout(null);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/army/icons/Target-PNG-Image-89635.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel8);
        jLabel8.setBounds(620, 170, 130, 180);

        jLabel6.setFont(new java.awt.Font("Tekton Pro Ext", 1, 11)); // NOI18N
        jLabel6.setText("2018  rights reserved");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(580, 370, 200, 40);

        jLabel4.setFont(new java.awt.Font("Tekton Pro Ext", 1, 11)); // NOI18N
        jLabel4.setText("Property of First Lieutenant LOUIS Rony. F");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(510, 400, 250, 30);

        jLabel3.setFont(new java.awt.Font("Tekton Pro Ext", 1, 12)); // NOI18N
        jLabel3.setText("USERNAME:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(460, 17, 80, 70);

        jLabel5.setFont(new java.awt.Font("Tekton Pro Ext", 1, 12)); // NOI18N
        jLabel5.setText("PASSWORD:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(460, 80, 90, 67);

        txtusername.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        jPanel2.add(txtusername);
        txtusername.setBounds(550, 40, 170, 30);

        txtpassword.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        jPanel2.add(txtpassword);
        txtpassword.setBounds(550, 90, 170, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/army/icons/000_RN3LI-e1503114866626.jpg"))); // NOI18N
        jLabel2.setText("For Assistance please contact ");
        jLabel2.setOpaque(true);
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, -10, 770, 450);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 90, 770, 533);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        j1.setFont(new java.awt.Font("Bradley Hand ITC", 1, 48)); // NOI18N
        j1.setForeground(new java.awt.Color(153, 0, 0));
        j1.setText("  Eliminate the threat to log in...");
        j1.setOpaque(true);
        jPanel1.add(j1);
        j1.setBounds(0, 0, 780, 90);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 770, 90);

        setSize(new java.awt.Dimension(786, 555));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
        static Logger logger = Logger.getLogger(LoginPage.class);
    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        jLabel8.setVisible(false);
        String user = txtusername.getText();
        String pass = txtpassword.getText();
        User CurrentUser = User.getinstance();
        CurrentUser.setUsername(user);
        CurrentUser.setPassword(pass);

        try {
            logger.info("check user input id valid!");
//        read if the user is in the xml file 
            XMLReaderDOM xml = new XMLReaderDOM();
            if (xml.Authentication(CurrentUser)) {
                logger.info("valid");
//close login frame
                setVisible(false);
                String priv = CurrentUser.getUsertype();
//                Soldier, Platoon Leader, Company Leader, Secretary
        switch(priv) 
        { 
            case "Soldier": 
                java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SoldierHome().setVisible(true);
            }});         
                break; 
            case "Platoon Leader": 
                System.out.println("two"); 
                break; 
            case "Company Leader": 
                System.out.println("three"); 
                break; 
            case "Secretary": 
                System.out.println("three"); 
                break; 
            default: 
           JOptionPane.showMessageDialog(null, "invalid login Privileges!!!", "login error", JOptionPane.ERROR_MESSAGE); 
        } 
//go to the next panel
//if user is soldier go to soldier home
//java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SoldierHome().setVisible(true);
//            }
//        });
              

            } else {
                logger.info("wrong username or passWord!");
                JOptionPane.showMessageDialog(null, "invalid login details", "login error", JOptionPane.ERROR_MESSAGE);
                txtusername.setText(null);
                txtpassword.setText(null);
                jLabel8.setVisible(true);
            }

        } catch (Exception e) {
            logger.warn(e.toString());
            JOptionPane.showMessageDialog(null, "invalid login details", "login error", JOptionPane.ERROR_MESSAGE);
            txtusername.setText(null);
            txtpassword.setText(null);
            jLabel8.setVisible(true);
        }
    }//GEN-LAST:event_jLabel8MouseClicked

    public static void changecolor() {
        tm = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                j1.setBackground(new Color(i, i, i));
                i++;
            }
        });
        tm.start();
    }

//    public static void main(String args[]) {
//                new LoginPage().setVisible(true);
//                changecolor();
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel j1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}

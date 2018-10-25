package army.views;

import army.controller.DbManager;
import com.sun.glass.events.KeyEvent;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Addsoldier extends javax.swing.JFrame {

    String imgpath;

    public Addsoldier() {

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        addsoldier = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        fn = new javax.swing.JTextField();
        platoonid = new javax.swing.JTextField();
        unit = new javax.swing.JTextField();
        rank = new javax.swing.JTextField();
        ln = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        bloodtype = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        drivinglicense = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        position = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        trainingid = new javax.swing.JTextField();
        platoonid7 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        TRAINING_ID = new javax.swing.JLabel();
        id1 = new javax.swing.JTextField();
        fn1 = new javax.swing.JTextField();
        platoonid11 = new javax.swing.JTextField();
        unit1 = new javax.swing.JTextField();
        ln1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        platoonid13 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        platoonid14 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        platoonid15 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        dob1 = new com.toedter.calendar.JDateChooser();
        dob2 = new com.toedter.calendar.JDateChooser();
        platoonid17 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        platoonid18 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        inpum = new javax.swing.JFormattedTextField();
        dob = new com.toedter.calendar.JDateChooser();
        fn2 = new javax.swing.JTextField();
        bimage = new javax.swing.JLabel();
        choose = new javax.swing.JButton();
        TRAINING_ID1 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        platoonid23 = new javax.swing.JTextField();
        platoonid24 = new javax.swing.JTextField();
        platoonid25 = new javax.swing.JTextField();
        unit2 = new javax.swing.JTextField();
        platoonid12 = new javax.swing.JTextField();
        dob3 = new com.toedter.calendar.JDateChooser();
        dob4 = new com.toedter.calendar.JDateChooser();
        ln2 = new javax.swing.JTextField();
        dob5 = new com.toedter.calendar.JDateChooser();
        dob6 = new com.toedter.calendar.JDateChooser();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FILL IN THE INFORMATION");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(null);

        addsoldier.setFont(new java.awt.Font("Tekton Pro", 0, 16)); // NOI18N
        addsoldier.setForeground(new java.awt.Color(0, 153, 102));
        addsoldier.setText("Add Info");
        addsoldier.setToolTipText("add soldier");
        addsoldier.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addsoldier.setOpaque(false);
        addsoldier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addsoldierActionPerformed(evt);
            }
        });
        jPanel1.add(addsoldier);
        addsoldier.setBounds(570, 240, 270, 30);

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Tekton Pro", 3, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 51));
        jButton2.setText("Reset All Values");
        jButton2.setToolTipText("exit");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(570, 280, 270, 30);

        jLabel1.setBackground(new java.awt.Color(204, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel1.setText("ID :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 160, 20, 15);

        jLabel2.setBackground(new java.awt.Color(204, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel2.setText("FIRST NAME :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 180, 90, 15);

        jLabel3.setBackground(new java.awt.Color(204, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel3.setText("RANK :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 220, 50, 15);

        jLabel4.setBackground(new java.awt.Color(204, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel4.setText("LAST NAME :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 200, 80, 15);

        jLabel5.setBackground(new java.awt.Color(204, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel5.setText("PLATOON ID :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 260, 74, 15);

        jLabel6.setBackground(new java.awt.Color(204, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel6.setText("UNIT :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 240, 40, 15);

        id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idKeyTyped(evt);
            }
        });
        jPanel1.add(id);
        id.setBounds(100, 160, 110, 20);

        fn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(fn);
        fn.setBounds(100, 180, 110, 20);

        platoonid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        platoonid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                platoonidKeyTyped(evt);
            }
        });
        jPanel1.add(platoonid);
        platoonid.setBounds(100, 260, 110, 20);

        unit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(unit);
        unit.setBounds(100, 240, 110, 20);

        rank.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(rank);
        rank.setBounds(100, 220, 110, 20);

        ln.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(ln);
        ln.setBounds(100, 200, 110, 20);

        jLabel7.setBackground(new java.awt.Color(204, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel7.setText("DOB:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 280, 50, 15);

        bloodtype.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(bloodtype);
        bloodtype.setBounds(100, 300, 110, 20);

        jLabel8.setBackground(new java.awt.Color(204, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel8.setText("BLOOD TYPE :");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 300, 80, 15);

        drivinglicense.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(drivinglicense);
        drivinglicense.setBounds(130, 320, 80, 20);

        jLabel9.setBackground(new java.awt.Color(204, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel9.setText("DRIVING_LICENSE :");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 320, 110, 15);

        position.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(position);
        position.setBounds(390, 20, 140, 20);

        jLabel10.setBackground(new java.awt.Color(204, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel10.setText("POSITION :");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(250, 20, 70, 15);

        trainingid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        trainingid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                trainingidKeyTyped(evt);
            }
        });
        jPanel1.add(trainingid);
        trainingid.setBounds(390, 40, 140, 20);

        platoonid7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(platoonid7);
        platoonid7.setBounds(390, 60, 140, 20);

        jLabel13.setBackground(new java.awt.Color(204, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel13.setText("PHONE # :");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(250, 40, 60, 15);

        TRAINING_ID.setBackground(new java.awt.Color(204, 255, 255));
        TRAINING_ID.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        TRAINING_ID.setText("Training id :");
        jPanel1.add(TRAINING_ID);
        TRAINING_ID.setBounds(250, 100, 90, 15);

        id1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        id1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                id1KeyTyped(evt);
            }
        });
        jPanel1.add(id1);
        id1.setBounds(390, 80, 140, 20);

        fn1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fn1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fn1KeyTyped(evt);
            }
        });
        jPanel1.add(fn1);
        fn1.setBounds(390, 300, 140, 20);

        platoonid11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(platoonid11);
        platoonid11.setBounds(390, 160, 140, 20);

        unit1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(unit1);
        unit1.setBounds(390, 180, 140, 20);

        ln1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(ln1);
        ln1.setBounds(390, 100, 140, 20);

        jLabel17.setBackground(new java.awt.Color(204, 255, 255));
        jLabel17.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel17.setText("Training end date :");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(250, 140, 120, 15);

        platoonid13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(platoonid13);
        platoonid13.setBounds(390, 200, 140, 20);

        jLabel18.setBackground(new java.awt.Color(204, 255, 255));
        jLabel18.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel18.setText("?????????/");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(210, 440, 70, 19);

        platoonid14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(platoonid14);
        platoonid14.setBounds(390, 220, 140, 20);

        jLabel19.setBackground(new java.awt.Color(204, 255, 255));
        jLabel19.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel19.setText("Sanction duration :");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(250, 220, 120, 15);

        platoonid15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(platoonid15);
        platoonid15.setBounds(390, 240, 140, 20);

        jLabel20.setBackground(new java.awt.Color(204, 255, 255));
        jLabel20.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel20.setText("Sanction reference :");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(250, 240, 130, 15);

        jLabel22.setBackground(new java.awt.Color(204, 255, 255));
        jLabel22.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel22.setText("WEIGHT:");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(250, 60, 50, 15);

        jLabel23.setBackground(new java.awt.Color(204, 255, 255));
        jLabel23.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel23.setText("HEIGHT :");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(250, 80, 50, 15);
        jPanel1.add(dob1);
        dob1.setBounds(390, 140, 139, 20);
        jPanel1.add(dob2);
        dob2.setBounds(390, 120, 139, 20);

        platoonid17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(platoonid17);
        platoonid17.setBounds(390, 260, 140, 20);

        jLabel25.setBackground(new java.awt.Color(204, 255, 255));
        jLabel25.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel25.setText("Training start date :");
        jPanel1.add(jLabel25);
        jLabel25.setBounds(250, 120, 130, 15);

        platoonid18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(platoonid18);
        platoonid18.setBounds(390, 280, 140, 20);

        jLabel26.setBackground(new java.awt.Color(204, 255, 255));
        jLabel26.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel26.setText("Sanction  Id : ");
        jPanel1.add(jLabel26);
        jLabel26.setBounds(250, 200, 100, 15);

        jLabel27.setBackground(new java.awt.Color(204, 255, 255));
        jLabel27.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel27.setText("Sanction status :");
        jPanel1.add(jLabel27);
        jLabel27.setBounds(250, 300, 140, 15);

        jLabel28.setBackground(new java.awt.Color(204, 255, 255));
        jLabel28.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel28.setText("Training reference : ");
        jPanel1.add(jLabel28);
        jLabel28.setBounds(250, 160, 130, 15);

        jLabel29.setBackground(new java.awt.Color(204, 255, 255));
        jLabel29.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel29.setText("Training location :");
        jPanel1.add(jLabel29);
        jLabel29.setBounds(250, 180, 100, 15);

        jLabel30.setBackground(new java.awt.Color(204, 255, 255));
        jLabel30.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel30.setText("Executed :");
        jPanel1.add(jLabel30);
        jLabel30.setBounds(250, 260, 60, 15);

        jLabel31.setBackground(new java.awt.Color(204, 255, 255));
        jLabel31.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel31.setText("Date of commitment :");
        jPanel1.add(jLabel31);
        jLabel31.setBounds(250, 280, 140, 15);

        jLabel32.setBackground(new java.awt.Color(204, 255, 255));
        jLabel32.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel32.setText("Deduction :");
        jPanel1.add(jLabel32);
        jLabel32.setBounds(250, 320, 140, 15);
        jPanel1.add(inpum);
        inpum.setBounds(70, 460, 6, 20);
        jPanel1.add(dob);
        dob.setBounds(100, 280, 110, 20);

        fn2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fn2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fn2KeyTyped(evt);
            }
        });
        jPanel1.add(fn2);
        fn2.setBounds(390, 320, 140, 20);

        bimage.setBackground(new java.awt.Color(255, 255, 255));
        bimage.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        bimage.setOpaque(true);
        jPanel1.add(bimage);
        bimage.setBounds(100, 10, 110, 105);

        choose.setFont(new java.awt.Font("Tekton Pro", 0, 12)); // NOI18N
        choose.setText("CHOOSE IMAGE");
        choose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseActionPerformed(evt);
            }
        });
        jPanel1.add(choose);
        choose.setBounds(103, 120, 110, 30);

        TRAINING_ID1.setBackground(new java.awt.Color(204, 255, 255));
        TRAINING_ID1.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        TRAINING_ID1.setText("Driving license :");
        jPanel1.add(TRAINING_ID1);
        TRAINING_ID1.setBounds(560, 20, 90, 15);

        jLabel33.setBackground(new java.awt.Color(204, 255, 255));
        jLabel33.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel33.setText(" Rest Start date :");
        jPanel1.add(jLabel33);
        jLabel33.setBounds(560, 180, 130, 15);

        jLabel21.setBackground(new java.awt.Color(204, 255, 255));
        jLabel21.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel21.setText(" Rest End date :");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(560, 200, 120, 15);

        jLabel34.setBackground(new java.awt.Color(204, 255, 255));
        jLabel34.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel34.setText("Driving reference :");
        jPanel1.add(jLabel34);
        jLabel34.setBounds(560, 80, 130, 15);

        jLabel35.setBackground(new java.awt.Color(204, 255, 255));
        jLabel35.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel35.setText("Driving location :");
        jPanel1.add(jLabel35);
        jLabel35.setBounds(560, 100, 100, 15);

        jLabel36.setBackground(new java.awt.Color(204, 255, 255));
        jLabel36.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel36.setText("Rest reference :");
        jPanel1.add(jLabel36);
        jLabel36.setBounds(560, 120, 100, 15);

        jLabel24.setBackground(new java.awt.Color(204, 255, 255));
        jLabel24.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel24.setText("Rest type :");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(560, 140, 120, 15);

        jLabel37.setBackground(new java.awt.Color(204, 255, 255));
        jLabel37.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel37.setText("Rest cause :");
        jPanel1.add(jLabel37);
        jLabel37.setBounds(560, 160, 130, 15);

        jLabel41.setBackground(new java.awt.Color(204, 255, 255));
        jLabel41.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel41.setText("Picture :");
        jPanel1.add(jLabel41);
        jLabel41.setBounds(10, 50, 60, 15);

        platoonid23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(platoonid23);
        platoonid23.setBounds(700, 160, 140, 20);

        platoonid24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(platoonid24);
        platoonid24.setBounds(700, 120, 140, 20);

        platoonid25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(platoonid25);
        platoonid25.setBounds(700, 140, 140, 20);

        unit2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(unit2);
        unit2.setBounds(700, 100, 140, 20);

        platoonid12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(platoonid12);
        platoonid12.setBounds(700, 80, 140, 20);
        jPanel1.add(dob3);
        dob3.setBounds(700, 200, 139, 20);
        jPanel1.add(dob4);
        dob4.setBounds(700, 180, 139, 20);

        ln2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(ln2);
        ln2.setBounds(700, 20, 140, 20);
        jPanel1.add(dob5);
        dob5.setBounds(700, 40, 139, 20);
        jPanel1.add(dob6);
        dob6.setBounds(700, 60, 139, 20);

        jLabel43.setBackground(new java.awt.Color(204, 255, 255));
        jLabel43.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel43.setText("Driving Start date :");
        jPanel1.add(jLabel43);
        jLabel43.setBounds(560, 40, 130, 15);

        jLabel44.setBackground(new java.awt.Color(204, 255, 255));
        jLabel44.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel44.setText(" Driving End date :");
        jPanel1.add(jLabel44);
        jLabel44.setBounds(560, 60, 120, 15);

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\ronyl\\Desktop\\icons\\qqqqq.jpg")); // NOI18N
        jLabel11.setOpaque(true);
        jPanel1.add(jLabel11);
        jLabel11.setBounds(0, 290, 900, 220);

        jLabel12.setBackground(new java.awt.Color(204, 255, 204));
        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\ronyl\\Desktop\\icons\\Untitledcolor.png")); // NOI18N
        jLabel12.setOpaque(true);
        jPanel1.add(jLabel12);
        jLabel12.setBounds(0, 0, 900, 330);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 880, 510);

        setSize(new java.awt.Dimension(895, 547));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public boolean checkInputs() {
        System.out.println(fn.getText() + ln.getText() + rank.getText() + id.getText() + unit.getText());
        if (fn.getText().equals("") || ln.getText().equals("") || rank.getText().equals("")
                || id.getText().equals("") || unit.getText().equals("")) {
            //|| date.getDate()==null
            return false;
        } else {
            return true;
        }
    }
    private void chooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseActionPerformed

        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            bimage.setIcon(ResizeImage(path, null));
            imgpath = path;
        } else {
            System.out.println("no file selected");
        }


    }//GEN-LAST:event_chooseActionPerformed
    public ImageIcon ResizeImage(String path, byte[] pic) {
        ImageIcon myimage = null;
        if (path != null) {
            myimage = new ImageIcon(path);
        } else {
            myimage = new ImageIcon(pic);
        }
        Image img = myimage.getImage();
        Image img2 = img.getScaledInstance(bimage.getWidth(), bimage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;

    }

    //Method to create all soldiers not done yet;still need to get reference to the arraylist
//public Soldier createsoldier(){
    // String  fname =id.getText();
    //String  lname =ln.getText();
    //int  sid =Integer.parseInt(id.getText());
    // Soldier x =new Soldier(sid,fname,lname);
    //   return x;}

    private void addsoldierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addsoldierActionPerformed

        if (checkInputs() && imgpath != null) {
            try {
                Connection con = null;
                try {
                    con = DbManager.getConnection();
                } catch (Exception ex) {
                    Logger.getLogger(Addsoldier.class.getName()).log(Level.SEVERE, null, ex);
                }

                PreparedStatement ps = con.prepareStatement("INSERT INTO `soldier`(`soldier_id`,`first_name`,`rank`,`unit`,`platoon_id`,`position`,`driving_license`,`training_id`,`dob`,image,last_name)"
                        + " VALUES (?,?,?,?,?,?,?,?,?,?,?)");

                String abc = id.getText();
                ps.setInt(1, Integer.parseInt(abc));
                ps.setString(2, fn.getText());
                ps.setString(3, rank.getText());
                ps.setString(4, unit.getText());
                String ghi = platoonid.getText();
                ps.setInt(5, Integer.valueOf(ghi));
                ps.setString(6, position.getText());
                ps.setString(7, drivinglicense.getText());
                String def = trainingid.getText();
                ps.setInt(8, Integer.valueOf(def));
                SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
                String adddate = dateformat.format(dob.getDate());
                ps.setString(9, adddate);
                InputStream img = new FileInputStream(new File(imgpath));
                ps.setBlob(10, img);
                ps.setString(11, ln.getText());

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "added");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (FileNotFoundException exa) {
                JOptionPane.showMessageDialog(null, exa.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "cannot be added...one or more fields are empty");
        }
    }//GEN-LAST:event_addsoldierActionPerformed
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);

    }//GEN-LAST:event_jButton2ActionPerformed


    private void idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE) {
            evt.consume();
        }
    }//GEN-LAST:event_idKeyTyped
    private void platoonidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_platoonidKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_platoonidKeyTyped
    private void trainingidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_trainingidKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_trainingidKeyTyped
    private void id1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id1KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_id1KeyTyped
    private void fn1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fn1KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_fn1KeyTyped

    private void fn2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fn2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_fn2KeyTyped

    public static void main(String args[]) {

        new Addsoldier().setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TRAINING_ID;
    private javax.swing.JLabel TRAINING_ID1;
    private javax.swing.JButton addsoldier;
    static javax.swing.JLabel bimage;
    static javax.swing.JTextField bloodtype;
    private javax.swing.JButton choose;
    static com.toedter.calendar.JDateChooser dob;
    static com.toedter.calendar.JDateChooser dob1;
    static com.toedter.calendar.JDateChooser dob2;
    static com.toedter.calendar.JDateChooser dob3;
    static com.toedter.calendar.JDateChooser dob4;
    static com.toedter.calendar.JDateChooser dob5;
    static com.toedter.calendar.JDateChooser dob6;
    static javax.swing.JTextField drivinglicense;
    static javax.swing.JTextField fn;
    static javax.swing.JTextField fn1;
    static javax.swing.JTextField fn2;
    static javax.swing.JTextField id;
    static javax.swing.JTextField id1;
    private javax.swing.JFormattedTextField inpum;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    static javax.swing.JTextField ln;
    static javax.swing.JTextField ln1;
    static javax.swing.JTextField ln2;
    static javax.swing.JTextField platoonid;
    static javax.swing.JTextField platoonid11;
    static javax.swing.JTextField platoonid12;
    static javax.swing.JTextField platoonid13;
    static javax.swing.JTextField platoonid14;
    static javax.swing.JTextField platoonid15;
    static javax.swing.JTextField platoonid17;
    static javax.swing.JTextField platoonid18;
    static javax.swing.JTextField platoonid23;
    static javax.swing.JTextField platoonid24;
    static javax.swing.JTextField platoonid25;
    static javax.swing.JTextField platoonid7;
    static javax.swing.JTextField position;
    static javax.swing.JTextField rank;
    static javax.swing.JTextField trainingid;
    static javax.swing.JTextField unit;
    static javax.swing.JTextField unit1;
    static javax.swing.JTextField unit2;
    // End of variables declaration//GEN-END:variables
}

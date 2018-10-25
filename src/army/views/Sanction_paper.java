package army.views;


import com.sun.glass.events.KeyEvent;

public class Sanction_paper extends javax.swing.JFrame {

  
    public Sanction_paper() {
        initComponents();
    }

   
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        value = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        zz = new javax.swing.JComboBox<>();
        calculate = new javax.swing.JButton();
        توقيف1 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        khedme = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        tekrar = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        totalkhedme = new javax.swing.JLabel();
        totalzourouf = new javax.swing.JLabel();
        totaltekrar = new javax.swing.JLabel();
        totalmoukhelafe = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        khedmeres = new javax.swing.JLabel();
        tekrarres = new javax.swing.JLabel();
        zouroufbox = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("قانونية,عادلة,شخصية,رادعة,فورية");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("التصنيف");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(188, 11, 57, 39);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("فئة");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(147, 19, 23, 22);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jTextField1);
        jTextField1.setBounds(98, 20, 45, 23);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("رقم");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(62, 19, 26, 22);

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jTextField2);
        jTextField2.setBounds(10, 20, 48, 23);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("الجزاء");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(188, 56, 57, 22);

        value.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        value.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                valueKeyTyped(evt);
            }
        });
        jPanel1.add(value);
        value.setBounds(10, 57, 160, 23);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("في ظروف المخالفة");
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(824, 130, 218, 34);

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jTextField4);
        jTextField4.setBounds(824, 170, 218, 221);

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jTextField5);
        jTextField5.setBounds(583, 170, 223, 221);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("في تصريح المعاقب ");
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6);
        jLabel6.setBounds(583, 130, 223, 34);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("في قدر العقوبة  ");
        jLabel7.setOpaque(true);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 130, 541, 34);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("المخالفة بحد ذاتها");
        jLabel8.setOpaque(true);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(418, 183, 133, 22);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("كيفية الخدمة ");
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(418, 213, 133, 22);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("ظروف المخالفة");
        jLabel10.setOpaque(true);
        jPanel1.add(jLabel10);
        jLabel10.setBounds(418, 246, 133, 22);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("التشديد للتكرار");
        jLabel11.setOpaque(true);
        jPanel1.add(jLabel11);
        jLabel11.setBounds(418, 281, 133, 22);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("مع الحسم أو دونه");
        jLabel12.setOpaque(true);
        jPanel1.add(jLabel12);
        jLabel12.setBounds(418, 336, 133, 22);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("المجموع");
        jLabel13.setOpaque(true);
        jPanel1.add(jLabel13);
        jLabel13.setBounds(418, 375, 133, 22);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("20%");
        jLabel14.setOpaque(true);
        jPanel1.add(jLabel14);
        jLabel14.setBounds(82, 183, 318, 24);

        zz.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        zz.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "توقيف", "حجز" }));
        jPanel1.add(zz);
        zz.setBounds(66, 372, 334, 28);

        calculate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        calculate.setText("احتساب");
        calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateActionPerformed(evt);
            }
        });
        jPanel1.add(calculate);
        calculate.setBounds(20, 418, 226, 31);

        توقيف1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        توقيف1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "مع الحسم", "دونه" }));
        jPanel1.add(توقيف1);
        توقيف1.setBounds(20, 333, 380, 28);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("العسكري المعاقب ");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(901, 19, 141, 22);

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jTextField10);
        jTextField10.setBounds(714, 20, 183, 23);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("الرتبة");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(1004, 56, 38, 22);

        jTextField18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jTextField18);
        jTextField18.setBounds(714, 57, 183, 23);

        jLabel17.setForeground(new java.awt.Color(153, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("© Property of First Lt Louis Rony. F ©");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(583, 429, 459, 14);

        khedme.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        khedme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "سيئة للغاية", "سيئة", "متوسطة", "جيدة ,جيدة جدا ,ممتازة,متفوق" }));
        khedme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                khedmeActionPerformed(evt);
            }
        });
        jPanel1.add(khedme);
        khedme.setBounds(160, 214, 240, 23);

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "مخففة", "عادية", "مشددة" }));
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(160, 247, 240, 23);

        tekrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tekrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "لا شيء", "تكرار للمرة الأولى", "تكرار للمرة الثانية", "تكرار للمرة الرابعة وما فوق", " " }));
        tekrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tekrarActionPerformed(evt);
            }
        });
        jPanel1.add(tekrar);
        tekrar.setBounds(160, 282, 240, 23);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("التاريخ                 ");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(630, 58, 66, 22);
        jPanel1.add(jDateChooser1);
        jDateChooser1.setBounds(269, 56, 357, 20);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("النوع");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(662, 19, 34, 22);

        jTextField12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jTextField12);
        jTextField12.setBounds(269, 21, 357, 20);

        totalkhedme.setText("أيام");
        jPanel1.add(totalkhedme);
        totalkhedme.setBounds(21, 220, 43, 14);

        totalzourouf.setText("أيام");
        jPanel1.add(totalzourouf);
        totalzourouf.setBounds(21, 256, 43, 14);

        totaltekrar.setText("أيام");
        jPanel1.add(totaltekrar);
        totaltekrar.setBounds(21, 288, 43, 14);

        totalmoukhelafe.setText("أيام");
        jPanel1.add(totalmoukhelafe);
        totalmoukhelafe.setBounds(21, 190, 43, 14);

        total.setText("أيام");
        jPanel1.add(total);
        total.setBounds(19, 382, 43, 14);

        khedmeres.setText("%");
        jPanel1.add(khedmeres);
        khedmeres.setBounds(82, 220, 60, 14);

        tekrarres.setText("%");
        jPanel1.add(tekrarres);
        tekrarres.setBounds(82, 288, 60, 14);

        zouroufbox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        zouroufbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0%", "5%", "10%", "15%", "20%", "25%", "30%", "35%", "40%", "45%", "50%" }));
        jPanel1.add(zouroufbox);
        zouroufbox.setBounds(82, 247, 58, 23);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("الرقم العسكري");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(929, 86, 113, 22);

        jTextField19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jTextField19);
        jTextField19.setBounds(714, 87, 183, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1071, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void khedmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_khedmeActionPerformed
        
        
        int x=khedme.getSelectedIndex();
        
        if ( x ==0){
       khedmeres.setText("30%"); }else if
            (x==1) {khedmeres.setText("20%");
        }else
        {if (x==2) {khedmeres.setText("10%");}
        else{khedmeres.setText("0%");
        }}
    
        
       
    }//GEN-LAST:event_khedmeActionPerformed

    private void tekrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tekrarActionPerformed
        int x=tekrar.getSelectedIndex();
        
        if ( x ==0){
     tekrarres.setText("0%"); }else if
            (x==1) {tekrarres.setText("1/3%");
        }else
        {if (x==2) {tekrarres.setText("2/3%");}
        else{tekrarres.setText("100%");
        }}
    }//GEN-LAST:event_tekrarActionPerformed

    private void calculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateActionPerformed
      
       
        double xtotalmoukhelafe = Integer.parseInt(value.getText())*0.2;
       totalmoukhelafe.setText(String.valueOf(xtotalmoukhelafe));
       double xtotaltekrar; 
       double xtotalkhedme; 
       double xtotalzourouf;
       
       
       
       if ((khedmeres.getText()).equals("30%")){
     xtotalkhedme =Integer.parseInt(value.getText())*0.3;
       }else if((khedmeres.getText()).equals("20%")){
     xtotalkhedme =Integer.parseInt(value.getText())*0.2;
        }else if((khedmeres.getText()).equals("10%")){
     xtotalkhedme =Integer.parseInt(value.getText())*0.1;
        }else xtotalkhedme=0;
       totalkhedme.setText(String.valueOf(xtotalkhedme));
       
       
       
            
        int x=zouroufbox.getSelectedIndex();
        
        if ( x ==0){xtotalzourouf=0;
                    totalzourouf.setText(String.valueOf(xtotalzourouf));
                    
            }else if
            (x==1) {xtotalzourouf=Integer.parseInt(value.getText())*0.05;
                    totalzourouf.setText(String.valueOf(xtotalzourouf));
            }else if
            (x==2) {xtotalzourouf=Integer.parseInt(value.getText())*0.10;
                    totalzourouf.setText(String.valueOf(xtotalzourouf));
            }else if
            (x==3) {xtotalzourouf=Integer.parseInt(value.getText())*0.15;
                    totalzourouf.setText(String.valueOf(xtotalzourouf));
            }else if
            (x==4) {xtotalzourouf=Integer.parseInt(value.getText())*0.20;
                totalzourouf.setText(String.valueOf(xtotalzourouf));
            }else if
            (x==5) {xtotalzourouf=Integer.parseInt(value.getText())*0.25;
                totalzourouf.setText(String.valueOf(xtotalzourouf));
            }else if
            (x==6) {xtotalzourouf=Integer.parseInt(value.getText())*0.30;
                totalzourouf.setText(String.valueOf(xtotalzourouf));
            }else if
            (x==7) {xtotalzourouf=Integer.parseInt(value.getText())*0.35;
                totalzourouf.setText(String.valueOf(xtotalzourouf));
            }else if
            (x==8) {xtotalzourouf=Integer.parseInt(value.getText())*0.40;
                totalzourouf.setText(String.valueOf(xtotalzourouf));
            }else if
            (x==9) {xtotalzourouf=Integer.parseInt(value.getText())*0.45;
                totalzourouf.setText(String.valueOf(xtotalzourouf));
            }else 
            {xtotalzourouf=Integer.parseInt(value.getText())*0.5;
                totalzourouf.setText(String.valueOf(xtotalzourouf));
            } 
        
        
        
        double fake;
       fake=xtotalkhedme+xtotalzourouf+xtotalmoukhelafe;
        
        
        int y=tekrar.getSelectedIndex();
        if ( y ==0){xtotaltekrar=0;
                    totaltekrar.setText(String.valueOf(xtotaltekrar));
            }else if
            (y==1) {xtotaltekrar= fake/3;
                    totaltekrar.setText(String.valueOf(xtotaltekrar));
            }else if
            (y==2) {xtotaltekrar= fake *2/3;
                    totaltekrar.setText(String.valueOf(xtotaltekrar));
            }else {xtotaltekrar= fake ;
                    totaltekrar.setText(String.valueOf(xtotaltekrar));
            }
        
       double xtotal =fake+xtotaltekrar;
        int z=zz.getSelectedIndex();
        if (z==0){total.setText(String.valueOf(xtotal));
            
        }else{
           double total1= xtotal*2;
            total.setText(String.valueOf(total1));
        }
        
               
      
       
     
    }//GEN-LAST:event_calculateActionPerformed

    private void valueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valueKeyTyped
char c =evt.getKeyChar();
if (!(Character.isDigit(c))||c==KeyEvent.VK_BACKSPACE ||c==KeyEvent.VK_DELETE){
    evt.consume();
    }        
    }//GEN-LAST:event_valueKeyTyped


    public static void main(String args[]) {
       
                new Sanction_paper().setVisible(true);
            
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calculate;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JComboBox<String> khedme;
    private javax.swing.JLabel khedmeres;
    private javax.swing.JComboBox<String> tekrar;
    private javax.swing.JLabel tekrarres;
    private javax.swing.JLabel total;
    private javax.swing.JLabel totalkhedme;
    private javax.swing.JLabel totalmoukhelafe;
    private javax.swing.JLabel totaltekrar;
    private javax.swing.JLabel totalzourouf;
    private javax.swing.JTextField value;
    private javax.swing.JComboBox<String> zouroufbox;
    private javax.swing.JComboBox<String> zz;
    private javax.swing.JComboBox<String> توقيف1;
    // End of variables declaration//GEN-END:variables
}

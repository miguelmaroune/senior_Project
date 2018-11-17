
package army.views;
import com.sun.javafx.tk.Toolkit;
import java.awt.datatransfer.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Gui_encryption extends javax.swing.JFrame {

    Cipher c;
    Key symKey;
    static String algorithm = "DESede";
    static String s ;
    byte[] encryptionBytes;
    static String result;
  

   
    public Gui_encryption() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        initComponents();
symKey = KeyGenerator.getInstance(algorithm).generateKey();
c = Cipher.getInstance(algorithm);
	      } 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        encrypt = new javax.swing.JButton();
        decrypt = new javax.swing.JButton();
        input = new javax.swing.JTextField();
        inputlabel = new javax.swing.JLabel();
        outputlabel = new javax.swing.JLabel();
        decryptlabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Encryption tool");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        encrypt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        encrypt.setText("encrypt");
        encrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptActionPerformed(evt);
            }
        });
        jPanel1.add(encrypt);
        encrypt.setBounds(10, 260, 130, 20);

        decrypt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        decrypt.setText("decrypt");
        decrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decryptActionPerformed(evt);
            }
        });
        jPanel1.add(decrypt);
        decrypt.setBounds(170, 260, 140, 20);
        jPanel1.add(input);
        input.setBounds(10, 47, 302, 205);

        inputlabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        inputlabel.setText("Input");
        jPanel1.add(inputlabel);
        inputlabel.setBounds(130, 20, 80, 22);

        outputlabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        outputlabel.setText("Output");
        jPanel1.add(outputlabel);
        outputlabel.setBounds(480, 20, 80, 22);

        decryptlabel.setBackground(new java.awt.Color(255, 255, 255));
        decryptlabel.setText("Result will show here");
        decryptlabel.setOpaque(true);
        jPanel1.add(decryptlabel);
        decryptlabel.setBounds(346, 47, 302, 205);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Copy content to clipboard");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(350, 260, 300, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/army/icons/Operational_Camouflage_Pattern_(OCP),_Scorpion_W2_swatch.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 660, 300);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 658, 300);

        setSize(new java.awt.Dimension(674, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void encryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryptActionPerformed
    
     s=input.getText();
        try {
            encryptionBytes = army.handler.Encrypt.encryptF(s,symKey,c);
            result=encryptionBytes.toString();
            System.out.println(encryptionBytes);  
            decryptlabel.setText(result);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Gui_encryption.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Gui_encryption.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Gui_encryption.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_encryptActionPerformed
    private void decryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decryptActionPerformed
s=input.getText(); 
        try {
          decryptlabel.setText( army.handler.Encrypt.decryptF(encryptionBytes,symKey,c)); 
            
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Gui_encryption.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Gui_encryption.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Gui_encryption.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_decryptActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
String myString =decryptlabel.getText() ;
StringSelection stringSelection = new StringSelection(myString);
Clipboard clipboard = getToolkit().getSystemClipboard();
clipboard.setContents(stringSelection, null);      
    }//GEN-LAST:event_jButton1ActionPerformed

/*String example = "This is an example";
		    byte[] bytes = example.getBytes();

		    System.out.println("Text : " + example);
		    System.out.println("Text [Byte Format] : " + bytes);
		    System.out.println("Text [Byte Format] : " + bytes.toString());

		    String s = new String(bytes);
		    System.out.println("Text Decryted : " + s);
		    
Output

Text : This is an example
Text [Byte Format] : [B@187aeca
Text [Byte Format] : [B@187aeca
Text Decryted : This is an example    
*/    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton decrypt;
    private javax.swing.JLabel decryptlabel;
    private javax.swing.JButton encrypt;
    private javax.swing.JTextField input;
    private javax.swing.JLabel inputlabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel outputlabel;
    // End of variables declaration//GEN-END:variables

}

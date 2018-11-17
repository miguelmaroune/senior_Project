package army.handler;


	import java.security.InvalidKeyException;
	import java.security.Key;
	import javax.crypto.BadPaddingException;
	import javax.crypto.Cipher;
	import javax.crypto.IllegalBlockSizeException;
        import javax.crypto.KeyGenerator;

	public class Encrypt {

	    public static byte[] encryptF(String input,Key pkey,Cipher c) throws InvalidKeyException, BadPaddingException,IllegalBlockSizeException {
	 	  c.init(Cipher.ENCRYPT_MODE, pkey);
	 	  byte[] inputBytes = input.getBytes();
            	  return c.doFinal(inputBytes);
	    }

	    public static String decryptF(byte[] encryptionBytes,Key pkey,Cipher c) throws InvalidKeyException,BadPaddingException, IllegalBlockSizeException {
	 	  c.init(Cipher.DECRYPT_MODE, pkey);
	 	  byte[] decrypt = c.doFinal(encryptionBytes);
	 	  String decrypted = new String(decrypt);
	 	  return decrypted;
	    }

	}
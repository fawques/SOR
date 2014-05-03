/**
 * 
 */
package seguridad;


/*
 * Copyright (c) 2000 David Flanagan.  All rights reserved.
 * This code is from the book Java Examples in a Nutshell, 2nd Edition.
 * It is provided AS-IS, WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, and modify it for any non-commercial purpose.
 * You may distribute it non-commercially as long as you retain this notice.
 * For a commercial use license, or to purchase the book (recommended),
 * visit http://www.davidflanagan.com/javaexamples2.
 */

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.CharSet;
import org.bouncycastle.jcajce.provider.symmetric.ARC4.Base;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * This class defines methods for encrypting and decrypting using the Triple DES
 * algorithm and for generating, reading and writing Triple DES keys. It also
 * defines a main() method that allows these methods to be used from the command
 * line.
 */
public class TripleDes {
	
	/*public TripleDes(){
		// This is where we'll read the key from or write it to
		File keyfile = new File("pepe.txt");
		System.out.print("Generating key. This may take some time...");
		System.out.flush();
		SecretKey key;
		try {
			key = generateKey();
			try {
				writeKey(key, keyfile);
			} catch (NoSuchAlgorithmException | InvalidKeySpecException
					| IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("done.");
		System.out.println("Secret key written to " + "pepe.txt"
				+ ". Protect that file carefully!");
	}*/
	/**
	 * The program. The first argument must be -e, -d, or -g to encrypt,
	 * decrypt, or generate a key. The second argument is the name of a file
	 * from which the key is read or to which it is written for -g. The -e and
	 * -d arguments cause the program to read from standard input and encrypt or
	 * decrypt to standard output.
	 */
	public static void main(String[] args) {
		// This is where we'll read the key from or write it to
				File keyfile = new File("pepe.txt");
				//System.out.print("Generating key. This may take some time...");
				//System.out.flush();
				SecretKey key;
				try {
					key = generateKey();
					try {
						writeKey(key, keyfile);
					} catch (NoSuchAlgorithmException | InvalidKeySpecException
							| IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println("done.");
				//System.out.println("Secret key written to " + "pepe.txt"+ ". Protect that file carefully!");
				
				/*encriptado*/
				SecretKey key2;
				try {
					key2 = readKey(keyfile);
					try {
						String cifrado = encrypt(key2, "pedro martinez calvoo");
						//System.out.println("ESTimado, esta es la clave de cifrado: " + key2);
						//System.out.println("ESTimado, este es el cifrado: " + cifrado);
						decrypt(key2,cifrado);
					} catch (NoSuchPaddingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (InvalidKeyException | NoSuchAlgorithmException
						| InvalidKeySpecException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	public SecretKey generarClaveGuardar(File keyfile) {
		
		//System.out.print("Generating key. This may take some time...");
		//System.out.flush();
		SecretKey key = null;
		try {
			key = generateKey();
			try {
				writeKey(key, keyfile);
			} catch (NoSuchAlgorithmException | InvalidKeySpecException
					| IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("done.");
		//System.out.println("Secret key written to " + "pepe.txt"+ ". Protect that file carefully!");
		return key;
	}
	
	/** Generate a secret TripleDES encryption/decryption key */
	public static SecretKey generateKey() throws NoSuchAlgorithmException {
		// Get a key generator for Triple DES (a.k.a DESede)
		KeyGenerator keygen = KeyGenerator.getInstance("DESede");
		// Use it to generate a key
		return keygen.generateKey();
	}

	/** Save the specified TripleDES SecretKey to the specified file */
	public static void writeKey(SecretKey key, File f) throws IOException,
	NoSuchAlgorithmException, InvalidKeySpecException {
		// Convert the secret key to an array of bytes like this
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
		DESedeKeySpec keyspec = (DESedeKeySpec) keyfactory.getKeySpec(key,
				DESedeKeySpec.class);
		byte[] rawkey = keyspec.getKey();

		//System.out.println("ESTimado, esta es rawkey: " + rawkey);
		
		// Write the raw key to the file
		FileOutputStream out = new FileOutputStream(f);
		out.write(rawkey);
		out.close();
	}

	/** Read a TripleDES secret key from the specified file */
	public static SecretKey readKey(File f) throws IOException,
	NoSuchAlgorithmException, InvalidKeyException,
	InvalidKeySpecException {
		// Read the raw bytes from the keyfile
		DataInputStream in = new DataInputStream(new FileInputStream(f));
		byte[] rawkey = new byte[(int) f.length()];
		in.readFully(rawkey);
		in.close();

		// Convert the raw bytes to a secret key like this
		DESedeKeySpec keyspec = new DESedeKeySpec(rawkey);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
		SecretKey key = keyfactory.generateSecret(keyspec);
		return key;
	}

	/**
	 * Use the specified TripleDES key to encrypt bytes from the input stream
	 * and write them to the output stream. This method uses CipherOutputStream
	 * to perform the encryption and write bytes at the same time.
	 */
	public static String encrypt(SecretKey key, String in)
			throws NoSuchAlgorithmException, InvalidKeyException,
			NoSuchPaddingException, IOException {
		if(key != null && seguridad.Config.isCifradoSimetrico()){
			// Create and initialize the encryption engine
			Cipher cipher = Cipher.getInstance("DESede");
			cipher.init(Cipher.ENCRYPT_MODE, key);
	
			byte[] encryptedString;
			try {
				/*Base64 b64 = new Base64();
				encryptedString = cipher.doFinal(in.getBytes("iso-8859-1"));
				return b64.encodeToString(encryptedString);*/
				 BASE64Encoder encoder = new BASE64Encoder();
			        encryptedString = cipher.doFinal(in.getBytes());
			        String decriptedString = encoder.encodeBuffer(encryptedString);
			        return decriptedString;
			} catch (IllegalBlockSizeException | BadPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}else{
			return in;
		}
	}

	/**
	 * Use the specified TripleDES key to decrypt bytes ready from the input
	 * stream and write them to the output stream. This method uses uses Cipher
	 * directly to show how it can be done without CipherInputStream and
	 * CipherOutputStream.
	 */
	public static String decrypt(SecretKey key,String encryptedString) {
		if(seguridad.Config.isCifradoSimetrico()){
		    String decryptedText=null;
		    try {
		    	Cipher cipher = Cipher.getInstance("DESede");
		    	cipher.init(Cipher.DECRYPT_MODE, key);
		    	
		 
		        
		        
		        BASE64Decoder decode = new BASE64Decoder();
		        byte[] results = cipher.doFinal(decode.decodeBuffer(encryptedString));
		        String decriptedString = new String(results, "UTF-8");
		        return decriptedString;
		    } catch (Exception e) {
		    	
		        e.printStackTrace();
		    }
		    return decryptedText;
	    }else{
	    	return encryptedString;
	    }
	}
}

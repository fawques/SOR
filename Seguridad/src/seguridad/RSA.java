/**
 * 
 */
package seguridad;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * Simple RSA public key encryption algorithm implementation.
 * http://www.java2s.com/Tutorial/Java/0490__Security/RSAexamplewithrandomkeygeneration.htm
 */
public class RSA {
	RSAPublicKeySpec pubKeySpec;
	RSAPrivateKeySpec privKeySpec;
	KeyFactory keyFactory;
	RSAPublicKey pubKey;
	RSAPrivateKey privKey;
	Cipher cipher;

	public RSA() {
		try {
		    try {
				cipher = Cipher.getInstance("RSA/None/NoPadding", "BC");
				keyFactory = KeyFactory.getInstance("RSA", "BC");
		    	pubKeySpec = new RSAPublicKeySpec(new BigInteger("12345678", 16), new BigInteger("11", 16));
			    privKeySpec = new RSAPrivateKeySpec(new BigInteger("12345678", 16), new BigInteger("12345678",16));
			    try {
					pubKey = (RSAPublicKey) keyFactory.generatePublic(pubKeySpec);
				    privKey = (RSAPrivateKey) keyFactory.generatePrivate(privKeySpec);
				} catch (InvalidKeySpecException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NoSuchPaddingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	String encrypt(String input){
		try {
			cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		    byte[] cipherText;
			try {
				cipherText = cipher.doFinal(input.getBytes());
			    System.out.println("cipher: " + new String(cipherText));
			    return new String(cipherText);
			} catch (IllegalBlockSizeException | BadPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	String decrypt(String cipherText){
		try {
			cipher.init(Cipher.DECRYPT_MODE, privKey);
		    byte[] plainText;
			try {
				plainText = cipher.doFinal(cipherText.getBytes());
			    System.out.println("plain : " + new String(plainText));
			    return new String(plainText);
			} catch (IllegalBlockSizeException | BadPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

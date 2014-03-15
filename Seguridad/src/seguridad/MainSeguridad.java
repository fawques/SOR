/**
 * 
 */
package seguridad;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.cert.Certificate;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Date;

import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.x509.X509V3CertificateGenerator;

/**
 * @author pablovm1990
 * 
 */
public class MainSeguridad {

	RSAPublicKeySpec pub;
	RSAPrivateKeySpec priv;
	/**
	 * Debera llamarse desde el inicio de gestion para que inicie una
	 * comunicaci—n segura
	 */
	public MainSeguridad(String nombreUsuario) {
		// TODO Auto-generated constructor stub
		generateKeys(nombreUsuario);	
	}

	public boolean generateKeys(String nombreUsuario) {
		KeyPairGenerator kpg;
		try {
			kpg = KeyPairGenerator.getInstance("RSA");
			kpg.initialize(2048);

			KeyPair kp = kpg.genKeyPair();

			KeyFactory fact = KeyFactory.getInstance("RSA");
			pub = fact.getKeySpec(kp.getPublic(),RSAPublicKeySpec.class);

			priv = fact.getKeySpec(kp.getPrivate(),
					RSAPrivateKeySpec.class);
			// CREATE A KEYSTORE OF TYPE "Java Key Store"
			KeyStore ks;
			try {
				ks = KeyStore.getInstance("JKS");
				X509Certificate certificate = generateCertificate(kp);  
				KeyStore keyStore = KeyStore.getInstance("JKS");   
				Certificate[] certChain = new Certificate[1];  
				certChain[0] = (Certificate) certificate;
				ks.setKeyEntry("key1"+nombreUsuario, kp.getPrivate().getEncoded(), certChain);
				try {
					ks.load(null, null);
					ks.store(new FileOutputStream("clavesSor"+nombreUsuario), //habria que generarlo donde lo pida
							"Albentosa".toCharArray());
				} catch (NoSuchAlgorithmException | CertificateException
						| IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					keyStore.load(null,null);
				} catch (NoSuchAlgorithmException | CertificateException
						| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (KeyStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		

		
		return false;
	}

	public X509Certificate generateCertificate(KeyPair keyPair) {
		X509V3CertificateGenerator cert = new X509V3CertificateGenerator();
		cert.setSerialNumber(BigInteger.valueOf(1)); // or generate a random
														// number
		cert.setSubjectDN(new X509Principal("CN=localhost")); // see examples to
																// add O,OU etc
		cert.setIssuerDN(new X509Principal("CN=localhost")); // same since it is
																// self-signed
		cert.setPublicKey(keyPair.getPublic());
		cert.setNotBefore(new Date());
		cert.setNotAfter(new Date());
		cert.setNotAfter(new Date(2015, 1, 1));
		cert.setSignatureAlgorithm("SHA1WithRSAEncryption");
		PrivateKey signingKey = keyPair.getPrivate();
		try {
			return cert.generate(signingKey, "BC");
		} catch (CertificateEncodingException | InvalidKeyException
				| IllegalStateException | NoSuchProviderException
				| NoSuchAlgorithmException | SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

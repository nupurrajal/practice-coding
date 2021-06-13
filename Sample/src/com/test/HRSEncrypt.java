package com.test;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class HRSEncrypt {

	private PrivateKey privateKey;
	private PublicKey publicKey;
	static File file = new File("publicKey.pem");

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException {
		encrypt("55137321");

	}

	static String readPubKey(File file) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
		String key = new String(Files.readAllBytes(file.toPath()), Charset.defaultCharset());
    	
    	String publicKeyPEM = key
    		      .replace("-----BEGIN PUBLIC KEY-----", "")
    		      .replaceAll(System.lineSeparator(), "")
    		      .replace("-----END PUBLIC KEY-----", "");
    	
//    	byte[] encoded = Base64.getDecoder().decode(publicKeyPEM);
//
//        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encoded);
//        return (PublicKey) keyFactory.generatePublic(keySpec);
    	return publicKeyPEM;
    }
	
	
	static byte[] encrypt (String input) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		File file = new File("src/com/test/publicKey.pem");
//		PublicKey publicKey = readPubKey(file);
//		KeyFactory factory = KeyFactory.getInstance("RSA");
//		
//		Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
//		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
//
//		byte[] cipherData = cipher.doFinal(input.getBytes());
//		
//		return cipherData;
		SecretKey key = new SecretKeySpec(readPubKey(file).getBytes(), "RSA");
		Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] encrypted = cipher.doFinal(input.getBytes());
		return null;
	}
}

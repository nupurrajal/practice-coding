package com.test;

public class Receiver {

//	private static String secret_key = "This is a secret_key";
	
//	public static void main(String[] args) {
//		String data = "Temp string to test!";
//		String data1 = "{\"activity\":\"RESCHEDULE\",\"datetime\":\"2020-08-25 16:40:00\",\"doctormobileno\":\"9009484694\",\"jhhid\":\"TUCE-6326\",\"orderid\":\"JIOHH1597645287\",\"patientmobileno\":\"9326715350\",\"reason\":\"\"}";
//		String secret_key = "This is a secret";
//		try {
//			//System.out.println("Final: " + generateSHAHash(data1));
//
//			decryptString("VVm76fwxipTy4wz+VPlg0GRHdqkEnlm/6/j+amMqZezd5HTqTax2vRzUyNrryMu2bXO+YVT7qKVjwNNPbbyZ/YV7h0YrssPbTXXH5POmO1BD172g/fDsxKqr+lEvWoeVKVKi7pIqjg8Zb+TVldYX+8jI0S6VtqPi/sB6EyzqmVlKfTtOIpu+abDXgED2ACNGnbWrrq2gU/xAiAiOUcX6vMi9qxwCjmIOTmoxc05JMSFiI+CC9akjDxk3uyhiIpD7");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static String generateSHAHash(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
//		String result = "";
//		try {
//			//MessageDigest digest = MessageDigest.getInstance("SHA-256");
//
//			// part 1 : integrity (calculate hash with a key) and send it for vendor to verify, put the hash generated in header as checksum
//			// Mac mac = Mac.getInstance("HmacSHA256");
////
//// 			SecretKeySpec spec = new SecretKeySpec(key_s.getBytes(), "HmacSHA256");
//// 			byte[] hash = null;
//// 			try {
//// 				mac.init(spec);
//// //				hash = input.getBytes("UTF-8");
//// 				hash = mac.doFinal(input.getBytes("UTF-8"));
//// 			} catch (InvalidKeyException e) {
//// 				// TODO Auto-generated catch block
//// 				e.printStackTrace();
//// 			}
//// 			System.out.println("Hash generated for payload with key " + Arrays.toString(key_s.getBytes()) + " is :" + bytesToHex(hash) + " SHA-Hashing : ");
//// 			//return result;
//
//			// part 2 : encrypt the payload with some encryption algorithm here.
//			SecretKey key = new SecretKeySpec("my_secret_key_12".getBytes(), "AES");//generateKey(); //new SecretKeySpec(new String("ENCRYPTION_KEY_A").getBytes(), "AES");
//
//			String keyHex  = bytesToHex(key.getEncoded());
//			System.out.println("Key HEX - " + keyHex);
//			System.out.println("Key: " + key.toString());
//			Cipher cipher = Cipher.getInstance("AES");
//			cipher.init(Cipher.ENCRYPT_MODE, key);
//
//			byte[] encrypted = cipher.doFinal(input.getBytes(StandardCharsets.UTF_8));
//			String ciphertext = Base64.getEncoder().encodeToString(encrypted);
//			System.out.println("Encrypted String : " + ciphertext);
//			System.out.println("https://qa3files.healthhub.net.in/rfhintegrationservice1/v1/sendAppointmentDetails".length());
//
//
//
//			cipher.init(Cipher.DECRYPT_MODE, key);
//			byte[] plaintext = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
//			// System.out.println(new String(plaintext));
//			return new String(plaintext);
//		} catch (NoSuchAlgorithmException e) {
//			throw new NoSuchAlgorithmException();
//		}
//	}
//
//	private static SecretKey generateKey() throws NoSuchAlgorithmException {
//		KeyGenerator generator = KeyGenerator.getInstance("AES");
//		SecureRandom random = new SecureRandom();
//		generator.init(256, random);
//		SecretKey key = generator.generateKey();
//		return key;
//	}
//
//	private static String bytesToHex(byte[] data) {
//		return Hex.encodeHexString(data);
//	}
//
//	private static void decryptString(String encryptMsg) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
//		Cipher cipher = Cipher.getInstance("AES");
//		SecretKey key = new SecretKeySpec("1234567890123456".getBytes(), "AES");//generateKey(); //new SecretKeySpec(new String("ENCRYPTION_KEY_A").getBytes(), "AES");
//
//		cipher.init(Cipher.DECRYPT_MODE, key);
//		byte[] plaintext = cipher.doFinal(Base64.getDecoder().decode(encryptMsg));
//
//		System.out.println("Decrypted ----- " + new String(plaintext));
//
//	}
}


// 9b806ecfa81b5b99b446ea792e159c0d
package temp;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class EncDecryptionService {
	
	//private static final Logger logger = LoggerFactory.getLogger(EncDecryptionService.class);
	
	
	byte[] ivbyte = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	IvParameterSpec iv = new IvParameterSpec(ivbyte);
	
	
	public String encrypt(String key, String input) {
		
		String encryptedString = null;
		
		try {

			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] dig = md.digest(key.getBytes(StandardCharsets.UTF_8));

			// 1. Digest secret key (symmetric key) with SHA256
			SecretKeySpec skeySpec = new SecretKeySpec(dig, "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");

			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

			// Encryption start

			// 2. Encrypt parameters with digest secret key
			byte[] encryptedText = cipher.doFinal(input.getBytes());

			// 3. Encode this encrypted parameters with Base64 encode.
			encryptedString = new String(Base64.getEncoder().encode(encryptedText));
		}
		catch(Exception e) {
			
		}
		
		
		return encryptedString;
		
	}
	
	
	public String decrypt(String key, String input) {
		
		String decryptedString = null;
		
		try {

			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] dig = md.digest(key.getBytes(StandardCharsets.UTF_8));

			// 1. Digest secret key (symmetric key) with SHA256
			SecretKeySpec skeySpec = new SecretKeySpec(dig, "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");

			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

			// 2. Decode this encrypted parameters with Base64 decode

			byte[] basedecodedEncrypted = Base64.getDecoder().decode(input);

			// 3.	Decrypt parameters with digest secret key.
 
			byte[] original = cipher.doFinal(basedecodedEncrypted);

			decryptedString =  new String(original);
		}
		catch(Exception e) {
			
		}
		
		
		return decryptedString;
		
	}

		
	public static void main(String args[]) {
		
		EncDecryptionService encDecryptionService = new EncDecryptionService();
		
		String secretkey = "27649041174535";
		
		//String data = "xLY+UrkDa/TUCHQ/G0GblkRSHgV8zCIl4Ni+fmHTmHiVpJ32zLh4VgPtGbZreohG+ECOOHhMH5e8NwD4HHlhz1dF1NdRQch/Vo1k/G/B0V7MMMrKWtSwdm7gBoXSgRLG9vshHe0Vcq1T+XTomM8t0vHUihMHqgKqK06a29AEsibqh+ZvNdzLw0f+lnGGloEzQy+vMyhGPLgirJEB+S+pFDOWEv586roC9OJswYtRclJIXH1RpfaucxP6fMY9vxFlC7/0k6CKJzPIBip9r5eUeaLka376j1H1nW6+LjimrwGvRqv70JBFfs/TRYNewDrt";
		Scanner sc = new Scanner(System.in);
		String data = sc.next();
		System.out.println("data "+encDecryptionService.decrypt(secretkey, data));
		
		
	}

}

package criptologia.model;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;

public class Remetente {
	

	public static String Asignature(String file) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
		
		byte[] file1=file.getBytes();
		String PKeyFile = "src\\ChavePrivada.der";
		Path pathPKey = Paths.get(PKeyFile);
		byte[] encodedPrivateKey = Files.readAllBytes(pathPKey);
		
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	    PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encodedPrivateKey);
	    RSAPrivateKey privateKey = (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
	    
	    
	    Signature signature = Signature.getInstance("SHA1withRSA");
	    signature.initSign(privateKey);
	    signature.update(file1);
	    
	    
	    byte[] signatureBytes = signature.sign();
	    String encoded = new String(Base64.encodeBase64(signatureBytes));
	    //System.out.println(encoded);
	    return encoded;
	}

	
	public static boolean verify(String file) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, SignatureException, IOException {
		RSAPublicKey publick = Chaves.Publickey();
		byte[] file1=file.getBytes();
		Signature sign=null;
		
		sign = Signature.getInstance("SHA1withRSA");
		sign.initVerify(publick);
		
		String data="iMtcCh4oggYWjXXQaSiqQzRGh0/RpAEJRu64YlanykGYHIKw7//RxfocLSDzATKps+LjUz2A4jpNKuuSzGMHF4bRxZbex2wilpDA6NUpoEfgwO853xIoGY6sS9AcLjpGgQBbUjcJpJYyAe7Iarza4yMvx58n1elJhkjocECQ+Zg=";
		sign.update(file1);
		
		byte[] ciphertext = Base64.decodeBase64(data.getBytes());
		//
		System.out.println(sign.verify(ciphertext));
	    return sign.verify(ciphertext);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static String encondingBase64(String hashtext) {
		String encodedString = new String(Base64.encodeBase64(hashtext.getBytes()));
		return encodedString;
	}

	public static String decondingBase64(String hashtext) {
		String decodedString = new String(Base64.decodeBase64(hashtext.getBytes()));
		return decodedString;
	}

	public static String getValorCaracterHash(String str) {
		return ""+str.charAt(0) + str.charAt(10) + str.charAt(20) + str.charAt(30)+"-Processado por programa validado n.º";
	}
}

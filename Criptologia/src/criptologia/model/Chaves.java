package criptologia.model;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Chaves {
	public static RSAPublicKey Publickey() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException,
			InvalidKeyException, SignatureException {
	String PKeyFile = "src\\ChavePublica.pem";
	Path pathPKey = Paths.get(PKeyFile);
	String key = new String(Files.readAllBytes(pathPKey), Charset.defaultCharset());
	String publicKeyPEM = key.replace("-----BEGIN PUBLIC KEY-----", "").replaceAll(System.lineSeparator(), "")
				.replace("-----END PUBLIC KEY-----", "");
	byte[] encoded = Base64.getDecoder().decode(publicKeyPEM);
	KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encoded);
	RSAPublicKey pubickey = (RSAPublicKey) keyFactory.generatePublic(keySpec);
	System.out.println(pubickey);
	return pubickey;
	}

	public static RSAPrivateKey Private() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException,
			InvalidKeyException, SignatureException {
		String PKeyFile = "src\\ChavePrivada.der";
		Path pathPKey = Paths.get(PKeyFile);
		byte[] encodedPrivateKey = Files.readAllBytes(pathPKey);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encodedPrivateKey);
		return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
	}
}

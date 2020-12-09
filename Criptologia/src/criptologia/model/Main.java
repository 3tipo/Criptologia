package criptologia.model;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;


//https://www.geeksforgeeks.org/sha-256-hash-in-java/
//https://www.geeksforgeeks.org/basic-type-base64-encoding-and-decoding-in-java/
/*eSCREVE OS DADOS NO FICHEIRO->  https://github.com/eugenp/tutorials/blob/master/libraries-security/src/main/java/com/baeldung/digitalsignature/level1/DigitalSignatureWithMessageDigestAndCipherSigning.java
 * https://www.codeflow.site/pt/article/java-digital-signature#
 * https://www.geeksforgeeks.org/sha-1-hash-in-java/
 * https://metamug.com/article/security/sign-verify-digital-signature-ecdsa-java.html
 * https://gist.github.com/nielsutrecht/855f3bef0cf559d8d23e94e2aecd4ede
 * */
public class Main {
	public static void main(String[] args) {
		String file = "18-05-2018" + ";" + "2018-05-18T11:22:19" + ";" + "Fac 001/18" + ";" + "53.00" + ";";
		try {
			String sms = Remetente.Asignature(file);
			// String file1=file+x;
			// String x1=Remetente.Asignature(file1);
			System.err.println(Remetente.getValorCaracterHash(sms));
		} catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | SignatureException
				| IOException e) {
			e.printStackTrace();
		}
	}
}

















































//byte[] primarykey="MIICXQIBAAKBgQDmoN56693wV6/vY5hH+fbCAkTxqP/GGjihp5sBhjbTH/6jz2Ou8OFLbAjRoqxqPJWASgLnX1N1uTbCkLmre60MUJ8l11qmhT9/aeIBfy1FQ6vX3XGkEan4DR0APoe+1uwSHFMF2b7Q5ESSQRxZl2BmmW0A2yPQmwOWWPjrWR328QIDAQABAoGARmUsA5EjOU1KomNgA/hEXYubx7ex+qHeT1l9csWozmChtRaEcs2Ltx3Ow05IGlVLvNDaeg0ayIA0Osc6JSGm+9rd5VjBIczr3tJ4VrP64VtKnhW3nUGOnUHxwNuIzt+p84HVnF7nY4qaZYmy9wgxnmUk2QMXV+qZLxEaa4QyYcECQQD8jiKm3S59fwKcOdInsT8txu+U2HyjhGr4oAa/69cCyAw9ZL3I/t0YDt0f7IpR8xRuue1FWxoMgxCrt+uSs7llAkEA6cYrmGy/kTnptIiV+R8Y5UOkWbmfGNCkd3NdwkKzwzzPM/FTHacYENSZR/tu5EKyrOKAd2yIdgTtxHmbaN30nQJBANyW4RlR8ztV5lfCARb+L6qyKayeci74h95lF8AmJASf6mDtTv7x7PcIdIdfuWjeoigcaWu8qMHo8HSsDixyoikCQFXosZSuQigIdE4X86U9PFTkar1ebY0c/5O2HbqJ8K3K5wpboQPAqCNnPX0qdTIFIMxP4I4CoJNedFJDrkz3ZDECQQC/KnRWKKP1Kqlz4HhsoHm1/oe4MXKxnUaoAh+a99fOV7ZPemtNCVzUxKMwPuikbP3QVWfnmuryWDEcpotmbmp2".getBytes();
//"C:\\Windows\\System32\\ChavePrivada.der";   
//String resultado =Remetente.encryptThisStringAndEncoding64(file1);
//System.out.println(resultado);
//System.out.println("\n"+Remetente.getValorCaracterHash("iMtcCh4oggYWjXXQaSiqQzRGh0/RpAEJRu64YlanykGYHIKw7//RxfocLSDzATKp\r\n" + 
	//	"s+LjUz2A4jpNKuuSzGMHF4bRxZbex2wilpDA6NUpoEfgwO853xIoGY6sS9AcLjpG\r\n" + 
	//	"gQBbUjcJpJYyAe7Iarza4yMvx58n1elJhkjocECQ+Zg="));
//System.out.println( Remetente.encondingBase64("SW5kaWEgVGVhbSB3aWxsIHdpbiB0aGUgQ3Vw"));
//System.err.println( Remetente.decondingBase64("SW5kaWEgVGVhbSB3aWxsIHdpbiB0aGUgQ3Vw"));

//FileOutputStream fos = new FileOutputStream("signature-java");
//fos.write(signatureBytes);
//fos.close();

/*
String key = new String(Files.readAllBytes(path), Charset.defaultCharset());

 String privateKeyPEM = key
   .replace("-----BEGIN PRIVATE KEY-----", "")
   .replaceAll(System.lineSeparator(), "")
   .replace("-----END PRIVATE KEY-----", "");

 String encoded = new String(Base64.decodeBase64(privateKeyPEM.getBytes()));

 KeyFactory keyFactory = KeyFactory.getInstance("RSA");
PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded.getBytes());
System.out.println((RSAPrivateKey) keyFactory.generatePrivate(keySpec));

*/   


/*byte[] file1="18-05-2018;2018-05-18T11:22:19;Fac 001/18;53.00;".getBytes();
	   //localizar o ficheiro da chave privada
	   String privateKeyFile = "src\\ChavePrivada.der";
	   Path pathPrivateKey = Paths.get(privateKeyFile);
	   
	   //localizar o ficheiro do texto
	   String file = "C:\\Windows\\System32\\Registo1.txt";   
	   Path pathfile = Paths.get(file);
	  	   
	   byte[] encodedPrivateKey = Files.readAllBytes(pathPrivateKey);//ler todos os bytes dentro do ficheiro ChavePrivada.der
       byte[] content = Files.readAllBytes(pathfile);//ler todos os bytes dentro do ficheiro Registo1.txt

       //extraimos a chave privada a partir dos bytes do arquivo .der
       KeyFactory keyFactory = KeyFactory.getInstance("RSA");
       PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encodedPrivateKey);
       RSAPrivateKey privateKey = (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
       
       System.err.println(privateKey);
       System.out.println();
       
       //ESTAMOS A ENCRIPTAR O texto E AO MESMO TEMPO ESTAMOS A ASSINAR
       Signature signature = Signature.getInstance("SHA1withRSA");
       signature.initSign(privateKey);
       //signature.update(content);
       signature.update(file1);
       
       byte[] signatureBytes = signature.sign();
       String encoded = new String(Base64.encodeBase64(signatureBytes));
       
       
       System.err.println("\n"+signatureBytes.length);
       System.out.println(encoded);*/
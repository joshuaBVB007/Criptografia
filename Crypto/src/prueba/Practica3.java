package prueba;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Practica3{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner e=new Scanner(System.in);
		System.out.println("Escoge el fichero: ");
		String nomFitxer=e.nextLine();
		File fichero=new File(nomFitxer);
		
		
		if(fichero.exists()) {
			System.out.println("Introduce una contraseña");
			String password=e.nextLine();
			
			try {
				byte[] data=password.getBytes("UTF-8");
				MessageDigest md=MessageDigest.getInstance("SHA-256");
				byte[] hash=md.digest(data);
				byte[] key=Arrays.copyOf(hash, 192/8);
				SecretKey clau=new SecretKeySpec(key,"AES");
				Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5PADDING");
				
				String nomFitxerNou;
				if (nomFitxer.endsWith(".aes")) {
					cipher.init(Cipher.DECRYPT_MODE,clau);
					nomFitxerNou=nomFitxer.substring(0,nomFitxer.length()-4);
					System.out.println("desencripta");
				}else {
					cipher.init(Cipher.ENCRYPT_MODE,clau);
					nomFitxerNou=nomFitxer+".aes";
					System.out.println("encripta");
				}
				
				byte[] dades=new byte[1024];
				FileOutputStream out=new FileOutputStream(nomFitxerNou);
				FileInputStream in=new FileInputStream(nomFitxer);
				
				
				int llegits=in.read(dades);
				while(llegits>0) {
					out.write(cipher.doFinal(dades,0,llegits));
					llegits=in.read();
				}
				in.close();
				out.close();
				
				RandomAccessFile rand=new RandomAccessFile(nomFitxer,"rw");
				for (int i = 0; i < rand.length(); i++) {
					rand.write(0);
				}
				rand.close();
				
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
		
		
	}
}

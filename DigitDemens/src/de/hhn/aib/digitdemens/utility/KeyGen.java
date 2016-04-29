package de.hhn.aib.digitdemens.utility;

import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class KeyGen {
	
	public static SecretKeySpec generatedKey(String keyString) throws Exception
	{
		// byte-Array erzeugen
		byte[] key = (keyString).getBytes("UTF-8");
		// aus dem Array einen Hash-Wert erzeugen mit MD5 oder SHA
		MessageDigest sha = MessageDigest.getInstance("MD5");
		key = sha.digest(key);
		// nur die ersten 128 bit nutzen
		key = Arrays.copyOf(key, 16); 
		// der fertige Schluessel
		return new SecretKeySpec(key, "AES");
	}
	
	public static Key generatedRandomKey() throws Exception
	{
		KeyGenerator keygen = KeyGenerator.getInstance("AES");
		keygen.init(128);
		Key key = keygen.generateKey();
		return key;
	}

}

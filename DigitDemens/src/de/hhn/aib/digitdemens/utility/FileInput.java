package de.hhn.aib.digitdemens.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileInput {
	
	File path;

	public FileInput(File path)
	{
		this.path = path;
	}
	
	public String readFromFileToString() throws IOException
	{
		FileInputStream fis = new FileInputStream(path);
		
		StringBuilder builder = new StringBuilder();
		int ch;
		while((ch = fis.read()) != -1){
		    builder.append((char)ch);
		}
		fis.close();
		return builder.toString().trim();
		
	}
	
	public Groups readGroup(char[] password) throws Exception
	{
		Crypt crypt = new Crypt(KeyGen.generatedKey(String.valueOf(password)),"AES");
		FileInputStream fis = new FileInputStream(path);
		try(ObjectInputStream ois = new ObjectInputStream(crypt.decryptInputStream(fis)))
		{
			return (Groups) ois.readObject();
		} catch (ClassNotFoundException e) {
			System.out.println("classNotFound");
		}
		return new Groups(null, path, null, null, null);
	}
}

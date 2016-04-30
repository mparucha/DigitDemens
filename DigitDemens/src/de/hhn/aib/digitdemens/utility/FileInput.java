package de.hhn.aib.digitdemens.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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
}

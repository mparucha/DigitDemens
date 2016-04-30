package de.hhn.aib.digitdemens.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


import de.hhn.aib.digitdemens.controller.Registration;

public class FileOutput {
	private String fullName;
	private String username;
	private String password;
	private String group;
	private String[] information;
	//TODO 
	
	public FileOutput(String fullName, String username, String password)
	{
		this.fullName=fullName;
		this.username=username;
		this.password=password;
	}
	
	public boolean writeDataFile(String[] data, boolean append)
	{
		return true;
	}
	
	public boolean writeLogFileFromString(String data) throws IOException
	{
		File logFile = new File(Registration.workingDir+fullName+"\\logFile.dd");
		System.out.println(logFile.getAbsolutePath());
		FileOutputStream fos = new FileOutputStream(logFile);
		
		logFile.createNewFile();
		
		try
		{
		byte[] dataByte = data.getBytes(StandardCharsets.UTF_8);
		
		fos.write(dataByte, 0, dataByte.length);
		fos.flush();
		fos.close();
		}
		catch(IOException e)
		{
			System.out.println("cant write logfile");
			return false;
		}
		return true;
	}
	
	public boolean writeLogFile(byte[] dataByte) throws IOException
	{
		File logFile = new File(Registration.workingDir+fullName+"\\logFile.dd");
		FileOutputStream fos = new FileOutputStream(logFile);
		
		logFile.createNewFile();
		
		try
		{
		fos.write(dataByte, 0, dataByte.length);
		fos.flush();
		fos.close();
		}
		catch(IOException e)
		{
			System.out.println("cant write logfile");
			return false;
		}
		return true;
	}
	
	
	public byte[] makeEncryptedLogFile(String[] data) throws Exception
	{
		Crypt crypt = new Crypt(KeyGen.generatedKey(password),"AES");
		String logFile = "";

			logFile+="FullName:"+fullName+";"+System.getProperty("line.seperator");
			logFile+="Username:"+username+";"+System.getProperty("line.seperator");
			logFile+="Password:"+password+";"+System.getProperty("line.seperator");
			logFile+="Info:";
			
			for(int i = 0; i<data.length; i++)
			{
					logFile+=data[i]+";";
			}
		byte[] logfileBytes = crypt.encrypt(logFile);
		return logfileBytes;
	}
}

package de.hhn.aib.digitdemens.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import de.hhn.aib.digitdemens.controller.Groups;
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
	public FileOutput(String fullName, String username)
	{
		this.fullName=fullName;
		this.username=username;
		this.password="";
	}
	
	public boolean writeDataFile(String[] data, boolean append)
	{
		return true;
	}
	
	public boolean writeLogFileFromString(String data) throws IOException
	{
		File logFile = new File(Variables.getWorkingDir()+fullName+"\\logFile.dd");
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
		File logFile = new File(Variables.getWorkingDir()+fullName+"\\logFile.dd");
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
	//TODO
	public boolean writeSystemFile(byte[] dataByte) throws IOException
	{
		File systemFile = new File(Variables.getSystemDir()+"\\systemFile.dd");
		FileOutputStream fos = new FileOutputStream(systemFile, true);
		
		systemFile.createNewFile();
		
		try
		{
		fos.write(dataByte, 0, dataByte.length);
		fos.flush();
		fos.close();
		}
		catch(IOException e)
		{
			System.out.println("cant write systemfile");
			return false;
		}
		return true;
	}
	
	//TODO
	public byte[] makeEncryptedLogFile(String[] data) throws Exception
	{
		Crypt crypt = new Crypt(KeyGen.generatedKey(password),"AES");
		String logFile = "";

			logFile+="FullName:"+fullName+";"+System.getProperty("line.separator");
			logFile+="Username:"+username+";"+System.getProperty("line.separator");
			logFile+="Password:"+password+";"+System.getProperty("line.separator");
			logFile+="Groups:";
			
			for(int i = 0; i<data.length; i++)
			{
					if(!data[i].trim().isEmpty()) logFile+=data[i]+";";
			}
		byte[] logfileBytes = crypt.encrypt(logFile);
		return logfileBytes;
	}
	
	
	public byte[] makeEncryptedSystemFile(String pass) throws Exception
	{
		Crypt crypt = new Crypt(KeyGen.generatedKey(pass),"AES");
		String systemFile = "FullName:"+fullName+";"+"Username:"+username+";"+System.getProperty("line.separator");
		byte[] systemFileBytes = crypt.encrypt(systemFile);
		return systemFileBytes;
	}
	
	public byte[] editEncryptedSystemFile(String pass, String data) throws Exception
	{
		Crypt crypt = new Crypt(KeyGen.generatedKey(pass),"AES");
		String systemFile = "FullName:"+fullName+";"+"Username:"+username+";"+System.getProperty("line.separator");
		systemFile+=data;
		byte[] systemFileBytes = crypt.encrypt(systemFile);
		return systemFileBytes;
	}
	
	public boolean writeGroupToDir(Groups group) throws Exception
	{
		Crypt crypt = new Crypt(KeyGen.generatedKey(password),"AES");
		FileOutputStream groupsFile = new FileOutputStream(group.getPath().getAbsolutePath());
		
		try(ObjectOutputStream fos = new ObjectOutputStream(crypt.encryptOutputStream(groupsFile)))
		{
		fos.writeObject(group);
		}
		catch(IOException e)
		{
			System.out.println("cant write GroupsFile");
			return false;
		}
		return true;
		
	}
	
}

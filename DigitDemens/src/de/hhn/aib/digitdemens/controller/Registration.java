package de.hhn.aib.digitdemens.controller;

import java.io.File;
import java.io.IOException;

import de.hhn.aib.digitdemens.utility.FileOutput;
import de.hhn.aib.digitdemens.utility.Utility;
import de.hhn.aib.digitdemens.utility.Variables;

public class Registration {
	
	
	public static boolean register(String username, String fullName, char[] password, String[] info)
	{
		if (!checkInput(username, fullName, password)) return false;
		try
		{
			File userPath = new File(Variables.getWorkingDir()+fullName);
			System.out.println(userPath.getAbsolutePath());
			
			if(userPath.exists())
			{
				System.out.println("userpath already exists");
			}
			else
			{
				if(createUser(userPath, username, fullName, password, info)&&writeSystemFile(username,fullName))
				{
					System.out.println("user created");
				}
				else System.out.println("user not created");
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return true;
	}
	
	//TODO
	public static boolean checkInput(String username, String fullName, char[] password)
	{
		return true;
	}
	
	
	public static boolean createUser(File path, String username, String fullName, char[] password, String[] info) throws Exception
	{
		String pass = String.valueOf(password);
		FileOutput fo = new FileOutput(fullName, username, pass);
		path.mkdirs();
		if(fo.writeLogFile(fo.makeEncryptedLogFile(info)))
		{
			return true;
		}	
		return false;
	}
	
	public static boolean writeSystemFile(String username, String fullName) throws IOException, Exception
	{
		File systemPath = new File(Variables.getSystemDir() + "systemFile.dd");
		FileOutput fo = new FileOutput(fullName, username);
		if(!systemPath.exists())
		{
			if(fo.writeSystemFile(fo.makeEncryptedSystemFile(Variables.getUserName())))
			{
				return true;
			}	
		}
		else
		{
			String text =  Utility.decryptFile(systemPath, Variables.getSystemDir());
			systemPath.delete();
			if(fo.writeSystemFile(fo.editEncryptedSystemFile(Variables.getUserName(), text)))
			{
				return true;
			}	
		}
		return false;
	}
	

}

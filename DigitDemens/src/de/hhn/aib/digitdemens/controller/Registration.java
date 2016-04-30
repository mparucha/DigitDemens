package de.hhn.aib.digitdemens.controller;

import java.io.File;
import java.io.IOException;

import de.hhn.aib.digitdemens.utility.FileOutput;

public class Registration {
	
	
	public static String workingDir = "C:\\Users\\Marek Parucha\\DigitalDemens\\";
	
	public static void main(String[] args)
	{
		System.out.println(workingDir);
	}
	
	public static boolean register(String username, String fullName, char[] password, String[] info)
	{
		if (!checkInput(username, fullName, password)) return false;
		try
		{
			File userPath = new File(workingDir+fullName);
			System.out.println(userPath.getAbsolutePath());
			
			if(userPath.exists())
			{
				System.out.println("userpath already exists");
			}
			else
			{
				if(createUser(userPath, username, fullName, password, info))
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
	
	
	public static boolean checkInput(String username, String fullName, char[] password)
	{
		return true;
	}
	
	
	public static boolean createUser(File path, String username, String fullName, char[] password, String[] info) throws Exception
	{
		String pass = String.valueOf(password);
		FileOutput fo = new FileOutput(fullName, username, pass);
		path.mkdir();
		if(fo.writeLogFile(fo.makeEncryptedLogFile(info)))
		{
			return true;
		}	
		return false;
	}
	

}

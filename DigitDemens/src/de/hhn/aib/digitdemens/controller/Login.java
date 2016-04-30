package de.hhn.aib.digitdemens.controller;

import java.io.File;
import java.io.IOException;

import javax.crypto.BadPaddingException;

import de.hhn.aib.digitdemens.utility.Crypt;
import de.hhn.aib.digitdemens.utility.FileInput;
import de.hhn.aib.digitdemens.utility.KeyGen;

public class Login {

	public static String workingDir = "C:\\Users\\Marek Parucha\\DigitalDemens\\";
	
	public static boolean login(String username, char[] password) throws Exception
	{
		File systemPath = new File(workingDir);
		File userPath = checkSystemLog(username);
		String fullName = userPath.getAbsolutePath().substring(0, workingDir.length());
		System.out.println(userPath.getAbsolutePath());
		if(userPath.equals(workingDir+null)) return false;
		if(!checkLoginData(username, password, userPath, fullName)) return false;
		return true;
	}
	
	public static boolean checkInput(String login, char[] password)
	{
		return true;
	}
	
	public static File checkSystemLog(String username) throws Exception
	{
		File systemPath = new File(workingDir+"systemFile.dd");
		FileInput fi = new FileInput(systemPath);
		String systemDataEncrypted = fi.readFromFileToString();
		Crypt decrypt = new Crypt(KeyGen.generatedKey(workingDir),"AES");
		String systemDataDecrypted=  decrypt.decrypt(systemDataEncrypted);
		System.out.println(systemDataDecrypted);
		return new File(workingDir+findUserpath(username,systemDataDecrypted));
	}
	
	public static String findUserpath(String username, String text )
	{
		String[] userInfos = text.split(System.getProperty("line.separator"));
		String[] user;
		for(int i = 0; i < userInfos.length; i++)
		{
			user = userInfos[i].split(";Username:");
				if(user[1].equals(username+";"))
				{
					return user[0].substring(9);
				}
					
			
		}
		System.out.println("User couldnt be found");
		return null;
	}
	
	public static boolean checkLoginData(String username, char[] password, File userPath, String fullName) throws Exception
	{
		File logPath = new File(userPath.getAbsolutePath()+"\\logFile.dd");
		FileInput fi = new FileInput(logPath);
		String text = fi.readFromFileToString();
		Crypt decrypt = new Crypt(KeyGen.generatedKey(String.valueOf(password)),"AES");
		String systemDataDecrypted = "no text";
		try
		{
			systemDataDecrypted =  decrypt.decrypt(text);
		}
		catch (BadPaddingException e)
		{
			System.out.println("false Password");
			return false;
		}
		System.out.println(systemDataDecrypted);
		return true;
	}
}

package de.hhn.aib.digitdemens.controller;

import java.io.File;
import javax.crypto.BadPaddingException;

import de.hhn.aib.digitdemens.utility.Utility;

public class Login {
	//TODO
	public static String workingDir = "C:\\Users\\Marek Parucha\\DigitalDemens\\";
	
	public static boolean login(String username, char[] password) throws Exception
	{
		File systemPath = new File(workingDir);
		File userPath = checkSystemLog(username);
		String fullName = userPath.getAbsolutePath().substring(0, workingDir.length()-1);
		System.out.println(userPath.getAbsolutePath());
		if(userPath.equals(systemPath)) return false;
		if(!checkLoginData(username, password, userPath, fullName)) return false;
		return true;
	}
	//TODO
	public static boolean checkInput(String login, char[] password)
	{
		return true;
	}
	//TODO
	public static File checkSystemLog(String username) throws Exception
	{
		File systemPath = new File(workingDir+"systemFile.dd");
		String systemDataDecrypted=  Utility.decryptFile(systemPath, String.valueOf(workingDir));
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
		return "";
	}
	
	public static boolean checkLoginData(String username, char[] password, File userPath, String fullName) throws Exception
	{
		File logPath = new File(userPath.getAbsolutePath()+"\\logFile.dd");
		String systemDataDecrypted = "no text";
		String[] userInfos;
		try
		{
			systemDataDecrypted =  Utility.decryptFile(logPath, String.valueOf(password));
		}
		catch (BadPaddingException e)
		{
			System.out.println("false Password");
			return false;
		}
		System.out.println(systemDataDecrypted);
		userInfos = systemDataDecrypted.split(";"+System.getProperty("line.separator"));
		
		if(!userInfos[0].substring(0, 9).equals(fullName)) return false;
		if(!userInfos[1].substring(0, 9).equals(username)) return false;
		if(!userInfos[2].substring(0, 9).equals(String.valueOf(password))) return false;
		
		return true;
	}
}

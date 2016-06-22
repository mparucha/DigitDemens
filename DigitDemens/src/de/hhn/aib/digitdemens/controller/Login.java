package de.hhn.aib.digitdemens.controller;

import java.io.File;
import javax.crypto.BadPaddingException;

import de.hhn.aib.digitdemens.utility.Utility;
import de.hhn.aib.digitdemens.utility.Variables;

public class Login {
	//TODO
	private static boolean loggedIn = false;
	
	public static boolean login(String username, char[] password) throws Exception
	{
		File systemPath = new File(Variables.getSystemDir());
		File userPath = checkSystemLog(username);
		String fullName = userPath.getAbsolutePath().substring(Variables.getWorkingDir().length());
		System.out.println(userPath.getAbsolutePath());
		if(userPath.equals(systemPath)) return loggedIn;
		if(!checkLoginData(username, password, userPath, fullName)) return loggedIn;
		loggedIn = true;
		Main.setMain(fullName,password,username);
		return loggedIn;
	}
	//TODO
	public static boolean checkInput(String login, char[] password)
	{
		return true;
	}
	
	public static File checkSystemLog(String username) throws Exception
	{
		File systemPath = new File(Variables.getSystemDir()+"systemFile.dd");
		String systemDataDecrypted;
		try {
			systemDataDecrypted = Utility.decryptFile(systemPath, String.valueOf(Variables.getUserName()));
			System.out.println(systemDataDecrypted);
			return new File(Variables.getWorkingDir()+findUserpath(username,systemDataDecrypted));
		} catch (Exception e) {
			System.out.println("Please register first.");
			throw new Exception();
		}
		
	}
	//TODO if user does not exist failure
	public static String findUserpath(String username, String text)
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
		
		if(!userInfos[0].substring(9).equals(fullName)) {
			System.out.println(userInfos[0].substring(9)+":"+fullName); 
			return false;
		}
		if(!userInfos[1].substring(9).equals(username)){
			System.out.println(userInfos[1].substring(9)+":"+username); 
			return false;
		}
		if(!userInfos[2].substring(9).equals(String.valueOf(password))){
			System.out.println(userInfos[2].substring(9)+":"+String.valueOf(password)); 
			return false;
		}
		
		return true;
	}
	
	
}

package de.hhn.aib.digitdemens.controller;

import java.io.File;

import de.hhn.aib.digitdemens.DigitDemens;
import de.hhn.aib.digitdemens.utility.Groups;
import de.hhn.aib.digitdemens.utility.Utility;

public class Main {
	public static String workingDir = "C:\\Users\\Marek Parucha\\DigitalDemens\\";
	private static String fullName;
	private static char[] password;
	private static String username;
	private static boolean initialized = false;
	
	
	public static void setMain(String fullName1, char[] password1, String username1)
	{
		fullName=fullName1;
		password=password1;
		username=username1;
		initialized = true;
		DigitDemens.getdDView().setData();
	}
	//List <Groups>
	public static Groups[] getGroups() throws Exception
	{
		File logPath = new File(workingDir+fullName+"\\logFile.dd");
		String decryptedLog = "";
		String[] groupsStrings;
		File[] groupsPath;
		Groups[] groupsList;
		String[] groupsText;
		
		decryptedLog = Utility.decryptFile(logPath, String.valueOf(password));
		groupsStrings = getGroupsString(decryptedLog);
		groupsPath = new File[groupsStrings.length];
		groupsList = new Groups[groupsStrings.length];
		groupsText = new String[groupsStrings.length];
		try
		{
			for(int i = 0; i < groupsStrings.length; i++) groupsPath[i] = new File(workingDir + fullName +"\\"+groupsList[i].getName()+".dd");
			for(int i = 0; i < groupsPath.length; i++) groupsText[i]=Utility.decryptFile(groupsPath[i], String.valueOf(password));
			for(int i = 0; i < groupsText.length; i++) groupsList[i]=new Groups(groupsStrings[i], groupsPath[i], username, fullName, groupsText[i]);
		}
		catch (Exception e)
		{
			System.out.println("ERROR: couldnt read groups");

		}
		System.out.println(groupsList);
		return groupsList;
	}
	
	public static String[] getGroupsString(String text)
	{
		String[] userInfos = text.split(System.getProperty("line.separator"));
		try{
			String[] groupsString = (userInfos[3].substring(7)).split(";");
			if(groupsString[0].equals("")) throw new StringIndexOutOfBoundsException();
			return groupsString;
		}
		catch(StringIndexOutOfBoundsException e)
		{
			return new String[0];
		}
		
		
	}
	//TODO
	public static void addGroup()
	{
		
	}
	
	public static boolean getInitialized()
	{
		return initialized;
	}
	
}

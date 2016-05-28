package de.hhn.aib.digitdemens.controller;

import java.io.File;

import de.hhn.aib.digitdemens.DigitDemens;
import de.hhn.aib.digitdemens.utility.FileInput;
import de.hhn.aib.digitdemens.utility.FileOutput;
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
		FileInput fi = new FileInput(logPath);
		String decryptedLog = "";
		String[] groupsStrings;
		File[] groupsPath;
		Groups[] groupsList;
		String[] groupsText;
		
		decryptedLog = Utility.decryptFile(logPath, String.valueOf(password));
		groupsStrings = getGroupsString(decryptedLog);
		groupsPath = new File[groupsStrings.length];
		groupsList = new Groups[groupsStrings.length];
		try
		{
			for(int i = 0; i < groupsStrings.length; i++) groupsPath[i] = new File(workingDir + fullName +"\\"+groupsStrings[i]+".ser");
			for(int i = 0; i < groupsPath.length; i++)
			{
				fi.setPath(groupsPath[i]);
				groupsList[i]=fi.readGroup(password);
			}
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
	
	public static String[] addGroupsString(String name, String text)
	{
		String[] newGroupsString;
		String[] userInfos = text.split(System.getProperty("line.separator"));
		try{
			String[] groupsString = (userInfos[3].substring(7)).split(";");
			newGroupsString = new String[groupsString.length+1];
			for(int i = 0; i<newGroupsString.length-1;i++) newGroupsString[i] = groupsString[i];
			newGroupsString[newGroupsString.length-1] = name;
			
			return newGroupsString;
		}
		catch(StringIndexOutOfBoundsException e)
		{
			return new String[0];
		}
		
	}
	public static String[] deleteGroupsString(String name, String text)
	{
		String[] newGroupsString;
		String[] userInfos = text.split(System.getProperty("line.separator"));
		try{
			String[] groupsString = (userInfos[3].substring(7)).split(";");
			newGroupsString = new String[groupsString.length-1];
			for(int i = 0,j = 0; i<newGroupsString.length;i++,j++)
			{
				if(!groupsString[j].equals(name)) newGroupsString[i] = groupsString[j];
				else i--;
			}
			
			return newGroupsString;
		}
		catch(StringIndexOutOfBoundsException e)
		{
			return new String[0];
		}
		
	}
	//TODO
	public static void addGroup(String name, String description) throws Exception
	{
		String[] data = addGroupsString(name, Utility.decryptFile(new File(workingDir+fullName+"\\logFile.dd"), String.valueOf(password)));
		FileOutput fo = new FileOutput(fullName, username, String.valueOf(password));
		fo.writeGroupToDir(new Groups(name, new File(workingDir+fullName+"\\"+name+".ser"), username, fullName, description));
		fo.writeLogFile(fo.makeEncryptedLogFile(data));
		
		
	}
	
	public static void deleteGroup(Groups group) throws Exception
	{
		String[] data = deleteGroupsString(group.getName(), Utility.decryptFile(new File(workingDir+fullName+"\\logFile.dd"), String.valueOf(password)));
		File groupFile = group.getPath();
		FileOutput fo = new FileOutput(fullName, username, String.valueOf(password));
		fo.writeLogFile(fo.makeEncryptedLogFile(data));
		groupFile.delete();
		
		
		
	}
	
	public static boolean getInitialized()
	{
		return initialized;
	}
	
}

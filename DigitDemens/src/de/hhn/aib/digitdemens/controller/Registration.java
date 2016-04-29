package de.hhn.aib.digitdemens.controller;

import java.io.File;

public class Registration {
	
	
	static String workingDir = "C:\\Users\\Marek Parucha\\DigitalDemens\\";
	
	public static void main(String[] args)
	{
		System.out.println(workingDir);
	}
	
	public static boolean register(String username, String preName, String name, char[] password)
	{
		try
		{
		File userPath = new File(workingDir+preName+name);
		
		if(userPath.exists())
		{
			System.out.println("userpath already exists");
		}
		else
		{
			userPath.mkdir();
			System.out.println("user created");
		}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean checkInput(String username, String preName, String name, char[] password)
	{
		return true;
	}
	

}

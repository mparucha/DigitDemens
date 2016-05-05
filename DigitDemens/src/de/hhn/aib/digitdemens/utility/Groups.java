package de.hhn.aib.digitdemens.utility;

import java.io.File;

public class Groups {

	private String name;
	private File path;
	private String username;
	private char[] password;
	private String fullName;
	private String text;
	
	/**
	 * 
	 * @param name
	 * @param path
	 * @param username
	 * @param password
	 * @param fullName
	 * @param text
	 */
	public Groups(String name, File path, String username, char[] password, String fullName, String text)
	{
		this.name = name;
		this.path = path;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.text = text;
	}
}

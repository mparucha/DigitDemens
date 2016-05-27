package de.hhn.aib.digitdemens.utility;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Groups implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private File path;
	private String username;
	private String fullName;
	private String text;
	private ArrayList <Accounts> accounts;
	
	/**
	 * 
	 * @param name
	 * @param path
	 * @param username
	 * @param fullName
	 * @param text
	 */
	public Groups(String name, File path, String username, String fullName, String text)
	{
		this.name = name;
		this.path = path;
		this.username = username;
		this.fullName = fullName;
		this.text = text;
		accounts = new ArrayList <Accounts>();
	}
	
	public void addAccount(Accounts acc)
	{
		accounts.add(acc);
	}
	public String getName()
	{
		return name;
	}
	public File getPath()
	{
		return path;
	}
}

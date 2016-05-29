package de.hhn.aib.digitdemens.controller;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;


public class Groups implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -1209802156117962061L;
	private String name;
	private File path;
	private String username;
	private String fullName;
	private String description;
	private ArrayList <Accounts> accounts;
	
	/**
	 * 
	 * @param name
	 * @param path
	 * @param username
	 * @param fullName
	 * @param description
	 */
	public Groups(String name, File path, String username, String fullName, String description)
	{
		this.name = name;
		this.path = path;
		this.username = username;
		this.fullName = fullName;
		this.description = description;
		accounts = new ArrayList <Accounts>();
	}
	
	public void addAccount(Accounts acc)
	{
		accounts.add(acc);
	}
	public void deleteAccount(Accounts acc)
	{
		accounts.remove(acc);
	}
	public String getName()
	{
		return name;
	}
	public File getPath()
	{
		return path;
	}
	
	public ArrayList <Accounts> getAccounts()
	{
		return accounts;
	}
}

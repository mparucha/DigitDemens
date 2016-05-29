package de.hhn.aib.digitdemens.controller;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;

public class Accounts implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8727636905528154093L;
	private String name;
	private String description;
	private String username;
	private String email;
	private char[] password;
	private URL url;
	private String passwordHint;
	private LocalDateTime creationDate;
	private LocalDateTime lastEditedDate;
	private String info;
	private Groups group;
	/**
	 * 
	 * @param name
	 * @param description
	 * @param username
	 * @param email
	 * @param password
	 * @param url
	 * @param passwordHint
	 * @param creationDate
	 * @param info
	 */
	public Accounts(String name, String description, String username, String email, char[] password, String url, String passwordHint, LocalDateTime creationDate, String info, Groups group)
	{
		this.name = name;
		this.description = description;
		this.username = username;
		this.email = email;
		this.password = password;
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			try {
				this.url = new URL("http://WrongURLGiven.com");
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		this.passwordHint = passwordHint;
		this.creationDate = creationDate;
		this.lastEditedDate = creationDate;
		this.info = info;
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(String url) {
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			try {
				this.url = new URL("http://WrongURLGiven.com");
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public String getPasswordHint() {
		return passwordHint;
	}

	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getLastEditedDate() {
		return lastEditedDate;
	}

	public void setLastEditedDate(LocalDateTime lastEditedDate) {
		this.lastEditedDate = lastEditedDate;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	public void setGroup(Groups group)
	{
		this.group = group;
	}
	
	public Groups getGroup()
	{
		return group;
	}


}

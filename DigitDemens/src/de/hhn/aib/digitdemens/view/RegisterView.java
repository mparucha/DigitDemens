package de.hhn.aib.digitdemens.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import de.hhn.aib.digitdemens.DigitDemens;
import de.hhn.aib.digitdemens.utility.Utility;



public class RegisterView extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GridBagConstraints gbc;
	
	private JLabel userLabel;
	private JLabel preNameLabel;
	private JLabel nameLabel;
	private JLabel passLabel;
	
	private JTextField name;
	private JTextField preName;
	private JTextField username;
	private JPasswordField password;
	private JButton registerButton;
	private JPasswordField passwordSec;
	private JLabel passSecLabel;
	private JButton backButton;
	
	public RegisterView()
	{
		super();
		init();
		setRegistry();
		initListener();
	}
	
	public void init()
	{
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		userLabel = new JLabel("Username: ");
		passLabel = new JLabel("Password: ");
		nameLabel = new JLabel("Name: ");
		preNameLabel = new JLabel("Pre Name: ");
		username = new JTextField(16);
		preName = new JTextField(16);
		name = new JTextField(16);
		password = new JPasswordField(16);
		registerButton = new JButton("Login");
		passwordSec = new JPasswordField(16);
		passSecLabel = new JLabel("Password again: ");
		backButton = new JButton("Back");
		userLabel.setLabelFor(username);
		nameLabel.setLabelFor(name);
		preNameLabel.setLabelFor(preName);
		passLabel.setLabelFor(password);
		passSecLabel.setLabelFor(passwordSec);
	}

	public void setRegistry()
	{
		Utility.makeGBC(gbc, 0, 0, -1, -1, -1, -1, -1, GridBagConstraints.EAST, -1, -1);
		add(userLabel,gbc);
		Utility.makeGBC(gbc, 0, 1, -1, -1, -1, -1, -1, GridBagConstraints.EAST, -1, -1);
		add(preNameLabel,gbc);
		Utility.makeGBC(gbc, 0, 2, -1, -1, -1, -1, -1, GridBagConstraints.EAST, -1, -1);
		add(nameLabel,gbc);
		Utility.makeGBC(gbc, 0, 3, -1, -1, -1, -1, -1, GridBagConstraints.EAST, -1, -1);
		add(passLabel, gbc);
		Utility.makeGBC(gbc, 0, 4, -1, -1, -1, -1, -1, GridBagConstraints.EAST, -1, -1);
		add(passSecLabel, gbc);
		Utility.makeGBC(gbc, 1, 0, -1, -1, -1, -1, -1, -1, -1, -1);
		add(username, gbc);
		Utility.makeGBC(gbc, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1);
		add(preName, gbc);
		Utility.makeGBC(gbc, 1, 2, -1, -1, -1, -1, -1, -1, -1, -1);
		add(name, gbc);
		Utility.makeGBC(gbc, 1, 3, -1, -1, -1, -1, -1, -1, -1, -1);
		add(password, gbc);
		Utility.makeGBC(gbc, 1, 4, -1, -1, -1, -1, -1, -1, -1, -1);
		add(passwordSec, gbc);
		Utility.makeGBC(gbc, 1, 5, -1, -1, -1, -1, -1, GridBagConstraints.WEST, -1, -1);
		add(registerButton, gbc);
		Utility.makeGBC(gbc, 1, 5, -1, -1, -1, -1, -1, GridBagConstraints.EAST, -1, -1);
		add(backButton, gbc);
	}
	
	public void initListener()
	{
		registerButton.addActionListener(new ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(ActionEvent e) {
            	
            }
        });
		
		backButton.addActionListener(new ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(ActionEvent e) {
            	DigitDemens.getdDView().setView("Login");
            }
        });
	}
}

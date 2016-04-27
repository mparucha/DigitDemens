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

public class LoginView extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel userLabel;
	private JLabel passLabel;
	private JTextField username;
	private JPasswordField password;
	
	private JButton loginButton;
	private JButton registerButton;
	private GridBagConstraints gbc;
	
	public LoginView()
	{
		super();
		init();
		setLogin();
		initListener();
	}
	
	public void init()
	{
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		userLabel = new JLabel("Username: ");
		passLabel = new JLabel("Password: ");
		username = new JTextField(16);
		password = new JPasswordField(16);
		loginButton = new JButton("Login");
		registerButton = new JButton("Register");
		userLabel.setLabelFor(username);
		passLabel.setLabelFor(password);
	}
	public void setLogin()
	{
		Utility.makeGBC(gbc, 0, 1, -1, -1, -1, -1, -1, GridBagConstraints.EAST, -1, -1);
		add(userLabel,gbc);
		Utility.makeGBC(gbc, 0, 2, -1, -1, -1, -1, -1, GridBagConstraints.EAST, -1, -1);
		add(passLabel, gbc);
		Utility.makeGBC(gbc, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1);
		add(username, gbc);
		Utility.makeGBC(gbc, 1, 2, -1, -1, -1, -1, -1, -1, -1, -1);
		add(password, gbc);
		Utility.makeGBC(gbc, 1, 3, -1, -1, -1, -1, -1, GridBagConstraints.WEST, -1, -1);
		add(loginButton, gbc);
		Utility.makeGBC(gbc, 1, 3, -1, -1, -1, -1, -1, GridBagConstraints.EAST, -1, -1);
		add(registerButton, gbc);
		
	}
	
	public void initListener()
	{
		loginButton.addActionListener(new ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(ActionEvent e) {
  
            }
        });
		registerButton.addActionListener(new ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(ActionEvent e) {
            	DigitDemens.getdDView().setView("Register");
            }
        });
		
	}

}

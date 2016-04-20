package de.hhn.aib.digitdemens.view;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class DigitDemensView extends JFrame{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JPanel cardPanel, main, registry;
	private GridBagConstraints gbc;
	private CardLayout cardLayout = new CardLayout();
	//main declaration
	private JLabel userLabel;
	private JLabel passLabel;
	private JTextField username;
	private JPasswordField password;
	private JButton okButton;
	private JButton registerButton;
	private JMenuBar menuBar;
	private JMenu options;
	private JMenuItem directory;
	//registry declaration
	private JPasswordField passwordSec;
	private JLabel passSecLabel;
	private JButton backButton;
	//other
	
	

	public DigitDemensView() {
		super("DigitDemens - Main");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(1200,800);
		
		cardPanel = (JPanel) getContentPane();
		cardPanel.setLayout(cardLayout);
		gbc = new GridBagConstraints();
		
		initMain();
		initRegistry();
		cardPanel.add(main, "Main");
		cardPanel.add(registry, "Register");
		cardLayout.show(cardPanel, "Register");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void initMain()
	{
		main = new JPanel();
		main.setLayout(new GridBagLayout());
		//initialize
		userLabel = new JLabel("Username:");
		passLabel = new JLabel("Password:");
		username = new JTextField(16);
		password = new JPasswordField(16);
		okButton = new JButton("OK");
		menuBar = new JMenuBar();
		options = new JMenu("Options");
		directory = new JMenuItem("Change Directory");
		registerButton = new JButton("register");
		
		//set up
		userLabel.setLabelFor(username);
		passLabel.setLabelFor(password);
		
		//Menu
		menuBar.add(options);
		options.add(directory);
		this.setJMenuBar(menuBar);
		
		//design
		gbc.gridx = 0;
		gbc.gridy = 1;
		main.add(userLabel,gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		main.add(passLabel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		main.add(username, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		main.add(password, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		main.add(okButton, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		main.add(registerButton, gbc);
		//this.pack();
		
	}
	
	public void initRegistry()
	{
		registry = new JPanel();
		registry.setLayout(new GridBagLayout());
		
		passwordSec = new JPasswordField(16);
		passSecLabel = new JLabel("Password again:");
		backButton = new JButton("Back");
		
		passSecLabel.setLabelFor(passwordSec);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		registry.add(userLabel,gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		registry.add(passLabel, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		registry.add(passSecLabel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		registry.add(username, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		registry.add(password, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		registry.add(passwordSec, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		registry.add(okButton, gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		registry.add(backButton, gbc);
	}

}

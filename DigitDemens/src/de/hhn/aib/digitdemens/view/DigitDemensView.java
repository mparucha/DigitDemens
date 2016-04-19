package de.hhn.aib.digitdemens.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class DigitDemensView extends JFrame{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel userLabel;
	private JLabel passLabel;
	private JTextField username;
	private JPasswordField password;
	private JButton okButton;
	private GridBagConstraints gbc;
	

	public DigitDemensView() {
		super("DigitDemens - Main");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(1200,800);
		panel = (JPanel) getContentPane();
		panel.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		initUI();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void initUI()
	{
		//initialize
		userLabel = new JLabel("Username:");
		passLabel = new JLabel("Password:");
		username = new JTextField(16);
		password = new JPasswordField(16);
		okButton = new JButton("OK");
		
		//set up
		userLabel.setLabelFor(username);
		passLabel.setLabelFor(password);
		
		//design
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(userLabel,gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(passLabel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(username, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(password, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		panel.add(okButton, gbc);
		//this.pack();
		
	}

}

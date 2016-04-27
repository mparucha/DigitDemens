package de.hhn.aib.digitdemens.view;

import de.hhn.aib.digitdemens.utility.*;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		initView();
		setMain();
		cardPanel.add(main, "Main");
		cardPanel.add(registry, "Register");
		cardLayout.show(cardPanel, "Main");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void setMain()
	{
		Utility.makeGBC(gbc, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1);
		main.add(userLabel,gbc);
		Utility.makeGBC(gbc, 0, 2, -1, -1, -1, -1, -1, -1, -1, -1);
		main.add(passLabel, gbc);
		Utility.makeGBC(gbc, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1);
		main.add(username, gbc);
		Utility.makeGBC(gbc, 1, 2, -1, -1, -1, -1, -1, -1, -1, -1);
		main.add(password, gbc);
		Utility.makeGBC(gbc, 0, 3, -1, -1, -1, -1, -1, -1, -1, -1);
		main.add(okButton, gbc);
		Utility.makeGBC(gbc, 1, 3, -1, -1, -1, -1, -1, -1, -1, -1);
		main.add(registerButton, gbc);
		
	}
	
	public void setRegistry()
	{
		Utility.makeGBC(gbc, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1);
		registry.add(userLabel,gbc);
		Utility.makeGBC(gbc, 0, 2, -1, -1, -1, -1, -1, -1, -1, -1);
		registry.add(passLabel, gbc);
		Utility.makeGBC(gbc, 0, 3, -1, -1, -1, -1, -1, -1, -1, -1);
		registry.add(passSecLabel, gbc);
		Utility.makeGBC(gbc, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1);
		registry.add(username, gbc);
		Utility.makeGBC(gbc, 1, 2, -1, -1, -1, -1, -1, -1, -1, -1);
		registry.add(password, gbc);
		Utility.makeGBC(gbc, 1, 3, -1, -1, -1, -1, -1, -1, -1, -1);
		registry.add(passwordSec, gbc);
		Utility.makeGBC(gbc, 0, 4, -1, -1, -1, -1, -1, -1, -1, -1);
		registry.add(okButton, gbc);
		Utility.makeGBC(gbc, 1, 4, -1, -1, -1, -1, -1, -1, -1, -1);
		registry.add(backButton, gbc);
	}
	
	public void initView()
	{
		main = new JPanel();
		main.setLayout(new GridBagLayout());
		registry = new JPanel();
		registry.setLayout(new GridBagLayout());
		
		userLabel = new JLabel("Username:");
		passLabel = new JLabel("Password:");
		username = new JTextField(16);
		password = new JPasswordField(16);
		okButton = new JButton("OK");
		menuBar = new JMenuBar();
		options = new JMenu("Options");
		directory = new JMenuItem("Change Directory");
		registerButton = new JButton("Register");
		passwordSec = new JPasswordField(16);
		passSecLabel = new JLabel("Password again:");
		backButton = new JButton("Back");
		//set up
		userLabel.setLabelFor(username);
		passLabel.setLabelFor(password);
		passSecLabel.setLabelFor(passwordSec);
		
		//Menu
		menuBar.add(options);
		options.add(directory);
		this.setJMenuBar(menuBar);
		
		//listener
				okButton.addActionListener(new ActionListener() {
		            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
		            public void actionPerformed(ActionEvent e) {
		            	dispose();  
		            }
		        });
				registerButton.addActionListener(new ActionListener() {
		            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
		            public void actionPerformed(ActionEvent e) {
		            	setRegistry();
		                cardLayout.show(cardPanel, "Register");
		            }
		        });
				
				backButton.addActionListener(new ActionListener() {
		            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
		            public void actionPerformed(ActionEvent e) {
		            	setMain();
		                cardLayout.show(cardPanel, "Main");
		            }
		        });
	}
}

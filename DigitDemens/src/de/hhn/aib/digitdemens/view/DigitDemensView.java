package de.hhn.aib.digitdemens.view;

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
	

	public DigitDemensView() {
		super("DigitDemens - Main");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(1200,800);
		panel = (JPanel) getContentPane();
		panel.setLayout(new GridBagLayout());
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
		username = new JTextField();
		password = new JPasswordField();
		okButton = new JButton("OK");
		
		//set up
		userLabel.setLabelFor(username);
		passLabel.setLabelFor(password);
		
		
		
	}

}

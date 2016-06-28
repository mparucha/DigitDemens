package de.hhn.aib.digitdemens.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import de.hhn.aib.digitdemens.controller.Groups;
import de.hhn.aib.digitdemens.controller.Main;
import de.hhn.aib.digitdemens.utility.Utility;

public class AccountsView extends JPanel{

	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	private JLabel nameLabel;
	private JLabel descriptionLabel;
	private JLabel usernameLabel;
	private JLabel emailLabel;
	private JLabel passwordLabel;
	private JLabel urlLabel;
	private JLabel passwordHintLabel;
	private JLabel infoLabel;
	private JTextField name;
	private JTextArea description;
	private JTextField username;
	private JTextField email;
	private JPasswordField password;
	private JTextField url;
	private JTextField passwordHint;
	private JTextArea info;
	private JButton okButton;
	private JButton cancelButton;
	private MainView mainView;
	private Groups group;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountsView (MainView mainView)
	{
		this.mainView = mainView;
		setBackground(Color.LIGHT_GRAY);
		setLayout(gbl);	
		init();
		setAccounts();
		initListener();
	}
	
	public void init()
	{
		nameLabel = new JLabel("Name of Account: ");
		descriptionLabel = new JLabel("Description of Account: ");
		usernameLabel = new JLabel("Username: ");
		emailLabel = new JLabel("E-Mail Address: ");
		passwordLabel = new JLabel("Password: ");
		urlLabel = new JLabel("URL: ");
		passwordHintLabel = new JLabel("Hint for your Password: ");
		infoLabel = new JLabel("Information of your Account: ");
		
		name = new JTextField(20);
		description = new JTextArea(5,20);
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		username = new JTextField(20);
		email = new JTextField(20);
		password = new JPasswordField(20);
		url = new JTextField(20);
		passwordHint = new JTextField(20);
		info = new JTextArea(5,20);
		info.setLineWrap(true);
		info.setWrapStyleWord(true);
		okButton = new JButton("OK");
		cancelButton = new JButton("Cancel");
	}
	public void setAccounts()
	{
		gbc.insets  = new Insets(10,10,10,10);
		Utility.makeGBC(gbc, 0, 0, -1, -1, -1, -1, -1, GridBagConstraints.EAST, -1, -1);
		add(nameLabel,gbc);
		Utility.makeGBC(gbc, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1);
		add(descriptionLabel,gbc);
		Utility.makeGBC(gbc, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1);
		add(usernameLabel,gbc);
		Utility.makeGBC(gbc, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1);
		add(emailLabel,gbc);
		Utility.makeGBC(gbc, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1);
		add(passwordLabel,gbc);
		Utility.makeGBC(gbc, -1, 5, -1, -1, -1, -1, -1, -1, -1, -1);
		add(urlLabel,gbc);
		Utility.makeGBC(gbc, -1, 6, -1, -1, -1, -1, -1, -1, -1, -1);
		add(passwordHintLabel,gbc);
		Utility.makeGBC(gbc, -1, 7, -1, -1, -1, -1, -1, -1, -1, -1);
		add(infoLabel,gbc);
		
		Utility.makeGBC(gbc, 1, 0, -1, -1, -1, 1, -1, GridBagConstraints.WEST, -1, -1);
		add(name,gbc);
		Utility.makeGBC(gbc, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1);
		add(new JScrollPane(description),gbc);
		Utility.makeGBC(gbc, -1, 2, -1, -1, -1, 1, -1, GridBagConstraints.WEST, -1, -1);
		add(username,gbc);
		Utility.makeGBC(gbc, -1, 3, -1, -1, -1, 1, -1, GridBagConstraints.WEST, -1, -1);
		add(email,gbc);
		Utility.makeGBC(gbc, -1, 4, -1, -1, -1, 1, -1, GridBagConstraints.WEST, -1, -1);
		add(password,gbc);
		Utility.makeGBC(gbc, -1, 5, -1, -1, -1, 1, -1, GridBagConstraints.WEST, -1, -1);
		add(url,gbc);
		Utility.makeGBC(gbc, -1, 6, -1, -1, -1, 1, -1, GridBagConstraints.WEST, -1, -1);
		add(passwordHint,gbc);
		Utility.makeGBC(gbc, -1, 7, -1, -1, -1, 1, -1, GridBagConstraints.WEST, -1, -1);
		add(new JScrollPane(info),gbc);
		Utility.makeGBC(gbc, 1, 8, -1, -1, -1, -1, -1, GridBagConstraints.SOUTHEAST, -1, -1);
		add(okButton,gbc);
		Utility.makeGBC(gbc, 1, 8, -1, -1, -1, -1, -1, GridBagConstraints.SOUTHWEST, -1, -1);
		add(cancelButton,gbc);
		
	}
	
	public void setGroup(Groups group)
	{
		this.group = group;
	}
	
	public void refresh()
	{
		name.setText("");
		description.setText("");
		username.setText("");
		email.setText("");
		password.setText("");
		url.setText("");
		passwordHint.setText("");
		info.setText("");
	}
	
	public void initListener()
	{
		okButton.addActionListener(new ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(ActionEvent e) {
            	try {
					Main.addAccount(name.getText(), description.getText(), username.getText(), email.getText(), password.getPassword(), url.getText(), passwordHint.getText(), LocalDateTime.now(), info.getText(), group);
					refresh();
					mainView.setView("InfoView");
					mainView.setAccounts();
				} catch (NullPointerException e1) {
					System.out.println("Please select Group.");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            }
        });
		cancelButton.addActionListener(new ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(ActionEvent e) {
            	try {
            		refresh();
					mainView.setView("InfoView");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
		
	}
}

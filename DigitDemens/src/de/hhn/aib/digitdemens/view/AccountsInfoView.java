package de.hhn.aib.digitdemens.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import de.hhn.aib.digitdemens.controller.Accounts;
import de.hhn.aib.digitdemens.controller.Groups;
import de.hhn.aib.digitdemens.controller.Main;
import de.hhn.aib.digitdemens.utility.Utility;

public class AccountsInfoView extends JPanel{


	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	private JLabel nameLabel;
	private JLabel descriptionLabel;
	private JLabel usernameLabel;
	private JLabel emailLabel;
	private JLabel passwordLabel;
	private JLabel urlLabel;
	private JLabel passwordHintLabel;
	private JLabel createdLabel;
	private JLabel lastEditedLabel;
	private JLabel infoLabel;
	private JTextField name;
	private JTextArea description;
	private JTextField username;
	private JTextField email;
	private JPasswordField password;
	private JTextField url;
	private JTextField passwordHint;
	private JLabel created;
	private JLabel lastEdited;
	private JTextArea info;
	private JButton editButton;
	private JButton saveButton;
	private MainView mainView;
	private Accounts currentAccount;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountsInfoView (MainView mainView)
	{
		this.mainView = mainView;
		setBackground(Color.LIGHT_GRAY);
		setLayout(gbl);	
		init();
		setAccount();
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
		lastEdited = new JLabel("");
		created = new JLabel("");
		lastEditedLabel = new JLabel("Last Edited: ");
		createdLabel = new JLabel("Created: ");
		infoLabel = new JLabel("Information of your Account: ");
		
		name = new JTextField(20);
		name.setEditable(false);
		description = new JTextArea(5,20);
		description.setEditable(false);
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		username = new JTextField(20);
		username.setEditable(false);
		email = new JTextField(20);
		email.setEditable(false);
		password = new JPasswordField(20);
		password.setEditable(false);
		url = new JTextField(20);
		url.setEditable(false);
		passwordHint = new JTextField(20);
		passwordHint.setEditable(false);
		info = new JTextArea(5,20);
		info.setEditable(false);
		info.setLineWrap(true);
		info.setWrapStyleWord(true);
		editButton = new JButton("Edit");
		saveButton = new JButton("Save");
	}
	public void setAccount()
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
		Utility.makeGBC(gbc, -1, 7, -1, -1, -1, 1, -1, GridBagConstraints.WEST, -1, -1);
		add(createdLabel,gbc);
		Utility.makeGBC(gbc, -1, 8, -1, -1, -1, 1, -1, GridBagConstraints.WEST, -1, -1);
		add(lastEditedLabel,gbc);
		Utility.makeGBC(gbc, -1, 9, -1, -1, -1, -1, -1, -1, -1, -1);
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
		Utility.makeGBC(gbc, -1, 8, -1, -1, -1, 1, -1, GridBagConstraints.WEST, -1, -1);
		add(created,gbc);
		Utility.makeGBC(gbc, -1, 9, -1, -1, -1, 1, -1, GridBagConstraints.WEST, -1, -1);
		add(lastEdited,gbc);
		Utility.makeGBC(gbc, 1, 10, -1, -1, -1, -1, -1, GridBagConstraints.SOUTHEAST, -1, -1);
		add(editButton,gbc);
		Utility.makeGBC(gbc, 1, 10, -1, -1, -1, -1, -1, GridBagConstraints.SOUTHWEST, -1, -1);
		add(saveButton,gbc);
		
	}
	public void updateUI(Accounts acc)
	{
		currentAccount=acc;
		name.setText(acc.getName());
		description.setText(acc.getDescription());
		username.setText(acc.getUsername());
		email.setText(acc.getEmail());
		password.setText(String.valueOf(acc.getPassword()));
		url.setText(acc.getUrl().toString());
		passwordHint.setText(acc.getPasswordHint());
		created.setText(acc.getCreationDate().toString());
		lastEdited.setText(acc.getLastEditedDate().toString());
		info.setText(acc.getInfo());
		
	}
	
	public void initListener()
	{
		editButton.addActionListener(new ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(ActionEvent e) {
            	
            	
            }
        });
		saveButton.addActionListener(new ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(ActionEvent e) {
            	
            }
        });
		
	}

}

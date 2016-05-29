package de.hhn.aib.digitdemens.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JCheckBox;
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
	private JButton editSaveButton;
	private JButton deleteCancelButton;
	private JCheckBox showPasswordBox;
	private MainView mainView;
	private Accounts account;
	private boolean editable;
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
		System.out.println(password.getEchoChar());
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
		editSaveButton = new JButton("Edit");
		deleteCancelButton = new JButton("Delete");
		showPasswordBox = new JCheckBox("Visible");
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
		add(infoLabel,gbc);
		Utility.makeGBC(gbc, -1, 8, -1, -1, -1, 1, -1, GridBagConstraints.WEST, -1, -1);
		add(createdLabel,gbc);
		Utility.makeGBC(gbc, -1, 9, -1, -1, -1, -1, -1, -1, -1, -1);
		add(lastEditedLabel,gbc);
		
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
		Utility.makeGBC(gbc, 2, 4, -1, -1, -1, 1, -1, GridBagConstraints.WEST, -1, -1);
		add(showPasswordBox,gbc);
		Utility.makeGBC(gbc, 1, 5, -1, -1, -1, 1, -1, GridBagConstraints.WEST, -1, -1);
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
		add(editSaveButton,gbc);
		Utility.makeGBC(gbc, 1, 10, -1, -1, -1, -1, -1, GridBagConstraints.SOUTHWEST, -1, -1);
		add(deleteCancelButton,gbc);
		
	}
	public void updateUI(Accounts acc)
	{
		editable = false;
		editSaveButton.setText("edit");
		deleteCancelButton.setText("delete");
		showPasswordBox.setSelected(false);
		account=acc;
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
	
	public void setEditable(boolean editable)
	{
    		name.setEditable(editable);
    		description.setEditable(editable);
    		username.setEditable(editable);
    		email.setEditable(editable);
    		password.setEditable(editable);
    		url.setEditable(editable);
    		passwordHint.setEditable(editable);
    		info.setEditable(editable);
    		if(editable)
    		{
    			editSaveButton.setText("save");
        		deleteCancelButton.setText("cancel");
    		}
    		else updateUI(account);
    		this.editable = editable;
	}
	public boolean getEditable()
	{
		return editable;
	}
	
	
	
	public void initListener()
	{
		editSaveButton.addActionListener(new ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(ActionEvent e) {
            	if(getEditable())
            	{
            		Main.editAccount(name.getText(), description.getText(), username.getText(), email.getText(), password.getPassword(), url.getText(), passwordHint.getText(), LocalDateTime.now(), info.getText(), account.getGroup(),account);
            		try {
						mainView.setAccounts();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            		setEditable(false);
            	}
            	else 
            	{
            		setEditable(true);
            	}
            	
            }
        });
		deleteCancelButton.addActionListener(new ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(ActionEvent e) {
            	if(getEditable())
            	{
            		setEditable(false);
            	}
            	else 
            	{
            		mainView.deleteAccount(account);
            	}
            	
            }
        });
		
		showPasswordBox.addItemListener(new ItemListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void itemStateChanged(ItemEvent  e) {
            	if (e.getStateChange() == ItemEvent.SELECTED) password.setEchoChar((char) 0);
            	else password.setEchoChar(('•'));
                   
            }
        });
		
	}

}

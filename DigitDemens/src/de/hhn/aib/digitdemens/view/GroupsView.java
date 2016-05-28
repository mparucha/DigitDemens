package de.hhn.aib.digitdemens.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import de.hhn.aib.digitdemens.controller.Main;
import de.hhn.aib.digitdemens.utility.Utility;


public class GroupsView extends JPanel{

	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	private JLabel nameLabel;
	private JLabel descriptionLabel;
	private JTextField name;
	private JTextArea description;
	private JButton okButton;
	private JButton cancelButton;
	private MainView mainView;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GroupsView (MainView mainView)
	{
		this.mainView = mainView;
		setBackground(Color.LIGHT_GRAY);
		setLayout(gbl);	
		init();
		setGroups();
		initListener();
	}
	
	public void init()
	{
		nameLabel = new JLabel("Name of Group: ");
		descriptionLabel = new JLabel("Description of Group: ");
		name = new JTextField(11);
		description = new JTextArea(5,20);
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		okButton = new JButton("OK");
		cancelButton = new JButton("Cancel");
	}
	public void setGroups()
	{
		gbc.insets  = new Insets(10,10,10,10);
		Utility.makeGBC(gbc, 0, 3, -1, -1, -1, -1, -1, GridBagConstraints.EAST, -1, -1);
		add(nameLabel,gbc);
		Utility.makeGBC(gbc, -1, 6, -1, -1, -1, -1, -1, -1, -1, -1);
		add(descriptionLabel,gbc);
		Utility.makeGBC(gbc, 4, 3, -1, -1, -1, 1, -1, GridBagConstraints.WEST, -1, -1);
		add(name,gbc);
		Utility.makeGBC(gbc, 4, 6, -1, -1, -1, -1, -1, -1, -1, -1);
		add(new JScrollPane(description),gbc);
		Utility.makeGBC(gbc, 4, 7, -1, -1, -1, -1, -1, GridBagConstraints.SOUTHEAST, -1, -1);
		add(okButton,gbc);
		Utility.makeGBC(gbc, 4, 7, -1, -1, -1, -1, -1, GridBagConstraints.SOUTHWEST, -1, -1);
		add(cancelButton,gbc);
		
	}
	
	public void initListener()
	{
		okButton.addActionListener(new ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(ActionEvent e) {
            	try {
					Main.addGroup(name.getText(), description.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	try {
					mainView.setView("InfoView");
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
					mainView.setView("InfoView");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
		
	}
}

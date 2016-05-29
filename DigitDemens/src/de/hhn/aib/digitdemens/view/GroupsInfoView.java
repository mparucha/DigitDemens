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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import de.hhn.aib.digitdemens.controller.Groups;
import de.hhn.aib.digitdemens.controller.Main;
import de.hhn.aib.digitdemens.utility.Utility;

public class GroupsInfoView extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	private JLabel nameLabel;
	private JLabel descriptionLabel;
	private JTextField name;
	private JTextArea description;
	private JButton editSaveButton;
	private JButton deleteCancelButton;
	private MainView mainView;
	private Groups group;
	private boolean editable;

	public GroupsInfoView (MainView mainView)
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
		name = new JTextField(20);
		name.setEditable(false);
		description = new JTextArea(5,20);
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		description.setEditable(false);
		editSaveButton = new JButton("Edit");
		deleteCancelButton = new JButton("Delete");
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
		add(editSaveButton,gbc);
		Utility.makeGBC(gbc, 4, 7, -1, -1, -1, -1, -1, GridBagConstraints.SOUTHWEST, -1, -1);
		add(deleteCancelButton,gbc);
		
	}
	
	public void updateUI(Groups group)
	{
		editable = false;
		editSaveButton.setText("edit");
		deleteCancelButton.setText("delete");
		this.group = group;
		name.setText(group.getName());
		description.setText(group.getDescription());
	}
	
	public void setEditable(boolean editable)
	{
    		name.setEditable(editable);
    		description.setEditable(editable);
    		if(editable)
    		{
    			editSaveButton.setText("save");
        		deleteCancelButton.setText("cancel");
    		}
    		else updateUI(group);
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
            		
            		try {
            			Main.editGroup(group,name.getText(), description.getText());
						mainView.setGroups();
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
            		mainView.deleteGroup(group);
            	}
            }
        });
		
	}

}

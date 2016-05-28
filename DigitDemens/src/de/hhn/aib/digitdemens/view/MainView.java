package de.hhn.aib.digitdemens.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ScrollPaneConstants;

import de.hhn.aib.digitdemens.controller.Groups;
import de.hhn.aib.digitdemens.controller.Main;
import de.hhn.aib.digitdemens.utility.Utility;

public class MainView extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel welcomeLabel;
	private JLabel groupsLabel;
	private JList <Groups> groupsList;
	private JButton deleteGroupButton;
	private JButton addGroupButton;
	private JScrollPane scrollBar;
	private JPanel cardPanel;
	private CardLayout cardLayout;
	private GroupsView groupsView;
	private InfoView infoView;
	private GridBagConstraints gbc;
	private GridBagLayout gbl;
	private Groups[] groups;
	
	public MainView()
	{
		super();
		init();
		setMain();
		initListener();
	}
	
	public void init()
	{
		gbl = new GridBagLayout();
		gbl.columnWidths = new int[]{250,800};
		gbl.rowHeights = new int[]{100,20,420,150};
		setLayout(gbl);
		
		
		welcomeLabel = new JLabel("Hello, Marek Parucha");
		welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		groupsLabel = new JLabel("Groups:");
		groupsList = new JList<Groups> ();
		groupsList.setVisibleRowCount(20);
		deleteGroupButton = new JButton("delete..");
		addGroupButton = new JButton("add..");
		gbc = new GridBagConstraints();
		groupsView = new GroupsView(this);
		infoView = new InfoView(this);
		groupsView.setPreferredSize(new Dimension(700,400));
		groupsList.setFixedCellHeight(20);
		scrollBar = new JScrollPane(groupsList,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		

		cardLayout = new CardLayout();
		cardPanel = new JPanel();
		cardPanel.setLayout(cardLayout);
		cardPanel.add(groupsView, "GroupsView");
		cardPanel.add(infoView,"InfoView");
	}
	
	public void setMain()
	{
		

		
		Utility.makeGBC(gbc, 0, 0, -1, -1, -1, -1, -1, GridBagConstraints.NORTHWEST, -1, -1);
		add(welcomeLabel,gbc);
		Utility.makeGBC(gbc, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1);
		add(groupsLabel,gbc);
		Utility.makeGBC(gbc, 0, 2, -1, -1, -1, -1, -1, -1, -1, -1);
		add(scrollBar,gbc);
		Utility.makeGBC(gbc, 0, 3, -1, -1, -1, -1, -1, GridBagConstraints.NORTHWEST, -1, -1);
		add(deleteGroupButton,gbc);
		Utility.makeGBC(gbc, 0, 3, -1, -1, -1, -1, -1, GridBagConstraints.NORTHEAST, -1, -1);
		add(addGroupButton,gbc);
		Utility.makeGBC(gbc, 1, 2, -1, -1, -1, -1, -1, GridBagConstraints.EAST, -1, -1);
		add(cardPanel,gbc);
		
		cardLayout.show(cardPanel,"InfoView");

	}
	
	
	public void setData() throws Exception
	{
		try {
			groups = Main.getGroups();
			groupsList.setListData(groups);
		} catch (NullPointerException e) {
			//groupsList.setListData(new Groups[0]);
			//e.printStackTrace();
		}
		
	}
	
	public void initListener()
	{
		addGroupButton.addActionListener(new ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(ActionEvent e) {
            	cardLayout.show(cardPanel, "GroupsView");
            }
        });
		deleteGroupButton.addActionListener(new ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(ActionEvent e) {
            	if(groupsList.getSelectedValue()!= null)
            	{
            		
	            	try {
						Main.deleteGroup(groupsList.getSelectedValue());
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
	            	try {
						setData();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
            }
        });
		
	}
	
	public void setView(String card) throws Exception
	{
		cardLayout.show(cardPanel, card);
		setData();
	}

}

package de.hhn.aib.digitdemens.view;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ScrollPaneConstants;

import de.hhn.aib.digitdemens.utility.Groups;
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
	private JPanel infoView;
	private GridBagConstraints gbc;
	private GridBagLayout gbl;
	
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
		gbl.rowHeights = new int[]{100,20,400,10};
		Groups[] groups = new Groups[50];
		for(int i = 0; i<groups.length; i++)
		{
			groups[i] = new Groups();
		}
		setLayout(gbl);
		welcomeLabel = new JLabel("Hello, Marek Parucha");
		groupsLabel = new JLabel("Groups:");
		groupsList = new JList<Groups> (groups);
		groupsList.setVisibleRowCount(-1);
		deleteGroupButton = new JButton("delete..");
		addGroupButton = new JButton("add..");

		infoView = new JPanel();
		gbc = new GridBagConstraints();
		infoView.add(groupsList);
		
		
	}
	
	public void setMain()
	{
		scrollBar = new JScrollPane(infoView,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//scrollBar.setViewportView(infoView);
		Utility.makeGBC(gbc, 0, 0, -1, -1, -1, -1, -1, GridBagConstraints.NORTHWEST, -1, -1);
		add(welcomeLabel,gbc);
		Utility.makeGBC(gbc, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1);
		add(groupsLabel,gbc);
		Utility.makeGBC(gbc, 0, 2, -1, -1, -1, -1, -1, -1, -1, -1);
		add(scrollBar,gbc);
		Utility.makeGBC(gbc, 0, 3, -1, -1, -1, -1, -1, GridBagConstraints.SOUTHWEST, -1, -1);
		add(deleteGroupButton,gbc);
		Utility.makeGBC(gbc, 0, 3, -1, -1, -1, -1, -1, GridBagConstraints.SOUTHEAST, -1, -1);
		add(addGroupButton,gbc);

	}
	
	public void initListener()
	{
		
	}
}

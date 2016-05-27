package de.hhn.aib.digitdemens.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import de.hhn.aib.digitdemens.controller.Login;
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
	private InfoView infoView;
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
		infoView = new InfoView();
		infoView.setPreferredSize(new Dimension(700,400));
		groupsList.setFixedCellHeight(20);
		scrollBar = new JScrollPane(groupsList,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
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
		add(infoView,gbc);

	}
	
	public void initListener()
	{
		
	}
	
	public void setData() throws Exception
	{
		try {
			groupsList.setListData(Login.getMain().getGroups());
		} catch (NullPointerException e) {
			//groupsList.setListData(new Groups[0]);
			//e.printStackTrace();
		}
		
	}

}

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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import de.hhn.aib.digitdemens.controller.Accounts;
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
	private JLabel accountsLabel;
	private JList <String> groupsList;
	private JList <String> accountsList;
	private JButton deleteGroupButton;
	private JButton addGroupButton;
	private JButton deleteAccountButton;
	private JButton addAccountButton;
	private JScrollPane scrollBarGroups;
	private JScrollPane scrollBarAccounts;
	private JPanel cardPanel;
	private CardLayout cardLayout;
	private GroupsView groupsView;
	private InfoView infoView;
	private AccountsView accountsView;
	private AccountsInfoView accountsInfoView;
	private GridBagConstraints gbc;
	private GridBagLayout gbl;
	private Accounts[] accounts;
	private Groups[] groups;
	private String[] groupsString;
	private String[] accountsString;
	private Groups currentGroup;
	
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
		gbl.columnWidths = new int[]{250,20,800};
		gbl.rowHeights = new int[]{75,20,250,50,20,250,50};
		setLayout(gbl);
		
		
		welcomeLabel = new JLabel("Hello, Marek Parucha");
		welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		groupsLabel = new JLabel("Groups:");
		accountsLabel = new JLabel("Accounts:");
		groupsList = new JList<String> ();
		groupsList.setVisibleRowCount(20);
		accountsList = new JList<String> ();
		accountsList.setVisibleRowCount(20);
		deleteGroupButton = new JButton("delete..");
		addGroupButton = new JButton("add..");
		deleteAccountButton = new JButton("delete..");
		addAccountButton = new JButton("add..");
		gbc = new GridBagConstraints();
		groupsView = new GroupsView(this);
		infoView = new InfoView(this);
		groupsView.setPreferredSize(new Dimension(700,400));
		accountsView = new AccountsView(this);
		accountsView.setPreferredSize(new Dimension(700,400));
		accountsInfoView = new AccountsInfoView(this);
		accountsInfoView.setPreferredSize(new Dimension(700,400));
		groupsList.setFixedCellHeight(20);
		scrollBarGroups = new JScrollPane(groupsList,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollBarAccounts = new JScrollPane(accountsList,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		

		cardLayout = new CardLayout();
		cardPanel = new JPanel();
		cardPanel.setLayout(cardLayout);
		cardPanel.add(groupsView, "GroupsView");
		cardPanel.add(infoView,"InfoView");
		cardPanel.add(accountsView,"AccountsView");
		cardPanel.add(accountsInfoView,"AccountsInfoView");
	}
	
	public void setMain()
	{
		

		
		Utility.makeGBC(gbc, 0, 0, -1, -1, -1, -1, -1, GridBagConstraints.NORTHWEST, -1, -1);
		add(welcomeLabel,gbc);
		Utility.makeGBC(gbc, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1);
		add(groupsLabel,gbc);
		Utility.makeGBC(gbc, 0, 2, -1, -1, GridBagConstraints.BOTH, -1, -1, -1, -1, -1);
		add(scrollBarGroups,gbc);
		Utility.makeGBC(gbc, 0, 4, -1, -1, GridBagConstraints.NONE, -1, -1, -1, -1, -1);
		add(accountsLabel,gbc);
		Utility.makeGBC(gbc, 0, 5, -1, -1, GridBagConstraints.BOTH, -1, -1, GridBagConstraints.NORTHWEST, -1, -1);
		add(scrollBarAccounts,gbc);
		Utility.makeGBC(gbc, 0, 3, -1, -1, GridBagConstraints.NONE, -1, -1, GridBagConstraints.NORTHWEST, -1, -1);
		add(deleteGroupButton,gbc);
		Utility.makeGBC(gbc, 0, 3, -1, -1, -1, -1, -1, GridBagConstraints.NORTHEAST, -1, -1);
		add(addGroupButton,gbc);
		Utility.makeGBC(gbc, 0, 6, -1, -1, GridBagConstraints.NONE, -1, -1, GridBagConstraints.NORTHWEST, -1, -1);
		add(deleteAccountButton,gbc);
		Utility.makeGBC(gbc, 0, 6, -1, -1, -1, -1, -1, GridBagConstraints.NORTHEAST, -1, -1);
		add(addAccountButton,gbc);
		Utility.makeGBC(gbc, 2, 2, -1, 4, GridBagConstraints.BOTH, -1, -1, GridBagConstraints.EAST, -1, -1);
		add(cardPanel,gbc);
		
		cardLayout.show(cardPanel,"InfoView");

	}
	
	
	public void setGroups() throws Exception
	{
		try {
			groups = Main.getGroups();
			groupsString = new String[groups.length];
			for(int i=0; i< groups.length; i++) groupsString[i] = groups[i].getName();
			groupsList.setListData(groupsString);
		} catch (NullPointerException e) {
			groupsList.setListData(new String[0]);
		}
		
	}
	public void setAccounts() throws Exception
	{
		try {
			accounts = Main.getAccounts(currentGroup);
			accountsString = new String[accounts.length];
			for(int i=0; i< accounts.length; i++) accountsString[i] = accounts[i].getName();
			accountsList.setListData(accountsString);
		} catch (NullPointerException e) {
			accountsList.setListData(new String[0]);
		}
		
	}
	
	public void initListener()
	{
		groupsList.addListSelectionListener(new ListSelectionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void valueChanged(ListSelectionEvent e) {
            	if(groupsList.getSelectedIndex()!=-1)
            	{
            		currentGroup = groups[groupsList.getSelectedIndex()];
	            	try {
						setAccounts();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
            }
        });
		
		accountsList.addListSelectionListener(new ListSelectionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void valueChanged(ListSelectionEvent e) {
            	if(accountsList.getSelectedIndex()!=-1)
            	{
            		try {
            			accountsInfoView.updateUI(accounts[accountsList.getSelectedIndex()]);
						setView("AccountsInfoView");
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
            	else
            	{
            		try {
						//setView("InfoView");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
            }
        });
		
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
						Main.deleteGroup(currentGroup);
						currentGroup = null;
						setGroups();
						setAccounts();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
            }
		});
            
            addAccountButton.addActionListener(new ActionListener() {
                // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
                public void actionPerformed(ActionEvent e) {
                	accountsView.setGroup(currentGroup);
                	cardLayout.show(cardPanel, "AccountsView");
                	try {
						setAccounts();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
            });
    		deleteAccountButton.addActionListener(new ActionListener() {
                // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
                public void actionPerformed(ActionEvent e) {
                	if(accountsList.getSelectedValue()!= null)
                	{
                		
    	            	try {
    						Main.deleteAccount(accounts[accountsList.getSelectedIndex()],currentGroup);
    						setGroups();
    						setAccounts();
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
		setGroups();
		setAccounts();
	}

}

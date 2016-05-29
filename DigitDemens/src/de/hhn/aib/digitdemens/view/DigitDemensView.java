package de.hhn.aib.digitdemens.view;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import de.hhn.aib.digitdemens.DigitDemens;
import de.hhn.aib.digitdemens.controller.Login;


public class DigitDemensView extends JFrame{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JPanel cardPanel;

	private CardLayout cardLayout = new CardLayout();
	private JMenuBar menuBar;
	private JMenu options;
	private JMenuItem directory;
	
	//Views
	private LoginView loginView;
	private RegisterView registerView;
	private MainView mainView;

	public DigitDemensView() {
		super("DigitDemens - Main");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(1200,800);
		initView();
	}
	

	public void initView()
	{
		loginView = new LoginView();
		registerView = new RegisterView();
		mainView = new MainView();
		cardPanel = (JPanel) getContentPane();
		cardPanel.setLayout(cardLayout);
		cardPanel.add(loginView, "Login");
		cardPanel.add(registerView, "Register");
		cardPanel.add(mainView, "Main");
		cardLayout.show(cardPanel, "Login");
		
		menuBar = new JMenuBar();
		options = new JMenu("Options");
		directory = new JMenuItem("Change Directory");

		menuBar.add(options);
		options.add(directory);
		this.setJMenuBar(menuBar);
		
	}
	
	public void setView(String view)
	{
		cardLayout.show(cardPanel, view);
	}
	
	public void setData()
	{
		try
		{
			mainView.setGroups();
		}
		catch(Exception e)
		{
			
		}
		
	}

}

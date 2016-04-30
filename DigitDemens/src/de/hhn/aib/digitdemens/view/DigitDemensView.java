package de.hhn.aib.digitdemens.view;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


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
	
	//other
	private LoginView loginView;
	private RegisterView registerView;

	public DigitDemensView() {
		super("DigitDemens - Main");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(1200,800);
		initView();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	public void initView()
	{
		loginView = new LoginView();
		registerView = new RegisterView();
		cardPanel = (JPanel) getContentPane();
		cardPanel.setLayout(cardLayout);
		cardPanel.add(loginView, "Login");
		cardPanel.add(registerView, "Register");
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
}

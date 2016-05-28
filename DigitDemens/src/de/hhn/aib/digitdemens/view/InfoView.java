package de.hhn.aib.digitdemens.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class InfoView extends JPanel {

	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MainView mainView;

	public InfoView (MainView mainView)
	{
		this.mainView = mainView;
		setBackground(Color.LIGHT_GRAY);
		setLayout(gbl);	
	}
}

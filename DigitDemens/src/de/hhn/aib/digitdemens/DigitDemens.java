package de.hhn.aib.digitdemens;

import de.hhn.aib.digitdemens.view.DigitDemensView;

public class DigitDemens {

	private static DigitDemensView dDView;
	
	public static void main(String[] args) {
		
		dDView = new DigitDemensView();
		dDView.setVisible(true);
		dDView.setLocationRelativeTo(null);

	}

}

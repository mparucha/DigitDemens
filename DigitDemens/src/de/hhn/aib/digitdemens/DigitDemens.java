package de.hhn.aib.digitdemens;


import de.hhn.aib.digitdemens.utility.Setup;
import de.hhn.aib.digitdemens.utility.Variables;
import de.hhn.aib.digitdemens.view.DigitDemensView;

public class DigitDemens {

	private static DigitDemensView dDView;


	public static void main(String[] args) {
		Setup.setProperties();
		dDView = new DigitDemensView();
		dDView.setSize(Variables.getWindowWidth(), Variables.getWindowHeight());
		dDView.setVisible(true);
		dDView.setLocationRelativeTo(null);

	}

	public static DigitDemensView getdDView() {
		return dDView;
	}


}

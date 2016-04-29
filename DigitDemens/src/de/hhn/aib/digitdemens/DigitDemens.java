package de.hhn.aib.digitdemens;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;

import de.hhn.aib.digitdemens.utility.Crypt;
import de.hhn.aib.digitdemens.view.DigitDemensView;

public class DigitDemens {

	private static DigitDemensView dDView;
	
	public static void main(String[] args) {
		
		dDView = new DigitDemensView();
		dDView.setVisible(true);
		dDView.setLocationRelativeTo(null);

	}

	public static DigitDemensView getdDView() {
		return dDView;
	}


}

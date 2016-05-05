package de.hhn.aib.digitdemens.utility;

import java.awt.GridBagConstraints;
import java.io.File;

public class Utility {
	
	/**
	 * if param == -1 nothing will change
	 * @param gbc
	 * @param gridx
	 * @param gridy
	 * @param gridwidth
	 * @param gridheight
	 * @param fill
	 * @param ipadx
	 * @param ipady
	 * @param anchor
	 * @param weightx
	 * @param weighty
	 */
	public static void makeGBC(GridBagConstraints gbc, int gridx, int gridy, int gridwidth, int gridheight, int fill, int ipadx, int ipady, int anchor, double weightx, double weighty )
	{
		if(gridx != -1)gbc.gridx = gridx;
		if(gridy != -1)gbc.gridy = gridy;
		if(gridwidth != -1)gbc.gridwidth = gridwidth;
		if(gridheight != -1)gbc.gridheight = gridheight;
		if(fill != -1)gbc.fill = fill;
		if(ipadx != -1)gbc.ipadx = ipadx;
		if(ipady != -1)gbc.ipady = ipady;
		if(anchor != -1)gbc.anchor = anchor;
		if(weightx != -1)gbc.weightx = weightx;
		if(weighty != -1)gbc.weighty = weighty;
	}
	
	public static String decryptFile(File path, String pass) throws Exception
	{
		FileInput fi = new FileInput(path);
		Crypt decrypt = new Crypt(KeyGen.generatedKey(pass),"AES");
		String text = fi.readFromFileToString();
		return decrypt.decrypt(text);
	}
	

}

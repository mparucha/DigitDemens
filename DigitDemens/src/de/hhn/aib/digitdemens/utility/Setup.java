package de.hhn.aib.digitdemens.utility;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Setup {

	public static void setProperties()
	{
		Properties props = new Properties();
		try {
			FileReader fi = new FileReader(Variables.systemDir+"\\config.properties");
			props.load(fi);
			Variables.setWindowHeight(Integer.parseInt(props.getProperty("WindowHeight","800")));
			Variables.setWindowWidth(Integer.parseInt(props.getProperty("WindowWidth","1200")));
			Variables.setWorkingDir(props.getProperty("UserDirectory",Variables.workingDir));
		} catch (IOException e) {
			try {
				setText(props);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	private static void setText(Properties props) throws IOException
	{
		props.setProperty("UserDirectory",Variables.workingDir);
		props.setProperty("WindowWidth","1200");
		props.setProperty("WindowHeight","800");
		props.store(new FileWriter(Variables.systemDir+"\\config.properties"),"#Please Configure the Variables like you want.");
	}
}

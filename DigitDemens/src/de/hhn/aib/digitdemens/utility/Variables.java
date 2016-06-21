package de.hhn.aib.digitdemens.utility;

public class Variables {
	
public static String workingDir = System.getProperty("user.home")+"\\DigitalDemens\\";
public static final String systemDir = System.getProperty("user.dir");
public static int windowHeight = 800;
public static int windowWidth = 1200;
public static String getWorkingDir() {
	return workingDir;
}
public static void setWorkingDir(String workingDir) {
	Variables.workingDir = workingDir;
}
public static int getWindowHeight() {
	return windowHeight;
}
public static void setWindowHeight(int windowHeight) {
	Variables.windowHeight = windowHeight;
}
public static int getWindowWidth() {
	return windowWidth;
}
public static void setWindowWidth(int windowWidth) {
	Variables.windowWidth = windowWidth;
}


}

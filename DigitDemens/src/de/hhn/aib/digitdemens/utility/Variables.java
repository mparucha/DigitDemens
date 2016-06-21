package de.hhn.aib.digitdemens.utility;

public class Variables {
	
private static String workingDir = System.getProperty("user.home")+"\\DigitalDemens\\";
private static final String systemDir = System.getProperty("user.dir");
private static int windowHeight = 800;
private static int windowWidth = 1200;
private static String userHome = System.getProperty("user.name");


public static String getUserName() {
	return userHome;
}

public static String getSystemDir() {
	return systemDir;
}
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

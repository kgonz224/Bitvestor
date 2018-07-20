/*
 *      File: GuiAux.java
 *      Project: Bitvestor
 *      Author(s): Eddie Noguera, Kevin Gonzalez
 *      Creation Date: 07/1/2018
 *      Language: Java
 *
 *      ********************************************************
 *
 *      Description:
 *              A helper class to facilitate communication among the different
 *              classes. This class also holds constanst used in other classes.
 *
 *      Methods:
 *             void sleep();
 *             void sleep(int);
 */


package DesktopApp;

public final class GuiAux {

	protected static final int POLLING_TIME = 3000; // In milliseconds

	protected static final String TITLE = "Bitvestor: Making money cents " +
		"at a time.";

	protected static final String TERMS = "This is program designed to an" +
		"alyze different crypto markets\nto automatically invest in t" +
		"he most appropiate market and pull\nwhen the market is near " +
                "falling. Please remember that there is\nno way for a program" +
	        " to predict the future. With that said, it\nis our goal to m" +
		"ake as much profits as possible but there is\npossibility of" +
	        " losses. As a safety precaution,\n\nONLY INVEST WHAT YOU ARE" +
	        " WILLING TO LOSE.\n\nThese markets are highly volitile are c" +
		"an have rapid unexpected\ndrops causing loss of initial inve" +
		"stments. Please DO NOT force\nclose the program onced logged" +
		" in. This can cause loss in\ninvestments and profits as well" +
		". Once you want to close the program\nclick log out and wait" +
	       	" for the all clear message. Please check\nthe box bellow to " +
		"continue with the understanding that money can\nbe lost as f" +
		"requently as won.";

	protected static boolean launchSignIn = true;
	protected static boolean launchRegistration = false;
	protected static boolean launchForgot = false;

	public GuiAux() {}

	public void sleep() {
		try {
			Thread.sleep(POLLING_TIME);
		}
		catch(InterruptedException e){
			System.out.println("Failed to wait.");
		}
		return;
	}
}

/*******************************************************************************
|       File: GUI.java
|       Project: Bitvestor
|       Author(s): Eddie Noguera, Kevin Gonzalez
|       Creation Date: 05/31/2018
|       Language: Java
|
|       Compilation: javac Bitvestor.java
|       Execution: java Bitvestor
|
|       **********************************************************
|
|       Description:
|               Takes care of user interface. All interactions are done through
|		this class.
|
|	Methods:
|		getLogoutStatus()
|		getPassword()
|		getUserName()
|		introMessage()
|		logout()
|		register()
|		signIn()
|		waitForLogin()
|		waitForLogout(long)
|		waitForTerms()
|
*******************************************************************************/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


//FIXME: This class is for operational purposes for now.
//FIXME: This GUI will improve in appearance when program is mostly done.


class GUI {

	final String HEADER = "BITVESTOR: Making money cents at a time";
	final int POLLING_INTERVAL = 1000;

	private boolean readTerms = false;
	private boolean termsAccepted = false;	

	private boolean logout = false;

	private String usr = null;
	private String pssw = null;
	private boolean loginAttempted = false;

	private boolean registrationAttempted = false;
	private String wallet = null;
	private String email = null;
	private String phone = null;

	/**
	 * boolean getLogoutStatus()
	 *
	 * Returns whether user logged out
	 *
	 * @author: Kevin Gonzalez
	 * @version: 0.0
	 * @date: 06/01/2018
	 * @return: boolean logout
	 * 	Returns true if user clicked logout.
	 */
	protected boolean getLogoutStatus() {
		return logout;
	}

	/**
	 * boolean getPassword()
	 *
	 * Returns password.
	 *
	 * @author: Kevin Gonzalez
	 * @version: 0.0
	 * @date: 06/07/2018
	 * @return: String pssw
	 * 	Password user inputs.
	 */
	protected String getPassword() {
		return pssw;
	}

	/**
	 * String getUserName()
	 *
	 * Returns user name.
	 *
	 * @author: Kevin Gonzalez
	 * @version: 0.0
	 * @date: 06/07/2018
	 * @return: String usr
	 * 	User name user inputs.
	 */
	protected String getUserName() {
		return usr;
	}

	/**
	 * void introMessage()
	 *
	 * Displays the intro screen of the program.
	 * Accept the terms and then the program will continue.
	 *
	 * @author: Kevin Gonzalez
	 * @version: 0.0
	 * @date: 06/06/2018
	 * @return: void
	 */
	protected void introMessage() {

		final int FRAME_WIDTH = 500;
		final int FRAME_HEIGHT = 500;
		final String WARNING = "<html>This is program designed " +
			"to analyze different crypto markets<br>to " +
			"automatically invest in the most appropiate<br>" +
			"market and pull when the market is near falling.<br>" +
			"Please remember that there is no way for a program<br>" +
			"to predict the furture. With that said, it is<br>our" +
		        "goal to make as much profits as possible but<br>there" +
			"is possibility of losses. As a safety precaution,<br>" +
		        "<br>ONLY INVEST WHAT YOU ARE WILLING TO LOSE.<br>" +
			"<br>These markets are highly volitile are can have<br>" +
			"rapid unexpected drops causing loss of initial investments." +
			"<br>Please DO NOT force close the program onced logged" +
		        "in.<br>This can cause loss in investments and profits " +
			"as<br>well. Once you want to close the program click log " +
		        "out and<br>wait for the all clear message. Please check " +
			"the box<br>bellow to continue with the understanding " +
			"that money can<br>be lost as frequently as won.<br>" +
			"<br></html>";

		//JFrame
		JFrame frame = new JFrame(HEADER);
		frame.setResizable(false);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JPanel
		JPanel textPanel = new JPanel(new FlowLayout());
		JPanel checkPanel = new JPanel(new FlowLayout());
		JPanel buttonPanel = new JPanel(new FlowLayout());
		
		//JLabel
		JLabel warningTxt = new JLabel(WARNING);

		//JCheckBox
		JCheckBox checkTerms = new JCheckBox("I accept and understand the risks");
		checkTerms.setSelected(readTerms);
		checkTerms.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent click) {
				Object accepted = click.getItemSelectable();
				if(accepted == checkTerms)
					readTerms = !readTerms;
			}
		});

		//JButton
		JButton continueBtn = new JButton("Continue");
		continueBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent click) {
				if (readTerms) {
					termsAccepted = true;
					frame.dispose();
				}
			}
		});

		//Putting it together.
		textPanel.add(warningTxt);
		checkPanel.add(checkTerms);
		buttonPanel.add(continueBtn);
		frame.add(textPanel, BorderLayout.NORTH);
		frame.add(checkPanel, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		frame.setVisible(true);

		return;

	} // End of introMessage()

	/**
	 * void logout();
	 *
	 * Creates a non-resizable window with a message, disabled 'X' button,
	 * and a logout button. When pressed changes variable logout to true.
	 *
	 * @author: Kevin Gonzalez
	 * @version: 0.0
	 * @date: 06/01/2018
	 * @return: void
	 */
	protected void logout() {

		final int FRAME_WIDTH = 500;
		final int FRAME_HEIGHT = 180;
		final String REMINDER_TXT = "<html><center>Please do NOT " +
			"force close program. Investments may <br>stay as " + 
			"crypto in unstable markets. Please click <br>'Logout'" +
		        " when finished and wait for completion message." +
			"<br><br></center></html>";

		//JFrame
		JFrame frame = new JFrame(HEADER);
		frame.setResizable(false);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		//JPanel
		JPanel topPanel = new JPanel(new FlowLayout());
		JPanel bottomPanel = new JPanel(new FlowLayout());
		
		//JLabel
		JLabel reminderTxt = new JLabel(REMINDER_TXT);

		//JButton
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent click) {
				logout = true;
				frame.dispose();
			}
		});

		//Putting it together.
		topPanel.add(reminderTxt);
		bottomPanel.add(logoutBtn);
		frame.add(topPanel, BorderLayout.NORTH);
		frame.add(bottomPanel);
		frame.setVisible(true);

		return;

	} // End of logout()

	/**
	 * void register()
	 *
	 * Shows the register window. Grabs credentials for new users.
	 *
	 * @author: Kevin Gonzalez
	 * @version: 0.0
	 * @date: 06/09/2018
	 * @return: void
	 */
	protected void register() {

		final int FRAME_WIDTH = 500;
		final int FRAME_HEIGHT = 400;
		final int NUMBER_OF_ELEMENTS = 6;

		//JFrame
		JFrame frame = new JFrame(HEADER);
		frame.setResizable(false);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JPanel
		JPanel headerPnl = new JPanel(new GridLayout(1,1,5,5));
		JPanel continuePnl = new JPanel();
		JPanel registerPnl = new JPanel(new GridLayout(NUMBER_OF_ELEMENTS,2,0,10));

		//JLabel
		JLabel headerTxt = new JLabel("<html><b>Register</b><br><br></html>");
		JLabel userNameLb = new JLabel("User Name:");
		JLabel passwordLb = new JLabel("Password:");
		JLabel walletLb = new JLabel("Gemini Wallet Address:");
		JLabel emailLb = new JLabel("E-mail:");
		JLabel phoneLb = new JLabel("*Phone:");
		JLabel astericsLb = new JLabel("Any element with asterics is optional.");

		//textField
		JTextField userNameTF = new JTextField();
		JTextField passwordTF = new JTextField();
		JTextField walletTF = new JTextField();
		JTextField emailTF = new JTextField();
		JTextField phoneTF = new JTextField();

		//JButton
		JButton signInBtn = new JButton("Sign-In");
		signInBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent click) {
				registrationAttempted = false;
				frame.dispose();
				signIn();
			}
		});

		JButton signUpBtn = new JButton("Sign-Up");
		signUpBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent click) {
				registrationAttempted = true;
				usr = userNameTF.getText();
				pssw = passwordTF.getText();
				wallet = walletTF.getText();
				email = emailTF.getText();
				phone = phoneTF.getText();
				frame.dispose();
			}
		});

		//Putting it together.
		headerPnl.add(headerTxt);
		headerPnl.add(signInBtn);
		registerPnl.add(userNameLb);
		registerPnl.add(userNameTF);
		registerPnl.add(passwordLb);
		registerPnl.add(passwordTF);
		registerPnl.add(walletLb);
		registerPnl.add(walletTF);
		registerPnl.add(emailLb);
		registerPnl.add(emailTF);
		registerPnl.add(phoneLb);
		registerPnl.add(phoneTF);
		registerPnl.add(astericsLb);
		continuePnl.add(signUpBtn);
		frame.add(headerPnl, BorderLayout.NORTH);
		frame.add(registerPnl, BorderLayout.CENTER);
		frame.add(continuePnl, BorderLayout.SOUTH);
		frame.setVisible(true);

		return;

	} // End of register()

	/**
	 * void signIn()
	 *
	 * Shows sign-in window. Grabs user name and password.
	 *
	 * @author: Kevin Gonzalez
	 * @version: 0.0
	 * @date: 06/07/2018
	 * @return: void
	 */
	protected void signIn() {
		
		final int FRAME_WIDTH = 500;
		final int FRAME_HEIGHT = 250;
		
		usr = null;
		pssw = null;

		// JFrame
		JFrame frame = new JFrame(HEADER);
		frame.setResizable(false);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JPanel
		JPanel headerPnl = new JPanel(new GridLayout(1,2,5,5));
		JPanel continuePnl = new JPanel();
		JPanel signInPnl = new JPanel(new GridLayout(3,2,5,10));

		// JLabel
		JLabel headerTxt = new JLabel("<html><b>Sign-In</b><br><br></html>");
		JLabel userNameLb = new JLabel("User Name:");
		JLabel passwordLb = new JLabel("Password:");

		// JTextField
		JTextField userNameTF = new JTextField();
		JTextField passwordTF = new JTextField();

		// JButton
		JButton forgotBtn = new JButton("Forgot Login");
		//FIXME: add action listener	

		JButton registerBtn = new JButton("Register");
		registerBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent click) {
				frame.dispose();
				register();
			}
		});

		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent click) {
				usr = userNameTF.getText();
				pssw = passwordTF.getText();
				loginAttempted = true;
				frame.dispose();
			}
		});

		// Putting it together
		headerPnl.add(headerTxt);
		headerPnl.add(forgotBtn);
		headerPnl.add(registerBtn);
		signInPnl.add(userNameLb);
		signInPnl.add(userNameTF);
		signInPnl.add(passwordLb);
		signInPnl.add(passwordTF);
		// If login has been tried before
		if(loginAttempted) {
			loginAttempted = false;
			JLabel failedLoginLb = new JLabel("Incorrect username or password.");
			signInPnl.add(failedLoginLb);
		}
		continuePnl.add(loginBtn);
		frame.add(headerPnl, BorderLayout.NORTH);
		frame.add(signInPnl, BorderLayout.CENTER);
		frame.add(continuePnl, BorderLayout.SOUTH);
		frame.setVisible(true);

		return;

	} // End of signIn()

	/**
	 * void waitForLogin()
	 *
	 * Loops until loggedIn is true. Use with signIn()
	 *
	 * @author: Kevin Gonzalez
	 * @version: 0.0
	 * @date: 06/07/2018
	 * @return: void
	 */
	protected void waitForLogin() {
		while(!loginAttempted) {
			try {
				Thread.sleep(POLLING_INTERVAL);
			}
			catch(InterruptedException e) {
				System.out.println("Failed to wait.");
			}
		}
		return;
	}

	/**
	 * void waitForLogout(long totalSec)
	 *
	 * Loops until logout is true or for x amount of seconds.
	 * Use with logout()
	 *
	 * @author: Kevin Gonzalez
	 * @version: 0.0
	 * @date: 06/07/2018
	 * @param: totalSec
	 * 	Amount of seconds checking for logout
	 * @return: void
	 */
	protected void waitForLogout(long totalSec) {
		for(long second = 0; second < totalSec && !logout; second++) {
			System.out.println("I'm still here");	//FIXME: Delete line.
			try {
				Thread.sleep(POLLING_INTERVAL);
			}
			catch(InterruptedException e) {
				System.out.println("Failed to wait.");
			}
		}
		return;
	}

	/**
	 * void waitForTerms()
	 *
	 * Loops until termsAccepted is true. Use with introMessage()
	 *
	 * @author: Kevin Gonzalez
	 * @version: 0.0
	 * @date: 06/07/2018
	 * @return: void
	 */
	protected void waitForTerms() {
		while(!termsAccepted) {
			try {
				Thread.sleep(POLLING_INTERVAL);
			}
			catch(InterruptedException e) {
				System.out.println("Failed to wait.");
			}
		}
		return;
	}
}

/*
 *	File: SignIn.java
 *	Project: Bitvestor
 *	Author(s): Eddie Noguera, Kevin Gonzalez
 *	Creation Date: 06/24/2018
 *	Language: Java
 *
 *	********************************************************
 *
 *	Description:
 *		Creates and controls desktop sign-in window using Java Swing
 *		and awt.
 *
 *	Methods:
 *		void actionPerformed(ActionEvent);
 *		boolean attempted();
 *		boolean done();
 *		String getPssw();
 *		String getUsrname();
 *		boolean isSignInToggled();
 *		void launch();
 *		void reset();
 *		void setAttempted(boolean);
 *		void setDone(boolean);
 */

package DesktopApp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignIn extends JFrame implements ActionListener {

	private JButton forgotBtn = null;
	private JButton registerBtn = null;
	private JButton signInBtn = null;
	private JLabel errLB = null;
	private JTextField usrnameTF = null;
	private JTextField psswTF = null;

	private boolean attempted = false;
	private boolean signInBtnToggled = false;
	private boolean done = false;
	private String usrname = null;
	private String pssw = null;

	/**
	 * Constructor 1
	 *
	 * @author: Kevin Gonzalez
	 * @version: 1.0
	 * @date: 06/24/2018
	 */
	public SignIn() { //FIXME: Fix layout

		setTitle(GuiAux.TITLE);

		GridBagConstraints layout = null;
		JLabel psswLB = null;
		JLabel signInLB = null;
		JLabel usrnameLB = null;

		// Creating JLabels
		errLB = new JLabel("<html>Incorrect user name or password.<br>" +
				"Please try again.</html>");
		errLB.setForeground(Color.red);
		psswLB = new JLabel("Password:");
		signInLB = new JLabel("Sign-In");
		usrnameLB = new JLabel("Username:");

		// Creating Text Fields
		usrnameTF = new JTextField(15);
		psswTF = new JTextField(15);

		// Creating Buttons
		forgotBtn = new JButton("Forgot");
		forgotBtn.addActionListener(this);
		registerBtn = new JButton("Register");
		registerBtn.addActionListener(this);
		signInBtn = new JButton("Sign-In");
		signInBtn.addActionListener(this);

		// Grid Layout
		setLayout(new GridBagLayout());
		
		layout = new GridBagConstraints();
		layout.insets = new Insets(10, 20, 10, 10);
		layout.anchor = GridBagConstraints.LINE_START;
		layout.gridx = 0;
		layout.gridy = 0;
		add(signInLB, layout);
			
		layout = new GridBagConstraints();
		layout.insets = new Insets(10, 10, 10, 0);
		layout.anchor = GridBagConstraints.LINE_END;
		layout.gridx = 2;
		layout.gridy = 0;
		add(forgotBtn, layout);

		layout = new GridBagConstraints();
		layout.insets = new Insets(10, 0, 10, 20);
		layout.anchor = GridBagConstraints.LINE_END;
		layout.gridx = 3;
		layout.gridy = 0;
		add(registerBtn, layout);

		layout = new GridBagConstraints();
		layout.insets = new Insets(10, 20, 5, 10);
		layout.anchor = GridBagConstraints.CENTER;
		layout.gridx = 0;
		layout.gridy = 1;
		layout.gridwidth = 2;
		add(usrnameLB, layout);

		layout = new GridBagConstraints();
		layout.insets = new Insets(10, 10, 5, 20);
		layout.anchor = GridBagConstraints.LINE_END;
		layout.fill = GridBagConstraints.BOTH;
		layout.gridx = 2;
		layout.gridy = 1;
		layout.gridwidth = 2;
		add(usrnameTF, layout);

		layout = new GridBagConstraints();
		layout.insets = new Insets(5, 20, 10, 10);
		layout.anchor = GridBagConstraints.CENTER;
		layout.gridx = 0;
		layout.gridy = 2;
		layout.gridwidth = 2;
		add(psswLB, layout);

		layout = new GridBagConstraints();
		layout.insets = new Insets(5, 10, 10, 20);
		layout.anchor = GridBagConstraints.LINE_END;
		layout.fill = GridBagConstraints.BOTH;
		layout.gridx = 2;
		layout.gridy = 2;
		layout.gridwidth = 2;
		add(psswTF, layout);

		layout = new GridBagConstraints();
		layout.insets = new Insets(10, 10, 10, 20);
		layout.anchor = GridBagConstraints.LINE_END;
		layout.gridx = 3;
		layout.gridy = 4;
		add(signInBtn, layout);
	}

	/**
	 * Runs after any button is pressed.
	 *	Forgot Button - Launches Forgot window
	 *	Register Button - Launches Forgot window
	 *	Sign-In Button - Changes attempted to true,
	 *			disposes window.
	 *
	 * @author: Kevin Gonzalez
	 * @version: 1.0
	 * @date: 06/24/2018
	 * @return: void
	 */
	@Override
	public void actionPerformed(ActionEvent click) {

		JButton sourceEvent = (JButton) click.getSource();

		if(sourceEvent == forgotBtn) {
			GuiAux.launchForgot = true;
		}

		else if (sourceEvent == registerBtn) {
			GuiAux.launchRegistration = true;
		}

		else if (sourceEvent == signInBtn) {

			setVisible(false);
			signInBtnToggled = true;

			if(!attempted) {

				GridBagConstraints layout = 
					new GridBagConstraints();
				layout.insets = new Insets (10, 20, 10, 10);
				layout.anchor = GridBagConstraints.LINE_START;
				layout.gridx = 0;
				layout.gridy = 3;
				layout.gridwidth = 3;
				add(errLB, layout);

				attempted = true;
			}
			
			usrname = usrnameTF.getText();
			pssw = psswTF.getText();
			dispose();

		} // end of else if

	} // end of actionPerformed(ActionEvent)

	/**
	 * Returns whether sign-in has been attempted
	 *
	 * @author: Kevin Gonzalez
	 * @vesion: 1.0
	 * @date: 06/24/2018
	 * @return: boolean attempted
	 * 	True if sign-in has been attempted
	 */
	protected boolean attempted() {
		return attempted;
	}

	/**
         * Returns whether sign-In is complete
         *
         * @author: Kevin Gonzalez
         * @vesion: 1.0
         * @date: 06/24/2018
         * @return: boolean done
         *      True if sign-in has is done
         */
        protected boolean done() {
                return done;
        }

	/**
	 * Gets password
	 *
	 * @author: Kevin Gonzalez
	 * @version: 1.0
	 * @date: 06/24/2018
	 * @return: String pssw
	 * 	Password inputted after user pressed sign-in.
	 */
	public String getPssw() {
		return pssw;
	}

	/**
	 * Gets username
	 *
	 * @author: Kevin Gonzalez
	 * @version: 1.0
	 * @date: 06/24/2018
	 * @return: String usrname
	 * 	Username inputted after user pressed sign-in.
	 */
	public String getUsrname() {
		return usrname;
	}

	/**
	 * Returns whether Sign-In button is toggled
	 *
	 * @author: Kevin Gonzalez
	 * @version: 1.0
	 * @date: 07/03/2018
	 * @return: signInBtnToggled
	 * 	True if sign-in was toggled
	 */
	public boolean isSignInToggled() {
		return signInBtnToggled;
	}

	/**
	 * Launches sign-in window
	 *
	 * @author: Kevin Gonzalez
	 * @version: 1.0
	 * @date: 06/24/2018
	 * @return: void
	 */
	public void launch() {
		GuiAux.launchSignIn = false;
		signInBtnToggled = false;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		return;
	}

	/**
	 * Resets attempted and removes err label from sign-in
	 *
	 * @author: Kevin Gonzalez
	 * @version: 1.0
	 * @date: 07/03/2018
	 * @return: void
	 */
	public void reset() {
		if(attempted) {
			attempted = false;
			remove(errLB);
		}
		return;
	}

	/**
	 * Sets attempted
	 *
	 * @author: Kevin Gonzalez
	 * @version: 1.0
	 * @date: 06/24/2018
	 * @param: boolean attempted
	 * 	Value stored in boolean attempted
	 * 	(attempted = if sign-in has been attempted)
	 * @return: void
	 */
	protected void setAttempted(boolean attempted) {
		this.attempted = attempted;
		return;
	}

	/**
	 * Sets done
	 *
	 * @author: Kevin Gonzalez
	 * @version: 1.0
	 * @date: 07/01/2018
	 * @param: boolean done
	 * 	True if sign-in is complete
	 * @return: void
	 */
	public void setDone(boolean done) {
		this.done = done;
		return;
	}
}

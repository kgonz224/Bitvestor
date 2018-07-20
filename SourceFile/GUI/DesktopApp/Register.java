/*
 *	File: Register.java
 *	Project: Bitvestor
 *	Author(s): Eddie Noguera, Kevin Gonzalez
 *	Creation Date: 06/28/2018
 *	Language: Java
 *
 *	********************************************************
 *
 *	Description:
 *		Creates and controls desktop register window using Java Swing
 *		and awt.
 *
 *	Methods:
 *		void actionPerformed(ActionEvent);
 *		boolean attempted();
 *		boolean done();
 *		String getEmail();
 *		String getPssw();
 *		String getPsswConf();
 *		String getUsrname();
 *		String getWallet();
 *		String getWalletConf();
 *		boolean isRegisterToggled();
 *		void launch();
 *		void launchHint();
 *		void reset();
 *		void setAttempted(boolean);
 *		void setDone(boolean);
 *		void setEmailValidity(boolean);
 *		void setPsswValidity(boolean);
 *		void setUsrnameValidity(boolean);
 *		void setWalletValidity(boolean);
 */

package DesktopApp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Register extends JFrame implements ActionListener {

	private JLabel usrnameLB = null;
	private JLabel psswLB = null;
	private JLabel psswConfLB = null;
	private JLabel emailLB = null;
	private JLabel gemWalletLB = null;
	private JLabel gemWalletConfLB = null;
	private JLabel errLB = null;
	
	private JTextField usrnameTF = null;
	private JTextField psswTF = null;
	private JTextField psswConfTF = null;
	private JTextField emailTF = null;
	private JTextField gemWalletTF = null;
	private JTextField gemWalletConfTF = null;

	private JButton signInBtn = null;
	private JButton hintBtn = null;
	private JButton registerBtn = null;

	private boolean usrnameValid = true;
	private boolean psswValid = true;
	private boolean emailValid = true;
	private boolean gemWalletValid = true;
	private boolean attempted = false;
	private boolean done = false;
	private boolean registerBtnToggled = false;

	private String usrname = null;
	private String pssw = null;
	private String psswConf = null;
	private String email = null;
	private String gemWallet = null;
	private String gemWalletConf = null;

	/**
	 * Constructor
	 *
	 * @author: Kevin Gonzalez
	 * @version: 1.0
	 * @date: 06/28/2018
	 */
	public Register () {

		setTitle(GuiAux.TITLE);

		GridBagConstraints layout = null;
		JLabel registerLB = null;

		// Creating Label
		registerLB = new JLabel("Registration");
		usrnameLB = new JLabel("Username:");
		psswLB = new JLabel("Password:");
		psswConfLB = new JLabel("Confirm Password:");
		emailLB = new JLabel("E-mail:");
		gemWalletLB = new JLabel("Gemini Wallet:");
		gemWalletConfLB = new JLabel("Confirm Gemini Wallet:");
		errLB = new JLabel("Review red entries.");
		errLB.setForeground(Color.red);
		
		// Creating Text Fields
		usrnameTF = new JTextField(20);
		psswTF = new JTextField(20);
		psswConfTF = new JTextField(20);
		emailTF = new JTextField(20);
		gemWalletTF = new JTextField(20);
		gemWalletConfTF = new JTextField(20);

		// Create Button
		JButton signInBtn = new JButton("Sign-In");
		signInBtn.addActionListener(this);
		JButton hintBtn = new JButton("Hints");
		hintBtn.addActionListener(this);
		JButton registerBtn = new JButton("Register");
		registerBtn.addActionListener(this);

		// Grid Layout
		setLayout(new GridBagLayout());

		layout = new GridBagConstraints();
		layout.insets = new Insets(10, 20, 10, 10);
		layout.anchor = GridBagConstraints.LINE_START;
		layout.gridx = 0;
		layout.gridy = 0;
		add(registerLB, layout);

		layout = new GridBagConstraints();
		layout.insets = new Insets(10, 10, 10, 20);
		layout.anchor = GridBagConstraints.LINE_END;
		layout.gridx = 3;
		layout.gridy = 0;
		add(signInBtn, layout);

		layout = new GridBagConstraints();
		layout.insets = new Insets(10, 20, 5, 10);
		layout.anchor = GridBagConstraints.LINE_START;
		layout.gridx = 0;
		layout.gridy = 1;
		layout.gridwidth = 2;
		add(usrnameLB, layout);

		layout = new GridBagConstraints();
		layout.insets = new Insets(10, 10, 5, 20);
		layout.anchor = GridBagConstraints.LINE_END;
		layout.gridx = 2;
		layout.gridy = 1;
		layout.gridwidth = 2;
		add(usrnameTF, layout);

		layout = new GridBagConstraints();
		layout.insets = new Insets(5, 20, 5, 10);
		layout.anchor = GridBagConstraints.LINE_START;
		layout.gridx = 0;
		layout.gridy = 2;
		layout.gridwidth = 2;
		add(psswLB, layout);

		layout = new GridBagConstraints();
                layout.insets = new Insets(5, 10, 5, 20);
                layout.anchor = GridBagConstraints.LINE_END;
                layout.gridx = 2;
                layout.gridy = 2;
                layout.gridwidth = 2;
                add(psswTF, layout);

                layout = new GridBagConstraints();
                layout.insets = new Insets(5, 20, 5, 10);
                layout.anchor = GridBagConstraints.LINE_START;
                layout.gridx = 0;
                layout.gridy = 3;
                layout.gridwidth = 2;
                add(psswConfLB, layout);

                layout = new GridBagConstraints();
                layout.insets = new Insets(5, 10, 5, 20);
                layout.anchor = GridBagConstraints.LINE_END;
                layout.gridx = 2;
                layout.gridy = 3;
                layout.gridwidth = 2;
                add(psswConfTF, layout);

		layout = new GridBagConstraints();
		layout.insets = new Insets(5, 20, 5, 10);
		layout.anchor = GridBagConstraints.LINE_START;
		layout.gridx = 0;
		layout.gridy = 4;
		layout.gridwidth = 2;
		add(emailLB, layout);

		layout = new GridBagConstraints();
		layout.insets = new Insets(5, 10, 5, 20);
		layout.anchor = GridBagConstraints.LINE_END;
		layout.gridx = 2;
		layout.gridy = 4;
		layout.gridwidth = 2;
		add(emailTF, layout);

		layout = new GridBagConstraints();
                layout.insets = new Insets(5, 20, 5, 10);
                layout.anchor = GridBagConstraints.LINE_START;
                layout.gridx = 0;
                layout.gridy = 5;
                layout.gridwidth = 2;
                add(gemWalletLB, layout);

                layout = new GridBagConstraints();
                layout.insets = new Insets(5, 10, 5, 20);
                layout.anchor = GridBagConstraints.LINE_END;
                layout.gridx = 2;
                layout.gridy = 5;
                layout.gridwidth = 2;
                add(gemWalletTF, layout);

                layout = new GridBagConstraints();
                layout.insets = new Insets(5, 20, 10, 10);
                layout.anchor = GridBagConstraints.LINE_START;
                layout.gridx = 0;
                layout.gridy = 6;
                layout.gridwidth = 2;
                add(gemWalletConfLB, layout);

                layout = new GridBagConstraints();
                layout.insets = new Insets(5, 10, 10, 20);
                layout.anchor = GridBagConstraints.LINE_END;
                layout.gridx = 2;
                layout.gridy = 6;
                layout.gridwidth = 2;
                add(gemWalletConfTF, layout);

		layout = new GridBagConstraints();
		layout.insets = new Insets(10, 10, 10, 20);
		layout.anchor = GridBagConstraints.LINE_END;
		layout.gridx = 3;
		layout.gridy = 8;
		add(registerBtn, layout);
	}

	/**
	 * Runs after any button is pressed.
	 *	Hint Button - Launches Hint window
	 *	Register Button - disposes window; assignd all String variables
	 *	Sign-In Button - Launches sign-In;
	 *			disposes window
	 *
	 * @author: Kevin Gonzalez
	 * @version: 1.0
	 * @date: 06/29/2018
	 * @return: void
	 */
	@Override
	public void actionPerformed(ActionEvent click) {

		JButton sourceEvent = (JButton) click.getSource();

		if(sourceEvent == signInBtn) {
			dispose();
			GuiAux.launchSignIn = true;
		}

		else if (sourceEvent == hintBtn) {
			//launchHint();
		}

		else if (sourceEvent == registerBtn) {

			setVisible(false);
			registerBtnToggled = true;

			if(!attempted) {

	      	          	GridBagConstraints layout =
					new GridBagConstraints();
        		        layout.insets = new Insets(10, 10, 10, 20);
	        	        layout.anchor = GridBagConstraints.LINE_START;
                		layout.gridx = 0;
	        	        layout.gridy = 7;
		                add(errLB, layout);

				attempted = true;
			}

			usrname = usrnameTF.getText();
			pssw = psswTF.getText();
			psswConf = psswConfTF.getText();
			email = emailTF.getText();
			gemWallet = gemWalletTF.getText();
			gemWalletConf = gemWalletConfTF.getText();
			dispose();

		} // end of else if

	} // end of actionPerformed(ActionEvent)

        /**
         * Returns whether registration has been attempted
         *
         * @author: Kevin Gonzalez
         * @vesion: 1.0
         * @date: 06/24/2018
         * @return: boolean attempted
         *      True if registration has been attempted
         */
        protected boolean attempted() {
                return attempted;
        }

        /**
         * Returns whether registration is complete
         *
         * @author: Kevin Gonzalez
         * @vesion: 1.0
         * @date: 06/24/2018
         * @return: boolean done
         *      True if registration is complete
         */
        protected boolean done() {
                return done;
        }

	/**
         * Gets email
         *
         * @author: Kevin Gonzalez
         * @version: 1.0
         * @date: 06/24/2018
         * @return: String email
         *      Email inputted after user pressed register.
         */
        public String getEmail() {
                return email;
        }

	/**
         * Gets gemini wallet
         *
         * @author: Kevin Gonzalez
         * @version: 1.0
         * @date: 06/24/2018
         * @return: String gemWallet
         *      Gemini Wallet inputted after user pressed register.
         */
        public String getGemWallet() {
                return gemWallet;
        }

        /**
         * Gets gemini wallet confirmation
         *
         * @author: Kevin Gonzalez
         * @version: 1.0
         * @date: 06/24/2018
         * @return: String getWalletConf
         *      Gemini Wallet confirmation inputted after user pressed register.
         */
        public String getGemWalletConf() {
                return gemWalletConf;
        }

        /**
         * Gets password
         *
         * @author: Kevin Gonzalez
         * @version: 1.0
         * @date: 06/24/2018
         * @return: String pssw
         *      Password inputted after user pressed register.
         */
        public String getPssw() {
                return pssw;
        }

        /**
         * Gets password confirmation
         *
         * @author: Kevin Gonzalez
         * @version: 1.0
         * @date: 06/24/2018
         * @return: String psswConf
         *      Password confirmation inputted after user pressed register.
         */
        public String getPsswConf() {
                return psswConf;
        }

        /**
         * Gets username
         *
         * @author: Kevin Gonzalez
         * @version: 1.0
         * @date: 06/24/2018
         * @return: String usrname
         *      Username inputted after user pressed sign-in.
         */
        public String getUsrname() {
                return usrname;
        }

	/**
         * Returns whether Register button is toggled
         *
         * @author: Kevin Gonzalez
         * @version: 1.0
         * @date: 07/03/2018
         * @return: registerBtnToggled
         *      True if register was toggled
         */
        public boolean isRegisterToggled() {
                return registerBtnToggled;
        }

        /**
         * Launches registration window
         *
         * @author: Kevin Gonzalez
         * @version: 1.0
         * @date: 06/24/2018
         * @return: void
         */
        public void launch() {

		if(!usrnameValid) {
			usrnameLB.setForeground(Color.red);
		}

		if(!psswValid) {
			psswLB.setForeground(Color.red);
			psswConfLB.setForeground(Color.red);
		}

		if(!emailValid) {
			emailLB.setForeground(Color.red);
		}

		if(!gemWalletValid) {
			gemWalletLB.setForeground(Color.red);
			gemWalletConfLB.setForeground(Color.red);
		}

		GuiAux.launchRegistration = false;
                registerBtnToggled = false;
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setResizable(false);
                pack();
                setLocationRelativeTo(null);
                setVisible(true);

                return;
        }

        /**
         * Resets attempted and removes err label from registration
         *
         * @author: Kevin Gonzalez
         * @version: 1.0
         * @date: 07/03/2018
         * @return: void
         */
        public void reset() {

                if(attempted) {

                        attempted = false;

			usrnameLB.setForeground(Color.black);
                        psswLB.setForeground(Color.black);
                        psswConfLB.setForeground(Color.black);
                        emailLB.setForeground(Color.black);
                        gemWalletLB.setForeground(Color.black);
                        gemWalletConfLB.setForeground(Color.black);

			usrnameValid = true;
			psswValid = true;
			emailValid = true;
			gemWalletValid = true;

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
         *      Value stored in boolean attempted
         *      (attempted equals true if registration has been attempted)
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
         *      True if registration is complete
         * @return: void
         */
        public void setDone(boolean done) {
                this.done = done;
                return;
        }

	/**
         * Sets email validity
         *
         * @author: Kevin Gonzalez
         * @version: 1.0
         * @date: 06/24/2018
         * @param: boolean valid
         *      True if email is valid
         * @return: void
         */
        protected void setEmailValidity(boolean valid) {
                this.emailValid = valid;
                return;
        }

	/**
         * Sets gemini wallet validity
         *
         * @author: Kevin Gonzalez
         * @version: 1.0
         * @date: 06/24/2018
         * @param: boolean valid
         *      True if gemini wallet is valid
         * @return: void
         */
        protected void setGemWalletValidity(boolean valid) {
                this.gemWalletValid = valid;
                return;
        }

	/**
         * Sets password validity
         *
         * @author: Kevin Gonzalez
         * @version: 1.0
         * @date: 06/24/2018
         * @param: boolean valid
         *      True if password is valid
         * @return: void
         */
        protected void setPsswValidity(boolean valid) {
                this.psswValid = valid;
                return;
        }

        /**
         * Sets username validity
         *
         * @author: Kevin Gonzalez
         * @version: 1.0
         * @date: 06/24/2018
         * @param: boolean valid
         *      True if username is valid
         * @return: void
         */
        protected void setUsrnameValidity(boolean valid) {
                this.usrnameValid = valid;
                return;
        }

}

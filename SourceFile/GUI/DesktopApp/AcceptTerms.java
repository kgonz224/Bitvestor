/*
 *      File: AcceptTerms.java
 *      Project: Bitvestor
 *      Author(s): Eddie Noguera, Kevin Gonzalez
 *      Creation Date: 06/23/2018
 *      Language: Java
 *
 *      ***********************************************************
 *
 *      Description:
 *              Takes care of terms displayed at the begining of the program
 *              using Java Swing and awt.
 *
 * 	Methods:
 *		void actionPerformed(ActionEvent)
 *		void itemStateChanged(ItemEvent)
 *		void launch()
 *		void waitForTerms();
 */

package DesktopApp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AcceptTerms extends JFrame implements ActionListener,
       							ItemListener {

	private JButton continueBtn = null;
	private JCheckBox acceptCB = null;

	private boolean accepted = false;
	private boolean done = false;

	/**
	 * Constructor. Creates terms window.
	 *
	 * @author: Kevin Gonzalez
	 * @version: 1.0
	 * @date: 06/23/2018
	 */
	public AcceptTerms() {

		int termsWidth = 40;
		int termsHeight = 20;

		GridBagConstraints layout = null;
		JScrollPane scrollPane = null;
		JTextArea termsTA = null;

		setTitle(GuiAux.TITLE);

		// Create Buttons
		continueBtn = new JButton("Continue");
		continueBtn.addActionListener(this);

		// Create Check Box
		acceptCB = new JCheckBox("I accept and understand the risks");
		acceptCB.setSelected(accepted);
		acceptCB.addItemListener(this);

		// Create termsTA
		termsTA = new JTextArea(termsHeight, termsWidth);
		scrollPane = new JScrollPane(termsTA);
		termsTA.setEditable(false);
		termsTA.setOpaque(false);
		termsTA.setText(GuiAux.TERMS);
		
		// Grid Layout
		setLayout(new GridBagLayout());

		layout = new GridBagConstraints();
		layout.insets = new Insets(20, 20, 20, 20);
		layout.gridx = 0;
		layout.gridy = 0;
		add(termsTA, layout);

		layout = new GridBagConstraints();
		layout.insets = new Insets(20, 20, 20, 20);
		layout.gridx = 0;
		layout.gridy = 1;
		add(acceptCB, layout);

		layout = new GridBagConstraints();
		layout.insets = new Insets(10, 20, 20, 20);
		layout.gridx = 0;
		layout.gridy = 2;
		add(continueBtn, layout);
	}
		
	/**
	 * Disposes window and changes bool done to true.
	 *
	 * @author: Kevin Gonzalez
	 * @version: 1.0
	 * @date: 06/23/2018
	 * @return: void
	 */
	@Override
	public void actionPerformed(ActionEvent click) {
		if(accepted == true) {
			done = true;
			dispose();
		}

		return;
	}

	
	/**
	 * Changes value of bool accepted everytime check box is toggled
	 *
	 * @author: Kevin Gonzalez
	 * @version: 1.0
	 * @date: 06/23/2018
	 * @return: void
	 */
	@Override
	public void itemStateChanged(ItemEvent toggle) {
		Object item = toggle.getItemSelectable();
		if (item == acceptCB) {
			accepted = !accepted;
		}
		return;
	}

	/**
	 * Displays window
	 *
	 * @author: Kevin Gonzalez
	 * @version: 1.0
	 * @date: 06/23/2018
	 * @retun: void
	 */
	public void launch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		return;
	}

	/**
	 * Waits for Terms to be accepted
	 *
	 * @author: Kevin Gonzalez
	 * @version: 1.0
	 * @date: 06/25/2018
	 * @return: void
	 */
	public void waitForTerms() {
//FIXME: add GuiAux.sleep()
	       	while(!done) {

                        try {
                                Thread.sleep(GuiAux.POLLING_TIME);
                        }
                        catch(InterruptedException e) {
                                System.out.println("Failed to wait");
                        }

                } // End of while

		return;
	}
}

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
*******************************************************************************/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GUI {

	private boolean logout = false;

	private final int FRAME_WIDTH = 700;
	private final int FRAME_HEIGHT = 600;
	private final String HEADER = "BITVESTOR: Making money cents at a time.";
	private final String REMINDER_TXT = "<html><center>Please do NOT force close " +
						"program. Investments may <br>" +
						"stay as crypto in unstable " +
						"markets. Please click <br>" +
						"'Logout' when finished and " +
						"wait for completion message.<br><br></center></html>";

	protected boolean getLogoutStatus() {
		return logout;
	}

	protected void introMessage() {
		return;	
	}

	protected void createLogout() {
		//JFrame
		JFrame frame = new JFrame(HEADER);
		frame.setResizable(false);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		//JPanal
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

	}
}

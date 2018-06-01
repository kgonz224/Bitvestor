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
import java.awt.event.*;

class GUI {

	private boolean logout = false;

	private final int FRAME_WIDTH = 400;
	private final int FRAME_HEIGHT = 500;

	protected boolean getLogoutStatus() {
		return logout;
	}

	protected void createFrame() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		JPanel panel = new JPanel();
		JButton logoutBtn = new JButton("Logout");

		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				logout = true;
				frame.dispose();
			}
		});

		panel.add(logoutBtn);
		frame.add(panel);
	}
}

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

	protected boolean getLogoutStatus() {
		return logout;
	}

	protected void createFrame() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(400,800);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		JButton logoutBtn = new JButton("Logout");

		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				logout = true;
				System.exit(0);
			}
		});

		panel.add(logoutBtn);
		frame.add(panel);
	}
}

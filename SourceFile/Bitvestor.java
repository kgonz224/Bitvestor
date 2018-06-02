/*******************************************************************************
|	File: Bitvestor.java
|	Project: Bitvestor
|	Author(s): Eddie Noguera, Kevin Gonzalez
|	Creation Date: 05/21/2018
|	Language: Java
|
|	Compilation: javac Bitvestor.java
|	Execution: java Bitvestor
|
|	**********************************************************
|
|	Description:
|		A program that constantly checks for indicators in
|		cryptocurrency markets to put in and take out money throughout
|		until interupted by the user. A portion of the user's investments
|		is put into a market that appears to rise. That market is then
|		tracked until the market shows a falling indicator where the
|		investment money will be taken out plus the profit. Once
|		interupted by the user all investments will be removed from all
|		markets except usdt (which is a stable coin).
|
*******************************************************************************/
import java.util.Scanner; //Subject to change (GUI, web, other)

class Bitvestor {
	
	private static final long INVEST_GAP = 5000; // In milliseconds

	public static void main(String[] args) {
		System.out.println("Bitvestor is a go!\n");

		String usrName = "";
		String pssw = "";

		// Bitvestor user database connection
		// Market database connection
		Scanner scan = new Scanner(System.in);

		System.out.print("User Name: ");
		usrName = scan.nextLine();
		System.out.print("Password: ");
		pssw = scan.nextLine();
		System.out.println(usrName + " " + pssw);

		// Database: Find user info

		// Button
		GUI gui = new GUI();
		gui.createLogout();

		System.out.println("I have begun.");	
		while(gui.getLogoutStatus() == false){
			System.out.println("Hi I'm still here!");
			try {
				Thread.sleep(INVEST_GAP);
			}
			catch(InterruptedException e) {
				System.out.println("I guess I'm not tired.");
			}
		}

		// Check user markets for cryptocurrency pull indicators
		// Seperate profit and investment
		// Update user info
		// If investment then
		// 	Check for desired coin
		// 	Invest
		// Loop until log out.

		System.out.println("You logged out!\nWohoo");
		return;
	}
}



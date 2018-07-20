/*******************************************************************************
 * Tester for Desktop GUI
 ******************************************************************************/
package DesktopApp;

class Tester {

	public static void main(String[] args) {
		AcceptTerms terms = new AcceptTerms();
		GuiAux aux = new GuiAux();
		SignIn signIn = new SignIn();
		Register register = new Register();
		// Forgot forgot = new Forgot();

		// TEMP
			int i = 0;
			int r = 0;
		// END TEMP

		terms.launch();
		terms.waitForTerms();

		while(!signIn.done()) {
			if(aux.launchSignIn){
				signIn.reset();
				signIn.launch();
			}
			else if (aux.launchRegistration) {
				register.reset();
				register.launch();
			}
			// else if (aux.launchForgot) {
			// 	forgot.launch();
			// }
			else if (signIn.isSignInToggled()) {
				if ( i < 2) {
					signIn.launch(); i++;}
				else
					signIn.setDone(true);
				
				// validate(signIn.getusrname());
				// validate(signIn.getpssw());
				// if (valid) {
				// 	signIn.setDone(true);
				// }
				// else {
				// 	signIn.launch();
				// }
			}
			else if (register.isRegisterToggled()) {
				if (r > 2) {
					aux.launchSignIn = true;
				}
				else
					{register.launch(); r++;}
				// validate registrationelements
				// if (valid) {
				// 	update database;
				// 	aux.launchSignIn = true;
				// }
				// else {
				// 	register.launch()
				// }
			}
			aux.sleep();
		}


		System.out.println("I\'M DONE");
		return;
	}
}

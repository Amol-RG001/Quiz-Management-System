package quizsystem;

import loginsystem.IDandPasswords;
import loginsystem.LoginPage;

public class AdminLogin{
	
	IDandPasswords idandPasswords = new IDandPasswords();
	LoginPage loginPage = new LoginPage(idandPasswords.getlogininfo());
	
	
}




package loginsystem;

public class LoginMain {

	public static void main(String[] args) {
		
		IDandPasswords idandPasswords = new IDandPasswords();
		LoginPage loginPage = new LoginPage(idandPasswords.getlogininfo());
	}

}

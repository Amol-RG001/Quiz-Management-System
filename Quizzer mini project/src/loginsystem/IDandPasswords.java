package loginsystem;

import java.util.HashMap;

public class IDandPasswords {

	HashMap<String, String> logininfo = new HashMap<String, String>();
	
	public IDandPasswords() {
		
		logininfo.put("","");
		logininfo.put("sujit","sujit@123");
		logininfo.put("nischay","nischay@123");
		logininfo.put("kajal","kajal@123");
		logininfo.put("amol","amol@123");
		logininfo.put("username","password");
	}
	
	public HashMap getlogininfo(){
		return logininfo;
	}
}

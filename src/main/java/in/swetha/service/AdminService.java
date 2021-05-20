package in.swetha.service;

public class AdminService {
	
	public static boolean adminInfo(String adminName,String passWord)
	{ boolean checkValid=false;
		  if(adminName.equalsIgnoreCase("admin")&&passWord.equalsIgnoreCase("admin@123"
		  )) { checkValid=true; }
		  
		  
		  return checkValid;
		  
		  }
		 
		  }
		
	
	
	
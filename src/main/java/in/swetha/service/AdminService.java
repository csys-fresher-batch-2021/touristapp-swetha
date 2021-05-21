package in.swetha.service;

public class AdminService {
	private AdminService() {
		
	}
	
	/** 
	 * 
	 * @param adminName
	 * @param passWord
	 * @return
	 */
	public static boolean adminInfo(String adminName,String passWord)
	{ boolean checkValid=false;
		  if(adminName.equalsIgnoreCase("admin")&&passWord.equalsIgnoreCase("admin@123"
		  )) { checkValid=true; }//same password name means return true
		  
		  
		  return checkValid;
		  
		  }
		 
		  }
		
	
	
	
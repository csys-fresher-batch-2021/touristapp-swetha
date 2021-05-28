package in.swetha.model;

public class User {
	private String userName;
	private String UserPassWord;
	private long userMobileNumber;
	public User(String userName, String userPassWord, long userMobileNumber) {
		super();
		this.userName = userName;
		this.UserPassWord = userPassWord;
		this.userMobileNumber = userMobileNumber;
	}
	public User(String userName, String userPassWord) {
		this.userName = userName;
		this.UserPassWord = userPassWord;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassWord() {
		return UserPassWord;
	}
	public void setUserPassWord(String userPassWord) {
		this.UserPassWord = userPassWord;
	}
	public long getUserMobileNumber() {
		return userMobileNumber;
	}
	public void setUserMobileNumber(long userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", UserPassWord=" + UserPassWord + ", userMobileNumber="
				+ userMobileNumber + "]";
	}
}
	
	
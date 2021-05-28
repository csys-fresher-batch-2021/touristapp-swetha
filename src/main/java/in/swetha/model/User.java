package in.swetha.model;

public class User {
	private String userName;
	private String userPassWord;
	private long userMobileNumber;
	public User(String userName, String userPassWord, long userMobileNumber) {
		super();
		this.userName = userName;
		this.userPassWord = userPassWord;
		this.userMobileNumber = userMobileNumber;
	}
	public User(String userName, String userPassWord) {
		this.userName = userName;
		this.userPassWord = userPassWord;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassWord() {
		return userPassWord;
	}
	public void setUserPassWord(String userPassWord) {
		this.userPassWord = userPassWord;
	}
	public long getUserMobileNumber() {
		return userMobileNumber;
	}
	public void setUserMobileNumber(long userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPassWord=" + userPassWord + ", userMobileNumber="
				+ userMobileNumber + "]";
	}
}
	
	
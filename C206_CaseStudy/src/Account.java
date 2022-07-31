
public class Account {
	private String userID; 
	private String password;
	private String username;
	private boolean isAvail;


	public Account(String userID, String password, String username) {
		this.userID = userID;
		this.password = password;
		this.username = username;
		this.isAvail = true;
}


	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	public boolean getIsAvail() {
		return isAvail;
	}

	public void setIsAvail(boolean isAvail) {
		this.isAvail = isAvail;
	}
}

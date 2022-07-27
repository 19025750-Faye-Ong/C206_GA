
public class Admin extends Account{
	private int loginAttempt;
	
	public Admin(String userId, String password, String username, int loginAttempt) {
		super(userId, password, username);
	}

	public int getLoginAttempt() {
		return loginAttempt;
	}

}

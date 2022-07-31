
public class User extends Account {
	
	
	private int contactNum ;
	private String email ;
	
	public User(String userId, String password, String username, int contactNum, String email) {
		super(userId, password, username);
		this.contactNum = contactNum;
		this.email = email;
	}

	public int getContactNum() {
		return contactNum;
	}

	public void setContactNum(int contactNum) {
		contactNum = contactNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

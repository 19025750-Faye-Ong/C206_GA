
public class Admin extends Account{
	private String department;
	
	public Admin(String userId, String password, String username, String department) {
		super(userId, password, username);
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

}

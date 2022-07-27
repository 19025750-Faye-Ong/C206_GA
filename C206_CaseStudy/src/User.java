
public class User extends Account {
	
	
	private int contactNum ;
	private String email ;
	private double rating ;
	
	public User(String userId, String password, String username, int contactNum, String email, double rating) {
		super(userId, password, username);
		this.contactNum = contactNum;
		this.email = email;
		this.rating = rating;
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

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

}

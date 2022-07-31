import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Item> itemList = new ArrayList<Item>();

		itemList.add(1, "Limited Edition RP Reusable Cup", "Condition: Brand New, Rose Gold Stainless Steel Cup with 500ml capacity.", 9.00, 2.00);
		itemList.add(2, "Limited Edition Stranger Things Tote Bag", "Condition: Like New, Bag is stranger than Stranger Things", 15.00, "01-02-2022", "11-02-2022", 5.00);
		itemList.add(3, "Rainbow Care Bear Hat", "Condition: Brand New, we care about your head:)", 30.00, "01-02-2022", "09-02-2022", 10.00);


	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	} 

	public static String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail; 
	}

	//================================= Option 1 View (CRUD - Read) =================================

	//Item List View
	public static String retrieveAllItem(ArrayList<Item>itemList ) {
		String output = "";

		for (int i = 0; i < itemList.size(); i++) {
			output += String.format("%-10s %-30s %-10s %-10d.2f %-10s %-10s %-20d.2f\n", itemList.get(i).getName()
					itemList.get(i).getDescription(), C206_CaseStudy.showAvailability(itemList.get(i).getIsAvailable()), itemList.get(i).getMinBid(), 
					itemList.get(i).getAuctionStart(),itemList.get(i).getAuctionEnd(), itemList.get(i).getBidIncrement());


		}
		return output; 	
	}

	public static void viewAllItem(ArrayList<Item> itemList) {
		C206_CaseStudy.setHeader("ITEM LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ASSET TAG", "DESCRIPTION",
				"AVAILABLE", "DUE DATE","OPTICAL ZOOM");
		output += retrieveAllItem(itemList);	
		System.out.println(output);
	}

	//User List View (FOR ADMIN ONLY)
	public static String retrieveAllUser(ArrayList<User> userList) {
		String output = "";
		// write your code here
		for (int i = 0; i < userList.size(); i++) {

			output += String.format("%-10s %-30s %-10s %-20s\n", userList.get(i).getUserID(),
					userList.get(i).getUsername(), 
					userList.get(i).getContactNum(),userList.get(i).getRating());
		}
		return output;
	}

	public static void viewAllUser(ArrayList<User> userList) {

		C206_CaseStudy.setHeader("USER LIST");
		String output = String.format("%-10s %-30s %-10s %-20s\n", "USER ID", "USERNAME",
				"CONTACT NUMBER", "RATING");
		output += retrieveAllUser(userList);
		System.out.println(output);
	}

	//================================= Option 2 Add (CRUD - Create)=================================

	//Add Item

	//Add User (Register User)
	public static User inputUser() {
		String usId = Helper.readString("Enter a unique User ID> ");
		String pass = Helper.readString("Enter Password > ");
		String usName = Helper.readString("Enter Name > ");
		int usCN = Helper.readInt("Enter Contact Number > ");
		String usEmail = Helper.readString("Enter Email > ");


		User us= new User(usId, pass, usName, usCN, usEmail);
		return us;

	}

	public static void addCamcorder(ArrayList<User> userList, User us) {

		userList.add(us);

	}

	//================================= Option 3 Edit (CURD- Update) =================================

	//Edit Item

	//Edit User Info
	public static boolean doUpdateUser(ArrayList<User> userList, String usId, String pass, int usCN, String usEmail) {

		boolean isUpdate = false;

		for (int i = 0; i < userList.size(); i++) {

			String userID = userList.get(i).getUserID();

			if (usId.equalsIgnoreCase(userID)				
					&& userList.get(i).getIsAvail() == true) {

				userList.get(i).setIsAvail(false);
				userList.get(i).setPassword(pass);
				userList.get(i).setContactNum(usCN);
				userList.get(i).setEmail(usEmail);

				isUpdate = true;

			}
		}
		return isUpdate;
	}

	public static void updateUser(ArrayList<User> userList) {
		C206_CaseStudy.viewAllUser(userList);
		String usId = Helper.readString("Enter your unique User ID> ");
		String pass = Helper.readString("Enter new Password > ");
		int usCN = Helper.readInt("Enter new Contact Number > ");
		String usEmail = Helper.readString("Enter new Email > ");
		Boolean isUpdate =doUpdateUser(userList, usId, pass, usCN, usEmail);
		if (isUpdate == false) {
			System.out.println("Invalid User ID!");
		} else {
			System.out.println("User " + usId + " is updated:)");
		}
	}

	//================================= Option 4 Remove (CURD- Delete)=================================

	//Remove Item

	//Remove User (FOR ADMIN ONLY)
	public static boolean doRemoveUser(ArrayList<User> userList, String usId, String validation) {

		boolean isRemove = false;

		for (int i = 0; i < userList.size(); i++) {

			String userID = userList.get(i).getUserID();

			if (usId.equalsIgnoreCase(userID)				
					&& userList.get(i).getIsAvail() == true) {

				userList.get(i).setIsAvail(false);
				if (validation == "Y" || validation == "y") {
					userList.removeAll(userList);
				} else {
					System.out.println("Error in remove");
				}
				
				
				isRemove = true;

			}
		}
		return isRemove;
	}

	public static void removeUser(ArrayList<User> userList) {
		C206_CaseStudy.viewAllUser(userList);
		String usId = Helper.readString("Enter User ID to be removed > ");
		String validation = Helper.readString(" Are you sure you want to remove? (Y/N) ");
		Boolean isRemove =doRemoveUser(userList, usId, validation);
		if (isRemove == false) {
			System.out.println("Invalid User ID!");
		} else {
			System.out.println("User " + usId + " is removed. ");
		}
	}
}


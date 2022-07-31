import java.time.LocalDate;
import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Item> itemList = new ArrayList<Item>();
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<Admin> adminList = new ArrayList<Admin>();

		//itemList.add(1, "Limited Edition RP Reusable Cup", "Condition: Brand New, Rose Gold Stainless Steel Cup with 500ml capacity.", 9.00, 2.00);
		//itemList.add(2, "Limited Edition Stranger Things Tote Bag", "Condition: Like New, Bag is stranger than Stranger Things", 15.00, "01-02-2022", "11-02-2022", 5.00);
		//itemList.add(3, "Rainbow Care Bear Hat", "Condition: Brand New, we care about your head:)", 30.00, "01-02-2022", "09-02-2022", 10.00);

		userList.add(new User("tester", "Password123", "Team One",88121234,"tester@gmail.com"));
		userList.add(new User("tester2","Password123", "Group One",88989876,"tester2@gmail.com"));
		
		int option = 0;
		C206_CaseStudy.menu();
		option = Helper.readInt("Enter an option > ");
		
		if (option == 1) {
			C206_CaseStudy.visitorMenu();
			int visOption = Helper.readInt("Enter an option > ");
			if (visOption == 1) {
				C206_CaseStudy.viewAllItem(itemList);
			} else if (visOption == 2) {
				User us = inputUser();
				C206_CaseStudy.addUser(userList, us);
				System.out.println("User added");
			} else {
				System.out.println("Thank you for visiting Campus Online Auction Shop (COAS)");
			}
		} else {
			C206_CaseStudy.loginMenu();
			int lgOption = Helper.readInt("Enter an option > ");
			if(lgOption == 1) {
				String loginId = Helper.readString("User ID: ");
				String loginPass = Helper.readString("Password: ");
				for (int i = 0; i < adminList.size(); i++) {
					String amID = adminList.get(i).getUserID();
					String pass = adminList.get(i).getPassword();
					
					if (loginId.equals(amID) && loginPass.equals(pass) && adminList.get(i).getIsAvail() == true) {
						C206_CaseStudy.adminMenu();
						int amOption = Helper.readInt("Enter a option > ");
						if (amOption == 1) {
							C206_CaseStudy.removeUser(userList);
						} else if (amOption == 2) {
							C206_CaseStudy.removeItem(itemList);
						} else  if (amOption == 3){
							
						} else {
							System.out.println("Thank you for visiting Campus Online Auction Shop (COAS)");
						}
					}
				} 
			} else {
				String loginId = Helper.readString("User ID: ");
				String loginPass = Helper.readString("Password: ");
				for (int i = 0; i < userList.size(); i++) {
					String userID = userList.get(i).getUserID();
					String pass = userList.get(i).getPassword();
					
					if (loginId.equals(userID) && loginPass.equals(pass) && userList.get(i).getIsAvail() == true) {
						C206_CaseStudy.userMenu();
						int usOption = Helper.readInt("Enter a option > ");
						if (usOption == 1) {
							C206_CaseStudy.viewAllItem(itemList);
							int itemId = Helper.readInt("Enter Item ID > ");
						} else if (option == 2) {
							Item it = inputItem();
							C206_CaseStudy.addItem(userList, it);
						} else {
							System.out.println("Thank you for visiting Campus Online Auction Shop (COAS)");
						}
					}
				}
			}	
		}
	}
	
	
	
	public static void menu() {
		C206_CaseStudy.setHeader("Campus Online Auction Shop (COAS)");
		System.out.println("1. As a Visitor ");
		System.out.println("2. Login ");
		Helper.line(80, "-");

	}
	
	public static void loginMenu() {
		C206_CaseStudy.setHeader("Login");
		System.out.println("1. Login as admin");
		System.out.println("2. Login as user");
		Helper.line(80, "-");
	}
	
	public static void userMenu() {
		C206_CaseStudy.setHeader("Campus Online Auction Shop (COAS)");
		System.out.println("1. View all items ");
		System.out.println("2. Sell items ");
		System.out.println("3. Log out ");
		Helper.line(80, "-");
	}

	public static void visitorMenu() {
		C206_CaseStudy.setHeader("Campus Online Auction Shop (COAS)");
		System.out.println("1. View all items ");
		System.out.println("2. Register account  ");
		System.out.println("3. Quit ");
		Helper.line(80, "-");
	}
	
	public static void adminMenu() {
		C206_CaseStudy.setHeader("Campus Online Auction Shop (COAS)");
		System.out.println("1. Block users ");
		System.out.println("2. Remove items ");
		System.out.println("3. Categorise items");
		System.out.println("4. Log out ");
		Helper.line(80, "-");
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
	/*public static String retrieveAllItem(ArrayList<Item>itemList ) {
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
	}*/

	//User List View (FOR ADMIN ONLY)
	public static String retrieveAllUser(ArrayList<User> userList) {
		String output = "";
		// write your code here
		for (int i = 0; i < userList.size(); i++) {

			output += String.format("%-10s %-30s %-10s %-20s\n", userList.get(i).getUserID(),
					userList.get(i).getUsername(), 
					userList.get(i).getContactNum(),userList.get(i).getEmail());
		}
		return output;
	}

	public static void viewAllUser(ArrayList<User> userList) {

		C206_CaseStudy.setHeader("USER LIST");
		String output = String.format("%-10s %-30s %-10s %-20s\n", "USER ID", "USERNAME",
				"CONTACT NUMBER", "EMAIL");
		output += retrieveAllUser(userList);
		System.out.println(output);
	} 

	//================================= Option 2 Add (CRUD - Create)=================================

	//Add Item
	public static Item inputItem() {
		int tag = Helper.readInt("Enter item id > ");
		String name = Helper.readString("Enter item name> ");
		String description = Helper.readString("Enter item description > ");
		double minBid = Helper.readDouble("Enter minimum bid > ");
		LocalDate auctionStart = Helper.readDate("Enter auction start date > ");
		LocalDate auctionEnd = Helper.readDate("Enter auction end date > ");
		double bidIncrement = Helper.readDouble("Enter bid increment > ");

		Item it = new Item(tag, name, description, minBid, auctionStart, auctionEnd, bidIncrement);
		return it;
		
	}
	public static void addItem(ArrayList<Item> itemList, Item it) {
		
		itemList.add(it);
		
	}

	

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

	public static void addUser(ArrayList<User> userList, User us) {

		userList.add(us);

	}

	//================================= Option 3 Edit (CURD- Update) =================================

	//Edit Item
	public static boolean doUpdateItem(ArrayList<Item>itemList, int itId, String name, String description, double minBid, LocalDate auctionStart, LocalDate auctionEnd, double bidIncrement) {

		boolean isUpdate = false;

		for (int i = 0; i < itemList.size(); i++) {

			 int id = itemList.get(i).getId();

			if (itId == id && itemList.get(i).getIsAvailable() == true) {

				itemList.get(i).setIsAvailable(false);
				itemList.get(i).setName(name);
				itemList.get(i).setDescription(description);
				itemList.get(i).setMinBid(minBid);
				itemList.get(i).setBidIncrement( bidIncrement);
				itemList.get(i).setAuctionStart(auctionStart);
                                itemList.get(i).setAuctionEnd(auctionEnd);


				isUpdate = true;

			}
		}
		return isUpdate;
	}

	public static void updateItem(ArrayList<Item> itemList) {
		C206_CaseStudy.viewAllItem(itemList);
		int itId = Helper.readInt("Enter Item ID > ");
		String name  = Helper.readString("Enter your new  name > ");
		String description = Helper.readString("Enter new description > ");
		double minBid = Helper.readDouble("Enter new minimum bid > ");
		LocalDate auctionStart = Helper.readDate("Enter new aution start date > ");
		LocalDate auctionEnd = Helper.readDate("Enter new aution end date > ");
        double bidIncrement= Helper.readDouble("Enter new bid increment > ");      
        
		Boolean isUpdate = doUpdateItem(itemList, itId, name, description,minBid, auctionStart, auctionEnd, bidIncrement);
		if (isUpdate == false) {
			System.out.println("Invalid Item ID!");
		} else {
			System.out.println("Item " + itId + " is updated");
		}
	}

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


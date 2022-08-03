import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class C206_CaseStudy {
	
	static DateTimeFormatter form1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Category> itemList = new ArrayList<Category>();
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<Admin> adminList = new ArrayList<Admin>();
		
		

		itemList.add(new Category(1, "Limited Edition RP Reusable Cup", "Condition: Brand New, Rose Gold Stainless Steel Cup with 500ml capacity.", 9.00, LocalDate.parse("01/02/2022", form1), LocalDate.parse("10/02/2022", form1), 2.00, "Drinkware"));
		itemList.add(new Category(2, "Limited Edition Stranger Things Tote Bag", "Condition: Like New, Bag is stranger than Stranger Things", 15.00, LocalDate.parse("01/02/2022", form1), LocalDate.parse("11/02/2022", form1), 5.00, "Bags"));
		itemList.add(new Category(3, "Rainbow Care Bear Hat", "Condition: Brand New, we care about your head:)", 30.00, LocalDate.parse("01/02/2022", form1), LocalDate.parse("09/02/2022", form1), 10.00, "Fashion"));

		userList.add(new User("tester", "Password123", "Team One",88121234,"tester@gmail.com"));
		userList.add(new User("tester2","Password123", "Group One",88989876,"tester2@gmail.com"));
		adminList.add(new Admin("Admin1", "password456", "CoolWell","Front-desk")); 
		adminList.add(new Admin("Admin2","password789", "AdminRP","Engineering"));
		
		int option = 0;
		while(option != 3) {
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
					
					} else if (visOption == 3){
						
						System.out.println("Thank you for visiting Campus Online Auction Shop (COAS)");
						
					} else {
						System.out.println("Invalid input");
					}
				
			} else if (option == 2) {
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
									C206_CaseStudy.categorise(itemList);
								} else if (amOption == 4) {
									System.out.println("Thank you for visiting Campus Online Auction Shop (COAS)");
								}
	
						} else {
							System.out.println("This admin does not exist!");
						}
					} 
					
				} else if (lgOption == 2) {
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
										
									} else if (usOption == 2) {
										Category it = inputItem();
										C206_CaseStudy.addItem(itemList, it);
										System.out.println("Item Added!");
										
									} else if (usOption == 3) {
										System.out.println("Thank you for visiting Campus Online Auction Shop (COAS)");
										
									} else {
										System.out.println("Invalid Option!");
									}
							}	
						}
				} else if (lgOption == 3) {
					System.out.println("Thank you for visiting Campus Online Auction Shop (COAS)");
				} else {
						System.out.println("Invalid Input");
				}
			} else {
				System.out.println("Thank you for visiting Campus Online Auction Shop (COAS)");
			}
		}
	}
	
	
	
	public static void menu() {
		C206_CaseStudy.setHeader("Campus Online Auction Shop (COAS)");
		System.out.println("1. As a Visitor ");
		System.out.println("2. Login ");
		System.out.println("3. Quit");
		Helper.line(80, "-");

	}
	
	public static void loginMenu() {
		C206_CaseStudy.setHeader("Login");
		System.out.println("1. Login as admin");
		System.out.println("2. Login as user");
		System.out.println("3. Quit");
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

	//================================= View (CRUD - Read) =================================

	//Item List View
	public static String retrieveAllItem(ArrayList<Category>itemList ) {
		String output = "";

		for (int i = 0; i < itemList.size(); i++) {
			
			output += String.format("%-45s %-80s %-10.2f %-20s %-20s %-20.2f\n", itemList.get(i).getName(),
					itemList.get(i).getDescription(), itemList.get(i).getMinBid(), 
					itemList.get(i).getAuctionStart().format(form1),itemList.get(i).getAuctionEnd().format(form1), itemList.get(i).getBidIncrement(), itemList.get(i).getCategory());


		}
		return output; 	
	}

	public static void viewAllItem(ArrayList<Category> itemList) {
		C206_CaseStudy.setHeader("ITEM LIST");
		String output = String.format("%-45s %-80s %-10s %-20s %-20s %-20s\n", "NAME", "DESCRIPTION", "Min Bid", "Auction Start", "Auction End", "Bid Increment", "Category");
		output += retrieveAllItem(itemList);	
		System.out.println(output);
	}
	
	//View specific Item
	/*public static void searchByCategory (ArrayList<Category> itemList) {
		Helper.line(40,"-");
		System.out.println("SEARCH FOR GAMERS BY NAME");
		Helper.line(40,"=");
		String searchName = Helper.readString("Enter name to search >");
		String output = String.format("%-10s 8-5s 8-15s 8-5s \n",
				for(int 1 = 0: 1 <gamers.size(); i+*) {
					
				}
	"NAME", "AGE", "USERNAME", "POINTS");
	if (gamers.get (i) .getName (). equalsIgnoreCase (searchName)) f
	Gamer g - gamers.get (i);
	output += String.format ("%-10s %-5d %-15s %-5d\n", 8-getName(), g.getAge(), g.getUsername(),
	¿.getPoints());
	break;
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

	//================================= Add (CRUD - Create)=================================

	//Add Item
	public static Category inputItem() {
		int tag = Helper.readInt("Enter item id > ");
		String name = Helper.readString("Enter item name> ");
		String description = Helper.readString("Enter item description > ");
		double minBid = Helper.readDouble("Enter minimum bid > ");
		String auctionStart = Helper.readString("Enter auction start date > ");
		LocalDate aucStart = LocalDate.parse(auctionStart, form1);
		String auctionEnd = Helper.readString("Enter auction end date > ");
		LocalDate aucEnd = LocalDate.parse(auctionEnd, form1);
		double bidIncrement = Helper.readDouble("Enter bid increment > ");
		String cat = Helper.readString("Enter category > ");

		Category it = new Category(tag, name, description, minBid, aucStart, aucEnd, bidIncrement, cat);
		return it;
		
	}
	public static void addItem(ArrayList<Category> itemList, Category it) {
		
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

	//================================= Edit (CURD- Update) =================================

	//Categorise
		public static boolean doCategorise(ArrayList<Category> itemList, int itID, String cat) {

			boolean isUpdate = false;

			for (int i = 0; i < itemList.size(); i++) {

				int id = itemList.get(i).getId();

				if (itID == id && itemList.get(i).getIsAvailable() == true) {

					itemList.get(i).setIsAvailable(false);
					
					
					isUpdate = true;

				}
			}
			return isUpdate;
		}

		public static void categorise(ArrayList<Category> itemList) {
			C206_CaseStudy.viewAllItem(itemList);
			int itID = Helper.readInt("Enter Item ID > ");
			String cat = Helper.readString("Enter Category > ");
	        
			Boolean isCategory = doCategorise(itemList, itID, cat);
			if (isCategory == false) {
				System.out.println("Invalid Item ID!");
			} else {
				System.out.println("Item " + itID + " is updated");
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
	
	
	//================================= Remove (CURD- Delete)=================================

	//Remove Item
	public static boolean doRemoveItem(ArrayList<Category> itemList, int itId, String validation) {

		boolean isRemove = false;

		for (int i = 0; i < itemList.size(); i++) {

			int id = itemList.get(i).getId();

			if (itId == id				
					&& itemList.get(i).getIsAvailable() == true) {

				itemList.get(i).setIsAvailable(false);
				if (validation == "Y" || validation == "y") {
					itemList.removeAll(itemList);
				} else {
					System.out.println("Error in remove");
				}
				
				
				isRemove = true;

			}
		}
		return isRemove;
	}

	public static void removeItem(ArrayList<Category> itemList) {
		C206_CaseStudy.viewAllItem(itemList);
		int itId = Helper.readInt("Enter Item ID to be removed > ");
		String validation = Helper.readString(" Are you sure you want to remove? (Y/N) ");
		Boolean isRemove = doRemoveItem(itemList, itId, validation);
		if (isRemove == false) {
			System.out.println("Invalid User ID!");
		} else {
			System.out.println("Item " + itId + " is removed. ");
		}
	}


	//Remove User (FOR ADMIN ONLY)
	public static boolean doRemoveUser(ArrayList<User> userList, String usId, String validation) {

		boolean isRemove = false;

		for (int i = 0; i < userList.size(); i++) {

			String userID = userList.get(i).getUserID();

			if (usId.equalsIgnoreCase(userID)				
					&& userList.get(i).getIsAvail() == true) {

				userList.get(i).setIsAvail(false);
				if (validation == "Y" || validation == "y") {
					userList.remove(userList);
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


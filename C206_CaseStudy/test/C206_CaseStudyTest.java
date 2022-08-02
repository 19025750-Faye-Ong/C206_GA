import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private User us1;
	private User us2;
	private Category it1;
	private Category it2;
	
	ArrayList<User> userList = new ArrayList<User>();
	ArrayList<Category> itemList = new ArrayList<Category>();
	
	public C206_CaseStudyTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data 
		us1 = new User("tester", "Password123", "Team One",88121234,"tester@gmail.com");
		us2 = new User("tester2","Password123", "Group One",88989876,"tester2@gmail.com");
		
		DateTimeFormatter form1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		it1 = new Category(1, "Limited Edition RP Reusable Cup", "Condition: Brand New, Rose Gold Stainless Steel Cup with 500ml capacity.", 9.00, LocalDate.parse("01/02/2022", form1), LocalDate.parse("10/02/2022", form1), 2.00, "Drinkware");
		it2 = new Category(2, "Limited Edition Stranger Things Tote Bag", "Condition: Like New, Bag is stranger than Stranger Things", 15.00, LocalDate.parse("01/02/2022", form1), LocalDate.parse("11/02/2022", form1), 5.00, "Bags");

		userList = new ArrayList<User>();
		itemList = new ArrayList<Category>();
	}
	
	@Test
	public void testAddUser() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid User arraylist to add to", userList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addUser(userList, us1);
		assertEquals("Check that User arraylist size is 1", 1, userList.size());
		assertSame("Check that User is added", us1, userList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addUser(userList, us2);
		assertEquals("Check that User arraylist size is 2", 2, userList.size());
		assertSame("Check that User is added", us2, userList.get(1));
	}
	
	@Test
	public void testRetrieveAllUser() {
		//fail("Not yet implemented");
		// Test if Item list is not null but empty - boundary
		assertNotNull("Test if there is valid User arraylist to retrieve item from", userList);
		
		//test if the list of User retrieved from the SourceCentre is empty - boundary
		String allUser= C206_CaseStudy.retrieveAllUser(userList);
		String testOutput = "";
		assertEquals("Test that the retrieved userlist is empty?", testOutput, allUser);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		 C206_CaseStudy.addUser(userList, us1);
		 C206_CaseStudy.addUser(userList, us2);
		assertEquals("Test that User arraylist size is 2", 2, userList.size());
		
		//test if the expected output string same as the list of users retrieved from the SourceCentre	
		allUser= C206_CaseStudy.retrieveAllUser(userList);
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","tester", "Password123", "Team One",88121234,"tester@gmail.com");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","tester2","Password123","Group One ",88989876,"tester2@gmail.com");
		assertEquals("Test that ViewAllUserlist", testOutput, allUser);
	}
	
	@Test
	public void testDoUpdateUser() {

		//boundary
		assertNotNull("test if there is valid User arraylist to update from", userList);
		
		C206_CaseStudy.addUser(userList, us1);
		
		// normal
		Boolean ok = C206_CaseStudy.doUpdateUser(userList, "tester", "Password123", 88121234 , "tester@gmail.com" );
		assertTrue("Test if an available item is ok to update?", ok);
		
		//error condition
		ok = C206_CaseStudy.doUpdateUser(userList, "tester", "Password123",88121234 , "tester@gmail.com"  );
		assertFalse("Test if an same item is NOT ok to update again?", ok);	
		
		//error condition
		C206_CaseStudy.addUser(userList, us2);	
		us2.setIsAvail(false);
		ok = C206_CaseStudy.doUpdateUser(userList, "tester2", "Password123" ,88989876 ," tester2@gmail.com");
		assertFalse("Test that un-available item is NOT ok to update?", ok);
		
		//error condition
		ok = C206_CaseStudy.doUpdateUser(userList, "tester3", "Password123" , 87971256 , "tester3@gmail.com");
		assertFalse("Test that non-exiting item is NOT ok to update?", ok);


	}
	
	@Test
	public void testDoRemoveUser() {
		//boundary
		assertNotNull("test if there is a removal of user", userList);
				
		C206_CaseStudy.addUser(userList, us1);
				
		// normal
		Boolean ok = C206_CaseStudy.doRemoveUser(userList, "tester", "y");
		assertTrue("Test if user is ok to remove?", ok);
		assertFalse(userList.get(0).getIsAvail());
		assertEquals(userList.get(0).getUserID(),"tester");
				
						
		//error condition
		ok = C206_CaseStudy.doRemoveUser(userList, "tester", "y");
		assertFalse("Test if the same user is NOT ok to remove again?", ok);	
	
				
		//error condition
		ok = C206_CaseStudy.doRemoveUser(userList, "tester2", "y");
		assertFalse("Test that non-existing user is NOT ok to remove?", ok);


	}
	@Test
	public void testAddItem() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Item arraylist to add to", itemList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addItem(itemList, it1);
		assertEquals("Check that Item arraylist size is 1", 1, itemList.size());
		assertSame("Check that Item is added", it1, itemList.get(0));

		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addItem(itemList, it2);
		assertEquals("Check that Item arraylist size is 2", 2, userList.size());
		assertSame("Check that Item is added", it2, itemList.get(1));
	}

	@After
	public void tearDown() throws Exception {
		us1 = null;
		us2 = null;
		it1 = null;
		it2 = null;
		userList = null;
		itemList = null;
	}
	
}

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
	
	private Bid Bd1;
	private Bid Bd2;
	
	private Deal de1;
	private Deal de2;
	
	DateTimeFormatter form1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	ArrayList<User> userList = new ArrayList<User>();
	ArrayList<Category> itemList = new ArrayList<Category>();
	ArrayList<Bid> bidList = new ArrayList<Bid>();
	ArrayList<Deal> DealList = new ArrayList<Deal>();

	public C206_CaseStudyTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data 
		us1 = new User("tester", "Password123", "Team One",88121234,"tester@gmail.com");
		us2 = new User("tester2","Password123", "Group One",88989876,"tester2@gmail.com");
		
		it1 = new Category(2, "Limited Edition Stranger Things Tote Bag", "Condition: Like New, Bag is stranger than Stranger Things", 15.00, LocalDate.parse("01/02/2022", form1), LocalDate.parse("11/02/2022", form1), 5.00, "Bags");
		it2 = new Category(3, "Rainbow Care Bear Hat", "Condition: Brand New, we care about your head:)", 30.00, LocalDate.parse("01/02/2022", form1), LocalDate.parse("09/02/2022", form1), 10.00, "Fashion");

		de1 = new Deal(1, "Transaction Number One", "In this Transaction RP Reusable Cup was sold", 30.50, LocalDate.parse("01/02/2022", form1), LocalDate.parse("10/02/2022", form1),2.00, 11, 50.00, LocalDate.parse("11/02/2022", form1));
		de2 = new Deal(2, "Transaction Number Two", "In this Transaction SP Reusable Cup was sold", 40.50, LocalDate.parse("04/02/2022", form1), LocalDate.parse("14/02/2022", form1),3.00, 12, 50.50, LocalDate.parse("03/03/2022", form1));

		userList= new ArrayList<User>();
		itemList= new ArrayList<Category>();
		bidList = new ArrayList<Bid>();

	}
	
	@Test
	public void testRetrieveAllItem() {
		
		// Test if Item list is not null but empty, so that can add a new item
		//fail("Not yet implemented");
				// Test if Item list is not null but empty - boundary
				assertNotNull("Test if there is valid item arraylist to retrieve item from", itemList);
				
				//test if the list of User retrieved from the SourceCentre is empty - boundary
				String allItem= C206_CaseStudy.retrieveAllItem(itemList);
				String testOutput = "";
				assertEquals("Test that the retrieved itemList is empty?", testOutput, allItem);
				
				//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
				 C206_CaseStudy.addItem(itemList, it1);
				 C206_CaseStudy.addItem(itemList, it2);
				assertEquals("Test that User arraylist size is 2", 2, itemList.size());

				//test if the expected output string same as the list of users retrieved from the SourceCentre	
				allItem= C206_CaseStudy.retrieveAllItem(itemList);
				testOutput = String.format("%-45s %-80s %-10s %-20s %-20s %-20s\n",2, "Limited Edition Stranger Things Tote Bag", "Condition: Like New, Bag is stranger than Stranger Things", 15.00, LocalDate.parse("01/02/2022", form1), LocalDate.parse("11/02/2022", form1), 5.00, "Bags");
				testOutput += String.format("%-45s %-80s %-10s %-20s %-20s %-20s\n",3, "Rainbow Care Bear Hat", "Condition: Brand New, we care about your head:)", 30.00, LocalDate.parse("01/02/2022", form1), LocalDate.parse("09/02/2022", form1), 10.00, "Fashion");
				assertEquals("Test that ViewAllitemList", allItem, testOutput);
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
		 testOutput = String.format("%-10s %-10s  %-10d %-10s\n","tester", "Team One",88121234,"tester@gmail.com");
		 testOutput += String.format("%-10s %-10s %-10d %-10s\n","tester2","Group One ",88989876,"tester2@gmail.com");
		 assertEquals("Test that ViewAllUserlist", testOutput, allUser);
	}
	//===========================================================================================
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
		assertEquals("Check that Item arraylist size is 2", 2, itemList.size());
		assertSame("Check that Item is added", it2, itemList.get(1));
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
	public void testAddBid() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid User arraylist to add to", bidList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addBid(bidList, Bd1);
		assertEquals("Check that User arraylist size is 1", 1, bidList.size());
		assertSame("Check that User is added", Bd1, bidList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addBid(bidList, Bd2);
		assertEquals("Check that User arraylist size is 2", 2, bidList.size());
		assertSame("Check that User is added", Bd2, bidList.get(1));
		}
			
	
	//======================================UPDATE==========================================================================================================================================================================================================//
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
	public void testDoUpdateItem() {

		//boundary
		assertNotNull("test if there is valid item arraylist to update from", itemList);
		
		C206_CaseStudy.addItem(itemList, it1);
		
		// normal
		Boolean ok = C206_CaseStudy.doUpdateItem(itemList,1,"Limited Edition RP Reusable Cup", "Condition: Brand New, Rose Gold Stainless Steel Cup with 500ml capacity.", 
9.00, LocalDate.parse("01/02/2022", form1), LocalDate.parse("10/02/2022", form1), 2.00);
		assertTrue("Test if an available item is ok to update?", ok);
		
		//error condition
		ok = C206_CaseStudy.doUpdateItem(itemList,1, "Limited Edition RP Reusable Cup", "Condition: Brand New, Rose Gold Stainless Steel Cup with 500ml capacity.", 
9.00, LocalDate.parse("01/02/2022", form1), LocalDate.parse("10/02/2022", form1), 2.00);
		assertFalse("Test if an same item is NOT ok to update again?", ok);	
		
		//error condition
		C206_CaseStudy.addItem(itemList, it2);	
		it2.setIsAvailable(false);
		ok = C206_CaseStudy.doUpdateItem(itemList,2, "Limited Edition Stranger Things Tote Bag", "Condition: Like New, Bag is stranger than Stranger Things", 
15.00, LocalDate.parse("01/02/2022", form1), LocalDate.parse("11/02/2022", form1), 5.00);
		assertFalse("Test that un-available item is NOT ok to update?", ok);

	
		
		//error condition
		ok = C206_CaseStudy.doUpdateItem(itemList,3, "Limited Edition Bottle", "Condition: Like New, Bag is stranger than Stranger Things", 
20.00, LocalDate.parse("01/02/2022", form1), LocalDate.parse("12/02/2022", form1), 7.00);
		assertFalse("Test that non-exiting item is NOT ok to update?",ok);
	}
	
	
	
//=========================================================================DELETE=================================================================================================================================================================================================================================================================================================
	@Test 
	public void testDoRemoveItem() {
		//boundary
				assertNotNull("test if there is a removal of item", itemList);
						
				C206_CaseStudy.addItem(itemList, it1);
						
				// normal
				Boolean ok = C206_CaseStudy.doRemoveItem(itemList, 1, "Drinkware");
				assertTrue("Test if item is to remove?", ok);
				assertFalse(itemList.get(0).getIsAvailable());
				assertEquals(itemList.get(0).getId(),"ID");
						
								
				//error condition
				ok = C206_CaseStudy.doRemoveItem(itemList, 2,"Bag");
				assertFalse("Test if the item is NOT ok to remove again?", ok);	
			
						
				//error condition
				ok = C206_CaseStudy.doRemoveItem(itemList, 2, "Bag");
				assertFalse("Test that non-existing item is NOT ok to remove?", ok);

		
	}
	
	@Test
	public void testDoRemoveUser() {
		//boundary
		assertNotNull("test if there is a removal of user", userList);
				
		C206_CaseStudy.addUser(userList, us1);
				
		// normal
		Boolean ok = C206_CaseStudy.doRemoveUser(userList, "tester", "y");
		assertTrue("Test if user is ok to remove?", ok);
				
						
		//error condition
		ok = C206_CaseStudy.doRemoveUser(userList, "tester", "y");
		assertFalse("Test if the same user is NOT ok to remove again?", ok);	
	
				
		//error condition
		ok = C206_CaseStudy.doRemoveUser(userList, "tester2", "y");
		assertFalse("Test that non-existing user is NOT ok to remove?", ok);


	}
	//Remove Bid 
	@Test
	public void testDoRemoveBid() {
		//boundary
		assertNotNull("test if there is a removal of user", bidList);
				
		C206_CaseStudy.addBid(bidList, Bd1);
				
		// normal
		Boolean ok = C206_CaseStudy.doRemoveBid(bidList, "tester", "y");
		assertTrue("Test if user is ok to remove?", ok);
	}
	
	@Test
	public void testDoRemoveDeal() {
		//boundary
		assertNotNull("test if there is a removal of user", DealList);
				
		C206_CaseStudy.addDeal(DealList, de1);
				
		// normal
		Boolean ok = C206_CaseStudy.doRemoveDeal(DealList, "tester", "y");
		assertTrue("Test if Deal is ok to remove?", ok);
				
						
		//error condition
		ok = C206_CaseStudy.doRemoveDeal(DealList, "tester", "y");
		assertFalse("Test if the same Deal is NOT ok to remove again?", ok);	
	
				
		//error condition
		ok = C206_CaseStudy.doRemoveDeal(DealList, "tester2", "y");
		assertFalse("Test that non-existing user is NOT ok to remove?", ok);


	}

	@After
	public void tearDown() throws Exception {
		us1 = null;
		us2 = null;
		userList = null;
	}
	@Test
	public void testAddDeal() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid User arraylist to add to", DealList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addDeal(DealList, de1);
		assertEquals("Check that User arraylist size is 1", 1, DealList.size());
		assertSame("Check that User is added", Bd1, DealList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addDeal(DealList, de2);
		assertEquals("Check that User arraylist size is 2", 2, DealList.size());
		assertSame("Check that User is added", de2, DealList.get(1));
		}
	
	 
}

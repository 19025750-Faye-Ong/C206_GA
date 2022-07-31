import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private User us1;
	private User us2;
	
	ArrayList<User> userList = new ArrayList<User>();
	
	public C206_CaseStudyTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data 
		us1 = new User("tester", "Password123", "Team One",88121234,"tester@gmail.com");
		us2 = new User("tester2","Password123", "Group One",88989876,"tester2@gmail.com");
		
		userList= new ArrayList<User>();
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

	@After
	public void tearDown() throws Exception {
		us1 = null;
		us2 = null;
		userList = null;
	}
	
}

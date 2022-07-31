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
	
	public static String retreiveAllItem(ArrayList<Item>itemList ) {
		String output = "";

		for (int i = 0; i < itemList.size(); i++) {
			output += String.format("%-10s %-30s %-10s %-10d.2f %-10s %-10s %-20d.2f\n", itemList.get(i).getName()
					itemList.get(i).getDescription(), C206_CaseStudy.showAvailability(itemList.get(i).getIsAvailable()), itemList.get(i).getMinBid(), 
					itemList.get(i).getAuctionStart(),itemList.get(i).getAuctionEnd(), itemList.get(i).getBidIncrement());
			
						
		}
		return output; 	
	}
	public static void viewAllList(ArrayList<Item> itemList) {
		C206_CaseStudy.setHeader("ITEM LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ASSET TAG", "DESCRIPTION",
				"AVAILABLE", "DUE DATE","OPTICAL ZOOM");
		 output += retreiveAllItem(itemList);	
		System.out.println(output);
}



}

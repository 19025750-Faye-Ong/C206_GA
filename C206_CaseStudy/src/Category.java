import java.time.LocalDate;

public class Category extends Item{
	private String category;
	
	public Category(int id, String name, String description, double minBid, LocalDate auctionStart, LocalDate auctionEnd, double bidIncrement , String cat) {
		super(id, name, description, minBid, auctionStart, auctionEnd, bidIncrement);
		this.category = cat;
	}

	public String getCategory() {
		return category;
	}

	//FOR ADMIN ONLY
	public void setCategory(String category) {
		this.category = category;
	}
}

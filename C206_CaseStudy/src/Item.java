import java.time.LocalDate;

public class Item {
	private int id;
	private String name;
	private String description;
	private double minBid;
	private LocalDate auctionStart;
	private LocalDate auctionEnd;
	private double bidIncrement;
	private boolean isAvailable;
	
	public Item(int id, String name, String description, double minBid, LocalDate auctionStart, LocalDate auctionEnd, double bidIncrement) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.minBid = minBid;
		this.auctionStart = this.auctionStart;
		this.auctionEnd = this.auctionEnd;
		this.bidIncrement = bidIncrement;
		this.isAvailable = true;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getMinBid() {
		return minBid;
	}
	
	public void setMinBid(double minBid) {
		this.minBid = minBid;
	}
	
	public LocalDate getAuctionStart() {
		return auctionStart;
	}
	
	public void setAuctionStart(LocalDate auctionStart) {
		this.auctionStart = auctionStart;
	}
	
	public LocalDate getAuctionEnd() {
		return auctionEnd;
	}
	
	public void setAuctionEnd(LocalDate auctionEnd) {
		this.auctionEnd = auctionEnd;
	}
	
	public double getBidIncrement() {
		return bidIncrement;
	}
	
	public void setBidIncrement(double bidIncrement) {
		this.bidIncrement = bidIncrement;
	}
	
	public boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}

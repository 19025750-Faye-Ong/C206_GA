
public class Item {
	private int id;
	private String name;
	private String description;
	private double minBid;
	private String auctionStart;
	private String auctionEnd;
	private double bidIncrement;
	
	public Item(int id, String name, String description, double minBid, String auctionStart, String auctionEnd,
			double bidIncrement) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.minBid = minBid;
		this.auctionStart = "";
		this.auctionEnd = "";
		this.bidIncrement = bidIncrement;
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
	
	public String getAuctionStart() {
		return auctionStart;
	}
	
	public void setAuctionStart(String auctionStart) {
		this.auctionStart = auctionStart;
	}
	
	public String getAuctionEnd() {
		return auctionEnd;
	}
	
	public void setAuctionEnd(String auctionEnd) {
		this.auctionEnd = auctionEnd;
	}
	
	public double getBidIncrement() {
		return bidIncrement;
	}
	
	public void setBidIncrement(double bidIncrement) {
		this.bidIncrement = bidIncrement;
	}
}


public class Item {
	private String name;
	private String description;
	private double minBid;
	private String auctionStart;
	private String auctionEnd;
	private double bidIncrement;
	
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

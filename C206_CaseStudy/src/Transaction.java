
public class Transaction extends Item{

	private String transactionid; 
	public Transaction(String name, String description, double minBid, String auctionStart, String auctionEnd,
			double bidIncrement) {
		super(name, description, minBid, auctionStart, auctionEnd, bidIncrement);

	}
	public String getTransactionid() {
		return transactionid;
	}


}

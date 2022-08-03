
public class Bid  {
	private int BidID; 
	private double BidPrice;
	
	
	public Bid(int bidID, double bidPrice) {
		this.BidID = bidID;
		this.BidPrice= bidPrice;
	}


	public int getBidID() {
		return BidID;
	}

	public double getBidPrice() {
		return BidPrice;
	}


	public void setBidPrice(double bidPrice) {
		BidPrice = bidPrice;
	}
	

}

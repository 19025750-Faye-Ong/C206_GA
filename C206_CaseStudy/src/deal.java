import java.sql.Date;
import java.time.LocalDate;

public class deal {
	private String dealid;
	private Double finalPrice;
	private Date CloseDate;
	
	
	public deal(int id,  String name, String description, double minBid, LocalDate auctionStart, LocalDate auctionEnd,
			double bidIncrement, String dealid, Double finalPrice, Date dealDate) {
		this.dealid = dealid;
		this.finalPrice = finalPrice;
		this.CloseDate = dealDate;
	}


	public String getdealid() {
		return dealid;
	}


	public Double getFinalPrice() {
		return finalPrice;
	}


	public Date getdealDate() {
		return dealDate;
	}
		
}	

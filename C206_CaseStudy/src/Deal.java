import java.sql.Date;
import java.time.LocalDate;

public class Deal {
	private String dealid;
	private Double finalPrice;
	private Date dealDate;
	
	
	public Deal(int id,  String name, String description, double minBid, LocalDate auctionStart, LocalDate auctionEnd,
			double bidIncrement, String dealid, Double finalPrice, Date dealDate) {
		this.dealid = dealid;
		this.finalPrice = finalPrice;
		this.dealDate = dealDate;
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

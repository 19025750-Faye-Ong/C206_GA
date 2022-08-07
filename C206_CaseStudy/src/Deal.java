import java.sql.Date;
import java.time.LocalDate;

public class Deal {
	private int dealid;
	private Double finalPrice;
	private LocalDate dealDate;
	
	
	public Deal(int id,  String name, String description, double minBid, LocalDate auctionStart, LocalDate auctionEnd,
			double bidIncrement, int dealid, Double finalPrice, LocalDate dealDate) {
		this.dealid = dealid;
		this.finalPrice = finalPrice;
		this.dealDate = dealDate;
	}


	public int getdealid() {
		return dealid;
	}


	public Double getFinalPrice() {
		return finalPrice;
	}


	public LocalDate getdealDate() {
		return dealDate;
	}
		
}	

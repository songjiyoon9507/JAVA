package inheritance;

public class GoldCustomer extends Customer {
	
	double saleRatio;

	public GoldCustomer(int customerId, String customerName) {
		super(customerId, customerName);
		customerGrade = "GOLD";
		bonusRatio = 0.02;
		saleRatio = 0.1;
	}
	
	public int calcPrice(int price) {
		bonusPoint += price*bonusRatio;
		return price - (int)(price*saleRatio);
	}

}

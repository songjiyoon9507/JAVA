package inheritance;

public class Customer {
	
	protected int customerId; // 고객 아이디
	protected String customerName; // 고객 이름
	protected String customerGrade; // 고객 등급
	protected int bonusPoint; // 보너스 포인트
	protected double bonusRatio; // 적립 비율
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerGrade() {
		return customerGrade;
	}
	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}
	public int getBonusPoint() {
		return bonusPoint;
	}
	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	public double getBonusRatio() {
		return bonusRatio;
	}
	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}
	
	public Customer() {
		customerGrade = "SILVER"; // 기본 등급
		bonusRatio = 0.01; // 기본 적립 비율
	}
	
	public Customer(int customerId, String customerName) {
		customerGrade = "SILVER";
		bonusRatio = 0.01;
		this.customerId = customerId;
		this.customerName = customerName;
	}
	
	public int calcPrice(int price) {
		bonusPoint += price*bonusRatio; // 보너스 포인트 적립
		return price; // 기본 고객은 할인 안해줌 그냥 들어온 가격 그대로 돌려주면됨
		// 적립만 해주고 가격 돌려줌
	}
	
	public String showInfo() {
		return customerName + "님의 등급은 " + customerGrade 
				+ "이며, 보너스 포인트는 " + bonusPoint + "point 입니다.";
	}
	
}

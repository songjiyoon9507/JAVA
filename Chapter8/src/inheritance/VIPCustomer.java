package inheritance;

public class VIPCustomer extends Customer {
	
	private int agentId; // VIP 고객 전담 상담원 아이디
	private double saleRatio; // 할인율
	
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public double getSaleRatio() {
		return saleRatio;
	}
	public void setSaleRatio(double saleRatio) {
		this.saleRatio = saleRatio;
	}

	public VIPCustomer() {
		customerGrade = "VIP"; // Customer 클래스에 protected 로 설정해놔서
		// 그냥 가져올 수 있음
		bonusRatio = 0.05;
		saleRatio = 0.1;
	}
	
	public VIPCustomer(int customerId, String customerName, int agentId) {
		super(customerId, customerName);
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
		this.agentId = agentId;
	}
	
	public int calcPrice(int price) {
		bonusPoint += price*bonusRatio;
		return price - (int)(price*saleRatio);
	}
	
	public String showInfo() {
		return super.showInfo() + "담당 상담원 번호는 " + agentId + "입니다.";
	}
}

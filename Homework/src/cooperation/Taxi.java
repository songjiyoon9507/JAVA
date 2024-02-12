package cooperation;

public class Taxi {
	public String taxiNumber;
	public int money;
	
	public Taxi(String taxiNumber) {
		this.taxiNumber = taxiNumber;
	}
	
	public void take(int money) {
		this.money += money;
	}
	
	public void showInfo() {
		System.out.println(taxiNumber + " 택시의 수입은 " + money + "원입니다.");
	}
}

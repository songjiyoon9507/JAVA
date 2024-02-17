package cooperation;

public class Coffeebeen {
	// 이 씨가 라떼 사먹음 4500
	
	private String coffee; // 커피 종류
	private int price; // 커피 가격
	private int total; // 매출
	
	
	
	public String getCoffee() {
		return coffee;
	}
	public void setCoffee(String coffee) {
		this.coffee = coffee;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	// 생성자
	public Coffeebeen() {}
	
	public Coffeebeen(String coffee, int price) {

		this.coffee = coffee;
		this.price = price;
		
	}
	
	public void drink() {
		
	}
	
}

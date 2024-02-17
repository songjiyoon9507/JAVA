package cooperation;

public class Starbucks {
	// 김씨가 아메리카노 사먹음 4000원
	
	// 커피가 있고 돈이 있음
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
	public Starbucks() {}
	
	public Starbucks(String coffee, int price) {

		this.coffee = coffee;
		this.price = price;
		
	}
	
	public void drink() {
		
	}
	
}

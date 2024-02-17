package cooperation;

public class Person {
	private String name; // 이름
	private int money; // 돈
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	// 생성자
	public Person() {}
	
	public Person(String name, int money) {
		
		this.name = name;
		this.money = money;
	}
	
	public void drinkAmericano(Starbucks starbucks) {
		// 사람 돈 빠지고 가게 매출 올라감
		
	}
	
	public void drinkLatte() {
		
	}
}

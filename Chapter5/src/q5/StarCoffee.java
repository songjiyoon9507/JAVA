package q5;

public class StarCoffee {
	
	int money;
	
	public String make(int money) {
		
		this.money += money;
		
		if(money == Menu.STARAMERICANO) {
			return "별 다방 아메리카노를 구입했습니다.";
		} else if(money == Menu.STARLATTE) {
			return "별 다방 라떼를 구입했습니다.";
		} else {
			return null;
		}
		
	}
}

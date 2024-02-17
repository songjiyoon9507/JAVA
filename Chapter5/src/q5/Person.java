package q5;

public class Person {
	String name;
	int money;
	
	Person(String name, int money) {
		this.name = name;
		this.money = money;
	}
	
	public void buyStarCoffee(StarCoffee sc, int money) {
		String message = sc.make(money);
		// 구매할 만큼의 돈 넣었으면
		// 스벅 아메리카노 4000원 라떼 4300원 (Menu 에 상수로 설정)
		if(message != null) {
			this.money -= money;
			// 돈 잘못 내면 커피 안줌
			// 제대로 냈을 때 메세지 돌아옴
			// 사람 돈 깎임
			System.out.println(name + "님의 잔액 : " + this.money + "원\n" + message);
		}
	}
	
	public void buyBeanCoffee(BeanCoffee bc, int money) {
		String message = bc.make(money);
		// 콩 커피 아메리카노 4100 라떼 4500
		if(message != null) {
			this.money -= money;
			System.out.println(name + "님의 잔액 : " + this.money + "원\n" + message );
		}
	}
	
}

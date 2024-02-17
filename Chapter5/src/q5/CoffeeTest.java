package q5;

public class CoffeeTest {
	
	public static void main(String[] args) {
		
		Person Kim = new Person("김첨지", 10000); // 사람 객체 생성 이름 김 씨 가진 돈 10000원
		StarCoffee starCoffee = new StarCoffee(); // 기본 생성자로 커피 만듦
		
		Person Lee = new Person("이순신", 20000);
		BeanCoffee beanCoffee = new BeanCoffee();
		
		Kim.buyStarCoffee(starCoffee, 4000);
		Lee.buyBeanCoffee(beanCoffee, 4500);
	}
}

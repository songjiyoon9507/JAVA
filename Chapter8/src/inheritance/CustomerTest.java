package inheritance;

public class CustomerTest {
	public static void main(String[] args) {
		Customer Lee = new Customer();
		Lee.setCustomerId(10010);
		Lee.setCustomerName("이순신");
		Lee.setBonusPoint(1000);
		
		System.out.println(Lee.showInfo());
		
		VIPCustomer Kim = new VIPCustomer();
		Kim.setCustomerId(10020);
		Kim.setCustomerName("김유신");
		Kim.setBonusPoint(1000);
		
		System.out.println(Kim.showInfo());
		
		int price = 10000;
		System.out.println(Lee.getCustomerName() + "님이 지불해야 하는 금액은 " + Lee.calcPrice(price) + "원입니다.");
		System.out.println(Kim.getCustomerName() + "님이 지불해야 하는 금액은 " + Kim.calcPrice(price) + "원입니다.");
		
		// Customer 형이어도 생성자가 VIP 라서 호출된 메서드도 VIP 클래스 거 호출됨
		// 가상 메서드(virtual method  )
		Customer Na = new VIPCustomer(10030, "나몰라", 2000);
		System.out.println(Na.getCustomerName() + "님이 지불해야 하는 금액은 " + Na.calcPrice(price) + "원입니다.");
		System.out.println(Na.showInfo());
	}
}

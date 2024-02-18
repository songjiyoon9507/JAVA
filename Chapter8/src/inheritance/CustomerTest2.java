package inheritance;

import java.util.ArrayList;

public class CustomerTest2 {
	public static void main(String[] args) {
		
		ArrayList<Customer> cl = new ArrayList<Customer>();
		
		// 일반 고객 2 gold 2 vip 1
		Customer c1 = new Customer(10010, "이순신");
		Customer c2 = new Customer(10020, "신사임당");
		Customer c3 = new GoldCustomer(10030, "홍길동");
		Customer c4 = new GoldCustomer(10040, "이율곡");
		Customer c5 = new VIPCustomer(100450, "김유신", 12345);
		
		// 배열에 넣어주기
		cl.add(c1);
		cl.add(c2);
		cl.add(c3);
		cl.add(c4);
		cl.add(c5);
		
		System.out.println("===== 고객 정보 출력 =====");
		for(Customer customerList : cl) {
			System.out.println(customerList.showInfo());
		}
		
		System.out.println("===== 할인율과 보너스 포인트 계산 =====");
		int price = 10000;
		for(Customer customerList : cl) {
			int cost = customerList.calcPrice(price);
			System.out.println(customerList.getCustomerName() + "님이 "
					+ cost + "원 지불하셨습니다.");
			System.out.println(customerList.showInfo());
		}
	}
}

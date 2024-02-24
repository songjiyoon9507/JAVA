package interfaceex;

public class CustomerTest {
	public static void main(String[] args) {
		Customer customer = new Customer();
		
		// Customer 에서 Buy 로 형 변환
		Buy buyer = customer;
		// Buy 인터페이스의 메서드만 호출 가능
		buyer.buy();
//		구매하기
		buyer.order();
//		고객 판매 주문
		// Buy 형이지만 Customer 에서 오버라이딩 했기 때문에 출력은 고객 판매 주문 결과 나옴
		
		
		Sell seller = customer;
		seller.sell();
//		판매하기
		seller.order();
//		고객 판매 주문
		// 여기도 마찬가지
		
		if(seller instanceof Customer) {
			// Sell 형인 seller 를 다시 Customer 로 다시 형 변환
			Customer customer2 = (Customer)seller;
			customer2.buy();
			customer2.sell();
//			구매하기
//			판매하기
		}
		customer.order();
		// 고객 판매 주문  
	}
}

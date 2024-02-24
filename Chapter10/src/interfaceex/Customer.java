package interfaceex;

// Customer 클래스는 Buy 와 Sell 인터페이스를 모두 구현할 수 있음
public class Customer implements Buy, Sell {

	@Override
	public void sell() {
		System.out.println("판매하기");
	}

	@Override
	public void buy() {
		System.out.println("구매하기");
	}

	@Override
	public void order() {
		System.out.println("고객 판매 주문");
	}

}

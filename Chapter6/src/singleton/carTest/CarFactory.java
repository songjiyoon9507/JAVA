package singleton.carTest;

public class CarFactory {
	// 싱글톤패턴
	// 유일한 차공장
	
	// 유일한 생성자
	private CarFactory() {}
	
	private static CarFactory instance = new CarFactory();
	
	public static CarFactory getInstance() { // static 메서드 == 클래스 메서드
		// static 변수를 위한 메서드
		// static 예약어 붙인 클래스 메서드
		if(instance == null) {
			instance = new CarFactory();
		}
		return instance;
		// istance 가 null 일 때 생성해서 돌려줘라
	}
	
	public Car createCar() {
		// 반환형 Car
		
		// Car 클래스에 있는 생성자 불러와서 객체화
		// createCar 부를 때마다 차 한대 만들어줌
		Car car = new Car();
		// 이 생성자는 carNum을 부여해줌 (Car 클래스에서 그렇게 써놓음)
		return car;
	}
}

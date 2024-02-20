package template;

public abstract class Car {
	public abstract void drive();
	public abstract void stop();
	public abstract void wiper();
	
	public void startCar() {
		System.out.println("시동을 켭니다.");
	}
	
	public void turnOff() {
		System.out.println("시동을 끕니다.");
	}
	
	/**
	 * 템플릿 메서드
	 * 메서드 실행 순서와 시나리오를 정의
	 * 상위 클래스를 상속받은 하위 클래스에서
	 * 템플릿 메서드를 재정의하면 안됨
	 * 로직 흐름을 정의하는 역할
	 */
	final public void run() {
		startCar();
		drive();
		wiper();
		stop();
		turnOff();
	}
}

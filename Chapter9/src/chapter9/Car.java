package chapter9;

public abstract class Car {
	// 추상 클래스
	public void start() {
		System.out.println("시동을 켭니다.");
	}
	
	public void drive() {
		System.out.println("달립니다.");
	}
	
	public void stop() {
		System.out.println("멈춥니다.");
	}
	
	public void turnoff() {
		System.out.println("시동을 끕니다.");
	}
	
	public abstract void washCar();
	
	// 템플릿 메서드
	final public void run() {
		start();
		drive();
		stop();
		turnoff();
	}
}

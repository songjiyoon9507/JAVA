package chapter9;

public class Avante extends Car {

	
	
	@Override
	public void start() {
		System.out.print("Avante ");
		super.start();
	}

	@Override
	public void drive() {
		System.out.print("Avante ");
		super.drive();
	}

	@Override
	public void stop() {
		System.out.print("Avante ");
		super.stop();
	}

	@Override
	public void turnoff() {
		System.out.print("Avante ");
		super.turnoff();
	}

	@Override
	public void washCar() {
		System.out.println("세차를 합니다.");
	}

}

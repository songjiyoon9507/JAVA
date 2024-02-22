package chapter9;

public class Genesis extends Car {

	@Override
	public void start() {
		System.out.print("Genesis ");
		super.start();
	}

	@Override
	public void drive() {
		System.out.print("Genesis ");
		super.drive();
	}

	@Override
	public void stop() {
		System.out.print("Genesis ");
		super.stop();
	}

	@Override
	public void turnoff() {
		System.out.print("Genesis ");
		super.turnoff();
	}

	@Override
	public void washCar() {
		System.out.println("세차를 합니다.");
	}

}

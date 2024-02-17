package singleton.carTest;

public class Car {
	// 공장에서 생성되는 자동차는 제작될 때마다 고유 번호 부여
	
	private static int serialNum = 10000;
	private int carNum;
	
	// 자동차 생성될 때마다 번호 부여
	public Car () {
		serialNum++;
		carNum = serialNum;
	}
	
	// CarNum 불러 올 수 있게 밖에서
	public int getCarNum() {
		return carNum;
	}
	
	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}
	
}

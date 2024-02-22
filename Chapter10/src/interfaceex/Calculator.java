package interfaceex;

public abstract class Calculator implements Calc { // 추상 클래스 인터페이스 전부 가져오지 않음

	@Override
	public int add(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public int substract(int num1, int num2) {
		return num1-num2;
	}

//	@Override
//	public int times(int num1, int num2) {
//		return num1*num2;
//	}
//
//	@Override
//	public int divide(int num1, int num2) {
//		return num1/num2;
//	}

}

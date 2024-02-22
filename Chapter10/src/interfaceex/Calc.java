package interfaceex;

public interface Calc {
	// 인터페이스에 선언한 메서드는 모두 구현 코드가 없는 추상메서드
	// public abstract 예약어를 명시적으로 쓰지 않아도 컴파일 과정에서 자동으로 추상 메서드로 변환

	double PI = 3.14;
	// 인터페이스에서 선언한 변수는 컴파일 과정에서 상수로 변환됨
	// public static final 예약어를 쓰지 않아도 무조건 상수로 인식
	int ERROR = -999999999;
	
	// 인터페이스에서 선언한 메서드는 컴파일 과정에서 추상 메서드로 변환됨
	int add(int num1, int num2);
	int substract(int num1, int num2);
	int times(int num1, int num2);
	int divide(int num1, int num2);
}

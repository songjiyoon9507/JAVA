package interfaceex;

public class CalculatorTest {
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 5;
		
		// Calc 인터페이스를 상속 받은 Calculator 를 상속 받은 CompeleteCalc
		// Calc 인터페이스는 추상메서드만 선언돼서 인스턴스를 생성할 수 없음
		// Calculator 클래스는 추상 클래스이므로 인스턴스를 생성할 수 없음
		// CompeleteCalc는 다 사용할 수 있음
		CompleteCalc calc = new CompleteCalc();
		// Calc clac = new CompleteCalc();
		// 이렇게 선언해도 똑같음 다 상속 상속이어서 사용할 수 있음
		System.out.println(calc.add(num1, num2));
		System.out.println(calc.substract(num1, num2));
		System.out.println(calc.times(num1, num2));
		System.out.println(calc.divide(num1, num2));
		System.out.println(calc.square(num2));
		calc.showInfo();
	}
}

package home.practice;

public class Practice2 {

	public static void main(String[] args) {
		// boolean && ||
		int num1 = 10;
		int i = 2;
		
		boolean value = ((num1 = num1 + 10) < 10) && ((i = i + 2) < 10);
		// num1은 10보다 작고 i는 10보다 작다 false
		System.out.println(value); // false
		System.out.println(num1); // num1 = 20
		// 앞에서 false가 나오면 뒤에는 실행하지 않음
		System.out.println(i); // 연산 실행 안돼서 i = 2 가 나옴
		
		value = ((num1 = num1 + 10) > 10) || ((i = i + 2) < 10);
		// 30은 10보다 크거나 에서 true가 나오면서 뒤에는 연산 하지 않음
		System.out.println(value); // true
		System.out.println(num1); // 30
		System.out.println(i); // 뒤에 실행 안 돼서 결과갑 2
		
		int num2 = 5;
		int i2 = 10;
		
		boolean value2 = ((num2 = num2 * 10) > 45) || ((i2 = i2 - 5) < 10);
		// num2 = 50 > 45 true 나오면서 뒤에 계산하지 않음
		System.out.println(value2); // true
		System.out.println(num2); // 50
		System.out.println(i2); // 10
	}

}

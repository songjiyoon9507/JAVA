package assignment;

public class OperationEx3 {

	public static void main(String[] args) {

		int num1 = 10;
		int i1 = 2;
		
		boolean value = ( ((num1 = num1 + 10) < 10) && ((i1 = i1 + 2) > 10) );
		System.out.println(value); //&&는 둘 다 true 일 때 true
		System.out.println(num1);  //앞에 값이 false라서 앞에 값은 계산됨
		System.out.println(i1); // 뒤에 값은 앞에 값이 false라서 평가 안함
		// 계산 안됨
		
		int num2 = 10;
		int i2= 2;
		
		boolean value2 = ((num2 = num2 + 10) > 10) && ((i2 = i2 + 2) > 10);
		System.out.println(value2);
		System.out.println(num2); //앞에 항이 true
		System.out.println(i2);  // 뒤에도 평가해봐야해서 뒤에 값도 계산됨
		
		int num3 = 10;
		int i3 = 2;
		
		boolean value3 = ((num3 = num3 + 10 ) > 10) || ((i3 = i3 + 2) > 10);
		System.out.println(value3); //||는 둘 중 하나가 true이면 true
		System.out.println(num3); //앞에 값이 true라서 앞은 계산됨
		System.out.println(i3); //앞에 값이 true라서 뒤에는 평가 안함
		//결과 값 계산 안돼서 더해지지 않음
	}

}
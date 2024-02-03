package home.practice;

public class Practice4 {

	public static void main(String[] args) {
		// 연습문제
		int myAge = 23;
		int teacherAge = 38;
		
		boolean value = (myAge > 25);
		System.out.println(value); // false
		
		System.out.println(myAge <= 25); // true
		System.out.println(myAge == teacherAge); // false
		
		char ch;
		ch = (myAge > teacherAge) ? 'T' : 'F'; // false
		
		System.out.println(ch); // F
		
		System.out.println("-------------------");
		// 비트 논리 연산자
		/* &(AND) 연산자
		 * 1이고 1
		 * 비트 값이 모두 1인 경우 1
		 * 
		 * |(OR) 연산자
		 * 1이거나 1 이면 1
		 * 비트 값 하나라도 1이면 1
		 * 모두 0 이면 0
		 * 
		 * ^ 연산자
		 * 같은 값이면 0 다른 값이면 1
		 * 
		 * ~(반전) 연산자
		 * 다 뒤집음
		 * */
		
		// 복합 대입 연산자
		int num = 8;
		
		System.out.println(num += 10);
		// 값이 num에 대입됨 num = 18
		System.out.println(num -= 10);
		// num 18 에서 -10
		// 결과값 8
		System.out.println(num >>= 2);
		// 8 2진수 00001000
		// >>     00000010
		// num = 2 가 됨
		System.out.println(num);
		
		System.out.println("-------------------");
	}

}

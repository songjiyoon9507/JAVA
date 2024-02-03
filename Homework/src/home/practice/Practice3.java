package home.practice;

public class Practice3 {

	public static void main(String[] args) {
		// 조건 연산자
		
		int fatherAge = 45;
		int motherAge = 47;
		
		char ch;
		ch = (fatherAge > motherAge) ? 'T' : 'F' ;
		
		System.out.println(ch); // false 'F'
		
		// 조건 연산자 사용 10이 짝수인 경우 true false
		int num = 10;
		boolean isEven;
		isEven = (num % 2 == 0) ? true : false ;
		
		System.out.println(isEven);
	}

}

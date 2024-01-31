package assignment;

public class OperationEx4 {

	public static void main(String[] args) {

		int num1 = 10;
		System.out.println(num1 += 1); //결과값 11 num1값 바뀌는 거
		
		System.out.println(num1 %= 10); // 11을 10으로 나눈 나머지
		//결과값 1 num1값 또 바뀜
		num1 -= 1;
		System.out.println(num1); //1에서 1을 뺀 결과값 0
	}

}

package assignment;

public class OperationEx5 {

	public static void main(String[] args) {

		int num1 = 5; //00000101
		int num2 =10; //00001010
		int result = num1 & num2; //둘 다 1인 게 하나도 없음
		System.out.println(result); //결과값 0
		
		int num3 =5; //00000101
		int num4 =11;//00001011
		int result2 = num3 & num4; //마지막이 둘 다 1
		System.out.println(result2); //결과값 1
		
		int num5 = 5; //00000101
		int num6 = 10;//00001010
		int result3 = num5 | num6; //00001111
		System.out.println(result3); //두 비트 모두 0이 아니면 1로 나와서
		// 2진수 00001111 10진수로 변환하면 15 결과값 15
		
		int num7 =5; //00000101
		System.out.println(num7<<3); //00101000 2의5제곱 +2의3제곱
		// 5 곱하기 2의3제곱 = 5곱하기8 = 40 num7 * 2의n제곱
		//결과값 40
		System.out.println(num7); // num7의 값은 변하지 않음 5
		
		System.out.println(num7<<=3); // 복합연산자 사용=이 더해져서
		System.out.println(num7); //num7의 값이 변함 40
		
		int num8 = 5;
		System.out.println(num8>>2); //00000001 결과값1
		System.out.println(num8>>1); //00000010 결과값2
	}

}

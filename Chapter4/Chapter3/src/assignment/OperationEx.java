package assignment;

public class OperationEx {

	public static void main(String[] args) {
		int age = 24;  //=대입연산자
		System.out.println(age); //대입연산자는 우선 순위가 가장 낮음
		
		int num = 10;
		int num2 = -num;  //num2는 -10이 나오지만 num의 값이 바뀐 건 아님
		System.out.println(+num);
		System.out.println(-num); //num = 10 앞에 - 붙인 것
		System.out.println(num); //부호연산자 값을 바꾸지 않음
		System.out.println(num2);
		
		num = -num;  //num 값을 음수로 바꿔 다시 num에 대입함
		System.out.println(num); //결과값 -10 출력
		//변수는 대입연산자 통해서 바꿔줘야함
	}

}

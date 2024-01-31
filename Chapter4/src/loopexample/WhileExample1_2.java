package loopexample;

public class WhileExample1_2 {

	public static void main(String[] args) {
		
		int num = 1;
		int sum = 0;// sum값 초기화
		
		
		do {
			//sum = sum + num;
			sum += num;
			num++; //무조건 한번은 수행 됨 do while문
		}while(num < 1); //조건문 while이 뒤에 있기 때문에
		System.out.println("1부터 10까지의 합은 "+ sum + "입니다.");
		//결과값 1 나옴
		int num1 = 1;
		int sum1 = 0;// sum값 초기화
		
		
		while (num1 < 1) {
			//그냥 while문은 조건에 맞지 않으면 수행문이 실행 안됨
			sum1 += num1;
			num++;
		}
		System.out.println("1부터 10까지의 합은 "+ sum1 + "입니다.");
	}

}
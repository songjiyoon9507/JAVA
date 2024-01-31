package loopexample;

public class ForExample {

	public static void main(String[] args) {
		
		int num = 1;
		int sum = 0;
		
		while(num <= 10) {
			
			sum += num;
			num++;
		}
		System.out.println(sum);
		System.out.println(num); //결과값 11 조건 맞지 않아서 빠져나옴
		
		int num2;
		int sum2 = 0;
		
		for(num2 = 1; num2 <= 10; num2++) {
			//초기화 num2 = 1, sum2 = 0; 이렇게 입력하면 위에 =0 안써도됨
			sum2 += num2;
		}
		System.out.println(sum2);
		System.out.println(num2); //결과값11 증감식 들어가서 11
		//조건식 거짓이라 빠져나옴
	}

}

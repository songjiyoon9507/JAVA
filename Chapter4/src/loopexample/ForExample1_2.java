package loopexample;

public class ForExample1_2 {

	public static void main(String[] args) {
		
		int dan;
		int times;
		
		for(dan = 2; dan <= 9; dan++) { //
			for(times = 1; times<=9; times++) { //times 결과값은 10
				//내부 반복문 빠져 나갔을 때 times 1로 초기화
				System.out.println(dan + "X" + times + "=" + dan*times);
			}
			System.out.println();
			System.out.println(times);
			System.out.println(dan); //중괄호 빠져나오기 전까지는 9						
		}
		System.out.println(dan); //중괄호 빠져나온 후에는 10
		//dan++ 실행 후 조건 확인
	}

}

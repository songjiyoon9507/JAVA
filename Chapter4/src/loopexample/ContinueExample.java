package loopexample;

public class ContinueExample {

	public static void main(String[] args) {
		//홀수만 더하기
		int total = 0;
		int num;
		
		for(num = 1; num<=100; num++) { //100까지 반복
			
			if( (num % 2) == 0) {
				//num이 짝수이면 다시 위로 올라감
				continue;
			}
			total += num;       //num 값이 홀수인 경우에만 수행
		}
		System.out.println(total);
		//나머지 1일 때는 짝수만 더해서 결과값 2550
		//나머지 0일 때는 홀수만 더해서 결과값 2500
		//1부터 100까지 더하면 5050
	}

}

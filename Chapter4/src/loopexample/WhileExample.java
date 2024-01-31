package loopexample;

public class WhileExample {

	public static void main(String[] args) {
		
		int num = 1;
		int sum = 0;// sum값 초기화
		
		//웹서버 같은 경우 계속 돌려야해서 true값 집어넣음
		while( num <= 10) { //괄호 안에 true 넣으면 계속 반복됨 (무한반복)
			//num 값이 10보다 작거나 같을 동안
			//sum = sum + num;
			sum += num; //sum에 num을 더하고 누적
			num++; //num +1 num += 1; 과 같은 뜻
		} //중간에 나가려면 break문 이용해서 나갈 수 있음
		System.out.println("1부터 10까지의 합은 "+ sum + "입니다.");
	}

}

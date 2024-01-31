package loopexample;

public class BreakExample {

	public static void main(String[] args) {
		
		int sum = 0;
		int num = 1;
		
		while(sum < 100) {
			sum += num;
			num++;
		}
		
		System.out.println(sum); //105
		System.out.println(num); //15
		//100이 넘는 순간 num 값이 15가 아님 14까지 더했을 때 이미 100이 넘음
		//num++이 마지막에 있어서 결과값이 이렇게 나옴
		
		int sum2 = 0;
		int num2 = 1;
		
		while(true) {
			sum2 += num2;
			
			if(sum2>100)
				break; //sum2가 100보다 크면 멈추고 나가라
			num2++;  //위에서 멈춰서 실행 안됨
		}//가장 가까운 반복문만 빠져나옴
		
		System.out.println(sum2);
		System.out.println(num2); //결과값 14 14까지 더했을 때가 105
	}

}

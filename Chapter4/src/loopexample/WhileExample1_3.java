package loopexample;

public class WhileExample1_3 {

	public static void main(String[] args) {
		
		int dan = 2;
		int times = 1;
		
		while(dan <= 9) {
			//times = 1; 초기화식 넣어주면 9단까지 나옴
			while(times<=9) {
				System.out.println(dan + "X" + times + "=" + dan*times);
				times++;  //times가 10이 돼서 빠져나옴
				//while문 안에 times를 초기화 해주는 값이 없어서 2단까지만 출력
			}
			dan++; //dan+1 해줌
			System.out.println();
		} //이렇게 하면 2단까지밖에 안 찍힘
	}
}

package loopexample;

public class WhileExample1_4 {

	public static void main(String[] args) {
		//구구단 짝수단만 출력
		int dan = 2;
		int times = 1;
		
		while(dan <= 9) {
			if ( ( dan % 2 ) != 0) { //짝수 되면 증감식 수행 dan++
				dan++; // 조건식 짝수면 dan++
				continue; //짝수일 때 위로 올라감
			}// 홀수단일 때 아래로 내려옴
			times = 1;
			while(times<=9) {
				System.out.println(dan + "X" + times + "=" + dan*times);
				times++;
			}
			dan++;
			System.out.println();
		}
	}
}

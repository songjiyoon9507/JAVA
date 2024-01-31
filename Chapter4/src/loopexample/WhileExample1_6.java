package loopexample;

public class WhileExample1_6 {

	public static void main(String[] args) {
		
		int dan = 2;
		int times = 1;
		
		while(dan <= 9) {
		
			times = 1;
			while(times<=9) {
				if(times > dan) break; //times가 dan보다 크면 출력x
				//2단은 x2까지 ~ 9단은 x9까지
				System.out.println(dan + "X" + times + "=" + dan*times);
				times++;
			}
			dan++; //break 빠져 나오면 여기로 옴
			System.out.println();
		}
	}
}
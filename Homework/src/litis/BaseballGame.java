package litis;

import java.util.Scanner;

public class BaseballGame {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int round = 0;
		
		// 승패 기록
		int win = 0;
		int draw = 0;
		int lose = 0;
		int out = 0;
		
		while(lose < 6) {

			System.out.print("가위/바위/보 중 하나를 입력 : ");
			String input = sc.next();
			sc.nextLine();
			
			int random = (int)(Math.random() * 3 + 1); // 1 2 3
			
			String com = null;
			
			switch(random) {
				case 1 : com = "가위"; break;
				case 2 : com = "바위"; break;
				case 3 : com = "보"; break;
			}

			System.out.printf("컴퓨터는 [%s]를 선택했습니다. \n",com);
			
			round++;
			
			// 컴퓨터와 플레이어 가위바위보 판별
			if( input.equals(com) ) {
				System.out.println("비겼습니다.");
				draw++;
			} else {
				// 이긴 경우
				boolean win1 = input.equals("가위") && com.equals("보");
				boolean win2 = input.equals("바위") && com.equals("가위");
				boolean win3 = input.equals("보") && com.equals("바위");
				// 이겼으면 true 가 나오게 만들어줌
				if(win1 || win2 || win3) { // if 문이 true 일 때 수행하는 거니까
					System.out.println("1루 진출");
					win++;
				} else {
					System.out.println("스트라이크");
					lose++;
					
					if(lose % 2 == 0) {
						out++;
//						System.out.printf("%d 아웃", out);
					}
				}
			}

//			System.out.printf("[%d 라운드] 현재 기록 : %d승 %d무 %d패\n", round, win, draw, lose);
		
			if(out == 3) {
				System.out.println("게임 종료");
				System.out.printf("| %d 승 | %d 라운드 | %d 회 | %.2f%% |", win, round, draw, (float)win/round*100);
			}
		}
	}

}

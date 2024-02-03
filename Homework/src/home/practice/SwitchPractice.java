package home.practice;

import java.util.Scanner;

public class SwitchPractice {
	public static void main(String[] args) {
		// 입력 받은 숫자로 메달 색 결정하기
		// Scanner switch문 합치기
		Scanner sc = new Scanner (System.in);
		
		System.out.print("순위 입력 : ");
		
		int rank = sc.nextInt();
		String medalColor;
		
		switch(rank) {
			case 1 : medalColor = "금메달입니다.";
			break;
			
			case 2 : medalColor = "은메달입니다.";
			break;
			
			case 3 : medalColor = "동메달입니다.";
			break;
			
			default : medalColor = "참가상입니다.";
		}
		System.out.println(medalColor);
	}
}

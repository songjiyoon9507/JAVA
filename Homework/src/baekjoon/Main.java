package baekjoon;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		String str = sc.next();
		
		int sum = 0;
		
		for(int i = 0 ; i < N ; i++) {
			// 아스키코드 0 은 10 진수(int)로 바꾸면 48
			sum += str.charAt(i)-'0';
		}
		System.out.print(sum);
	}
}

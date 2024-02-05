package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt();
		int M = sc.nextInt();
		
		if (H < 0 && (M - 45) < 0) {
			System.out.printf("%d %d",23, 60  + (M - 45));
		} else if (H > 0 && (M - 45) < 0) {
			System.out.printf("%d %d", H-1, 60  + (M - 45));
		} else {
			System.out.printf("%d %d", H-1, M-1);
		}
	}
}
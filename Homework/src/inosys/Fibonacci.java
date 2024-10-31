package inosys;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("항의 수 입력 : ");
		int n = sc.nextInt();
		
		int num1 = 0;
		int num2 = 1;
		System.out.printf("피보나치 수열 : %d %d", num1, num2);
		
		if(n > 2) {
			for(int i = 2 ; i < n ; i++) {
				int nextNum = num1 + num2;
				System.out.printf(" %d", nextNum);
				num1 = num2;
				num2 = nextNum;
			}
		}
	}
}

package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String S = sc.next();
		
		int i = sc.nextInt();
		
		char[] arr = new char[S.length()];
		
		for(int x = 0 ; x < S.length() ; x++) {
			arr[x] = S.charAt(x);
			
			if(i == x+1) {
				System.out.println(arr[x]);
			}
		}
		
	}
}

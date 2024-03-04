package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int count = N;
		
		for(int i = 0 ; i < N ; i++) {
			String str = sc.next();
			
			for(int j = 0 ; j < str.length() ; j++) {
				if (j < str.length()-1 && str.charAt(j) != str.charAt(j+1)) {
//					if(str.charAt(j) == )
				}
			}
		}
		
	}
}

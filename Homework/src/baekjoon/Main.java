package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		int answer = str.length();
		
		for(int i = 0 ; i < str.length() ; i++) {
			
			char ch = str.charAt(i);
			
			if(ch == 'c' && str.charAt(i+1) == '=') {
				answer -= 1;
			}
			if(ch == 'c' && str.charAt(i+1) == '-') {
				answer -= 1;
			}
			if(ch == 'd' && str.charAt(i+1) == 'z' && str.charAt(i+2) == '=') {
				answer -= 2;
			}
			if(ch == 'd' && str.charAt(i+1) == '-') {
				answer -= 1;
			}
			if(ch == 'l' && str.charAt(i+1) == 'j') {
				answer -= 1;
			}
			if(ch == 'n' && str.charAt(i+1) == 'j') {
				answer -= 1;
			}
			if(ch == 's' && str.charAt(i+1) == '=') {
				answer -= 1;
			}

			
		}

		System.out.println(answer);
	}
}

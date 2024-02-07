package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();

		String i = "int";
		String l = "long";
		int a = N/4;
		String[] str = new String[a];
				
		for (int j = 0 ; j < str.length ; j++) {
			str[j] += l;
			System.out.printf("%s ",l);
		}
		System.out.printf("%s",i);

	}
}
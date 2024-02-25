package baekjoon;

import java.util.Scanner;

public class StringCount {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String S = sc.nextLine();
		
		String[] arr = S.split(" ");
		
		System.out.println(arr.length);
		// 공백 개수에 따라서 배열 길이 달라짐
		//  The Curious Case of Benjamin Button (문장 앞 뒤 공백 O)
		// 7
	}
}

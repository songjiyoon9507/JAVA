package buffered.reader;

import java.util.Scanner;

public class StringScanner {
	public static void main(String[] args) {
		// 백준 런타임 에러남
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		// T 길이 String 배열
		String[] arr = new String[T];
		
		// 3번 동안 문자열 받아오기
		for(int i = 0 ; i < T ; i++) {
			arr[i] = sc.nextLine();
			System.out.print(arr[i].charAt(0));
			System.out.println(arr[i].charAt(arr[i].length()-1));
		}
		sc.close();
	}
}

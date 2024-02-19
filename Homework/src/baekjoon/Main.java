package baekjoon;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 배열 길이 26 알파벳 개수
		int[] arr = new int[26];
		
		// 들어있을 경우 체크니까 안 들어있다는 가정하에 모두 -1로 배열 초기화
		for (int i = 0 ; i < arr.length ; i++) {
			arr[i] = -1;
		}
		
		String str = sc.next();
		// String 입력 받음
		// 입력 받은 String 에서 알파벳 찾아서 그 알파벳이  String 의 몇 번째
		// index 에 들어가있는지 검사
		// String charAt 몇 번째
		
		
		for(int i = 0 ; i < str.length() ; i++) {
			// 문장을 char 형으로 하나씩 나눠줌
			char ch = str.charAt(i);
			// b e a k j o o n int 형으로 바꾸면 번호가 나옴
			// a 를 빼줘야 a = 0 이 됨
			// i == 0 ch == b
			if(arr[ch - 'a'] == -1) { // 알파벳 순서대로 index 번호 부여
				// 알파벳이 들어가 있는 곳이 -1로 돼있으면
				arr[ch - 'a'] = i;
				// b 는 0번째 위치에 있음
			}
			
		}
		
		for(int result : arr) {
			System.out.print(result + " ");
		}
	}
}

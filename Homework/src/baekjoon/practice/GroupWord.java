package baekjoon.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GroupWord {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 받을 단어 개수
		int num = Integer.parseInt(br.readLine());
		
		// 그룹 단어가 아닐 경우 -1
		int count = num;
		

		for(int i = 0 ; i < num ; i++) {
			
			// num번 단어 입력 받을 곳
			String str = br.readLine();
			
			// 알파벳 배열 길이만큼의 배열을 만들어서 boolean으로 체크된 적이 있는 문자인지 확인
			boolean check[] = new boolean[26];
			
			// j와 j+1 을 비교해야해서 str.length()로 str 길이 초과됨.
			for(int j = 0 ; j < str.length() - 1 ; j++) {
				// 입력 받은 문자를 check해서 true로 바꿔줌 뒤에 걸리는 문자로 그룹 단어 확인
				check[str.charAt(j)-97] = true;
				
				// j와 j+1 문자가 같지 않고 j+1이 이미 체크된 알파벳(true)이면 그룹 단어가 아님 count - 1 
				if( (str.charAt(j) != str.charAt(j+1)) && (check[str.charAt(j+1)-97] == true) ) {
					count--;
					// for 문이 더 도는 걸 막음
					break;
				}
				
			}
		}
		System.out.println(count);
		br.close();
	}
}

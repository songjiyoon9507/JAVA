package programmers;

import java.util.Arrays;

public class ArraysTest {
	public static void main(String[] args) {
		
		int[] answer = new int[3];
		
		for(int i = 0 ; i < answer.length ; i++) {
			answer[i] = -1;
		}
		
		// Arrays.toString()
		// 배열 하나씩 꺼내 문자열 형태로 반환
		System.out.println(Arrays.toString(answer));
		
		// 선언과 동시에 배열 초기화
		int[] arr = {0,1,2,4,3};
		
		int max = arr[0];
		
		// 최대값 찾는 for 문
		for(int i = 0 ; i < arr.length ; i ++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		
		System.out.println(max);
	}
}

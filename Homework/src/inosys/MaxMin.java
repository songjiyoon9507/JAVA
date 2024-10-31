package inosys;

import java.util.Arrays;

public class MaxMin {

	public static void main(String[] args) {
		
		// 배열에서 최댓값, 최솟값 찾기
		
		// 새로운 배열
		int[] arr = new int[10];
		
		for(int i = 0 ; i < arr.length ; i++) {
			
			// 중복 검사 + 배열 만들기
			int random;
			boolean flag;
			do {
				
				random = (int)(Math.random() * 100 + 1); // 1 ~ 100 랜덤한 숫자 배열 초기화
				flag = true;
				
				for(int j = 0 ; j < i ; j++) {
					if(arr[j] == random) {
						flag = false;
						break;
					}
				}
				
			} while (!flag);
			
			arr[i] = random;
		}
		
		System.out.println(Arrays.toString(arr));
		
		int max = arr[0];
		int min = arr[0];
		
		for(int i = 0 ; i < arr.length ; i++) {
			// 최댓값 찾기
			if(max < arr[i]) {
				max = arr[i];
			}
			
			// 최솟값 찾기
			if(min > arr[i]) {
				min = arr[i];
			}
		}
		
		System.out.printf("최댓값 : %d, 최솟값 : %d", max, min);
	}
}

package programmers;

public class Queries2 {
	// 수열과 구간 쿼리 2
	// util 없이 풀기
	
	public int[] solution(int[] arr, int[][] queries) {
		
		int[] answer = new int[queries.length];
		
		int max = arr[0];
		
		for(int i = 0 ; i < arr.length ; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		
		// 초기값을 max 로 설정
		for(int i = 0 ; i < answer.length ; i++) {
			answer[i] = max;
		}
		
		for(int i = 0 ; i < queries.length ; i++) {
			// queries 는 열 고정
			int s = queries[i][0];
			int e = queries[i][1];
			int k = queries[i][2];
			
			// s 부터 e 까지의 arr[j] 의 값
			for(int j = s ; j <= e ; j++) {
				if(arr[j] > k) {
					if(answer[i] > arr[j]) {
						answer[i] = arr[j];						
					}
				}
			}
			if(answer[i] == max) {
				answer[i] = -1;
			}
		}
		return answer;
	}
}

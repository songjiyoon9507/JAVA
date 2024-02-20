package programmers;
// 임포트 해줘야함
import java.util.*;

public class Solution {
	
	 public int[] solution(int[] arr, int[][] queries) {
		 // 반환형이 정수 배열인 solution 메서드에 매개변수 넣어서 호출
		 // 정수 배열 return 해주면 호출한 곳으로 돌아감
	        int[] answer = new int[queries.length];
	        // 새로운 정수 배열 생성, 길이는 쿼리
	        Arrays.fill(answer, Integer.MAX_VALUE);
	        /*
	         * Arrays.fill()
	         * Arrays 클래스에서 제공하는 메서드
	         * - 배열의 모든 값을 같은 값으로 초기화하는 메서드
	         * 
	         * */
	        for (int i = 0 ; i < queries.length ; i++) {
	            int s = queries[i][0];
	            int e = queries[i][1];
	            int k = queries[i][2];
	            for (int j = s ; j <= e ; j++) {
	                if(arr[j] > k) {
	                    if(answer[i] > arr[j]) {
	                        answer[i] = arr[j];
	                    }
	                }
	            }
	            if(answer[i] == Integer.MAX_VALUE) {
	                answer[i] = -1;
	            }
	        }
	        return answer;
	    }

}

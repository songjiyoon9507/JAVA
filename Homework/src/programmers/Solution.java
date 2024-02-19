package programmers;

public class Solution {
	function solution(arr, queries) {
	    int[] answer = new int[queries.length];
	    Arrays.fill(answer, -1);
	    
	    for(int i = 0 ; i < queries.length ; i++) {
	        int s = queries[i][0];
	        int e = queries[i][1];
	        int k = queries[i][2];
	        
	        int min = Integer.MAX_VALUE;
	        // 큰 것보다 작아야함
	        
	        for(int j = s ; j <= e ; j++) {
	            // 2보다 크면서 가장 작은 거 찾아야함
	            if(arr[j] > k && arr[j] < min) {
	                min = arr[j];
	            }
	        }
	        
	        if(min != Integer.MAX_VALUE) {
	            answer[i] = min;
	        }
	        
	    }
	    
	    return answer;
	}
}

package engis;

import java.util.*;

public class Solution2 {

	public int[][] solution2(int[][] data) {
		// 1. 수학 점수가 높은 순서대로 정렬(내림차순)
		// 2. 수학 점수가 같다면 영어 점수가 높은 순서 (내림차순)
		// 3. 수학 및 영어 점수가 같다면 수험번호가 빠른 순서대로 정렬 (오름차순)
		
		// 앞에 문제와 같이 Comparator 사용
		Arrays.sort(data, (a, b) -> {
			// 들어온 data [수험 번호, 수학 점수, 영어 점수]
			// 배열 a, b 의 [1] index == 수학 점수
			// 수학 점수가 같지 않을 경우 내림차순 정렬
			if(a[1] != b[1]) {
				return b[1] - a[1];
			}
			
			// 수학 점수 같을 경우 영어 점수 내림차순
			// index 2 가 영어 점수니까
			if(a[2] != b[2]) {
				return b[2] - a[2];
			}
			
			// 수학 점수와 영어 점수가 같을 경우
			// 수험번호 오름차순
			return a[0] - b[0];
			
		});
		
		return data;
	}
}

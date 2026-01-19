package engis;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		// 문제 1
//		Map<String, String> map1 = new HashMap<>();
//		map1.put("no", "1");
//		map1.put("id", "Apple");
//		Map<String, String> map2 = new HashMap<>();
//		map2.put("no", "2");
//		map2.put("id", "Samsung");
//		List<Map<String, String>> companyList = new ArrayList<>();
//		companyList.add(map1);
//		companyList.add(map2);
//		Solution1 sol = new Solution1();
//		System.out.println(Arrays.toString(sol.solution1(companyList)));
		
		// 문제 2
		int[][] data = {
				// 수험번호, 수학점수, 영어점수
				{25050607, 90, 80},
				{25050610, 95, 90},
				{25050611, 95, 100}
		};
		
		Solution2 sol = new Solution2();
		int[][] result = sol.solution2(data);
		
		for(int[] row : result) {
			System.out.println(Arrays.toString(row));
		}
	}
}

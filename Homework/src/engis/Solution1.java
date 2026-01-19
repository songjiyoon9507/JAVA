package engis;

import java.util.*;

public class Solution1 {
	// 매개변수 companyList
	// String 배열 return 하는 solution1 함수
	public String[] solution1(List<Map<String, String>> companyList) {

		// comparator
		companyList.sort((a, b) -> {
			// map에서 key 값으로 id의 value 뽑아서 길이 담아주기
			int aId = a.get("id").length();
			int bId = b.get("id").length();
			// Comparator 에서 return x - y라고 작성했을 때
			// 값이 음수면 x가 앞으로
			// 0이면 순서 그대로, 양수면 y가 앞으로(오름차순)
			// return y - x 라고 작성하면
			// 값이 음수이면 y가 앞으로
			// 0이면 순서 그대로, 양수이면 x가 앞으로(내림차순)
			// 내림차순 정렬
			return bId - aId;
		});

		// no만 꺼내서 String 배열로 만들어서 반환
		String[] result = new String[companyList.size()];
		for (int i = 0; i < companyList.size(); i++) {
			result[i] = companyList.get(i).get("no");
		}

		return result;
	}
}

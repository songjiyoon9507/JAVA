package arraylist;

import java.util.ArrayList;

public class ArrayListTest {
	public static void main(String[] args) {
		
		ArrayList<Book> library = new ArrayList<Book>();
		// Book 클래스 사용자 정의 자료형
		
		library.add(new Book("태백산맥", "조정래")); // 매개변수 생성자로 Book 객체 생성해서 배열에 바로 넣음
		library.add(new Book("데미안", "헤르만 헤세"));
		library.add(new Book("어떻게 살 것인가", "유시민"));
		library.add(new Book("토지", "박경리"));
		library.add(new Book("어린왕자", "생텍쥐페리"));
		
		// .size() 는 배열 길이
		for(int i = 0 ; i < library.size() ; i++) {
			// .get(i) 배열의 index 위치에 있는 요소 값을 반환
			Book book = library.get(i);
			book.showBookInfo();
		}
		System.out.println();
		
		System.out.println("===========향상된 for문 사용===========");
		
		for(Book book : library) { // 배열 시작부터 끝까지 모두 출력
			book.showBookInfo();
		}
	}
}

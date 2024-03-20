package bookManagement.model.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import bookManagement.model.dto.Book;
import bookManagement.model.service.BookManagementService;
import bookManagement.model.service.BookManagementServiceImpl;

public class BookManagementView {
	// 입력 버퍼 참조변수 선언
	private BufferedReader br = null;
	
	// service와 연결
	private BookManagementService service = null;
	
	public BookManagementView() {
		try {
			service = new BookManagementServiceImpl();
			
			br = new BufferedReader(new InputStreamReader(System.in));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void startView() {
		
		int input = 0;
		
		do {
			
			try {
				// selectMenu 메서드에서 던진 Exception 여기서 잡아줌
				input = selectMenu();
				
				switch(input) {
				
				case 1 : veiwBookList(); break;
				case 2 : addBookList(); break;
				case 3 : searchBookList(); break;
				case 4 : updateBookMenu(); break;
				case 5 : deleteBook(); break;
				case 0 : System.out.println("@@@@@ 프로그램 종료 @@@@@"); break;
				default : System.out.println("### 메뉴에 작성된 번호만 입력해주세요. ###");
				}
				
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} while(input != 0);
	}
	
	public int selectMenu() throws Exception {
		System.out.println("\n========== [ 도서 관리 프로그램 ] ==========\n");
		
		System.out.println("1. 도서 목록 조회");
		System.out.println("2. 도서 등록");
		System.out.println("3. 도서 검색");
		System.out.println("4. 도서 수정");
		System.out.println("5. 도서 삭제");
		System.out.println("0. 프로그램 종료");
		
		System.out.print("메뉴 선택 >> ");
		int input = Integer.parseInt(br.readLine());
		return input;
	}
	
	/**
	 * 메인 메뉴 1번
	 * 도서 목록 조회
	 */
	public void veiwBookList() {
		
		int menuNum = 0;
		
		do {
			
			try {
				
				menuNum = selectViewList();
				
				switch(menuNum) {
				case 1 : bookListFullView(); break;
				case 2 : sortByTitle(); break;
				case 3 : sortByCategory(); break;
				case 4 : sortByLowPrice(); break;
				case 5 : sortByHighPrice(); break;
				case 0 : System.out.println("도서 목록 조회 종료"); break;
				default : System.out.println("### 메뉴에 작성된 번호만 입력해주세요. ###");
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} while(menuNum != 0);
	}

	public int selectViewList() throws Exception {
		System.out.println("\n========== [ 도서 목록 조회 ] ==========\n");
			
		System.out.println("1. 도서 목록 전체 조회");
		System.out.println("2. 제목순 정렬");
		System.out.println("3. 장르별 정렬");
		System.out.println("4. 낮은 가격 순으로 정리하기");
		System.out.println("5. 높은 가격 순으로 정리하기");
		System.out.println("0. 메인 메뉴로 돌아가기");
		
		System.out.print("메뉴 선택 >> ");
		int menuNum = Integer.parseInt(br.readLine());

		return menuNum;
		
	}
	
	/**
	 * 도서 전체 목록 도서 번호 순으로 정렬
	 */
	public void bookListFullView() {
		System.out.println("\n========== [ 도서 번호 순 정렬 ] =========\n");
		for (Book list : service.bookListFullView()) {
			System.out.println(list);
		}
	}
	
	/**
	 * 제목순으로 정렬
	 */
	private void sortByTitle() {
		System.out.println("\n========== [ 제목순 정렬 ] =========\n");
		for (Book list : service.sortByTitle()) {
			System.out.println(list);
		}
	}
	
	/**
	 * 카테고리 별 정렬
	 */
	private void sortByCategory() {
		System.out.println("\n========== [ 카테고리별 정렬 ] =========\n");
		for (Book list : service.sortByCategory()) {
			System.out.println(list);
		}
	}
	
	/**
	 * 낮은 가격 순 정렬
	 */
	public void sortByLowPrice() {
		System.out.println("\n========== [ 낮은 가격 순 정렬 ] =========\n");
		for (Book list : service.sortByLowPrice()) {
			System.out.println(list);
		}
	}
	
	/**
	 * 높은 가격 순 정렬
	 */
	public void sortByHighPrice() {
		System.out.println("\n========== [ 높은 가격 순 정렬 ] =========\n");
		for (Book list : service.sortByHighPrice()) {
			System.out.println(list);
		}
	}
	
	/**
	 * 메인 메뉴 3번
	 * 도서 검색
	 */
	public void searchBookList() {
		
		int menuNum = 0;
		
		do {
			
			try {
				
				menuNum = selectSearchList();
				
				switch(menuNum) {
				case 1 : searchTitle(); break;
				case 2 : searchCategory(); break;
				case 0 : System.out.println("도서 검색 종료"); break;
				default : System.out.println("### 메뉴에 작성된 번호만 입력해주세요. ###");
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} while(menuNum != 0);
	}
	
	/**
	 * 검색 메뉴
	 * @return 
	 * @throws Exception
	 */
	public int selectSearchList() throws Exception {
		System.out.println("\n========== [ 도서 검색 ] ==========\n");
			
		System.out.println("1. 제목으로 검색하기");
		System.out.println("2. 장르별로 검색하기");
		System.out.println("0. 메인 메뉴로 돌아가기");
		
		System.out.print("메뉴 선택 >> ");
		int menuNum = Integer.parseInt(br.readLine());

		return menuNum;
		
	}
	
	/**
	 * 제목으로 검색하기
	 */
	public void searchTitle() throws Exception {
		System.out.println("\n========== [ 제목 검색 ] =========\n");
		System.out.print("제목 입력 : ");
		String title = br.readLine();
		
		boolean flag = false;
		int index = 0;
		
		for(int i = 0; i < service.bookListFullView().size() ; i ++) {
			if(service.bookListFullView().get(i).getTitle().equals(title)) {
				index = i;
				flag = true;
				break;
			}
		}
		
		if(flag) {
			System.out.println("일치하는 항목이 존재합니다.");
			System.out.println(service.bookListFullView().get(index).toString());
		} else {
			System.out.println("일치하는 항목이 존재하지 않습니다.");
		}
	}
	
	/**
	 * 장르별로 검색하기
	 */
	public void searchCategory() throws Exception {
		System.out.println("\n========== [ 장르별 검색 ] ==========\n");
		
		System.out.print("검색할 장르 입력 : ");
		String str = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		
		for(Book list : service.bookListFullView()) {
			if(list.getCategory().equals(str)) {
				sb.append(list.toString());
				sb.append("\n");
			}
		}
		
		if(sb.isEmpty()) {
			System.out.println("일치하는 장르의 책이 존재하지 않습니다.");
		} else {
			System.out.println(sb.toString());
		}
	}
	
	/**
	 * 도서 등록
	 * @throws Exception
	 */
	public void addBookList() throws Exception {
		System.out.println("\n========== [ 신규 도서 등록 ] ==========\n");
		
		while (true) {
			
			System.out.print("제목 : ");
			String title = br.readLine();
			
			System.out.print("저자 : ");
			String author = br.readLine();
			
			System.out.print("가격 : ");
			int price = Integer.parseInt(br.readLine());
			
			System.out.print("출판사 : ");
			String publisher = br.readLine();
			
			System.out.print("장르 : ");
			String category = br.readLine();
				
			boolean temp = service.addBookList(title, author, price, publisher, category);
				
			if (temp) {
				System.out.println("[ 신규 도서 등록 완료 ]");
			} else {
				System.out.println("[ 신규 도서 등록 실패 ]");
			}
			
			System.out.println("등록을 종료하려면 'exit' 입력해주세요.");
			System.out.println("등록을 계속하시려면 아무 키나 눌러주세요.");
			String exit = br.readLine();
			
			if(exit.equals("exit")) {
				System.out.println("##### 도서 등록 종료 #####");
				return;
			}
		}
		
	}
	
	/**
	 * 도서 수정
	 */
	public void updateBookMenu() throws Exception {
		System.out.println("\n========== [ 도서 목록 내용 수정 ] ==========\n");

		System.out.print("수정할 도서의 도서 번호 입력 : ");
		int bookNum = Integer.parseInt(br.readLine());
			
		// indexMatch 메서드에서 도서번호 존재하면 true 존재하지 않으면 false 반환
		int index = service.indexMatch(bookNum);
			
		if(index == -1) { // 매치하는 번호가 없을 때
			System.out.println("일치하는 도서 번호가 없습니다.");
		} else { // 매칭되는 번호가 있을 때 index
			updateBook(index);
		}
		
	}
	
	public int updateView() throws Exception {
		
		System.out.println("\n===== [ 수정할 메뉴 선택 ] =====\n");
		
		System.out.println("1. 제목 수정");
		System.out.println("2. 저자 수정");
		System.out.println("3. 가격 수정");
		System.out.println("4. 출판사 수정");
		System.out.println("5. 장르 수정");
		System.out.println("0. 수정 종료");
		System.out.print("\n메뉴 선택 >> ");
		int menuNum = Integer.parseInt(br.readLine());
		
		return menuNum;
		
	}
	
	public void updateBook(int index) {
		
		int menuNum = 0;
		
		do {
			
			try {
				
				menuNum = updateView();
				
				switch(menuNum) {
				case 1 : updateTitle(index); break;
				case 2 : updateAuthor(index); break;
				case 3 : updatePrice(index); break;
				case 4 : updatePublisher(index); break;
				case 5 : updateCategory(index); break;
				case 0 : System.out.println("### 도서 목록 수정 종료 ###"); break;
				default : System.out.println("### 메뉴에 작성된 번호만 입력해주세요. ###");
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} while(menuNum != 0);
		
	}
	
	public void updateTitle(int index) throws Exception {
		
		System.out.print("수정할 제목 입력 : ");
		String title = br.readLine();
		
		boolean update = service.updateTitle(index, title);
		
		if(update) {
			System.out.println("\n@@@@@ 제목 수정 완료 @@@@@");
		} else {
			System.out.println("\n##### 제목 수정 실패 #####");
		}
		
	}
	
	public void updateAuthor(int index) throws Exception {
		
		System.out.print("수정할 저자 입력 : ");
		String author = br.readLine();
		
		boolean update = service.updateAuthor(index, author);
		
		if(update) {
			System.out.println("\n@@@@@ 저자 수정 완료 @@@@@");
		} else {
			System.out.println("\n##### 저자 수정 실패 #####");
		}
		
	}
	
	public void updatePrice(int index) throws Exception {
		
		System.out.print("수정할 가격 입력 : ");
		int price = Integer.parseInt(br.readLine());
		
		boolean update = service.updatePrice(index, price);
		
		if(update) {
			System.out.println("\n@@@@@ 가격 수정 완료 @@@@@");
		} else {
			System.out.println("\n##### 가격 수정 실패 #####");
		}
		
	}
	
	public void updatePublisher(int index) throws Exception {
		
		System.out.print("수정할 출판사 입력 : ");
		String publisher = br.readLine();
		
		boolean update = service.updatePublisher(index, publisher);
		
		if(update) {
			System.out.println("\n@@@@@ 출판사 수정 완료 @@@@@");
		} else {
			System.out.println("\n##### 출판사 수정 실패 #####");
		}
		
	}
	
	public void updateCategory(int index) throws Exception {
		
		System.out.print("수정할 장르 입력 : ");
		String category = br.readLine();
		
		boolean update = service.updateCategory(index, category);
		
		if(update) {
			System.out.println("\n@@@@@ 장르 수정 완료 @@@@@");
		} else {
			System.out.println("\n##### 장르 수정 실패 #####");
		}
		
	}
	
	/**
	 * 도서 삭제
	 */
	public void deleteBook() throws Exception {
		System.out.println("삭제할 도서 번호 입력 : ");
		int bookNum = Integer.parseInt(br.readLine());
		
		boolean check = service.checkBookNum(bookNum);
		
		if(!check) {
			System.out.println("일치하는 도서 번호가 없습니다.");
		} else {
			// 삭제 되면 book 객체가 null 이 아님
			System.out.print("정말 삭제하시겠습니까?(Y/N) : ");
			char answer = br.readLine().toUpperCase().charAt(0);
			
			if(answer == 'N') {
				System.out.println("\n### 삭제 취소 ###\n");
			} else if(answer != 'Y') {
				System.out.println("\n### 잘못 입력하셨습니다. ###\n");
			} else {
				Book book = service.deleteBook(bookNum);
				System.out.printf("\n%s의 도서 정보가 삭제되었습니다.\n", book.getTitle());	
			}
		}
	}
	
}

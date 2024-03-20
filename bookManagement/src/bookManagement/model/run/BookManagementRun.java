package bookManagement.model.run;

import bookManagement.model.view.BookManagementView;

public class BookManagementRun {
	public static void main(String[] args) {
		System.out.println("========== [ 프로그램 실행 ] ==========");
	
		BookManagementView view = new BookManagementView();
		view.startView();
	}
}

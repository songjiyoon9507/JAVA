package customerManagement.run;

import customerManagement.view.CustomerListView;

public class CustomerListRun {
	public static void main(String[] args) {
		
		System.out.println("========== 프로그램 실행 ==========");
	
		CustomerListView view = new CustomerListView();
		view.startView();
	}
}

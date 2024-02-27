package customerManagement.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import customerManagement.model.dto.Customer;
import customerManagement.model.service.CustomerListService;
import customerManagement.model.service.CustomerListServiceImpl;

public class CustomerListView {
	
	// 필드
	private BufferedReader br = null;
	private CustomerListService service = null;
	
	public CustomerListView() {
		try {
			service = new CustomerListServiceImpl();
			
			br = new BufferedReader(new InputStreamReader(System.in));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void startView() {
		
		int input = 0;
		
		do {
			
			try {
				input = selectMenu();
				
				switch(input) {
				
				case 1 : customerList(); break;
				case 2 : addCustomerList(); break;
				case 3 : login(); break;
				case 4 : updatePw(); break;
				case 5 : deleteCustomerList(); break;
				
				case 0 : System.out.println("@@ 프로그램 종료 @@"); break;
				default : System.out.println("### 메뉴에 작성된 번호만 입력해주세요. ###");
				}
				
				
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		} while(input != 0);
	}
	
	public int selectMenu() throws Exception {
		System.out.println("\n========== 고객 관리 프로그램 ==========\n");
	
		System.out.println("1. 고객 전체 조회");
		System.out.println("2. 신규 고객 회원가입");
		System.out.println("3. 로그인");
		System.out.println("4. 비밀번호 변경");
		System.out.println("5. 고객 정보 삭제");
		System.out.println("0. 프로그램 종료");
		
		System.out.print("메뉴 선택 >> ");
		
		int input = Integer.parseInt(br.readLine());
		
		return input;
	}
	
	public void customerList() {
		System.out.println("\n========== [고객 정보 전체 조회] ==========\n");
	
		for(Customer list : service.customerListFullView()) {
			System.out.println(list);
		}
	}
	
	public void addCustomerList() throws Exception {
		System.out.println("\n========== [신규 고객 회원가입] ==========\n");
		
		int num = 0;
		
		String userId = "";
		while(num == 0) {
			System.out.print("신규 등록 아이디 : ");
			userId = br.readLine();
			
			num = service.checkId(userId);
			
			if(num == 0) {
				System.out.println("\n이미 존재하는 아이디입니다. 다시 입력해주세요.");
				System.out.println("처음 메뉴로 돌아가시려면 1을 입력해주세요.\n");
			}
			
			if(num == 1) {
				System.out.println("처음 화면을 돌아갑니다.");
				return;
			}
		}
		
		boolean flag = true;
		String userPw = "";
		while(flag) {
			
			System.out.print("비밀 번호 입력 : ");
			userPw = br.readLine();
			
			System.out.print("비밀 번호 확인 : ");
			String userPw2 = br.readLine();
			
			flag = service.checkPw(userPw, userPw2);
		}
		
		System.out.print("고객 성함 입력 : ");
		String userName = br.readLine();
		
		System.out.print("고객 나이 입력 : ");
		int userAge = Integer.parseInt(br.readLine());
		
		System.out.print("고객 주소 입력 : ");
		String address = br.readLine();
		
		System.out.print("휴대폰 번호 입력 : ");
		String phoneNumber = br.readLine();
		
		// 성공 : 추가된  index, 실패 : -1
		int index = service.addCustomerList(userId, userPw, userName, userAge, address, phoneNumber);
		
		if(index == -1) {
			System.out.println("### 회원가입 실패 ###");
			return;
		}
		System.out.println("\n" + service.customerListFullView().get(index).getMemberName() + "님 회원가입을 축하합니다.");
	}

	public void login() throws Exception {
		System.out.println("\n=============== [로그인] ===============\n");
		
		int num = 1;
		
		String memberId = "";
		while(num != 0) {
			System.out.print("아이디 입력 : ");
			memberId = br.readLine();
			
			num = service.checkId(memberId);
			
			if(num == 2) {
				System.out.println("@@@@@ 로그인 실패 @@@@@");
				System.out.println("등록되지 않은 아이디입니다.");
				System.out.println("처음 화면으로 돌아가시려면 1을 입력해주세요.");
			}
			
			if(num == 1) {
				System.out.println("\n처음 화면을 돌아갑니다.");
				return;
			}

		}
		
		System.out.print("비밀번호 입력 : ");
		String memberPw = br.readLine();
		
		int index = service.checkPw2(memberId, memberPw);
		
		if(index == -1) {
			System.out.println("로그인에 실패하였습니다. 비밀번호 불일치");
		}
		
		if (index != -1) {
			boolean login = service.login(index);
			
			if(login) {
				System.out.println("\n로그인이 완료되었습니다.");
			}
		}
		
//		boolean login = service.login(index);
//		
//		if(login) {
//			System.out.println("\n로그인이 완료되었습니다.");
//			
//		} else {
//			System.out.println("\n로그아웃 되었습니다.");
//		}
		
	}
	
//	public void updateList() throws Exception {
//		System.out.println("\n========== [고객 정보 수정] ==========\n");
//		int index = 0;
//		
//		for(Customer list : service.customerListFullView()) {
//			System.out.print("[" + index + "] ");
//			System.out.println(list);
//			index++;
//		}
//		
//		System.out.print("수정할 정보의 인덱스 번호 입력 : ");
//		int num = Integer.parseInt(br.readLine());
//		
//		String id = service.customerListFullView().get(num).getMemberId();
//		
//		int checkid = service.checkId(id);
//		
//		boolean flag = true;
//		
//		while(flag) {
//			
//			if (checkid == 0) { // 일치하는 아이디 있을 때
//				System.out.print("해당 아이디의 비밀번호를 입력해주세요 : ");
//				String pw = br.readLine();
//				int checkPw = service.checkPw2(id, pw); // checkPw 에 해당 index 들어가있음
//				
//				if(checkPw == -1) {
//					System.out.println("비밀번호가 일치하지 않습니다.");
//					System.out.println("다시 입력해주세요.");
//				} else {
//					System.out.println("로그인 되었습니다.");
//					flag = false;
//				}
//			}
//		}
//		
//		int menuNum = -1;
//		while (menuNum != 0) {
//			
//			System.out.println("\n========== [본인 정보 수정] ==========\n");
//			
////			System.out.println("1. 고객 비밀번호 수정");
////			System.out.println("2. 고객 이름 수정");
////			System.out.println("3. 고객 나이 수정");
////			System.out.println("4. 고객 주소 수정");
////			System.out.println("5. 고객 번호 수정");
////			System.out.println("0. 수정 종료");
//			
//			
//			switch (menuNum) {
////			case 1 : updatePw(); break;
////			case 2 : updateName(); break;
////			case 3 : updateAge(); break;
////			case 4 : updateAddress(); break;
////			case 5 : updateNumber(); break;
//			case 0 : System.out.println("수정 종료");
//			}
//		
//		
//		}
//		
//		
////		System.out.print("수정할 정보의 아이디 입력 : ");
////		String memberId = br.readLine();
////		
////		int num = service.checkId(memberId);
////		
////		if(num == 0) {
////			System.out.print("비밀 번호 입력 : ");
////			String memberPw = br.readLine();
////			int index = service.checkPw2(memberId, memberPw);
////
////		}
//	}
	
	/**
	 * 비밀번호 변경
	 */
	public void updatePw() throws Exception {
		
		System.out.println("\n========== [비밀번호 변경] ==========\n");
		
		int index = 0;
		
		for(Customer list : service.customerListFullView()) {
			System.out.print("[" + index + "] ");
			System.out.println(list);
			index++;
		}
		
		System.out.print("비밀 번호 수정할 고객 인덱스 번호 입력 : ");
		int num = Integer.parseInt(br.readLine());
		
		String id = service.customerListFullView().get(num).getMemberId();
		
		int checkid = service.checkId(id);
		
		boolean flag = true;
		
		String updatePw = "";
		
		
		while(flag) {
			
			if (checkid == 0) { // 일치하는 아이디 있을 때
				System.out.print("해당 아이디의 비밀번호를 입력해주세요 : ");
				String pw = br.readLine();
				int checkPw = service.checkPw2(id, pw); // checkPw 에 해당 index 들어가있음
				
				if(checkPw == -1) {
					System.out.println("비밀번호가 일치하지 않습니다.");
					System.out.println("다시 입력해주세요.");
				} else {
					// 일치했으면 수정할 비밀번호 받기
					System.out.print("수정할 비밀번호를 입력해주세요. : ");
					updatePw = br.readLine();
					flag = false;
				}
			}
		}
		
		boolean savePw = service.updatePw(checkid, updatePw);
		
		if(savePw) {
			System.out.println("비밀번호 변경 완료");
		}
		
	}
	
	public void deleteCustomerList() throws Exception {
		System.out.println("\n========== [고객 정보 삭제] ==========\n");
		
		int index = 0;
		
		for(Customer list : service.customerListFullView()) {
			System.out.print("[" + index + "] ");
			System.out.println(list);
			index++;
		}
		
		System.out.print("삭제할 고객 인덱스 번호 입력 : ");
		int num = Integer.parseInt(br.readLine());
		
		if (num >= 0 && service.customerListFullView().size() > num) {
			
			System.out.print("정말 삭제하시겠습니까? (Y/N) : ");
			char answer = br.readLine().toUpperCase().charAt(0);
			
			if(answer == 'Y') {
				String name = service.deleteCustomerList(num);
				System.out.println(name + "님의 정보가 삭제되었습니다.");
			} else {
				System.out.println("삭제가 취소되었습니다.");
			}
		}
		
	}
	
}

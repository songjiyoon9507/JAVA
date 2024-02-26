package customerManagement.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.plaf.synth.SynthOptionPaneUI;

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
				case 4 : updateList(); break;
				
				
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
		System.out.println("4. 고객 정보 수정");
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
		
		boolean login = service.login(index);
		
		if(login) {
			System.out.println("\n로그인이 완료되었습니다.");
			
		} else {
			System.out.println("\n로그아웃 되었습니다.");
		}
		
	}
	
	public void updateList() throws Exception {
		System.out.println("\n========== [고객 정보 수정] ==========\n");
		
		System.out.print("수정할 정보의 아이디 입력 : ");
		String memberId = br.readLine();
		
		int num = service.checkId(memberId);
		
		if(num == 0) {
			System.out.print("비밀 번호 입력 : ");
			String memberPw = br.readLine();
			int index = service.checkPw2(memberId, memberPw);

		}
	}
	
}

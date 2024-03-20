package busReservation.view;

import java.util.Scanner;

import busReservation.common.Session;
import busReservation.model.service.BusService;

public class BusView {
	
	private Scanner sc = new Scanner(System.in);
	
	private BusService service = new BusService();
	
	// 메인 메뉴
	public void mainMenu() {
		
		int input = 0;
		
		do {
			
			try {
				
				if(Session.loginMember == null) {
					
					System.out.println("\n======= [ 버스 예약 프로그램 ] =======\n");
					
					System.out.println("1. 회원가입");
					System.out.println("2. 로그인\n");
					System.out.println("0. 프로그램 종료");
					
					System.out.print("\n메뉴 선택 >> ");
					input = sc.nextInt();
					sc.nextLine();
					
					switch(input) {
					case 1 : signUp(); break;
					case 2 : login(); break;
					case 0 : System.out.println("\n### [ 프로그램 종료 ] ###\n");
					default : System.out.println("\n!!! 메뉴에 있는 번호만 입력 !!!\n");
					}
					
				} else {
					
					System.out.println("\n======= [ 버스 예약 메뉴 ] =======\n");
					System.out.print("1. 버스 조회");
				}
				
				
				
			} catch(Exception e) {
				System.out.println("\n### 입력 형식이 올바르지 않습니다. ###\n");
				sc.nextLine();
				input = -1;
			}
			
		} while(input != 0);
		
	}
	
	public void signUp() {
		System.out.println("\n===== [ 회원 가입 ] =====\n");
		
		
	}
	
	public void login() {
		System.out.println("\n======= [ 로그인 ] =======\n");
	}
	
}

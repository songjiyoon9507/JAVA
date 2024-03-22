package busReservation.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import busReservation.common.Session;
import busReservation.model.dto.Bus;
import busReservation.model.dto.ReservePerson;
import busReservation.model.service.BusService;

public class BusView {
	
	private Scanner sc = new Scanner(System.in);
	
	private BusService service = new BusService();
	
	// 메인 메뉴
	public void mainMenu() {
		
		int input = 0;
		
		do {
			
			try {
				
				if(Session.loginPerson == null) {
					
					System.out.println("\n======= [ 버스 예약 프로그램 ] =======\n");
					
					System.out.println("1. 회원가입");
					System.out.println("2. 로그인");
					System.out.println("3. 로그아웃\n");
					System.out.println("0. 프로그램 종료");
					
					System.out.print("\n메뉴 선택 >> ");
					input = sc.nextInt();
					sc.nextLine();
					
					switch(input) {
					case 1 : signUp(); break;
					case 2 : login(); break;
					case 3 : System.out.println("\n=== [ 로그아웃 되었습니다. ] ===\n");
							 Session.loginPerson = null;
							 break;
					case 0 : System.out.println("\n### [ 프로그램 종료 ] ###\n");
					default : System.out.println("\n!!! 메뉴에 있는 번호만 입력 !!!\n");
					}
					
				} else {
					System.out.println("\n======= [ 버스 예약 메뉴 ] =======\n");
					System.out.println("1. 버스 조회");
					System.out.println("2. 버스 예약");
					System.out.println("0. 프로그램 종료");
					
					System.out.print("\n메뉴 선택 >> ");
					input = sc.nextInt();
					sc.nextLine();
					
					switch(input) {
					case 1 : searchAllBus(); break;
					case 2 : reserveBus(); break;
					
					case 0 : System.out.println("\n=== [ 프로그램 종료 ] ===\n"); break;
					default : System.out.println("\n### 메뉴 번호만 입력해주세요. ###\n");
					}
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
		
		String phone = null;
		String name = null;
		
		try {
			
			while (true) {
				System.out.print("전화번호 입력('-', 공백 제외) : ");
				phone = sc.nextLine();
				
				// 전화번호 중복 확인 서비스 호출
				int result = service.phoneNumCheck(phone);
				
				if(result == 0) { // 전화번호 중복 아닐 때
					System.out.println("\n=== 회원가입이 가능한 번호입니다. ===\n");
					break;
				} else {
					System.out.println("\n=== 이미 등록된 전화번호입니다. ===\n");
				}
			}
			
			// 이름 입력
			System.out.print("이름 : ");
			name = sc.nextLine();
			
			ReservePerson person = new ReservePerson();
			
			person.setPhoneNum(phone);
			person.setName(name);
			
			// 회원 가입 서비스 호출
			// INSERT 구문
			int result = service.signUp(person);
			
			if(result > 0) {
				System.out.println("\n=== 회원 가입 성공 ===\n");
				// 버스 예약 메서드 호출
			} else {
				System.out.println("\n### 회원 가입 실패 ###\n");
			}
			
		} catch(Exception e) {
			System.out.println("\n### [ 회원 가입 중 예외 발생] ###\n");
		}
		
	}
	
	/**
	 * 로그인
	 */
	public void login() {
		System.out.println("\n======= [ 로그인 ] =======\n");
		
		System.out.print("전화번호 입력('-', 공백 제외) : ");
		String phone = sc.nextLine();
		
		try {
			Session.loginPerson = service.login(phone);
			
			if(Session.loginPerson == null) {
				System.out.println("\n### 일치하는 전화번호가 존재하지 않습니다. ###\n");
			} else {
				System.out.printf("\n=== %s님 버스 예약 시스템에 로그인 되었습니다. ===\n",
						Session.loginPerson.getName());
			}
			
		} catch (Exception e) {
			System.out.println("\n### [ 로그인 중 예외 발생 ] ###\n");
			e.printStackTrace();
		}
	}
	
	/**
	 * 전체 버스 조회
	 */
	public void searchAllBus() {
		System.out.println("\n===== [ 전체 버스 조회 ] =====\n");
		
		try {
			List<Bus> busList = service.searchAllBus();

			Map<Integer, Integer> leftSeatList = service.leftSeat();
			
			if(busList.isEmpty()) {
				System.out.println("\n##### 조회 결과가 없습니다. #####\n");
				return;
			}

			for(int i = 0 ; i < busList.size() ; i ++) {
				System.out.printf("[버스번호] : %d | [출발지] : %s | [도착지] : %s | [출발시간] : %s | [도착시간] : %s | [남은 좌석] : %d\n",
						busList.get(i).getBusNo(),
						busList.get(i).getDepartures(),
						busList.get(i).getArrivals(),
						busList.get(i).getDepartureTime(),
						busList.get(i).getArrivalTime(),
						leftSeatList.get(busList.get(i).getBusNo())
						);
			}
			
		} catch (Exception e) {
			System.out.println("\n### [ 버스 조회 중 예외 발생 ] ###\n");
			e.printStackTrace();
		}
	}
	
	/**
	 * 버스 예약
	 */
	public void reserveBus() {
		
		int busNo = 0;
		int seatNo = 0;
		
		try {
			
			System.out.print("예약할 버스 번호 입력 : ");
			busNo = sc.nextInt();
			sc.nextLine();
			
			List<Bus> busList = service.searchAllBus();
			
			boolean flag = false;
			
			for(int i = 0 ; i < busList.size() ; i++) {
				if(busList.get(i).getBusNo() == busNo) {
					flag = true;
				}
				
			}
			
			if(flag) {
				
				// 남은 좌석 번호 출력
				List<Integer> remain = service.remainSeat(busNo);
				
				System.out.println("\n===== [ 예약 가능 좌석 ] =====\n");
				
				for(Integer list : remain) {
					System.out.println(list);
				}
				
				System.out.print("예약할 좌석 번호 : ");
				seatNo = sc.nextInt();
				sc.nextLine();
				
				// 좌석 번호 입력 받아서 로그인 DB에 예약자 정보 저장
				// insert 반환형이 int
				// + 버스 좌석 예약 현황 Y 변경
				int result = service.reserveBus(busNo, seatNo);
				
				if(result > 0) {
					System.out.println("\n[[[ 버스 예약 완료 ]]]\n");
				} else {
					System.out.println("\n### 버스 예약 실패 ###\n");
				}
				
			} else {
				System.out.println("\n### 일치하는 버스 번호가 존재하지 않습니다. ###\n");
				System.out.println("##### 버스 조회 후 다시 입력해주세요. #####");
			}
			
		} catch(Exception e) {
			System.out.println("\n### [ 버스 예약 중 예외 발생 ] ###\n");
			e.printStackTrace();
		}
	}
	
}

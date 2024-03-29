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
					System.out.println("1. 버스 조회");
					System.out.println("2. 버스 예약 및 변경");
					System.out.println("3. 버스 예약 취소");
					System.out.println("8. 회원 탈퇴");
					System.out.println("9. 로그아웃");
					System.out.println("0. 프로그램 종료");
					
					System.out.print("\n메뉴 선택 >> ");
					input = sc.nextInt();
					sc.nextLine();
					
					switch(input) {
					case 1 : searchAllBus(); break;
					case 2 : reserveBus(); break;
					case 3 : removeBusReserve(); break;
					case 8 : deleteInfo(); break;
					case 9 : System.out.println("\n=== [ 로그아웃 되었습니다. ] ===\n");
						Session.loginPerson = null;
						break;
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
		boolean start = true;
		
		try {
			// 로그인한 사람 예약 정보 있는지 먼저 보여주기
			ReservePerson person = service.reserveInfo(Session.loginPerson.getPhoneNum());
			
			// 예약 정보가 있을 때
			if(person.getDepartures() != null) {
				System.out.printf("\n[ %s ] 님 %d번 버스 출발시간 %s %s 도착하는 버스 예약 정보 존재 좌석번호 : %d\n",
						Session.loginPerson.getName(), person.getBusNo(), person.getDepartureTime(),
						person.getArrivals(), person.getReserveSeatNo());
				
				System.out.print("\n예약 정보를 바꾸시겠습니까?(Y/N) : ");
				char answer = sc.nextLine().toUpperCase().charAt(0);
				
				if(answer == 'N') {
					System.out.println("\n===== [ 버스 예약 종료 ] =====\n");
					start = false;
				} else {
					// 예약 취소 메서드 호출
					// 예약 취소는 로그인 멤버 phone 넘겨서 이름, 번호 남겨두고 다 null 로
					
					int result = service.deleteReserve(Session.loginPerson.getPhoneNum(), person.getBusNo(), person.getReserveSeatNo());
					
					if(result <= 0) {
						System.out.println("예약 정보 오류 발생");
						start = false;
					}
				}
			}
			
			if(start) {
				
				System.out.print("\n예약할 버스 번호 입력 : ");
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
			}

		} catch(Exception e) {
			System.out.println("\n### [ 버스 예약 중 예외 발생 ] ###\n");
			e.printStackTrace();
		}
	}
	
	/**
	 * 예약 취소
	 */
	public void removeBusReserve() {
		try {
			System.out.println("\n===== [ 예약 취소 ] =====\n");
			// 로그인한 사람 예약 정보 담아둔 person 객체
			ReservePerson person = service.reserveInfo(Session.loginPerson.getPhoneNum());
			
			if(person.getDepartures() != null) {
				System.out.printf("\n[ %s ] 님 %d번 버스 출발시간 %s %s 도착하는 버스 좌석번호 : %d\n",
						Session.loginPerson.getName(), person.getBusNo(), person.getDepartureTime(),
						person.getArrivals(), person.getReserveSeatNo());
				
				System.out.print("정말 예약을 취소하시겠습니까?(Y/N) : ");
				char answer = sc.nextLine().toUpperCase().charAt(0);
				
				if(answer == 'Y') {
					int result = service.deleteReserve(Session.loginPerson.getPhoneNum(),
							person.getBusNo(), person.getReserveSeatNo());
					if(result > 0) {
						System.out.println("\n===== 예약이 취소되었습니다. =====\n");
					} else {
						System.out.println("\n##### 예약 취소 실패 #####\n");
					}
				} else {
					System.out.println("\n### [ 예약 취소 프로그램 종료 ] ###\n");
				}
				
			} else {
				System.out.println("\n예약 정보가 존재하지 않습니다.");
			}
		} catch (Exception e) {
			System.out.println("\n### 예약 취소 중 오류 발생 ###\n");
			e.printStackTrace();
		}
	}
	
	/**
	 * 회원 탈퇴
	 */
	public void deleteInfo() {
		try {
			System.out.println("\n===== [ 회원 탈퇴 메뉴 ] =====\n");
			System.out.print("정말 탈퇴하시겠습니까?(Y/N) : ");
			char ch = sc.nextLine().toUpperCase().charAt(0);
			
			if(ch == 'Y') {
				System.out.print("전화번호 입력 : ");
				String phone = sc.nextLine();
				
				// 전화번호 일치할 때 삭제
				if(Session.loginPerson.getPhoneNum().equals(phone)) {
					ReservePerson person = service.reserveInfo(Session.loginPerson.getPhoneNum());
					
					int result = service.deleteReserve(Session.loginPerson.getPhoneNum(),
							person.getBusNo(), person.getReserveSeatNo());
					// 예약 정보 삭제 메서드 성공했을 때
					if(result > 0) {
						// 전화번호 일치하는 행 아예 삭제
						int remove = service.removePerson(Session.loginPerson.getPhoneNum());
						
						if(remove > 0) {
							// 행 삭제 성공시
							System.out.println("\n===== [ 회원 탈퇴 성공 ] =====\n");
							Session.loginPerson = null;
						} else {
							System.out.println("\n##### [ 회원 탈퇴 실패 ] #####\n");
						}
					} else {
						// 예약 정보 삭제 실패시
						System.out.println("\n### 회원 탈퇴 중 예약 정보 삭제 오류 ###\n");
					}
				} else {
					System.out.println("\n##### 전화번호 불일치 #####\n");
				}
			} else {
				System.out.println("\n===== [ 회원 탈퇴 종료 ] =====\n");
			}
			
		} catch (Exception e) {
			System.out.println("\n### [ 회원 탈퇴 중 오류 발생 ] ###\n");
			e.printStackTrace();
		}
	}
}

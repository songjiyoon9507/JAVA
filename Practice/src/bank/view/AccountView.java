package bank.view;

import java.util.Scanner;

import bank.dao.AccountManager;

public class AccountView {
	private Scanner sc = new Scanner(System.in);
	
	public int displayMenu() {
		System.out.println("========== 원하시는 메뉴를 선택해주세요. ==========\n");
		System.out.println("1. 계좌개설");
		System.out.println("2. 입금");
		
		System.out.println("0. 프로그램 종료");
		
		System.out.print("메뉴 선택 >> ");
		int menuNum = sc.nextInt();
		sc.nextLine();
		
		return menuNum;
		
	}
	
	public void selectMenu() {
		
		int menuNum = 0;
		AccountManager am = new AccountManager();
		
		do {
			// displayMenu() 를 do 밖에서 부르면 숫자 초기화가 안 돼서
			// 처음 누른 번호 그대로 그 메서드만 계속 호출됨
			menuNum = displayMenu();
			
			switch(menuNum) {
			case 1 : am.makeAccount(); break;
			case 2 : am.deposit(); break;
			
			
			}
			
		} while(menuNum != 0);
		
	}
}

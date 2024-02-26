package bank.dao;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import bank.dto.Account;

// 데이터가 저장된 파일/DB/외부 장치에 접근하는 역할
public class AccountManager {
	// 중복 계좌 안됨
	private Set<Account> accountList;
	private Scanner sc;
	
	public AccountManager() {
		accountList = new HashSet<Account>();
		sc = new Scanner(System.in);
	}
	
	public void makeAccount() {
		
		System.out.println("\n========== 계좌개설 ==========\n");
		
		System.out.print("계좌번호 : ");
		String id = sc.nextLine();
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("입금액 : ");
		long balance = sc.nextLong();
		sc.nextLine();
		
		for(Account account : accountList) {
			if(account.getId().equals(id)) { // 같은 계좌번호가 존재할 때
				System.out.println("이미 존재하는 계좌번호입니다. 다시 작성해주세요.");
				return;
			}
		}
		
		accountList.add(new Account(id, name, balance));
		System.out.println("계좌 개설이 완료되었습니다.");
		
	}
	
	public void deposit() { // 입금
		System.out.println("\n=============== 입금 ===============\n");
		
		System.out.print("입급하실 계좌번호를 입력해주세요 : ");
		String id = sc.nextLine();
		
		System.out.print("입금하실 금액을 입력해주세요 : ");
		long balance = sc.nextLong();
		sc.nextLine();
		
		for(Account list : accountList) {
			if(list.getId().equals(id)) {
				long money = list.getBalance();
				
				balance += money;
				
				list.setBalance(balance);
				
				System.out.printf("%s님 계좌에 %d원이 입금되었습니다.\n", list.getName(), money);
				return;
			}
		}
		
		System.out.println("존재하지 않는 계좌번호입니다. 다시 확인해주세요.");
		
	}
}

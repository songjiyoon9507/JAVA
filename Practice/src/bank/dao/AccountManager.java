package bank.dao;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import bank.dto.Account;

public class AccountManager {
	// 중복 계좌 안됨
	private Set<Account> accountList;
	private Scanner sc;
	
	public AccountManager() {
		accountList = new HashSet<Account>();
		sc = new Scanner(System.in);
	}
	
	public void makeAccount() {
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
}

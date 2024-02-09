package home.practice.oop.run;

import home.practice.oop.Person;
import home.practice.oop.Shopping;

public class PersonRun {
	
	public static void main(String[] args) {
		Person p1 = new Person();
		
		p1.setAge(40);
		p1.setName("James");
		p1.setIsMarried(true);
		p1.setChildNumber(3);
		
		System.out.println("이 사람의 나이 : " + p1.getAge());
		System.out.println("이 사람의 이름 : " + p1.getName());
		System.out.println("이 사람의 결혼 여부 : " + p1.getIsMarried());
		System.out.println("이 사람의 자녀 수 : " + p1.getChildNumber());
		
		System.out.println("=============================================");
		
		Shopping s1 = new Shopping();
		
		s1.setOrderNum(201803120001l); // l 붙여야함
		s1.setUserId("abc123");
		s1.setOrderDate("2018년 3월 12일");
		s1.setUserName("홍길순");
		s1.setProductNum("PD0345-12");
		s1.setAddress("서울시 영등포구 여의도동 20번지");
		
		System.out.println("주문 번호 : " + s1.getOrderNum());
		System.out.println("주문자 아이디 : " + s1.getUserId());
		System.out.println("주문 날짜 : " + s1.getOrderDate());
		System.out.println("주문자 이름 : " + s1.getUserName());
		System.out.println("주문 상품 번호 : " + s1.getProductNum());
		System.out.println("배송 주소 : " + s1.getAddress());
		
	}
	
}

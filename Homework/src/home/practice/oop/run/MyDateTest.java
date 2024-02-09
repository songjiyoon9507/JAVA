package home.practice.oop.run;

import home.practice.oop.MyDate;

public class MyDateTest {
	public static void main(String[] args) {
		
		MyDate date1 = new MyDate(30, 2, 2000);
		System.out.println(date1.isvalid());
//		System.out.println(date1.getDay());
//		System.out.println(date1.getMonth());
//		System.out.println(date1.getYear());
		
		MyDate date2 = new MyDate(2, 10, 2006);
		System.out.println(date2.isvalid());
	}
	
}

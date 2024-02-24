package cloudstudying;

import java.util.Scanner;

public class Alba {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int price = sc.nextInt();
		int time = sc.nextInt();
		
		System.out.println(price*time);
	}
}

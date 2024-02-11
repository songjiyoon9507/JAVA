package scanner.practice;

import java.util.Scanner;

public class Array1Practice1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i] += sc.nextInt();
		}
		
		int count = 0;
		
		int v = sc.nextInt();
		
		for(int i = 0 ; i < arr.length ; i++) {
			
			if(arr[i] == v) {
				count++;
			} 
		}
		
		System.out.println(count);
		
	}

}

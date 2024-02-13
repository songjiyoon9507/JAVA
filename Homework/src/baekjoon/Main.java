package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt(); // 총 과목 수
		
		// 다 double 로 입력 받아야 
		
		double[] arr = new double[M];
		
		for(int i = 0 ; i < M ; i++) { // 점수 입력 받을 횟수
			arr[i] = sc.nextDouble(); // 점수 입력 받아서 배열에 대입
		}
		
		// 점수 중 최대값 구하기
		
		
		double max = arr[0];
		
		for(int i = 0 ; i < arr.length ; i++) {
			
			if(arr[i] > max) {
				max = arr[i];
			}
			
		}
		
		double sum = 0;
		
		double[] avgArr = new double[M];
		
		for (int i = 0 ; i < arr.length ; i++) {
			
			avgArr[i] = arr[i]/max*100;
			
			sum += avgArr[i];
		}
		
		System.out.println(sum/M);
		
	}
}

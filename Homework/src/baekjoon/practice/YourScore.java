package baekjoon.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class YourScore {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		double gradeSum = 0; // 학점 총점
		double totalSum = 0;
		
		for(int i = 0 ; i < 20 ; i++) {
			str = new StringTokenizer(br.readLine());
			String subject = str.nextToken();
			double grade = Double.parseDouble(str.nextToken()); // 학점
			String alphabet = str.nextToken();
			double score = 0; // 과목 평점
			
			if(!(alphabet.equals("P"))) {
				
				switch (alphabet) {
					case "A+" :
						score = 4.5;
						break;
					case "A0" :
						score = 4.0;
						break;
					case "B+" :
						score = 3.5;
						break;
					case "B0" :
						score = 3.0;
						break;
					case "C+" :
						score = 2.5;
						break;
					case "C0" :
						score = 2.0;
						break;
					case "D+" :
						score = 1.5;
						break;
					case "D0" :
						score = 1.0;
						break;
					case "F" :
						score = 0.0;
						break;
					default :
						break;
						
				}
				
				gradeSum += grade;
				totalSum += (grade*score);
				
			}
		}
		System.out.printf("%.6f", totalSum / gradeSum);
		br.close();
	}
}

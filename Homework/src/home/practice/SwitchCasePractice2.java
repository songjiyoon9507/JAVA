package home.practice;

import java.util.Scanner;

public class SwitchCasePractice2 {

	public static void main(String[] args) {

		/* 5층 건물이 있습니다.
		 * 1층 약국, 2층 정형외과, 3층 피부과, 4층 치과, 5층 헬스 클럽
		 * 건물의 층을 누르면 그 층이 어떤 곳인지 알려주는 엘레베이터
		 * 
		 * 누른 숫자가 5인 경우 '5층 헬스 클럽입니다.' 출력
		 * */
		
		// Scanner switch 이용해보기
		// printf 이용 출력
		
		Scanner sc = new Scanner (System.in);
		
		System.out.print("이동하실 층수를 입력해주세요 : ");
		
		int floor = sc.nextInt();
		String str;
		
		switch(floor) {
		case 1 : str = "약국";
		break;
		
		case 2 : str = "정형외과";
		break;
		
		case 3 : str = "피부과";
		break;
		
		case 4 : str = "치과";
		break;
		
		case 5 : str = "헬스 클럽";
		break;
		
		default : str = ": 이 건물에 존재하지 않는 곳";
		}
		
		System.out.printf("%d층 %s입니다.",floor,str);
	}

}

package home.practice;

public class Practice1 {

	public static void main(String[] args) {
		// 유니코드
		// '글' 유니코드 찾아 char형으로 선언한 변수 저장 뒤 출력
		// 유니코드 AE00
		
		char ch1 = '\uAE00';
		System.out.println(ch1);
		
		// 후위 연산자
		int value = 10;
		int num = value++;
		
		System.out.println(num); // num에 10 대입 후
		System.out.println(value); // +1이 됨
		
		int gameScore = 150;
		
		int lastScore1 = gameScore++; // gameScore 증가 전 대입
		System.out.println(lastScore1); // 150
		// 출력 후 gameScore 151 됨
		int lastScore2 = gameScore--; // gameScore151 대입
		System.out.println(lastScore2); // 151 출력
		// 출력 후 gameScore 150 됨
		System.out.println(gameScore);
	}

}

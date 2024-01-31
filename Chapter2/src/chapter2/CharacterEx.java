package chapter2;

public class CharacterEx {

	public static void main(String[] args) {
		char ch1 = 'A';
		
		System.out.println(ch1); //문자 출력
		System.out.println((int)ch1);  //A=65 문자에 해당하는 정수값 출력
		
		char ch2 = 66; //정수값 대입
		System.out.println(ch2);   //B=66 정수값에 해당하는 문자 출력

		int ch3 = 67;
		System.out.println(ch3);  //67
		System.out.println((char)ch3);  //C=67 문자 출력
	}

}
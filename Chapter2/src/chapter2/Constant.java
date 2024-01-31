package chapter2;

public class Constant {

	public static void main(String[] args) {
		final int STUDENT_NUM = 31;  //여기만 30으로 바꾸면 결과값 달라짐
		//상수 선언해놓고 상수 값만 바꾸면 아래 결과가 알아서 바뀜
		int num = 0; //초기화
		if ( num  == STUDENT_NUM ) {}
		
		System.out.println(STUDENT_NUM);
		
	}

}
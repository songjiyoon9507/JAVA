package ifexample;

public class IfExample1 {

	public static void main(String[] args) {

		int age = 2;
		
		if(age >= 8) {
			System.out.println("학교에 다닙니다."); //참일때
		}
		else {
			System.out.println("학교에 다니지 않습니다."); //거짓일때
		}//else 지우면 여기는 결과값 안 나옴
		

		int age2 = 10;
		
		if(age2 >= 8) {
			System.out.println("학교에 다닙니다.");
			System.out.println("Test");
		}//하나의 수행문일 때는 중괄호 안 열어도 되지만 가독성 위해서 씀
		//중괄호 열고 들여쓰기
		else {
			System.out.println("학교에 다니지 않습니다.");
		}
	}

}
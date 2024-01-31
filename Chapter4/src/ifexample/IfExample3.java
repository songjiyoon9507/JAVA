package ifexample;

public class IfExample3 {

	public static void main(String[] args) {

		int age = 9;
		int charge =0;
		
		if(age < 8) {
			charge = 1000;
			System.out.println("미취학 아동입니다.");
		}
		if(age < 14) {  //else if 아닌 if만 쓰면 다 충족돼서
			charge = 2000;
			System.out.println("초등학생입니다."); //결과값이 출력됨
		}
		if(age < 20) {  //이 문장도 수행이 돼서 charge값이 2500원으로 나옴
			charge = 2500;
			System.out.println("중, 고등학생입니다.");
		}
		else {
			charge = 3000;
			System.out.println("일반인입니다.");
		}
		System.out.println("입장료는 " + charge + "원 입니다.");
		//else 빼면 결과값이 달라짐
	}

}
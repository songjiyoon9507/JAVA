package chapter2;

public class DoubleEx {
	//여기에는 자료형 변수형 쓸 수 없음 var 안됨
	public static void main(String[] args) {
		double dNum = 3.14; //기본
		float fNum = 3.14F; //뒤에 F 식별자
		
		System.out.println(dNum);
		System.out.println(fNum);
		
		boolean isMarried = true; //boolean 변수를 선언하고 초기화
		
		System.out.println(isMarried);
		
		var oNum = 3.14;   //var 자료형 추론됨 실수로 추론
		var Num = 10;  //정수로 추론
		var str = "hello"; //문자열로 추론
		
		System.out.println(oNum);
		System.out.println(Num);
		System.out.println(str);
	}

}

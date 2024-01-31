package chapter2;

public class ImplicitConversion {

	public static void main(String[] args) {
		byte bNum = 10;  //1바이트
		int num = bNum;  //4바이트 묵시적 형변환
		
		System.out.println(num);
		
		long lNum = 10;     //정수 8바이트지만 정수
		float fNum = lNum;  //실수 4바이트지만 실수 더 정밀한 수
		
		System.out.println(fNum); //결과값 10.0
		
		double dNum = fNum + num; //int + float
		System.out.println(dNum); //double로 형 변환 결과값 20.0
	}

}

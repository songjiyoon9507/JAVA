package chapter2;

public class ExclicitConversion {

	public static void main(String[] args) {
		
		int iNum = 1000; //4바이트
		byte bNum = (byte)iNum;  //-128 ~ 127까지 표현됨 1바이트
		//(byte) 안 쓰면 오류남
		System.out.println(iNum); //정상출력
		System.out.println(bNum);  //1000까지 표현이 안돼서 데이터유실
		//결과값 -24 
		
		double dNum = 3.14;
		iNum = (int)dNum; //int입력해서 소수점 이하 소실
		System.out.println(iNum); //결과값 3 출력

		float fNum = 0.9F;
		int num1 = (int)dNum + (int)fNum;
		int num2 = (int)(dNum + fNum);
		
		System.out.println(num1); //3+0이 됨
		System.out.println(num2); //3.14+0.9=4.04 4만 나옴
		
	}

}

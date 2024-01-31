package chapter2;

public class ByteVariable {

	public static void main(String[] args) {
		byte bData = -128;// 2의 -7제곱까지 표현 가능
		System.out.println(bData);
		
		byte bData2 = 127; // 127까지밖에 표현 못함 128쓰면 오류남
		System.out.println(bData2);
	}

}

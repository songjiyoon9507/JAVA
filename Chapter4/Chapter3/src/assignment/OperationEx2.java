package assignment;

public class OperationEx2 {

	public static void main(String[] args) {

		int num1 = 10;
		System.out.println(++num1); //세미콜론 끝나기 전에 1더함 결과 11
		System.out.println(num1); //이미 계산된 후라서 11
		
		int num2 = 10;
		System.out.println(num2++); //세미콜론이 끝나고 1 더함
		//아직 계산 전이라 결과 10
		System.out.println(num2); //윗 문장 끝난 후라 결과 11
		
		int num3 = 10;
		System.out.println(--num3); //세미콜론 전 계산 됨 9
		System.out.println(num3);  //세미콜론 전에 계산 돼서 얘도 9
		
		int num4 = 10;
		System.out.println(num4--); //아직 10
		System.out.println(num4);  //세미콜론 끝나고 바뀐거라 9로 출력
		//뒤에 붙은 부호 이 문장이 끝나고 나면 더해라 빼라
	}

}

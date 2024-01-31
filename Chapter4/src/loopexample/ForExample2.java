package loopexample;

public class ForExample2 {

	public static void main(String[] args) {
		
		for(int i = 0; i <10; i++) {
			//i 많이 씀, 0 많이 씀 
			System.out.println("hello, world");
		}
		//더 선호하는 방법, 계산하기가 쉬움 0~9까지는 10개 10-0은 10개
		System.out.println();
		
		for(int i = 1; i <= 10; i++) { //생각하기는 더 쉬움
			System.out.println("hello, world");
		}
		//결과는 똑같이 10개씩 출력됨
	}

}

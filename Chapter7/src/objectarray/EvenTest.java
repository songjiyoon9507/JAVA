package objectarray;

public class EvenTest {
	public static void main(String[] args) {
		
		// 배열 길이가 5인 정수형 배열을 선언하고, 1 ~ 10 중 짝수만을 배열에 저장한 후 그 합을 출력
		
		int[] arr = new int[5];
		
		for(int i = 1 ; i <= 10 ; i++) {
			if(i % 2 == 0) {
				arr[i/2-1]= i;
			}
		}
		
		int sum = 0;
		for(int total : arr) {
			sum += total;
		}
		System.out.println(sum);
	}
}

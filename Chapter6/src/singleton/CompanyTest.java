package singleton;

public class CompanyTest {
	public static void main(String[] args) {
		Company com1 = Company.getInstance();
		Company com2 = Company.getInstance();
		
		System.out.println(com1 == com2); // 결과값 boolean
		// 결과값 true 같은 곳을 참조하고 있음을 의미
	}
}

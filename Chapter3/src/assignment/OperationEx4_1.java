package assignment;

public class OperationEx4_1 {

	public static void main(String[] args) {

		//int num1 = (5>3)?10:20; //조건문,참,거짓
		//System.out.println(num1); //참이니까 10 나옴
		
		//int num2=(5<3)?10:20;
		//System.out.println(num2); //거짓이라 20 나옴
		
		int fatherAge = 45;
		int motherAge = 47;
		
		char ch;
		ch = (fatherAge > motherAge) ? 'T' : 'F';
		
		System.out.println(ch);
	}

}

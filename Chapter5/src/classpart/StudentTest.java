package classpart;

public class StudentTest {

	public static void main(String[] args) {
		

		// 출력 방법은 다른 곳에 만들어 놓고
		// 출력 내용 따로 만듦
		Student studentLee = new Student();
		studentLee.studentName = "이순신";
		studentLee.address = "서울시 영등포구 여의도동";
		studentLee.studentID = 100;
		
		Student studentKim = new Student();
		studentKim.studentName = "김유신";
		studentKim.studentID = 101;
		studentKim.address = "미국 산호세";
		
		studentLee.showStudentInfor();
		studentKim.showStudentInfor();
		
		System.out.println(studentLee);
		System.out.println(studentKim);
	}

}

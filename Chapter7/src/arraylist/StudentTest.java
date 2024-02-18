package arraylist;

public class StudentTest {
	
	public static void main(String[] args) {
		
		// 학생 생성
		Student Lee = new Student(1001, "이순신");
		
		// addSubject로 과목과 점수 추가
		Lee.addSubject("국어", 100);
		Lee.addSubject("한국사", 100);
		Lee.addSubject("코딩", 20);
		
		// 학생 생성
		Student Hong = new Student(1002, "홍길동");
		
		Hong.addSubject("국어", 70);
		Hong.addSubject("영어", 100);
		Hong.addSubject("사회", 90);
		
		Lee.showStudentInfo();
		System.out.println("========================================");
		Hong.showStudentInfo();
		
	}
}

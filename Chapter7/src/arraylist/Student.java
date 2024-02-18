package arraylist;

import java.util.ArrayList;

public class Student {
	private int studentId;
	private String studentName;
	
	ArrayList<Subject> subjectList; // ArrayList 선언하기
	
	public Student() {}

	public Student(int studentId, String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
		// 학생 만들 때 subjectList 배열 만들기
		// 그 안에 .add 로 과목 추가
		// 학생마다 list가 있는 거임
		subjectList = new ArrayList<Subject>(); // ArrayList 생성하기
	}
	
	public void addSubject(String name, int score) {
		Subject subject = new Subject(); // Subject 생성하기
		subject.setName(name); // 과목이름
		subject.setScore(score); // 과목 점수
		subjectList.add(subject); // 배열에 저장하기
	}
	
	public void showStudentInfo() {
		int total = 0;
		// 향상된 for 문
		for(Subject s : subjectList) {
			total += s.getScore(); // 총점 더하기
			// SubjectList 길이만큼 (과목 수만큼) 학생 이름, 과목 각각 성적 출력
			System.out.println("학생 " + studentName + "의 " + s.getName() 
			+ "과목 성적은 " + s.getScore() + "점 입니다.");
		}
		// 각 과목 다 꺼내고 나서 총점 출력
		System.out.println("학생 " + studentName + "의 총점은 " + total + "입니다.");
	}
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	
}

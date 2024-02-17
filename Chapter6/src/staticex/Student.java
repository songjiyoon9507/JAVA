package staticex;

public class Student {
	
	private static int serialNum = 1000;
	private int studentId; // 학번
	private String studentName;
	private int grade;
	private String address;
	private int cardNumber; // 카드번호
	
	// 기본 생성자
	public Student() {
		// 생성할 때마다 학번 부여
		serialNum++;
		// 학번은 1001번부터 식작
		studentId = serialNum;
		cardNumber = studentId + 100;
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

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
}

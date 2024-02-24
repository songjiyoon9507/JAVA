package object;

public class Student {
	int studentID;
	String studentName;
	
	public Student() {}
	
	public Student(int studentID, String studentName) {
		this.studentID = studentID;
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return studentID + ", " + studentName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student std = (Student) obj;
			if(this.studentID == std.studentID) {
				return true;
			} else return false;
		}
		return false;
	}
}

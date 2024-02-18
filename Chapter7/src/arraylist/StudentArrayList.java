package arraylist;

import java.util.ArrayList;

import objectarray.Student;

public class StudentArrayList {
	
	public static void main(String[] args) {
		
		ArrayList<Student> stu = new ArrayList<Student>();
		
		stu.add(new Student(1001,"James"));
		stu.add(new Student(1002,"Tomas"));
		stu.add(new Student(1003,"Edward"));
		
		for(Student student : stu) {
			student.showStudentInfo();
		}
	}
}

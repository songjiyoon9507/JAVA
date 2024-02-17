package objectarray;

public class StudentArray {
	public static void main(String[] args) {
		
		Student[] arr = new Student[3];
		
		arr[0] = new Student(1001, "James");
		arr[1] = new Student(1002, "Tomas");
		arr[2] = new Student(1003, "Edward");
		
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i].showStudentInfo();
		}
	}
}

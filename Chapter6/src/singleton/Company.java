package singleton;

public class Company {
	// 유일한 생성자 private
	private Company() {}
	
	// 유일하게 생성한 인스턴스
	private static Company instance = new Company();
	// Company 자료형 변수명 instance 인 static 예약어(모두 공유)
	
	// 밖에서 instance 에 접근할 수 있게 public 메서드 만들어줌
	public static Company getInstance() {
		// 반환은 static 으로 해줘야함
		// if 문이 없어도 만들어진 애 하나라서
		// 다 그곳을 바라봄
		// 불렀을 때 instance 만 return 해주면 됨
//		if(instance == null) {
//			instance = new Company();
//		}
		return instance;
	}
}

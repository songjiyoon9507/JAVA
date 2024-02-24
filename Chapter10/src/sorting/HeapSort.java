package sorting;

public class HeapSort implements Sort{

	@Override
	public void ascending(int[] arr) {
		System.out.println("HeapSort ascending");
	}

	@Override
	public void descending(int[] arr) {
		System.out.println("HeapSort descending");
	}

	@Override
	public void description() {
		// 이렇게 불러 오는 거 아님
//		super().description();
		// super() 는 상위 클래스의 생성자 호출
		// 인터페이스는 생성자 만들 수 없음 객체 생성 안됨
		
		// 이렇게 불러오는 거
		Sort.super.description();
		// super 는 상위 클래스 호출
		// Sort 참조 변수로는 사용 가능
		// Sort 는 extends 로 가져온 게 아니고 implements 로
		// 가져온 거라서 extends 로 부모 자식 상속 받은 게
		// 아니라서 super. 으로 바로 가져오는 게 안되고
		// 참조변수 이용해서 가져오는 거?
		System.out.println("HeapSort입니다.");
	}

}

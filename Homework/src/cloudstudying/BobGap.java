package cloudstudying;

public class BobGap {
	public static void main(String[] args) {
		int dongas = 8000;
		int calguksu = 6000;
		int wangmandu = 5000;
		
		int donCount = 16;
		int calCount = 8;
		int wangCount = 1;
		
		int donPrice = dongas*donCount;
		int calPrice = calguksu*calCount;
		int wangPrice = wangmandu*wangCount;
		
		int total = donPrice + calPrice + wangPrice;
		
		System.out.printf("%s x %2d = %6d\n", "돈가스", 16, donPrice);
		System.out.printf("%s x %2d = %6d\n", "칼국수", 8, calPrice);
		System.out.printf("%s x %2d = %6d\n", "왕만두", 1, wangPrice);
		System.out.println("====================");
		System.out.printf("총합: %d", total);
	}
}

package chapter4;

public class Q4 {

	public static void main(String[] args) {
		//별의 개수는 2개씩 늘어나고 1줄 빈칸이 양쪽에 3개씩 있음
		int lineCount = 4; //변수 정의 라인 수 4줄
		int starCount = 1;
		int spaceCount = lineCount/2 +1;
		//전체 줄 4/2 +1 = 3
		//lineCount가 3이 되면 2가 됨
		
		for(int i = 0; i<lineCount; i++) {
			for(int j = 0; j<spaceCount; j++) { //left  빈칸 처음에3
				System.out.print(" ");
			}
			
			for(int j = 0; j<starCount; j++) {
				System.out.print("*");
			}
			
			for(int j = 0; j<spaceCount; j++) { //right 빈칸 처음에3
				System.out.print(" ");
			}
			spaceCount -= 1; //한쪽에 하나씩 공백 줄어듦
			starCount +=2;  //별은 2개씩 늚
			System.out.println();
		}
	}

}

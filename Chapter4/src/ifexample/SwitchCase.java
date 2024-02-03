package ifexample;

public class SwitchCase {

	public static void main(String[] args) {
		// if-else 문
		int rank1 = 2;
		char medalColor1;
		
		if(rank1 == 1) {
			medalColor1 = 'G';
		}
		else if(rank1 ==2) {
			medalColor1 = 'S';
		}
		else if(rank1 ==3) {
			medalColor1 = 'B';
		}
		else {
			medalColor1 = 'A';
		}
		System.out.println(rank1 + "등 메달의 색깔은 " + medalColor1 + "입니다.");
		// switch 문
		int rank = 1;
		char medalColor;
		
		switch(rank) {
			case 1: medalColor = 'G';
					break;  //빠져나가는 문장
			case 2: medalColor = 'S';
					break;  //break 안 쓰면 뒤에 문장이 실행돼서 break 만나기 전까지 수행함
			case 3: medalColor = 'B';
					break;
			default: medalColor = 'A'; //다 아니면
		}
		System.out.println(rank + "등 메달의 색깔은 " + medalColor + "입니다.");
		
	}

}
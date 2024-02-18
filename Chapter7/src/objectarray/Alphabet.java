package objectarray;

public class Alphabet {
	
	public static void main(String[] args) {
			
		char[][] ch = new char[13][2];
			
		char a = 'A';
			
		for(int i  = 0 ; i < ch.length ; i ++) { // 13번 반복
			for(int j = 0 ; j < ch[i].length ; j++) { // 2번 반복
				ch[i][j] = a;
				a++;
				System.out.print(ch[i][j]);
			}
			System.out.println();
		}
	}
		
}

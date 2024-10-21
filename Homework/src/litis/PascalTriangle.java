package litis;

public class PascalTriangle {

	public static void main(String[] args) {
		int[][] triangle = new int[7][7];
		
		for(int i = 0 ; i < triangle.length ; i++) {
			for(int j = 0 ; j <= i ; j++) {
				if(j == 0 || j == i) {
					triangle[i][j] = 1;
				} else {
					triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
				}
				System.out.print(triangle[i][j] + " ");
			}
			System.out.println();
		}
	}
}

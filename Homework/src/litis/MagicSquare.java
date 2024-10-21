package litis;

import java.util.Random;

public class MagicSquare {

	public static void main(String[] args) {
        int n = 5;
        int[][] magicSquare = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                magicSquare[i][j] = 0;
            }
        }

        Random random = new Random();
        int row = random.nextInt(n);
        int col = random.nextInt(n);

        for (int num = 1; num <= n * n; num++) {
            magicSquare[row][col] = num;

            int newRow = (row - 1 + n) % n;
            int newCol = (col + 1) % n;

            if (magicSquare[newRow][newCol] != 0) {
                row = (row + 1) % n;
            } else {
                row = newRow;
                col = newCol;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%2d ", magicSquare[i][j]);
            }
            System.out.println();
        }
	}
}

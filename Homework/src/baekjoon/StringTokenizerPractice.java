package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class StringTokenizerPractice {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int x = 1 ; x <= T ; x++) {
			
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			
			int A = Integer.parseInt(str.nextToken());
			int B = Integer.parseInt(str.nextToken());
			bw.write("Case #" + x + ": " + A + " + " + B + " = " + (A + B) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}

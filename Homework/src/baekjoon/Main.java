package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(str);
		
		String temp = sb.toString();
		
		String[] arr =temp.split(" ");
		
		for(String s : arr) {
			System.out.println(s);
		}
		
		
	}
}

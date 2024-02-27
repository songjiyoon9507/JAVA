package edu.kh.network.client.model.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientService {

	public void clientStart() {
		
		// 1) 서버의 IP주소와 서버와 서버가 정한 포트번호를 매개변수로 하여
		//    클라이언트용 소켓 객체 생성
		
		String serverIP = "127.0.0.1"; // loop back IP(현재 컴퓨터를 나타내는 IP)
		int port = 8500; // 포트 번호 Server 에서 정해 놓음
		
		Socket clientSocket = null; // 클라이언트용 소켓 참조변수 선언
		
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			System.out.println("[Client]");
			
			clientSocket = new Socket(serverIP, port);
			// UnknownHostException : IP가 잘못되었을 때 발생하는 예외
			
			// 2) 서버와의 입출력 스트림 오픈
			if(clientSocket != null) { // 서버와 연결이 성공한 경우
				
				is = clientSocket.getInputStream();
				os = clientSocket.getOutputStream();
				
				// 3) 보조 스트림을 통해 성능 개선
				br = new BufferedReader(new InputStreamReader(is));
				pw = new PrintWriter(os);
				
				// 4) 스트림을 통해 읽고 쓰기
				String serverMessage = br.readLine();
				// 서버 -> 클라이언트에게 보낸 메세지를 저장
				
				// 서버로부터 받은 메세지를 화면에 출력
				System.out.println(serverMessage);
				
				// ===================================================
				// 클라이언트 -> 서버로 메세지 전송
				Scanner sc = new Scanner(System.in);
				
				System.out.print("서버로 전달할 메세지 : ");
				String str = sc.nextLine();
				
				pw.println(str); // 메세지를 서버쪽으로 출력
				pw.flush(); // 스트림 내용 밀어내기
				
				// ===================================================
				
				// ===================================================
				// 서버 -> 클라이언트로 메세지 전달 받기
				String serverMessage2 = br.readLine();
				
				// 클라이언트 메세지 출력
				System.out.println("서버가 보낸 메세지 : " + serverMessage2);
				
				// ===================================================

			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			// 5) 통신 종료
			try {
				if(br != null) br.close();
				if(pw != null) pw.close();
				
				if(clientSocket != null) clientSocket.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

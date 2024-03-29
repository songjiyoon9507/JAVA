package home.practice.servlet.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Controller : 요청(Request)에 따라 어떤 Service 를 호출할지 "제어"하고,
//              어떻게 응답(Response)을 할지 "제어"하는 역할
public class ExampleController1 extends HttpServlet{
	// 클라이언트 -(요청)-> 서버(Controller -> Service -> DAO -> DB)
	// DB에서 맞는 값을 들고 돌아옴
	// 결과 값을 들고 와서 다시 클라이언트로 응답해주는 게 Controller
	
	// Java 코드로 웹페이지를 만들 수 있게 해주는 기술
	// Servlet 이용
	// Servlet 이용하려면 HttpServlet 을 상속 받아야함
	// HttpServlet 을 상속 받아서 쓸 수 있는 메서드들
	// Ctrl + SpaceBar 누르면 오버라이딩 해서 쓸 수 있는 메서드들 많이 정의돼있음
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 사용자에게 요청이 오면 Servlet Container 가 만들어줌
		// 매개 변수 이용해서 가져옴
		// req resp 에 요청에 관한 정보들 응답에 관한 정보들이 들어가져있음
		// Servlet Container 가 만들어준 걸 보여주는 거
		// HttpServletRequest
		// HttpServletResponse
		
		// doGet() 메서드
		// -> GET 방식 요청을 처리하는 메서드
	}
	
	
}

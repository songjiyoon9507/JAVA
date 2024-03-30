package home.practice.servlet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// ** Servlet 관련 코드를 작성하기 위해서는 HttpServlet 클래스를 반드시 상속 받아야함 **

// 자카르타에서 제공해주는 어노테이션 임포트
/* @Override
 * 어노테이션 : 컴파일러가 읽는 주석
 * 
 * @WebServlet 어노테이션
 * 해당 클래스를 Servlet 으로 등록하고 (ExampleController2 클래스를 Servlet 으로 등록)
 * 매핑할 주소를 연결하라고 지시하는 어노테이션 ("/signUp") 연결
 * 
 * -> 서버 실행 시 자동으로 web.xml 에 <servlet> <servlet-mapping> 를 작성하는 효과와 같음
 * */
@WebServlet("/signUp")
public class ExampleController2 extends HttpServlet{ // servlet 이용하기 위해서는 상속 받아야함
	// ExampleController1 보다 간단하게 매핑 하는 법
	/* ExampleController1은 web.xml 에서 직접 매핑해줬음
	 * 클라이언트에서 요청이 들어오면 어디로 보낼지 지정해줬음
	 * */
	
	// POST 요청 처리 메서드 오버라이딩
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 클라이언트에서 전달 받은 데이터 req 에 담겨있음 (요청 받은 데이터)
		// POST 방식의 [단점]이었던
		/* 서버에서 추가적인 문자 인코딩 처리
		 * 
		 * 원래 tomcat9 버전에서는 전달받은 값을 얻어와서 확인해보면 한글이 깨지는 문제 발생
		 * 해결 방법 : 전달받은 데이터의 문자 인코딩을 서버에 맞게 변경해줬어야했음
		 * req.setCharacterEncoding("UTF-8");
		 * 이렇게 해줘야 req 안에 들어있는 한글 값들이 안 깨졌었음
		 * 
		 * => tomcat 10 버전 이상부터 자동으로 인코딩 처리를 해주기 때문에
		 * 추가적인 처리 필요 X
		 * */
		
		String inputId = req.getParameter("inputId");
		String inputPw = req.getParameter("inputPw");
		String inputName = req.getParameter("inputName");
		String intro = req.getParameter("intro");
		//                               name 속성값
		
		System.out.println(inputId);
		System.out.println(inputPw);
		System.out.println(inputName);
		System.out.println(intro);
		/*  http://localhost:8080/signUp
		 * URL 에 뜨는 값 없음
		 * 요청 주소 외에는 query String 데이터 노출 안됨
		 * 
		 * Console 창 출력 화면
		 * 
		  	user01
			pass01
			홍길동
			안녕하세요 홍길동입니다.
			
			-> 한글 안 깨지고 잘 넘어옴
		 * */
		
		// 클라이언트한테 보낼 응답화면 보내기
		// ExampleController1 에서는 PrintWriter 로 한줄 한줄 출력해서 보냄
		// -> Java 에서 작성하는 방식이 너무 귀찮고 힘듦
		
		// Servlet 이 요청을 위임함 (대신 만들어달라고) -> jsp 에게 요청 위임
		// -> JSP 가 대신 화면 만들어줄거임
		// => JSP : Java Server Page
		// 자바에서 만드는 웹페이지 기술 (자바로 만든 HTML 파일)
		// JSP 확장자를 통해서 HTML 만드는 것과 거의 똑같이 화면을 만들 수 있음
		// JSP 에게 응답화면을 만들어라 하고 위임하는 것 (HTML 처럼)
		
		// JSP가 대신 화면을 만들어 주기 위해서는 Servlet 이 어떤 요청을 받았는지 알아야함
		// Servlet 이 받은 요청(클라이언트에서 보낸 요청에 대한 데이터는 req 에 담겨있음)
		
		// req 에 담긴 정보를 jsp 에게 알려줘야함
		// req.getRequestDispatcher(); 이 메서드를 통해서 servlet 이 어떤 요청을 받은건지 jsp 에게
		// 알려주는 거 (디스패처 이용해서 요청정보를 전달하면서 이 경로에 응답화면을 만들어달라고
		// 주문하는 것)
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/result.jsp");
		// 반환 자료형이 RequestDispatcher
		// jsp 라는 확장자 파일을 만들어서 webapp 안에 WEB-INF 안에 jsp 폴더 만들어줄 거임
		// 이 경로를 전달해줘야함
		// 경로의 기준이 webapp
		// => 작성해준 경로의 jsp 로 위임을 하겠다 req 데이터를 담아서
		dispatcher.forward(req, resp);
		// 요청 정보 받은 걸로 화면 만들어서 가지고 돌아와라
	}
}

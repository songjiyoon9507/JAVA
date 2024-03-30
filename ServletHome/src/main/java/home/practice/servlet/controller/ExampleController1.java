package home.practice.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
	// 재정의하여 사용
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
		
		/* HttpServletRequest
		 * - 클라이언트 요청 시 Servlet Container 안에서 생성되는 객체
		 * - 클라이언트의 데이터 + 요청 관련 데이터
		 * 
		 * HttpServletResponse
		 * - 클라이언트 요청 시 서버에서 생성하는 객체
		 * - 서버가 클라이언트에게 응답하기 위한 방법을 제공하는 객체
		 * */
		
		System.out.println("이름, 나이를 입력받아 처리하는 코드");
		
		// 클라이언트 단에서 요청할 때 inputName이랑 inputAge
		// 요청 시 입력된 이름, 나이를 전달 받아오기
		
		// 클라이언트의 데이터와 요청 관련 데이터가 req 매개변수에 담겨져서 들어옴
		// req 에서 입력받은 이름, 나이를 꺼내서 쓸 수 있음
		
		// Parameter : 매개변수 == 다른 곳의 값을 전달 받아올 때 사용하는 변수
		
		// req.getParameter(); req 에서 요청 받은 데이터를 getParameter 메서드로 가져올거임
		// 파라미터를 얻어올 때 전달해줘야할 값은 "name 속성값"
		// => getParameter("name속성값");
		// -> 요청 시 전달된 데이터 중 name 속성값이 일치하는 데이터의 value 값을 얻어와서
		//    String 형태로 반환해줌
		// /example1 input 태그 안에 name 속성값으로 작성된 거의 value 를 얻어오는 거
		// name="inputName" -> getParameter("inputName") 하면 inputName이라는 name 속성을 가진 input 태그 안에 작성된 값이
		// String 형태로 들어옴
		
		// HTML 에서 얻어오는 모든 값은 ** String **
		String name = req.getParameter("inputName");
		String age = req.getParameter("inputAge");
		// => <a href="/example1?inputName=홍길동">홍길동</a>
		// 이렇게 작성하면 req.getParameter("inputName") -> 홍길동 값이 넘어옴
		// doGet 방식
		// <a href="/example1?inputName=홍길동&inputAge=20">홍길동</a>
		// -> getParameter("inputAge") -> 20
		
		System.out.println("입력 받은 이름 : " + name);
		System.out.println("입력 받은 나이 : " + age);
		
		// GET 요청 주소창
		// http://localhost:8080/example1?inputName=송지윤&inputAge=30
		// URL                  요청 주소
		
		/* Console
		 * 
		 * 이름, 나이를 입력받아 처리하는 코드
		 * 입력 받은 이름 : 송지윤
		 * 입력 받은 나이 : 30
		 * 
		 * 요청한 곳에서 보낸 데이터 확인
		 * */
		
		// 서버에서 클라이언트로 응답하기
		// HttpServletResponse 객체를 이용
		
		// 응답하는 문서의 형식과 문자인코딩을 지정해줘야함
		// out 통해서 내보내는 게 html 이고 utf-8 이라고 알려줘야함
		// 안해주면 �≪��ㅻ떂�� �섏씠�� 30�� �낅땲��. 이렇게 깨져서 html 화면 보여짐
		// 응답하는 형식이라서 resp 로 보내줌
		resp.setContentType("text/html; charset=UTF-8");
		//                  글자가 작성된 html 문자 형식은 UTF-8이다
		
		// -> 형식 지정해준 후 출력 (HTML 화면)
		// 송지윤님의 나이는 30세 입니다.
		
		// 서버 -> 클라이언트로 연결되는 스트림을 얻어오기
		// 서버에서 클라이언트로 응답하는 방법은 응답페이지(HTML 같은 거)를 만들어서 보냄
		// 서버랑 응답페이지를 연결해서 출력해주는 형태로 만들 거
		// 출력 스트림 이용
		PrintWriter out = resp.getWriter(); // 서버 -> 클라이언트에게 쓰는 것 (출력)
		
		// HTML 형태로 꾸며줘야함
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
			out.println("<title>서버 응답 결과</title>");
		out.println("</head>");
		
		out.println("<body>");
			out.println("<h1>");
			out.println(name + "님의 나이는 " + age + "세 입니다.");
			out.println("</h1>");
		out.println("</body>");
		
		out.println("</html>");
	}
	
	
}

package sjy.busReservation.member.model.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sjy.busReservation.member.model.dto.Member;
import sjy.busReservation.member.model.service.MemberService;

@WebServlet("/signup")
public class SignupController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 회원가입 폼으로 이동
		req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String inputName = req.getParameter("inputName");
			String inputPhone = req.getParameter("inputPhone");
			
			
			
			
			Member member = new Member();
			
			member.setName(inputName);
			member.setPhoneNum(inputPhone);
			
			MemberService service = new MemberService();
			
			HttpSession session = req.getSession();
			// 전화번호 겹치는 게 있는지 검사
			// 전화번호가 primary key 라서 중복되면 에러 뜸
			int check = service.check(inputPhone);
			
			System.out.println(check);
			
			if (check > 0) {
				session.setAttribute("message", "이미 가입된 번호입니다.");
				resp.sendRedirect(req.getHeader("referer"));
			} else if (check == -1) {
				System.out.println("SQL 조회 자체가 안된 거");
			} else {
				
				int result = service.signup(member);
				
				if(result > 0) {
					session.setAttribute("message", "회원가입 완료");
					resp.sendRedirect("/");
				} else {
					session.setAttribute("message", "회원가입 오류");
					resp.sendRedirect(req.getHeader("referer"));
				}
			}
			
		} catch (Exception e) {
			System.out.println("[회원가입 중 예외발생]");
			e.printStackTrace();
		}
	
	}
	
}

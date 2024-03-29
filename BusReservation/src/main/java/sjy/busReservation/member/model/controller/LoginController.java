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

@WebServlet("/login")
public class LoginController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// 1. 입력 받은 값(파라미터) 얻어오기
			String inputName = req.getParameter("inputName");
			String inputPhone = req.getParameter("inputPhone");
			
			System.out.println(inputName);
			System.out.println(inputPhone);
			
			MemberService service = new MemberService();
			Member loginMember = service.login(inputName, inputPhone);
			
			System.out.println(loginMember);
			
			HttpSession session = req.getSession();
			
			if(loginMember != null) { // 로그인 성공시
				session.setAttribute("loginMember", loginMember);
				
				session.setMaxInactiveInterval(60 * 60);
				
				Member reserveInfo = service.selectInfo(inputName, inputPhone);
				
				session.setAttribute("reserveInfo", reserveInfo);
				
				// 매인 페이지로 이동 재요청
				resp.sendRedirect("/");
			} else { // 로그인 실패시
				session.setAttribute("message", "이름 또는 전화번호 불일치");
				
				String referer = req.getHeader("referer");
				
				resp.sendRedirect(referer);
			}
			
		} catch(Exception e) {
			System.out.println("[로그인 중 예외 발생]");
			e.printStackTrace();
		}
	}
}

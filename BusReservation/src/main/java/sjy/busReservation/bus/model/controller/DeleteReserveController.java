package sjy.busReservation.bus.model.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sjy.busReservation.bus.model.service.BusSeatService;
import sjy.busReservation.member.model.dto.Member;
import sjy.busReservation.member.model.service.MemberService;

@WebServlet("/deleteReserve")
public class DeleteReserveController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession();
			
			Member loginMember = (Member) session.getAttribute("loginMember");
			
			// loginMember 아이디 번호로 예약 정보 담긴 서비스 불러서
			// busNo 이랑 busSeat 받아서
			// 버스 먼저 예약 가능으로 만들고
			// loginMember 안에 내용 삭제
			
			// 로그인한 사람의 예약 정보 불러서 일단 busNo 이랑 seatNo 저장
			MemberService ms = new MemberService();
			
			Member memberInfo = ms.selectInfo(loginMember.getName(), loginMember.getPhoneNum());
			
			BusSeatService bs = new BusSeatService();
			
			int busResult = bs.backReserve(memberInfo.getBusNo(), memberInfo.getReserveSeatNo());
			
			if(busResult > 0) {
				// 버스 정보 변경 완료
				// 로그인한 사람 예약 정보를 null 로 바꿔줘야함
				int memResult = ms.deleteReserve(loginMember.getPhoneNum());
				
				if(memResult > 0) {
					session.setAttribute("message", "예약 취소 완료");
					
					Member reserveInfo = ms.selectInfo(loginMember.getName(), loginMember.getPhoneNum());
					
					session.setAttribute("reserveInfo", reserveInfo);
					
					resp.sendRedirect("/");
				} else {
					session.setAttribute("message", "예약 취소 실패");
					resp.sendRedirect(req.getHeader("referer"));
				}
				
			} else {
				session.setAttribute("message", "버스 예약 정보 변경 실패");
			}
			
		} catch (Exception e) {
			System.out.println("[예약 취소 중 오류 발생]");
			e.printStackTrace();
		}
	
	}
}

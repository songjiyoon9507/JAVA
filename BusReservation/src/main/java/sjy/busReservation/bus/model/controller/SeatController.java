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

@WebServlet("/reserveSeat")
public class SeatController extends HttpServlet {
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		try {
//			String seatNo = req.getParameter("seatNo");
//			
//			System.out.println(seatNo);
//			
//		} catch(Exception e) {
//			System.out.println("[SeatController 오류]");
//			e.printStackTrace();
//		}
//		
//
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession();
			
			String seatNo = req.getParameter("seatNo");
			String busNo = (String) session.getAttribute("busNo");
			Member member = (Member) session.getAttribute("loginMember");
			
			// Member 안에 예약 정보 넣어주기 + 제대로 들어갔으면 버스 예약됐다고 바꿔주기
			MemberService service = new MemberService();

			BusSeatService bs = new BusSeatService();

			// 예약 변경 눌렀을 때도 이쪽으로 옴
			// member 이름 번호로 예약 정보 있는지 먼저 조회
			Member check = service.selectInfo(member.getName(), member.getPhoneNum());
			
			if (check != null) {
				// 조회 결과 있을 때
				// 기존 버스 예약 N 으로 바꿔줘야함
				int checkResult = bs.backReserve(check.getBusNo(), check.getReserveSeatNo());
				
				// 결과
				if(checkResult <= 0) {
					session.setAttribute("message", "예약 변경 실패");
					resp.sendRedirect(req.getHeader("referer"));
				}
			}
			
			
			int result = service.updateReserve(member, busNo, seatNo);
			
			if(result > 0) {
				// 정보가 제대로 들어갔다면
				// bus_seat 테이블 예약 정보 바꿔줘야함
				
				int update = bs.update(busNo,seatNo);
				
				// update 결과
				if (update > 0) {
					session.setAttribute("message", "예약 완료");
					
					Member reserveInfo = service.selectInfo(member.getName(), member.getPhoneNum());
					
					session.setAttribute("reserveInfo", reserveInfo);
					
					resp.sendRedirect("/");
				} else {
					session.setAttribute("message", "예약 실패");
					resp.sendRedirect(req.getHeader("referer"));
				}
				
			} else {
				session.setAttribute("message", "예약 실패");
				resp.sendRedirect(req.getHeader("referer"));
			}

			// 값 받아옴 
		} catch (Exception e) {
			System.out.println("[SeatController 오류]");
			e.printStackTrace();
		}
	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		try {
//			HttpSession session = req.getSession();
//			
//			String seatNo = req.getParameter("seatNo");
//			String busNo = (String) session.getAttribute("busNo");
//			Member member = (Member) session.getAttribute("loginMember");
////			System.out.println(seatNo); 
////			System.out.println(busNo); 
////			System.out.println(member.getPhoneNum()); 
//			
//			// 이제 값들 넣어서 service 호출해서
//			// 테이블에 update 해줄 거
//
//			
//		} catch (Exception e) {
//			System.out.println("[SeatController 오류]");
//			e.printStackTrace();
//		}
//	
//	}
	
//	/**
//	 * 돌아가기 버튼
//	 */
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		super.doPost(req, resp);
//	}
}

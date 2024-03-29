package sjy.busReservation.bus.model.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sjy.busReservation.member.model.dto.Member;

@WebServlet("/reserveOut")
public class ReserveOutController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		Member member = (Member) session.getAttribute("loginMember");
		
		session.setAttribute("loginMember", member);
		
		req.getRequestDispatcher("/").forward(req, resp);
	
	}
}

package sjy.busReservation.member.model.service;

import java.sql.Connection;

import static sjy.busReservation.common.JDBCTemplate.*;
import sjy.busReservation.member.model.dao.MemberDAO;
import sjy.busReservation.member.model.dto.Member;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO();
	
	/** 로그인 서비스
	 * @param inputName
	 * @param inputPhone
	 * @return loginMember
	 */
	public Member login(String inputName, String inputPhone) throws Exception {
		Connection conn = getConnection();
		
		Member loginMember = dao.login(conn, inputName, inputPhone);
		
		close(conn);
		
		System.out.println("[MemberService]");
		
		return loginMember;
	}

	/** 회원가입 서비스
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int signup(Member member) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.signup(conn, member);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 로그인한 사람의 예약 정보
	 * @param inputName
	 * @param inputPhone
	 * @return reserveInfo
	 * @throws Exception
	 */
	public Member selectInfo(String inputName, String inputPhone) throws Exception {
		Connection conn = getConnection();
		
		Member reserveInfo = dao.selectInfo(conn, inputName, inputPhone);
		
		close(conn);

		return reserveInfo;
	}

	/** 중복되는 전화번호 있는지 검사
	 * @param inputPhone
	 * @return check
	 * @throws Exception
	 */
	public int check(String inputPhone) throws Exception {
		Connection conn = getConnection();
		
		int check = dao.check(conn, inputPhone);
		
		close(conn);
		
		return check;
	}

	/** 예약 정보 넣어주는 서비스
	 * @param member
	 * @param busNo
	 * @param seatNo
	 * @return result
	 * @throws Excpetion
	 */
	public int updateReserve(Member member, String busNo, String seatNo) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.updateReserve(conn, member, busNo,seatNo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		return result;
	}

	/** 핸드폰 번호 일치하는 사람 예약 정보 날려주는 서비스
	 * @param phoneNum
	 * @return memResult
	 */
	public int deleteReserve(String phoneNum) throws Exception {
		Connection conn = getConnection();
		
		int memResult = dao.deleteReserve(conn, phoneNum);
		
		if(memResult > 0) commit(conn);
		else rollback(conn);
		
		return memResult;
	}




}

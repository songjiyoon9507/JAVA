package busReservation.model.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import static busReservation.common.JDBCTemplate.*;

import busReservation.common.Session;
import busReservation.model.dao.BusDAO;
import busReservation.model.dto.Bus;
import busReservation.model.dto.ReservePerson;

public class BusService {
	
	private BusDAO dao = new BusDAO();

	/** 핸드폰 번호 중복 확인
	 * @param phone
	 * @return result
	 * @throws Exception
	 */
	public int phoneNumCheck(String phone) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.phoneNumCheck(conn, phone);
		
		close(conn);
		
		return result;
	}

	/** 회원가입
	 * @param person
	 * @return result
	 * @throws Exception
	 */
	public int signUp(ReservePerson person) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.signUp(conn, person);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 로그인
	 * @param phone
	 * @return person
	 * @throws Exception
	 */
	public ReservePerson login(String phone) throws Exception {
		Connection conn = getConnection();
		
		ReservePerson person = dao.login(conn, phone);
		
		close(conn);
		
		return person;
	}

	/** 버스 목록 조회
	 * @return busList
	 */
	public List<Bus> searchAllBus() throws Exception {
		Connection conn = getConnection();
		
		List<Bus> busList = dao.searchAllBus(conn);
		
		close(conn);
		
		return busList;
	}

	/** 버스별 남은 좌석 조회
	 * @return leftSeatList
	 * @throws Exception
	 */
	public Map<Integer, Integer> leftSeat() throws Exception {
		Connection conn = getConnection();
		
		Map<Integer, Integer> leftSeatList = dao.leftSeat(conn);
		
		close(conn);
		
		return leftSeatList;
	}

	/** 예약 정보 있는지 조회
	 * @param phoneNum
	 * @return person
	 */
	public ReservePerson reserveInfo(String phoneNum) throws Exception {
		Connection conn = getConnection();
		
		ReservePerson person = dao.reserveInfo(conn, phoneNum);
		
		close(conn);
		
		return person;
	}
	
	/** 버스 번호 받아서 남은 좌석 번호 돌려주는 메서드
	 * @param busNo
	 * @return remainSeatList
	 */
	public List<Integer> remainSeat(int busNo) throws Exception {
		Connection conn = getConnection();
		
		List<Integer> remainSeatList = dao.remainSeatList(conn, busNo);

		close(conn);
		
		return remainSeatList;
	}

	/** 버스 예약
	 * @param busNo
	 * @param seatNo
	 * @return result
	 */
	public int reserveBus(int busNo, int seatNo) throws Exception {
		Connection conn = getConnection();
		int personResult= 0;
		
		int busResult = dao.reserveBus(conn, busNo, seatNo);
		
		if(busResult > 0) {
			personResult = dao.updatePerson(conn, busNo, seatNo, Session.loginPerson.getPhoneNum());
			commit(conn);
		} else rollback(conn);
		
		close(conn);
		
		return personResult;
	}

	/** 예약 취소
	 * @param phoneNum
	 * @param SeatNo 
	 * @param busNo 
	 * @return result
	 * @throws Exception
	 */
	public int deleteReserve(String phoneNum, int busNo, int seatNo) throws Exception {
		Connection conn = getConnection();
		int result = 0;
		
		int busReserve = dao.busReserve(conn, busNo, seatNo);
		
		if (busReserve > 0) {
			result = dao.deleteReserve(conn, phoneNum);
			if(result > 0) {
				commit(conn);
			} else rollback(conn);
		} else rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 회원 삭제
	 * @param phoneNum
	 * @return result
	 */
	public int removePerson(String phoneNum) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.removePerson(conn, phoneNum);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		return result;
	}



}

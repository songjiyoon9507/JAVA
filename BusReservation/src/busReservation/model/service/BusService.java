package busReservation.model.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import static busReservation.common.JDBCTemplate.*;
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

	/** 
	 * @param busNo
	 * @return
	 */
	public List<Integer> remainSeat(int busNo) {
		// TODO Auto-generated method stub
		return null;
	}

}

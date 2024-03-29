package sjy.busReservation.bus.model.service;

import java.sql.Connection;
import java.util.List;

import sjy.busReservation.bus.model.dao.BusSeatDAO;
import sjy.busReservation.bus.model.dto.BusSeat;
import static sjy.busReservation.common.JDBCTemplate.*;

public class BusSeatService {

	private BusSeatDAO dao = new BusSeatDAO();
	
	/** 버스 번호 입력 받아 남은 좌석 보여줌
	 * @param inputBusNo
	 * @return seatList
	 * @throws Exception
	 */
	public List<BusSeat> showSeat(String inputBusNo) throws Exception {
		Connection conn = getConnection();
		
		List<BusSeat> seatList = dao.showSeat(conn, inputBusNo);
		
		close(conn);
		
		return seatList;
	}

	/** 예약 정보 업데이트
	 * @param busNo
	 * @param seatNo
	 * @return reserve
	 * @throws Exception
	 */
	public int update(String busNo, String seatNo) throws Exception{
		Connection conn = getConnection();
		
		int reserve = dao.update(conn, busNo, seatNo);
		
		if(reserve > 0) commit(conn);
		else rollback(conn);
		
		return reserve;
	}

	/** 예약 변경 누르면 기존에 예약 돼있던 버스 정보 바꿔주는 서비스
	 * @param busNo
	 * @param reserveSeatNo
	 * @return checkResult
	 * @throws Exception
	 */
	public int backReserve(int busNo, int reserveSeatNo) throws Exception {
		Connection conn = getConnection();
		
		int checkResult = dao.backReserve(conn, busNo, reserveSeatNo);
		
		if(checkResult > 0) commit(conn);
		else rollback(conn);
		
		return checkResult;
	}

}

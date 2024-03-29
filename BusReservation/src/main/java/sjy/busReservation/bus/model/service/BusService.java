package sjy.busReservation.bus.model.service;

import java.sql.Connection;
import java.util.List;

import sjy.busReservation.bus.model.dao.BusDAO;
import sjy.busReservation.bus.model.dto.Bus;
import static sjy.busReservation.common.JDBCTemplate.*;

public class BusService {

	private BusDAO dao = new BusDAO();
	
	public List<Bus> selectAll() throws Exception {
		
		Connection conn = getConnection();
		
		List<Bus> busList = dao.selectAll(conn);
		
		close(conn);
		
		return busList;
	}

	/** 입력받은 버스번호가 존재하는지 조회하는 서비스
	 * @param inputBusNo
	 * @return count
	 * @throws Exception
	 */
	public int select(String inputBusNo) throws Exception {
		Connection conn = getConnection();
		
		int count = dao.select(conn, inputBusNo);
		
		close(conn);
		
		return count;
	}

}

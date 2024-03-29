package sjy.busReservation.bus.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import sjy.busReservation.bus.model.dto.Bus;
import static sjy.busReservation.common.JDBCTemplate.*;

public class BusDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public BusDAO() {
		try {
			prop = new Properties();
			
			String filePath
				= BusDAO.class.getResource("/sjy/busReservation/sql/bus-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (Exception e) {
			System.out.println("[BusDAO 오류 발생]");
			e.printStackTrace();
		}
	
	}
	
	/** 버스 전체 조회
	 * @param conn
	 * @return busList
	 * @throws Exception
	 */
	public List<Bus> selectAll(Connection conn) throws Exception {
		List<Bus> busList = new ArrayList<Bus>();
		
		try {
			String sql = prop.getProperty("selectAll");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				busList.add(new Bus(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
			}
		} finally {
			close(rs);
			close(stmt);
		}
		
		return busList;
	}

	/** 입력 받은 버스가 존재하는지 조회
	 * @param conn
	 * @param inputBusNo
	 * @return count
	 * @throws Exception
	 */
	public int select(Connection conn, String inputBusNo) throws Exception {
		int count = -1;
		
		try {
			String sql = prop.getProperty("select");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, inputBusNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return count;
	}

}

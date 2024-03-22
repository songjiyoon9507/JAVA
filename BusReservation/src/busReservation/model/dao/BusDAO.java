package busReservation.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import busReservation.model.dto.Bus;
import busReservation.model.dto.ReservePerson;

import static busReservation.common.JDBCTemplate.*;

public class BusDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public BusDAO() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("query.xml"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/** 전화번호 중복 확인
	 * @param conn
	 * @param phone
	 * @return result
	 * @throws Exception
	 */
	public int phoneNumCheck(Connection conn, String phone) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("phoneNumCheck");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phone);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) result = rs.getInt(1);
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}

	/** 회원가입
	 * @param conn
	 * @param person
	 * @return result
	 */
	public int signUp(Connection conn, ReservePerson person) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("signUp");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, person.getName());
			pstmt.setString(2, person.getPhoneNum());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 로그인
	 * @param conn
	 * @param phone
	 * @return person
	 * @throws Exception
	 */
	public ReservePerson login(Connection conn, String phone) throws Exception {
		ReservePerson person = null;
		
		try {
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phone);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				person = new ReservePerson();
				
				person.setName(rs.getString(1));
				person.setPhoneNum(rs.getString(2));
				person.setDepartures(rs.getString(3));
				person.setArrivals(rs.getString(4));
				person.setDepartureTime(rs.getString(5));
				person.setBusNo(rs.getInt(6));
				person.setReserveSeatNo(rs.getInt(7));
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return person;
	}

	/** 버스 목록 조회
	 * @param conn
	 * @return busList
	 * @throws Exception
	 */
	public List<Bus> searchAllBus(Connection conn) throws Exception {
		List<Bus> busList = new ArrayList<Bus>();
		
		try {
			String sql = prop.getProperty("searchAllBus");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				busList.add(new Bus(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5)));
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return busList;
	}

	/** 버스 남은 좌석
	 * @param conn
	 * @return leftSeatList
	 */
	public Map<Integer, Integer> leftSeat(Connection conn) throws Exception {
		Map<Integer, Integer> leftSeatList = new  LinkedHashMap<Integer, Integer>();
		
		try {
			String sql = prop.getProperty("leftSeat");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				leftSeatList.put(rs.getInt(1), rs.getInt(2));
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		return leftSeatList;
	}

	/** 남은 좌석 번호 조회
	 * @param conn
	 * @param busNo
	 * @return remainSeatList
	 * @throws Exception
	 */
	public List<Integer> remainSeatList(Connection conn, int busNo) throws Exception {
		List<Integer> remainSeatList = new ArrayList<Integer>();
		
		try {
			String sql = prop.getProperty("remainSeat");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, busNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				remainSeatList.add(rs.getInt(1));
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return remainSeatList;
	}

	/** 버스 예약
	 * @param conn
	 * @param busNo
	 * @param seatNo
	 * @return result
	 */
	public int reserveBus(Connection conn, int busNo, int seatNo) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("reserveBus");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, busNo);
			pstmt.setInt(2, seatNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}

	/** 예약한 사람 정보 저장
	 * @param conn
	 * @param busNo
	 * @param seatNo
	 * @param phone 
	 * @return result
	 * @throws Exception
	 */
	public int updatePerson(Connection conn, int busNo, int seatNo, String phone) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("updatePerson");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, busNo);
			pstmt.setInt(2, busNo);
			pstmt.setInt(3, busNo);
			pstmt.setInt(4, busNo);
			pstmt.setInt(5, seatNo);
			pstmt.setString(6, phone);
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	
}

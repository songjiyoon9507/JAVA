package sjy.busReservation.member.model.dao;

import static sjy.busReservation.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import sjy.busReservation.member.model.dto.Member;

public class MemberDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	/**
	 * 기본 생성자
	 */
	public MemberDAO() {
		try {
			prop = new Properties();
			
			String filePath
				= MemberDAO.class.getResource("/sjy/busReservation/sql/member-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch(Exception e) {
			System.out.println("[sql 가져오는 과정에서 오류]");
			e.printStackTrace();
		}
	}

	/** 로그인 SQL 수행 DAO
	 * @param conn
	 * @param inputName
	 * @param inputPhone
	 * @return loginMember
	 */
	public Member login(Connection conn, String inputName, String inputPhone) throws Exception {
		Member loginMember = null;
		
		try {
			
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, inputName);
			pstmt.setString(2, inputPhone);
			System.out.println("[memberDAO]");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginMember = new Member();
				
				loginMember.setName(rs.getString(1));
				loginMember.setPhoneNum(rs.getString(2));
//				if(rs.getString(3) != null) {
//					loginMember.setDepartures(rs.getString(3));
//					loginMember.setArrivals(rs.getString(4));
//					loginMember.setDepartureTime(rs.getString(5));
//					loginMember.setBusNo(rs.getInt(6));
//					loginMember.setReserveSeatNo(rs.getInt(7));
//				}
				
				System.out.println("ResultSet 있음");
				
				System.out.println(loginMember.getName().toString());
				
//				System.out.println(loginMember.getDepartures().toString());
				
			} else {
				
				System.out.println("[ResultSet이 없음]");
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return loginMember;
	}
	
	// 회원 가입 전에 중복되는 전화번호 있는지 먼저 확인
	
	
	public int signup(Connection conn, Member member) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("signup");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPhoneNum());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 로그인한 회원의 예약 정보 조회
	 * @param conn
	 * @param inputPhone
	 * @return
	 */
	public Member selectInfo(Connection conn,String inputName, String inputPhone) throws Exception{
		Member reserveInfo = null;
		
		try {
			String sql = prop.getProperty("reserveInfo");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, inputName);
			pstmt.setString(2, inputPhone);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				reserveInfo = new Member();
				
				reserveInfo.setDepartures(rs.getString(1));
				reserveInfo.setArrivals(rs.getString(2));
				reserveInfo.setDepartureTime(rs.getString(3));
				reserveInfo.setBusNo(rs.getInt(4));
				reserveInfo.setReserveSeatNo(rs.getInt(5));
			}
			
		} finally {
			close(pstmt);
		}
		
		return reserveInfo;
	}

	/** 중복되는 전화번호 있는지 검사
	 * @param conn
	 * @param inputPhone
	 * @return check
	 * @throws Exception
	 */
	public int check(Connection conn, String inputPhone) throws Exception {
		int check = -1;
		
		try {
			String sql = prop.getProperty("check");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inputPhone);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				check = rs.getInt(1);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return check;
	}

	/** 예약 정보 넣어주는 DAO
	 * @param conn
	 * @param member
	 * @param busNo
	 * @param seatNo
	 * @return result
	 * @throws Exception
	 */
	public int updateReserve(Connection conn, Member member, String busNo, String seatNo) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateReserve");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, busNo);
			pstmt.setString(2, busNo);
			pstmt.setString(3, busNo);
			pstmt.setString(4, busNo);
			pstmt.setString(5, seatNo);
			pstmt.setString(6, member.getPhoneNum());
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 예약 정보 날려주는 DAO
	 * @param conn
	 * @param phoneNum
	 * @return memResult
	 * @throws Exception
	 */
	public int deleteReserve(Connection conn, String phoneNum) throws Exception {
		int memResult = 0;
		
		try {
			String sql = prop.getProperty("deleteReserve");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, phoneNum);
			
			memResult = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return memResult;
	}


	
	
	
	
	
	
	
	
	
	
	
}

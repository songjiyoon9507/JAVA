package sjy.busReservation.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	
	private static Connection conn = null;
	
	/** DB 연결 정보를 담고있는 Connection 객체 생성 및 반환 메서드
	 * @return conn
	 */
	public static Connection getConnection() {
		
		try {
			
			if(conn == null || conn.isClosed() ) {
				
				Properties prop = new Properties();
				
				String filePath = JDBCTemplate.class.getResource("/sjy/busReservation/sql/driver.xml").getPath();
				// JDBCTemplate 의 최상위 폴더
				// src/main/java 에서 시작 해서 하위 /edu ...
				// getPath() 경로 얻어오기
				// 절대 경로 얻어와짐
				
				System.out.println(filePath);
				
		    		// C:\workspace\05_Server\JSPProject2\src\main\java\edu\kh\jsp\sql\driver.xml
				// 파일 우클릭 properties 누르면 뜸
						
				// driver.xml 파일 읽어오기
				prop.loadFromXML( new FileInputStream( filePath ) );
				// -> XML 파일에 작성된 내용이 Properties 객체에 모두 저장됨.
				
				// XML에서 읽어온 값을 모두 변수에 저장
				String driver = prop.getProperty("driver");
				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String password = prop.getProperty("password");
				
				// 커넥션 생성
				Class.forName(driver); // Oracle JDBC Driver 객체 메모리 로드
				
				// DriverManager를 이용해 Connection 객체 생성
				conn = DriverManager.getConnection(url, user, password);
				
				// 자동 커밋 비활성화
				conn.setAutoCommit(false);
			}
			
			
		}catch(Exception e) {
			System.out.println("[Connection 생성 중 예외 발생]");
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	/** Connection 객체 자원 반환 메서드
	 * @param conn
	 */
	public static void close(Connection conn) {
		
		try {
			
			if(conn != null && !conn.isClosed()) conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/** Statement(부모), PreparedStatment(자식) 객체 자원 반환 메서드
	 * @param stmt
	 */
	public static void close(Statement stmt) {
		try {
			
			if(stmt != null && !stmt.isClosed()) stmt.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/** ResultSet 객제 자원 반환 메서드
	 * @param rs
	 */
	public static void close(ResultSet rs) {
		try {
			if(rs != null && !rs.isClosed()) rs.close(); 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 트랜잭션 Commit 메서드
	 * @param conn
	 */
	public static void commit(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed() ) conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 트랜잭션 Rollback 메서드
	 * @param conn
	 */
	public static void rollback(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed() ) conn.rollback();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

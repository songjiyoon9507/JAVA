package edu.kh.jdbc.common;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	
	/* DB 연결 (Connection 생성) + 자동 커밋 off , JDBC 객체 자원 반환(close)
	 * (원하지 않을 때 commit 되면 안됨)
	 * 트랜잭션 제어 commit 하고 싶을 때 commit , rollback  하고 싶을 때 rollback
	 * 
	 * 이러한 JDBC에서 반복 사용되는 코드를 모아둔 클래스
	 * 
	 * * 모든 필드, 메서드가 static *
	 * -> 어디서든지 클래스명.필드명 / 클래스명.메서드명 호출 가능
	 * -> 별도 객체 생성 X
	 * 
	 * */
	
	private static Connection conn = null;
	
	/** DB 연결 정보를 담고있는 Connection 객체 생성 및 반환 메서드
	 * @return conn
	 */
	public static Connection getConnection() {
		// JDBCTemplate 에 있는 getConnection 메서드 부르면 driver 연결해서
		// 계정에 접속한 connection 객체 생성한 걸 반환해줌
		// autoCommit 꺼져있음
		try {
			
			// 현재 커넥션 객체가 없을 경우 -> 새 커넥션 객체 생성
			// 여러 개 만들면 안됨
			if(conn == null || conn.isClosed()) {
				// conn.isClosed() : 커넥션이 close 상태면 true 반환
				
				Properties prop = new Properties();
				// 읽어와야 하니까 일단 prop 객체 생성
				// Map <String, String> 형태의 객체, XML 입출력에 특화되어있는 객체
				
				// driver.xml 파일 읽어오기
				prop.loadFromXML(new FileInputStream("driver.xml"));
				// -> xml 파일에 작성된 내용이 Properties 객체에 모두 저장됨.
				
				// driver.xml 파일과 연결해서 prop 에 key value 형식으로 저장
				
				// XML에서 읽어온 값을 모두 변수에 저장
				
				// LoadXMLFile 에서 했던 거 그대로 해주면 됨
				String driver = prop.getProperty("driver");
				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String password = prop.getProperty("password");
				
				// 커넥션 생성
				
				// Oracle JDBC Driver 객체 메모리 로드
				Class.forName(driver);
				
				// DriverManager 통해 Connection 객체 생성
				conn = DriverManager.getConnection(url, user, password);
				
				// 자동 commit 비활성화
				// Connection 이 해주는 일
				conn.setAutoCommit(false);
			}
			
		} catch(Exception e) {
			System.out.println("[Connection 생성 중 예외 발생]");
			e.printStackTrace();
		}
		
		return conn;
	}

	/** Connection 객체 자원 반환 메서드
	 * @param conn
	 */
	public static void close(Connection conn) {
		// 다 쓴 자원 반환해주는 메서드
		// 코드에서 사용하고 있던 Connection 을 매개변수로 받아서 닫아줌
		try {
			// 전달받은 Conn 이
			// 참조하는 Connection 객체가 있고
			// 그 Connection 객체가 close 상태가 아니라면
			// 자원 반환 할 거
			if(conn != null && !conn.isClosed()) conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// ResultSet 이나 Statement 는 필요한 java 클래스 내에서 객체를 만들어서 쓸거임
	// 자원 반환하는 메서드만
	
	/** Statement, PreparedStatement 객체 자원 반환 메서드
	 * PreparedStatement 는 Statement 자식
	 * 다형성의 업캐스팅 적용 됨
	 * @param stmt
	 */
	public static void close(Statement stmt) {
		// conn 과 타입 다름 오버로딩 적용
		try {
			if(stmt != null && !stmt.isClosed()) stmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** ResultSet 객체 자원 반환 메서드
	 * @param rs
	 */
	public static void close(ResultSet rs) {
		try {
			if(rs != null && !rs.isClosed()) rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// commit, rollback 에 대한 메서드
	// 커밋 롤백도 커넥션이 함
	// 자동 커밋 connection 이 함
	
	/** 트랜잭션 commit 메서드
	 * @param conn
	 */
	public static void commit(Connection conn) {
		try {
			// commit 할 때 SQLException 발생
			if(conn != null && !conn.isClosed()) conn.commit();
			// connection 을 통해서 commit 하겠다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 트랜잭션 rollback 메서드
	 * @param conn
	 */
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package litis.dao;

import static litis.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import litis.vo.Organization;

public class OrganizationDAO {
	// JDBC 객체 참조변수 선언
	private Statement stmt;
	private ResultSet rs;
	
	private Properties prop;
	// query 가져와서 저장
	
	public OrganizationDAO() {
		
		try {
			prop = new Properties();
			
			prop.loadFromXML( new FileInputStream("query.xml"));
			// key value 형식으로 파일 로드해서 저장
			// key value 묶어서 prop 에 저장해둠
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Organization> selectAll(Connection conn) throws Exception {
		
		// 결과 저장용 변수 선언
		List<Organization> list = new ArrayList<Organization>();
		
		// Exception view 까지 던질 거임
		// View 단에서 try catch 구문 작성해둠
		
		try {
			
			// SQL 가져오기
			String sql = prop.getProperty("selectAll");
			
			// service 에서 전달 받아온 Connection 객체
			// Statement 객체 생성 (버스 먼저 만들고 승객 보내야함)
			stmt = conn.createStatement();
			
			// SQL을 수행 후 결과(ResultSet) 반환 받음
			rs = stmt.executeQuery(sql);

			// 조회 결과를 얻어와 한 행씩 접근하여
			// Employee 객체를 생성 후 컬럼값 담기
			// -> List 담기
			while(rs.next()) { // rs.next() 다음 행이 있으면 true, 없으면 false
				
				int orgNo = rs.getInt("ORG_NO");
				// EMP_ID 컬럼은 문자열 컬럼이지만
				// 저장된 값들은 모두 숫자 형태
				// -> DB에서 자동으로 형변환 진행해서 얻어옴
				String orgName = rs.getString("ORG_NAME");
				int parentOrgNo = rs.getInt("PARENT_ORG_NO");
				String orgNoDelFl = rs.getString("ORG_NO_DEL_FL");

				Organization org = new Organization(orgNo, orgName, parentOrgNo, orgNoDelFl);
				list.add(org); // List 담기
			} // while 문 종료
			
		} finally {
			// 사용한 JDBC 객체 자원 반환
			close(rs);
			close(stmt);
			// JDBCTemplate 에 메서드 만들어둔 거 사용해서 닫기
		}
		return list;
	}
}

package edu.kh.jdbc.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class LoadXMLFile {
	
	// 외부 파일 내용 읽어오기
	// XML 읽어오는 기능을 가진 파일
	public static void main(String[] args) {
		
		// XML 파일 읽어오기 (Properties, FileInputStream)
		try {
			Properties prop = new Properties();
			// XML 파일 읽어올 때 Properties 객체 필요함
			
			// driver.xml 파일을 읽어오기 위한 InputStream 객체 생성
			FileInputStream fis = new FileInputStream("driver.xml");
			// 읽어올 파일 명
			
			// 연결된 driver.xml 파일에 있는 내용을 모두 읽어와서
			// Properties 객체에 K:V 형식으로 저장해줄 거
			prop.loadFromXML(fis);
			// fis 가 연결하고 있는 xml 파일 안에 내용들을
			// key value 형식으로 prop 에 저장됨
			
			System.out.println(prop);
			// << 출력 결과 >>
			/*
			{password=kh1234, driver=oracle.jdbc.driver.OracleDriver,
			user=kh_sjy, url=jdbc:oracle:thin:@localhost:1521:XE}
			*/
			// Key = Value 형식으로 Properties 객체 안에 저장되어 있음
			
			// prop.getProperty("key") : key 가 일치하는 속성(데이터 == Value) 을 얻어옴
			
			/*
			String driver = prop.getProperty("driver");
			// -> oracle.jdbc.driver.OracleDriver
			
			String url = prop.getProperty("url");
			// -> jdbc:oracle:thin:@localhost:1521:XE
			
			String user = prop.getProperty("user");
			// -> kh_sjy
			
			String password = prop.getProperty("password");
			// -> kh1234
			*/
			
			Class.forName(prop.getProperty("driver"));
			
			Connection conn = DriverManager.getConnection(prop.getProperty("url"),
					prop.getProperty("user"), prop.getProperty("password"));
			
			System.out.println(conn);
			// << 출력 결과 >>
			// oracle.jdbc.driver.T4CConnection@38c6f217
			// connection 잘 연결됨
			
			/* 왜 XML 파일을 이용해서 DB 연결 정보를 읽어와야 할까?
			 * 
			 * 1. 코드 중복 제거
			 * 2. 별도 관리 용도
			 * 3. 재 컴파일을 진행하지 않기 위해서
			 * - 코드가 길수록 컴파일 소요 시간이 크다.
			 * -> 코드 수정으로 인한 컴파일 소요시간을 없앰.
			 * (XML 파일의 내용을 읽어오는 코드만 작성해두면
			 * Java 코드 수정 없이, XML 파일 내용만 수정하면
			 * 재컴파일은 수행되지 않는다. java 코드가 수정된 것이 아니기 때문에)
			 * 
			 * 4. XML 파일에 작성된 문자열 형태를 그대로 읽어오기 때문에
			 *    SQL 작성 시 좀 더 편리해짐.
			 * 
			 * */
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

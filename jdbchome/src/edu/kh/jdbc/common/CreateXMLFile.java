package edu.kh.jdbc.common;

import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Scanner;

public class CreateXMLFile {

	public static void main(String[] args) {
		
		// XML (eXtensible Markup Language) :  단순화된 데이터 기술 형식
		// 확장 가능한 마크업 언어
		// 데이터 저장하고 전송을 쉽게 할 수 있게 해주는 텍스트 기반 형식
		// 쉽게 저장하고 쉽게 불러다 쓸 수 있게 데이터에 집중되어 있는 형태
		// DB 정보, SQL 정보를 담아두려고 함
		
		// 우리가 알고 있는 마크업 언어 -> HTML
		
		// XML도 태그가 적용되어있음
		// <ex key="key">value</ex>
		
		/* XML에 저장되는 데이터 형식 Key : Value 형식이다.
		 * -> Key , Value 모두 String (문자열) 형식이다.
		 * 
		 * XML 은 외부 파일
		 * 
		 * XML 파일을 읽고 쓰기 위한 IO 관련 클래스 필요
		 * ex) FileOutputStream, FileInputStream 
		 * 
		 * 필요한 객체
		 * << Properties 컬렉션 객체 >>
		 * Map 의 후손 객체 중에 있음
		 * 
		 * Map 은 key 와 value로 구성되어있음
		 * 
		 * << Properties >>
		 * 
		 * 키와 값을 String 타입으로 제한한 Map 컬렉션
		 * 주로 Properties는 프로퍼티(*.properties) 파일을 읽어 들일 때 주로 사용
		 * 
		 * 프로퍼티(*.properties) 파일
		 * - 옵션정보, 데이터베이스 연결정보, 국제화(다국어)정보를 기록하여 텍스트 파일로 활용
		 * - 애플리케이션에서 주로 변경이 잦은 문자열을 저장하여 관리하기 때문에
		 *   유지보수를 편리하게 만들어 줌
		 * - 키와 값이 '=' 기호로 연결되어 있는 텍스트 파일로 ISO 8859-1 문자셋으로 저장되고,
		 *   한글은 유니코드(Unicode)로 변환되어 저장
		 * */
		
		// XML 파일을 Properties 와 유사함
		
		// * Properties 컬렉션 객체 *
		// - Map 후손 클래스
		// - Key, Value 모두 String(문자열)
		// - XML 파일을 읽고, 쓰는데 특화된 메서드 제공
		
		try {
			
			// XML 만들기 위한 절차
			// 파일명을 뭘로 만들지 사용자에게 입력 받을 거
			Scanner sc = new Scanner(System.in);
			
			// Properties 객체 생성
			Properties prop = new Properties();
			// key, value 가 모두 String Map 후손
			
			System.out.print("생성할 파일 이름 : ");
			String fileName = sc.next();
			
			// File 생성 => java 내부에서 외부로 출력하는 일 - 파일을 내보내는 일
			// FileOutputStream 생성
			FileOutputStream fos = new FileOutputStream(fileName + ".xml");
			// 입력 받은 fileName.xml 현재 프로젝트 안에 파일이 생성됨
			
			// Properties 객체를 이용해서 XML 파일 생성
			prop.storeToXML(fos, fileName + ".xml file!!!!!");
			// FileOutputStream 객체 통해서 fileName 들어감
//			xml 파일 만들면 안에 comment 라는 주석이 생김
//			<comment>filname.xml file!!!!!</comment> 안에 fileName 들어가 있음
			// 저장한다는 뜻 XML 파일로 저장한다는 뜻
			// fos 이용해서 내부에 태그 안에는 fileName.xml file!!!!
			// 이 구문 지나가야 실제로 xml 파일이 만들어 지는 것
			
			System.out.println(fileName + ".xml 파일 생성 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

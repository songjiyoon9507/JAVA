<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--charset 안 바꾸면 글자 다 깨져서 서로 값 안 맞음 db 연결할 때 오류남 --%>
    <%-- UTF-8 --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입 결과</title>
</head>
<body>
	<%-- JSP용 주석
		
		<%@ %> : 지시자 태그
		jsp 파일의 전반적인 속성을(정보를) 설정하는데 사용하는 태그
	
		자바 코드 쓸려면 필요한 표현식
		
		<% %> : 스크립틀릿 -> 스클립틀릿 태그 사이에는 자바 코드를 작성할 수 있음
		
		<%= %> : JSP 표현식 -> 자바, 서버에서 얻어온 값을 표현(출력)할 때 사용
	
		JSP : Javs Server Page / java 코드가 들어가있는 HTML 코드
		-> 자바에서 만들어주느 페이지 html 처럼 생긴 형식이어도 java 코드 사용할 수 있음
		
	 --%>
	<h3 style="color: pink;"></h3>
	
	<ul>
		<li>id : </li>
		<li>pw : </li>
	</ul>
	
	<h4>자기소개</h4>
	<p></p>
</body>
</html>
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
		if 문 같은 걸 스크립틀릿 안에서 사용할 수 있음
		
		<%= %> : JSP 표현식 -> 자바, 서버에서 얻어온 값을 표현(출력)할 때 사용
		if 문 안됨
		
		JSP : Java Server Page / java 코드가 들어가있는 HTML 코드
		-> 자바에서 만들어주느 페이지 HTML 처럼 생긴 형식이어도 java 코드 사용할 수 있음
		
	 --%>
	 
	 <%-- Controller 에서 JSP 에게 위임할 때 req 에 담은 정보를 JSP 에서 꺼내 쓸 수 있음 --%>
	 
	 <%-- JSP 표현식을 통해서 바꿔줄 것 --%>
	 <%-- req 안에 정보를 꺼내다 쓸 것 --%>
	<h3 style="color: pink;"><%= request.getParameter("inputName") %>님의 가입을 환영합니다.</h3>
	
	<ul>
		<li>id : <%= request.getParameter("inputId") %></li>
		<li>pw : <%= request.getParameter("inputPw") %></li>
	</ul>
	
	<%-- HTML 에서 자기소개 칸에 아무것도 입력하지 않았을 경우 빈문자열이 넘어옴
	NULL 아님 
	빈 문자열일 땐 안 보여주고 문자열이 넘어왔을 때만 보여주게 하려면 if 문 사용해야함
	표현식 아니고 스크립틀릿 사용해야함
	--%>
	
	<% if(!request.getParameter("intro").equals("")) { %>
	<%--빈 문자열이 아니라면 --%>
		<h4>자기소개</h4>
		<p><%= request.getParameter("intro") %></p>
	<% } %>
	
	<%-- 자기소개 작성했을 때
	홍길동님의 가입을 환영합니다.
	id : user01
	pw : pass01
	자기소개
	안녕하세요 홍길동입니다.
	
	자기소개 작성 안했을 때
	홍길동님의 가입을 환영합니다.
	id : user01
	pw : pass01
	 --%>
</body>
</html>
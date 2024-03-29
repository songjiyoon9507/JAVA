<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 가입</title>
	
	<link rel="stylesheet" href="/resources/css/signup.css">
</head>
<body>
	<main>
		<h1>회원가입</h1>
		
		<%-- 유효성 검사 빠짐 --%>
		<form action="/signup" method="post">
			<div>
				<p>이름</p>
				<input type="text" name="inputName" autocomplete="off" required>
			</div>
			
			<div>
				<p>전화번호</p>
				<input type="text" name="inputPhone" autocomplete="off" required>
			</div>
			
			<button>가입하기</button>
		</form>
		
		<c:if test="${not empty sessionScope.message}">
			${message}
			
			<c:remove var="message" scope="session"/>		
		</c:if>
	</main>
	
</body>
</html>
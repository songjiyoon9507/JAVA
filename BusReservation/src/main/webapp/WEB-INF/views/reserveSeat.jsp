<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>좌석 예약</title>
	
	<link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
	<main>
		<h1>좌석 예약하기</h1>
		<c:choose>
			<%-- seatList가 null이 아닐 때 --%>
			<c:when test="${not empty requestScope.seatList}">
	
			<div class="seat">
				<c:forEach var="seat" items="${seatList}">
						<div class="seatNo">
	 						<a href="/reserveSeat?seatNo=${seat.seatNo}">${seat.seatNo}</a>
						</div>
					<%-- <span>${seat.seatNo}</span>	 --%>
				</c:forEach>
			</div>
<!-- 				<form action="/reserveSeat" method="post">
					<p>예약할 좌석 번호 입력</p>
					<input type="number" name="inputSeatNo">
					<div>
						<button>확인</button>
						<a>돌아가기</a>
					</div>		
				</form> -->
			
				<a href="/reserveOut" class="back">돌아가기</a>
				
			</c:when>
			
			<%-- seatList가 null 일 때 --%>
			<c:otherwise>
				남은 좌석이 없습니다.

				<a href="/reserveOut" class="back">돌아가기</a>

			</c:otherwise>
		</c:choose>
		
		<c:if test="${not empty sessionScope.message}">
			${message}
			
			<c:remove var="message" scope="session"/>
		</c:if>
		
	</main>
	

</body>
</html>
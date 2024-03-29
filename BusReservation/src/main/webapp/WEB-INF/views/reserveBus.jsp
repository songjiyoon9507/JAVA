<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>버스 예약</title>
	
	<link rel="stylesheet" href="/resources/css/reserve.css">
</head>
<body>
	<main>
		<h1>버스 시간표</h1>
		
		<table border="1">
		<tr>
			<th>버스번호</th>
			<th>출발지</th>
			<th>도착지</th>
			<th>출발시간</th>
			<th>도착시간</th>
			<th>남은 좌석</th>
		</tr>
		
		<c:forEach var="bus" items="${busList}">		
			<tr>
				<td>${bus.busNo}</td>
				<td>${bus.departures}</td>
				<td>${bus.arrivals}</td>
				<td>${bus.departureTime}</td>
				<td>${bus.arrivalTime}</td>
				<td>${bus.remainSeat}</td>
			</tr>
		</c:forEach>
		
		</table>
		
		<form action="/reserveBus" method="post">
			<p>예약할 버스 번호</p>
			<input type="number" name="inputBusNo">
			
			<div>
				<button>예약하기</button>				
			</div>
			
			<div class="out">
				<a href="/reserveOut">예약 종료</a>			
			</div>
		</form>
		
		<c:if test="${not empty sessionScope.message}">
		${message}
		
		<c:remove var="message" scope="session"/>
	</c:if>
		
	</main>
</body>
</html>
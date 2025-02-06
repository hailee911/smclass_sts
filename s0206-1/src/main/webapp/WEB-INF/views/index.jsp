<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
	</head>
	<body>
		<h2>메인페이지</h2>
		<h4>세션 : ${session_id }</h4>
		<c:if test="${session_id == null }">
			<ul><a href="/login">로그인</a></ul>
			<ul><a href="/member">회원가입</a></ul>
		</c:if>
		<c:if test="${session_id != null }">
		<ul><a href="/logout">로그아웃</a></ul>
		<ul><a href="/board">게시판</a></ul>
		<ul><a href="/memInfo">회원정보</a></ul>
		</c:if>
	</body>
</html>
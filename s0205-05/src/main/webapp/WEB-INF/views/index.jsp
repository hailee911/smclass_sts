<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지2</title>
	</head>
	<body>
		<h2>메인페이지2</h2>
		<div>세션아이디 : ${session_id}</div>
		<ul><a href="/login">로그인</a></ul>
		<ul><a href="/logout">로그아웃</a></ul>
	
	</body>
</html>
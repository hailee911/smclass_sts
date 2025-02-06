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
		<ul><a href="/login">로그인</a></ul>
		<ul><a href="#">회원가입</a></ul>
		<ul><a href="/board?bno=1&btitle=이벤트안내">게시판</a></ul>
		<ul><a href="/stuInput">학생성적입력</a></ul>
	</body>
</html>
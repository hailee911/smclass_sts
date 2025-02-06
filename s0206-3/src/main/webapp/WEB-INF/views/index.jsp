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
		<ul><a href="/member">회원정보</a></ul>
		<ul><a href="stuInput">학생성적입력</a></ul>
		<ul><a href="/data?bno=10">데이터전달1</a></ul>
		<ul><a href="/data2/100">데이터전달2</a></ul>
		<ul><a href="/data3/1,2,3">데이터전달3</a></ul>
		<ul><a href="/data4">데이터전달-객체(list)</a></ul>
	</body>
</html>
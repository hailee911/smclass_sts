<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>board정보</title>
		<style>
		  h2{text-align: center;}
		  table,th,td{border:1px solid black; border-collapse: collapse;}
		  table{text-align: center; width:700px; margin:0 auto;}
		  th,td{height:40px; }
		  div{text-align: center; margin-top: 20px;}
		</style>
	</head>
	<body>
	  <h2>board정보</h2>
	  <table>
	    <colgroup>
	      <col width="50%">
	      <col width="50%">
	    </colgroup>
	    <tr>
	      <th>페이지번호</th>
	      <th>제목</th>
	    </tr>
	    <tr>
	      <td>${bno }</td>
	      <td>${btitle }</td>
	    </tr>
	  </table>
	 
	   <div><a href="/">메인페이지 이동</a></div>
	
	</body>
</html>
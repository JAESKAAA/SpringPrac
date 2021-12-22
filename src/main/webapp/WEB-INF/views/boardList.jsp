<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="loginOutLink" value="${sessionScope.id==null ? '/login/login' : '/login/logout' }"/>
<c:set var="loginOut" value="${sessionScope.id==null ? 'login' : 'logout' }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>BoardList</title>
	<link rel="stylesheet" href="<c:url value='/css/menu.css'/>" />
</head>
<body>

	<div id="menu">
		<ul>
			<li id="logo">jaeskaaa</li>
			<li><a href="<c:url value='/'/>">home</a></li>
			<li><a href="<c:url value='/board/list'/>">Board</a></li>
	   		<li><a href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>    
			<li><a href="<c:url value='/register/add'/>">Sign in</a></li>
			<li><a href=""><i class="fas fa-search small"></i></a></li>
		</ul>
	</div>
	<div style="text-align:center">
		<h1>보드 게시글 예정입니다 1</h1>
		<h1>보드 게시글 예정입니다 2</h1>
		<h1>보드 게시글 예정입니다 3</h1>
		<h1>보드 게시글 예정입니다 4</h1>
		<h1>보드 게시글 예정입니다 5</h1>
	</div>

</body>
</html>
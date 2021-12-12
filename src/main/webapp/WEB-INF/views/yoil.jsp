<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h2> year = ${param.year}</h2>

<h1> ${myDate.year}년 ${myDate.month}월 ${myDate.date}일은 ${yoil}요일 입니다. </h1>
</body>
</html>

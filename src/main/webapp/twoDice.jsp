<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>
    <%-- <%! 클래스영역!! %> --%>
    <%! 
    	int getRandomInt(int range){
    		return new Random().nextInt(range)+1;
    	}
    %>
    <%-- <% 메서드 영역 - service()의 내부로 들어감 %> --%>
    <%
    	int idx1 = getRandomInt(6);
    	int idx2 = getRandomInt(6);
    %>
<!DOCTYPE html>
<html>
<head>
<title>twoDice.jsp</title>
</head>
<body>
	<img src='resources/img/dice<%=idx1%>.jpg' >
	<img src='resources/img/dice<%=idx2%>.jpg' >
</body>
</html>
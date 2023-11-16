<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String deck_id = (String)request.getAttribute("deck_id");
%>
<%
String errorMsg = (String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カード作成</title>
</head>
<body>
	<form action="/tangoChou/CardServlet" method="post">
		問題<input type="text" name="question"><br>
		答え<input type="text" name="answer"><br>
		<input type="hidden" name="deck_id" value="<%= deck_id %>">
		<input type="submit" value="作成">
	</form>
	<% if(errorMsg != null) { %>
		<p><%= errorMsg %></p>
	<% } %>
</body>
</html>
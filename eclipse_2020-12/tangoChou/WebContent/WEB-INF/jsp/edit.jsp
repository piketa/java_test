<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Card" %>
<%
Card card = (Card)request.getAttribute("card");
%>
<%
String card_id = (String)request.getAttribute("card_id");
%>
<%
String errorMsg = (String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集</title>
</head>
<body>
	<form action="/tangoChou/Edit" method="post">
		問題<input type="text" name="question" value="<%= card.getQuestion() %>"><br>
		答え<input type="text" name="answer" value="<%= card.getAnswer() %>"><br>
		<input type="hidden" name="card_id" value="<%= card_id %>">
		<input type="submit" value="更新">
	</form>
	<% if(errorMsg != null) { %>
		<p><%= errorMsg %></p>
	<% } %>
</body>
</html>
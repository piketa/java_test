<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Card" %>
<%@ page import="java.util.List,java.util.ArrayList" %>
<%
List<Card> cards = (List<Card>) request.getAttribute("cards");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>テスト</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
	<% for(Card card : cards) { %>
		<p><%= card.getQuestion() %></p>
		<p><%= card.getAnswer() %></p>
		<p><%= card.getCount() %></p>
	<% } %>
	<p><a href="/tangoChou/">終了</a></p>
	<script src="/tangoChou/js/test.js"></script>
</body>
</html>
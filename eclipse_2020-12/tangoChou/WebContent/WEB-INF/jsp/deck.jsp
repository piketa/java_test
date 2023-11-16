<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Card" %>
<%@ page import="java.util.List,java.util.ArrayList" %>
<%
String deck_id = (String)request.getAttribute("deck_id");
%>
<%
List<Card> cards = (List<Card>) request.getAttribute("cards");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>デッキ</title>
</head>
<body>
	<% for(Card card : cards) { %>
		<p>問題：<%= card.getQuestion() %>：<%= card.getCount() %></p>
		<p>答え：<%= card.getAnswer() %></p>
		<p><a href="/tangoChou/Edit?id=<%= card.getId() %>">編集</a></p>
	<% } %>
	<p><a href="/tangoChou/CardServlet?deck_id=<%= deck_id %>">+カードを追加</a></p>
	<p><a href="/tangoChou/">戻る</a><p>
</body>
</html>
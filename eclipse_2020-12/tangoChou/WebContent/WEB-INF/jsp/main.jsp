<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Deck" %>
<%@ page import="java.util.List,java.util.ArrayList" %>
<%
List<Deck> decks = (List<Deck>) request.getAttribute("decks");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メイン</title>
</head>
<body>
	<% for(Deck deck : decks) { %>
		<% if(deck.getDate() == null ) { %>
			<p><a href="/tangoChou/DeckServlet?id=<%= deck.getId() %>">1日1回</a>:
			<a href="/tangoChou/Test?id=<%= deck.getId() %>">テストスタート</a></p>
		<% }else { %>
			<p><a href="/tangoChou/DeckServlet?id=<%= deck.getId() %>"><%= deck.getDate() %></a></p>
		<% } %>
	<% } %>
	<p><a href="/tangoChou/Login?logout=logout">ログアウト</a></p>
</body>
</html>
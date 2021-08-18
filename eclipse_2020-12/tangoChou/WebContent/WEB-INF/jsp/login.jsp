<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/tangoChou.css">
</head>
<body>
	<h2>ログインしてください</h2>
	<form action="/tangoChou/Login" method="post">
		メールアドレス<input type="email" name="email"><br>
		パスワード<input type="password" name="pass"><br>
		<input type="submit" value="ログイン">
	</form>
	<% if(errorMsg != null) { %>
		<p><%= errorMsg %></p>
	<% } %>
	<p>アカウントをお持ちでないですか？<a href="/tangoChou/Signup">登録する</a></p>
</body>
</html>
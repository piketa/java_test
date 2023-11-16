<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>サインアップ</title>
</head>
<body>
	<h2>新規アカウントを作成</h2>
	<form action="/tangoChou/Signup" method="post">
		メールアドレス<input type="email" name="email"><br>
		パスワード<input type="password" name="pass"><br>
		パスワード確認<input type="password" name="verify"><br>
		<input type="submit" value="登録">
	</form>
	<% if(errorMsg != null) { %>
		<p><%= errorMsg %></p>
	<% } %>
	<p>アカウントをお持ちですか？<a href="/tangoChou/Login">ログイン</a><p>
</body>
</html>
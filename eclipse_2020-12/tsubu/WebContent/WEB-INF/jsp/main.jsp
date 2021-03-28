<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>じじばばつぶ</title>
</head>
<body>
<h1>じじばばつぶメイン</h1>
<p>
<c:out value="${loginUser.name}"/>さん、ログイン中
<a href="/tsubu/Logout">ログアウト</a>
</p>
<p><a href="/tsubu/Main">更新</a>
<form action="/tsubu/Main" method="post">
<input type="text" name="text">
<input type="submit" value="つぶやく">
</form>
<c:if test="${not empty errorMsg}">
	<p>${errorMsg}</p>
</c:if>
<c:forEach var="mutter" items="${mutterList}">
	<p><c:out value="${mutter.userName}"/>:
		<c:out value="${mutter.text}" /></p>
</c:forEach>
</body>
</html>
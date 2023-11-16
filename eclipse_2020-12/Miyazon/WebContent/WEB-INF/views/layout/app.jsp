<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Miyazon</title>
<link rel="stylesheet" href="<c:url value='/css/reset.css' />">
<link rel="stylesheet" href="<c:url value='/css/style.css' />">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<div id="header_menu">
				<h1>
					<a href="<c:url value='/toppage' />">Miyazon</a>
				</h1>
			</div>
			<c:if test="${sessionScope.login_UserID != null}">
				<div id="User_name">
					<c:out value="${sessionScope.login_User.name}" />
					&nbsp;さん&nbsp;&nbsp;&nbsp; <a href="<c:url value='/logout' />">ログアウト</a>
				</div>
			</c:if>
		</div>
		<div id="content">${param.content}</div>
		<div id="footer">Miyazon</div>
	</div>
</body>
</html>

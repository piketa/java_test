<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<header id="login">
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
					<a href="/Miyazon/toppage">Miyazon</a>
				</h1>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<c:if test="${login_user.admin_flag == 1}">
					<a href="/Miyazon/listing/new">商品登録へ</a>
				</c:if>
				&nbsp; <a href="/Miyazon/cart/index">カートの中身</a>&nbsp; &nbsp; <a
					href="/Miyazon/purchase/index">購入履歴</a>&nbsp;
			</div>
			<div id="User_name">
				<a href="/Miyazon/Users/edit"><c:out
						value="${sessionScope.login_user.name}" /></a>
				&nbsp;さん&nbsp;&nbsp;&nbsp;<a href="/Miyazon/logout">ログアウト</a>
			</div>
		</div>
		<div id="content">
			<c:if test="${flush != null}">
				<div id="flush_success">
					<c:out value="${flush}"></c:out>
				</div>
			</c:if>
			<h2>Miyazonへようこそ</h2>
			<h2>商品一覧</h2>
			<table>
				<tbody>
					<tr>
						<th>商品名</th>
						<th>出品者</th>
						<th>商品画像</th>
						<th>価格</th>
					</tr>
					<c:forEach var="item" items="${listing}">
						<tr>
							<td><a href="<c:url value="/listing/show?id=${item.id}" />">
									<c:out value="${item.product_name}" /></a></td>
							<td><c:out value="${item.user.name}" /></td>
							<td><c:choose>
									<c:when test="${item.image != null}">
										<img src="/Miyazon/uploads/${item.image}" style="width: 30%">
									</c:when>
									<c:otherwise>
									画像はありません。
									</c:otherwise>
								</c:choose></td>
							<td>&yen;<fmt:formatNumber value="${item.price}"
									type="currency" currencySymbol="" maxFractionDigits="0" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div id="footer">Miyazon</div>
	</div>
</body>
	</html>
</header>
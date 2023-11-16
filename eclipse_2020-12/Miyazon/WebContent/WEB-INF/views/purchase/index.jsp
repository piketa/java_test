<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
					<a href="/Miyazon/toppage">Miyazon</a>
				</h1>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<c:if test="${login_user.admin_flag == 1}">
					<a href="/Miyazon/listing/new">商品登録へ</a>
				</c:if>
				&nbsp; <a href="/Miyazon/cart/index">カートの中身</a>&nbsp; <a
					href="/Miyazon/purchase/index">購入した商品</a>&nbsp;
			</div>
			<div id="User_name">
				<c:out value="${sessionScope.login_user.name}" />
				&nbsp;さん&nbsp;&nbsp;&nbsp;<a href="/Miyazon/logout">ログアウト</a>
			</div>
		</div>
		<h2>購入履歴</h2>
		<table>
			<tbody>
				<tr>
					<th>商品名</th>
					<th>単価</th>
					<th>個数</th>
					<th>合計金額</th>
					<th>支払い方法</th>
					<th>購入日時</th>
				</tr>
				<c:forEach var="purchase" items="${myPurchaseList}">
					<tr>
						<td><a href="<c:url value="/listing/show?id=${purchase.listing.id}" />"><c:out
									value="${purchase.listing.product_name}" /></a></td>
						<td>&yen;<fmt:formatNumber value="${purchase.listing.price}"
								type="currency" currencySymbol="" maxFractionDigits="0" /></td>
						<td><c:out value="${purchase.number}" />個</td>
						<td>&yen;<fmt:formatNumber
								value="${purchase.number * purchase.listing.price}" type="currency"
								currencySymbol="" maxFractionDigits="0" /></td>
						<td><c:out value="${purchase.pay_method}" /></td>
						<td><fmt:formatDate value="${purchase.created_at}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<p>
			<a href="<c:url value="/toppage" />">トップページに戻る</a>
		</p>
	</div>
	<div id="footer">Miyazon</div>
</body>
</html>
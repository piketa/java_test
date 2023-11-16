<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
					<a href="/Miyazon/toppage">Miyazon</a>
				</h1>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<c:if test="${login_user.admin_flag == 1}">
					<a href="/Miyazon/listing/new">商品登録へ</a>
				</c:if>
				&nbsp; <a href="/Miyazon/cart/index">カートの中身</a>&nbsp; <a
					href="/Miyazon/purchase/index">購入履歴</a>&nbsp;
			</div>
			<div id="User_name">
				<c:out value="${sessionScope.login_user.name}" />
				&nbsp;さん&nbsp;&nbsp;&nbsp;<a href="/Miyazon/logout">ログアウト</a>
			</div>
		</div>
		<h2>カートの中身一覧</h2>
		<table>
			<tbody>
				<tr>
					<th>商品名</th>
					<th>個数</th>
					<th>価格</th>
					<th>購入操作</th>
					<th>削除</th>
				</tr>
				<c:forEach var="cart_status" items="${my_cart}">
					<form action="/Miyazon/purchase/confirm" method="POST">
						<tr>
							<td><c:out value="${cart_status.listing.product_name}" /></td>
							<td><input type="number" name="number"
								value="${cart_status.number}" min="1"
								max="${cart_status.listing.stock}"
								value="<c:out value="${cart_status.number}" />"></td>
							<td>&yen;<fmt:formatNumber
									value="${cart_status.listing.price}" type="currency"
									currencySymbol="" maxFractionDigits="0" /></td>

							<td><input type="hidden" name="cart_id"
								value="<c:out value="${cart_status.id}"/>"> <input
								type="submit" value="購入"></td>
					</form>
					<form method="POST"
						action="${pageContext.request.contextPath}/cart/destroy">
						<input type="hidden" name="_token" value="${_token}" />
						<td><input type="hidden" name="cart_id"
                         value="<c:out value="${cart_status.id}"/>">
							<input type="submit" value="カートの中身を削除"></td>
					</form>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
		function confirmDestroy() {
			if (confirm("本当に削除してよろしいですか？")) {
				document.forms[1].submit();
			}
		}
	</script>
	<div id="footer">Miyazon</div>
</body>
</html>
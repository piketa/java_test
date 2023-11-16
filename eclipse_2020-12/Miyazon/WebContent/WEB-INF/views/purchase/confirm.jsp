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
		<h3>商品情報</h3>
		<table>
			<tbody>
				<tr>
					<th>商品画像</th>
					<td><c:choose>
							<c:when test="${listing.image != null}">
								<img src="/Miyazon/uploads/${listing.image}" style="width: 10%">
							</c:when>
							<c:otherwise>
                                   画像はありません。
                             </c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<th>商品名</th>
					<td><c:out value="${purchase.listing.product_name}" /></td>
				</tr>
				<tr>
					<th>カテゴリー</th>
					<td><c:out value="${purchase.listing.category}" /></td>
				</tr>
				<tr>
					<th>出品者</th>
					<td><c:out value="${purchase.listing.user.name}" /></td>
				</tr>
				<tr>
					<th>価格</th>
					<td>&yen;<fmt:formatNumber value="${purchase.listing.price}"
							type="currency" currencySymbol="" maxFractionDigits="0" /></td>
				</tr>
				<tr>
					<th>個数</th>
					<td><c:out value="${purchase.number}" />個</td>
				</tr>
				<tr>
					<th>合計金額</th>
					<td>&yen;<fmt:formatNumber
							value="${purchase.listing.price *  purchase.number}"
							type="currency" currencySymbol="" maxFractionDigits="0" /></td>
				</tr>

			</tbody>
		</table>
		<br> <br>

		<h3>お客様情報</h3>
		<table>
			<tbody>
				<tr>
					<th>お名前</th>
					<td><c:out value="${purchase.user.name}" /></td>
				</tr>
				<tr>
					<th>性別</th>
					<td><c:out value="${purchase.user.sex}" /></td>
				</tr>
				<tr>
					<th>住所</th>
					<td><c:out value="${purchase.user.address}" /></td>
				</tr>
				<tr>
					<th>電話番号</th>
					<td><c:out value="${purchase.user.tel}" /></td>
				</tr>
				<tr>
					<th>お誕生日</th>
					<td><c:out value="${purchase.user.birthday}" /></td>
				</tr>
			</tbody>
		</table>
		<br> <br>

		<h3>お支払情報</h3>
		<form action="<c:url value='/purchase/create' />" method="POST">
			<table>
				<tbody>
					<tr>
						<th>クレジットカード会社</th>
						<td><c:out value="${purchase.user.credit_card_company}" /></td>
					</tr>
					<tr>
						<th>クレジットカード番号</th>
						<td><c:out value="${purchase.user.credit_card_number}" /></td>
					</tr>
					<tr>
						<th>金融機関名</th>
						<td><c:out value="${purchase.user.bank_name}" /></td>
					</tr>
					<tr>
						<th>支店名</th>
						<td><c:out value="${purchase.user.branch_name}" /></td>
					</tr>
					<tr>
						<th>口座種類</th>
						<td><c:out value="${purchase.user.account_type}" /></td>
					</tr>
					<tr>
						<th>口座番号</th>
						<td><c:out value="${purchase.user.account_number}" /></td>
					</tr>
					<tr>
						<th>支払い方法選択</th>
						<td><input type="radio" name="pay_method" value="クレジットカード"
							required checked> クレジットカード <input type="radio"
							name="pay_method" value="銀行振込" required>銀行振込</td>
					</tr>

				</tbody>
			</table>
			<br> <br>
			<button type="submit">購入決定</button>
			<button type="button" onclick="history.back()">戻る</button>
		</form>
		<p>
			<a href="<c:url value="/toppage" />">トップページに戻る</a>
		</p>
	</div>
	<div id="footer">Miyazon</div>
</body>
</html>
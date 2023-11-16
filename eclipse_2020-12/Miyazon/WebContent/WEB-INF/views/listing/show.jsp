<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/layout/app.jsp">
	<c:param name="content">
		<c:choose>
			<c:when test="${listing != null}">
				<h2>商品ページ</h2>
				<table>
					<tbody>
						<tr>
							<th>商品名</th>
							<td><c:out value="${listing.product_name}" /></td>
						</tr>
						<tr>
							<th>商品画像</th>
							<td><c:choose>
									<c:when test="${listing.image != null}">
										<img src="/Miyazon/uploads/${listing.image}"
											style="width: 30%">
									</c:when>
									<c:otherwise>
                                    画像はありません。
                                </c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<th>商品カテゴリー</th>
							<td><c:out value="${listing.category}" /></td>
						</tr>
						<tr>
							<th>価格</th>
							<td>&yen;<fmt:formatNumber value="${listing.price}"
									type="currency" currencySymbol="" maxFractionDigits="0" /></td>
						</tr>
						<tr>
							<th>在庫数</th>
							<td><c:out value="${listing.stock}" /></td>
						</tr>
						<tr>
							<th>商品説明</th>
							<td><c:out value="${listing.introduction}" /></td>
						</tr>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<h2>お探しのデータは見つかりませんでした。</h2>
			</c:otherwise>
		</c:choose>
		<br>
		<c:if test="${sessionScope.login_user.ID != listing.user.ID}">
			<c:choose>
				<c:when test="${listing.stock > 0}">
					<form method="POST"
						action="${pageContext.request.contextPath}/cart/create">
						個数<br> <input type="number" name="number" min="1"
							max="${listing.stock}"> <br> <input type="hidden"
							name="_token" value="${_token}" /> <br> <input
							type="submit" value="カートに追加する">
					</form>
				</c:when>
				<c:otherwise>
					<p>在庫切れです</p>
				</c:otherwise>
			</c:choose>
		</c:if>
		<br>
		<script>
			function confirmDestroy() {
				if (confirm("本当に削除してよろしいですか？")) {
					document.forms[1].submit();
				}
			}
		</script>
		<p>
			<a href="<c:url value="/toppage" />">トップページに戻る</a>
		</p>
	</c:param>
</c:import>

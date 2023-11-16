<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${errors != null}">
	<div id="flush_error">
		入力内容にエラーがあります。<br />
		<c:forEach var="error" items="${errors}">
 ・<c:out value="${error}" />
			<br />
		</c:forEach>
	</div>
</c:if>
<label for="listing_id">商品</label>
<br />
<input type="text" name="listing_id" value="${listing.product_name}" />
<br />
<br />
<label for="category">商品カテゴリー</label>
<br />
<input type="text" name="category" value="${listing.category}" />
<br />
<br />
<label for="price">価格</label>
<br />
<input type="text" name="price" value="${listing.price}" />
<br />
<br />
<label for="number">個数</label>
<br />
<input type="text" name="number" value="${cart.number}" />
<br />
<br />
<label for="image">商品画像</label>
<br />
<input type="file" name="image" />
<br />
<br />
<input type="hidden" name="_token" value="${_token}" />
<button type="submit">商品購入画面へ</button>
<br />
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
<label for="product_name">商品名</label>
<br />
<input type="text" name="product_name" value="${listing.product_name}" />
<br />
<br />
<label for="category">商品カテゴリー</label>
<br />
<form method="POST" action="/listing/create "
	enctype="multipart/form-data">
	<select name="category">
		<option value="家電">家電</option>
		<option value="食品">食品</option>
		<option value="スポーツ・アウトドア">スポーツ・アウトドア</option>
		<option value="パソコン・周辺機器">パソコン・周辺機器</option>
		<option value="キッズ・ベビー・マタニティ">キッズ・ベビー・マタニティ</option>
		<option value="水・ソフトドリンク">水・ソフトドリンク</option>
		<option value="インテリア・寝具・収納">インテリア・寝具・収納</option>
		<option value="その他">その他</option>
	</select><br> <br /> <label for="price">価格</label> <br /> <input
		type="text" name="price" value="${listing.price}" /> <br /> <br />
	<label for="stock">在庫数</label> <br /> <input type="text" name="stock"
		value="${listing.stock}" /> <br /> <br /> <label for="image">商品画像</label>
	<br /> <input type="file" name="image" /> <br /> <br /> <label
		for="introduction">商品説明</label> <br />
	<textarea name="introduction" rows="10" cols="50">${listing.introduction}</textarea>
	<br /> <br /> <input type="hidden" name="_token" value="${_token}" />
	<button type="submit">商品登録</button>
</form>
<br />
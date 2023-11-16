<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/layout/app.jsp">
	<c:param name="content">
		<c:if test="${flush != null}">
			<div id="flush_success">
				<c:out value="${flush}"></c:out>
			</div>
		</c:if>
		<h2>商品一覧</h2>
		<table id="listing_list">
			<tbody>
				<tr>
					<th class="product_name">商品名</th>
					<th class="category">商品カテゴリー</th>
					<th class="image">商品画像</th>
					<th class="introduction">商品紹介</th>
				</tr>
				<c:forEach var="listing" items="${listing}" varStatus="status">
					<tr class="row${status.count % 2}">
						<td class="name"><c:out value="${listing.name}" /></td>
						<td class="listing_title">${listing.title}</td>
						<td class="listing_action"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div id="pagination">
			（全 ${listings_count} 件）<br />
			<c:forEach var="i" begin="1" end="${((listings_count - 1) / 15) + 1}"
				step="1">
				<c:choose>
					<c:when test="${i == page}">
						<c:out value="${i}" />&nbsp;
 </c:when>
					<c:otherwise>
						<a href="<c:url value='/listing/index?page=${i}' />"><c:out
								value="${i}" /></a>&nbsp;
 </c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
		<div>
			<p>
				<a href="<c:url value='/listing/new' />">商品の登録</a>
			</p>
		</div>
	</c:param>
</c:import>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/layout/app.jsp">
	<c:param name="content">
		<c:choose>
			<c:when test="${login_user != null}">
				<h2><c:out value="${sessionScope.login_user.name}" />さんの会員情報 編集ページ</h2>
				<form method="POST" action="<c:url value='/users/update' />">
					<c:import url="_form2.jsp" />
				</form>

				<P>
					<a href="#" onclick="confirmDestroy();">退会手続き</a>
				</P>
				<form method="POST" action="<c:url value='/users/destroy' />">
					<input type="hidden" name="_token" value="${_token}" />
				</form>

				<script>
					function confirmDestroy() {
						if (confirm("本当に退会してよろしいですか？")) {
							document.forms[1].submit();
						}
					}
				</script>
			</c:when>
			<c:otherwise>
				<h2>お探しのデータは見つかりませんでした。</h2>
			</c:otherwise>
		</c:choose>

		<P>
			<a href="<c:url value='/toppage' />">一覧に戻る</a>
		</P>
	</c:param>
</c:import>
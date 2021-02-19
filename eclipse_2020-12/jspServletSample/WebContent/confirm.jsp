<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	String Name = request.getAttribute("fromName").toString();
	String Old = request.getAttribute("fromOld").toString();
	String Gender_select = request.getAttribute("fromGender_select").toString();
	String Gender = request.getAttribute("fromGender").toString();
%>
<title>確認画面</title>
</head>
<body>

	<div align="center">会員登録</div>
	<div align="center">氏名<%=Name%></div>
	<div align="center">年齢<%=Old%></div>
	<div id="Gender_select" align="center">性別<%=Gender_select%></div>
	<div id="Gender" align="center">カスタム<%=Gender%></div>


	<script>
		if (Gender == null) {
			document.getElementById("Gender").style.display = "none";
			document.getElementById("Gender_select").style.display = "block";
		} else {
			document.getElementById("Gender").style.display = "block";
			document.getElementById("Gender_select").style.display = "none";
		}
	</script>



	<div align="center">
		<form action="/jspServletSample/member.jsp" method="post">
			<input type="submit" value="戻る">
		</form>
	</div>
	<div align="center">
		<form action="/jspServletSample/complete.jsp">
			<input type="submit" value="登録">
		</form>
	</div>
</body>
</html>
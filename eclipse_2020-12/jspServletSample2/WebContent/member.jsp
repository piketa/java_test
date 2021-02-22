<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メンバー登録</title>
</head>
<body>
	<form method="post" action="./Member">
		<div align="center">会員登録</div>
		<div id="Name1" align="center">
			氏名<input type="text" name="Name">
		</div>
		<%-- 氏名に何も入力されていない場合 --%>
		<%
			if (request.getAttribute("error_msg_name") == "false") {
		%>
		<%=request.getAttribute("error_msg_name")%>
		<%
			}
		%>
		<%-- 全角でない場合エラー表示 --%>
		<%
			if (request.getAttribute("error_msg_name_zenkaku") == "false") {
		%>
		<%=request.getAttribute("error_msg_name_mojinember")%>
		<%
			}
		%>
		<%-- ２０文字以内ではない場合エラー表示 --%>
		<%
			if (request.getAttribute("error_msg_name_mojinember") == "false") {
		%>
		<%=request.getAttribute("error_msg_name")%>
		<%
			}
		%>
		<div align="center">
			年齢<input type="text" name="Old">
		</div>
		<%
			if (request.getAttribute("error_msg_old") != null) {
		%>
		<%=request.getAttribute("error_msg_old")%>
		<%
			}
		%>
		<div align="center">
			性別 <select id="Gender" name="Gender_select" onchange="changeSelect()">
				<option value="男">男</option>
				<option value="女">女</option>
				<option value="custem">カスタム</option>
			</select>
		</div>
		<%-- カスタムが選択された場合、テキストボックスを表示する処理 START --%>
		<div id="custombox_a" align="center" style="display: none;">
			<input id="custombox" type="text" name="Gender">
		</div>
		<script>
			document
					.getElementById("Gender")
					.addEventListener(
							"change",
							function() {
								var custombox1 = document
										.getElementById("Gender");
								var custom_value = custombox1.options[custombox1.selectedIndex].value;
								var custombox2 = document
										.getElementById("custombox_a");
								if (custom_value == "custem") {
									custombox2.style.display = 'block';
								} else {
									custombox2.style.display = 'none';
								}
							}, false);

			function changeSelect() {
				console.log("You have changed this text area");
			}
		<%=request.getAttribute("errorMessage_gender")%>

		</script>
		<%-- カスタムが選択された場合、テキストボックスを表示する処理 FINISH --%>
		<div>
			<input type="submit" value="確認">
		</div>
	</form>
</body>
</html>
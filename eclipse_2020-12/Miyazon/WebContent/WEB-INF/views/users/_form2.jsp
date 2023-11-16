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
<label for="UserID">ユーザーID(メールアドレス)</label>
<br />
<input type="text" name="account" value="${user.account}" />
<br />
<br />
<label for="name">ユーザー名</label>
<br />
<input type="text" name="name" value="${user.name}" />
<br />
<br />
<label for="password">パスワード</label>
<br />
<input type="password" name="password" />
<br />
<br />
<label for="address">住所</label>
<br />
<input type="text" name="address" value="${user.address}" />
<br />
<br />
<label for="tel">電話番号(ハイフン不要)</label>
<br />
<input type="text" name="tel" value="${user.tel}" />
<br />
<br />
<label for="birthday">誕生日 （記入例）1985年1月1日→19850101</label>
<br />
<input type="text" name="birthday" value="${user.birthday}" />
<br />
<br />
<label for="sex">性別</label>
<br />
<input type="radio" name="sex" value="男" checked="checked">
男
<input type="radio" name="sex" value="女">
女
<br />
<br />
<p>クレジットカード情報</p>
<br />
<div>クレジットカード会社</div>
<select name="credit_card_company">
	<option value="VISA"
		<c:if test="${user.credit_card_company == VISA}"> selected</c:if>>VISA</option>
	<option value="MasterCard"
		<c:if test="${user.credit_card_company == MasterCard}"> selected</c:if>>MasterCard</option>
	<option value="JCB"
		<c:if test="${user.credit_card_company == JCB}"> selected</c:if>>JCB</option>
	<option value="American Express"
		<c:if test="${user.credit_card_company == AmericanExpress}"> selected</c:if>>AmericanExpress</option>
</select>
<br />
<br />
<div>クレジットカード番号（ハイフン不要）</div>
<input type="text" name="credit_card_number"
	value="${user.credit_card_number}" />
<br />
<br />
<p>引き落とし銀行口座</p>
<br />
<div>金融機関名</div>
<input type="text" name="bank_name" value="${user.bank_name}" />
<br />
<p>支店名</p>
<input type="text" name="branch_name" value="${user.branch_name}" />
<br />
<p>口座種類</p>
<input type="radio" name="account_type" value="普通" checked="checked">
普通
<input type="radio" name="account_type" value="当座">
当座
<br />
<p>口座番号</p>
<input type="text" name="account_number" value="${user.account_number}" />
<br />
<br />
<label for="admin_flag">権限</label>
<br />
<select name="admin_flag">
	<option value="0" <c:if test="${user.admin_flag == 0}"> selected</c:if>>お買い物のみ希望</option>
	<option value="1" <c:if test="${user.admin_flag == 1}"> selected</c:if>>お買い物、商品出品どちらも希望</option>
</select>
<br />
<br />
<input type="hidden" name="_token" value="${_token}" />
<button type="submit">登録情報更新</button>
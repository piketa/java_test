<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Count Up!</title>
</head>
<body>
<h1><%=session.getAttribute("number") %> 回クリックしました。</h1>
<form action="countup" method="get">
<button type="submit" name="button" value="click">Click!</button>
<button type="submit" name="button" value="reset">Reset</button>
</form>
</body>
</html>
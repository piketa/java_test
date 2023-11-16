<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.UserInformation" %>
<%
   UserInformation loginUser = (UserInformation) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title></title>
    <style>
        html {
            font-family: sans-serif;
        }
        * {
            margin: 0;
            padding: 0;
        }
        body{
            background-color: #f0f8ff;
        }
        header {
            width: 100%;
            height: 100px;
            background-color: #99CCFF;
            text-align: right;
        }
        .nav-list-item {
            list-style: none;
            display: inline-block;
            margin-top: 20px;
            margin-right: 20px;
            color: white;
        }
        h1{
            font-size: 26px;
            margin-top: 30px;
            margin-bottom: 15px;
            color: #6495ed;
        }
        .success_area{
            text-align: center;
            font-family: sans-serif;
            background-color: white;
            margin: 111px 50px;
        }
        .failure_area{
            text-align: center;
            font-family: sans-serif;
            background-color: white;
            margin: 85px 50px;
        }
        .login_message{
            margin: 0px;
            font-size: 15px;
            color: #005FFF;
        }
        .successful{
            color: #ffc1e0;
            font-size: 95px;
            margin: 0px;
            font-weight: 700px;
        }
        .failure{
            color: #ce9eff;
            font-size: 130px;
            margin: 0px;
        }
        footer{
            width: 100%;
            background-color: #99CCFF;
            color: #fff;
            text-align: center;
            padding: 225px 0;
            bottom: 0;
        }
        a{
            color: #005FFF;
        }
    </style>
</head>
<body>
    <header></header>
    <% if(loginUser != null) { %>
        <div class="success_area">
            <h1 class="successful">◎</h1>
            <div class="login_message">ログインに成功しました</div><br>
            <a href="/Main">メンバー募集投稿ページへ</a><br><br>
        </div>
    <% }else{ %>
        <div class="failure_area">
            <h1 class="failure">×</h1>
            <div class="login_message">ログインに失敗しました。</div><br>
            <a href="/login.jsp">TOPへ</a><br><br>
        </div>
    <% } %>
    <footer>
    </footer>
</body>
</html>
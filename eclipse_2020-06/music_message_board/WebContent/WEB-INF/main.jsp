<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.UserInformation,model.Message,java.util.List"%>
<%
UserInformation loginUser = (UserInformation) session.getAttribute("loginUser");
List<Message> messageList = (List<Message>) application.getAttribute("messageList");
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
        header {
            width: 100%;
            height: 70px;
            background-color: #99CCFF;
            text-align: right;
        }
        body{
            background-color: #f0f8ff;
        }
       .nav-list-item {
            list-style: none;
            display: inline-block;
            margin-top: 20px;
            margin-right: 20px;
            color: white;
        }
        div{
            text-align: center;
        }
        .white{
            background-color: white;
            margin: 10px 60px;
            padding: 20px;
        }
        .text{
            color: #666666;
            padding: 1em;
            border: 1px solid #e8e8e8;
            background-color: #fff;
            box-shadow: 1px 1px 2px #e8e8e8;
            padding: 15px;
            width: 88%;
            font-size: 15px;
            margin: 8px;
            border-width: 3px;
            height: 130px;
            margin-top: 25px;
        }
        .submit{
            height: 40%;
            width: 25%;
            text-align: center;
            background-color: #FF82B2;
            padding-top: 5px;
            padding-bottom: 5px;
            border-radius: 0.3em;
            border-style: none;
            font-size: 20px;
            color: #fff;
            margin-top: 10px;
        }
        .submit:hover {
            background-color: #FF69A3;
            color: #fff;
        }
        footer {
            width: 100%;
            background-color: #99CCFF;
            color: #fff;
            text-align: center;
            padding: 140px 0;
            bottom: 0;
        }
        a{
            color: white;
            text-decoration: none;
        }
        p{
            text-align: initial;
            margin-right: 50px;
            white-space: pre-wrap;
        }
        .username{
            color: #6495ed;
            font-size: 17px;
        }
        .gettext{
            color: #778899;
            margin: 0;
        }
        hr{
            height: 1px;
            background-color: #C0C0C0;
            border: none;
        }
        .introduction{
            text-align: center;
            background-color: white;
            color: #6495ed;
            display: block;
            padding-right: 30px;
            margin: 0 -200%;
            padding: 0 200%;
            padding-bottom: 8px;
            margin: 0;
            padding: 0;
        }
        .example{
            color: #6495ed;
            margin: 0;
        }
        </style>
    </head>
    <body>
    <header>
        <ul>
            <li class="nav-list-item"><a href="/Logout">ログアウト</a></li>
        </ul>
    </header>
        <p class="introduction">こちらはバンドメンバー募集の掲示板です。あなたにぴったりのメンバーを見つけましょう。</p>
        <div class ="white">
            <p class="example">
記述例
《活動場所/活動頻度/活動曜日》
 東京/月6/土曜日、日曜日/
《モチベーション》
 趣味
《好きな音楽のジャンル》
 シャンソン シティポップ
《募集パート》
 ベース、ドラム
《コンタクト》
 hogehoge@gmail.com
《一言》
 初心者の方も大歓迎楽しくやりましょ〜
                <hr>
            </p>
            <% for(Message message :messageList) { %>
                <p class="username"><%= message.getUserName() %><br></p>
                <p class="gettext"><%= message.getText() %><br></p>
                <hr>
             <% } %>
        <br>
        <form method = "POST" action = "/Main" method = "post" >
                <textarea class="text" name="text"></textarea><br>
                <input class="submit" type="submit" value="コメントの投稿">
        </form>
        </div>
        <footer>
        </footer>
      </body>
</html>
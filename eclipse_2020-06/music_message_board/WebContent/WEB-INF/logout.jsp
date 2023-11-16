<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
            font-size: 18px;
            margin-top: 30px;
            margin-bottom: 15px;
            color: #6495ed;
        }
        div{
            text-align: center;
            font-family: sans-serif;
            background-color: white;
            margin: 100px 50px;
        }
        .submit{
            height: 25%;
            width: 25%;
            marrgin-top: 20px;
            margin-bottom: 30px;
            text-align: center;
            background-color: #FF82B2;
            padding-top: 5px;
            padding-bottom: 5px;
            border-radius: 0.3em;
            border-style: none;
            font-size: 15px;
            color: #fff;
        }
        .submit:hover {
            background-color: #FF69A3;
            color: #fff;
        }
         .login_failure{
            margin: 0px;
            font-size: 15px;
            color: #005FFF;
        }
        .logout{
            color: #ffc1e0;
            opacity: 0.7;
            width: 8%;
            height: 12%;
        }
        footer{
            width: 100%;
            background-color: #99CCFF;
            color: #fff;
            text-align: center;
            padding: 225px 0px;
            bottom: 0;
        }
        a{
            color: #005FFF;
        }
        </style>
</head>
    <body>
        <header>
        </header>
        <div class = "form_area">
            <form class ="form" action ="/Login" method = "post"><br><br>
                <img class = "logout" src ="/pict/logout.png" alt="ログアウトアイコン"><br><br>
                <div class = "login_failure">ログアウトしました</div><br>
                <a href = "/login.jsp">TOPへ</a><br><br>
            </form>
        </div>
        <footer>
        </footer>
    </body>
</html>
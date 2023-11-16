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
            font-size: 26px;
            margin-top: 30px;
            margin-bottom: 15px;
            color: #6495ed;
            font-weight: bolder;
        }
        div{
            text-align: center;
            font-family: sans-serif;
            background-color: white;
            margin: 65px 50px;
        }
        .text{
            background-color: #f0f8ff;
            width: 80%;
            font-size: 16px;
            color: #666666;
            margin: 2em auto;
            padding: 1em;
            width: 90%;
            margin: 10px;
            border: solid #e8e8e8;
            max-width: 300px;
            padding: 15px 10px 10px;
            font-size: 15px;
            border-width: 2px;
            height: 8px;
        }
        ::placeholder{
            color: #C0C0C0;
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
        footer {
            width: 100%;
            background-color: #99CCFF;
            color: #fff;
            text-align: center;
            padding: 225px 0;
            bottom: 0;
        }
        </style>
    </head>
    <body>
        <header>
        </header>
        <div class="form_area">
            <br>
            <h1>LOGIN</h1>
            <form class="form" action="/Login" method="post">
                <input class="text" type="text" name="name" placeholder="ユーザー名" ><br>
                <input class="text" type="password" name="pass" placeholder="パスワード"><br><br>
                <input type="submit" class="submit" value="ログイン"><br><br>
            </form>
        </div>
        <footer>
        </footer>
    </body>
</html>
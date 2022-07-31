<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            margin: 0 auto;
            max-width: 800px;
            padding: 0 20px;
        }


        .bottom_wrapper {
            width: 80%;
            background-color: #fff;
            padding: 20px 20px;
            position: relative;
            bottom: 0;
        }
        .bottom_wrapper .user_name_input_wrapper {
            display: inline-block;
            height: 50px;
            border-radius: 25px;
            border: 1px solid #bcbdc0;
            width: 700px;
            position: relative;
            padding: 0 20px;
        }
        .bottom_wrapper .user_name_input_wrapper .user_name_input {
            border: none;
            height: 100%;
            box-sizing: border-box;
            width: 700px;
            position: absolute;
            outline-width: 0;
            color: gray;
        }
        .bottom_wrapper .wrapper {
            width: 140px;
            height: 50px;
            display: inline-block;
            border-radius: 50px;
            background-color: #a3d063;
            border: 2px solid #a3d063;
            color: #fff;
            cursor: pointer;
            transition: all 0.2s linear;
            text-align: center;
            position: relative;
        }

        .top_menu {
            background-color: #fff;
            width: 100%;
            padding: 20px 0 15px;
            box-shadow: 0 1px 30px rgba(0, 0, 0, 0.1);

        }
        .top_menu .buttons {
            margin: 3px 0 0 20px;
            position: absolute;
        }
        .top_menu .buttons .button {
            width: 16px;
            height: 16px;
            border-radius: 50%;
            display: inline-block;
            margin-right: 10px;
            position: relative;
        }
        .top_menu .buttons .button.close {
            background-color: #f5886e;
        }
        .top_menu .buttons .button.minimize {
            background-color: #fdbf68;
        }
        .top_menu .buttons .button.maximize {
            background-color: #a3d063;
        }
        .top_menu .title {
            text-align: center;
            color: #bcbdc0;
            font-size: 20px;
        }
    </style>
</head>
    <body>
        <div class="top_menu">
            <div class="buttons">
                <div class="button close"></div>
                <div class="button minimize"></div>
                <div class="button maximize"></div>
            </div>
            <div class="title">Welcome to The Chat</div>

            <form name="loginForm" method="post" action="${pageContext.request.contextPath}/welcome">
                <div class="bottom_wrapper clearfix">
                    <div class="user_name_input_wrapper">
                        <input name="user_name" class="user_name_input" placeholder="Type your name here..." />
                    </div>
                    <button class="wrapper" type="submit">Enter to chat</button>
                </div>
            </form>
        </div>
    </body>
</html>

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

        .container {
            border: 2px solid #dedede;
            background-color: #f1f1f1;
            border-radius: 5px;
            padding: 5px;
            margin: 10px 0;
        }

        .container::after {
            content: "";
            clear: both;
            display: table;
        }

        .time-right {
            float: right;
            color: #aaa;
        }
        .user-name {
            float: left;
            color: #aaaabf;
        }

        .bottom_wrapper {
            width: 80%;
            background-color: #fff;
            padding: 20px 20px;
            position: relative;
            bottom: 0;
        }
        .bottom_wrapper .message_input_wrapper {
            display: inline-block;
            height: 50px;
            border-radius: 25px;
            border: 1px solid #bcbdc0;
            width: 750px;
            position: relative;
            padding: 0 20px;
        }
        .bottom_wrapper .message_input_wrapper .message_input {
            border: none;
            height: 100%;
            box-sizing: border-box;
            width: 750px;
            position: absolute;
            outline-width: 0;
            color: gray;
        }

        .bottom_wrapper .send_message:hover {
            color: #a3d063;
            background-color: #fff;
        }
        .bottom_wrapper .send_message .text {
            font-size: 18px;
            font-weight: 300;
            display: inline-block;
            line-height: 48px;
        }

        .message_block {
            height:90%;
            overflow-y: scroll;
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

        #refresh {
            margin-left: 10px;
        }
        .row {
            display: flex;
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
            <div class="title">Chat Messages</div>
        </div>

        <div class="message_block">
            <c:forEach items="${list}" var="emp">
                <div class="container">
                    <p>${emp.message}</p>
                    <span class="time-right">${emp.time}</span>
                    <span class="user-name">${emp.userName}</span>
                </div>
            </c:forEach>
        </div>

        <div class="bottom_wrapper clearfix">
            <div class = "row">
                <form name="loginForm" method="post" action="${pageContext.request.contextPath}/index">
                    <div class="message_input_wrapper">
                        <input type="text" name="message" class="message_input" placeholder="Type your message here..." />
                    </div>
                    <button class="wrapper" type="submit">Send</button>
                </form>
                <form name="Refresh_button" method="get" action="${pageContext.request.contextPath}/index/refresh">
                    <button class="wrapper" id="refresh" type="submit">Refresh</button>
                </form>
            </div>
        </div>
    </body>
</html>

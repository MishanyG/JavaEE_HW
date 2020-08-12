<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <html>
    <style>
        #wrapper{
            outline: 1px solid #787274;
            padding: 10px;
            margin: 0 auto;
        }
        #header{
            position:relative;
            height: 80px;
            background-color: #25B33f;
            margin-bottom: 10px;
            background-image: url(images/top.jpg)
        }
        #content{
            background-color: #5fccf5;
            margin-bottom: 10px;
            padding: 10px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        #footer{
            background-color: #b2ff79;
            margin-bottom: 10px;
            height: 500px;
            display: flex;
            align-items: center;
        }
        h1{
            color: #43ff1a;
            font: 40px Georgia;
            margin-left: 40%;
        }
        img{
            position:absolute;
            top:10px;
            left:10px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
    </style>
    <head>
        <title>Корзина</title>
    </head>
    <body>
    <div id="wrapper">
        <div id="header">
            <%@ include file="menu.jsp" %> </div>
        <div id="content"> <h1>Корзина</h1></div>
            <div id="footer">
                <strong style="color: #132cff; font: 17px 'Comic Sans MS';">URL-адрес страницы:
                    <%= request.getRequestURI() %> </strong>
            </div>
    </div>
    </body>
    </html>
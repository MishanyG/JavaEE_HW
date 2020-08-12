<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <style>
        nav a {
            text-decoration: none;
        }

        nav ul {
            margin: 0;
            padding: 0;
        }

        nav li {
            list-style-position: inside;
            font: 24px 'Comic Sans MS', sans-serif;
            padding: 12px;
            font-weight: bold;
        }

        .menu li {
            display: inline-block;
            padding: 12px 36px;
            margin: 0;
        }

        .menu li.active {
            background: #3ee653;
            color: #fff2cb;
        }

        .menu a {
            color: #5431b2;
        }
    </style>
    <title>Меню</title>
</head>
    <body>
        <nav>
            <ul class="menu">
                <li>
                    <a href="${pageContext.request.contextPath}/main">Главная страница</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/product">Товар</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/cart">Корзина</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/order">Оформление товара</a>
                </li>
                <li>
                    <a href="company_info.jsp">Информация о компании</a>
                </li>
            </ul>
        </nav>
    </body>
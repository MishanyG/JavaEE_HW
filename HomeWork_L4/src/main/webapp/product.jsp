<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <html>
        <head>
            <title>Товар</title>
            <style>
                table {
                    float: left;
                    width: 800px;
                    border: 2px solid;
                }
                td {
                    border: 2px solid;
                }
                input {
                    margin-left: 10px;
                }
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
                    display: flex;
                    align-items: center;
                }
                h1{
                    color: #ff0e0b;
                    font: 40px Georgia;
                    margin-left: 300px;
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
        </head>
        <body>
        <div id="wrapper">
            <div id="header">
            <%@ include file="menu.jsp" %> </div>
            <div id="content"> <h1>Товар</h1></div>
        <div id="footer">
            <table>
                    <tr>
                        <td bgcolor="#00FF66" style="font: 17px 'Comic Sans MS';">Марка</td>
                        <td bgcolor="#996666" style="font: 17px 'Comic Sans MS';">Фирма</td>
                        <td bgcolor="#CC6633" style="font: 17px 'Comic Sans MS';">Цена</td>
                    </tr>
                    <tr>
                        <td>Pentium 1</td>
                        <td>Intel</td>
                        <td>1000</td>
                        <td width="11%"><form>
                            <input type="button" onclick="window.location.href = '${pageContext.request.contextPath}/cart';"
                                   value="Купить" /></form></td>
                    </tr>
                    <tr>
                        <td>Pentium 2</td>
                        <td>Intel</td>
                        <td>2000</td>
                        <td width="11%"><form>
                            <input type="button" onclick="window.location.href = '${pageContext.request.contextPath}/cart';"
                                   value="Купить"/></form></td>
                    </tr>
                    <tr>
                        <td>Pentium 3</td>
                        <td>Intel</td>
                        <td>3000</td>
                        <td width="11%"><form>
                            <input type="button" onclick="window.location.href = '${pageContext.request.contextPath}/cart';"
                                   value="Купить"/></form></td>
                    </tr>
                <tr>
                    <td>Pentium 4</td>
                    <td>AMD</td>
                    <td>4000</td>
                    <td width="11%"><form>
                        <input type="button" onclick="window.location.href = '${pageContext.request.contextPath}/cart';"
                               value="Купить" /></form></td>
                </tr>
                <tr>
                    <td>Pentium 5</td>
                    <td>Sempron</td>
                    <td>5000</td>
                    <td width="11%"><form>
                        <input type="button" onclick="window.location.href = '${pageContext.request.contextPath}/cart';"
                               value="Купить"/></form></td>
                </tr>
                <tr>
                    <td>Pentium 6</td>
                    <td>Celeron</td>
                    <td>6000</td>
                    <td width="11%"><form>
                        <input type="button" onclick="window.location.href = '${pageContext.request.contextPath}/cart';"
                               value="Купить"/></form></td>
                </tr>
                <tr>
                    <td>Pentium 7</td>
                    <td>AMD</td>
                    <td>7000</td>
                    <td width="11%"><form>
                        <input type="button" onclick="window.location.href = '${pageContext.request.contextPath}/cart';"
                               value="Купить" /></form></td>
                </tr>
                <tr>
                    <td>Pentium 8</td>
                    <td>Sempron</td>
                    <td>8000</td>
                    <td width="11%"><form>
                        <input type="button" onclick="window.location.href = '${pageContext.request.contextPath}/cart';"
                               value="Купить"/></form></td>
                </tr>
                <tr>
                    <td>Pentium 3</td>
                    <td>Celeron</td>
                    <td>9000</td>
                    <td width="11%"><form>
                        <input type="button" onclick="window.location.href = '${pageContext.request.contextPath}/cart';"
                               value="Купить"/></form></td>
                </tr>
                </table>
            </div>
        </div>
        </body>
    </html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <%
        String username = (String)session.getAttribute("username");// Phải ép kiểu dữ liệu về String
    %>
    Login Session Success
    
    
    <h1>Xinh Chào: <%= username %></h1>
    <h1>Đây là trang chào mừng</h1>
    <a href="Trang1.jsp">Trang 1</a>

    
</body>
</html>
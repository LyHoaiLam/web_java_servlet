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
<body style="background-color: yellow">
    <%
        String username = (String)session.getAttribute("username");// Phải ép kiểu dữ liệu về String
    %>

    <h1>Xinh Chào: <%= username %></h1>
    <h1>Đây là Trang 1</h1>
    
    <a href="Trang2.jsp">Trang 2</a>

    
</body>
</html>
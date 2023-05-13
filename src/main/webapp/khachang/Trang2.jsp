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
<body  style="background-color: green">
    <%
        String username = (String)session.getAttribute("username");// Phải ép kiểu dữ liệu về String
    %>
   
    
    <h1>Xinh Chào: <%= username %></h1>
    <h1>Đây là Trang 2</h1>
    <a href="Trang1.jsp">Quay lại Trang 1</a>
   

    
</body>
</html>
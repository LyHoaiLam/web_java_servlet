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
        String hoVaTen = request.getParameter("hoVaTen");
        String email = request.getParameter("email");
        String soLuong = request.getParameter("soLuong");
        /*int soLuongSanPham = Integer.parseInt(soLuong);*/


        int soLuongSanPham =0;
        try{
            soLuongSanPham = Integer.parseInt(soLuong);
        }catch(Exception e){
            
        }

        
    %>
    <h1>Xac Nhan Dat Hang Tren He Thong</h1>
    <p>Xin Cam On Ban: <b> <%= hoVaTen %></b></p>
    <p>Email:<b> <%= email %></b></p>
    <p>So Luong<b> <%= soLuong %></b></p>
    <p>So Tien Ban Can Thanh Toan La: <b> <%= soLuongSanPham * 5 %> $ </b> </p>
</body>
</html>
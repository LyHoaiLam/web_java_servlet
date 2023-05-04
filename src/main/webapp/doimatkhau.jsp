<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đổi Mật Khẩu</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js" integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous"></script>
<style>
  
</style>
</head>
<body>
  <img src="img/windows10.jpg" style="position: absolute; width: 100%;">
  <div class="container" style="position: relative;">

    <%
    Object obj = session.getAttribute("khachHang");
		KhachHang khachHang = null;
		if (obj!=null)
			khachHang = (KhachHang)obj;		
			if(khachHang==null){	

    %>
        <!-- Nếu KhacHang = null (Có nghĩa là chưa Login thì không cho phép hiển thị ra code xứ ký Changed Password) -->
    <h1>Bạn Chưa Login Vui Lòng Quay Lại Trang Chủ</h1>

    <%
  }else {
    String baoLoi = request.getAttribute("baoLoi")+"";
    if(baoLoi.equals("null")){
      baoLoi = "";
    }

    %>
    
   
        
            <h1>Đổi mật khẩu</h1>
            <span style="color: red;">
                <%=baoLoi%>
            </span>
            <form action="doi-mat-khau" method="POST">
                <div class="mb-3">
                  <label for="exampleInputEmail1" class="form-label">Mật khẩu hiện tại</label>
                  <input type="password" class="form-control" id="matKhauHienTai" name="matKhauHienTai">
                </div>
                <div class="mb-3">
                  <label for="matKhauMoi" class="form-label">Mật khẩu mới</label>
                  <input type="password" class="form-control" id="matKhauMoi" name="matKhauMoi">
                </div>
                <div class="mb-3">
                    <label for="matKhauMoiNhapLai" class="form-label">Nhập lại mật khẩu mới</label>
                    <input type="password" class="form-control" id="matKhauMoiNhapLai" name="matKhauMoiNhapLai">
                  </div>
                <div class="mb-3 form-check">
                  <input type="checkbox" class="form-check-input" id="exampleCheck1">
                  <label class="form-check-label" for="exampleCheck1">Check me out</label>
                </div>
                <button type="submit" class="btn btn-primary">Lưu mật khẩu</button>
              </form>
    

    <% } %>
  </div>
</body>
</html>
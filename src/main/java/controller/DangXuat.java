package controller;


import java.io.IOException;
//import java.sql.Date;
//import java.util.Random;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.mysql.cj.Session;

//@WebServlet(name = "DangNhap", urlPatterns = {"/dang-xuat" })
@WebServlet("/dang-xuat")
public class DangXuat extends HttpServlet{
    // Đăng xuất bằng hủy phiên làm việc
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesson = request.getSession();
        sesson.invalidate();//Hủy bỏ tất cả sesson
        
        String url = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + request.getContextPath();

        response.sendRedirect(url + "/trangchu.jsp");//Đi đến page đó thôi không kèm theo bất kỳ data nào kèm theo

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request, response);
    }
    
}

package gdu.k14pm01;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/dang-nhap")
public class Login_03 extends HttpServlet{
    public Login_03(){

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        //resp.getWriter().append("Bạn Đang Vào Phương Thức Do Get");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String url = "";
        if(username.equals("hoailam03999") && password.equals("0362685068")){
            //resp.getWriter().append("Chúc mừng bạn đã đăng nhập thành công");
            url = "/Login_Success.jsp";// Thay bằng một file jsp cho cái trên
           
        }else{
            //resp.getWriter().append("Chúc mừng bạn đã đăng nhập thất bại");
            url = "/Login_Error.jsp";// Thay bằng một file jsp cho cái trên
        }

        

        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        //req.setCharacterEncoding("UTF-8");
        //resp.setCharacterEncoding("UTF-8");
        //resp.setContentType("text/html; charset=UTF-8");
        //resp.getWriter().append("Bạn Đang Vào Phươc Thức Do Post");
        doGet(req, resp);
    }
}

package controller;

import java.io.IOException;
// import java.sql.Date;
// import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// import com.mysql.cj.Session;

import database.KhachHangDAO;
import model.KhachHang;
import util.MaHoa;
@WebServlet(name = "DangNhap", urlPatterns = {"/dang-nhapweb" })
public class DangNhap extends HttpServlet{

     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         // TODO Auto-generated method stub
         response.getWriter().append("Served at: ").append(request.getContextPath());
     }
    
    


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
     String tenDangNhap = request.getParameter("tenDangNhap");
     String matKhau = request.getParameter("matKhau");
     matKhau = MaHoa.toSHA1(matKhau);
     
     KhachHang kh = new KhachHang();
     kh.setTenDangNhap(tenDangNhap);
     kh.setMatKhau(matKhau);
     
     KhachHangDAO khd = new KhachHangDAO();
     KhachHang khachHang = khd.selectByUserNameAndPassWord(kh);
     String url = "";
     if(khachHang!=null) {
          HttpSession	session = request.getSession();
          session.setAttribute("khachHang", khachHang);
          url = "/trangchu.jsp";
     }else {
          request.setAttribute("baoLoi", "Tên đăng nhập hoặc mật khẩu không đúng!");
          url = "/dangnhap.jsp";
     }
     RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
     rd.forward(request, response);   
        
    

}
}

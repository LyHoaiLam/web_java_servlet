package gdu.k14pm01;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mua-hang")
public class MuaHang extends HttpServlet{
    public MuaHang(){

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        /*Lấy data user nhập từ form trong index_03.jsp */
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");


        String soLuong = request.getParameter("soLuong");
        String soDienThoai = request.getParameter("soDienThoai");
        String email = request.getParameter("email");
        double giatri_soLuong = 0;

        boolean checkError = false;
        //Bắt error số lượng
        try{
            giatri_soLuong = Double.parseDouble(soLuong);
            /* */
        }catch(Exception e){
            checkError = true;
            request.setAttribute("e_soLuong", "Nhập data số lượng không đúng!");
        }


        //Bắt error số lượng phải lớn hơn 0
        if(giatri_soLuong == 0){
            checkError = true;
            request.setAttribute("e_soLuong", "Bạn phải nhập lớn hơn 0!");
        }

        Pattern soDienThoatPattern = Pattern.compile("\\d{10}");/*Không nhấp quá 10 số */
        Matcher soDienThoaiMatcher = soDienThoatPattern.matcher(soDienThoai);/*Kiểm tar user nhập có OK không */
        if(! soDienThoaiMatcher.matches()){ /* "!" Nếu không matches(); */
            checkError = true;
            request.setAttribute("e_soDienThoai", "Số điện thoại bao gồm 10 ký tự !");

        }

        //Kiểm tra email
        Pattern emailPattern = Pattern.compile("\\ w +@ \\ w + (\\. \\ w +)+  (\\. \\ w +)*");/*Không nhấp quá 10 sp61 */
        Matcher emailMatcher = emailPattern.matcher(email);/*Kiểm tar user nhập có OK không */
        if(! emailMatcher.matches()){ /* "!" Nếu không matches(); */
            checkError = true;
            request.setAttribute("e_email", "Cấu trúc email chưa đúng!");
        }

        String url = "Login_Success.jsp";
        if(checkError){
            url = "/index_03.jsp";
        }
        RequestDispatcher rq = getServletContext().getRequestDispatcher(url);
        rq.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //super.doPost(request, response);
    }
}

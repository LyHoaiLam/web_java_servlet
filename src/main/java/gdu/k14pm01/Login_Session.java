package gdu.k14pm01;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login_Session")
public class Login_Session extends HttpServlet{
    public Login_Session(){
        
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {     
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String url = "";

        if(username.equalsIgnoreCase("hoailam") && password.equals("0362685068")){
            HttpSession session = request.getSession();// Tạo Session mới
            // Kưu trữ username trong session
            session.setAttribute("username", username);
            url = "/Login_Session_Success.jsp";//True thì vào Trang Success
        }else{
             url = "/Login_Session.jsp";//Flase thì quay lại page
        }
        RequestDispatcher rq = getServletContext().getRequestDispatcher(url);// Chuyển page
        rq.forward(request, response);

       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        doGet(request, response);
    }
}

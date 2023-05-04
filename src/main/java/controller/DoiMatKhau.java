package controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.KhachHangDAO;
import model.KhachHang;
import util.MaHoa;

@WebServlet("/doi-mat-khau")
public class DoiMatKhau extends HttpServlet{




    public DoiMatKhau() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matKhauHienTai = request.getParameter("matKhauHienTai");/*Lấy ra đc mật khẩu hiện tại */
		String matKhauMoi = request.getParameter("matKhauMoi");
		String matKhauMoiNhapLai = request.getParameter("matKhauMoiNhapLai");
		
		String matKhauHienTai_Sha1 = MaHoa.toSHA1(matKhauHienTai);
		
		String baoLoi = "";
		String url = "/doimatkhau.jsp";
		
		// Kiem tra mat khau cu co giong hay khong
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("khachHang");// Lấy đối tương khachHang
		KhachHang khachHang = null;
		if (obj!=null)
			khachHang = (KhachHang)obj;		
		if(khachHang==null) {
			baoLoi = "Bạn chưa đăng nhập vào hệ thống!";
		}else {
			// Neu khach hang da dang nhap
			if(!matKhauHienTai_Sha1.equals(khachHang.getMatKhau())){/*Nếu 2 password không giống nhau (có ! phủ định phía trước) */
				baoLoi = "Mật khẩu hiện tại không chính xác!";
			}else {/*Nếu 2 password trên bằng nhau thì zo đây xử lý :))*/
				if(!matKhauMoi.equals(matKhauMoiNhapLai)) {// Mật khễu mới và mật khẩu mới nhập lại không giống nhau
					baoLoi = "Mật khẩu nhập lại không khớp!";
				}else { /*Nếu không có các sai sót trên thì lưu mật khẩu mới*/
					String matKhauMoi_Sha1 = MaHoa.toSHA1(matKhauMoi);
					khachHang.setMatKhau(matKhauMoi_Sha1);
					KhachHangDAO khd = new KhachHangDAO();
					if(khd.changedPassword(khachHang)) {
						baoLoi = "Mật khẩu đã thay đổi thành công!";
					}else {
						baoLoi = "Quá trình thay đổi mật khẩu không thành công!";
					}
				}
			}
		}
		
		request.setAttribute("baoLoi", baoLoi);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}


}

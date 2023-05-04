package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.KhachHangDAO;
import model.KhachHang;
import util.MaHoa;

@WebServlet(name = "DangKy", urlPatterns = {"/dang-ky" })
public class DangKy extends HttpServlet {
	
 
    public DangKy() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");
		String matKhauNhapLai = request.getParameter("matKhauNhapLai");
		String hoVaTen = request.getParameter("hoVaTen");
		String gioiTinh = request.getParameter("gioiTinh");
		String ngaySinh = request.getParameter("ngaySinh");
		String diaChiKhachHang = request.getParameter("diaChiKhachHang");
		String diaChiMuaHang = request.getParameter("diaChiMuaHang");
		String diaChiNhanHang = request.getParameter("diaChiNhanHang");
		String dienThoai = request.getParameter("dienThoai");
		String email = request.getParameter("email");
		String dongYNhanMail = request.getParameter("dongYNhanMail");
		

		// Giữ lại thông tin user nhập nếu có lỗi (không bắt user nhập lại từ đầu)
		request.setAttribute("tenDangNhap", tenDangNhap);		
		request.setAttribute("hoVaTen", hoVaTen);
		request.setAttribute("gioiTinh", gioiTinh);
		request.setAttribute("ngaySinh", ngaySinh);
		request.setAttribute("diaChiKhachHang", diaChiKhachHang);
		request.setAttribute("diaChiMuaHang", diaChiMuaHang);
		request.setAttribute("diaChiNhanHang", diaChiNhanHang);
		request.setAttribute("dienThoai", dienThoai);
		request.setAttribute("dongYNhanMail", dongYNhanMail);
		
		String url = "";
		
		String baoLoi = "";
		KhachHangDAO khachHangDAO = new KhachHangDAO();

		if(khachHangDAO.kiemTraTenDangNhap(tenDangNhap)) {
			baoLoi +="Tên đăng nhập đã tồn tại, vui lòng chọn tên đăng nhập khác.<br/>";
		}
		
		if(!matKhau.equals(matKhauNhapLai)) {
			baoLoi +="Mẫu khẩu không khớp.<br/>";
		}else{
			matKhau = MaHoa.toSHA1(matKhau);// Trc khi save password xuống database thì mã hóa nó

		}
		
		request.setAttribute("baoLoi", baoLoi);
		
		
		if(baoLoi.length()>0){/*Lớn hơn 0 tức có xuất chuỗi thông bào nghĩa là có error thì quay về lại trang dangky.jsp */
			url = "/dangky.jsp";
		}else {
			Random rd = new Random();
			String maKhachHang = System.currentTimeMillis() + rd.nextInt(1000) +"";/*Lấy time của máy tính + vs random trong dãy số 1000. cộng "" để biến thành chuỗi*/

			KhachHang kh = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh,
			diaChiKhachHang, diaChiNhanHang, diaChiMuaHang, Date.valueOf(ngaySinh),
			dienThoai, email, dongYNhanMail != null);

			khachHangDAO.insert(kh);
			url = "/trangchu.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
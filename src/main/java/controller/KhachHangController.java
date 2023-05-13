package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import javax.servlet.http.HttpSession;

import database.KhachHangDAO;
import model.KhachHang;
import util.MaHoa;

@WebServlet("/khach-hang")
public class KhachHangController extends HttpServlet{//Gôm nhóm các sự kiện vào một Servlet (Gom nhóm các hành động của KhachHang vào Servlet KhachHang)
    //Vấn đề Chúng ta có rất nhiều method (Login, Logout, Thay đổi thông tin KhachHang). Chúng ta cần biến để đánh dấu, và chúng ta dựa trên biến đó để gọi hành động tương ứng
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String hanhDong =  request.getParameter("hanhDong");
       if(hanhDong.equals("dang-nhap")){
        dangNhap(request, response);
       }else if(hanhDong.equals("dang-xuat")){
        dangXuat(request, response);
       }else if(hanhDong.equals("dang-ky")){
        dangKy(request, response);
       }else if(hanhDong.equals("thay-doi-thong-tin")){
        thayDoiThongTin(request, response);
       }else if(hanhDong.equals("doi-mat-khau")){
        doiMatKhau(request, response);
       }
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request, response);
    }

    private void dangNhap(HttpServletRequest request, HttpServletResponse response){
                    try{
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
                            url = "/trangchugomnhom.jsp";
                        }else {
                            request.setAttribute("baoLoi", "Tên đăng nhập hoặc mật khẩu không đúng!");
                            url = "/dangnhapgomnhom.jsp";
                        }
                        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                        rd.forward(request, response);   
                    }catch(ServletException e){
                        e.printStackTrace();
                    }catch(IOException e){
                        e.printStackTrace();
                    }
        }

    private void dangXuat(HttpServletRequest request, HttpServletResponse response){
                try{
                    HttpSession sesson = request.getSession();
                    sesson.invalidate();
                    String url = request.getScheme() + "://" + request.getServerName() + ":"
                    + request.getServerPort() + request.getContextPath();

                    response.sendRedirect(url + "/trangchugomnhom.jsp");
                }catch(IOException e){
                    e.printStackTrace();
                }
    }

    private void dangKy(HttpServletRequest request, HttpServletResponse response){
            try{
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
                    url = "/dangkygomnhom.jsp";
                }else {
                    Random rd = new Random();
                    String maKhachHang = System.currentTimeMillis() + rd.nextInt(1000) +"";/*Lấy time của máy tính + vs random trong dãy số 1000. cộng "" để biến thành chuỗi*/

                    KhachHang kh = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh,
                    diaChiKhachHang, diaChiNhanHang, diaChiMuaHang, Date.valueOf(ngaySinh),
                    dienThoai, email, dongYNhanMail != null);

                    khachHangDAO.insert(kh);
                    url = "/trangchugomnhom.jsp";
                }
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request, response);
            }catch(ServletException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }
    }

    public void thayDoiThongTin(HttpServletRequest request, HttpServletResponse response){
        try{
            String hoVaTen = request.getParameter("hoVaTen");
            String gioiTinh = request.getParameter("gioiTinh");
            String ngaySinh = request.getParameter("ngaySinh");
            String diaChi = request.getParameter("diaChi");
            String diaChiMuaHang = request.getParameter("diaChiMuaHang");
            String diaChiNhanHang = request.getParameter("diaChiNhanHang");
            String dienThoai = request.getParameter("dienThoai");
            String email = request.getParameter("email");
            String dongYNhanMail = request.getParameter("dongYNhanMail");
            request.setAttribute("hoVaTen", hoVaTen);
            request.setAttribute("gioiTinh", gioiTinh);
            request.setAttribute("ngaySinh", ngaySinh);
            request.setAttribute("diaChi", diaChi);
            request.setAttribute("diaChiMuaHang", diaChiMuaHang);
            request.setAttribute("diaChiNhanHang", diaChiNhanHang);
            request.setAttribute("dienThoai", dienThoai);
            request.setAttribute("dongYNhanMail", dongYNhanMail);
            
            
            String url = "";
            
            String baoLoi = "";
            KhachHangDAO khachHangDAO = new KhachHangDAO();

            request.setAttribute("baoLoi", baoLoi);
            
            
            if(baoLoi.length()>0) {
                url = "/dangkygomnhom.jsp";
            }else {
                Object obj = request.getSession().getAttribute("khachHang");
                KhachHang khachHang = null;
                if (obj!=null)
                    khachHang = (KhachHang)obj;		
                    if(khachHang!=null){	
                        String maKhachHang = khachHang.getMaKhacHang();
                        KhachHang kh = new KhachHang(maKhachHang, "", "", hoVaTen, gioiTinh, diaChi, diaChiNhanHang, diaChiMuaHang, Date.valueOf(ngaySinh), dienThoai, email, dongYNhanMail!=null);
                        khachHangDAO.updateInfor(kh);
                        KhachHang kh2 = khachHangDAO.selectById(kh);
                        request.getSession().setAttribute("khachHang", kh2);
                        url = "/thanhcong2.jsp";
                    }
                
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
        }catch(ServletException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();;
        }
    }


    private void doiMatKhau(HttpServletRequest request, HttpServletResponse response){
        try{
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
        }catch(ServletException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

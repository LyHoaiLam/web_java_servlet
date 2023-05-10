package database;

//import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TacGia;
public class TacGiaDAO implements DAOInterface<TacGia>{

    @Override
	public ArrayList<TacGia> selectAll() {
		ArrayList<TacGia> ketQua = new ArrayList<TacGia>();// Tạo ra một ArrayList TacGia
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection(); //Sau đó kết nối nó đến CSDL
			// Class JDBCUtil và sử dụng method getConnection(); để kết nối đến CSDL
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM tacgia";// Lấy từ Table tacgia (Câu lệnh SQL)
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				// Từ ResultSet lấy information ra
				String maTacGia = rs.getString("matacgia");
				String hoVaTen = rs.getString("hovaten");
				Date ngaySinh = rs.getDate("ngaysinh");
				String tieuSu = rs.getString("tieusu");
				
				// Từ những thông tin trên chúng ta lấy ra và chuyển xuống OBJECT TacGia bên dưới để tạo ra một TacGia lấy data từ CSDL
				TacGia tg = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);
				ketQua.add(tg);// Thêm ông TacGia vào phần ketQua (ArrayList)
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);//Đóng CSLD
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}




	@Override
	public TacGia selectById(TacGia t) {// Lấy ra ID của TacGia
		TacGia ketQua = null;
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM tacgia WHERE matacgia=?";// lấy ra id theo ông TacGia nên có thêm điều kiện WHERE matacgia
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaTacGia());// matacgia là String nên sử dụng setString

			System.out.println(sql);
			ResultSet rs = st.executeQuery();
		
			while(rs.next()) {
				String maTacGia = rs.getString("matacgia");
				String hoVaTen = rs.getString("hovaten");
				Date ngaySinh = rs.getDate("ngaysinh");
				String tieuSu = rs.getString("tieusu");
				
				ketQua = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);
				break;// lấy id TacGia mà mỗi ông TacGia co một id khác nhau nên cho break luôn
			}// Vì selectByID nên chỉ lấy ra đc một TacGia
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return ketQua;
	}



	@Override
	public int insert(TacGia t){
		int ketQua = 0;
		try {
		
			Connection con = JDBCUtil.getConnection();
			String sql = "INSERT INTO tacgia (matacgia, hovaten, ngaysinh, tieusu) "+
					" VALUES (?,?,?,?)";// có 4 trường thông tin thì có 4 dấu ?	

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaTacGia());
			st.setString(2, t.getHoVaTen());
			st.setDate(3, t.getNgaySinh());
			st.setString(4, t.getTieuSu());
			ketQua = st.executeUpdate();
				
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return ketQua;
	}




	@Override
	public int insertAll(ArrayList<TacGia> arr) {
		int dem = 0;
		for (TacGia tacGia : arr) {
			dem+=this.insert(tacGia);
		}
		return dem;
	}



	@Override
	public int delete(TacGia t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();	
			String sql = "DELETE from tacgia "+
					 " WHERE matacgia=?";			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaTacGia());// Dựa trên matacgia để xóa TacGia		
		
			System.out.println(sql);
			ketQua = st.executeUpdate();
			
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return ketQua;
	}



	@Override
	public int deleteAll(ArrayList<TacGia> arr) {
		int dem = 0;
		for (TacGia tacGia : arr) {
			dem+=this.delete(tacGia);
		}
		return dem;
	}



	@Override
	public int update(TacGia t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE tacgia "+
					 " SET " +
					 " hovaten=?"+
					 ", ngaysinh=?"+
					 ", tieusu=?"+
					 " WHERE matacgia=?";//Dựa trên matacgia
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getHoVaTen());
			st.setDate(2, t.getNgaySinh());
			st.setString(3, t.getTieuSu());
			st.setString(4, t.getMaTacGia());
		
			System.out.println(sql);
			ketQua = st.executeUpdate();
			
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return ketQua;
	}
	

	public static void main(String[] args) {
		TacGiaDAO tgd = new TacGiaDAO();
		// ArrayList<TacGia> kq = tgd.selectAll();
		// for (TacGia tacGia : kq) {
		// 	System.out.println(tacGia.toString());
		// }

		// TacGia td = tgd.selectById(new TacGia("TG3", null, null, null));
		// System.out.println(td);

		// TacGia th_new = new TacGia("TG10", "David", new Date(2000-1900,10,12), null);
		// tgd.insert(th_new);

		TacGia tg = new TacGia("TG1", "David", new Date(2000-1900,10,12), null);
		System.out.println(tg);
		tg.setTieuSu("Tieu Su Da Bi Thay Doi");
		tgd.update(tg);


    }

}

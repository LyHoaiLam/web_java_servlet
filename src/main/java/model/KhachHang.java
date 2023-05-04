package model;

import java.sql.Date;
public class KhachHang {
    private String maKhacHang;
	private String tenDangNhap;
	private String matKhau; 
	private String hoVaTen;
	private String gioiTinh;
	private String diaChi; // xa, huyen, tinh
	private String diaChiNhanHang;
	private String diaChiMuaHang;
	private Date ngaySinh;
	private String soDienThoai;
	private String email;
	private boolean dangKyNhanBangTin;
	
	public boolean getDangKyNhanBangTin(){//Thêm vào sau
		return dangKyNhanBangTin;
	}

	public void setMaKhacHang(String maKhacHang) {
		this.maKhacHang = maKhacHang;
	}
	public String getMaKhacHang() {
		return maKhacHang;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}
	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}
	public void setDiaChiMuaHang(String diaChiMuaHang) {
		this.diaChiMuaHang = diaChiMuaHang;
	}
	public String getDiaChiMuaHang() {
		return diaChiMuaHang;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setDangKyNhanBangTin(boolean dangKyNhanBangTin) {
		this.dangKyNhanBangTin = dangKyNhanBangTin;
	}
	
	
	
	public KhachHang() {
	}

	public KhachHang(String maKhacHang, String tenDangNhap, String matKhau, String hoVaTen, String gioiTinh,
			String diaChi, String diaChiNhanHang, String diaChiMuaHang, Date ngaySinh, String soDienThoai, String email,
			boolean dangKyNhanBangTin) {
		this.maKhacHang = maKhacHang;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.hoVaTen = hoVaTen;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiMuaHang = diaChiMuaHang;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.dangKyNhanBangTin = dangKyNhanBangTin;
	}

}

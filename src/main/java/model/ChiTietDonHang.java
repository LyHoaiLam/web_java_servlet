package model;

public class ChiTietDonHang {
    private String maChiTietDonHang;
	private DonHang donHang;
	private SanPham sanPham;
	private double soLuong;
	private double giaGoc;
	private double giamGia;
	private	double giaBan;
	private double thueVAT;
	private double tongTien;

	public void setMaChiTietDonHang(String maChiTietDonHang) {
		this.maChiTietDonHang = maChiTietDonHang;
	}
	public String getMaChiTietDonHang() {
		return maChiTietDonHang;
	}
	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}
	public DonHang getDonHang() {
		return donHang;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSoLuong(double soLuong) {
		this.soLuong = soLuong;
	}
	public double getSoLuong() {
		return soLuong;
	}
	public void setGiaGoc(double giaGoc) {
		this.giaGoc = giaGoc;
	}
	public double getGiaGoc() {
		return giaGoc;
	}
	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}
	public double getGiamGia() {
		return giamGia;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setThueVAT(double thueVAT) {
		this.thueVAT = thueVAT;
	}
	public double getThueVAT() {
		return thueVAT;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public double getTongTien() {
		return tongTien;
	}
	
	public ChiTietDonHang() {
	}

	public ChiTietDonHang(String maChiTietDonHang, DonHang donHang, SanPham sanPham, double soLuong, double giaGoc,
			double giamGia, double giaBan, double thueVAT, double tongTien) {
		this.maChiTietDonHang = maChiTietDonHang;
		this.donHang = donHang;
		this.sanPham = sanPham;
		this.soLuong = soLuong;
		this.giaGoc = giaGoc;
		this.giamGia = giamGia;
		this.giaBan = giaBan;
		this.thueVAT = thueVAT;
		this.tongTien = tongTien;
	}

}

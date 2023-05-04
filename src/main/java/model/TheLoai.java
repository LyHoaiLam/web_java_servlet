package model;

public class TheLoai {
    private String maTheLoai;
	private String tenTheLoai;

	public void setMaTheLoai(String maTheLoai) {
		this.maTheLoai = maTheLoai;
	}
	public String getMaTheLoai() {
		return maTheLoai;
	}
	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}
	public String getTenTheLoai() {
		return tenTheLoai;
	}

	public TheLoai() {
	}

	public TheLoai(String maTheLoai, String tenTheLoai) {
		this.maTheLoai = maTheLoai;
		this.tenTheLoai = tenTheLoai;
	}

	
}

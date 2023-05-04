package model;
import java.sql.Date;
import java.util.Objects;
public class TacGia {
    private String 	maTacGia;
	private String 	hoVaTen;
	private Date	ngaySinh;
	private String	tieuSu;

	public void setMaTacGia(String maTacGia) {
		this.maTacGia = maTacGia;
	}
	public String getMaTacGia() {
		return maTacGia;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setTieuSu(String tieuSu) {
		this.tieuSu = tieuSu;
	}
	public String getTieuSu() {
		return tieuSu;
	}
	
	public TacGia() {
	}
	
	public TacGia(String maTacGia, String hoVaTen, Date ngaySinh, String tieuSu) {
		this.maTacGia = maTacGia;
		this.hoVaTen = hoVaTen;
		this.ngaySinh = ngaySinh;
		this.tieuSu = tieuSu;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TacGia other = (TacGia) obj;
		return Objects.equals(maTacGia, other.maTacGia);
	}

	@Override
	public String toString() {
		return "TacGia [maTacGia=" + maTacGia + ", hoVaTen=" + hoVaTen + ", ngaySinh=" + ngaySinh + ", tieuSu=" + tieuSu
				+ "]";
	}
}

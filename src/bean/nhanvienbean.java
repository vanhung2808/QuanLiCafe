package bean;

import java.util.Date;
public class nhanvienbean {
	private String MaNV;
	private String HoTen;
	private String GioiTinh;
	private Date NgaySinh;
	private String SDT;
	private String DiaChi;
	private Date NgayBDLV;
	private Long Luong;
	public nhanvienbean() {
		super();
	}
	public nhanvienbean( String maNV, String hoTen, String gioiTinh, Date ngaySinh, String sDT, String diaChi,
			Date ngayBDLV, Long luong) {
		super();

		MaNV = maNV;
		HoTen = hoTen;
		GioiTinh = gioiTinh;
		NgaySinh = ngaySinh;
		SDT = sDT;
		DiaChi = diaChi;
		NgayBDLV = ngayBDLV;
		Luong = luong;
	}

	public String getMaNV() {
		return MaNV;
	}
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public Date getNgayBDLV() {
		return NgayBDLV;
	}
	public void setNgayBDLV(Date ngayBDLV) {
		NgayBDLV = ngayBDLV;
	}
	public Long getLuong() {
		return Luong;
	}
	public void setLuong(Long luong) {
		Luong = luong;
	}
	
}

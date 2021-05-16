package bean;
import java.util.Date;

public class calamviecbean {
	private Date Ngay;
	private String MaNV;
	private String HoTen;
	private String Checkin;
	private String Checkout;
	private String GhiChu;
	public calamviecbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	public calamviecbean(Date ngay, String maNV, String hoTen, String checkin, String checkout, String ghiChu) {
		super();
		Ngay = ngay;
		MaNV = maNV;
		HoTen = hoTen;
		Checkin = checkin;
		Checkout = checkout;
		GhiChu = ghiChu;
	}

	public String getMaNV() {
		return MaNV;
	}


	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public Date getNgay() {
		return Ngay;
	}

	public void setNgay(Date ngay) {
		Ngay = ngay;
	}

	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getCheckin() {
		return Checkin;
	}
	public void setCheckin(String checkin) {
		Checkin = checkin;
	}
	public String getCheckout() {
		return Checkout;
	}
	public void setCheckout(String checkout) {
		Checkout = checkout;
	}
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	

}

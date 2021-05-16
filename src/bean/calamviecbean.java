package bean;

public class calamviecbean {
	private Integer STT;
	private String HoTen;
	private String Checkin;
	private String Checkout;
	private String GhiChu;
	public calamviecbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public calamviecbean(Integer sTT, String hoTen, String checkin, String checkout, String ghiChu) {
		super();
		STT = sTT;
		HoTen = hoTen;
		Checkin = checkin;
		Checkout = checkout;
		GhiChu = ghiChu;
	}
	public Integer getSTT() {
		return STT;
	}
	public void setSTT(Integer sTT) {
		STT = sTT;
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

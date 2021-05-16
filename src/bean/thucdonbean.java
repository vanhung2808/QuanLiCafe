package bean;

public class thucdonbean {
	private String TenMH;
	private Double GiamGia;
	private Integer Gia;
	public thucdonbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public thucdonbean(String tenMH, Integer gia, Double giamGia) {
		super();
		TenMH = tenMH;
		GiamGia = giamGia;
		Gia = gia;
	}
	public String getTenMH() {
		return TenMH;
	}
	public void setTenMH(String tenMH) {
		TenMH = tenMH;
	}
	public Double getGiamGia() {
		return GiamGia;
	}
	public void setGiamGia(Double giamGia) {
		GiamGia = giamGia;
	}
	public Integer getGia() {
		return Gia;
	}
	public void setGia(Integer gia) {
		Gia = gia;
	}
	
	
}

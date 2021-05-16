package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.calamviecbean;

public class calamviecdao {
	DungChung dc= new DungChung();
	public ArrayList<calamviecbean> getcalv() throws Exception{
		dc.KetNoi();
		ArrayList<calamviecbean> ds= new ArrayList<calamviecbean>();
		String sql= "select * from calamviec";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		ResultSet rs= cmd.executeQuery();
		while(rs.next()) {
			Date ngaylamviec = rs.getDate("Ngay");
			String manv = rs.getString("MaNV");
			String hoTen=rs.getString("TenNV");
			String checkin = rs.getString("GioCheckIn");
			String checkout = rs.getString("GioCheckOut");
			String ghichu = rs.getString("GhiChu");
			calamviecbean calv = new calamviecbean(ngaylamviec, manv,hoTen, checkin, checkout, ghichu);
			ds.add(calv);
		}
		rs.close();
		return ds;
	}
	
	
}

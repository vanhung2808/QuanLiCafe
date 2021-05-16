package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.nhanvienbean;

public class nhanviendao {
	DungChung dc= new DungChung();
	public ArrayList<nhanvienbean> getnv() throws Exception{
		dc.KetNoi();
		ArrayList<nhanvienbean> ds= new ArrayList<nhanvienbean>();
		String sql= "select * from nhanvien";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		ResultSet rs= cmd.executeQuery();
		while(rs.next()) {
			String manv=rs.getString("MaNV");
			String hoTen=rs.getString("HoTen");
			String gioiTinh=rs.getString("GioiTinh");
			Date ngaySinh=rs.getDate("NgaySinh");
			String sdt = rs.getString("SDT");
			String diachi = rs.getString("DiaChi");
			Date ngaylamviec = rs.getDate("NgayBDLV");
			Long luong=rs.getLong("Luong");
			nhanvienbean nv= new nhanvienbean( manv, hoTen, gioiTinh, ngaySinh, sdt, diachi, ngaylamviec, luong);
			ds.add(nv);
		}
		rs.close();
		return ds;
	}
	public int them(String manv, String hoTen, String gioiTinh, Date ngaySinh, String sdt, String diachi, Date ngaylamviec, Long luong) throws Exception{
		//tao cau lenh sql
		String sql="insert into NhanVien( MaNV, HoTen, GioiTinh, NgaySinh, SDT, DiaChi, NgayBDLV, Luong) values (?,?,?,?,?,?,?,?)";
		//tao ra Preparedstatement
		PreparedStatement cmd=DungChung.cn.prepareStatement(sql);
		//truyen tham so (neu co)
		cmd.setString(1, manv);
		cmd.setString(2, hoTen);
		cmd.setString(3, gioiTinh);
		//doi date util qua date sql
		cmd.setDate(4, new java.sql.Date(ngaySinh.getTime()));
		cmd.setString(5, sdt);
		cmd.setString(6, diachi);
		cmd.setDate(7, new java.sql.Date(ngaylamviec.getTime()));
		cmd.setLong(8, luong);
		//thuc hien cau lenh
		return cmd.executeUpdate();
	}
	public int sua(String manv, String hoTen, String gioiTinh, Date ngaySinh, String sdt, String diachi, Date ngaylamviec, Long luong) throws Exception{
		String sql="update NhanVien \r\n" + 
				"set MaNV =?, Hoten =?, GioiTinh =?, NgaySinh =?, SDT =? ,DiaChi =?, NgayBDLV = ?, Luong =? \r\n" + 
				"where MaNV=?";
		PreparedStatement cmd=DungChung.cn.prepareStatement(sql);
		cmd.setString(1, manv);
		cmd.setString(2, hoTen);
		cmd.setString(3, gioiTinh);
		//doi date util qua date sql
		cmd.setDate(4, new java.sql.Date(ngaySinh.getTime()));
		cmd.setString(5, sdt);
		cmd.setString(6, diachi);
		cmd.setDate(7, new java.sql.Date(ngaylamviec.getTime()));
		cmd.setLong(8, luong);
		cmd.setString(9, manv);
		return cmd.executeUpdate();
	}
	public int xoa(String manv) throws Exception{
		String sql="delete\r\n" + 
				"from NhanVien\r\n" + 
				"where MaNV=?";
		PreparedStatement cmd=DungChung.cn.prepareStatement(sql);
		cmd.setString(1, manv);
		return cmd.executeUpdate();
	}
	
	

}

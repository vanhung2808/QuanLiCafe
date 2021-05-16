package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.nhanvienbean;
import bean.thucdonbean;

public class thucdondao {
	DungChung dc= new DungChung();
	public ArrayList<thucdonbean> gettd() throws Exception{
		dc.KetNoi();
		ArrayList<thucdonbean> ds= new ArrayList<thucdonbean>();
		String sql= "select * from 	THUCDON";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		ResultSet rs= cmd.executeQuery();
		while(rs.next()) {
			String tenMh=rs.getString("TenMH");
			Integer gia = Integer.parseInt(rs.getString("Gia"));
			Double giamGia = Double.parseDouble(rs.getString("GiamGia"));
			thucdonbean td= new thucdonbean(tenMh, gia, giamGia);
			ds.add(td);
		}
		rs.close();
		return ds;
	}
	public int them(String tenMH, Integer gia, Double giamGia) throws Exception{
		//tao cau lenh sql
		String sql="insert into THUCDON( tenMH, gia, giamGia) values (?,?,?)";
		//tao ra Preparedstatement
		PreparedStatement cmd=DungChung.cn.prepareStatement(sql);
		//truyen tham so (neu co)
		cmd.setString(1, tenMH);
		cmd.setString(2, gia.toString());
		cmd.setString(3, giamGia.toString());
		//doi date util qua date sql
		
		return cmd.executeUpdate();
	}
	public int sua(String tenMH, Integer gia, Double giamGia) throws Exception{
		String sql="update THUCDON \r\n" + 
				"set tenMH =?, gia =?, GiamGia =? \r\n" + 
				"where tenMH=?";
		PreparedStatement cmd=DungChung.cn.prepareStatement(sql);
		cmd.setString(1, tenMH);
		cmd.setString(2, gia.toString());
		cmd.setString(3, giamGia.toString());
		cmd.setString(4, tenMH);
		return cmd.executeUpdate();
	}
	public int xoa(String tenMH) throws Exception{
		String sql="delete\r\n" + 
				"from THUCDON\r\n" + 
				"where tenMH=?";
		PreparedStatement cmd=DungChung.cn.prepareStatement(sql);
		cmd.setString(1, tenMH);
		return cmd.executeUpdate();
	}
}

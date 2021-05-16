package bo;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import bean.nhanvienbean;
import dao.DungChung;
import dao.nhanviendao;

public class nhanvienbo {
	nhanviendao nvdao= new nhanviendao();
	ArrayList<nhanvienbean> ds;
	public ArrayList<nhanvienbean> getnv() throws Exception{
		ds=nvdao.getnv();
		return ds;
	}
	
	public int them(String manv, String hoTen, String gioiTinh, Date ngaySinh, String sdt, String diachi, Date ngaylamviec, Long luong) throws Exception{
		//kiem tra trung ma
		for(nhanvienbean n:ds) {
			if(n.getMaNV().equals(manv)) return 0;
		}
		//them vao ds: bo nho
		nhanvienbean nv= new nhanvienbean(manv, hoTen, gioiTinh, ngaySinh, sdt, diachi, ngaylamviec, luong);
		ds.add(nv);
		//them vao csdl
		return nvdao.them( manv, hoTen, gioiTinh, ngaySinh, sdt, diachi, ngaylamviec, luong);
	}
	public int sua(String manv, String hoTen, String gioiTinh, Date ngaySinh, String sdt, String diachi, Date ngaylamviec, Long luong) throws Exception{
		return nvdao.sua(manv, hoTen, gioiTinh, ngaySinh, sdt, diachi, ngaylamviec, luong);
	}
	public int xoa(String manv) throws Exception{
		for(int i=0;i<ds.size();i++)
			if(ds.get(i).getMaNV().equals(manv))
				ds.remove(i);
		return nvdao.xoa(manv);
	}
	public DefaultTableModel napbang(String tb) throws Exception{
		DungChung dc= new DungChung();
		return dc.napbang(tb);
	}
}


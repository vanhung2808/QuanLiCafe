package bo;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import bean.thucdonbean;
import dao.DungChung;
import dao.thucdondao;;

public class thucdonbo {
	thucdondao nvdao= new thucdondao();
	ArrayList<thucdonbean> ds;
	public ArrayList<thucdonbean> gettd() throws Exception{
		ds=nvdao.gettd();
		return ds;
	}
	
	public int them(String tenMH, Integer gia, Double giamGia) throws Exception{
		//kiem tra trung ma
		for(thucdonbean n:ds) {
			if(n.getTenMH().equals(tenMH)) return 0;
		}
		//them vao ds: bo nho
		thucdonbean td= new thucdonbean(tenMH, gia, giamGia);
		ds.add(td);
		//them vao csdl
		return nvdao.them( tenMH, gia, giamGia);
	}
	public int sua(String tenMH, Integer gia, Double giamGia) throws Exception{
		return nvdao.sua(tenMH, gia, giamGia);
	}
	public int xoa(String tenMH) throws Exception{
		for(int i=0;i<ds.size();i++)
			if(ds.get(i).getTenMH().equals(tenMH))
				ds.remove(i);
		return nvdao.xoa(tenMH);
	}
	public DefaultTableModel napbang(String tb) throws Exception{
		DungChung dc= new DungChung();
		return dc.napbang(tb);
	}

}

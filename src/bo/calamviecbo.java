package bo;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import bean.calamviecbean;
import dao.DungChung;
import dao.calamviecdao;;

public class calamviecbo {
	calamviecdao nvdao= new calamviecdao();
	ArrayList<calamviecbean> ds;
	public ArrayList<calamviecbean> getclv() throws Exception{
		ds=nvdao.getcalv();
		return ds;
	}
	
	public DefaultTableModel napbang(String tb) throws Exception{
		DungChung dc= new DungChung();
		return dc.napbang(tb);
	}

}

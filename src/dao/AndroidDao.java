package dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbutil.SQLHelper;
import entity.Android;

public class AndroidDao {
	public int addzj(Android a) {
		String sql = "insert into android values(?,?,?,?)";
		return SQLHelper.executeUpdateByParams(sql, a.getId(),a.getName(),a.getHomework(),a.getVideo());
	}
	public int deletezjByid(String id){
		int r=0;
		String sql="delete from python where id='"+id+"'";
		r=SQLHelper.executeUpdate(sql);
		return r;
	}
	public List<Android> allzj(){
		List<Android> clist=new ArrayList<Android>();
		String sql="select * from android";
		ResultSet rs=SQLHelper.executeQuery(sql);
		try{
			while(rs.next()){
				Android a=new Android();
				a.setId(rs.getString(1));
				a.setName(rs.getString(2));
				a.setHomework(rs.getString(3));
				a.setVideo(rs.getString(4));
				clist.add(a);
			}
			SQLHelper.closeConnection();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return clist;
    }
	public Android queryzjById(String id) {
		Android a = null;
		String sql = "select * from android where id='" + id + "'";
		ResultSet rs = SQLHelper.executeQuery(sql);
		try {
			if (rs.next()) {
				a=new Android();
				a.setId(rs.getString(1));
				a.setName(rs.getString(2));
				a.setHomework(rs.getString(3));
				a.setVideo(rs.getString(4));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return a;
	}
	public Android queryzjByName(String name) {
		Android a=null;
		String sql = "select * from android where name='" + name + "'";
		ResultSet rs = SQLHelper.executeQuery(sql);
		try {
			if (rs.next()) {
				a=new Android();
				a.setId(rs.getString(1));
				a.setName(rs.getString(2));
				a.setHomework(rs.getString(3));
				a.setVideo(rs.getString(4));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return a;
	}
	
	public int updatezj(Android a) {
		String sql = "update android set name=? where id=?";
		return SQLHelper.executeUpdateByParams(sql,a.getName(),a.getId());
	}
	public int updatehomework(Android a,String h) {
		String sql = "update android set homework=? where id=?";
		return SQLHelper.executeUpdateByParams(sql,h,a.getId());
	}
	public int updatevideo(Android a,String v) {
		String sql = "update android set video=? where id=?";
		return SQLHelper.executeUpdateByParams(sql,v,a.getId());
	}
}
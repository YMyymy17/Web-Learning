package dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbutil.SQLHelper;
import entity.Python;

public class PythonDao {
	public int addzj(Python p) {
		String sql = "insert into python values(?,?,?,?)";
		return SQLHelper.executeUpdateByParams(sql, p.getId(),p.getName(),p.getHomework(),p.getVideo());
	}
	public int deletezjByid(String id){
		int r=0;
		String sql="delete from python where id='"+id+"'";
		r=SQLHelper.executeUpdate(sql);
		return r;
	}
	public List<Python> allzj(){
		List<Python> clist=new ArrayList<Python>();
		String sql="select * from python";
		ResultSet rs=SQLHelper.executeQuery(sql);
		try{
			while(rs.next()){
				Python p=new Python();
				p.setId(rs.getString(1));
				p.setName(rs.getString(2));
				p.setHomework(rs.getString(3));
				p.setVideo(rs.getString(4));
				clist.add(p);
			}
			SQLHelper.closeConnection();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return clist;
    }
	public Python queryzjById(String id) {
		Python p = null;
		String sql = "select * from python where id='" + id + "'";
		ResultSet rs = SQLHelper.executeQuery(sql);
		try {
			if (rs.next()) {
				p=new Python();
				p.setId(rs.getString(1));
				p.setName(rs.getString(2));
				p.setHomework(rs.getString(3));
				p.setVideo(rs.getString(4));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return p;
	}
	public Python queryzjByName(String name) {
		Python p=null;
		String sql = "select * from python where name='" + name + "'";
		ResultSet rs = SQLHelper.executeQuery(sql);
		try {
			if (rs.next()) {
				p=new Python();
				p.setId(rs.getString(1));
				p.setName(rs.getString(2));
				p.setHomework(rs.getString(3));
				p.setVideo(rs.getString(4));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return p;
	}
	
	public int updatezj(Python p) {
		String sql = "update python set name=? where id=?";
		return SQLHelper.executeUpdateByParams(sql,p.getName(),p.getId());
	}
	public int updatehomework(Python p,String h) {
		String sql = "update python set homework=? where id=?";
		return SQLHelper.executeUpdateByParams(sql,h,p.getId());
	}
	public int updatevideo(Python p,String v) {
		String sql = "update python set video=? where id=?";
		return SQLHelper.executeUpdateByParams(sql,v,p.getId());
	}
}
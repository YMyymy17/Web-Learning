package dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbutil.SQLHelper;
import entity.JavaEE;

public class JavaeeDao {
	public int addzj(JavaEE j) {
		String sql = "insert into javaee values(?,?,?,?)";
		return SQLHelper.executeUpdateByParams(sql, j.getId(),j.getName(),j.getHomework(),j.getVideo());
	}
	public int deletezjByid(String id){
		int r=0;
		String sql="delete from javaee where id='"+id+"'";
		r=SQLHelper.executeUpdate(sql);
		return r;
	}
	public List<JavaEE> allzj(){
		List<JavaEE> clist=new ArrayList<JavaEE>();
		String sql="select * from javaee";
		ResultSet rs=SQLHelper.executeQuery(sql);
		try{
			while(rs.next()){
				JavaEE j=new JavaEE();
				j.setId(rs.getString(1));
				j.setName(rs.getString(2));
				j.setHomework(rs.getString(3));
				j.setVideo(rs.getString(4));
				clist.add(j);
			}
			SQLHelper.closeConnection();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return clist;
    }
	public JavaEE queryzjById(String id) {
		JavaEE j = null;
		String sql = "select * from javaee where id='" + id + "'";
		ResultSet rs = SQLHelper.executeQuery(sql);
		try {
			if (rs.next()) {
				j=new JavaEE();
				j.setId(rs.getString(1));
				j.setName(rs.getString(2));
				j.setHomework(rs.getString(3));
				j.setVideo(rs.getString(4));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return j;
	}
	public JavaEE queryzjByName(String name) {
		JavaEE j=null;
		String sql = "select * from javaee where name='" + name + "'";
		ResultSet rs = SQLHelper.executeQuery(sql);
		try {
			if (rs.next()) {
				j=new JavaEE();
				j.setId(rs.getString(1));
				j.setName(rs.getString(2));
				j.setHomework(rs.getString(3));
				j.setVideo(rs.getString(4));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return j;
	}
	
	public int updatezj(JavaEE j) {
		String sql = "update javaee set name=? where id=?";
		return SQLHelper.executeUpdateByParams(sql,j.getName(),j.getId());
	}
	public int updatehomework(JavaEE j,String h) {
		String sql = "update javaee set homework=? where id=?";
		return SQLHelper.executeUpdateByParams(sql,h,j.getId());
	}
	public int updatevideo(JavaEE j,String v) {
		String sql = "update javaee set video=? where id=?";
		return SQLHelper.executeUpdateByParams(sql,v,j.getId());
	}
}
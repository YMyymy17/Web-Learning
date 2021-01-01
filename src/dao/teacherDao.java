package dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbutil.SQLHelper;
import entity.Teacher;

public class teacherDao {
	public int addTeacher(Teacher t) {
		String sql = "insert into teacher values(?,?,?,?,?)";
		return SQLHelper.executeUpdateByParams(sql, t.getTid(),t.getTname(),t.getTsex(),t.getClassid(),t.getTcheck_key());
	}
	public int deleteTeacherByCid(String id){
		int r=0;
		String sql="delete from teacher where tid='"+id+"'";
		r=SQLHelper.executeUpdate(sql);
		return r;
	}
	public List<Teacher> allTeacher(){
		List<Teacher> clist=new ArrayList<Teacher>();
		String sql="select * from teacher";
		ResultSet rs=SQLHelper.executeQuery(sql);
		try{
			while(rs.next()){
				Teacher t=new Teacher();
				t.setTid(rs.getInt(1));
				t.setTname(rs.getString(2));
				t.setTsex(rs.getString(3));
				t.setClassid(rs.getInt(4));
				t.setTcheck_key(rs.getString(5));
				clist.add(t);
			}
			SQLHelper.closeConnection();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return clist;
    }
	public Teacher queryTeacherById(String id) {
		Teacher t = null;
		String sql = "select * from teacher where tid='" + id + "'";
		ResultSet rs = SQLHelper.executeQuery(sql);
		try {
			if (rs.next()) {
				t=new Teacher();
				t.setTid(rs.getInt(1));
				t.setTname(rs.getString(2));
				t.setTsex(rs.getString(3));
				t.setClassid(rs.getInt(4));
				t.setTcheck_key(rs.getString(5));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return t;
	}
	public Teacher queryTeacherByName(String name) {
		Teacher t=null;
		String sql = "select * from Teacher where tname='" + name + "'";
		ResultSet rs = SQLHelper.executeQuery(sql);
		try {
			if (rs.next()) {
				t=new Teacher();
				t.setTid(rs.getInt(1));
				t.setTname(rs.getString(2));
				t.setTsex(rs.getString(3));
				t.setClassid(rs.getInt(4));
				t.setTcheck_key(rs.getString(5));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return t;
	}
	public int updateTeacher(Teacher t) {
		String sql = "update teacher set tname=?,tsex=?,classid=? where tId=?";
		return SQLHelper.executeUpdateByParams(sql,t.getTname(),t.getTsex(),t.getClassid(),t.getTid());
	}
	public int updatepwd(Teacher t) {
		String sql = "update teacher set tcheck_key=? where tId=?";
		return SQLHelper.executeUpdateByParams(sql,t.getTcheck_key(),t.getTid());
	}
}
package dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbutil.SQLHelper;
import entity.python_student_homework;

public class python_stuhomeworkDao {
	public int add(python_student_homework p) {
		String sql = "insert into python_student_homework values(?,?,?,?)";
		return SQLHelper.executeUpdateByParams(sql, p.getSid(),p.getZjid(),p.getHomework(),null);
	}
	public int deleteByid(String sid,String zjid){
		int r=0;
		String sql="delete from python_student_homework where sid='"+sid+"' and zjid='"+zjid+"'";
		r=SQLHelper.executeUpdate(sql);
		return r;
	}
	public List<python_student_homework> all(){
		List<python_student_homework> clist=new ArrayList<python_student_homework>();
		String sql="select * from python_student_homework";
		ResultSet rs=SQLHelper.executeQuery(sql);
		try{
			while(rs.next()){
				python_student_homework p=new python_student_homework();
				p.setSid(rs.getInt(1));
				p.setZjid(rs.getString(2));
				p.setHomework(rs.getString(3));
				p.setScore(rs.getInt(4));
				clist.add(p);
			}
			SQLHelper.closeConnection();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return clist;
    }
	public python_student_homework queryById(String sid,String zjid) {
		python_student_homework p= null;
		String sql = "select * from python_student_homework where sid='" + sid + "' and zjid='"+zjid+"'";
		ResultSet rs = SQLHelper.executeQuery(sql);
		try {
			if (rs.next()) {
				p=new python_student_homework();
				p.setSid(rs.getInt(1));
				p.setZjid(rs.getString(2));
				p.setHomework(rs.getString(3));
				p.setScore(rs.getInt(4));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return p;
	}
	
	public int updatescore(python_student_homework p) {
		String sql = "update python_student_homework set score=? where sid=? and zjid=?";
		return SQLHelper.executeUpdateByParams(sql,p.getScore(),p.getSid(),p.getZjid());
	}
	public int updatehomework(python_student_homework p,String h) {
		String sql = "update python_student_homework set homework=? where sid=? and zjid=?";
		return SQLHelper.executeUpdateByParams(sql,h,p.getSid(),p.getZjid());
	}
}
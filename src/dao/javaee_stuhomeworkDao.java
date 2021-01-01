package dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbutil.SQLHelper;
import entity.JavaEE;
import entity.javaee_student_homework;

public class javaee_stuhomeworkDao {
	public int add(javaee_student_homework j) {
		String sql = "insert into javaee_student_homework values(?,?,?,?)";
		return SQLHelper.executeUpdateByParams(sql, j.getSid(),j.getZjid(),j.getHomework(),null);
	}
	public int deleteByid(String sid,String zjid){
		int r=0;
		String sql="delete from javaee_student_homework where sid='"+sid+"' and zjid='"+zjid+"'";
		r=SQLHelper.executeUpdate(sql);
		return r;
	}
	public List<javaee_student_homework> all(){
		List<javaee_student_homework> clist=new ArrayList<javaee_student_homework>();
		String sql="select * from javaee_student_homework";
		ResultSet rs=SQLHelper.executeQuery(sql);
		try{
			while(rs.next()){
				javaee_student_homework j=new javaee_student_homework();
				j.setSid(rs.getInt(1));
				j.setZjid(rs.getString(2));
				j.setHomework(rs.getString(3));
				j.setScore(rs.getInt(4));
				clist.add(j);
			}
			SQLHelper.closeConnection();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return clist;
    }
	public javaee_student_homework queryById(String sid,String zjid) {
		javaee_student_homework j= null;
		String sql = "select * from javaee_student_homework where sid='" + sid + "' and zjid='"+zjid+"'";
		ResultSet rs = SQLHelper.executeQuery(sql);
		try {
			if (rs.next()) {
				j=new javaee_student_homework();
				j.setSid(rs.getInt(1));
				j.setZjid(rs.getString(2));
				j.setHomework(rs.getString(3));
				j.setScore(rs.getInt(4));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return j;
	}
	
	public int updatescore(javaee_student_homework j) {
		String sql = "update javaee_student_homework set score=? where sid=? and zjid=?";
		return SQLHelper.executeUpdateByParams(sql,j.getScore(),j.getSid(),j.getZjid());
	}
	public int updatehomework(javaee_student_homework j,String h) {
		String sql = "update javaee_student_homework set homework=? where sid=? and zjid=?";
		return SQLHelper.executeUpdateByParams(sql,h,j.getSid(),j.getZjid());
	}
}
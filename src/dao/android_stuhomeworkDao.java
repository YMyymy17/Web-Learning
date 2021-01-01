package dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbutil.SQLHelper;
import entity.android_student_homework;

public class android_stuhomeworkDao {
	public int add(android_student_homework a) {
		String sql = "insert into android_student_homework values(?,?,?,?)";
		return SQLHelper.executeUpdateByParams(sql, a.getSid(),a.getZjid(),a.getHomework(),null);
	}
	public int deleteByid(String sid,String zjid){
		int r=0;
		String sql="delete from android_student_homework where sid='"+sid+"' and zjid='"+zjid+"'";
		r=SQLHelper.executeUpdate(sql);
		return r;
	}
	public List<android_student_homework> all(){
		List<android_student_homework> clist=new ArrayList<android_student_homework>();
		String sql="select * from android_student_homework";
		ResultSet rs=SQLHelper.executeQuery(sql);
		try{
			while(rs.next()){
				android_student_homework a=new android_student_homework();
				a.setSid(rs.getInt(1));
				a.setZjid(rs.getString(2));
				a.setHomework(rs.getString(3));
				a.setScore(rs.getInt(4));
				clist.add(a);
			}
			SQLHelper.closeConnection();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return clist;
    }
	public android_student_homework queryById(String sid,String zjid) {
		android_student_homework a= null;
		String sql = "select * from android_student_homework where sid='" + sid + "' and zjid='"+zjid+"'";
		ResultSet rs = SQLHelper.executeQuery(sql);
		try {
			if (rs.next()) {
				a=new android_student_homework();
				a.setSid(rs.getInt(1));
				a.setZjid(rs.getString(2));
				a.setHomework(rs.getString(3));
				a.setScore(rs.getInt(4));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return a;
	}
	
	public int updatescore(android_student_homework a_score) {
		String sql = "update android_student_homework set score=? where sid=? and zjid=?";
		return SQLHelper.executeUpdateByParams(sql,a_score.getScore(),a_score.getSid(),a_score.getZjid());
	}
	public int updatehomework(android_student_homework a,String h) {
		String sql = "update android_student_homework set homework=? where sid=? and zjid=?";
		return SQLHelper.executeUpdateByParams(sql,h,a.getSid(),a.getZjid());
	}
}
package dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbutil.SQLHelper;
import entity.Course;

public class courseDao {
	public int addCourse(Course c) {
		String sql = "insert into course values(?,?,?,?)";
		return SQLHelper.executeUpdateByParams(sql, c.getCid(),c.getCname(),c.getClassid(),c.getCid());
	}
	public int deleteCourseByCid(String id){
		int r=0;
		String sql="delete from course where cid='"+id+"'";
		r=SQLHelper.executeUpdate(sql);
		return r;
	}
	public List<Course> allCourse(){
		List<Course> clist=new ArrayList<Course>();
		String sql="select * from course";
		ResultSet rs=SQLHelper.executeQuery(sql);
		try{
			while(rs.next()){
				Course c=new Course();
				c.setCid(rs.getInt(1));
				c.setCname(rs.getString(2));
				c.setClassid(rs.getInt(3));
				c.setTid(rs.getInt(4));
				clist.add(c);
			}
			SQLHelper.closeConnection();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return clist;
    }
	public Course queryCourseById(String id) {
		Course c = null;
		String sql = "select * from course where cid='" + id + "'";
		ResultSet rs = SQLHelper.executeQuery(sql);
		try {
			if (rs.next()) {
				c=new Course();
				c.setCid(rs.getInt(1));
				c.setCname(rs.getString(2));
				c.setClassid(rs.getInt(3));
				c.setTid(rs.getInt(4));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return c;
	}
	public Course queryCourseByName(String name) {
		Course c=null;
		String sql = "select * from course where cname='" + name + "'";
		ResultSet rs = SQLHelper.executeQuery(sql);
		try {
			if (rs.next()) {
				c=new Course();
				c.setCid(rs.getInt(1));
				c.setCname(rs.getString(2));
				c.setClassid(rs.getInt(3));
				c.setTid(rs.getInt(4));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return c;
	}
	public List<Course> queryCourseByTid(String tid){
		List<Course> clist=new ArrayList<Course>();
		String sql="select * from course where tid=' " + tid + " '";
		ResultSet rs=SQLHelper.executeQuery(sql);
		try{
			while(rs.next()){
				Course c=new Course();
				c.setCid(rs.getInt(1));
				c.setCname(rs.getString(2));
				c.setClassid(rs.getInt(3));
				c.setTid(rs.getInt(4));
				clist.add(c);
			}
			SQLHelper.closeConnection();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return clist;
    }
	public List<Course> queryCourseByClassid( int classid){
		List<Course> clist=new ArrayList<Course>();
		String sql="select * from course where classid=' "+ classid + " '";
		ResultSet rs=SQLHelper.executeQuery(sql);
		try{
			while(rs.next()){
				Course c=new Course();
				c.setCid(rs.getInt(1));
				c.setCname(rs.getString(2));
				c.setClassid(rs.getInt(3));
				c.setTid(rs.getInt(4));
				clist.add(c);
			}
			SQLHelper.closeConnection();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return clist;
    }
	public int updateCourse(Course c) {
		String sql = "update course set cname=?,classid=? where cid=?";
		return SQLHelper.executeUpdateByParams(sql,c.getCname(),c.getClassid(),c.getCid());
	}
}
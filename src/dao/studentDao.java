package dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbutil.SQLHelper;
import entity.Student;
import entity.Teacher;

public class studentDao {
	public int addStudent(Student s) {
		String sql = "insert into student values(?,?,?,?,?)";
		return SQLHelper.executeUpdateByParams(sql, s.getSid(),s.getSname(),s.getSsex(),s.getClassid(),s.getScheck_key());
	}
	public int deleteStudentByCid(String id){
		int r=0;
		String sql="delete from student where sid='"+id+"'";
		r=SQLHelper.executeUpdate(sql);
		return r;
	}
	public List<Student> allStudent(){
		List<Student> clist=new ArrayList<Student>();
		String sql="select * from student";
		ResultSet rs=SQLHelper.executeQuery(sql);
		try{
			while(rs.next()){
				Student s=new Student();
				s.setSid(rs.getInt(1));
				s.setSname(rs.getString(2));
				s.setSsex(rs.getString(3));
				s.setClassid(rs.getInt(4));
				s.setScheck_key(rs.getString(5));
				clist.add(s);
			}
			SQLHelper.closeConnection();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return clist;
    }
	public Student queryStudentById(String id) {
		Student s = null;
		String sql = "select * from student where sid='" + id + "'";
		ResultSet rs = SQLHelper.executeQuery(sql);
		try {
			if (rs.next()) {
				s=new Student();
				s.setSid(rs.getInt(1));
				s.setSname(rs.getString(2));
				s.setSsex(rs.getString(3));
				s.setClassid(rs.getInt(4));
				s.setScheck_key(rs.getString(5));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return s;
	}
	public Student queryStudentByName(String name) {
		Student s=null;
		String sql = "select * from student where sname='" + name + "'";
		ResultSet rs = SQLHelper.executeQuery(sql);
		try {
			if (rs.next()) {
				s=new Student();
				s.setSid(rs.getInt(1));
				s.setSname(rs.getString(2));
				s.setSsex(rs.getString(3));
				s.setClassid(rs.getInt(4));
				s.setScheck_key(rs.getString(5));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return s;
	}
	public List<Student> queryStudentByClassid(String classid){
		List<Student> clist=new ArrayList<Student>();
		String sql="select * from student where classid=' "+ classid + " '";
		ResultSet rs=SQLHelper.executeQuery(sql);
		try{
			while(rs.next()){
				Student s=new Student();
				s.setSid(rs.getInt(1));
				s.setSname(rs.getString(2));
				s.setSsex(rs.getString(3));
				s.setClassid(rs.getInt(4));
				s.setScheck_key(rs.getString(5));
				clist.add(s);
			}
			SQLHelper.closeConnection();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return clist;
    }
	public int updateStudent(Student s) {
		String sql = "update student set sname=?,ssex=?,classid=? where sid=?";
		return SQLHelper.executeUpdateByParams(sql,s.getSname(),s.getSsex(),s.getClassid(),s.getSid());
	}
	public int updatepwd(Student s) {
		String sql = "update student set scheck_key=? where sId=?";
		return SQLHelper.executeUpdateByParams(sql,s.getScheck_key(),s.getSid());
	}
}
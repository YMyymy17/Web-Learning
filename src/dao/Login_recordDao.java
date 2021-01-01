package dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbutil.SQLHelper;

import entity.login_record;
public class Login_recordDao {
	public int addrecordf(String name,String date) {
		String sql = "insert into login_record(USER_NAME,LOGIN_TIME,IS_LOGINSUCCESS) values(?,?,?)";
		return SQLHelper.executeUpdateByParams(sql,name,date,"0");
	}
	
	public int addrecords(String name,String date) {
		String sql = "insert into login_record(USER_NAME,LOGIN_TIME,IS_LOGINSUCCESS) values(?,?,?)";
		return SQLHelper.executeUpdateByParams(sql,name,date,"1");
	}
	
	public login_record queryrecordById(String id) {
		login_record lr = null;
		String sql = "select * from login_record where ID='" + id + "'";
		ResultSet rs = SQLHelper.executeQuery(sql);
		try {
			if (rs.next()) {
				lr=new login_record();
				lr.setID(rs.getInt(1));
				lr.setUSER_NAME(rs.getString(2));
				lr.setLOGIN_TIME(rs.getString(3));
				lr.setIS_LOGINSUCCESS(rs.getInt(4));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lr;
	}
	
	public List<login_record> queryrecords() throws Exception {
		List<login_record> clist = new ArrayList<login_record>();
		String sql = "select * from login_record";
		ResultSet rs = SQLHelper.executeQuery(sql);
		while(rs.next()) {
			login_record lr=new login_record();
			lr.setID(rs.getInt(1));
			lr.setUSER_NAME(rs.getString(2));
			lr.setLOGIN_TIME(rs.getString(3));
			lr.setIS_LOGINSUCCESS(rs.getInt(4));
			clist.add(lr);
		}
		return clist;
	}
	
	public int deletelogin_recordById(String id) {
		String sql = "delete from login_record where ID=?";
		return SQLHelper.executeUpdateByParams(sql,id);
	}
}
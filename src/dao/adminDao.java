package dao;
import java.sql.ResultSet;
import dbutil.SQLHelper;
import entity.Admin;
import entity.Teacher;

public class adminDao {
	public Admin queryAdminById(String id) {
		Admin a = null;
		String sql = "select * from admin where aid='" + id + "'";
		ResultSet rs = SQLHelper.executeQuery(sql);
		try {
			if (rs.next()) {
				a=new Admin();
				a.setAid(rs.getInt(1));
				a.setAcheck_key(rs.getString(2));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return a;
	}
	public int updatepwd(Admin a) {
		String sql = "update admin set acheck_key=? where aid=?";
		return SQLHelper.executeUpdateByParams(sql,a.getAcheck_key(),a.getAid());
	}
}

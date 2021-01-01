package dbutil;

import java.sql.*;

public class SQLHelper {
	private  static  String driver="com.mysql.jdbc.Driver";
	private  static  String url="jdbc:mysql://localhost:3306/web_learning",user="root",pwd="1234";
	private static Connection conn=null;
	static{
		try{
			Class.forName(driver);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void  closeConnection(){
		try{
			if(conn!=null && !conn.isClosed() ){
				conn.close();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static int executeUpdateByParams(String sql,Object...params){
		int r=0;
		try{
			Connection conn=DriverManager.getConnection(url,user,pwd);
			PreparedStatement pcmd=conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				if (params[i] instanceof String)
					pcmd.setString(i+1, params[i].toString() );
				else if(params[i] instanceof Integer)
					pcmd.setInt(i+1, new Integer(params[i].toString()));
				else if(params[i] instanceof Double)
					pcmd.setDouble(i+1, new Double(params[i].toString()));
				else
					pcmd.setObject(i+1,params[i]);
			}
	        r=pcmd.executeUpdate();
	        conn.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return r;
	}
	public static int executeUpdate(String sql){
		int r=0;
		try{
			Connection conn=DriverManager.getConnection(url,user,pwd);
	        Statement cmd=conn.createStatement();
	        r=cmd.executeUpdate(sql);
	        conn.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return r;
	}
	public static ResultSet executeQuery(String sql){
		ResultSet rs=null;
		try{
		    conn=DriverManager.getConnection(url,user,pwd);
	        Statement cmd=conn.createStatement();
	        rs=cmd.executeQuery(sql);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return rs;
	}
}
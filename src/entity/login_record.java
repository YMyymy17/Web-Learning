package entity;

public class login_record {
	private int ID;
	private String USER_NAME,LOGIN_TIME;
	private int IS_LOGINSUCCESS;
	public login_record(int iD, String uSER_NAME, String lOGIN_TIME, int iS_LOGINSUCCESS) {
		super();
		ID = iD;
		USER_NAME = uSER_NAME;
		LOGIN_TIME = lOGIN_TIME;
		IS_LOGINSUCCESS = iS_LOGINSUCCESS;
	}
	public login_record() {
		// TODO Auto-generated constructor stub
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getLOGIN_TIME() {
		return LOGIN_TIME;
	}
	public void setLOGIN_TIME(String lOGIN_TIME) {
		LOGIN_TIME = lOGIN_TIME;
	}
	public int getIS_LOGINSUCCESS() {
		return IS_LOGINSUCCESS;
	}
	public void setIS_LOGINSUCCESS(int iS_LOGINSUCCESS) {
		IS_LOGINSUCCESS = iS_LOGINSUCCESS;
	}
}
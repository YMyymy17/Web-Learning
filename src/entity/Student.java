package entity;

public class Student {
	private int sid;
	private String sname,ssex;
	private int classid;
	private String scheck_key;
	public Student(int sid, String sname, String ssex, int classid, String scheck_key) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.ssex = ssex;
		this.classid = classid;
		this.scheck_key = scheck_key;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getScheck_key() {
		return scheck_key;
	}
	public void setScheck_key(String scheck_key) {
		this.scheck_key = scheck_key;
	}
}
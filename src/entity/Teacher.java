package entity;

public class Teacher {
	private int tid;
	private String tname,tsex;
	private int classid;
	private String tcheck_key;
	
	public Teacher(int tid, String tname, String tsex, int classid, String tcheck_key) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.tsex = tsex;
		this.classid = classid;
		this.tcheck_key = tcheck_key;
	}
	
	public Teacher() {
		// TODO Auto-generated constructor stub
	}

	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTsex() {
		return tsex;
	}
	public void setTsex(String tsex) {
		this.tsex = tsex;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getTcheck_key() {
		return tcheck_key;
	}
	public void setTcheck_key(String tcheck_key) {
		this.tcheck_key = tcheck_key;
	}
}
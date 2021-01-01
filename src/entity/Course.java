package entity;

public class Course {
	private int cid;
	private String cname;
	private int classid,tid;
	public Course(int cid, String cname, int classid, int tid) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.classid = classid;
		this.tid = tid;
	}
	public Course() {
		// TODO Auto-generated constructor stub
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	
}

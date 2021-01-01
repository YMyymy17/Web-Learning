package entity;

public class python_student_homework {
	private int sid;
	private String zjid,homework;
	private int score;
	public python_student_homework(int sid, String zjid, String homework, int score) {
		super();
		this.sid = sid;
		this.zjid = zjid;
		this.homework = homework;
		this.score = score;
	}
	public python_student_homework() {
		// TODO Auto-generated constructor stub
	}
	public python_student_homework(int sid2, String zjid2, String path1, Object object) {
		this.sid = sid2;
		this.zjid = zjid2;
		this.homework = path1;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getZjid() {
		return zjid;
	}
	public void setZjid(String zjid) {
		this.zjid = zjid;
	}
	public String getHomework() {
		return homework;
	}
	public void setHomework(String homework) {
		this.homework = homework;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
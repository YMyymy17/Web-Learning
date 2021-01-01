package entity;

public class Admin {
	private int aid;
	private String acheck_key;

	public Admin(int aid, String acheck_key) {
		super();
		this.aid = aid;
		this.acheck_key = acheck_key;
	}
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAcheck_key() {
		return acheck_key;
	}

	public void setAcheck_key(String acheck_key) {
		this.acheck_key = acheck_key;
	}
}
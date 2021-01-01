package entity;

public class User {
	public String id,upwd,uyzm,role;

	public User(String id, String upwd, String uyzm, String role) {
		super();
		this.id = id;
		this.upwd = upwd;
		this.uyzm = uyzm;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getUyzm() {
		return uyzm;
	}

	public void setUyzm(String uyzm) {
		this.uyzm = uyzm;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
